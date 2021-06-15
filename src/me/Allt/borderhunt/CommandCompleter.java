package me.Allt.borderhunt;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class CommandCompleter implements TabCompleter
{
	  //List of all words in tab-completer
	  List<String> arguments = new ArrayList<String>();	  
	  //List of all words currently appearing
	  List<String> result = new ArrayList<String>();
	  
	  @Override
	  public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args)
	  {
		  	//Populating the list
		    if(arguments.isEmpty())
		    {
		    	arguments.add("start");
		    	arguments.add("stop");
		    	arguments.add("time");
		    	arguments.add("increment");
		    	arguments.add("initial");
		    	arguments.add("pause");
		    	arguments.add("resume");
		    }		    		    
		    
		    //If the command is /borderhunt
		    if(cmd.getName().equalsIgnoreCase("borderhunt"))
		    {
		    	  //We only have words for the first argument
			      if(args.length == 1)
			      {
			    	//Clear the result list
					result.clear();
					
					//Fillign result list
					for(String s : arguments)
					{
						  //Check if the word we started typing is contained in the list
						  if(s.toLowerCase().startsWith(args[0].toLowerCase())) result.add(s);
					}	
					
					//Returning result list
					return result;
			      }
		    }
		    
		    //If the command is not borderhunt, return nothing
		    return null;
	  }
}
