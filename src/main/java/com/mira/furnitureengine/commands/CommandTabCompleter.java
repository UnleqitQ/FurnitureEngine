package com.mira.furnitureengine.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.mira.furnitureengine.FurnitureEngine;

public class CommandTabCompleter implements TabCompleter {
	FurnitureEngine main = FurnitureEngine.getPlugin(FurnitureEngine.class);
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args){
		
		if(args.length == 1) {
			List<String> autoCompletion = new ArrayList<>();
			autoCompletion.add("reload");
			autoCompletion.add("give");
			autoCompletion.add("remove");
			autoCompletion.add("get");
			
			return autoCompletion;
		}
		if(args.length == 2&&args[0].equals("give")) {
			List<String> autoCompletion = new ArrayList<>();
			
			for (Player p : Bukkit.getOnlinePlayers()) {
				autoCompletion.add(p.getName());
            }
			
			return autoCompletion;
		}
		if(args.length == 3&&args[0].equals("give")) {
			List<String> autoCompletion = new ArrayList<>();
			
			main.getConfig().getConfigurationSection("Furniture").getKeys(false).forEach(key -> {
				autoCompletion.add(key);
			});
			
			return autoCompletion;
		}
		if(args.length ==4&&args[0].equals("give")) {
			List<String> autoCompletion = new ArrayList<>();
			autoCompletion.add(Integer.toString(1));
			return autoCompletion;
		}
		
		if(args.length == 2&&args[0].equals("get")) {
			List<String> autoCompletion = new ArrayList<>();
			
			main.getConfig().getConfigurationSection("Furniture").getKeys(false).forEach(key -> {
				autoCompletion.add(key);
			});
			
			return autoCompletion;
		}
		if(args.length == 3&&args[0].equals("get")) {
			List<String> autoCompletion = new ArrayList<>();
			autoCompletion.add(Integer.toString(1));
			return autoCompletion;
		}
		if(args.length == 2&&args[0].equals("remove")) {
			List<String> autoCompletion = new ArrayList<>();
			
			autoCompletion.add("0");
			
			return autoCompletion;
		}
		if(args.length == 3&&args[0].equals("remove")) {
			List<String> autoCompletion = new ArrayList<>();
			
			autoCompletion.add("0");
			
			return autoCompletion;
		}
		if(args.length == 4&&args[0].equals("remove")) {
			List<String> autoCompletion = new ArrayList<>();
			
			autoCompletion.add("0");
			
			return autoCompletion;
		}
		return null;
	}
	
}