package me.Allt.borderhunt;

import java.sql.Time;

import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class Commands implements CommandExecutor
{
	private int time = 0;
	private int increment = 0;
	
	  @Override
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	  {
		  	//If we try sending this command via Server Command Line or through another entity
		    if(!(sender instanceof Player))
		    {
			      sender.sendMessage("Only players can use the command!");
			      return true;
		    }
		    
		    Player player = (Player)sender;
		    
		    if(cmd.getName().equalsIgnoreCase("borderhunt"))
		    {
			      if(args.length == 0 || args.length > 2)
			      {
					player.sendMessage("§4Incorrect command usage.");
					return true;
			      }
			      
			      if(args.length == 1)
			      {
			    	  if(args[0].equals("start"))
			    	  {
			    		  //Example: /borderhunt start
				    	  
				    	  player.sendMessage("§6§lBorder increased by 10.");
					      
					      WorldBorder border = player.getWorld().getWorldBorder();
					      border.setSize(border.getSize() + increment);
			    	  }
			    	  else if(args[0].equals("stop"))
			    	  {
			    		  //Example: /borderhunt stop
			    		  
			    		  player.sendMessage("§dBorderhunt STOP!");
			    	  }
			    	  else 
			    	  {
			    		  player.sendMessage("§4Incorrect command usage.");
			    	  }
			      }

			      if(args.length == 2)
			      {
			    	  if(args[0].equals("time"))
			    	  {
			    		  //Example: /borderhunt time 30
			    		  
			    		  int value = Integer.parseInt(args[1]);
			    		  time = value;
			    		  
			    		  player.sendMessage("§6Time changed to: §2§l" + args[1] + " seconds.");
			    	  }
			    	  else if (args[0].equals("increment"))
			    	  {
			    		  //Example: /borderhunt increment 50
			    		  
			    		  int value = Integer.parseInt(args[1]);
			    		  increment = value;
			    		  
			    		  player.sendMessage("§6Increment changed to: §2§l" + args[1]);
			    	  }
			    	  else 
			    	  {
			    		  player.sendMessage("§4Incorrect command usage.");
			    	  }
			    	  
			    	  return true;
			     }
		   }
		    
		   return true;
	  }
}
