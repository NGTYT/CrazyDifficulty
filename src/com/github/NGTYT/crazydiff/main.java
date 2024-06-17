package com.github.NGTYT.crazydiff;



import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	  private static main instance;
	  
	  public static main getInstance() {
	    return instance;
	    
	
	    
	    
	  
	  }

	  public void onEnable() {
	    instance = this;
	    getServer().getPluginManager().registerEvents(new events(this), this);
	    this.saveDefaultConfig();
	   
	    
	  }
	  
	  public void onDisable() {
	    instance = null;

	  }
	  
	  
	  
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
if (!command.getName().equalsIgnoreCase("CrazyDifficulty-reload")) return super.onCommand(sender, command, label, args);
		        reloadConfig();
		        sender.sendMessage (ChatColor.translateAlternateColorCodes('&',
		        this.getConfig().getString("message.reload")));
		        return true;
		        

	  }

}