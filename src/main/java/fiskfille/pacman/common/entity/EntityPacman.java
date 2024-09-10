package fiskfille.pacman.common.entity;

import net.minecraft.entity.monster.*;
import java.util.*;
import net.minecraft.command.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import fiskfille.pacman.common.entity.ai.*;
import net.minecraft.entity.ai.*;
import fiskfille.pacman.common.config.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import fiskfille.pacman.common.item.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;

public class EntityPacman extends EntityMob
{
    public double scale;
    public long animationStart;
    public int resizeTimer;
    public UUID eatenEntity;
    private static final IEntitySelector attackEntitySelector;
    
    public EntityPacman(final World world) {
        super(world);
        this.scale = 1.0;
        this.animationStart = System.currentTimeMillis();
        this.tasks.addTask(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(1, (EntityAIBase)new EntityPacmanAIEatBlocks(this));
        this.tasks.addTask(2, (EntityAIBase)new EntityPacmanAIAttackOnCollide((EntityCreature)this, (Class)EntityPlayer.class, 1.0, false));
        this.tasks.addTask(3, (EntityAIBase)new EntityPacmanAIMoveTowardsBlocks(this));
        this.tasks.addTask(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((EntityCreature)this, 1.0));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.tasks.addTask(8, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityLivingBase.class, 8.0f));
        this.tasks.addTask(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
        this.targetTasks.addTask(1, (EntityAIBase)new EntityAIHurtByTarget((EntityCreature)this, true));
        this.targetTasks.addTask(2, (EntityAIBase)new EntityAINearestAttackableTarget((EntityCreature)this, (Class)EntityLivingBase.class, 0, false, false, EntityPacman.attackEntitySelector));
        this.experienceValue = PacmanConfig.pacmanExperience;
    }
    
    public boolean isAIEnabled() {
        return true;
    }
    
    public int getTotalArmorValue() {
        return PacmanConfig.pacmanDefense;
    }
    
    public void onUpdate() {
        if (this.getHibernationTimer() == 1337) {
            return;
        }
        super.onUpdate();
        if (this.resizeTimer > 0) {
            --this.resizeTimer;
        }
        if (this.resizeTimer == 0 && this.scale > 0.0) {
            this.scale -= 0.5;
        }
        if (this.resizeTimer > 0 && this.scale < 10.0) {
            this.scale += 0.5;
        }
        if (this.scale < 0.5) {
            this.scale = 0.5;
        }
        final float range = PacmanConfig.pacmanViewDistance;
        float size = (float)this.scale * 0.65f - 0.35f;
        size = ((size < 0.5f) ? 0.5f : size);
        this.setSize(size, size);
        for (int i = 0; i < this.worldObj.loadedEntityList.size(); ++i) {
            final Entity entity = this.worldObj.loadedEntityList.get(i);
            if (entity != null && !entity.getUniqueID().equals(this.getUniqueID()) && entity instanceof EntityLivingBase) {
                if (this.getDistanceToEntity(entity) <= range && !(entity instanceof EntityPacman)) {
                    this.resizeTimer = 100;
                }
                if (this.getDistanceToEntity(entity) <= 4.0f && this.getEaten() == null && (this.riddenByEntity == null || (this.riddenByEntity != null && !this.riddenByEntity.getUniqueID().equals(entity.getUniqueID())))) {
                    this.setEaten(entity);
                }
            }
        }
        this.updateHibernationLogic();
        if (!this.isHibernating()) {
            this.updateEatingLogic();
        }
        if (this.scale >= 10.0) {
            for (int i = 0; i < 20; ++i) {
                final double spreadX = (this.rand.nextDouble() - 0.5) * 4.0;
                final double spreadZ = (this.rand.nextDouble() - 0.5) * 4.0;
                this.worldObj.spawnParticle("splash", this.posX + spreadX, this.posY + 3.0, this.posZ + spreadZ, 0.0, 0.0, 0.0);
            }
        }
        this.stepHeight = (float)this.scale / 2.0f;
        if (this.ticksExisted % 6 == 0 && !this.isHibernating() && this.isEntityAlive()) {
            this.playSound("pacman:mob.pacman.chomp", 1.0f, 1.0f);
        }
    }
    
    public void setDead() {
        this.setHibernationTimer(1337);
        super.setDead();
    }
    
    private void updateHibernationLogic() {
        if (this.getHibernationTimer() == 1337) {
            return;
        }
        if (this.getHibernationTimer() > 0) {
            this.setHibernationTimer(this.getHibernationTimer() - 1);
        }
        if (this.getHibernationTimer() == 1) {
            this.setHibernationTimer(0);
            this.setBlocksEaten(0);
        }
        if (this.isHibernating()) {
            this.riddenByEntity = null;
            this.motionX = 0.0;
            this.motionZ = 0.0;
        }
        if (this.getBlocksEaten() >= PacmanConfig.pacmanAppetite && !this.isHibernating()) {
            this.setHibernationTimer((int)(PacmanConfig.pacmanHibernationTime * 20.0f));
        }
    }
    
    public boolean isHibernating() {
        return this.getHibernationTimer() > 0;
    }
    
    private void updateEatingLogic() {
        final EntityLivingBase entity = this.getEaten();
        if (entity != null && !this.worldObj.isRemote) {
            entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), PacmanConfig.pacmanEatDamage);
            entity.setPosition(this.posX, this.posY + 4.0, this.posZ);
            entity.fallDistance = 0.0f;
            this.motionX = 0.0;
            this.motionZ = 0.0;
            if (this.rand.nextInt(20) == 0) {
                entity.motionX = (this.rand.nextFloat() - 0.5f) * 4.0f;
                entity.motionY = (this.rand.nextFloat() - 0.5f) * 4.0f;
                entity.motionZ = (this.rand.nextFloat() - 0.5f) * 4.0f;
                this.setEaten(null);
            }
            if (this.isEaten(this.riddenByEntity) || entity.isDead) {
                this.setEaten(null);
            }
        }
    }
    
    public boolean isEaten(final Entity entity) {
        return entity != null && entity.getUniqueID().equals(this.eatenEntity);
    }
    
    public void setEaten(final Entity entity) {
        if (!(entity instanceof EntityPacman)) {
            this.eatenEntity = ((entity == null) ? null : entity.getUniqueID());
        }
    }
    
    public EntityLivingBase getEaten() {
        for (int i = 0; i < this.worldObj.loadedEntityList.size(); ++i) {
            final Entity entity = this.worldObj.loadedEntityList.get(i);
            if (entity instanceof EntityLivingBase && this.isEaten(entity)) {
                return (EntityLivingBase)entity;
            }
        }
        return null;
    }
    
    public void updateRiderPosition() {
        super.updateRiderPosition();
    }
    
    public void moveEntityWithHeading(float par1, float par2) {
        if (this.isHibernating() && this.riddenByEntity != null) {
            final float rotationYaw = this.riddenByEntity.rotationYaw;
            this.rotationYaw = rotationYaw;
            this.prevRotationYaw = rotationYaw;
            this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5f;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            final float rotationYaw2 = this.rotationYaw;
            this.renderYawOffset = rotationYaw2;
            this.rotationYawHead = rotationYaw2;
            par1 = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5f;
            par2 = ((EntityLivingBase)this.riddenByEntity).moveForward;
        }
        super.moveEntityWithHeading(par1, par2);
    }
    
    public double getMountedYOffset() {
        return this.height * 1.0700000524520874;
    }
    
    public void applyEntityCollision(final Entity entityIn) {
    }
    
    public boolean canBePushed() {
        return false;
    }
    
    public boolean canBeCollidedWith() {
        return true;
    }
    
    public boolean canBeSteered() {
        return true;
    }
    
    public boolean interact(final EntityPlayer player) {
        final ItemStack itemstack = player.inventory.getCurrentItem();
        if (super.interact(player)) {
            return true;
        }
        if (this.getSaddled() && !this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == player)) {
            player.mountEntity((Entity)this);
            return true;
        }
        if (!this.getSaddled() && itemstack != null && itemstack.getItem() == Items.saddle) {
            if (!player.capabilities.isCreativeMode) {
                final ItemStack itemStack = itemstack;
                --itemStack.stackSize;
            }
            this.setSaddled(true);
            return true;
        }
        return false;
    }
    
    protected String getLivingSound() {
        return null;
    }
    
    protected String getHurtSound() {
        return null;
    }
    
    protected String getDeathSound() {
        return "pacman:mob.pacman.death";
    }
    
    public boolean attackEntityAsMob(final Entity entity) {
        if ((!this.isHibernating() && this.riddenByEntity == null) || (this.riddenByEntity != null && !this.riddenByEntity.getUniqueID().equals(entity.getUniqueID()))) {
            if (this.rand.nextInt(3) == 0 && !this.isEaten(entity)) {
                this.setEaten(entity);
            }
            else if (this.rand.nextInt(2) == 0) {
                return super.attackEntityAsMob(entity);
            }
        }
        return false;
    }
    
    protected void dropFewItems(final boolean par1, final int par2) {
        super.dropFewItems(par1, par2);
        for (int i = 0; i < 10; ++i) {
            final ItemStack itemstack = ItemDropHelper.getItems().get(this.rand.nextInt(ItemDropHelper.getItems().size()));
            itemstack.stackSize = 1;
            this.entityDropItem(itemstack, 0.0f);
        }
        if (this.getSaddled()) {
            this.dropItem(Items.saddle, 1);
        }
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)PacmanConfig.pacmanHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.275);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)PacmanConfig.pacmanAttackDamage);
    }
    
    protected void setSize(final float width, final float height) {
        if (width != this.width || height != this.height) {
            if (width != this.width || height != this.height) {
                final float f2 = this.width;
                this.width = width;
                this.height = height;
                this.boundingBox.maxX = this.boundingBox.minX + this.width;
                this.boundingBox.maxZ = this.boundingBox.minZ + this.width;
                this.boundingBox.maxY = this.boundingBox.minY + this.height;
            }
            final float f2 = width % 2.0f;
            if (f2 < 0.375) {
                this.myEntitySize = Entity.EnumEntitySize.SIZE_1;
            }
            else if (f2 < 0.75) {
                this.myEntitySize = Entity.EnumEntitySize.SIZE_2;
            }
            else if (f2 < 1.0) {
                this.myEntitySize = Entity.EnumEntitySize.SIZE_3;
            }
            else if (f2 < 1.375) {
                this.myEntitySize = Entity.EnumEntitySize.SIZE_4;
            }
            else if (f2 < 1.75) {
                this.myEntitySize = Entity.EnumEntitySize.SIZE_5;
            }
            else {
                this.myEntitySize = Entity.EnumEntitySize.SIZE_6;
            }
        }
    }
    
    protected float getSoundVolume() {
        return 0.3f;
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setBoolean("Saddle", this.getSaddled());
        if (this.getHibernationTimer() == 1337) {
            nbt.setBoolean("MorphFix", true);
        }
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        this.setSaddled(nbt.getBoolean("Saddle"));
        if (nbt.hasKey("MorphFix") && nbt.getBoolean("MorphFix")) {
            this.setHibernationTimer(1337);
        }
    }
    
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (Object)0);
        this.dataWatcher.addObject(17, (Object)0);
        this.dataWatcher.addObject(18, (Object)0);
    }
    
    public boolean getSaddled() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 0x1) != 0x0;
    }
    
    public void setSaddled(final boolean flag) {
        if (flag) {
            this.dataWatcher.updateObject(16, (Object)1);
        }
        else {
            this.dataWatcher.updateObject(16, (Object)0);
        }
    }
    
    public int getHibernationTimer() {
        return this.dataWatcher.getWatchableObjectInt(17);
    }
    
    public void setHibernationTimer(final int i) {
        this.dataWatcher.updateObject(17, (Object)i);
    }
    
    public int getBlocksEaten() {
        return this.dataWatcher.getWatchableObjectInt(18);
    }
    
    public void setBlocksEaten(final int i) {
        this.dataWatcher.updateObject(18, (Object)i);
    }
    
    static {
        attackEntitySelector = (IEntitySelector)new IEntitySelector() {
            public boolean isEntityApplicable(final Entity entity) {
                return entity instanceof EntityLivingBase && (!(entity instanceof EntityPlayer) || (entity instanceof EntityPlayer && !(entity.ridingEntity instanceof EntityPacman))) && !(entity instanceof EntityPacman);
            }
        };
    }
}
