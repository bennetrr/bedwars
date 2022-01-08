package io.github.bennetrr.bedwarsplugin.traps;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class ItsATrap extends BPTrap{
    public ItsATrap() {
        super("It's a trap!");
    }

    @Override
    public void action(List<Player> players) {
        players.forEach(player -> {
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 3, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 3, 2));
        });
    }
}
