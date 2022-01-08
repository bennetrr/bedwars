package io.github.bennetrr.bedwarsplugin.traps;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class CounteroffensiveTrap extends BPTrap {
    public CounteroffensiveTrap() {
        super("Counteroffensive Trap");
    }

    @Override
    public void action(List<Player> players) {
        players.forEach(player -> {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 3, 9));
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 3, 14));
        });
    }
}
