package io.github.bennetrr.bedwarsplugin.game_elements;

import io.github.bennetrr.bedwarsplugin.utils.ItemUtils;
import io.github.bennetrr.bedwarsplugin.utils.VillagerUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class VillagerTrades {
    // Buy1, Buy2, Sell
    private final List<ItemStack[]> itemTraderTrades;
    private final List<ItemStack[]> upgradeTraderTrades;

    public VillagerTrades() {
        // Section Blocks
        itemTraderTrades = new ArrayList<>();
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 4), null, new ItemStack(Material.WHITE_WOOL, 32)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 4), null, new ItemStack(Material.END_STONE, 16)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 24), null, new ItemStack(Material.OAK_PLANKS, 18)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 10), null, ItemUtils.itemStackWithName(Material.CYAN_STAINED_GLASS, 4, "Explosion proof glass")});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 1), null, new ItemStack(Material.CRYING_OBSIDIAN, 2)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 4), null, new ItemStack(Material.LADDER, 16)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 4), null, new ItemStack(Material.LADDER, 16)});
        // Section Weapons
        {
            ItemStack sellItem = new ItemStack(Material.IRON_SWORD);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 7), null, sellItem});
        }

        upgradeTraderTrades = new ArrayList<>();
        upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 4), null, new ItemStack(Material.WHITE_WOOL, 32)});
        upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 4), null, new ItemStack(Material.END_STONE, 16)});
    }

    public List<ItemStack[]> getItemTraderTrades() {
        return itemTraderTrades;
    }

    public List<ItemStack[]> getUpgradeTraderTrades() {
        return upgradeTraderTrades;
    }

}
