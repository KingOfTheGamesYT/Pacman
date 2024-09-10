//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\minec\Desktop\mappings\mcp_stable-12-1.7.10"!

//Decompiled by Procyon!

package fiskfille.pacman.client.model.entity;

import net.minecraft.client.model.*;
import java.util.*;

public abstract class ModelFiskBiped extends ModelBiped
{
    public Random rand;
    protected List<FiskModelRenderer> parts;
    
    public ModelFiskBiped() {
        this.rand = new Random();
    }
    
    protected void setInitPose() {
        for (int i = 0; i < this.parts.size(); ++i) {
            this.parts.get(i).setInitValuesToCurrentPose();
        }
    }
    
    protected void setToInitPose() {
        for (int i = 0; i < this.parts.size(); ++i) {
            this.parts.get(i).setCurrentPoseToInitValues();
        }
    }
    
    public void setScale(final FiskModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.scaleX = x;
        modelRenderer.scaleY = y;
        modelRenderer.scaleZ = z;
    }
}
