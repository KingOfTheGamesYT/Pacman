package fiskfille.pacman.common.entity;

import net.minecraft.world.biome.*;
import net.minecraft.entity.*;
import cpw.mods.fml.common.registry.*;

public class PacmanEntities
{
    public static void load() {
        EntityHelper.registerEntity("Pacman", (Class)EntityPacman.class, 16776960, 0);
        for (final BiomeGenBase biome : BiomeGenBase.getBiomeGenArray()) {
            if (biome != null) {
                final int probability = 2;
                EntityRegistry.addSpawn((Class)EntityPacman.class, probability, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] { biome });
            }
        }
    }
}
