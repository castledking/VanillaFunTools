package com.vanillafun.tools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(sender instanceof Player p){
			if (args.length != 0) {
				String playerName = args[0];

				Player target = Bukkit.getServer().getPlayerExact(playerName);

				if(target == null){
					p.sendMessage("This player is not online.");
				}else{
					p.sendMessage(target.getDisplayName() + ChatColor.YELLOW + " has been sated.");
					target.sendMessage(ChatColor.YELLOW + "You have been sated.");
					target.setFoodLevel(20);
					target.setSaturation(20);
				}

			} else {
				p.setSaturation(20);
				p.setFoodLevel(20);
				p.sendMessage(ChatColor.YELLOW + "You have been sated.");
			}

		}



		return true;
	}
}
