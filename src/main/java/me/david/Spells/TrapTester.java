package me.david.Spells;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class TrapTester extends BukkitRunnable {

	List<Entity> entities = new ArrayList<Entity>();

	@SuppressWarnings("deprecation")
	public void run() {
		if(!Main.traps.isEmpty())
			for (final Block trap : Main.traps) {
				entities.clear();
				entities.addAll(trap.getWorld().getNearbyEntities(trap.getLocation(), 3.0D, 3.0D, 3.0D));
				for (Entity entity : entities) {
					Location entityLocation = entity.getLocation();
					Block steppedOnBlock = entity.getWorld().getBlockAt(entityLocation.getBlockX(), entityLocation.getBlockY() - 1, entityLocation.getBlockZ());
					if(steppedOnBlock.equals(trap)) {
						Block aboveTrapBlock = trap.getWorld().getBlockAt(trap.getLocation().getBlockX(), trap.getLocation().getBlockY() + 1, trap.getLocation().getBlockZ());
						Location aboveTrap = new Location(aboveTrapBlock.getWorld(), aboveTrapBlock.getX() + 0.5D, aboveTrapBlock.getY(), aboveTrapBlock.getZ() + 0.5D);
						if(aboveTrap.getBlock().getType() == Material.AIR)
							for (MetadataValue metadataOwner : trap.getMetadata("spellCaster")) {
								if(!metadataOwner.asString().equals(entity.getUniqueId().toString()))
									for (MetadataValue metadataSpell : trap.getMetadata("owningSpell")) {
										if(metadataSpell.asString().equals("LavaTrap")) {
											aboveTrap.getBlock().setType(Material.STATIONARY_LAVA);
											Bukkit.getServer().getScheduler().runTaskLater(Main.plugin, 
													new BukkitRunnable() {
												public void run() {
													Block replacedBlockLater = trap.getWorld().getBlockAt(trap.getLocation().getBlockX(), trap.getLocation().getBlockY() + 1, trap.getLocation().getBlockZ());
													if(replacedBlockLater.getType() == Material.LAVA || replacedBlockLater.getType() == Material.STATIONARY_LAVA) {
														replacedBlockLater.setType(Material.AIR);
													}
												}
											}, 120L); continue;
										} 
										if(metadataSpell.asString().equals("PoisonTrap")) {
											ThrownPotion poison = (ThrownPotion) aboveTrap.getWorld().spawnEntity(aboveTrap, EntityType.SPLASH_POTION);
											ItemStack poisonItem = new ItemStack(Material.SPLASH_POTION);
											PotionMeta poisonMeta = (PotionMeta) poisonItem.getItemMeta();
											poisonMeta.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 7, 2), true);
											poisonMeta.setColor(Color.GREEN);
											poisonItem.setItemMeta((ItemMeta) poisonMeta);
											poison.setItem(poisonItem);
										} 
									}  
							}  
					} 
				} 
			}  
	}
}