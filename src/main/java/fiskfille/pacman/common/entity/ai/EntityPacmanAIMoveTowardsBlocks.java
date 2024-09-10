package fiskfille.pacman.common.entity.ai;

import net.minecraft.entity.ai.*;
import fiskfille.pacman.common.entity.*;
import net.minecraft.world.*;
import fiskfille.pacman.common.proxy.*;
import fiskfille.pacman.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.block.*;

public class EntityPacmanAIMoveTowardsBlocks extends EntityAIBase
{
    private EntityPacman entity;
    private World worldObj;
    private int blockPosX;
    private int blockPosZ;
    
    public EntityPacmanAIMoveTowardsBlocks(final EntityPacman p_i1637_1_) {
        this.blockPosX = -1;
        this.blockPosZ = -1;
        this.entity = p_i1637_1_;
        this.worldObj = this.entity.worldObj;
    }
    
    public boolean shouldExecute() {
        if (this.entity.isHibernating()) {
            return false;
        }
        if (this.entity.getRNG().nextInt(10) == 0) {
            return false;
        }
        if (CommonProxy.pacmanAwayBlock.packmanAway.containsKey(this.worldObj.provider.dimensionId) && CommonProxy.pacmanAwayBlock.packmanAway.get(this.worldObj.provider.dimensionId).size() > 0) {
            for (final Coordinate coord : CommonProxy.pacmanAwayBlock.packmanAway.get(this.worldObj.provider.dimensionId)) {
                if (this.entity.getDistance((double)coord.getX(), this.entity.posY, (double)coord.getZ()) < 80.0) {
                    this.blockPosX = (int)(this.entity.posX - (coord.getX() - this.entity.posX));
                    this.blockPosZ = (int)(this.entity.posZ - (coord.getZ() - this.entity.posZ));
                    return true;
                }
            }
        }
        final int range = 32;
        final int range2 = 5;
        for (int i = -range; i <= range; ++i) {
            for (int j = -range2; j <= range2; ++j) {
                for (int k = -range; k <= range; ++k) {
                    final int x = (int)this.entity.posX + i;
                    final int y = (int)this.entity.posY + j;
                    final int z = (int)this.entity.posZ + k;
                    final Block block = this.worldObj.getBlock(x, y, z);
                    if (this.entity.getDistance((double)x, (double)y, (double)z) <= 16.0 && (block.getMaterial().equals(Material.wood) || block.getMaterial().equals(Material.leaves) || block.getMaterial().equals(Material.gourd) || block.getMaterial().equals(Material.plants) || block.getMaterial().equals(Material.cactus) || block.getMaterial().equals(Material.vine)) && block.getBlockHardness(this.worldObj, x, y, z) > 0.0f) {
                        this.blockPosX = x;
                        this.blockPosZ = z;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean continueExecuting() {
        return !this.entity.getNavigator().noPath() && !this.entity.isHibernating();
    }
    
    public void startExecuting() {
        this.entity.getNavigator().tryMoveToXYZ(this.blockPosX + 0.5, this.entity.posY, this.blockPosZ + 0.5, 1.0);
    }
    
    public void resetTask() {
        this.blockPosX = 0;
        this.blockPosZ = 0;
    }
}
