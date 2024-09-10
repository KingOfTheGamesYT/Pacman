package fiskfille.pacman.common.item;

import net.minecraft.block.*;
import fiskfille.pacman.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;

public class PacmanAwayBlock extends Block
{
    public final Map<Integer, Set<Coordinate>> packmanAway;
    
    public PacmanAwayBlock() {
        super(Material.rock);
        this.packmanAway = new HashMap<Integer, Set<Coordinate>>();
        this.setUnlocalizedName("PacmanAwayBlock");
    }
    
    public IIcon getIcon(final int side, final int meta) {
        return Blocks.command_block.getIcon(side, meta);
    }
    
    public int tickRate(final World worldIn) {
        return 1;
    }
    
    public void onBlockPreDestroy(final World worldIn, final int x, final int y, final int z, final int meta) {
        super.onBlockPreDestroy(worldIn, x, y, z, meta);
        final Coordinate coordinate = new Coordinate(x, y, z);
        if (!this.packmanAway.containsKey(worldIn.provider.dimensionId)) {
            this.packmanAway.put(worldIn.provider.dimensionId, new HashSet<Coordinate>());
        }
        this.packmanAway.get(worldIn.provider.dimensionId).remove(coordinate);
    }
    
    public int onBlockPlaced(final World worldIn, final int x, final int y, final int z, final int side, final float subX, final float subY, final float subZ, final int meta) {
        return super.onBlockPlaced(worldIn, x, y, z, side, subX, subY, subZ, meta);
    }
    
    public void onBlockAdded(final World worldIn, final int x, final int y, final int z) {
        final Coordinate coordinate = new Coordinate(x, y, z);
        if (!this.packmanAway.containsKey(worldIn.provider.dimensionId)) {
            this.packmanAway.put(worldIn.provider.dimensionId, new HashSet<Coordinate>());
        }
        this.packmanAway.get(worldIn.provider.dimensionId).add(coordinate);
        System.out.println(this.packmanAway);
        super.onBlockAdded(worldIn, x, y, z);
    }
}
