package io.github.bennetrr.bedwarsplugin.definitions;

import io.github.bennetrr.bedwarsplugin.utils.ItemUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class VillagerTrades {
    public static List<ItemStack[]> getItemTraderTrades(NamedTextColor color) {
        List<ItemStack[]> itemTraderTrades = new ArrayList<>();
        // Section Blocks
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 4), new ItemStack(ItemUtils.coloredWool(color), 32)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 4), new ItemStack(Material.END_STONE, 16)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 24), new ItemStack(Material.OAK_PLANKS, 18)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 1), new ItemStack(Material.CRYING_OBSIDIAN, 2)});
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 4), new ItemStack(Material.LADDER, 16)});
        // Section Weapons
        {
            ItemStack sellItem = new ItemStack(Material.IRON_SWORD);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            sellItem.setItemMeta(itemMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 7), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            sellItem.setItemMeta(itemMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 3), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.IRON_CHESTPLATE);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Permanent Iron Armor").decoration(TextDecoration.ITALIC, State.FALSE));
            itemMeta.setUnbreakable(true);
            sellItem.setItemMeta(itemMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 12), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Permanent Diamond Armor").decoration(TextDecoration.ITALIC, State.FALSE));
            itemMeta.setUnbreakable(true);
            sellItem.setItemMeta(itemMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 6), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.BOW);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            sellItem.setItemMeta(itemMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 10), sellItem});
        }
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 1), new ItemStack(Material.ARROW, 8)});
        // Section Tools
        {
            ItemStack sellItem = new ItemStack(Material.SHEARS);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            sellItem.setItemMeta(itemMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 10), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.IRON_PICKAXE);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            sellItem.setItemMeta(itemMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 5), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            sellItem.setItemMeta(itemMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 5), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.IRON_AXE);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.setUnbreakable(true);
            sellItem.setItemMeta(itemMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, 6), sellItem});
        }
        // Section Potions
        {
            ItemStack sellItem = new ItemStack(Material.POTION);
            PotionMeta potionMeta = (PotionMeta) sellItem.getItemMeta();
            potionMeta.setBasePotionData(new PotionData(PotionType.INVISIBILITY, false, false));
            sellItem.setItemMeta(potionMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 1), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.POTION);
            PotionMeta potionMeta = (PotionMeta) sellItem.getItemMeta();
            potionMeta.setBasePotionData(new PotionData(PotionType.SPEED, false, true));
            sellItem.setItemMeta(potionMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 1), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.POTION);
            PotionMeta potionMeta = (PotionMeta) sellItem.getItemMeta();
            potionMeta.setBasePotionData(new PotionData(PotionType.JUMP, false, true));
            sellItem.setItemMeta(potionMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 1), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.SPLASH_POTION);
            PotionMeta potionMeta = (PotionMeta) sellItem.getItemMeta();
            potionMeta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL, false, true));
            sellItem.setItemMeta(potionMeta);
            itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.EMERALD, 1), sellItem});
        }
        // Section Miscellaneous
        itemTraderTrades.add(new ItemStack[]{new ItemStack(Material.IRON_INGOT, 3), new ItemStack(Material.COOKED_BEEF, 5)});
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
        {
            ItemStack sellItem = new ItemStack(Material.GOLDEN_SWORD, 1);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Strength Upgrade").decoration(TextDecoration.ITALIC, State.FALSE));
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("This upgrade gives each player in").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("your team the strength effect").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text(""));
            lore.add(Component.text("Level 1: Strength 1").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("Level 2: Strength 2").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            itemMeta.lore(lore);
            sellItem.setItemMeta(itemMeta);
            upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.DIAMOND, 8), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.GOLDEN_CARROT, 1);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Regeneration Upgrade").decoration(TextDecoration.ITALIC, State.FALSE));
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("This upgrade gives each player in").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("your team the regeneration effect").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text(""));
            lore.add(Component.text("Level 1: Regeneration 1").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            itemMeta.lore(lore);
            sellItem.setItemMeta(itemMeta);
            upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.DIAMOND, 3), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Protection Upgrade").decoration(TextDecoration.ITALIC, State.FALSE));
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("This upgrade gives each player in").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("your team the protection").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("enchantment on the armor").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text(""));
            lore.add(Component.text("Level 1: Protection 1").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("Level 2: Protection 2").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("Level 3: Protection 3").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("Level 4: Protection 4").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            itemMeta.lore(lore);
            sellItem.setItemMeta(itemMeta);
            upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.DIAMOND, 5), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.GOLDEN_PICKAXE, 1);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Haste Upgrade").decoration(TextDecoration.ITALIC, State.FALSE));
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("This upgrade gives each player in").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("your team the haste effect").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text(""));
            lore.add(Component.text("Level 1: Haste 1").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("Level 2: Haste 2").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            itemMeta.lore(lore);
            sellItem.setItemMeta(itemMeta);
            upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.DIAMOND, 4), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.DEEPSLATE_EMERALD_ORE, 1);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Spawner Upgrade").decoration(TextDecoration.ITALIC, State.FALSE));
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("This upgrade speeds up the spawner").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("on your island").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text(""));
            lore.add(Component.text("Level 0: Iron 0.5 items/s;      Gold 0.2 items/s").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("Level 1: Iron 0.75 items/s;    Gold 0.3 items/s").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("Level 2: Iron 1.0 items/s;      Gold 0.4 items/s").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("Level 3: Emeralds can spawn").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("Level 4: Iron 1.5 items/s;      Gold 0.6 items/s").color(NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, State.FALSE));
            itemMeta.lore(lore);
            sellItem.setItemMeta(itemMeta);
            upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.DIAMOND, 6), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.REDSTONE_TORCH, 1);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Alarm Trap").decoration(TextDecoration.ITALIC, State.FALSE));
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("This trap triggers an alarm when").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("a player from another team enters your island").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            itemMeta.lore(lore);
            sellItem.setItemMeta(itemMeta);
            upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.DIAMOND, 1), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.WOODEN_PICKAXE, 1);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Mining Fatigue Trap").decoration(TextDecoration.ITALIC, State.FALSE));
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("This trap triggers an alarm when").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("a player from another team enters your island").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("and gives the player the mining fatigue effect").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            itemMeta.lore(lore);
            sellItem.setItemMeta(itemMeta);
            upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.DIAMOND, 1), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.TRIPWIRE_HOOK, 1);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Counteroffensive Trap").decoration(TextDecoration.ITALIC, State.FALSE));
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("This trap triggers an alarm when").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("a player from another team enters your island").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("and gives the player the speed and jump boost").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("effects with very high levels").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            itemMeta.lore(lore);
            sellItem.setItemMeta(itemMeta);
            upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.DIAMOND, 1), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.OBSERVER, 1);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("Detection Trap").decoration(TextDecoration.ITALIC, State.FALSE));
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("This trap triggers an alarm when").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("a player from another team enters your island,").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("lets the player glow and removes").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("their invisibility effect").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            itemMeta.lore(lore);
            sellItem.setItemMeta(itemMeta);
            upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.DIAMOND, 1), sellItem});
        }
        {
            ItemStack sellItem = new ItemStack(Material.INK_SAC, 1);
            ItemMeta itemMeta = sellItem.getItemMeta();
            itemMeta.displayName(Component.text("It's a trap!").decoration(TextDecoration.ITALIC, State.FALSE));
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("This trap triggers an alarm when").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("a player from another team enters your island").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            lore.add(Component.text("and gives them the blindness and slowness effects").color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, State.FALSE));
            itemMeta.lore(lore);
            sellItem.setItemMeta(itemMeta);
            upgradeTraderTrades.add(new ItemStack[]{new ItemStack(Material.DIAMOND, 1), sellItem});
        }
        return upgradeTraderTrades;
    }

}
