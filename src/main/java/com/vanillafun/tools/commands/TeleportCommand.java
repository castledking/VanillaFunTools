package com.vanillafun.tools.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)){

			String playerX = args[0];
			String playerZ = args[1];
			Player x = Bukkit.getServer().getPlayerExact(playerX);
			Player z = Bukkit.getServer().getPlayerExact(playerZ);
			if (args.length == 0){
				System.out.println("&7Usage: &3/tp &6[playerName] (playerName)");
			}
			if (x == null || z == null) {
				System.out.println("&cCould not find a player with this name!");
			}
			Location location = z.getLocation();
			x.teleport(location);
			System.out.println("&7Teleported &3" + x.getDisplayName() + "&7to &3" + z.getDisplayName());
		}
		Player p = (Player) sender;

		String playerX = args[0];
		String playerZ = args[1];
		Player x = Bukkit.getServer().getPlayerExact(playerX);
		Player z = Bukkit.getServer().getPlayerExact(playerZ);
		if (p.hasPermission("vft.tp")) {
			if (args.length == 0) {
				p.sendMessage("&7Usage: &3/tp &6[playerName] (playerName)");
			}
			if (x == null || z == null) {
				p.sendMessage("&cCould not find a player with this name!");
			}
			if (args.length == 1) {
				try {
					Location location = x.getLocation();
					p.teleport(location);
					p.sendMessage("&7Teleported to &3" + x.getDisplayName());
				}catch(NullPointerException e){
					p.sendMessage("&cCould not teleport to unsafe location.");
				}
			}
			try {
				Location location = z.getLocation();
				p.teleport(location);
				p.sendMessage("&7Teleported &3" + x.getDisplayName() + "&7to &3" + z.getDisplayName());
			}catch(NullPointerException e){
				p.sendMessage("&cCould not teleport to unsafe location.");
			}
		}

		return true;
	}
}
