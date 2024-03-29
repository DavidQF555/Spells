package io.github.davidqf555.spells;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin implements Listener {

    public static Main plugin;
    public static List<Block> traps = new ArrayList<Block>();

    @SuppressWarnings("deprecation")
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        plugin = this;
        getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new TrapTester(), 0, 3);
        getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new InfiniteParticleSpawner(), 0, 3);
        getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new CustomTargetting(), 0, 3);
    }

    public void onDisable() {
        plugin = null;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player != null) {
            String lowerCaseCommand = command.getName().toLowerCase();
            if (lowerCaseCommand.equals("spell")) {
                if (player.isOp()) {
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("Levitation")) {
                            spawnSpell(player.getLocation(), "Levitation");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("Fireball")) {
                            spawnSpell(player.getLocation(), "Fireball");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("WitherSkull")) {
                            spawnSpell(player.getLocation(), "WitherSkull");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("Lightning")) {
                            spawnSpell(player.getLocation(), "Lightning");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("Storm")) {
                            spawnSpell(player.getLocation(), "Storm");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("Infestation")) {
                            spawnSpell(player.getLocation(), "Infestation");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("Teleport")) {
                            spawnSpell(player.getLocation(), "Teleport");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("LavaTrap")) {
                            spawnSpell(player.getLocation(), "LavaTrap");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("PoisonTrap")) {
                            spawnSpell(player.getLocation(), "PoisonTrap");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("Freeze")) {
                            spawnSpell(player.getLocation(), "Freeze");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("NoFallDamage")) {
                            spawnSpell(player.getLocation(), "NoFallDamage");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("Push")) {
                            spawnSpell(player.getLocation(), "Push");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("Digging")) {
                            spawnSpell(player.getLocation(), "Digging");
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("Guardian")) {
                            spawnSpell(player.getLocation(), "Guardian");
                            return true;
                        }
                        player.sendMessage(ChatColor.DARK_RED + "Usage: /spell <type>");
                        player.sendMessage(ChatColor.DARK_RED + "Types: Levitation, Fireball, WitherSkull, Lightning, Storm, Infestation, Teleport, LavaTrap, PoisonTrap, Freeze, NoFallDamage, Push, Digging, MeteorShower");
                        return true;
                    }
                    player.sendMessage(ChatColor.DARK_RED + "Usage: /spell <type>");
                    player.sendMessage(ChatColor.DARK_RED + "Types: Levitation, Fireball, WitherSkull, Lightning, Storm, Infestation, Teleport, LavaTrap");
                    return true;
                }
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command");
                return true;
            }
        }
        return true;
    }

    public void spawnSpell(Location location, String spellName) {
        switch (spellName) {
            case "Levitation":
                ItemStack levitationSpell = new ItemStack(Material.PAPER);
                ItemMeta levitationSpellMeta = levitationSpell.getItemMeta();
                levitationSpellMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Levitation Spell");
                levitationSpellMeta.setLocalizedName("Levitation Spell");
                levitationSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                levitationSpell.setItemMeta(levitationSpellMeta);
                location.getWorld().dropItemNaturally(location, levitationSpell);
                break;
            case "Fireball":
                ItemStack fireballSpell = new ItemStack(Material.PAPER);
                ItemMeta fireballSpellMeta = fireballSpell.getItemMeta();
                fireballSpellMeta.setDisplayName(ChatColor.DARK_RED + "Fireball Spell");
                fireballSpellMeta.setLocalizedName("Fireball Spell");
                fireballSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                fireballSpell.setItemMeta(fireballSpellMeta);
                location.getWorld().dropItemNaturally(location, fireballSpell);
                break;
            case "WitherSkull":
                ItemStack witherSkullSpell = new ItemStack(Material.PAPER);
                ItemMeta witherSkullSpellMeta = witherSkullSpell.getItemMeta();
                witherSkullSpellMeta.setDisplayName(ChatColor.DARK_GRAY + "Wither Skull Spell");
                witherSkullSpellMeta.setLocalizedName("Wither Skull Spell");
                witherSkullSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                witherSkullSpell.setItemMeta(witherSkullSpellMeta);
                location.getWorld().dropItemNaturally(location, witherSkullSpell);
                break;
            case "Lightning":
                ItemStack lightningSpell = new ItemStack(Material.PAPER);
                ItemMeta lightningSpellMeta = lightningSpell.getItemMeta();
                lightningSpellMeta.setDisplayName(ChatColor.YELLOW + "Lightning Spell");
                lightningSpellMeta.setLocalizedName("Lightning Spell");
                lightningSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                lightningSpell.setItemMeta(lightningSpellMeta);
                location.getWorld().dropItemNaturally(location, lightningSpell);
                break;
            case "Storm":
                ItemStack stormSpell = new ItemStack(Material.PAPER);
                ItemMeta stormSpellMeta = stormSpell.getItemMeta();
                stormSpellMeta.setDisplayName(ChatColor.DARK_BLUE + "Storm Spell");
                stormSpellMeta.setLocalizedName("Storm Spell");
                stormSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                stormSpell.setItemMeta(stormSpellMeta);
                location.getWorld().dropItemNaturally(location, stormSpell);
                break;
            case "Infestation":
                ItemStack infestationSpell = new ItemStack(Material.PAPER);
                ItemMeta infestationSpellMeta = infestationSpell.getItemMeta();
                infestationSpellMeta.setDisplayName(ChatColor.DARK_GREEN + "Infestation Spell");
                infestationSpellMeta.setLocalizedName("Infestation Spell");
                infestationSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                infestationSpell.setItemMeta(infestationSpellMeta);
                location.getWorld().dropItemNaturally(location, infestationSpell);
                break;
            case "Teleport":
                ItemStack teleportSpell = new ItemStack(Material.PAPER);
                ItemMeta teleportSpellMeta = teleportSpell.getItemMeta();
                teleportSpellMeta.setDisplayName(ChatColor.DARK_PURPLE + "Teleport Spell");
                teleportSpellMeta.setLocalizedName("Teleport Spell");
                teleportSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                teleportSpell.setItemMeta(teleportSpellMeta);
                location.getWorld().dropItemNaturally(location, teleportSpell);
                break;
            case "LavaTrap":
                ItemStack lavaTrapSpell = new ItemStack(Material.PAPER);
                ItemMeta lavaTrapSpellMeta = lavaTrapSpell.getItemMeta();
                lavaTrapSpellMeta.setDisplayName(ChatColor.DARK_RED + "Lava Trap Spell");
                lavaTrapSpellMeta.setLocalizedName("Lava Trap Spell");
                lavaTrapSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                lavaTrapSpell.setItemMeta(lavaTrapSpellMeta);
                location.getWorld().dropItemNaturally(location, lavaTrapSpell);
                break;
            case "PoisonTrap":
                ItemStack poisonTrapSpell = new ItemStack(Material.PAPER);
                ItemMeta poisonTrapSpellMeta = poisonTrapSpell.getItemMeta();
                poisonTrapSpellMeta.setDisplayName(ChatColor.GREEN + "Poison Trap Spell");
                poisonTrapSpellMeta.setLocalizedName("Poison Trap Spell");
                poisonTrapSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                poisonTrapSpell.setItemMeta(poisonTrapSpellMeta);
                location.getWorld().dropItemNaturally(location, poisonTrapSpell);
                break;
            case "Freeze":
                ItemStack freezeSpell = new ItemStack(Material.PAPER);
                ItemMeta freezeSpellMeta = freezeSpell.getItemMeta();
                freezeSpellMeta.setDisplayName(ChatColor.BLUE + "Freeze Spell");
                freezeSpellMeta.setLocalizedName("Freeze Spell");
                freezeSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                freezeSpell.setItemMeta(freezeSpellMeta);
                location.getWorld().dropItemNaturally(location, freezeSpell);
                break;
            case "NoFallDamage":
                ItemStack noFallDamageSpell = new ItemStack(Material.PAPER);
                ItemMeta noFallDamageSpellMeta = noFallDamageSpell.getItemMeta();
                noFallDamageSpellMeta.setDisplayName(ChatColor.WHITE + "No Fall Damage Spell");
                noFallDamageSpellMeta.setLocalizedName("No Fall Damage Spell");
                noFallDamageSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                noFallDamageSpell.setItemMeta(noFallDamageSpellMeta);
                location.getWorld().dropItemNaturally(location, noFallDamageSpell);
                break;
            case "Push":
                ItemStack pushSpell = new ItemStack(Material.PAPER);
                ItemMeta pushSpellMeta = pushSpell.getItemMeta();
                pushSpellMeta.setDisplayName(ChatColor.BOLD + "Push Spell");
                pushSpellMeta.setLocalizedName("Push Spell");
                pushSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                pushSpell.setItemMeta(pushSpellMeta);
                location.getWorld().dropItemNaturally(location, pushSpell);
                break;
            case "Digging":
                ItemStack diggingSpell = new ItemStack(Material.PAPER);
                ItemMeta diggingSpellMeta = diggingSpell.getItemMeta();
                diggingSpellMeta.setDisplayName(ChatColor.GRAY + "Digging Spell");
                diggingSpellMeta.setLocalizedName("Digging Spell");
                diggingSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                diggingSpell.setItemMeta(diggingSpellMeta);
                location.getWorld().dropItemNaturally(location, diggingSpell);
                break;
            case "Guardian":
                ItemStack guardianSpell = new ItemStack(Material.PAPER);
                ItemMeta guardianSpellMeta = guardianSpell.getItemMeta();
                guardianSpellMeta.setDisplayName(ChatColor.AQUA + "Guardian Spell");
                guardianSpellMeta.setLocalizedName("Guardian Spell");
                guardianSpellMeta.addEnchant(Enchantment.MENDING, 1, false);
                guardianSpell.setItemMeta(guardianSpellMeta);
                location.getWorld().dropItemNaturally(location, guardianSpell);
                break;
        }
    }

    @SuppressWarnings("deprecation")
    public void activateSpell(final LivingEntity entity, String spellName) {
        Location entityEyeLocation = entity.getEyeLocation();
        final Location entityLocation = entity.getLocation();
        switch (spellName) {
            case "Levitation": {
                LlamaSpit tester = (LlamaSpit) entity.getWorld().spawnEntity(entityEyeLocation, EntityType.LLAMA_SPIT);
                tester.setShooter(entity);
                tester.setGravity(false);
                tester.setMetadata("owningSpell", new FixedMetadataValue(plugin, "Levitation"));
                tester.setVelocity(entityLocation.getDirection().multiply(100));
                break;
            }
            case "Fireball":
                Fireball fireball = (Fireball) entity.getWorld().spawnEntity(entityEyeLocation, EntityType.FIREBALL);
                fireball.setShooter(entity);
                fireball.setGravity(false);
                fireball.setIsIncendiary(true);
                fireball.setVelocity(entityLocation.getDirection().multiply(1.5D));
                break;
            case "WitherSkull":
                WitherSkull witherSkull = (WitherSkull) entity.getWorld().spawnEntity(entityEyeLocation, EntityType.WITHER_SKULL);
                witherSkull.setShooter(entity);
                witherSkull.setGravity(false);
                witherSkull.setVelocity(entityLocation.getDirection().multiply(1.5D));
                break;
            case "Lightning": {
                LlamaSpit tester = (LlamaSpit) entity.getWorld().spawnEntity(entityEyeLocation, EntityType.LLAMA_SPIT);
                tester.setShooter(entity);
                tester.setGravity(false);
                tester.setMetadata("owningSpell", new FixedMetadataValue(plugin, "Lightning"));
                tester.setVelocity(entityLocation.getDirection().multiply(100));
                break;
            }
            case "Storm":
                entity.getWorld().setStorm(true);
                entity.getWorld().setWeatherDuration(600);
                new BukkitRunnable() {
                    int lightningStruck = 0;

                    @Override
                    public void run() {
                        int xDifference = (int) (Math.random() * 50 - 25);
                        int zDifference = (int) (Math.random() * 50 - 25);
                        int x = entityLocation.getBlockX() - xDifference;
                        int z = entityLocation.getBlockZ() - zDifference;
                        int y = entity.getWorld().getHighestBlockYAt(x, z);
                        Location lightningStrikeLocation = new Location(entity.getWorld(), x, y, z);
                        entity.getWorld().strikeLightning(lightningStrikeLocation);
                        lightningStruck++;
                        if (lightningStruck >= 100) {
                            cancel();
                        }
                    }
                }.runTaskTimer(plugin, 0, 6);
                break;
            case "Infestation": {
                LlamaSpit tester = (LlamaSpit) entity.getWorld().spawnEntity(entityEyeLocation, EntityType.LLAMA_SPIT);
                tester.setShooter(entity);
                tester.setGravity(false);
                tester.setMetadata("owningSpell", new FixedMetadataValue(plugin, "Infestation"));
                tester.setVelocity(entityLocation.getDirection().multiply(100));
                break;
            }
            case "Teleport":
                EnderPearl enderPearl = (EnderPearl) entityLocation.getWorld().spawnEntity(entityLocation.add(entityLocation.getDirection().normalize()), EntityType.ENDER_PEARL);
                enderPearl.setShooter(entity);
                enderPearl.setGravity(false);
                enderPearl.setVelocity(entityLocation.getDirection().multiply(100));
                break;
            case "LavaTrap":
                final Block lavaTrap = entity.getWorld().getBlockAt(entityLocation.getBlockX(), entityLocation.getBlockY() - 1, entityLocation.getBlockZ());
                if (lavaTrap.getType() != Material.AIR && lavaTrap.getType() != Material.LAVA && lavaTrap.getType() != Material.WATER) {
                    lavaTrap.setMetadata("spellCaster", new FixedMetadataValue(plugin, entity.getUniqueId().toString()));
                    lavaTrap.setMetadata("owningSpell", new FixedMetadataValue(plugin, "LavaTrap"));
                    traps.add(lavaTrap);
                    getServer().getScheduler().runTaskLater(plugin,
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    Main.traps.remove(lavaTrap);
                                }
                            }, 12000);
                }

                break;
            case "PoisonTrap":
                final Block poisonTrap = entity.getWorld().getBlockAt(entityLocation.getBlockX(), entityLocation.getBlockY() - 1, entityLocation.getBlockZ());
                if (poisonTrap.getType() != Material.AIR && poisonTrap.getType() != Material.LAVA && poisonTrap.getType() != Material.WATER) {
                    poisonTrap.setMetadata("spellCaster", new FixedMetadataValue(plugin, entity.getUniqueId().toString()));
                    poisonTrap.setMetadata("owningSpell", new FixedMetadataValue(plugin, "PoisonTrap"));
                    traps.add(poisonTrap);
                    getServer().getScheduler().runTaskLater(plugin,
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    Main.traps.remove(poisonTrap);
                                }
                            }, 12000L);
                }

                break;
            case "Freeze": {
                LlamaSpit tester = (LlamaSpit) entity.getWorld().spawnEntity(entityEyeLocation, EntityType.LLAMA_SPIT);
                tester.setShooter(entity);
                tester.setGravity(false);
                tester.setMetadata("owningSpell", new FixedMetadataValue(plugin, "Freeze"));
                tester.setVelocity(entityLocation.getDirection().multiply(100));
                break;
            }
            case "NoFallDamage":
                entity.setMetadata("NoFallDamage", new FixedMetadataValue(plugin, true));
                getServer().getScheduler().runTaskLater(plugin,
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                entity.setMetadata("NoFallDamage", new FixedMetadataValue(Main.plugin, null));
                            }
                        }, 200);
                break;
            case "Push": {
                LlamaSpit tester = (LlamaSpit) entity.getWorld().spawnEntity(entityEyeLocation, EntityType.LLAMA_SPIT);
                tester.setShooter(entity);
                tester.setGravity(false);
                tester.setMetadata("owningSpell", new FixedMetadataValue(plugin, "Push"));
                tester.setVelocity(entityLocation.getDirection().multiply(100));
                break;
            }
            case "Digging": {
                LlamaSpit tester = (LlamaSpit) entity.getWorld().spawnEntity(entityEyeLocation, EntityType.LLAMA_SPIT);
                tester.setShooter(entity);
                tester.setGravity(false);
                tester.setMetadata("owningSpell", new FixedMetadataValue(plugin, "Digging"));
                tester.setVelocity(entityLocation.getDirection().multiply(100));
                break;
            }
            case "Guardian":
                final Guardian guardian = (Guardian) entity.getWorld().spawnEntity(entityEyeLocation, EntityType.GUARDIAN);
                guardian.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 0, 1000000));
                guardian.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1000000));
                guardian.setMetadata("owningSpell", new FixedMetadataValue(plugin, "Guardian"));
                guardian.setMetadata("spellCaster", new FixedMetadataValue(plugin, entity.getUniqueId().toString()));
                Bat bat = (Bat) entity.getWorld().spawnEntity(entityLocation, EntityType.BAT);
                bat.setAI(false);
                bat.setGravity(false);
                bat.setInvulnerable(true);
                bat.setSilent(true);
                bat.setCollidable(false);
                bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 1, true, false));
                bat.setPassenger(guardian);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (!guardian.isDead()) {
                            guardian.damage(1000000);
                        }
                    }
                }.runTaskLater(plugin, 1200);
                break;
        }
    }

    @SuppressWarnings("deprecation")
    public void setCooldown(final ItemStack item, long time) {
        final ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta.hasEnchant(Enchantment.MENDING)) {
            itemMeta.removeEnchant(Enchantment.MENDING);
            item.setItemMeta(itemMeta);
            getServer().getScheduler().runTaskLater(plugin,
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            itemMeta.addEnchant(Enchantment.MENDING, 1, false);
                            item.setItemMeta(itemMeta);
                        }
                    }, time);
        }
    }

    @EventHandler
    public void castSpell(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && item.getItemMeta().hasLocalizedName() && item.getType() == Material.PAPER) {
            if (item.getItemMeta().hasEnchant(Enchantment.MENDING)) {
                String itemName = item.getItemMeta().getLocalizedName();
                switch (itemName) {
                    case "Levitation Spell":
                        activateSpell(player, "Levitation");
                        setCooldown(item, 100L);
                        break;
                    case "Fireball Spell":
                        activateSpell(player, "Fireball");
                        setCooldown(item, 100L);
                        break;
                    case "Wither Skull Spell":
                        activateSpell(player, "WitherSkull");
                        setCooldown(item, 100L);
                        break;
                    case "Lightning Spell":
                        activateSpell(player, "Lightning");
                        setCooldown(item, 160L);
                        break;
                    case "Storm Spell":
                        activateSpell(player, "Storm");
                        setCooldown(item, 200L);
                        break;
                    case "Infestation Spell":
                        activateSpell(player, "Infestation");
                        setCooldown(item, 200L);
                        break;
                    case "Teleport Spell":
                        activateSpell(player, "Teleport");
                        setCooldown(item, 60L);
                        break;
                    case "Lava Trap Spell":
                        activateSpell(player, "LavaTrap");
                        setCooldown(item, 200L);
                        break;
                    case "Poison Trap Spell":
                        activateSpell(player, "PoisonTrap");
                        setCooldown(item, 200L);
                        break;
                    case "Freeze Spell":
                        activateSpell(player, "Freeze");
                        setCooldown(item, 300L);
                        break;
                    case "No Fall Damage Spell":
                        activateSpell(player, "NoFallDamage");
                        setCooldown(item, 400L);
                        break;
                    case "Push Spell":
                        activateSpell(player, "Push");
                        setCooldown(item, 300L);
                        break;
                    case "Digging Spell":
                        activateSpell(player, "Digging");
                        setCooldown(item, 20L);
                        break;
                    case "Guardian Spell":
                        activateSpell(player, "Guardian");
                        setCooldown(item, 1200L);
                        break;
                }
            } else {
                player.sendMessage(ChatColor.DARK_RED + "Spell is still on Cooldown");
            }
        }
    }

    @EventHandler
    public void spellEffects(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();
        if (projectile.hasMetadata("owningSpell")) {
            if (event.getHitEntity() != null && event.getHitEntity() instanceof LivingEntity) {
                LivingEntity hitEntity = (LivingEntity) event.getHitEntity();
                for (MetadataValue metadata : projectile.getMetadata("owningSpell")) {
                    if (metadata.asString().equals("Levitation")) {
                        hitEntity.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 2));
                        continue;
                    }
                    if (metadata.asString().equals("Lightning")) {
                        hitEntity.getWorld().strikeLightning(hitEntity.getLocation());
                        continue;
                    }
                    if (metadata.asString().equals("Infestation")) {
                        for (int spawnedAmount = 0; spawnedAmount < 5; spawnedAmount++) {
                            Silverfish infestation = (Silverfish) hitEntity.getWorld().spawnEntity(hitEntity.getLocation(), EntityType.SILVERFISH);
                            infestation.setTarget(hitEntity);
                            infestation.setCustomName(ChatColor.DARK_GREEN + "Infestation");
                            infestation.setCustomNameVisible(false);
                        }
                        continue;
                    }
                    if (metadata.asString().equals("Freeze")) {
                        hitEntity.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, -10));
                        hitEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 100));
                        hitEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 100, 100));
                        continue;
                    }
                    if (metadata.asString().equals("Push")) {
                        hitEntity.setVelocity(projectile.getVelocity().multiply(0.1D));
                    }
                }
            }

            if (event.getHitBlock() != null) {
                Block hitBlock = event.getHitBlock();
                for (MetadataValue metadata : projectile.getMetadata("owningSpell")) {
                    if (metadata.asString().equals("Lightning")) {
                        hitBlock.getWorld().strikeLightning(hitBlock.getLocation());
                        continue;
                    }
                    if (metadata.asString().equals("Digging") && hitBlock.getType() != Material.BARRIER && hitBlock.getType() != Material.BEDROCK && hitBlock.getType() != Material.END_GATEWAY && hitBlock.getType() != Material.ENDER_PORTAL && hitBlock.getType() != Material.ENDER_PORTAL_FRAME) {
                        hitBlock.breakNaturally();
                    }
                }
            }
        }
    }


    @EventHandler
    public void entityDamaged(EntityDamageEvent event) {
        if (event.getEntity() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) event.getEntity();
            EntityDamageEvent.DamageCause cause = event.getCause();
            if (cause == EntityDamageEvent.DamageCause.FALL && entity.hasMetadata("NoFallDamage")) {
                for (MetadataValue metadata : entity.getMetadata("NoFallDamage")) {
                    if (metadata.asBoolean()) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void entityDamagedByEntity(EntityDamageByEntityEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            Projectile projectile = (Projectile) event.getDamager();
            if (projectile.hasMetadata("owningSpell"))
                event.setCancelled(true);
        }
    }

    @EventHandler
    public void entityDies(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.hasMetadata("owningSpell"))
            for (MetadataValue metadata : entity.getMetadata("owningSpell")) {
                if (metadata.asString().equals("Guardian")) {
                    entity.getVehicle().remove();
                    event.getDrops().clear();
                    event.setDroppedExp(0);
                }
            }
    }

    @EventHandler
    public void entityTarget(EntityTargetEvent event) {
        LivingEntity entity = (LivingEntity) event.getEntity();
        if (entity.hasMetadata("owningSpell") && event.getTarget() != null)
            for (MetadataValue metadata : entity.getMetadata("owningSpell")) {
                if (metadata.asString().equals("Guardian") && entity.hasMetadata("spellCaster")) {
                    for (MetadataValue caster : entity.getMetadata("spellCaster")) {
                        if (event.getTarget().getUniqueId().toString().equals(caster.asString())) {
                            event.setCancelled(true);
                            return;
                        }
                    }
                }
            }
    }

}