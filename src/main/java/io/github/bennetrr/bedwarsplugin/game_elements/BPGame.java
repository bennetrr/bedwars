package io.github.bennetrr.bedwarsplugin.game_elements;

import java.util.Arrays;
import java.util.List;

public class BPGame {
    private final BPMap map;
    private final BPTeam[] teams;

    public BPGame(BPMap map, BPTeam[] teams) {
        this.map = map;
        this.teams = teams;
    }

    public BPGame(BPMap map, List<BPTeam> teams) {
        this(map, teams.toArray(new BPTeam[0]));
    }

    public void tickActions() {
        Arrays.stream(teams).forEach(BPTeam::tickActions);
    }

    public BPMap getMap() {
        return map;
    }

    public BPTeam[] getTeams() {
        return teams;
    }
}
