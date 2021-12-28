package com.mira.furnitureengine.api.events;


import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.mira.furnitureengine.FurnitureEngine;


public class FurniturePlaceEvent extends Event{
	FurnitureEngine main = FurnitureEngine.getPlugin(FurnitureEngine.class);

	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled;
	
	private Player interactingPlayer; 
	
	private Location furnitureLocation;
	
	
	public FurniturePlaceEvent(Player interactingPlayer, Location furnitureLocation) {
		this.interactingPlayer = interactingPlayer;
		this.furnitureLocation = furnitureLocation;
	}
	
	public Player getPlayer() {
		return interactingPlayer;
	}
	
	public Location getFurnitureLocation() {
		return furnitureLocation;
	}
	
	public boolean isCancelled() {
		return cancelled;
	}
	
	public void setCancelled(boolean cancel) {
		cancelled = cancel;
	}

	public HandlerList getHandlers() {
	    return handlers;
	}

	public static HandlerList getHandlerList() {
	    return handlers;
	}

}
