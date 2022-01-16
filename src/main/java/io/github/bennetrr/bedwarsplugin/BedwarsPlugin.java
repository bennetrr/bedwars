package io.github.bennetrr.bedwarsplugin;

import cloud.commandframework.CommandTree;
import cloud.commandframework.annotations.AnnotationParser;
import cloud.commandframework.annotations.CommandDescription;
import cloud.commandframework.annotations.CommandMethod;
import cloud.commandframework.arguments.parser.ParserParameters;
import cloud.commandframework.arguments.parser.StandardParameters;
import cloud.commandframework.bukkit.BukkitCommandManager;
import cloud.commandframework.bukkit.CloudBukkitCapabilities;
import cloud.commandframework.execution.AsynchronousCommandExecutionCoordinator;
import cloud.commandframework.execution.CommandExecutionCoordinator;
import cloud.commandframework.meta.CommandMeta;
import cloud.commandframework.paper.PaperCommandManager;
import io.github.bennetrr.bedwarsplugin.definitions.Maps;
import io.github.bennetrr.bedwarsplugin.game_elements.*;
import io.github.bennetrr.bedwarsplugin.handlers.*;
import io.github.bennetrr.bedwarsplugin.utils.WorldEditStuff;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Team;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;


public class BedwarsPlugin extends JavaPlugin {
    private BPMap map;
    private Location spawnLoc;
    private Location mapPasteLoc;
    private Location spectatingTeamSpawnpoint;
    private BPGame game = null;
    private World w;

    private BukkitCommandManager<CommandSender> manager;
    private AnnotationParser<CommandSender> annotationParser;

    public void log(Object msg) {
        getServer().getLogger().info("[BedwarsPlugin] " + msg.toString());
    }

    public void log(String module, Object msg) {
        getServer().getLogger().info("[BedwarsPlugin / " + module + "] " + msg.toString());
    }

