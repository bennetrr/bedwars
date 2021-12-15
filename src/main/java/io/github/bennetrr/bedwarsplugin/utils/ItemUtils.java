package io.github.bennetrr.bedwarsplugin.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {
    public static ItemStack itemStackWithName(Material material, int amount, String name) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.displayName(Component.text(name));
        item.setItemMeta(itemMeta);
        return item;
    }
}
