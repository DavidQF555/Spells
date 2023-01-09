package io.github.davidqf555.spells;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class InfiniteParticleSpawner extends BukkitRunnable {

    List<Entity> entities = new ArrayList<>();

    @Override
    public void run() {
        for (World world : Bukkit.getServer().getWorlds()) {
            this.entities.addAll(world.getEntities());
        }
        for (Entity entity : entities) {
            if (entity.hasMetadata("owningSpell"))
                for (MetadataValue metadata : entity.getMetadata("owningSpell")) {
                    if (metadata.asString().equals("Guardian"))
                        entity.getWorld().playEffect(entity.getLocation(), Effect.PORTAL_TRAVEL, 5, 2);
                }
        }
    }

}