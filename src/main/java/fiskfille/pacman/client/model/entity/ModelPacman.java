//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\minec\Desktop\mappings\mcp_stable-12-1.7.10"!

//Decompiled by Procyon!

package fiskfille.pacman.client.model.entity;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;
import fiskfille.pacman.common.entity.*;

public class ModelPacman extends ModelFiskBiped
{
    public FiskModelRenderer base;
    public FiskModelRenderer upperHalf;
    public FiskModelRenderer lowerHalf;
    public FiskModelRenderer upperTop1;
    public FiskModelRenderer upperBack1;
    public FiskModelRenderer upperLeft1;
    public FiskModelRenderer upperRight1;
    public FiskModelRenderer upperFront1;
    public FiskModelRenderer upperMouthSide1;
    public FiskModelRenderer upperTooth1;
    public FiskModelRenderer upperTooth2;
    public FiskModelRenderer upperTooth3;
    public FiskModelRenderer upperTooth4;
    public FiskModelRenderer upperTooth5;
    public FiskModelRenderer upperTooth6;
    public FiskModelRenderer upperTooth7;
    public FiskModelRenderer eyeball1;
    public FiskModelRenderer eyeball2;
    public FiskModelRenderer upperTop2;
    public FiskModelRenderer saddleSeat;
    public FiskModelRenderer saddleFront;
    public FiskModelRenderer saddleBack;
    public FiskModelRenderer upperBack2;
    public FiskModelRenderer upperLeft2;
    public FiskModelRenderer upperRight2;
    public FiskModelRenderer upperFront2;
    public FiskModelRenderer upperMouthSide2;
    public FiskModelRenderer upperMouthSide3;
    public FiskModelRenderer upperMouthSide4;
    public FiskModelRenderer eye1;
    public FiskModelRenderer eyebrow1;
    public FiskModelRenderer eye2;
    public FiskModelRenderer eyebrow2;
    public FiskModelRenderer lowerFront1;
    public FiskModelRenderer lowerLeft1;
    public FiskModelRenderer lowerRight1;
    public FiskModelRenderer lowerBack1;
    public FiskModelRenderer lowerBottom1;
    public FiskModelRenderer lowerMouthSide1;
    public FiskModelRenderer lowerTooth1;
    public FiskModelRenderer lowerTooth2;
    public FiskModelRenderer lowerTooth3;
    public FiskModelRenderer lowerTooth4;
    public FiskModelRenderer lowerTooth5;
    public FiskModelRenderer lowerTooth6;
    public FiskModelRenderer lowerTooth7;
    public FiskModelRenderer tounge1;
    public FiskModelRenderer lowerFront2;
    public FiskModelRenderer lowerLeft2;
    public FiskModelRenderer lowerRight2;
    public FiskModelRenderer lowerBack2;
    public FiskModelRenderer lowerBottom2;
    public FiskModelRenderer lowerMouthSide2;
    public FiskModelRenderer lowerMouthSide3;
    public FiskModelRenderer lowerMouthSide4;
    public FiskModelRenderer tounge2;
    public FiskModelRenderer tounge3;
    public FiskModelRenderer tounge4;
    
