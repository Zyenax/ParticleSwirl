package net.Snickzz.main.utils;

import java.util.Random;

import net.Snickzz.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;

public class Utils implements Listener{
	
	@SuppressWarnings("unused")
	private static Main plugin;

	public Utils(Main hub) {
		Utils.plugin = hub;
	}

	public static String color(String string){
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
	public static int randomNum(int Low, int High){
		Random r = new Random();
		int R = r.nextInt(High-Low) + Low;
		return R;
	}
	
}
