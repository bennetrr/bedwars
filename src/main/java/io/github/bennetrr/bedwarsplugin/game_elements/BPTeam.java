package io.github.bennetrr.bedwarsplugin.game_elements;

import io.github.bennetrr.bedwarsplugin.BedwarsPlugin;
import io.github.bennetrr.bedwarsplugin.definitions.VillagerTrades;
import io.github.bennetrr.bedwarsplugin.utils.LocationRelativizer;
import io.github.bennetrr.bedwarsplugin.utils.VillagerUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.*;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.Range;

import java.util.List;

import static io.github.bennetrr.bedwarsplugin.utils.ItemUtils.getUnbreakableItem;

public class BPTeam extends BPTeamTemplate {
    private final List<Player> players;
    private final Team team;
    private final Villager itemVillager, upgradeVillager;
    private final LocationRelativizer r;
    private final BedwarsPlugin plugin;

    private int ironTimerMax;
    private int goldTimerMax;
    private boolean eliminated = false;
    private int ironTimer;
    private int goldTimer;

    private @Range(from = 0, to = 2) int strengthUpgrade;
    private boolean regenUpgrade;
    private @Range(from = 0, to = 4) int protectionUpgrade;
    private @Range(from = 0, to = 2) int hasteUpgrade;
    private @Range(from = 0, to = 4) int spawnerUpgrade;

    public BPTeam(NamedTextColor color, String name, String fullName, Location bedLoc, Location itemVillagerLoc, Location upgradeVillagerLoc, Location spawnerLoc, Location spawnpoint, List<Player> players, Location mapStartLoc, Location mapPasteLoc) {
        super(color, name, fullName, bedLoc, itemVillagerLoc, upgradeVillagerLoc, spawnerLoc, spawnpoint);
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
        return new BPTeam(t.getColor(), t.getName(), t.getFullName(), t.getBedLoc(), t.getItemVillagerLoc(), t.getUpgradeVillagerLoc(), t.getSpawnerLoc(), t.getSpawnpoint(), players, mapStartLoc, mapPasteLoc);
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
                            ItemStack itemStack = getUnbreakableItem(Material.LEATHER_HELMET, 1);
                            LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
                            itemMeta.setColor(Color.fromRGB(color.value()));
                            itemStack.setItemMeta(itemMeta);
                            inventory.setHelmet(itemStack);
                        }
                        {
                            ItemStack itemStack = getUnbreakableItem(Material.LEATHER_CHESTPLATE, 1);
                            LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
                            itemMeta.setColor(Color.fromRGB(color.value()));
                            itemStack.setItemMeta(itemMeta);
                            inventory.setChestplate(itemStack);
                        }
                        {
                            ItemStack itemStack = getUnbreakableItem(Material.LEATHER_LEGGINGS, 1);
                            LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
                            itemMeta.setColor(Color.fromRGB(color.value()));
                            itemStack.setItemMeta(itemMeta);
                            inventory.setLeggings(itemStack);
                        }
                        {
                            ItemStack itemStack = getUnbreakableItem(Material.LEATHER_BOOTS, 1);
                            LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
                            itemMeta.setColor(Color.fromRGB(color.value()));
                            itemStack.setItemMeta(itemMeta);
                            inventory.setBoots(itemStack);
                        }
                    }
                }
                case "iron" -> {
                    if (inventory.getHelmet() == null || inventory.getChestplate() == null || inventory.getLeggings() == null || inventory.getBoots() == null || !inventory.getHelmet().getType().equals(Material.IRON_HELMET) || !inventory.getChestplate().getType().equals(Material.IRON_CHESTPLATE) || !inventory.getLeggings().getType().equals(Material.IRON_LEGGINGS) || !inventory.getBoots().getType().equals(Material.IRON_BOOTS)) {
                        inventory.setHelmet(getUnbreakableItem(Material.IRON_HELMET, 1));
                        inventory.setChestplate(getUnbreakableItem(Material.IRON_CHESTPLATE, 1));
                        inventory.setLeggings(getUnbreakableItem(Material.IRON_LEGGINGS, 1));
                        inventory.setBoots(getUnbreakableItem(Material.IRON_BOOTS, 1));
                    }
                }
                case "diamond" -> {
                    if (inventory.getHelmet() == null || inventory.getChestplate() == null || inventory.getLeggings() == null || inventory.getBoots() == null || !inventory.getHelmet().getType().equals(Material.DIAMOND_HELMET) || !inventory.getChestplate().getType().equals(Material.DIAMOND_CHESTPLATE) || !inventory.getLeggings().getType().equals(Material.DIAMOND_LEGGINGS) || !inventory.getBoots().getType().equals(Material.DIAMOND_BOOTS)) {
                        inventory.setHelmet(getUnbreakableItem(Material.DIAMOND_HELMET, 1));
                        inventory.setChestplate(getUnbreakableItem(Material.DIAMOND_CHESTPLATE, 1));
                        inventory.setLeggings(getUnbreakableItem(Material.DIAMOND_LEGGINGS, 1));
                        inventory.setBoots(getUnbreakableItem(Material.DIAMOND_BOOTS, 1));
                    }
                }
            }

            // Give default stone sword
            if (!inventory.contains(Material.STONE_SWORD) && !inventory.contains(Material.IRON_SWORD) && !inventory.contains(Material.DIAMOND_SWORD)) {
                inventory.addItem(getUnbreakableItem(Material.STONE_SWORD, 1));
            }
        }
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
    public Location getSpawnpoint() {
        return r.c(spawnpoint);
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

    public boolean isEliminated() {
        return eliminated;
    }

    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    public int getIronTimer() {
        return ironTimer;
    }

    public int getGoldTimer() {
        return goldTimer;
    }

    public int getStrengthUpgrade() {
        return strengthUpgrade;
    }

    public void setStrengthUpgrade(int strengthUpgrade) {
        this.strengthUpgrade = strengthUpgrade;
    }

    public boolean isRegenUpgrade() {
        return regenUpgrade;
    }

    public void setRegenUpgrade(boolean regenUpgrade) {
        this.regenUpgrade = regenUpgrade;
    }

    public int getProtectionUpgrade() {
        return protectionUpgrade;
    }

    public void setProtectionUpgrade(int protectionUpgrade) {
        this.protectionUpgrade = protectionUpgrade;
    }

    public int getHasteUpgrade() {
        return hasteUpgrade;
    }

    public void setHasteUpgrade(int hasteUpgrade) {
        this.hasteUpgrade = hasteUpgrade;
    }

    public int getSpawnerUpgrade() {
        return spawnerUpgrade;
    }

    public void setSpawnerUpgrade(int spawnerUpgrade) {
        this.spawnerUpgrade = spawnerUpgrade;
    }
}
