package io.github.bennetrr.bedwarsplugin.traps;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ItsATrap extends BPTrap{
    public ItsATrap() {
        super("It's a trap!");
    }

    @Override
    public void action(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 3, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 3, 2));
    }
}
