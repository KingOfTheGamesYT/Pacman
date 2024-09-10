package fiskfille.pacman;

import fiskfille.pacman.common.proxy.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;

@Mod(modid = "pacman", name = "Pacman")
public class MainClass
{
    public static final String modid = "pacman";
    @Mod.Instance("pacman")
    public static MainClass instance;
    @SidedProxy(clientSide = "fiskfille.pacman.common.proxy.ClientProxy", serverSide = "fiskfille.pacman.common.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        MainClass.proxy.preInit(event);
    }
}
