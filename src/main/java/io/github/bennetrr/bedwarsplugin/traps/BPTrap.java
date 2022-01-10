package io.github.bennetrr.bedwarsplugin.traps;

import org.bukkit.entity.Player;

public abstract class BPTrap {
    private final String name;

    protected BPTrap(String name) {
        this.name = name;
    }

    public abstract void action(Player player);

    public String getName() {
        return name;
    }
}
