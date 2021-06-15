package me.Allt.borderhunt;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class CommandCompleter implements TabCompleter
{
	  List<String> arguments = new ArrayList<String>();	  
	  List<String> result = new ArrayList<String>();
	  
	  @Override
	  public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args)
	  {
		    if(arguments.isEmpty())
		    {
		    	arguments.add("start");
		    	arguments.add("stop");
		    	arguments.add("time");
		    	arguments.add("increment");
		    }		    		    
		    
		    if(cmd.getName().equalsIgnoreCase("borderhunt"))
		    {
			      if(args.length == 1)
			      {
					result.clear();
					
					for(String s : arguments)
					{
						  if(s.toLowerCase().startsWith(args[0].toLowerCase())) result.add(s);
					}	
					
					return result;
			      }
		    }
		    
		    result.clear();
		    return result;
	  }
}
