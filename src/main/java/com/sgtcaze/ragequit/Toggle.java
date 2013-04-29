package com.sgtcaze.ragequit;

import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class Toggle
implements Listener
{
    private RageQuit plugin;

    public Toggle(RageQuit instance)
    {
        this.plugin = instance;
    }

    @EventHandler(priority=EventPriority.NORMAL)
    public void onExplosionPrime(ExplosionPrimeEvent event)
    {
        if ((event.getEntity() instanceof TNTPrimed)) {
            if (this.plugin.getConfig().getString("DisableExplosion").equalsIgnoreCase("true")) {
                event.setCancelled(true);
            } 
        }
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        if (this.plugin.getConfig().getString("DisableBlockDamage").equalsIgnoreCase("true")) {
            event.setCancelled(true);
        }
    }
}