package io.github.bennetrr.bedwarsplugin.game_elements;

import io.github.bennetrr.bedwarsplugin.utils.ItemUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class VillagerTrades {
    public static List<ItemStack[]> getItemTraderTrades() {
        List<ItemStack[]> itemTraderTrades = new ArrayList<>();
        // Section Blocks
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 4), new ItemStack(Material.WHITE_WOOL, 32)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 4), new ItemStack(Material.END_STONE, 16)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 24), new ItemStack(Material.OAK_PLANKS, 18)});
        // TODO: Possible?
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 10), ItemUtils.itemStackWithName(Material.CYAN_STAINED_GLASS, 4, "Explosion proof glass")});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 1), new ItemStack(Material.CRYING_OBSIDIAN, 2)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 4), new ItemStack(Material.LADDER, 16)});
        // Section Weapons
        {
            ItemStack sellItem = new ItemStack(Material.IRON_SWORD);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 7), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 3), sellItem});
        }
        // TODO: Add actions
        {
            ItemStack sellItem = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Permanent Iron Armor"));
            itemMeta.setUnbreakable(true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 12), sellItem});
        }
        // TODO: Add actions
        {
            ItemStack sellItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Permanent Diamond Armor"));
            itemMeta.setUnbreakable(true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 6), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.SHIELD);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 20), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.BOW);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 10), sellItem});
        }
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 1), new ItemStack(Material.ARROW, 8)});
        // Section Tools
        {
            ItemStack sellItem = new ItemStack(Material.SHEARS);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 10), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.IRON_PICKAXE);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 5), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 5), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.IRON_AXE);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 6), sellItem});
        }
        // Section Potions
        // TODO: Add potion colors and names
        {
            ItemStack sellItem = new ItemStack(Material.POTION);
            PotionMeta potionMeta = (PotionMeta) sellItem.getItemMeta();
            potionMeta.addCustomEffect(PotionType.INVISIBILITY.getEffectType().createEffect(3600, 1), true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 1), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.POTION);
            PotionMeta potionMeta = (PotionMeta) sellItem.getItemMeta();
            potionMeta.addCustomEffect(PotionType.SPEED.getEffectType().createEffect(1800, 2), true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 1), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.POTION);
            PotionMeta potionMeta = (PotionMeta) sellItem.getItemMeta();
            potionMeta.addCustomEffect(PotionType.JUMP.getEffectType().createEffect(1800, 2), true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 1), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.SPLASH_POTION);
            PotionMeta potionMeta = (PotionMeta) sellItem.getItemMeta();
            potionMeta.addCustomEffect(PotionType.INSTANT_HEAL.getEffectType().createEffect(1, 2), true);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 1), sellItem});
        }
        // Section Miscellaneous
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 3), new ItemStack(Material.GOLDEN_APPLE, 1)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 20), new ItemStack(Material.WATER_BUCKET, 1)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 10), new ItemStack(Material.LAVA_BUCKET, 1)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 10), new ItemStack(Material.FIRE_CHARGE, 1)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 7), new ItemStack(Material.ENDER_PEARL, 1)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 8), new ItemStack(Material.TNT, 1)});
        return itemTraderTrades;
    }

    public static List<ItemStack[]> getUpgradeTraderTrades() {
        List<ItemStack[]> upgradeTraderTrades = new ArrayList<>();
        // Section Upgrades
        // TODO: Add upgrades and traps
        upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.BARRIER, 1), new ItemStack(Material.BARRIER, 1)});
        return upgradeTraderTrades;
    }

}
