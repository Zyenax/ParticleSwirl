package net.Snickzz.main;

import net.Snickzz.main.utils.Packets;
import net.Snickzz.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	public void onEnable(){
		Listeners();
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(Utils.color("&eParticleSwirl has been enabled!"));
	}
	
	public void onDisable(){
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(Utils.color("&eParticleSwirl has been disabled!"));
	}
	
	public void Listeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Packets(this), this);
		pm.registerEvents(new Utils(this), this);
	}
	
}
