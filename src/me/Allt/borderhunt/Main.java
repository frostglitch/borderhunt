package me.Allt.borderhunt;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	  @Override
	  public void onEnable()
	  {
		  //Assign command to Commands.java
		  getCommand("borderhunt").setExecutor(new Commands(this));
		  //Assign tab-completer to CommandCompleter.java
		  getCommand("borderhunt").setTabCompleter(new CommandCompleter());
	  }
	  
	  @Override
	  public void onDisable()
	  {

	  }
}
