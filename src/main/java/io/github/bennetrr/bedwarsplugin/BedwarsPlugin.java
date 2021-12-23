package io.github.bennetrr.bedwarsplugin;

import io.github.bennetrr.bedwarsplugin.exceptions.NotEnoughPlayersException;
import io.github.bennetrr.bedwarsplugin.exceptions.WrongCommandArgumentsException;
import io.github.bennetrr.bedwarsplugin.game_elements.BPGame;
import io.github.bennetrr.bedwarsplugin.game_elements.BPMap;
import io.github.bennetrr.bedwarsplugin.game_elements.BPTeam;
import io.github.bennetrr.bedwarsplugin.game_elements.BPTeamTemplate;
import io.github.bennetrr.bedwarsplugin.handlers.BlockProtection;
import io.github.bennetrr.bedwarsplugin.handlers.Commands;
import io.github.bennetrr.bedwarsplugin.utils.WorldEditStuff;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BedwarsPlugin extends JavaPlugin {
    private BPMap map;
    private Location spawnLoc, mapPasteLoc;
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
        // Locations
        w = getServer().getWorlds().get(0);
        spawnLoc = new Location(w, 999, 43, 7);
        mapPasteLoc = new Location(w, 608, 50, -144);

        //DEBUG
        fullReset();

        // Maps
        map = new BPMap(new BPTeamTemplate[]{
                new BPTeamTemplate(NamedTextColor.RED, "teamRed", "Team Nether", new Location(w, -36, 41, 0), new Location(w, -54, 41, 6, -90, 0), new Location(w, -54, 41, -6, -90, 0), new Location(w, 0, 41, 55), new Location(w, -49, 41, 0)),
                new BPTeamTemplate(NamedTextColor.DARK_GREEN, "teamGreen", "Team Jungle", new Location(w, 0, 41, -39), new Location(w, -4, 41, -47, -90, 0), new Location(w, 4, 41, -47, 90, 0), new Location(w, 0, 41, -54), new Location(w, 0, 41, -47)),
                new BPTeamTemplate(NamedTextColor.GRAY, "teamGray", "Team Cave", new Location(w, 40, 41, 0), new Location(w, 49, 41, -5, 0, 0), new Location(w, 49, 41, 5, 180, 0), new Location(w, 54, 41, 0), new Location(w, 49, 41, 0)),
                new BPTeamTemplate(NamedTextColor.GOLD, "teamOrange", "Team Desert", new Location(w, 0, 41, 42), new Location(w, -4, 41, 53, -135, 0), new Location(w, 4, 41, 53, 135, 0), new Location(w, 0, 41, 55), new Location(w, 0, 41, 49))},
                new Location[]{new Location(w, 34, 41, 34), new Location(w, -34, 41, 34), new Location(w, -34, 41, -34), new Location(w, 34, 41, -34)},
                new Location[]{new Location(w, 2, 47, 0), new Location(w, -2, 47, 0), new Location(w, 0, 41, 0)},
                new Location(w, -80, 32, -80),
                new Location(w, 79, 74, 79)
        );

        // Spawn point
        getServer().setSpawnRadius(0);
        getServer().getWorlds().get(0).setSpawnLocation(spawnLoc);

        // Event Handlers
        getServer().getPluginManager().registerEvents(new BlockProtection(), this);

        // Tick schedulers
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            // pre-game Loop
            if (game == null) {
                for (Player onlinePlayer : getServer().getOnlinePlayers()) {
                    onlinePlayer.setGameMode(GameMode.ADVENTURE);
                    onlinePlayer.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 3, 265, false, false, false));
                    onlinePlayer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 3, 265, false, false, false));
                    onlinePlayer.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 3, 265, false, false, false));
                }
            } else {
                game.tickActions();
            }
        }, 1L, 1L);

        // Commands
        this.getCommand("start").setExecutor(new Commands(this));

        log("Enabled");
    }

    public void startGame(int maxPlayersPerTeam, int maxTeams) throws WrongCommandArgumentsException, NotEnoughPlayersException {
        log("Starting a game");
        log("maxPlayersPerTeam=" + maxPlayersPerTeam);
        log("maxTeams=" + maxTeams);
        log("Clear and copy the map");
        // Clear the old map and copy the new
        WorldEditStuff.clearMap(mapPasteLoc);
        map.copyMap(mapPasteLoc);

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
            BPTeamTemplate template = map.getTeams()[i];
            List<Player> players = new ArrayList<>();

            for (int j = 0; j < maxPlayersPerTeam; j++) {
                if (playerList.isEmpty()) break;

                // Get a random player
                Random rand = new Random();
                players.add(playerList.remove(rand.nextInt(playerList.size())));
            }

            teams.add(BPTeam.fromTemplate(template, players, map.getStartLoc(), mapPasteLoc));
        }

        log("Deleting items");
        w.getEntitiesByClass(EntityType.DROPPED_ITEM.getEntityClass()).forEach(Entity::remove);
        w.getEntitiesByClass(EntityType.VILLAGER.getEntityClass()).forEach(Entity::remove);

        game = new BPGame(map, teams);
        getServer().broadcast(Component.text("Game started!"));
    }

    public void fullReset() {
        // Clear the map
        // WorldEditStuff.clearMap(mapPasteLoc);

        // Delete items and other entities
        w.getEntitiesByClass(EntityType.DROPPED_ITEM.getEntityClass()).forEach(Entity::remove);
        w.getEntitiesByClass(EntityType.VILLAGER.getEntityClass()).forEach(Entity::remove);

        // Remove teams
        Bukkit.getScoreboardManager().getMainScoreboard().getTeams().forEach(Team::unregister);
    }

    @Override
    public void onDisable() {
    }
}
