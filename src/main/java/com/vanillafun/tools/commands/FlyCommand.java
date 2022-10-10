package com.vanillafun.tools.commands;

import com.vanillafun.tools.VanillaFunTools;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


		if (sender instanceof Player p) {
			if(args.length != 0 && p.hasPermission("vft.fly")) {

				String playerName = args[0];
				Player target = Bukkit.getPlayer(playerName);
				if (target != null && p.hasPermission("vft.fly.others")){
					String onf = null;
					if(target.isOnline()){
						onf = " &7(&6Online&7)";
					}else{
						onf = " &7(&cOffline&7)";
					}
					if (args[1].equalsIgnoreCase("on")){
						target.setFlying(true);
						p.sendMessage(VanillaFunTools.Color("&7You have set fly to &6Enabled &7for " + target.getName() + onf));
						return true;
					}
					if (args[1].equalsIgnoreCase("off")){
						target.setFlying(false);
						p.sendMessage(VanillaFunTools.Color("&7You have set fly to &cDisabled &7for " + target.getName() + onf));
					}else{
						if(p.isFlying()){
							p.setFlying(false);
							p.sendMessage(VanillaFunTools.Color("&7You have set fly to &cDisabled &7for " + target.getName() + onf));
						}else{
							p.setFlying(true);
							p.sendMessage(VanillaFunTools.Color("&7You have set fly to &6Enabled &7for " + target.getName() + onf));
						}
					}
				}else{
					if(!p.hasPermission("vft.fly.others")){
						p.sendMessage(VanillaFunTools.Color("&cYou don't have permission!"));
					}else{
						p.sendMessage(VanillaFunTools.Color("&cCould not find a player with that name!"));
					}
					return true;
				}

			}else{
				if(p.hasPermission("vft.fly")) {
					if (p.isFlying()) {
						p.setFlying(false);
						p.sendMessage(VanillaFunTools.Color("&7You have set fly to &cDisabled &7for " + p.getName() + " &7(&6Online&7)"));
					}else{
						p.setFlying(true);
						p.sendMessage(VanillaFunTools.Color("&7You have set fly to &6Enabled &7for " + p.getName() + " &7(&6Online&7)"));
					}
				}else{
					p.sendMessage(VanillaFunTools.Color("&cYou don't have permission!"));
				}
				return true;
			}
			}else{
			if(args.length != 0){
				String playerName = args[0];
				Player target = Bukkit.getPlayer(playerName);
				if (target != null){
					String onf = null;
					if(target.isOnline()){
						onf = " &7(&6Online&7)";
					}else{
						onf = " &7(&cOffline&7)";
					}
					if (args[1].equalsIgnoreCase("on")) {
						target.setFlying(true);
						System.out.println(VanillaFunTools.Color("&7You have set fly to &6Enabled &7for " + target.getName() + onf));
						return true;
					}
					if (args[1].equalsIgnoreCase("off")){
						target.setFlying(false);
						System.out.println(VanillaFunTools.Color("&7You have set fly to &cDisabled &7for " + target.getName() + onf));
					}
				}else{
					System.out.println(VanillaFunTools.Color("&cCould not find a player with that name!"));
				}
			}else{
				System.out.println(VanillaFunTools.Color("&7Usage: &3/fly &6[playerName] (on/off)"));
			}
		}
		return true;
	}
}

