package fiskfille.pacman;

import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import java.util.*;

public class Utilities
{
    private static ArrayList<ItemStack> recipeItems;
    
    public static ArrayList<ItemStack> getItemsWithRecipes() {
        if (Utilities.recipeItems.isEmpty()) {
            final Set<ItemStack> recipes = new HashSet<ItemStack>();
            for (final IRecipe recipe : CraftingManager.getInstance().getRecipeList()) {
                recipes.add(recipe.getRecipeOutput());
            }
            Utilities.recipeItems.addAll(recipes);
        }
        return Utilities.recipeItems;
    }
    
    static {
        Utilities.recipeItems = new ArrayList<ItemStack>();
    }
}
