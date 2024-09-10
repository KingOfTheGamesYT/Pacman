package fiskfille.pacman.common.item;

import net.minecraft.creativetab.*;
import fiskfille.pacman.common.proxy.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.item.crafting.*;

public class PacmanItems
{
    public static CreativeTabs pacman;
    
    public static void load() {
        PacmanItems.pacman = new CreativeTabs("PacmanCreativeTab") {
            public Item getTabIconItem() {
                return Items.stick;
            }
        };
        (CommonProxy.pacmanAwayBlock = new PacmanAwayBlock()).setCreativeTab(PacmanItems.pacman);
        GameRegistry.registerBlock((Block)CommonProxy.pacmanAwayBlock, "PacmanAwayBlock");
        final ItemStack diamond = new ItemStack(Items.diamond);
        final ItemStack yellow = new ItemStack(Items.dye, 1, 11);
        final ItemStack torch = new ItemStack(Blocks.torch);
        final ShapedRecipes sr = new ShapedRecipes(3, 2, new ItemStack[] { yellow, diamond, yellow, null, torch, null }, new ItemStack((Block)CommonProxy.pacmanAwayBlock));
        GameRegistry.addRecipe((IRecipe)sr);
    }
}
