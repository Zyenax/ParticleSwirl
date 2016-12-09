package net.Snickzz.main.utils;

import net.Snickzz.main.Main;
import net.minecraft.server.v1_9_R1.EnumParticle;
import net.minecraft.server.v1_9_R1.PacketPlayOutWorldParticles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Packets implements Listener{
	
	Location loc = new Location(Bukkit.getWorld("world"), -1302.5, 95, -1264.5);
	
	private static Main plugin;
	public Packets(Main listener) {
		Packets.plugin = listener;	
		createParticleHelix(loc, 5, 7, 0, EnumParticle.FIREWORKS_SPARK);
		createParticleHelix(loc, 5, 7, 5, EnumParticle.FIREWORKS_SPARK);
		createParticleHelix(loc, 5, 7, 10, EnumParticle.FIREWORKS_SPARK);
		createParticleHelix(loc, 5, 7, 15, EnumParticle.FIREWORKS_SPARK);
		createParticleHelix(loc, 5, 7, 20, EnumParticle.FIREWORKS_SPARK);
		startLightning();
	}
	
	public void startLightning(){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
    		public void run() {
    			int i = Utils.randomNum(1, 10);
    			if(i == 5){
    				Bukkit.getWorld("world").strikeLightningEffect(loc);
    			}
    		}
		}, 0, 2 * 20);
	}
	
	public static void createParticleHelix(final Location loc, final Integer MaxHeight, final Integer radius, final Integer rotation, final EnumParticle particletype) {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
			double y = 0;
    		public void run() {
		if(y > MaxHeight){
			y=0;
		}
			y = y + 0.05;
	        double x = radius * Math.cos(y + rotation);
	        double z = radius * Math.sin(y + rotation);
	        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particletype, true, (float) (loc.getX() + x), (float) (loc.getY() + y), (float) (loc.getZ() + z), 0, 0, 0, 0, 1, null);
	        for(Player online : Bukkit.getOnlinePlayers()) {
	            ((CraftPlayer)online).getHandle().playerConnection.sendPacket(packet);
	        }
    		}
		}, 0, 1);
	}

}
