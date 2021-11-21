package io.github.bennetrr.bedwarsplugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.bennetrr.bedwarsplugin.handlers.BlockProtection;
import io.github.bennetrr.bedwarsplugin.handlers.Commands;
import io.github.bennetrr.bedwarsplugin.game_elements.BPMap;
import io.github.bennetrr.bedwarsplugin.game_elements.BPTeam;
import io.github.bennetrr.bedwarsplugin.game_elements.BPTeamTemplate;
import io.github.bennetrr.bedwarsplugin.game_elements.BPGame;


public class BedwarsPlugin extends JavaPlugin {

    private final BPMap map;
    private final Location spawnLoc;
    private BPGame game;

    public BedwarsPlugin() {
        World w = getServer().getWorlds().get(0);

        spawnLoc = new Location(w, 999, 43, 7);

        // Maps
        map = new BPMap(new BPTeamTemplate[]{
                new BPTeamTemplate(ChatColor.RED, "teamRed", "Team Nether", new Location(w, -36, 41, 0), new Location(w, -54, 41, 6, -90, 0), new Location(w, -54, 41, -6, -90, 0), new Location(w, 0, 41, 55), new Location(w, -49, 41, -47)),
                new BPTeamTemplate(ChatColor.DARK_GREEN, "teamGreen", "Team Jungel", new Location(w, 0, 41, -39), new Location(w, -4, 41, -47, -90, 0), new Location(w, 4, 41, -47, 90, 0), new Location(w, 0, 41, -54), new Location(w, 0, 41, -47)),
                new BPTeamTemplate(ChatColor.GRAY, "teamGray", "Team Cave", new Location(w, 40, 41, 0), new Location(w, 49, 41, -5, 0,0), new Location(w, 49, 41, 5, 180, 0), new Location(w, 54, 41, 0), new Location(w, 49, 41, 0)),
                new BPTeamTemplate(ChatColor.GOLD, "teamOrange", "Team Wüste", new Location(w, 0, 41, 42), new Location(w, -4, 41, 53, -135, 0), new Location(w, 4, 41, 53, 135, 0), new Location(w, 0, 41, 55), new Location(w, -49, 41, 49))},
            new Location[]{new Location(w, 34, 41, 34), new Location(w, -34, 41, 34), new Location(w, -34, 41, -34), new Location(w, 34, 41, -34)},
            new Location[]{new Location(w, 2, 47, 0), new Location(w, -2, 47, 0), new Location(w, 0, 41, 0)},
            new Location(w, -80, 32, -80),
            new Location(w, 79, 74, 79)
        );
    }

    @Override
    public void onEnable() {
        // Spawn point
        getServer().setSpawnRadius(0);
        getServer().getWorlds().get(0).setSpawnLocation(spawnLoc);

        // Event Handlers
        getServer().getPluginManager().registerEvents(new BlockProtection(), this);

        // Commands
        this.getCommand("start").setExecutor(new Commands(this));
    }

    public void startGame() {
        // Get playersPerTeam from config
        int playersPerTeam = getConfig().getInt("playersPerTeam");

        // There can only be 6 players in one team
        if(playersPerTeam <= 0 || playersPerTeam > 6) throw new IllegalArgumentException();

        // Get a copy of the online players
        List<Player> playerList = Arrays.stream((Player[]) getServer().getOnlinePlayers().toArray().clone()).toList();
        int playerCount = playerList.size();

        // When no players are online, there is nothing to do
        if(playerCount <= 0) return;

        // If there are not enough players to fill a team with the given playersPerTeam, assign only one player per team
        if(playersPerTeam >= playerCount) playersPerTeam = 1;

        // Calculate, how many teams we need
        int teamCount = playerCount / playersPerTeam;
        if(teamCount > 4) teamCount = 4;

        List<BPTeam> teams = new ArrayList<>();

        for(int i = 0; i < teamCount; i++) {
            BPTeamTemplate template = map.getTeams()[i];
            List<Player> players = new ArrayList<>();

            for(int j = 0; j < playersPerTeam; j++) {
                if(playerList.isEmpty()) break;
                Random rand = new Random();
                // Get a random player
                players.add(playerList.remove(rand.nextInt(playerList.size())));
            }

            teams.add(BPTeam.fromTemplate(template, players));
        }

        game = new BPGame(map, teams);
        game.getMap().copy();
    }

    @Override
    public void onDisable() {
    }
}
