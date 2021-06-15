package me.Allt.borderhunt;

import org.bukkit.Bukkit;
import org.bukkit.WorldBorder;
import org.bukkit.scheduler.BukkitRunnable;

public class BorderTask extends BukkitRunnable
{
	  //Reference to Main.java
	  Main plugin;
	  //How much blocks to increment
	  int increment;
	  
	  //Constructor
	  public BorderTask(Main plugin, int increment)
	  {
		    this.plugin = plugin;
		    this.increment = increment;
	  }
	  
	  //Code in this function happens when we call BorderTask.runTimer()
	  public void run()
	  {
		  //Get the border
		  WorldBorder border = Bukkit.getServer().getWorld("world").getWorldBorder();
		  //Increment the size
	      border.setSize(border.getSize() + increment);
	      
	      //Send a title to all players in the actionbar, notifying about the border
	      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title @a actionbar {\"text\":\"\\u26a0 Border has expanded \\u26a0\",\"bold\":true,\"color\":\"gold\"}");
	  }
}
