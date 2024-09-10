//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\minec\Desktop\mappings\mcp_stable-12-1.7.10"!

//Decompiled by Procyon!

package fiskfille.pacman.client.render.entity;

import net.minecraft.client.renderer.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import fiskfille.pacman.client.model.entity.*;
import net.minecraft.client.model.*;
import fiskfille.pacman.common.entity.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;

@SideOnly(Side.CLIENT)
public class RenderPacman extends RenderBiped
{
    private ResourceLocation texture;
    private ResourceLocation textureSaddle;
    
    public RenderPacman() {
        super((ModelBiped)new ModelPacman(), 0.5f);
        this.texture = new ResourceLocation("pacman", "textures/entity/pacman.png");
        this.textureSaddle = new ResourceLocation("pacman", "textures/entity/pacman_saddle.png");
        this.setRenderPassModel((ModelBase)new ModelPacman());
    }
    
    protected int shouldRenderPass(final EntityPacman entity, final int p_77032_2_, final float p_77032_3_) {
        if (p_77032_2_ == 0 && entity.getSaddled()) {
            this.bindTexture(this.textureSaddle);
            return 1;
        }
        return -1;
    }
    
    protected int shouldRenderPass(final EntityLivingBase p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        return this.shouldRenderPass((EntityPacman)p_77032_1_, p_77032_2_, p_77032_3_);
    }
    
    protected void preRenderCallback(final EntityLivingBase entity, final float partialTicks) {
        this.preRenderCallback((EntityPacman)entity, partialTicks);
    }
    
    protected void preRenderCallback(final EntityPacman entity, final float partialTicks) {
        final float f = -(float)entity.scale / 3.0f;
        GL11.glTranslatef(0.0f, 0.925f, 0.0f);
        GL11.glTranslatef(0.0f, f, 0.0f);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return this.texture;
    }
}
