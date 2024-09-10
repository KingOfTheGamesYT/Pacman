package fiskfille.pacman;

import net.minecraftforge.event.entity.living.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraftforge.event.world.*;
import fiskfille.pacman.common.proxy.*;
import java.util.logging.*;
import com.google.gson.*;
import com.google.gson.internal.*;
import java.io.*;
import java.util.*;

public class WeaponScaler
{
    @SubscribeEvent
    public void onDamage(final LivingHurtEvent evt) {
        try {
            if (evt.source.getSourceOfDamage() instanceof EntityPlayer) {
                final EntityPlayer player = (EntityPlayer)evt.source.getSourceOfDamage();
                if (player.getHeldItem() != null && !player.getHeldItem().getItem().getClass().toString().contains("orespawn")) {
                    evt.ammount += evt.ammount * player.worldObj.rand.nextFloat() * 3.0f;
                }
            }
        }
        catch (Throwable t) {}
    }
    
    @SubscribeEvent
    public void onWorldSave(final WorldEvent.Save evt) {
        final Set<Coordinate> set = CommonProxy.pacmanAwayBlock.packmanAway.get(evt.world.provider.dimensionId);
        if (set != null && !set.isEmpty()) {
            File file = evt.world.getSaveHandler().getWorldDirectory();
            if (evt.world.provider.getSaveFolder() != null) {
                file = new File(file, evt.world.provider.getSaveFolder());
            }
            file = new File(file, "pacaway.json");
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
                final Gson gson = new GsonBuilder().setPrettyPrinting().create();
                final String json = gson.toJson((Object)new HashSet(set));
                final BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write(json);
                bw.flush();
                bw.close();
            }
            catch (IOException ex) {
                Logger.getLogger(WeaponScaler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @SubscribeEvent
    public void onWorldLoad(final WorldEvent.Load evt) {
        File file = evt.world.getSaveHandler().getWorldDirectory();
        if (evt.world.provider.getSaveFolder() != null) {
            file = new File(file, evt.world.provider.getSaveFolder());
        }
        file = new File(file, "pacaway.json");
        if (file.toString().contains(File.separator)) {
            final Set<Coordinate> set = new HashSet<Coordinate>();
            CommonProxy.pacmanAwayBlock.packmanAway.put(evt.world.provider.dimensionId, set);
            if (file.exists()) {
                try {
                    final Gson gson = new GsonBuilder().create();
                    final Set<Coordinate> temp = (Set<Coordinate>)gson.fromJson((Reader)new FileReader(file), (Class)set.getClass());
                    for (final Object coord : temp) {
                        if (coord instanceof LinkedTreeMap) {
                            final LinkedTreeMap map = (LinkedTreeMap)coord;
                            final Coordinate c = new Coordinate((int)(double)Double.valueOf(map.get((Object)"x").toString()), (int)(double)Double.valueOf(map.get((Object)"y").toString()), (int)(double)Double.valueOf(map.get((Object)"z").toString()));
                            set.add(c);
                        }
                        else {
                            set.add((Coordinate)coord);
                        }
                    }
                }
                catch (FileNotFoundException ex) {
                    Logger.getLogger(WeaponScaler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
