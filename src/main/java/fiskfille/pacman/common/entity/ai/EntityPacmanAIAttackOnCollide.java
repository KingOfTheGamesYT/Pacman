package fiskfille.pacman.common.entity.ai;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.world.World;

public class EntityPacmanAIAttackOnCollide extends Goal {
    World world;
    CreatureEntity attacker;
    int attackTick;
    double speedTowardsTarget;
    boolean longMemory;
    Path entityPathEntity;
    Class<? extends Entity> classTarget;
    private int delayCounter;
    private double targetX;
    private double targetY;
    private double targetZ;
    private int failedPathFindingPenalty;

    public EntityPacmanAIAttackOnCollide(CreatureEntity p_i1635_1_, Class<? extends Entity> p_i1635_2_, double p_i1635_3_, boolean p_i1635_5_) {
        this(p_i1635_1_, p_i1635_3_, p_i1635_5_);
        this.classTarget = p_i1635_2_;
    }

    public EntityPacmanAIAttackOnCollide(CreatureEntity p_i1636_1_, double p_i1636_2_, boolean p_i1636_4_) {
        this.attacker = p_i1636_1_;
        this.world = p_i1636_1_.world;
        this.speedTowardsTarget = p_i1636_2_;
        this.longMemory = p_i1636_4_;
    }

    public boolean shouldExecute() {
        LivingEntity entitylivingbase = this.attacker.getAttackTarget();
        if (entitylivingbase == null) {
            return false;
        } else if (!entitylivingbase.isAlive()) {
            return false;
        } else if (this.classTarget != null && !this.classTarget.isAssignableFrom(entitylivingbase.getClass())) {
            return false;
        } else if (--this.delayCounter <= 0) {
            this.entityPathEntity = this.attacker.getNavigator().pathfind(entitylivingbase, 0);
            this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);
            return this.entityPathEntity != null;
        } else {
            return true;
        }
    }

    public boolean shouldContinueExecuting() {
        LivingEntity entitylivingbase = this.attacker.getAttackTarget();
        return entitylivingbase == null ? false : (!entitylivingbase.isAlive() ? false : (!this.longMemory ? !this.attacker.getNavigator().noPath() : this.attacker.isWithinHomeDistanceFromPosition(entitylivingbase.getPosition())));
    }

    public void startExecuting() {
        this.attacker.getNavigator().setPath(this.entityPathEntity, this.speedTowardsTarget);
        this.delayCounter = 0;
    }

    public void resetTask() {
        this.attacker.getNavigator().clearPath();
    }

    public void tick() {
        LivingEntity entitylivingbase = this.attacker.getAttackTarget();
        this.attacker.getLookController().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
        double d0 = this.attacker.getDistanceSq(entitylivingbase.getPosX(), entitylivingbase.getBoundingBox().minY, entitylivingbase.getPosZ());
        double d1 = (double)(this.attacker.getWidth() * this.attacker.getWidth() * 0.8F + entitylivingbase.getWidth());
        --this.delayCounter;
        if (entitylivingbase != null && this.attacker.getDistance(entitylivingbase) <= 6.0F) {
            this.attacker.setMotion((entitylivingbase.getPosX() - this.attacker.getPosX()) / 10.0, this.attacker.getMotion().getY(), (entitylivingbase.getPosZ() - this.attacker.getPosZ()) / 10.0);
        }

        if ((this.longMemory || this.attacker.getEntitySenses().canSee(entitylivingbase)) && this.delayCounter <= 0 && (this.targetX == 0.0 && this.targetY == 0.0 && this.targetZ == 0.0 || entitylivingbase.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0 || this.attacker.getRNG().nextFloat() < 0.05F)) {
            this.targetX = entitylivingbase.getPosX();
            this.targetY = entitylivingbase.getBoundingBox().minY;
            this.targetZ = entitylivingbase.getPosZ();
            this.delayCounter = this.failedPathFindingPenalty + 4 + this.attacker.getRNG().nextInt(7);
            if (this.attacker.getNavigator().getPath() != null) {
                PathPoint finalPathPoint = this.attacker.getNavigator().getPath().getFinalPathPoint();
                if (finalPathPoint != null && entitylivingbase.getDistanceSq((double)finalPathPoint.x, (double)finalPathPoint.y, (double)finalPathPoint.z) < 1.0) {
                    this.failedPathFindingPenalty = 0;
                } else {
                    this.failedPathFindingPenalty += 10;
                }
            } else {
                this.failedPathFindingPenalty += 10;
            }

            if (d0 > 1024.0) {
                this.delayCounter += 10;
            } else if (d0 > 256.0) {
                this.delayCounter += 5;
            }

            if (!this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.speedTowardsTarget)) {
                this.delayCounter += 15;
            }
        }

        if (d0 <= d1) {
            this.attacker.attackEntityAsMob(entitylivingbase);
        }

    }
}
