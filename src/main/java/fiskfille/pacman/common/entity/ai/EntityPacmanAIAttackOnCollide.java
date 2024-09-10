package fiskfille.pacman.common.entity.ai;

import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.pathfinding.*;

public class EntityPacmanAIAttackOnCollide extends EntityAIBase
{
    World worldObj;
    EntityCreature attacker;
    int attackTick;
    double speedTowardsTarget;
    boolean longMemory;
    PathEntity entityPathEntity;
    Class classTarget;
    private int field_75445_i;
    private double field_151497_i;
    private double field_151495_j;
    private double field_151496_k;
    private int failedPathFindingPenalty;
    
    public EntityPacmanAIAttackOnCollide(final EntityCreature p_i1635_1_, final Class p_i1635_2_, final double p_i1635_3_, final boolean p_i1635_5_) {
        this(p_i1635_1_, p_i1635_3_, p_i1635_5_);
        this.classTarget = p_i1635_2_;
    }
    
    public EntityPacmanAIAttackOnCollide(final EntityCreature p_i1636_1_, final double p_i1636_2_, final boolean p_i1636_4_) {
        this.attacker = p_i1636_1_;
        this.worldObj = p_i1636_1_.worldObj;
        this.speedTowardsTarget = p_i1636_2_;
        this.longMemory = p_i1636_4_;
    }
    
    public boolean shouldExecute() {
        final EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        if (entitylivingbase == null) {
            return false;
        }
        if (!entitylivingbase.isEntityAlive()) {
            return false;
        }
        if (this.classTarget != null && !this.classTarget.isAssignableFrom(entitylivingbase.getClass())) {
            return false;
        }
        if (--this.field_75445_i <= 0) {
            this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving((Entity)entitylivingbase);
            this.field_75445_i = 4 + this.attacker.getRNG().nextInt(7);
            return this.entityPathEntity != null;
        }
        return true;
    }
    
    public boolean continueExecuting() {
        final EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        return entitylivingbase != null && entitylivingbase.isEntityAlive() && (this.longMemory ? this.attacker.isWithinHomeDistance(MathHelper.floor_double(entitylivingbase.posX), MathHelper.floor_double(entitylivingbase.posY), MathHelper.floor_double(entitylivingbase.posZ)) : (!this.attacker.getNavigator().noPath()));
    }
    
    public void startExecuting() {
        this.attacker.getNavigator().setPath(this.entityPathEntity, this.speedTowardsTarget);
        this.field_75445_i = 0;
    }
    
    public void resetTask() {
        this.attacker.getNavigator().clearPathEntity();
    }
    
    public void updateTask() {
        final EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        this.attacker.getLookHelper().setLookPositionWithEntity((Entity)entitylivingbase, 30.0f, 30.0f);
        final double d0 = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.boundingBox.minY, entitylivingbase.posZ);
        final double d2 = this.attacker.width * this.attacker.width * 0.8f + entitylivingbase.width;
        --this.field_75445_i;
        if (entitylivingbase != null && this.attacker.getDistanceToEntity((Entity)entitylivingbase) <= 6.0f) {
            this.attacker.motionX = (entitylivingbase.posX - this.attacker.posX) / 10.0;
            this.attacker.motionZ = (entitylivingbase.posZ - this.attacker.posZ) / 10.0;
        }
        if ((this.longMemory || this.attacker.getEntitySenses().canSee((Entity)entitylivingbase)) && this.field_75445_i <= 0 && ((this.field_151497_i == 0.0 && this.field_151495_j == 0.0 && this.field_151496_k == 0.0) || entitylivingbase.getDistanceSq(this.field_151497_i, this.field_151495_j, this.field_151496_k) >= 1.0 || this.attacker.getRNG().nextFloat() < 0.05f)) {
            this.field_151497_i = entitylivingbase.posX;
            this.field_151495_j = entitylivingbase.boundingBox.minY;
            this.field_151496_k = entitylivingbase.posZ;
            this.field_75445_i = this.failedPathFindingPenalty + 4 + this.attacker.getRNG().nextInt(7);
            if (this.attacker.getNavigator().getPath() != null) {
                final PathPoint finalPathPoint = this.attacker.getNavigator().getPath().getFinalPathPoint();
                if (finalPathPoint != null && entitylivingbase.getDistanceSq((double)finalPathPoint.xCoord, (double)finalPathPoint.yCoord, (double)finalPathPoint.zCoord) < 1.0) {
                    this.failedPathFindingPenalty = 0;
                }
                else {
                    this.failedPathFindingPenalty += 10;
                }
            }
            else {
                this.failedPathFindingPenalty += 10;
            }
            if (d0 > 1024.0) {
                this.field_75445_i += 10;
            }
            else if (d0 > 256.0) {
                this.field_75445_i += 5;
            }
            System.out.println("Interference");
            if (!this.attacker.getNavigator().tryMoveToEntityLiving((Entity)entitylivingbase, this.speedTowardsTarget)) {
                this.field_75445_i += 15;
            }
        }
        if (d0 <= d2) {
            this.attacker.attackEntityAsMob((Entity)entitylivingbase);
        }
    }
}
