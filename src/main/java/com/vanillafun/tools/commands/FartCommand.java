package com.vanillafun.tools.commands;

import com.vanillafun.tools.VanillaFunTools;
import github.scarsz.discordsrv.hooks.vanish.VanishNoPacketHook;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public class FartCommand implements CommandExecutor {

	//key = uuid of player
	//long = the epoch time of when they ran the command
	private final HashMap<UUID, Long> cooldown;

	public FartCommand(){
		this.cooldown = new HashMap<>();
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (sender instanceof Player) {

			Player player = (Player) sender;

			if (!this.cooldown.containsKey(player.getUniqueId())) {
				this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());

				player.sendMessage(VanillaFunTools.Color("&cYou farted! whoopsies..."));

			}else{

				//difference in ms
				long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
				timeElapsed = timeElapsed / 1000;

				if (timeElapsed >= 300){

					this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
					player.sendMessage(VanillaFunTools.Color("&cYou farted! whoopsies..."));
				}else{
					player.sendMessage(VanillaFunTools.Color("&7You can't fart again for another " + (300 - timeElapsed) + "seconds!"));
				}


			}

		}

		return true;
	}
}
