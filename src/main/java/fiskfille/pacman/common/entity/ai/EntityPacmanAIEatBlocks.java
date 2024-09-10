package fiskfille.pacman.common.entity.ai;

import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import fiskfille.pacman.common.entity.*;
import net.minecraft.block.material.*;
import java.util.*;
import fiskfille.pacman.common.config.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class EntityPacmanAIEatBlocks extends EntityAIBase
{
    World worldObj;
    EntityPacman attacker;
    private int eatTimer;
    List<Material> materialTypes;
    
    public EntityPacmanAIEatBlocks(final EntityPacman entity) {
        this.materialTypes = new ArrayList<Material>();
        this.attacker = entity;
        this.worldObj = entity.worldObj;
        this.setMutexBits(3);
        this.materialTypes.add(Material.wood);
        this.materialTypes.add(Material.leaves);
        this.materialTypes.add(Material.gourd);
        this.materialTypes.add(Material.plants);
        this.materialTypes.add(Material.cactus);
        this.materialTypes.add(Material.vine);
    }
    
    public boolean shouldExecute() {
        return this.attacker.getBlocksEaten() < PacmanConfig.pacmanAppetite;
    }
    
    public boolean continueExecuting() {
        return this.attacker.getBlocksEaten() < PacmanConfig.pacmanAppetite;
    }
    
    public void updateTask() {
        if (this.eatTimer > 0) {
            --this.eatTimer;
        }
        if (this.attacker.scale >= 6.0) {
            final int range = 6;
            final Vec3 getLookVec;
            final Vec3 dirVec = getLookVec = this.attacker.getLookVec();
            getLookVec.xCoord *= range * 2;
            final Vec3 vec3 = dirVec;
            vec3.zCoord *= range * 2;
            for (int i = 0; i != MathHelper.floor_double(dirVec.xCoord); i += (int)Math.signum(dirVec.xCoord)) {
                for (int j = -range; j <= range; ++j) {
                    for (int k = 0; k != MathHelper.floor_double(dirVec.zCoord); k += (int)Math.signum(dirVec.zCoord)) {
                        final int x = (int)this.attacker.posX + i;
                        final int y = (int)this.attacker.posY + j;
                        final int z = (int)this.attacker.posZ + k;
                        final Block block = this.worldObj.getBlock(x, y, z);
                        if (block.getBlockHardness(this.worldObj, x, y, z) > 0.0f && this.eatTimer == 0 && this.materialTypes.contains(block.getMaterial())) {
                            this.attacker.setBlocksEaten(this.attacker.getBlocksEaten() + 1);
                            this.worldObj.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block) + (this.worldObj.getBlockMetadata(x, y, z) << 12));
                            this.worldObj.setBlock(x, y, z, Blocks.air);
                            this.eatTimer = 1;
                        }
                    }
                }
            }
        }
    }
}
