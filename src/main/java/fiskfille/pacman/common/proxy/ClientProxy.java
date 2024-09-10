package fiskfille.pacman.common.proxy;

import cpw.mods.fml.relauncher.*;
import cpw.mods.fml.common.event.*;
import fiskfille.pacman.common.entity.*;
import fiskfille.pacman.client.render.entity.*;
import cpw.mods.fml.client.registry.*;
import net.minecraft.client.renderer.entity.*;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(final FMLPreInitializationEvent event) {
        super.preInit(event);
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityPacman.class, (Render)new RenderPacman());
    }
}
