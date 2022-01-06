package io.github.bennetrr.bedwarsplugin.definitions;

import io.github.bennetrr.bedwarsplugin.game_elements.BPMap;
import io.github.bennetrr.bedwarsplugin.game_elements.BPTeamTemplate;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class Maps {
    public static BPMap getMap(World w, Location mapPasteLoc) {
        // Team Templates
        List<BPTeamTemplate> teamTemplates = new ArrayList<>();
        teamTemplates.add(new BPTeamTemplate(NamedTextColor.RED, "teamRed", "Team Nether", new Location(w, -36, 41, 0), new Location(w, -54, 41, 6, -90, 0), new Location(w, -54, 41, -6, -90, 0), new Location(w, -55, 41, 0), new Location(w, -49, 41, 0, -90, 0)));
        teamTemplates.add(new BPTeamTemplate(NamedTextColor.GRAY, "teamGray", "Team Cave", new Location(w, 40, 41, 0), new Location(w, 49, 41, -5, 0, 0), new Location(w, 49, 41, 5, 180, 0), new Location(w, 54, 41, 0), new Location(w, 49, 41, 0, 90, 0)));
        teamTemplates.add(new BPTeamTemplate(NamedTextColor.DARK_GREEN, "teamGreen", "Team Jungle", new Location(w, 0, 41, -39), new Location(w, -4, 41, -47, -90, 0), new Location(w, 4, 41, -47, 90, 0), new Location(w, 0, 41, -54), new Location(w, 0, 41, -47, 180, 0)));
        teamTemplates.add(new BPTeamTemplate(NamedTextColor.GOLD, "teamOrange", "Team Desert", new Location(w, 0, 41, 42), new Location(w, -4, 41, 53, -135, 0), new Location(w, 4, 41, 53, 135, 0), new Location(w, 0, 41, 55), new Location(w, 0, 41, 49, 0, 0)));

        // Diamond Spawners
        List<Location> diamondSpawnerLocs = new ArrayList<>();
        diamondSpawnerLocs.add(new Location(w, 34, 41, 34));
        diamondSpawnerLocs.add(new Location(w, -34, 41, 34));
        diamondSpawnerLocs.add(new Location(w, -34, 41, -34));
        diamondSpawnerLocs.add(new Location(w, 34, 41, -34));

        // Emerald Spawners
        List<Location> emeraldSpawnerLocs = new ArrayList<>();
        emeraldSpawnerLocs.add(new Location(w, 2, 47, 0));
        emeraldSpawnerLocs.add(new Location(w, -2, 47, 0));
        emeraldSpawnerLocs.add(new Location(w, 0, 41, 0));

        // Start and end point
        Location startLoc = new Location(w, -80, 32, -80);
        Location endLoc = new Location(w, 79, 74, 79);

        return new BPMap(teamTemplates, diamondSpawnerLocs, emeraldSpawnerLocs, startLoc, endLoc, mapPasteLoc);
    }
}
