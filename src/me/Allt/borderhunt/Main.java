package me.Allt.borderhunt;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	  @Override
	  public void onEnable()
	  {
		  getCommand("borderhunt").setExecutor(new Commands());
	  }
	  
	  @Override
	  public void onDisable()
	  {

	  }
}
