package com.vanillafun.tools;

import com.vanillafun.tools.listeners.SpawnListener;
import com.vanillafun.tools.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class VanillaFunTools extends JavaPlugin {

	public static String Color(String s){
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	public final Logger logger = Bukkit.getLogger();
	private static VanillaFunTools plugin;

	@Override
	public void onEnable() {
		// Logger
		plugin = this;

		PluginManager pm = this.getServer().getPluginManager();
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been Enabled.");

		getConfig().options().copyDefaults();
		saveDefaultConfig();

		// Commands
		getCommand("speed").setExecutor(new SpeedCommand());
		getCommand("god").setExecutor(new GodCommand());
		getCommand("feed").setExecutor(new FeedCommand());
		getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
		getCommand("spawn").setExecutor(new SpawnCommand(this));
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("clear").setExecutor(new ClearCommand());
		getCommand("tsp").setExecutor(new TeleportCommand());
		getCommand("gm").setExecutor(new GamemodeCommand());
		getCommand("fart").setExecutor(new FartCommand());

		// Listeners
		getServer().getPluginManager().registerEvents(new SpawnListener(this), this);

	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public static VanillaFunTools getPlugin() {
		return plugin;
	}

}
