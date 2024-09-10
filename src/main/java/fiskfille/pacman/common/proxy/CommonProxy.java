package fiskfille.pacman.common.proxy;

import cpw.mods.fml.common.event.*;
import net.minecraftforge.common.config.*;
import fiskfille.pacman.common.config.*;
import fiskfille.pacman.common.item.*;
import fiskfille.pacman.common.entity.*;
import cpw.mods.fml.common.*;
import fiskfille.pacman.*;
import net.minecraftforge.common.*;

public class CommonProxy
{
    public static PacmanAwayBlock pacmanAwayBlock;
    
    public void preInit(final FMLPreInitializationEvent event) {
        final Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        PacmanConfig.load(config);
        config.save();
        ItemDropHelper.initItemList();
        PacmanItems.load();
        PacmanEntities.load();
        FMLCommonHandler.instance().bus().register((Object)new WeaponScaler());
        MinecraftForge.EVENT_BUS.register((Object)new WeaponScaler());
    }
}
