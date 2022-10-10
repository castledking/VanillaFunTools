package com.vanillafun.tools.commands;

import com.vanillafun.tools.VanillaFunTools;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

	private final VanillaFunTools plugin;

	public SetSpawnCommand(VanillaFunTools plugin) {
		this.plugin = plugin;
	}


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player){
			Player player = (Player) sender;
			Location location = player.getLocation();
			plugin.getConfig().set("spawn", location);
			plugin.saveConfig();
			player.sendMessage("Spawn location set!");
		}else{
			System.out.println("You can't run this command.");
		}




		return true;
	}
}
