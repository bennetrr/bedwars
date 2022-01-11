package io.github.bennetrr.bedwarsplugin.game_elements;

import io.github.bennetrr.bedwarsplugin.BedwarsPlugin;
import io.github.bennetrr.bedwarsplugin.definitions.VillagerTrades;
import io.github.bennetrr.bedwarsplugin.traps.BPTrap;
import io.github.bennetrr.bedwarsplugin.utils.ItemUtils;
import io.github.bennetrr.bedwarsplugin.utils.LocationRelativizer;
import io.github.bennetrr.bedwarsplugin.utils.VillagerUtils;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Range;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static io.github.bennetrr.bedwarsplugin.utils.ItemUtils.getItem;

public class BPTeam extends BPTeamTemplate {
    private final static Enchantment PROTECTION = Enchantment.PROTECTION_ENVIRONMENTAL;
    private final List<Player> players;
    private final Team team;
    private final Villager itemVillager, upgradeVillager;
    private final LocationRelativizer r;
    private final BedwarsPlugin plugin;
    private final Queue<BPTrap> traps;
    private BPTrap activeTrap;
    private int ironTimerMax;
    private int goldTimerMax;
    private boolean bedDestroyed;
    private boolean eliminated;
    private int ironTimer;
    private int goldTimer;
    private @Range(from = 0, to = 2) int strengthUpgrade;
    private boolean regenUpgrade;
    private @Range(from = 0, to = 4) int protectionUpgrade;
    private @Range(from = 0, to = 2) int hasteUpgrade;
    private @Range(from = 0, to = 4) int spawnerUpgrade;

    public BPTeam(NamedTextColor color, String name, String fullName, Location bedLoc, Location itemVillagerLoc, Location upgradeVillagerLoc, Location spawnerLoc, Location spawnpoint, List<Player> players, Location mapStartLoc, Location mapPasteLoc, Location startLoc, Location endLoc) {
        super(color, name, fullName, bedLoc, itemVillagerLoc, upgradeVillagerLoc, spawnerLoc, spawnpoint, startLoc, endLoc);
        this.players = players;
        plugin = BedwarsPlugin.getPlugin(BedwarsPlugin.class);

        ironTimer = 40;
        ironTimerMax = 40;
        goldTimer = 100;
        goldTimerMax = 100;

        strengthUpgrade = 0;
        regenUpgrade = false;
        protectionUpgrade = 0;
        hasteUpgrade = 0;
        spawnerUpgrade = 0;
        bedDestroyed = false;
        eliminated = false;
        activeTrap = null;

        traps = new LinkedList<>();

        // Team for display in game
        team = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam(this.name);
        team.color(color);
        team.displayName(Component.text(this.fullName));
        team.prefix(Component.text("[" + this.fullName + "] "));

        // Making invisible teammates have a transparent body
        team.setCanSeeFriendlyInvisibles(true);

        // Add players to the team
        players.stream().map(HumanEntity::getName).forEach(team::addEntry);

        r = new LocationRelativizer(mapStartLoc, mapPasteLoc);

        // Spawn and prepare the villagers
        itemVillager = world.spawn(r.c(itemVillagerLoc), Villager.class, villager -> {
            villager.customName(Component.text("Items").color(color));
            VillagerUtils.setDump(villager);
            VillagerUtils.addTrades(villager, VillagerTrades.getItemTraderTrades(color));
        });

        upgradeVillager = world.spawn(r.c(upgradeVillagerLoc), Villager.class, villager -> {
            villager.customName(Component.text("Upgrades").color(color));
            VillagerUtils.setDump(villager);
            VillagerUtils.addTrades(villager, VillagerTrades.getUpgradeTraderTrades());
        });

        // Game modes, TP, Inventories
        for (Player player : players) {
            // Game modes
            player.setGameMode(GameMode.SURVIVAL);

            // TP
            player.teleport(r.c(spawnpoint));

            // Inventories
            player.getInventory().clear();
            player.getEnderChest().clear();

            // Effects
            player.getActivePotionEffects().stream().map(PotionEffect::getType).forEach(player::removePotionEffect);
        }
    }

    public static BPTeam fromTemplate(BPTeamTemplate t, List<Player> players, Location mapStartLoc, Location mapPasteLoc) {
        return new BPTeam(t.getColor(), t.getName(), t.getFullName(), t.getBedLoc(), t.getItemVillagerLoc(), t.getUpgradeVillagerLoc(), t.getSpawnerLoc(), t.getSpawnLoc(), players, mapStartLoc, mapPasteLoc, t.getStartLoc(), t.getEndLoc());
    }

