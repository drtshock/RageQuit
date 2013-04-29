package com.sgtcaze.ragequit;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RageQuit extends JavaPlugin implements Listener
{
    ArrayList<Player> cooldown = new ArrayList<Player>();
    ArrayList<Player> jump = new ArrayList<Player>();

    public void onEnable()
    {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new Toggle(this), this);
    }

    @EventHandler(priority=EventPriority.HIGH)
    public void DisableDamage(EntityExplodeEvent event)
    {
        if (getConfig().getBoolean("RageQuit.DisableBlockDamage")) {
            event.blockList().clear();
        }
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
        {
            if (player.getInventory().getItemInHand().getType() == Material.FEATHER)
            {
                if (player.hasPermission("rq.powers"))
                {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 3));
                    player.sendMessage(ChatColor.DARK_GREEN + "You now have speed for 10 seconds!");
                    int amount = player.getInventory().getItemInHand().getAmount();
                    amount--;
                    if (amount == 0)
                    {
                        player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.FEATHER) });
                    }
                    else {
                        player.getInventory().getItemInHand().setAmount(amount);
                    }
                }

            }

        }

        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
        {
            if (player.getInventory().getItemInHand().getType() == Material.MAGMA_CREAM)
            {
                if (player.hasPermission("rq.powers"))
                {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 3));
                    player.sendMessage(ChatColor.DARK_GREEN + "You now have fire resistance for 10 seconds!");
                    int amount = player.getInventory().getItemInHand().getAmount();
                    amount--;
                    if (amount == 0)
                    {
                        player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.MAGMA_CREAM) });
                    }
                    else {
                        player.getInventory().getItemInHand().setAmount(amount);
                    }
                }
            }
        }

        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
        {
            if (player.getInventory().getItemInHand().getType() == Material.SUGAR)
            {
                if (player.hasPermission("rq.powers"))
                {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 3));
                    player.sendMessage(ChatColor.DARK_GREEN + "You now have invisibility for 10 seconds!");
                    int amount = player.getInventory().getItemInHand().getAmount();
                    amount--;
                    if (amount == 0)
                    {
                        player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.SUGAR) });
                    }
                    else {
                        player.getInventory().getItemInHand().setAmount(amount);
                    }
                }
            }
        }

        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
        {
            if (player.getInventory().getItemInHand().getType() == Material.GHAST_TEAR)
            {
                if (player.hasPermission("rq.powers"))
                {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1));
                    player.sendMessage(ChatColor.DARK_GREEN + "You now have increased damage for 10 seconds!");
                    int amount = player.getInventory().getItemInHand().getAmount();
                    amount--;
                    if (amount == 0)
                    {
                        player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.GHAST_TEAR) });
                    }
                    else {
                        player.getInventory().getItemInHand().setAmount(amount);
                    }
                }
            }
        }

        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
        {
            if (player.getInventory().getItemInHand().getType() == Material.PAPER)
            {
                if (player.hasPermission("rq.powers"))
                {
                    player.setHealth(20);
                    player.sendMessage(ChatColor.DARK_GREEN + "You have been healed!");
                    int amount = player.getInventory().getItemInHand().getAmount();
                    amount--;
                    if (amount == 0)
                    {
                        player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.PAPER) });
                    }
                    else {
                        player.getInventory().getItemInHand().setAmount(amount);
                    }
                }
            }
        }

        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
        {
            if (player.getInventory().getItemInHand().getType() == Material.GOLD_NUGGET)
            {
                if (player.hasPermission("rq.powers"))
                {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 3));
                    player.sendMessage(ChatColor.DARK_GREEN + "You now have damage resistance for 10 seconds!");
                    int amount = player.getInventory().getItemInHand().getAmount();
                    amount--;
                    if (amount == 0)
                    {
                        player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.GOLD_NUGGET) });
                    }
                    else {
                        player.getInventory().getItemInHand().setAmount(amount);
                    }
                }
            }
        }

        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
        {
            if (player.getInventory().getItemInHand().getType() == Material.DIAMOND)
            {
                if (player.hasPermission("rq.powers"))
                {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 3));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 3));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 3));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 3));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 3));
                    player.sendMessage(ChatColor.DARK_GREEN + "You now have every power for 10 seconds!");
                    int amount = player.getInventory().getItemInHand().getAmount();
                    amount--;
                    if (amount == 0)
                    {
                        player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.DIAMOND) });
                    }
                    else {
                        player.getInventory().getItemInHand().setAmount(amount);
                    }
                }
            }
        }

        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
        {
            if (player.getInventory().getItemInHand().getType() == Material.BLAZE_POWDER)
            {
                if (player.hasPermission("rq.powers"))
                {
                    TNTPrimed tnt = (TNTPrimed)player.getWorld().spawn(player.getEyeLocation(), TNTPrimed.class);
                    tnt.setVelocity(player.getEyeLocation().getDirection().multiply(2));
                    tnt.setFuseTicks(40);
                    player.sendMessage(ChatColor.RED + "TNT Launched!");
                    int amount = player.getInventory().getItemInHand().getAmount();
                    amount--;
                    if (amount == 0)
                    {
                        player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.BLAZE_POWDER) });
                    }
                    else
                        player.getInventory().getItemInHand().setAmount(amount);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerEggThrow(PlayerEggThrowEvent event)
    {
        Player player = event.getPlayer();
        if (player.hasPermission("rq.powers"))
        {
            event.getEgg().remove();
            Egg egg = event.getEgg();
            event.setHatching(false);
            event.getEgg().getWorld().createExplosion(egg.getLocation(), 0.0F);

            if (player.getLocation().distance(event.getEgg().getLocation()) <= 4.0D)
            {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 3));
            }player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0), true);
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 1), true);
        }
    }

    @EventHandler
    public boolean onPlayerInteract(PlayerInteractEvent event)
    {
        final Player p = event.getPlayer();
        if (p.hasPermission("rq.powers"))
        {
            if ((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)))
            {
                if (event.getPlayer().getItemInHand().getType() == Material.BLAZE_ROD)
                {
                    if (this.cooldown.contains(p))
                    {
                        p.sendMessage(ChatColor.DARK_RED + "Please wait 5 seconds between use!");
                    }
                    else {
                        event.getPlayer().getWorld().strikeLightning(event.getPlayer().getTargetBlock(null, 200).getLocation());
                        p.sendMessage(ChatColor.RED + "Lightning used: " + ChatColor.YELLOW + "5 second cooldown");
                        this.cooldown.add(p);
                        getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable()
                        {
                            public void run() {
                                RageQuit.this.cooldown.remove(p);
                                p.sendMessage(ChatColor.RED + "You can now use lightning again!");
                            }
                        }
                        , 100L);
                    }
                }
            }

        }

        return true;
    }

    @EventHandler(priority=EventPriority.NORMAL)
    public void onProjectileHit(ProjectileHitEvent event) {
        Entity entity = event.getEntity();
        if ((entity instanceof Arrow)) {
            Arrow arrow = (Arrow)entity;
            Entity shooter = arrow.getShooter();
            if ((shooter instanceof Player)) {
                Player player = (Player)shooter;
                player.getWorld().createExplosion(arrow.getLocation(), 2.0F);
            }
        }
    }

    @EventHandler
    public void tickDamageEvent(EntityDamageEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.FALL)
        {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public boolean onPlayerInteractEvent1(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (player.hasPermission("rq.powers"))
        {
            if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && 
                    (event.getPlayer().getItemInHand().getType() == Material.QUARTZ)) {
                if (this.jump.contains(player)) {
                    player.sendMessage(ChatColor.DARK_RED + "Please wait 5 seconds between use!");
                } else {
                    player.setVelocity(player.getEyeLocation().getDirection().multiply(3));
                    player.sendMessage(ChatColor.RED + "Jump used: " + ChatColor.YELLOW + "5 second cooldown");
                    this.jump.add(player);
                    getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable()
                    {
                        public void run() {
                            RageQuit.this.jump.remove(player);
                            player.sendMessage(ChatColor.RED + "You can now use jump again!");
                        }
                    }
                    , 100L);
                }
            }

        }

        return true;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if ((cmd.getName().equalsIgnoreCase("ragequit")))
        {
            sender.sendMessage(ChatColor.GOLD + "[RageQuit]" + ChatColor.GREEN + " Reloading configuration files");
            sender.sendMessage(ChatColor.GOLD + "[RageQuit]" + ChatColor.GREEN + " Plugin Reloaded!");
            sender.sendMessage(ChatColor.GOLD + "[RageQuit]" + ChatColor.GREEN + " Version 1.1 by sgtcaze");
            reloadConfig();
        }
        return true;
    }
}