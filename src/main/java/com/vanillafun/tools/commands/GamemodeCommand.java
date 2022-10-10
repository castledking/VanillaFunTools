package com.vanillafun.tools.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {

			if (args.length == 0) {
				System.out.println("&7Usage: &3/gm &6[playerName] &6(gamemode)");
			}
			if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")){
				System.out.println("&7Set gamemode to &3Survival");
			}
		}
		return true;
	}
}
