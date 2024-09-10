package fiskfille.pacman.common.entity;

import java.lang.reflect.*;
import cpw.mods.fml.common.registry.*;
import fiskfille.pacman.*;
import net.minecraft.world.biome.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.*;
import com.google.common.collect.*;

public class EntityHelper
{
    static int startEntityId;
    private static Field classToIDMappingField;
    private static Field stringToIDMappingField;
    private static List<Class<? extends Entity>> removedEntities;
    
    public static boolean hasEntityBeenRemoved(final Class<? extends Entity> entity) {
        return EntityHelper.removedEntities.contains(entity);
    }
    
    public static void registerEntity(final String entityName, final Class<? extends Entity> entityClass) {
        final int id = getUniqueEntityId();
        EntityRegistry.registerGlobalEntityID((Class)entityClass, entityName, id);
        EntityRegistry.registerModEntity((Class)entityClass, entityName, id, (Object)MainClass.instance, 64, 1, true);
    }
    
    public static void registerEntity(final String entityName, final Class<? extends Entity> entityClass, final int primaryColor, final int secondaryColor) {
        final int id = getUniqueEntityId();
        EntityRegistry.registerGlobalEntityID((Class)entityClass, entityName, id);
        EntityRegistry.registerModEntity((Class)entityClass, entityName, id, (Object)MainClass.instance, 64, 1, true);
        EntityList.idToClassMap.put(id, entityClass);
        EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
    }
    
    public static void removeLivingEntity(final Class<? extends EntityLiving> clazz) {
        removeEntity((Class<? extends Entity>)clazz);
        removeEntityEgg(clazz);
        for (final BiomeGenBase biome : BiomeGenBase.getBiomeGenArray()) {
            if (biome != null) {
                EntityRegistry.removeSpawn((Class)clazz, EnumCreatureType.ambient, new BiomeGenBase[] { biome });
                EntityRegistry.removeSpawn((Class)clazz, EnumCreatureType.creature, new BiomeGenBase[] { biome });
                EntityRegistry.removeSpawn((Class)clazz, EnumCreatureType.monster, new BiomeGenBase[] { biome });
                EntityRegistry.removeSpawn((Class)clazz, EnumCreatureType.waterCreature, new BiomeGenBase[] { biome });
            }
        }
    }
    
    public static void removeEntity(final Class<? extends Entity> clazz) {
        EntityHelper.removedEntities.add(clazz);
        EntityList.idToClassMap.remove(clazz);
        final Object name = EntityList.classToStringMapping.get(clazz);
        EntityList.stringToClassMapping.remove(name);
        EntityList.classToStringMapping.remove(clazz);
        try {
            final Map classToIDMapping = (Map)EntityHelper.classToIDMappingField.get(null);
            final Map stringToIDMapping = (Map)EntityHelper.stringToIDMappingField.get(null);
            classToIDMapping.remove(clazz);
            stringToIDMapping.remove(name);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }
    
    public static void removeEntityEgg(final Class<? extends EntityLiving> clazz) {
        Integer toRemove = null;
        for (final Object key : EntityList.entityEggs.keySet()) {
            final Integer intKey = (Integer)key;
            final Class<? extends Entity> entityClass = (Class<? extends Entity>)EntityList.getClassFromID((int)intKey);
            if (clazz.equals(entityClass)) {
                toRemove = intKey;
                break;
            }
        }
        if (toRemove != null) {
            EntityList.entityEggs.remove(toRemove);
        }
    }
    
    private static int getUniqueEntityId() {
        do {
            ++EntityHelper.startEntityId;
        } while (EntityList.getStringFromID(EntityHelper.startEntityId) != null);
        return EntityHelper.startEntityId;
    }
    
    public static Entity getEntityFromClass(final Class entityClass, final World world) {
        Entity entity = null;
        try {
            entity = entityClass.getConstructor(World.class).newInstance(world);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
    
    static {
        EntityHelper.startEntityId = 0;
        EntityHelper.removedEntities = (List<Class<? extends Entity>>)Lists.newArrayList();
        int i = 0;
        for (final Field field : EntityList.class.getDeclaredFields()) {
            if (field.getType() == Map.class) {
                if (i == 3) {
                    field.setAccessible(true);
                    EntityHelper.classToIDMappingField = field;
                }
                else if (i == 4) {
                    field.setAccessible(true);
                    EntityHelper.stringToIDMappingField = field;
                    break;
                }
                ++i;
            }
        }
    }
}
