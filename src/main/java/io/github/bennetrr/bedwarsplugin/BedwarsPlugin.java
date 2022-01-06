package io.github.bennetrr.bedwarsplugin;

import io.github.bennetrr.bedwarsplugin.definitions.Maps;
import io.github.bennetrr.bedwarsplugin.exceptions.NotEnoughPlayersException;
import io.github.bennetrr.bedwarsplugin.exceptions.WrongCommandArgumentsException;
import io.github.bennetrr.bedwarsplugin.game_elements.*;
import io.github.bennetrr.bedwarsplugin.handlers.*;
import io.github.bennetrr.bedwarsplugin.utils.WorldEditStuff;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BedwarsPlugin extends JavaPlugin {
    private BPMap map;
    private Location spawnLoc;
    private Location mapPasteLoc;
    private Location spectatingTeamSpawnpoint;
    private BPGame game = null;
    private World w;

    public void log(Object msg) {
        getServer().getLogger().info("[BedwarsPlugin] " + msg.toString());
    }

    public void log(String module, Object msg) {
        getServer().getLogger().info("[BedwarsPlugin / " + module + "] " + msg.toString());
    }

    @Override
    public void onEnable() {
        // Locations and maps
        w = getServer().getWorlds().get(0);
        spawnLoc = new Location(w, 999, 43, 7);
        mapPasteLoc = new Location(w, 608, 50, -144);
        spectatingTeamSpawnpoint = new Location(w, 700, 65, -40);
        map = Maps.getMap(w, mapPasteLoc);

        // Do a reset
        reset();

        // Set the servers spawnpoint
        getServer().setSpawnRadius(0);
        getServer().getWorlds().get(0).setSpawnLocation(spawnLoc);

        // Register event handlers
        getServer().getPluginManager().registerEvents(new BlockProtection(), this);
        getServer().getPluginManager().registerEvents(new Explosions(), this);
        getServer().getPluginManager().registerEvents(new CraftingProtection(), this);
        getServer().getPluginManager().registerEvents(new LoginHandler(this), this);
//        getServer().getPluginManager().registerEvents(new TradeHandler(this), this);

        // Register the tick actions
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            if (game == null) {
                // Pre-game loop
                for (Player player : getServer().getOnlinePlayers()) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 3, 265, false, false, false));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 3, 265, false, false, false));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 3, 265, false, false, false));
                }
            } else {
                // During-game loop
                game.tickActions(getServer());
                for (Player player : getServer().getOnlinePlayers()) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 3, 265, false, false, false));
                }
            }
        }, 1L, 1L);

        // Register commands
        this.getCommand("start").setExecutor(new Commands(this));
    }

    public void startGame(int maxPlayersPerTeam, int maxTeams) throws WrongCommandArgumentsException, NotEnoughPlayersException {
        getServer().broadcast(Component.text("Starting a game!"));
        log("maxPlayersPerTeam=" + maxPlayersPerTeam);
        log("maxTeams=" + maxTeams);
        log("Clear and copy the map");
        // Clear the old map and copy the new
        WorldEditStuff.clearMap(mapPasteLoc);
        map.copyMap();

        //# Team creation and assignment
        // Do some validation on the inputs
        log("Assigning teams");
        if (maxPlayersPerTeam <= 0 || maxPlayersPerTeam > 6)
            throw new WrongCommandArgumentsException("maxPlayersPerTeam has to be between 1 and 6");
        if (maxTeams <= 0 || maxTeams > 4)
            throw new WrongCommandArgumentsException("maxTeams has to be between 1 and 4");

        // Get a copy of the online players list
        List<Player> playerList = new ArrayList<>(getServer().getOnlinePlayers());
        int playerCount = playerList.size();
        if (playerCount <= 0) throw new NotEnoughPlayersException("No players online");

        // Do some more validation on the inputs
        if (maxPlayersPerTeam >= playerCount) maxPlayersPerTeam = 1;
        if (((maxPlayersPerTeam - 1) * maxTeams) > 3)
            throw new NotEnoughPlayersException("There would be an empty team");

        List<BPTeam> teams = new ArrayList<>();

        for (int i = 0; i < maxTeams; i++) {
            BPTeamTemplate template = map.getTeams().get(i);
            List<Player> players = new ArrayList<>();

            for (int j = 0; j < maxPlayersPerTeam; j++) {
                if (playerList.isEmpty()) break;

                // Get a random player
                Random rand = new Random();
                players.add(playerList.remove(rand.nextInt(playerList.size())));
            }

            teams.add(BPTeam.fromTemplate(template, players, map.getStartLoc(), mapPasteLoc));
        }

        game = new BPGame(map, teams, new BPSpectatingTeam(spectatingTeamSpawnpoint, playerList));
        getServer().broadcast(Component.text("Game started!"));
    }

    public void reset() {
        // TP
        for (Player player : getServer().getOnlinePlayers()) {
            player.teleport(spawnLoc);
            player.getInventory().clear();
            player.getEnderChest().clear();
            player.setBedSpawnLocation(null);
            player.setGameMode(GameMode.ADVENTURE);
        }

        // Delete items and other entities
        w.getEntitiesByClass(Item.class).forEach(Entity::remove);
        w.getEntitiesByClass(Villager.class).forEach(Entity::remove);

        // Remove teams
        Bukkit.getScoreboardManager().getMainScoreboard().getTeams().forEach(Team::unregister);
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
