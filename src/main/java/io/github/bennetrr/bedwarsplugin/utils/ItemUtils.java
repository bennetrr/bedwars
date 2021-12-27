package io.github.bennetrr.bedwarsplugin.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

public class ItemUtils {
    public static ItemStack itemStackWithName(Material material, int amount, String name) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.displayName(Component.text(name));
        item.setItemMeta(itemMeta);
        return item;
    }

    @Nullable
    public static Material coloredWool(NamedTextColor color) {
        if (color == NamedTextColor.DARK_RED) return Material.RED_WOOL;
        if (color == NamedTextColor.RED) return Material.PINK_WOOL;
        if (color == NamedTextColor.GOLD) return Material.ORANGE_WOOL;
        if (color == NamedTextColor.YELLOW) return Material.YELLOW_WOOL;
        if (color == NamedTextColor.DARK_GREEN) return Material.GREEN_WOOL;
        if (color == NamedTextColor.GREEN) return Material.LIME_WOOL;
        if (color == NamedTextColor.AQUA) return Material.LIGHT_BLUE_WOOL;
        if (color == NamedTextColor.DARK_AQUA) return Material.LIME_WOOL;
        if (color == NamedTextColor.DARK_BLUE) return Material.BLUE_WOOL;
        if (color == NamedTextColor.BLUE) return Material.BLUE_WOOL;
        if (color == NamedTextColor.LIGHT_PURPLE) return Material.MAGENTA_WOOL;
        if (color == NamedTextColor.DARK_PURPLE) return Material.PURPLE_WOOL;
        if (color == NamedTextColor.WHITE) return Material.WHITE_WOOL;
        if (color == NamedTextColor.GRAY) return Material.LIGHT_GRAY_WOOL;
        if (color == NamedTextColor.DARK_GRAY) return Material.GRAY_WOOL;
        if (color == NamedTextColor.BLACK) return Material.BLACK_WOOL;
        return null;
    }
}
