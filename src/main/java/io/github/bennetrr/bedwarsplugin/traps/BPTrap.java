package io.github.bennetrr.bedwarsplugin.traps;

import org.bukkit.entity.Player;

import java.util.List;

public abstract class BPTrap {
    private final String name;

    protected BPTrap(String name) {
        this.name = name;
    }

    public abstract void action(List<Player> players);

    public String getName() {
        return name;
    }
}
