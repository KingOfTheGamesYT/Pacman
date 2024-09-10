package fiskfille.pacman.common.item;

import net.minecraft.item.*;
import net.minecraft.nbt.*;
import java.util.*;
import fiskfille.pacman.*;
import com.google.common.collect.*;

public class ItemDropHelper
{
    private static ArrayList<ItemStack> items;
    
    public static void initItemList() {
        for (final String name : new String[] { "FiskFille", "TheCodyMaverick", "Joebuz" }) {
            final ItemStack head = new ItemStack((Item)Item.itemRegistry.getObject("skull"), 1, 3);
            head.setTagCompound(new NBTTagCompound());
            head.getTagCompound().setString("SkullOwner", name);
            ItemDropHelper.items.add(head);
        }
        for (final Item item : Item.itemRegistry) {
            final ItemStack itemstack = new ItemStack(item);
            if (item != null) {
                try {
                    if (itemstack == null) {
                        continue;
                    }
                    ItemDropHelper.items.add(itemstack);
                }
                catch (Exception ex) {}
            }
        }
    }
    
    public static ArrayList<ItemStack> getItems() {
        return Utilities.getItemsWithRecipes();
    }
    
    static {
        ItemDropHelper.items = (ArrayList<ItemStack>)Lists.newArrayList();
    }
}
