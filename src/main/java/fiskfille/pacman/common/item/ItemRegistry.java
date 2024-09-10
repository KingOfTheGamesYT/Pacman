package fiskfille.pacman.common.item;

import net.minecraft.item.*;
import cpw.mods.fml.common.registry.*;

public class ItemRegistry
{
    public static void registerItem(final Item item, String name) {
        name = trim(name);
        item.setUnlocalizedName(name);
        item.setTextureName(name);
        GameRegistry.registerItem(item, name);
    }
    
    public static String trim(String s) {
        s = s.replace(" ", "_");
        s = s.replace("'", "");
        s = s.toLowerCase();
        return s;
    }
}
