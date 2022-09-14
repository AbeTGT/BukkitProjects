package me.abetgt.villagercureevent;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class VillagerCureHandler extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onVillagerCure(CreatureSpawnEvent event){
        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CURED){
            LivingEntity entity = event.getEntity();
            VillagerCureEvent villagerCureEvent = new VillagerCureEvent(entity, event.getLocation());
            Bukkit.getServer().getPluginManager().callEvent(villagerCureEvent);
            if (villagerCureEvent.isCancelled()) {event.setCancelled(true);}
        }
    }
}
