package io.github.bennetrr.bedwarsplugin.traps;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class MiningFatigueTrap extends BPTrap {
    public MiningFatigueTrap() {
        super("Mining Fatigue Trap");
    }

    @Override
    public void action(List<Player> players) {
        players.forEach(player -> player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 3, 0)));
    }
}
