package io.github.bennetrr.bedwarsplugin.handlers;

import io.github.bennetrr.bedwarsplugin.BedwarsPlugin;
import io.github.bennetrr.bedwarsplugin.utils.ItemUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.Nullable;

public class TradeHandler implements Listener {
    private final BedwarsPlugin plugin;

    public TradeHandler(BedwarsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onVillagerGUIClose(InventoryCloseEvent event) {
        // If no game is running, quit
        if (!plugin.isGameRunning()) return;

        // If the GUI is not a villager GUI, quit
        if (!(event.getInventory() instanceof MerchantInventory)) return;

        // Check if the sender is a player
        if (!(event.getPlayer() instanceof Player player)) return;

        PlayerInventory inventory = player.getInventory();

        // Iterate through all items of the player who closed the GUI
        for (@Nullable ItemStack itemStack : inventory) {
            if (itemStack == null) continue;

            // Permanent Iron Armor
            if (itemStack.getType().equals(Material.IRON_CHESTPLATE)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;

                if (displayName.equalsIgnoreCase("permanent iron armor")) {
                    String armorType = plugin.getConfig().getString("players." + player.getUniqueId() + ".armorType", "leather");
                    if (armorType.equals("leather")) {
                        player.sendMessage(Component.text("You bought permanent Iron Armor"));
                        inventory.remove(itemStack);

                        plugin.getConfig().set("players." + player.getUniqueId() + ".armorType", "iron");
                        inventory.setHelmet(ItemUtils.getUnbreakableItem(Material.IRON_HELMET, 1));
                        inventory.setChestplate(ItemUtils.getUnbreakableItem(Material.IRON_CHESTPLATE, 1));
                        inventory.setLeggings(ItemUtils.getUnbreakableItem(Material.IRON_LEGGINGS, 1));
                        inventory.setBoots(ItemUtils.getUnbreakableItem(Material.IRON_BOOTS, 1));
                    } else {
                        player.sendMessage(Component.text("You already bought this or a better upgrade!"));
                    }
                }
            }

            // Permanent Diamond Armor
            else if (itemStack.getType().equals(Material.DIAMOND_CHESTPLATE)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;

                if (displayName.equalsIgnoreCase("permanent diamond armor")) {
                    String armorType = plugin.getConfig().getString("players." + player.getUniqueId() + ".armorType", "leather");
                    if (armorType.equals("leather") || armorType.equals("iron")) {
                        player.sendMessage(Component.text("You bought permanent Diamond Armor"));
                        inventory.remove(itemStack);

                        plugin.getConfig().set("players." + player.getUniqueId() + ".armorType", "diamond");
                        inventory.setHelmet(ItemUtils.getUnbreakableItem(Material.DIAMOND_HELMET, 1));
                        inventory.setChestplate(ItemUtils.getUnbreakableItem(Material.DIAMOND_CHESTPLATE, 1));
                        inventory.setLeggings(ItemUtils.getUnbreakableItem(Material.DIAMOND_LEGGINGS, 1));
                        inventory.setBoots(ItemUtils.getUnbreakableItem(Material.DIAMOND_BOOTS, 1));
                    } else {
                        player.sendMessage(Component.text("You already bought this upgrade!"));
                    }
                }
            }
//            // Get the players team
//            BPTeam team = plugin.getGame().getTeamForPlayer(player);
//            if (team == null) return;
//
//            team.
        }
    }
}
