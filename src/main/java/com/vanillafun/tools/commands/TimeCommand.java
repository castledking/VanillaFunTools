package com.vanillafun.tools.commands;

import com.vanillafun.tools.VanillaFunTools;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.generator.WorldInfo;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)){

			if(args.length == 0){
				System.out.println(VanillaFunTools.Color("&7Usage: &3/time &6(day/night/noon) &6(world)"));
			}
			String time = args[0];

		}

		return true;
	}
}
