package me.abetgt.villagercureevent;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;

public final class VillagerCureEvent extends EntityEvent implements Cancellable {
    public static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;

    private Location eventLocationCured;

    /**
     * The VillagerCureEvent fires when a zombie villager turns into a normal villager after being cured.
     * @param curedEntity The entity that was cured.
     * @param locationCured The location where the entity was cured.
     */
    public VillagerCureEvent(Entity curedEntity, Location locationCured){
        super(curedEntity);
        eventLocationCured = locationCured;
    };

    /**
     * Returns the location that the entity was cured at.
     * @return Location (org.bukkit.Location) | Entity's location
     */
    public Location getLocation() {return eventLocationCured;}
    
        public static HandlerList getHandlerList(){
        return handlers;
    }
    public HandlerList getHandlers(){
        return handlers;
    }
    public boolean isCancelled(){
        return this.cancel;
    }
    public void setCancelled(boolean cancel){
        this.cancel = cancel;
    }
}
