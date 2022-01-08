package io.github.bennetrr.bedwarsplugin.traps;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class DetectionTrap extends BPTrap{
    public DetectionTrap() {
        super("Detection Trap");
    }

    @Override
    public void action(List<Player> players) {
        players.forEach(player -> {
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 3, 0));
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
        });
    }
}
