package io.github.bennetrr.bedwarsplugin.handlers;

import io.github.bennetrr.bedwarsplugin.BedwarsPlugin;
import io.github.bennetrr.bedwarsplugin.game_elements.BPTeam;
import io.github.bennetrr.bedwarsplugin.traps.*;
import io.github.bennetrr.bedwarsplugin.utils.ItemUtils;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.PlayerInventory;

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
        for (int slot = 0; slot < inventory.getSize(); slot++) {
            ItemStack itemStack = inventory.getItem(slot);
            if (itemStack == null) continue;

            // Permanent Iron Armor
            if (itemStack.getType().equals(Material.IRON_CHESTPLATE)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;

                if (displayName.equalsIgnoreCase("permanent iron armor")) {
                    String armorType = plugin.getGame().getArmorType(player);
                    if (armorType.equals("leather")) {
                        player.sendMessage(Component.text("You bought permanent iron armor"));
                        player.playSound(Sound.sound(Key.key("minecraft:entity.experience_orb.pickup"), Sound.Source.MASTER, 0.5F, 1));
                        plugin.getGame().setArmorType(player, "iron");
                    } else {
                        player.sendMessage(Component.text("You already bought this or a better upgrade!").color(NamedTextColor.RED));
                        player.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 12));
                    }
                    inventory.setItem(slot, null);
                }
            }

            // Permanent Diamond Armor
            else if (itemStack.getType().equals(Material.DIAMOND_CHESTPLATE)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;

                if (displayName.equalsIgnoreCase("permanent diamond armor")) {
                    String armorType = plugin.getGame().getArmorType(player);
                    if (armorType.equals("leather") || armorType.equals("iron")) {
                        player.sendMessage(Component.text("You bought permanent diamond armor"));
                        player.playSound(Sound.sound(Key.key("minecraft:entity.experience_orb.pickup"), Sound.Source.MASTER, 0.5F, 1));
                        plugin.getGame().setArmorType(player, "diamond");
                    } else {
                        player.sendMessage(Component.text("You already bought this upgrade!").color(NamedTextColor.RED));
                        player.getInventory().addItem(new ItemStack(Material.EMERALD, 6));
                    }
                    inventory.setItem(slot, null);
                }
            }

            // Strength Upgrade
            else if (itemStack.getType().equals(Material.GOLDEN_SWORD)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;

                if (displayName.equalsIgnoreCase("strength upgrade")) {
                    // Get the players team
                    BPTeam team = plugin.getGame().getTeamForPlayer(player);
                    if (team == null) return;

                    if (team.getStrengthUpgrade() >= 2) {
                        player.sendMessage(Component.text("You already bought this upgrade!").color(NamedTextColor.RED));
                        player.getInventory().addItem(new ItemStack(Material.DIAMOND, 8));
                    } else {
                        team.setStrengthUpgrade(team.getStrengthUpgrade() + 1);
                        team.getPlayers().forEach(p -> {
                            p.sendMessage(Component.text("You bought a strength upgrade level " + team.getStrengthUpgrade() + "!"));
                            p.playSound(Sound.sound(Key.key("minecraft:entity.experience_orb.pickup"), Sound.Source.MASTER, 0.5F, 1));
                        });
                    }
                    inventory.setItem(slot, null);
                }
            }

            // Regeneration Upgrade
            else if (itemStack.getType().equals(Material.GOLDEN_CARROT)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;

                if (displayName.equalsIgnoreCase("regeneration upgrade")) {
                    // Get the players team
                    BPTeam team = plugin.getGame().getTeamForPlayer(player);
                    if (team == null) continue;

                    if (team.hasRegenUpgrade()) {
                        player.sendMessage(Component.text("You already bought this upgrade!"));
                        player.getInventory().addItem(new ItemStack(Material.DIAMOND, 3));
                    } else {
                        team.setRegenUpgrade(true);
                        team.getPlayers().forEach(p -> {
                            p.sendMessage(Component.text("You bought a regeneration upgrade!"));
                            p.playSound(Sound.sound(Key.key("minecraft:entity.experience_orb.pickup"), Sound.Source.MASTER, 0.5F, 1));
                        });
                    }
                    inventory.setItem(slot, null);
                }
            }

            // Protection Upgrade
            else if (itemStack.getType().equals(Material.CHAINMAIL_CHESTPLATE)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;

                if (displayName.equalsIgnoreCase("protection upgrade")) {
                    // Get the players team
                    BPTeam team = plugin.getGame().getTeamForPlayer(player);
                    if (team == null) continue;

                    if (team.getProtectionUpgrade() >= 4) {
                        player.sendMessage(Component.text("You already bought this upgrade!").color(NamedTextColor.RED));
                        player.getInventory().addItem(new ItemStack(Material.DIAMOND, 5));
                    } else {
                        team.setProtectionUpgrade(team.getProtectionUpgrade() + 1);
                        team.getPlayers().forEach(p -> {
                            p.sendMessage(Component.text("You bought a protection upgrade level " + team.getProtectionUpgrade() + "!"));
                            p.playSound(Sound.sound(Key.key("minecraft:entity.experience_orb.pickup"), Sound.Source.MASTER, 0.5F, 1));
                            p.getInventory().setBoots(null);
                        });
                    }
                    inventory.setItem(slot, null);
                }
            }

            // Haste Upgrade
            else if (itemStack.getType().equals(Material.GOLDEN_PICKAXE)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;

                if (displayName.equalsIgnoreCase("haste upgrade")) {
                    // Get the players team
                    BPTeam team = plugin.getGame().getTeamForPlayer(player);
                    if (team == null) continue;

                    if (team.getHasteUpgrade() >= 2) {
                        player.sendMessage(Component.text("You already bought this upgrade!").color(NamedTextColor.RED));
                        player.getInventory().addItem(new ItemStack(Material.DIAMOND, 4));
                    } else {
                        team.setHasteUpgrade(team.getHasteUpgrade() + 1);
                        team.getPlayers().forEach(p -> {
                            p.sendMessage(Component.text("You bought a haste upgrade level " + team.getHasteUpgrade() + "!"));
                            p.playSound(Sound.sound(Key.key("minecraft:entity.experience_orb.pickup"), Sound.Source.MASTER, 0.5F, 1));
                        });
                    }
                    inventory.setItem(slot, null);
                }
            }

            // Spawner Upgrade
            else if (itemStack.getType().equals(Material.DEEPSLATE_EMERALD_ORE)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;

                if (displayName.equalsIgnoreCase("spawner upgrade")) {
                    // Get the players team
                    BPTeam team = plugin.getGame().getTeamForPlayer(player);
                    if (team == null) continue;

                    for (int i = 0; i < itemStack.getAmount(); i++) {
                        if (team.getSpawnerUpgrade() >= 4) {
                            player.sendMessage(Component.text("You already bought this upgrade!").color(NamedTextColor.RED));
                            player.getInventory().addItem(new ItemStack(Material.DIAMOND, 6));
                        } else {
                            team.setSpawnerUpgrade(team.getSpawnerUpgrade() + 1);
                            team.getPlayers().forEach(p -> {
                                p.sendMessage(Component.text("You bought a spawner upgrade level " + team.getSpawnerUpgrade() + "!"));
                                p.playSound(Sound.sound(Key.key("minecraft:entity.experience_orb.pickup"), Sound.Source.MASTER, 0.5F, 1));
                            });

                            switch (team.getSpawnerUpgrade()) {
                                case 1 -> {
                                    team.setIronTimerMax(27);
                                    team.setGoldTimerMax(67);
                                }
                                case 2 -> {
                                    team.setIronTimerMax(20);
                                    team.setGoldTimerMax(50);
                                }
                                case 4 -> {
                                    team.setIronTimerMax(13);
                                    team.setGoldTimerMax(33);
                                }
                            }
                        }
                    }
                    inventory.setItem(slot, null);
                }
            }

            // Alarm Trap
            else if (itemStack.getType().equals(Material.REDSTONE_TORCH)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;

                if (displayName.equalsIgnoreCase("alarm trap")) {
                    // Get the players team
                    BPTeam team = plugin.getGame().getTeamForPlayer(player);
                    if (team == null) continue;

                    for (int i = 0; i < itemStack.getAmount(); i++) {
                        team.addTrap(new AlarmTrap());
                        team.getPlayers().forEach(p -> {
                            p.sendMessage(Component.text("You bought a alarm trap!"));
                            p.playSound(Sound.sound(Key.key("minecraft:entity.experience_orb.pickup"), Sound.Source.MASTER, 0.5F, 1));
                        });
                    }
                    inventory.setItem(slot, null);
                }
            }

            // Mining Fatigue Trap
            else if (itemStack.getType().equals(Material.WOODEN_PICKAXE)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;

                if (displayName.equalsIgnoreCase("mining fatigue trap")) {
                    // Get the players team
                    BPTeam team = plugin.getGame().getTeamForPlayer(player);
                    if (team == null) continue;

                    team.addTrap(new MiningFatigueTrap());
                    team.getPlayers().forEach(p -> {
                        p.sendMessage(Component.text("You bought a mining fatigue trap!"));
                        p.playSound(Sound.sound(Key.key("minecraft:entity.experience_orb.pickup"), Sound.Source.MASTER, 0.5F, 1));
                    });

                    inventory.setItem(slot, null);
                }
            }

            // Counteroffensive Trap
            else if (itemStack.getType().equals(Material.TRIPWIRE_HOOK)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;
                // Get the players team
                BPTeam team = plugin.getGame().getTeamForPlayer(player);
                if (team == null) continue;

                if (displayName.equalsIgnoreCase("counteroffensive trap")) {
                    for (int i = 0; i < itemStack.getAmount(); i++) {
                        team.addTrap(new CounteroffensiveTrap());
                        team.getPlayers().forEach(p -> {
                            p.sendMessage(Component.text("You bought a counteroffensive trap!"));
                            p.playSound(Sound.sound(Key.key("minecraft:entity.experience_orb.pickup"), Sound.Source.MASTER, 0.5F, 1));
                        });
                    }
                    inventory.setItem(slot, null);
                }
            }

            // Detection Trap
            else if (itemStack.getType().equals(Material.OBSERVER)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;
                // Get the players team
                BPTeam team = plugin.getGame().getTeamForPlayer(player);
                if (team == null) continue;

                if (displayName.equalsIgnoreCase("detection trap")) {
                    for (int i = 0; i < itemStack.getAmount(); i++) {
                        team.addTrap(new DetectionTrap());
                        team.getPlayers().forEach(p -> {
                            p.sendMessage(Component.text("You bought a detection trap!"));
                            p.playSound(Sound.sound(Key.key("minecraft:entity.experience_orb.pickup"), Sound.Source.MASTER, 0.5F, 1));
                        });
                    }
                    inventory.setItem(slot, null);
                }
            }

            // It's a trap
            else if (itemStack.getType().equals(Material.INK_SAC)) {
                String displayName = ItemUtils.getDisplayName(itemStack);
                if (displayName == null) continue;
                // Get the players team
                BPTeam team = plugin.getGame().getTeamForPlayer(player);
                if (team == null) continue;

                if (displayName.equals("It's a trap!")) {
                    for (int i = 0; i < itemStack.getAmount(); i++) {
                        team.addTrap(new ItsATrap());
                        team.getPlayers().forEach(p -> {
                            p.sendMessage(Component.text("You bought It's a trap!"));
                            p.playSound(Sound.sound(Key.key("minecraft:entity.experience_orb.pickup"), Sound.Source.MASTER, 0.5F, 1));
                        });
                    }
                    inventory.setItem(slot, null);
                }
            }
        }
    }
}
