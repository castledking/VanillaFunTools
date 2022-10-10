package com.vanillafun.tools.commands;

import com.vanillafun.tools.VanillaFunTools;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

	public final VanillaFunTools plugin;

	public SpawnCommand(VanillaFunTools plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;

			Location location = plugin.getConfig().getLocation("spawn");
			if (location != null){
				player.teleport(location);
				player.sendMessage("Teleporting you to spawn!");
			}else{
				player.sendMessage(ChatColor.RED + "No spawnpoint has been set!");
			}
		}

		return true;
	}
}