    public void tickActions() {
        // Iron
        ironTimer++;
        if (ironTimer >= ironTimerMax) {
            ironTimer = 0;
            world.spawn(r.c(spawnerLoc, .5, .5), Item.class, item -> item.setItemStack(new ItemStack(Material.IRON_INGOT, 1)));
        }

        // Gold
        goldTimer++;
        if (goldTimer >= goldTimerMax) {
            goldTimer = 0;
            world.spawn(r.c(spawnerLoc, .5, .5), Item.class, item -> item.setItemStack(new ItemStack(Material.GOLD_INGOT, 1)));
        }

        for (Player player : players) {
            // Reset armor
            String armorType = plugin.getConfig().getString("players." + player.getUniqueId() + ".armorType", "leather");
            PlayerInventory inventory = player.getInventory();

            switch (armorType) {
                case "leather" -> {
                    if (inventory.getHelmet() == null || inventory.getChestplate() == null || inventory.getLeggings() == null || inventory.getBoots() == null || !inventory.getHelmet().getType().equals(Material.LEATHER_HELMET) || !inventory.getChestplate().getType().equals(Material.LEATHER_CHESTPLATE) || !inventory.getLeggings().getType().equals(Material.LEATHER_LEGGINGS) || !inventory.getBoots().getType().equals(Material.LEATHER_BOOTS)) {
                        {
                            ItemStack itemStack = getItem(Material.LEATHER_HELMET, 1, true, PROTECTION, protectionUpgrade);
                            LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
                            itemMeta.setColor(Color.fromRGB(color.value()));
                            itemStack.setItemMeta(itemMeta);
                            inventory.setHelmet(itemStack);
                        }
                        {
                            ItemStack itemStack = getItem(Material.LEATHER_CHESTPLATE, 1, true, PROTECTION, protectionUpgrade);
                            LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
                            itemMeta.setColor(Color.fromRGB(color.value()));
                            itemStack.setItemMeta(itemMeta);
                            inventory.setChestplate(itemStack);
                        }
                        {
                            ItemStack itemStack = getItem(Material.LEATHER_LEGGINGS, 1, true, PROTECTION, protectionUpgrade);
                            LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
                            itemMeta.setColor(Color.fromRGB(color.value()));
                            itemStack.setItemMeta(itemMeta);
                            inventory.setLeggings(itemStack);
                        }
                        {
                            ItemStack itemStack = getItem(Material.LEATHER_BOOTS, 1, true, PROTECTION, protectionUpgrade);
                            LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
                            itemMeta.setColor(Color.fromRGB(color.value()));
                            itemStack.setItemMeta(itemMeta);
                            inventory.setBoots(itemStack);
                        }
                    }
                }
                case "iron" -> {
                    if (inventory.getHelmet() == null || inventory.getChestplate() == null || inventory.getLeggings() == null || inventory.getBoots() == null || !inventory.getHelmet().getType().equals(Material.IRON_HELMET) || !inventory.getChestplate().getType().equals(Material.IRON_CHESTPLATE) || !inventory.getLeggings().getType().equals(Material.IRON_LEGGINGS) || !inventory.getBoots().getType().equals(Material.IRON_BOOTS)) {
                        inventory.setHelmet(getItem(Material.IRON_HELMET, 1, true, PROTECTION, protectionUpgrade));
                        inventory.setChestplate(getItem(Material.IRON_CHESTPLATE, 1, true, PROTECTION, protectionUpgrade));
                        inventory.setLeggings(getItem(Material.IRON_LEGGINGS, 1, true, PROTECTION, protectionUpgrade));
                        inventory.setBoots(getItem(Material.IRON_BOOTS, 1, true, PROTECTION, protectionUpgrade));
                    }
                }
                case "diamond" -> {
                    if (inventory.getHelmet() == null || inventory.getChestplate() == null || inventory.getLeggings() == null || inventory.getBoots() == null || !inventory.getHelmet().getType().equals(Material.DIAMOND_HELMET) || !inventory.getChestplate().getType().equals(Material.DIAMOND_CHESTPLATE) || !inventory.getLeggings().getType().equals(Material.DIAMOND_LEGGINGS) || !inventory.getBoots().getType().equals(Material.DIAMOND_BOOTS)) {
                        inventory.setHelmet(getItem(Material.DIAMOND_HELMET, 1, true, PROTECTION, protectionUpgrade));
                        inventory.setChestplate(getItem(Material.DIAMOND_CHESTPLATE, 1, true, PROTECTION, protectionUpgrade));
                        inventory.setLeggings(getItem(Material.DIAMOND_LEGGINGS, 1, true, PROTECTION, protectionUpgrade));
                        inventory.setBoots(getItem(Material.DIAMOND_BOOTS, 1, true, PROTECTION, protectionUpgrade));
                    }
                }
            }

            // Give default stone sword
            if (!inventory.contains(Material.STONE_SWORD) && !inventory.contains(Material.IRON_SWORD) && !inventory.contains(Material.DIAMOND_SWORD)) {
                inventory.addItem(getItem(Material.STONE_SWORD, 1, true));
            }

            // Apply effects
            switch (strengthUpgrade) {
                case 1 -> player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3, 0, false, false));
                case 2 -> player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3, 1, false, false));
            }

            if (regenUpgrade)
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 3, 0, false, false));

            switch (hasteUpgrade) {
                case 1 -> player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 3, 0, false, false));
                case 2 -> player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 3, 1, false, false));
            }
        }

        Vector startVector = new Vector(r.c(startLoc).getX(), 0, r.c(startLoc).getZ());
        Vector endVector = new Vector(r.c(endLoc).getX(), 0, r.c(endLoc).getZ());

        boolean playerInArea = false;

        // Traps
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            // If player is in this team, continue with the next player
            if (players.contains(player)) continue;

            // Check if the player is in the area of this team
            Vector playerVector = new Vector(player.getLocation().getX(), 0, player.getLocation().getZ());
            if (playerVector.isInAABB(startVector, endVector)) {
                // If there is no active trap and if there are available traps
                if (activeTrap == null && !traps.isEmpty()) {
                    activeTrap = traps.remove();
                    players.forEach(teamPlayer -> {
                        teamPlayer.sendMessage(Component.text("Your trap got triggered!").color(NamedTextColor.DARK_RED));
                        teamPlayer.playSound(Sound.sound(Key.key("minecraft:block.sculk_sensor.clicking"), Sound.Source.MASTER, 0.5F, 1));
                    });
                }
                activeTrap.action(player);
                playerInArea = true;
            }
        }
        if (!playerInArea) {
            activeTrap = null;
        }

        // Bed
        if (!world.getBlockAt(bedLoc).getType().equals(ItemUtils.coloredBeds(color)) && !bedDestroyed){
            bedDestroyed = true;
            players.forEach(teamPlayer -> {
                teamPlayer.sendMessage(Component.text("Your bed got destroyed!").color(NamedTextColor.DARK_RED));
                teamPlayer.playSound(Sound.sound(Key.key("minecraft:entity.ender_dragon.breathe"), Sound.Source.MASTER, 0.5F, 1));
            });
            plugin.getServer().getOnlinePlayers().stream().filter(player -> !players.contains(player)).forEach(player ->
                player.sendMessage(Component.text("The bed of " + fullName + "got destroyed!").color(color)));
        }

        // Eliminated
        if (players.stream().noneMatch(player -> player.getGameMode().equals(GameMode.SURVIVAL))) {
            eliminated = true;
            plugin.getServer().broadcast(Component.text(fullName + " is eliminated!").color(color));
        }
    }

    public void spawnEmeralds() {
        if (spawnerUpgrade > 2)
            world.spawn(r.c(spawnerLoc, .5, .5), Item.class, item -> item.setItemStack(new ItemStack(Material.EMERALD, 1)));
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public Location getBedLoc() {
        return r.c(bedLoc);
    }

    @Override
    public Location getItemVillagerLoc() {
        return r.c(itemVillagerLoc);
    }

    @Override
    public Location getUpgradeVillagerLoc() {
        return r.c(upgradeVillagerLoc);
    }

    @Override
    public Location getSpawnerLoc() {
        return r.c(spawnerLoc);
    }

    @Override
    public Location getSpawnLoc() {
        return r.c(spawnLoc);
    }

    public Team getTeam() {
        return team;
    }

    public Villager getItemVillager() {
        return itemVillager;
    }

    public Villager getUpgradeVillager() {
        return upgradeVillager;
    }

    public int getIronTimerMax() {
        return ironTimerMax;
    }

    public void setIronTimerMax(int ironTimerMax) {
        this.ironTimerMax = ironTimerMax;
    }

    public int getGoldTimerMax() {
        return goldTimerMax;
    }

    public void setGoldTimerMax(int goldTimerMax) {
        this.goldTimerMax = goldTimerMax;
    }

    public boolean isBedDestroyed() {
        return bedDestroyed;
    }

    public void setBedDestroyed(boolean bedDestroyed) {
        this.bedDestroyed = bedDestroyed;
    }

    public int getIronTimer() {
        return ironTimer;
    }

    public int getGoldTimer() {
        return goldTimer;
    }

    public @Range(from = 0, to = 2) int getStrengthUpgrade() {
        return strengthUpgrade;
    }

    public void setStrengthUpgrade(@Range(from = 0, to = 2) int strengthUpgrade) {
        this.strengthUpgrade = strengthUpgrade;
    }

    public boolean hasRegenUpgrade() {
        return regenUpgrade;
    }

    public void setRegenUpgrade(boolean regenUpgrade) {
        this.regenUpgrade = regenUpgrade;
    }

    public @Range(from = 0, to = 4) int getProtectionUpgrade() {
        return protectionUpgrade;
    }

    public void setProtectionUpgrade(@Range(from = 0, to = 4) int protectionUpgrade) {
        this.protectionUpgrade = protectionUpgrade;
    }

    public @Range(from = 0, to = 2) int getHasteUpgrade() {
        return hasteUpgrade;
    }

    public void setHasteUpgrade(@Range(from = 0, to = 2) int hasteUpgrade) {
        this.hasteUpgrade = hasteUpgrade;
    }

    public @Range(from = 0, to = 4) int getSpawnerUpgrade() {
        return spawnerUpgrade;
    }

    public void setSpawnerUpgrade(@Range(from = 0, to = 4) int spawnerUpgrade) {
        this.spawnerUpgrade = spawnerUpgrade;
    }

    public List<? extends BPTrap> getTraps() {
        return traps.stream().toList();
    }

    public void addTrap(BPTrap trap) {
        traps.add(trap);
    }

    public boolean isEliminated() {
        return eliminated;
    }
}
