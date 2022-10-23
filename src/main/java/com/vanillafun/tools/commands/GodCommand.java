package com.vanillafun.tools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player){

			Player p = (Player) sender;

			if (p.isInvulnerable()){
				p.setInvulnerable(false);
				p.sendMessage(ChatColor.RED + "God mode disabled.");
			}else{

				p.setInvulnerable(true);
				p.sendMessage(ChatColor.GREEN + "God mode enabled.");
				return true;
			}

		}else{
			if(args.length == 0){
				System.out.println("&7Usages: &e/god &6(playerName)");
			}
			String playerName = args[0];
			Player target = Bukkit.getServer().getPlayerExact(playerName);
			if(target == null){
				System.out.println("&cCould not find a player with this name!");
			}
			if(target.isInvulnerable()){
				target.setInvulnerable(false);
				target.sendMessage("&7God mode disabled for &3" + target.getDisplayName());
			}else{
				target.setInvulnerable(true);
				target.sendMessage("&7God mode enabled for &3" + target.getDisplayName());
			}
		}


		return true;
	}
}
