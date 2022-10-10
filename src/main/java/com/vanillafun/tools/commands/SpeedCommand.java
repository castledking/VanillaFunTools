package com.vanillafun.tools.commands;

import com.vanillafun.tools.VanillaFunTools;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {

	public SpeedCommand() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			if (args.length == 0) {
				System.out.println(VanillaFunTools.Color("&4Number can't be less than 0!"));
				return true;
			}
				String playerName = args[0];
				Player target = Bukkit.getServer().getPlayerExact(playerName);
				if (target == null) {
					System.out.println(VanillaFunTools.Color("&cCan't find player with this name!"));
					return true;
				}
				float amount = Float.parseFloat(args[1]);
				if (amount < 0 || amount > 10) {
					System.out.println(VanillaFunTools.Color("&cPlease provide a speed from 1-10"));
					return true;
				}
				if (target.isFlying()){
					target.setFlySpeed(amount / 10);
					System.out.println(VanillaFunTools.Color("&7You have set &3" + amount + " &7fly speed for &e" + target.getDisplayName()));
				}else{
					target.setWalkSpeed(amount / 10);
					System.out.println(VanillaFunTools.Color("&7You have set &3" + amount + " &7walk speed for &e" + target.getDisplayName()));
				}
			}else {
			Player p = (Player) sender;
			if (!p.hasPermission("vftools.speed")) {

				p.sendMessage(VanillaFunTools.Color("&cYou don't have permission!"));
				return true;

			}
			if (args.length == 0) {
				p.sendMessage(VanillaFunTools.Color("&4Number can't be less than 0!"));
				return true;
			}
			try {
				float amount = Float.parseFloat(args[0]);
				if (amount < 0 || amount > 10) {
					p.sendMessage(VanillaFunTools.Color("&cPlease provide a speed from 1-10"));
				}
				if (p.isFlying()) {
					p.setFlySpeed(amount / 10);
					p.sendMessage(VanillaFunTools.Color("&7You have set &3" + amount + " &7fly speed for &e" + p.getDisplayName()));
				} else {
					p.setWalkSpeed(amount / 10);
					p.sendMessage(VanillaFunTools.Color("&7You have set &3" + amount + " &7walk speed for &e" + p.getDisplayName()));
				}
				return true;
			} catch (NumberFormatException e) {
				String playerName = args[0];
				Player target = Bukkit.getServer().getPlayerExact(playerName);
				if (target == null) {
					p.sendMessage(VanillaFunTools.Color("&cCan't find player with this name!"));
					return true;
				}
				float amount = Float.parseFloat(args[1]);
				if (amount < 0 || amount > 10) {
					p.sendMessage(VanillaFunTools.Color("&cPlease provide a speed from 1-10"));
					return true;
				}
				if (target.isFlying()) {
					target.setFlySpeed(amount / 10);
					p.sendMessage(VanillaFunTools.Color("&7You have set &3" + amount + " &7fly speed for &e" + p.getDisplayName()));
				} else {
					target.setWalkSpeed(amount / 10);
					p.sendMessage(VanillaFunTools.Color("&7You have set &3" + amount + " &7walk speed for &e" + p.getDisplayName()));
				}
			}
		}
		return true;
	}

}