    public ModelPacman() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.upperRight2 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, -0.6f, 0.0f);
        this.upperRight2.addBox(0.0f, -1.0f, -1.0f, 1, 1, 2, 0.0f);
        (this.lowerTooth2 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(-3.6f, 0.0f, -2.4f);
        this.lowerTooth2.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.saddleBack = new FiskModelRenderer((ModelBase)this, 0, 38)).setRotationPoint(0.0f, -1.0f, 2.0f);
        this.saddleBack.addBox(-4.0f, -3.0f, -1.0f, 8, 3, 2, 0.0f);
        this.setRotateAngle(this.saddleBack, -1.0471976f, 0.0f, 0.0f);
        (this.lowerTooth7 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(4.0f, 0.0f, -1.0f);
        this.lowerTooth7.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.upperTop2 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, -0.6f, 0.0f);
        this.upperTop2.addBox(-1.0f, -1.0f, -1.0f, 2, 1, 2, 0.0f);
        (this.upperTop1 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, -4.0f, 0.0f);
        this.upperTop1.addBox(-3.0f, -1.0f, -3.0f, 6, 1, 6, 0.0f);
        (this.eyebrow1 = new FiskModelRenderer((ModelBase)this, 18, 4)).setRotationPoint(0.5f, -1.5f, -0.2f);
        this.eyebrow1.addBox(-1.0f, -0.5f, -1.0f, 2, 1, 1, 0.0f);
        this.setRotateAngle(this.eyebrow1, 0.0f, 0.0f, 0.5235988f);
        (this.lowerFront2 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, -0.6f, 0.0f);
        this.lowerFront2.addBox(-1.0f, -1.0f, 0.0f, 2, 1, 1, 0.0f);
        (this.upperBack2 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, -0.6f, 0.0f);
        this.upperBack2.addBox(-1.0f, -1.0f, -1.0f, 2, 1, 1, 0.0f);
        (this.lowerBack2 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, -0.6f, 0.0f);
        this.lowerBack2.addBox(-1.0f, -1.0f, -1.0f, 2, 1, 1, 0.0f);
        (this.eyeball2 = new FiskModelRenderer((ModelBase)this, 0, 7)).setRotationPoint(3.3f, -2.0f, -3.3f);
        this.eyeball2.addBox(-1.0f, -1.0f, -1.0f, 2, 2, 1, 0.0f);
        this.setRotateAngle(this.eyeball2, 0.0f, -0.7853982f, 0.0f);
        (this.tounge2 = new FiskModelRenderer((ModelBase)this, 24, 6)).setRotationPoint(0.0f, 0.0f, -2.0f);
        this.tounge2.addBox(-1.5f, -0.5f, -2.0f, 3, 1, 2, 0.0f);
        this.setRotateAngle(this.tounge2, 0.91053826f, 0.0f, 0.0f);
        (this.tounge1 = new FiskModelRenderer((ModelBase)this, 24, 6)).setRotationPoint(0.0f, -0.5f, 3.5f);
        this.tounge1.addBox(-1.5f, -0.5f, -2.0f, 3, 1, 2, 0.0f);
        this.setRotateAngle(this.tounge1, -0.6981317f, 0.0f, 0.0f);
        (this.eye1 = new FiskModelRenderer((ModelBase)this, 0, 10)).setRotationPoint(0.0f, 0.0f, -1.0f);
        this.eye1.addBox(-0.2f, -0.2f, -0.2f, 1, 1, 1, 0.0f);
        (this.saddleSeat = new FiskModelRenderer((ModelBase)this, 0, 27)).setRotationPoint(0.0f, -1.0f, 0.0f);
        this.saddleSeat.addBox(-5.0f, -2.0f, -4.5f, 10, 2, 9, 0.0f);
        (this.upperMouthSide2 = new FiskModelRenderer((ModelBase)this, 24, 0)).setRotationPoint(3.5f, 0.0f, 3.5f);
        this.upperMouthSide2.addBox(-3.0f, 0.0f, -0.5f, 6, 2, 1, 0.0f);
        this.setRotateAngle(this.upperMouthSide2, 0.0f, 1.5707964f, 0.0f);
        (this.tounge4 = new FiskModelRenderer((ModelBase)this, 24, 6)).setRotationPoint(0.0f, 0.0f, -2.0f);
        this.tounge4.addBox(-1.5f, -0.5f, -2.0f, 3, 1, 2, 0.0f);
        this.setRotateAngle(this.tounge4, -0.4098033f, 0.0f, 0.0f);
        (this.tounge3 = new FiskModelRenderer((ModelBase)this, 24, 6)).setRotationPoint(0.0f, 0.0f, -2.0f);
        this.tounge3.addBox(-1.5f, -0.5f, -2.0f, 3, 1, 2, 0.0f);
        this.setRotateAngle(this.tounge3, 0.2617994f, 0.0f, 0.0f);
        (this.eyeball1 = new FiskModelRenderer((ModelBase)this, 0, 7)).setRotationPoint(-3.3f, -2.0f, -3.3f);
        this.eyeball1.addBox(-1.0f, -1.0f, -1.0f, 2, 2, 1, 0.0f);
        this.setRotateAngle(this.eyeball1, 0.0f, 0.7853982f, 0.0f);
        (this.lowerLeft1 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.lowerLeft1.addBox(0.0f, -1.0f, -3.0f, 3, 1, 6, 0.0f);
        this.setRotateAngle(this.lowerLeft1, 0.0f, 0.0f, -1.5707964f);
        (this.lowerTooth5 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(2.0f, 0.0f, -4.0f);
        this.lowerTooth5.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.upperTooth2 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(-3.6f, 0.0f, -2.4f);
        this.upperTooth2.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.upperMouthSide4 = new FiskModelRenderer((ModelBase)this, 24, 3)).setRotationPoint(0.0f, 0.0f, 7.0f);
        this.upperMouthSide4.addBox(-4.0f, 0.0f, -0.5f, 8, 2, 1, 0.0f);
        this.setRotateAngle(this.upperMouthSide4, 0.0f, 3.1415927f, 0.0f);
        (this.upperLeft1 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(4.0f, 0.0f, 0.0f);
        this.upperLeft1.addBox(-3.0f, -1.0f, -3.0f, 3, 1, 6, 0.0f);
        this.setRotateAngle(this.upperLeft1, 0.0f, 0.0f, 1.5707964f);
        (this.upperTooth5 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(2.0f, 0.0f, -4.0f);
        this.upperTooth5.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.lowerMouthSide4 = new FiskModelRenderer((ModelBase)this, 24, 3)).setRotationPoint(0.0f, 0.0f, 7.0f);
        this.lowerMouthSide4.addBox(-4.0f, 0.0f, -0.5f, 8, 2, 1, 0.0f);
        this.setRotateAngle(this.lowerMouthSide4, 0.0f, 3.1415927f, 0.0f);
        (this.lowerTooth1 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(-4.0f, 0.0f, -1.0f);
        this.lowerTooth1.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.upperFront2 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, -0.6f, 0.0f);
        this.upperFront2.addBox(-1.0f, -1.0f, 0.0f, 2, 1, 1, 0.0f);
        (this.lowerTooth3 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(-2.0f, 0.0f, -4.0f);
        this.lowerTooth3.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.upperTooth1 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(-4.0f, 0.0f, -1.0f);
        this.upperTooth1.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.base = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 9.0f, 0.0f);
        this.base.addBox(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        (this.lowerMouthSide1 = new FiskModelRenderer((ModelBase)this, 24, 3)).setRotationPoint(0.0f, -2.0f, -3.5f);
        this.lowerMouthSide1.addBox(-4.0f, 0.0f, -0.5f, 8, 2, 1, 0.0f);
        (this.upperFront1 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 0.0f, -4.0f);
        this.upperFront1.addBox(-3.0f, -1.0f, 0.0f, 6, 1, 3, 0.0f);
        this.setRotateAngle(this.upperFront1, 1.5707964f, 0.0f, 0.0f);
        (this.upperTooth7 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(4.0f, 0.0f, -1.0f);
        this.upperTooth7.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.upperLeft2 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, -0.6f, 0.0f);
        this.upperLeft2.addBox(-1.0f, -1.0f, -1.0f, 1, 1, 2, 0.0f);
        (this.upperRight1 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.upperRight1.addBox(0.0f, -1.0f, -3.0f, 3, 1, 6, 0.0f);
        this.setRotateAngle(this.upperRight1, 0.0f, 0.0f, -1.5707964f);
        (this.lowerFront1 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 0.0f, -4.0f);
        this.lowerFront1.addBox(-3.0f, -1.0f, 0.0f, 6, 1, 3, 0.0f);
        this.setRotateAngle(this.lowerFront1, 1.5707964f, 0.0f, 0.0f);
        (this.upperMouthSide3 = new FiskModelRenderer((ModelBase)this, 24, 0)).setRotationPoint(-3.5f, 0.0f, 3.5f);
        this.upperMouthSide3.addBox(-3.0f, 0.0f, -0.5f, 6, 2, 1, 0.0f);
        this.setRotateAngle(this.upperMouthSide3, 0.0f, -1.5707964f, 0.0f);
        (this.eye2 = new FiskModelRenderer((ModelBase)this, 0, 10)).setRotationPoint(0.0f, 0.0f, -1.0f);
        this.eye2.addBox(-0.8f, -0.2f, -0.2f, 1, 1, 1, 0.0f);
        (this.lowerTooth6 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(3.6f, 0.0f, -2.4f);
        this.lowerTooth6.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.upperTooth3 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(-2.0f, 0.0f, -4.0f);
        this.upperTooth3.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.upperBack1 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 0.0f, 4.0f);
        this.upperBack1.addBox(-3.0f, -1.0f, -3.0f, 6, 1, 3, 0.0f);
        this.setRotateAngle(this.upperBack1, -1.5707964f, 0.0f, 0.0f);
        (this.saddleFront = new FiskModelRenderer((ModelBase)this, 0, 38)).setRotationPoint(0.0f, -1.0f, -4.0f);
        this.saddleFront.addBox(-4.0f, -3.0f, -1.0f, 8, 3, 2, 0.0f);
        this.setRotateAngle(this.saddleFront, 0.43633232f, 0.0f, 0.0f);
        (this.lowerMouthSide3 = new FiskModelRenderer((ModelBase)this, 24, 0)).setRotationPoint(-3.5f, 0.0f, 3.5f);
        this.lowerMouthSide3.addBox(-3.0f, 0.0f, -0.5f, 6, 2, 1, 0.0f);
        this.setRotateAngle(this.lowerMouthSide3, 0.0f, -1.5707964f, 0.0f);
        (this.eyebrow2 = new FiskModelRenderer((ModelBase)this, 18, 4)).setRotationPoint(-0.5f, -1.5f, -0.2f);
        this.eyebrow2.addBox(-1.0f, -0.5f, -1.0f, 2, 1, 1, 0.0f);
        this.setRotateAngle(this.eyebrow2, 0.0f, 0.0f, -0.5235988f);
        (this.upperTooth6 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(3.6f, 0.0f, -2.4f);
        this.upperTooth6.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.lowerMouthSide2 = new FiskModelRenderer((ModelBase)this, 24, 0)).setRotationPoint(3.5f, 0.0f, 3.5f);
        this.lowerMouthSide2.addBox(-3.0f, 0.0f, -0.5f, 6, 2, 1, 0.0f);
        this.setRotateAngle(this.lowerMouthSide2, 0.0f, 1.5707964f, 0.0f);
        (this.upperTooth4 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(0.0f, 0.0f, -4.5f);
        this.upperTooth4.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.lowerBack1 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 0.0f, 4.0f);
        this.lowerBack1.addBox(-3.0f, -1.0f, -3.0f, 6, 1, 3, 0.0f);
        this.setRotateAngle(this.lowerBack1, -1.5707964f, 0.0f, 0.0f);
        (this.lowerBottom1 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, -4.0f, 0.0f);
        this.lowerBottom1.addBox(-3.0f, -1.0f, -3.0f, 6, 1, 6, 0.0f);
        (this.lowerHalf = new FiskModelRenderer((ModelBase)this, 0, 7)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.lowerHalf.addBox(-4.0f, -4.0f, -4.0f, 8, 2, 8, 0.0f);
        this.setRotateAngle(this.lowerHalf, -0.17453292f, 0.0f, -3.1415927f);
        (this.lowerRight2 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, -0.6f, 0.0f);
        this.lowerRight2.addBox(-1.0f, -1.0f, -1.0f, 1, 1, 2, 0.0f);
        (this.lowerBottom2 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, -0.6f, 0.0f);
        this.lowerBottom2.addBox(-1.0f, -1.0f, -1.0f, 2, 1, 2, 0.0f);
        (this.lowerRight1 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(4.0f, 0.0f, 0.0f);
        this.lowerRight1.addBox(-3.0f, -1.0f, -3.0f, 3, 1, 6, 0.0f);
        this.setRotateAngle(this.lowerRight1, 0.0f, 0.0f, 1.5707964f);
        (this.lowerTooth4 = new FiskModelRenderer((ModelBase)this, 18, 0)).setRotationPoint(0.0f, 0.0f, -4.5f);
        this.lowerTooth4.addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1, 0.0f);
        (this.upperMouthSide1 = new FiskModelRenderer((ModelBase)this, 24, 3)).setRotationPoint(0.0f, -2.0f, -3.5f);
        this.upperMouthSide1.addBox(-4.0f, 0.0f, -0.5f, 8, 2, 1, 0.0f);
        (this.lowerLeft2 = new FiskModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, -0.6f, 0.0f);
        this.lowerLeft2.addBox(0.0f, -1.0f, -1.0f, 1, 1, 2, 0.0f);
        (this.upperHalf = new FiskModelRenderer((ModelBase)this, 0, 17)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.upperHalf.addBox(-4.0f, -4.0f, -4.0f, 8, 2, 8, 0.0f);
        this.setRotateAngle(this.upperHalf, -0.17453292f, 0.0f, 0.0f);
        this.upperRight1.addChild((ModelRenderer)this.upperRight2);
        this.lowerHalf.addChild((ModelRenderer)this.lowerTooth2);
        this.saddleSeat.addChild((ModelRenderer)this.saddleBack);
        this.lowerHalf.addChild((ModelRenderer)this.lowerTooth7);
        this.upperTop1.addChild((ModelRenderer)this.upperTop2);
        this.upperHalf.addChild((ModelRenderer)this.upperTop1);
        this.eyeball1.addChild((ModelRenderer)this.eyebrow1);
        this.lowerFront1.addChild((ModelRenderer)this.lowerFront2);
        this.upperBack1.addChild((ModelRenderer)this.upperBack2);
        this.lowerBack1.addChild((ModelRenderer)this.lowerBack2);
        this.upperHalf.addChild((ModelRenderer)this.eyeball2);
        this.tounge1.addChild((ModelRenderer)this.tounge2);
        this.lowerHalf.addChild((ModelRenderer)this.tounge1);
        this.eyeball1.addChild((ModelRenderer)this.eye1);
        this.upperTop1.addChild((ModelRenderer)this.saddleSeat);
        this.upperMouthSide1.addChild((ModelRenderer)this.upperMouthSide2);
        this.tounge3.addChild((ModelRenderer)this.tounge4);
        this.tounge2.addChild((ModelRenderer)this.tounge3);
        this.upperHalf.addChild((ModelRenderer)this.eyeball1);
        this.lowerHalf.addChild((ModelRenderer)this.lowerLeft1);
        this.lowerHalf.addChild((ModelRenderer)this.lowerTooth5);
        this.upperHalf.addChild((ModelRenderer)this.upperTooth2);
        this.upperMouthSide1.addChild((ModelRenderer)this.upperMouthSide4);
        this.upperHalf.addChild((ModelRenderer)this.upperLeft1);
        this.upperHalf.addChild((ModelRenderer)this.upperTooth5);
        this.lowerMouthSide1.addChild((ModelRenderer)this.lowerMouthSide4);
        this.lowerHalf.addChild((ModelRenderer)this.lowerTooth1);
        this.upperFront1.addChild((ModelRenderer)this.upperFront2);
        this.lowerHalf.addChild((ModelRenderer)this.lowerTooth3);
        this.upperHalf.addChild((ModelRenderer)this.upperTooth1);
        this.lowerHalf.addChild((ModelRenderer)this.lowerMouthSide1);
        this.upperHalf.addChild((ModelRenderer)this.upperFront1);
        this.upperHalf.addChild((ModelRenderer)this.upperTooth7);
        this.upperLeft1.addChild((ModelRenderer)this.upperLeft2);
        this.upperHalf.addChild((ModelRenderer)this.upperRight1);
        this.lowerHalf.addChild((ModelRenderer)this.lowerFront1);
        this.upperMouthSide1.addChild((ModelRenderer)this.upperMouthSide3);
        this.eyeball2.addChild((ModelRenderer)this.eye2);
        this.lowerHalf.addChild((ModelRenderer)this.lowerTooth6);
        this.upperHalf.addChild((ModelRenderer)this.upperTooth3);
        this.upperHalf.addChild((ModelRenderer)this.upperBack1);
        this.saddleSeat.addChild((ModelRenderer)this.saddleFront);
        this.lowerMouthSide1.addChild((ModelRenderer)this.lowerMouthSide3);
        this.eyeball2.addChild((ModelRenderer)this.eyebrow2);
        this.upperHalf.addChild((ModelRenderer)this.upperTooth6);
        this.lowerMouthSide1.addChild((ModelRenderer)this.lowerMouthSide2);
        this.upperHalf.addChild((ModelRenderer)this.upperTooth4);
        this.lowerHalf.addChild((ModelRenderer)this.lowerBack1);
        this.lowerHalf.addChild((ModelRenderer)this.lowerBottom1);
        this.base.addChild((ModelRenderer)this.lowerHalf);
        this.lowerRight1.addChild((ModelRenderer)this.lowerRight2);
        this.lowerBottom1.addChild((ModelRenderer)this.lowerBottom2);
        this.lowerHalf.addChild((ModelRenderer)this.lowerRight1);
        this.lowerHalf.addChild((ModelRenderer)this.lowerTooth4);
        this.upperHalf.addChild((ModelRenderer)this.upperMouthSide1);
        this.lowerLeft1.addChild((ModelRenderer)this.lowerLeft2);
        this.base.addChild((ModelRenderer)this.upperHalf);
        this.setInitPose();
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.setToInitPose();
        final float scale = 0.1f;
        this.setScale(this.saddleSeat, scale, scale, scale);
        final FiskModelRenderer saddleSeat = this.saddleSeat;
        saddleSeat.rotationPointY -= 0.01f;
        final FiskModelRenderer saddleSeat2 = this.saddleSeat;
        saddleSeat2.rotationPointZ -= 1.3f;
        this.saddleSeat.rotateAngleX = -this.upperHalf.rotateAngleX;
        GL11.glPushMatrix();
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.base.render(f5);
        GL11.glPopMatrix();
    }
    
    public void setRotateAngle(final FiskModelRenderer FiskModelRenderer, final float x, final float y, final float z) {
        FiskModelRenderer.rotateAngleX = x;
        FiskModelRenderer.rotateAngleY = y;
        FiskModelRenderer.rotateAngleZ = z;
    }
    
    public double sinEasingInOut(final double tick, final double start, final double end, final double duration) {
        return -end / 2.0 * (Math.cos(3.141592653589793 * tick / duration) - 1.0) + start;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
        if (e instanceof EntityPacman) {
            final EntityPacman entity = (EntityPacman)e;
            final long currentTime = System.currentTimeMillis();
            if (System.currentTimeMillis() - entity.animationStart > 500L) {
                entity.animationStart = System.currentTimeMillis();
            }
            final double scale = entity.scale;
            final float rot = (float)Math.sin(this.sinEasingInOut((double)(currentTime - entity.animationStart), 0.0, 3.0, 500.0)) * 0.4f + 0.15f;
            if (!entity.isHibernating() && entity.isEntityAlive()) {
                if (entity.riddenByEntity != null) {
                    this.lowerHalf.rotateAngleX = -rot;
                }
                else {
                    this.upperHalf.rotateAngleX = -rot;
                    this.lowerHalf.rotateAngleX = -rot;
                }
                for (final FiskModelRenderer part : new FiskModelRenderer[] { this.tounge1, this.tounge2, this.tounge3, this.tounge4 }) {
                    final float f6 = (float)Math.sin(entity.ticksExisted / 10.0) / 10.0f;
                    final FiskModelRenderer fiskModelRenderer = part;
                    fiskModelRenderer.rotateAngleX += -f6;
                    final FiskModelRenderer fiskModelRenderer2 = part;
                    fiskModelRenderer2.rotateAngleY += f6;
                    final FiskModelRenderer fiskModelRenderer3 = part;
                    fiskModelRenderer3.rotateAngleZ += f6;
                }
            }
            else {
                this.base.rotateAngleZ = 1.5707964f;
            }
            this.setScale(this.eyeball1, 1.0f, 1.0f, 1.0f);
            this.setScale(this.eyeball2, 1.0f, 1.0f, 1.0f);
            GL11.glTranslatef(this.base.offsetX, this.base.offsetY, this.base.offsetZ);
            GL11.glTranslatef(this.base.rotationPointX * f5, this.base.rotationPointY * f5, this.base.rotationPointZ * f5);
            GL11.glScaled(scale, scale, scale);
            GL11.glTranslatef(-this.base.offsetX, -this.base.offsetY, -this.base.offsetZ);
            GL11.glTranslatef(-this.base.rotationPointX * f5, -this.base.rotationPointY * f5, -this.base.rotationPointZ * f5);
        }
    }
}