    @Override
    public void onEnable() {
        // Commands
        final Function<CommandTree<CommandSender>, CommandExecutionCoordinator<CommandSender>> executionCoordinatorFunction = AsynchronousCommandExecutionCoordinator.<CommandSender>newBuilder().build();

        // Get the command manager
        try {
            this.manager = new PaperCommandManager<>(this, executionCoordinatorFunction, Function.identity(), Function.identity());
        } catch (Exception e) {
            log("Failed to initialize the command manager");
            log("Disabling...");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Register Brigadier mappings
        if (this.manager.queryCapability(CloudBukkitCapabilities.BRIGADIER)) {
            this.manager.registerBrigadier();
        }

        // Register asynchronous completions
        if (this.manager.queryCapability(CloudBukkitCapabilities.ASYNCHRONOUS_COMPLETION)) {
            ((PaperCommandManager<CommandSender>) this.manager).registerAsynchronousCompletions();
        }

        // Create the annotation parser
        final Function<ParserParameters, CommandMeta> commandMetaFunction = p -> CommandMeta.simple().with(CommandMeta.DESCRIPTION, p.get(StandardParameters.DESCRIPTION, "No description")).build();
        this.annotationParser = new AnnotationParser<>(this.manager, CommandSender.class, commandMetaFunction);


        // Parse all @CommandMethod-annotated methods
        this.annotationParser.parse(this);

        // Locations and maps
        w = getServer().getWorlds().get(0);
        spawnLoc = new Location(w, 999, 43, 7);
        mapPasteLoc = new Location(w, 608, 50, -144);
        spectatingTeamSpawnpoint = new Location(w, 700, 65, -40);
        map = Maps.getMap(w, mapPasteLoc, this);

        // Do a reset
        reset();

        // Set the servers spawnpoint
        getServer().setSpawnRadius(0);
        getServer().getWorlds().get(0).setSpawnLocation(spawnLoc);

        // Register event handlers
        getServer().getPluginManager().registerEvents(new BlockProtection(), this);
        getServer().getPluginManager().registerEvents(new Explosives(), this);
        getServer().getPluginManager().registerEvents(new CraftingProtection(), this);
        getServer().getPluginManager().registerEvents(new LoginHandler(this), this);
        getServer().getPluginManager().registerEvents(new DeathHandler(this), this);
        getServer().getPluginManager().registerEvents(new TradeHandler(this), this);

        // Register the tick actions
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            if (game == null) {
                // Pre-game loop
                for (Player player : getServer().getOnlinePlayers()) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 3, 265, false, false));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 3, 265, false, false));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 3, 265, false, false));
                }
            } else {
                // During-game loop
                game.tickActions(getServer());
            }

            w.getEntitiesByClass(Item.class).stream().filter(item -> item.getItemStack().getType().name().toLowerCase().contains("helmet") || item.getItemStack().getType().name().toLowerCase().contains("chestplate") || item.getItemStack().getType().name().toLowerCase().contains("legging") || item.getItemStack().getType().name().toLowerCase().contains("boots") || item.getItemStack().getType().name().toLowerCase().contains("bed") || item.getItemStack().getType().equals(Material.STONE_SWORD)).forEach(Entity::remove);
        }, 1L, 1L);
    }

    @CommandMethod("start")
    @CommandDescription("Start a new bedwars game")
    private void startCommand(@NonNull CommandSender sender) {
        getServer().broadcast(Component.text("Starting a game!"));
        // Reset and copy the map
        reset();
        WorldEditStuff.clearMap(mapPasteLoc);
        map.copyMap();

        // Get and check the values
        int maxPlayersTeam1 = getConfig().getInt("maxplayer.team1");
        int maxPlayersTeam2 = getConfig().getInt("maxplayer.team2");
        int maxPlayersTeam3 = getConfig().getInt("maxplayer.team3");
        int maxPlayersTeam4 = getConfig().getInt("maxplayer.team4");

        if (maxPlayersTeam1 < 1 || maxPlayersTeam1 > 6 || maxPlayersTeam2 < 0 || maxPlayersTeam2 > 6 || maxPlayersTeam3 < 0 || maxPlayersTeam3 > 6 || maxPlayersTeam4 < 0 || maxPlayersTeam4 > 6) {
            getServer().broadcast(Component.text("Failed to start a game").color(NamedTextColor.RED));
            sender.sendMessage(Component.text("The maximum number of players per team is not set or set incorrectly").color(NamedTextColor.RED));
            sender.sendMessage(Component.text("Please use the /bedwars config command").color(NamedTextColor.RED));
            return;
        }

        List<Player> playerList = new ArrayList<>(getServer().getOnlinePlayers());
        int playerCount = playerList.size();
        if (playerCount <= 0) {
            getServer().broadcast(Component.text("Failed to start a game").color(NamedTextColor.RED));
            sender.sendMessage(Component.text("There are no players online").color(NamedTextColor.RED));
            return;
        }

        if ((maxPlayersTeam1 + maxPlayersTeam2 + maxPlayersTeam3 + maxPlayersTeam4) != playerCount) {
            getServer().broadcast(Component.text("Failed to start a game").color(NamedTextColor.RED));
            sender.sendMessage(Component.text("The maximum number of players per team is set incorrectly").color(NamedTextColor.RED));
            sender.sendMessage(Component.text("Please use the /bedwars config command").color(NamedTextColor.RED));
            return;
        }

        List<Integer> maxPlayersPerTeams = new ArrayList<>();
        maxPlayersPerTeams.add(maxPlayersTeam1);
        if (maxPlayersTeam2 > 0) maxPlayersPerTeams.add(maxPlayersTeam2);
        if (maxPlayersTeam3 > 0) maxPlayersPerTeams.add(maxPlayersTeam3);
        if (maxPlayersTeam4 > 0) maxPlayersPerTeams.add(maxPlayersTeam4);

        List<BPTeam> teams = new ArrayList<>();

        for (int i = 0; i < maxPlayersPerTeams.size(); i++) {
            BPTeamTemplate template = map.getTeams().get(i);
            List<Player> players = new ArrayList<>();

            for (int j = 0; j < maxPlayersPerTeams.get(i); j++) {
                Random rand = new Random();
                players.add(playerList.remove(rand.nextInt(playerList.size())));
            }

            teams.add(BPTeam.fromTemplate(template, players, map.getStartLoc(), mapPasteLoc));
        }

        game = new BPGame(map, teams, new BPSpectatingTeam(spectatingTeamSpawnpoint, playerList), this);
    }

    public void stopGame() {
        getServer().broadcast(Component.text("Stopping the game..."));
        reset();
    }

    public void reset() {
        game = null;

        // TP
        for (Player player : getServer().getOnlinePlayers()) {
            resetPlayer(player);

            player.setGameMode(GameMode.ADVENTURE);
            player.teleport(spawnLoc);
        }
        // Delete items and other entities
        w.getEntitiesByClass(Item.class).forEach(Entity::remove);
        w.getEntitiesByClass(Villager.class).forEach(Entity::remove);

        // Remove teams
        Bukkit.getScoreboardManager().getMainScoreboard().getTeams().forEach(Team::unregister);
    }

    public void resetPlayer(Player player) {
        player.getInventory().clear();
        player.getEnderChest().clear();
        player.getActivePotionEffects().stream().map(PotionEffect::getType).forEach(player::removePotionEffect);
    }

    public boolean isGameRunning() {
        return game != null;
    }

    public Location getSpawnLoc() {
        return spawnLoc;
    }

    public BPGame getGame() {
        return game;
    }
}
