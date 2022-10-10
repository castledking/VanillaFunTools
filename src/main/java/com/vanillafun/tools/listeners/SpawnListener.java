package com.vanillafun.tools.listeners;


import com.vanillafun.tools.VanillaFunTools;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {

	private final VanillaFunTools plugin;

	public SpawnListener(VanillaFunTools plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){

		Player player = e.getPlayer();

		if(!player.hasPlayedBefore()){
			Location location = plugin.getConfig().getLocation("spawn");

			if(location != null){
				player.teleport(location);
			}
		}

	}

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e){
		Location location = plugin.getConfig().getLocation("spawn");
		if (location != null){
			e.setRespawnLocation(location);
		}
	}

}
