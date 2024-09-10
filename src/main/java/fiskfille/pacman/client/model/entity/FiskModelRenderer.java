//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\minec\Desktop\mappings\mcp_stable-12-1.7.10"!

//Decompiled by Procyon!

package fiskfille.pacman.client.model.entity;

import java.util.*;
import org.lwjgl.opengl.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;

public class FiskModelRenderer extends ModelRenderer
{
    private boolean compiled;
    private int displayList;
    private ModelBase baseModel;
    public float scaleX;
    public float scaleY;
    public float scaleZ;
    public float scaleOffset;
    public float initRotateAngleX;
    public float initRotateAngleY;
    public float initRotateAngleZ;
    public float initRotationPointX;
    public float initRotationPointY;
    public float initRotationPointZ;
    
    public FiskModelRenderer(final ModelBase modelBase, final String string) {
        super(modelBase, string);
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.scaleZ = 1.0f;
        this.scaleOffset = 0.0625f;
        this.textureWidth = 64.0f;
        this.textureHeight = 32.0f;
        this.showModel = true;
        this.cubeList = new ArrayList();
        this.baseModel = modelBase;
        modelBase.boxList.add(this);
        this.setTextureSize(modelBase.textureWidth, modelBase.textureHeight);
    }
    
    public FiskModelRenderer(final ModelBase modelBase) {
        this(modelBase, null);
    }
    
    public FiskModelRenderer(final ModelBase modelBase, final int textureX, final int textureY) {
        this(modelBase);
        this.setTextureOffset(textureX, textureY);
        if (modelBase instanceof ModelFiskBiped) {
            final ModelFiskBiped mowzieModelBase = (ModelFiskBiped)modelBase;
            if (mowzieModelBase.parts == null) {
                mowzieModelBase.parts = new ArrayList<FiskModelRenderer>();
            }
            mowzieModelBase.parts.add(this);
        }
    }
    
    public void setCurrentPoseToInitValues() {
        this.rotateAngleX = this.initRotateAngleX;
        this.rotateAngleY = this.initRotateAngleY;
        this.rotateAngleZ = this.initRotateAngleZ;
        this.rotationPointX = this.initRotationPointX;
        this.rotationPointY = this.initRotationPointY;
        this.rotationPointZ = this.initRotationPointZ;
    }
    
    public void setInitValuesToCurrentPose() {
        this.initRotateAngleX = this.rotateAngleX;
        this.initRotateAngleY = this.rotateAngleY;
        this.initRotateAngleZ = this.rotateAngleZ;
        this.initRotationPointX = this.rotationPointX;
        this.initRotationPointY = this.rotationPointY;
        this.initRotationPointZ = this.rotationPointZ;
    }
    
    @SideOnly(Side.CLIENT)
    public void render(final float f) {
        GL11.glPushMatrix();
        if (!this.isHidden && this.showModel) {
            if (!this.compiled) {
                this.compileDisplayList(f);
            }
            final float f2 = 0.0625f;
            GL11.glTranslatef(this.offsetX, this.offsetY, this.offsetZ);
            GL11.glTranslatef(this.rotationPointX * f2, this.rotationPointY * f2, this.rotationPointZ * f2);
            GL11.glScalef(this.scaleX, this.scaleY, this.scaleZ);
            GL11.glTranslatef(-this.rotationPointX * f2, -this.rotationPointY * f2, -this.rotationPointZ * f2);
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX == 0.0f && this.rotationPointY == 0.0f && this.rotationPointZ == 0.0f) {
                    GL11.glCallList(this.displayList);
                    if (this.childModels != null) {
                        for (int i = 0; i < this.childModels.size(); ++i) {
                            this.childModels.get(i).render(f);
                        }
                    }
                }
                else {
                    GL11.glTranslatef(this.rotationPointX * f, this.rotationPointY * f, this.rotationPointZ * f);
                    GL11.glCallList(this.displayList);
                    if (this.childModels != null) {
                        for (int i = 0; i < this.childModels.size(); ++i) {
                            this.childModels.get(i).render(f);
                        }
                    }
                    GL11.glTranslatef(-this.rotationPointX * f, -this.rotationPointY * f, -this.rotationPointZ * f);
                }
            }
            else {
                GL11.glPushMatrix();
                GL11.glTranslatef(this.rotationPointX * f, this.rotationPointY * f, this.rotationPointZ * f);
                if (this.rotateAngleZ != 0.0f) {
                    GL11.glRotatef(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GL11.glRotatef(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GL11.glRotatef(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
                GL11.glCallList(this.displayList);
                if (this.childModels != null) {
                    for (int i = 0; i < this.childModels.size(); ++i) {
                        this.childModels.get(i).render(f);
                    }
                }
                GL11.glPopMatrix();
            }
            GL11.glTranslatef(-this.offsetX, -this.offsetY, -this.offsetZ);
        }
        GL11.glPopMatrix();
    }
    
    @SideOnly(Side.CLIENT)
    private void compileDisplayList(final float p_78788_1_) {
        GL11.glNewList(this.displayList = GLAllocation.generateDisplayLists(1), 4864);
        final Tessellator tessellator = Tessellator.instance;
        for (int i = 0; i < this.cubeList.size(); ++i) {
            this.cubeList.get(i).render(tessellator, p_78788_1_);
        }
        GL11.glEndList();
        this.compiled = true;
    }
}
