package com.vanillafun.tools.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)){

			if(args.length == 0) {
				System.out.println("&7Usage: &3/clear &6[playerName] -a");
			}
			String playerName = args[0];
			Player target = Bukkit.getServer().getPlayerExact(playerName);

			if(target == null){
				System.out.println("&cCould not find a player with this name!");
			}
			target.getInventory().clear();
			System.out.println("&7Inventory has been cleared for &3" + target.getDisplayName());


		}

		Player p = (Player) sender;
		if(args.length == 0) {
			p.sendMessage("&7Inventory has been cleared.");
		}
		String playerName = args[0];
		Player target = Bukkit.getServer().getPlayerExact(playerName);
		if(target == null){
			p.sendMessage("&cCould not find a player with this name!");
		}
		target.getInventory().clear();
		p.sendMessage("&7Inventory has been cleared for &3" + target.getDisplayName());

		return true;
	}
}
