package com.vanillafun.tools.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class MenuCommand implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		Player p = (Player) sender;

		Inventory inventory = Bukkit.createInventory(p, 9, ChatColor.RED + "Potato Time");

		ItemStack item = new ItemStack(Material.STONE_BUTTON, 1);
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(ChatColor.GREEN + "Click me.");
		item.setItemMeta(itemMeta);

		inventory.setItem(4, item);

		p.openInventory(inventory);

		return true;
	}
}
