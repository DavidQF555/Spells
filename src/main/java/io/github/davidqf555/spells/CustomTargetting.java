package io.github.davidqf555.spells;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.LivingEntity;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomTargetting extends BukkitRunnable {

    @Override
    public void run() {
        List<LivingEntity> livingEntities = new ArrayList<>();
        for (World world : Bukkit.getServer().getWorlds()) {
            livingEntities.addAll(world.getLivingEntities());
        }
        for (LivingEntity entity : livingEntities) {
            if (entity.hasMetadata("owningSpell"))
                for (MetadataValue metadata : entity.getMetadata("owningSpell")) {
                    if (metadata.asString().equals("Guardian") &&
                            entity instanceof Guardian) {
                        Guardian guardian = (Guardian) entity;
                        List<Entity> nearbyEntities = guardian.getNearbyEntities(16, 16, 16);
                        UUID caster = null;
                        if (guardian.hasMetadata("spellCaster")) {
                            for (MetadataValue guardianCaster : guardian.getMetadata("spellCaster")) {
                                caster = UUID.fromString(guardianCaster.asString());
                            }
                            List<LivingEntity> targets = new ArrayList<>();
                            for (Entity testingEntity : nearbyEntities) {
                                if (!(testingEntity instanceof LivingEntity) || testingEntity.getUniqueId().equals(caster) || testingEntity.isInvulnerable()) {
                                    continue;
                                }
                                targets.add((LivingEntity) testingEntity);
                            }
                            if (guardian.getTarget() == null && !targets.isEmpty())
                                for (LivingEntity target : targets) {
                                    if (guardian.hasLineOfSight(target)) {
                                        guardian.setTarget(target);
                                        return;
                                    }
                                }
                        }
                    }
                }
        }
    }

}