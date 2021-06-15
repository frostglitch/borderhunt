package me.Allt.borderhunt;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	  @Override
	  public void onEnable()
	  {
		  getCommand("borderhunt").setExecutor(new Commands());
		  getCommand("borderhunt").setTabCompleter(new CommandCompleter());
	  }
	  
	  @Override
	  public void onDisable()
	  {

	  }
}
