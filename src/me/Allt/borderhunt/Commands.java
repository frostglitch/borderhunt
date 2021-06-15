package me.Allt.borderhunt;

import org.bukkit.Location;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor
{
	  //BORDERHUNT BORDERHUNT
	
	  //Seconds to wait before next increment
	  private int time = 10;
	  //How much blocks to increment
	  private int increment = 10;
	  //When running /borderhunt start, how many blocks wide should the border be
	  private int initial = 30;
	  //Task for handling waiting and expanding border
	  private BorderTask borderTask = null;
	  //Reference to Main.java
	  private Main main;
	
	  
	  //Constructor - Used to give this class a reference to Main
	  public Commands(Main main) 
	  {
		  this.main = main;
	  }
	  
	  @Override
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	  {
		  	//If we try sending this command via Server Command Line or through another entity
		    if(!(sender instanceof Player))
		    {
			      sender.sendMessage("Only players can use the command!");
			      return true;
		    }
		    
		    //Get the player
		    Player player = (Player)sender;
		    
		    //If the command is "borderhunt"
		    if(cmd.getName().equalsIgnoreCase("borderhunt"))
		    {
		    	  //If we have 0 arguments (just /borderhunt) or more than 2 (/borderhunt initial 20 30)
			      if(args.length == 0 || args.length > 2)
			      {
					player.sendMessage("§4Incorrect command usage.");
					return true;
			      }
			      
			      //If we have only 1 argument
			      if(args.length == 1)
			      {
			    	  if(args[0].equals("start"))
			    	  {
			    		  //borderhunt start
			    		  
			    		  //If we have not initialized the task yet
			    		  if(borderTask == null)
			    		  {
			    			  //Get worldborder
			    			  WorldBorder border = player.getWorld().getWorldBorder();
			    			  
			    			  //Get X and Z from player
			    			  double x = player.getLocation().getX();
			    			  double z = player.getLocation().getZ();
			    			  //X and Z should be rounded for pixel-perfect worldborder on blocks
			    			  Location borderLocation = new Location(player.getWorld(), (int)Math.round(x), 0, (int)Math.round(z));
			    					  	  
			    			  //Set center to the location we just calculated
			    			  border.setCenter(borderLocation);
			    			  //Set the size to initial
			    			  border.setSize(initial);
			    			  
			    			  //Start the task
			    			  borderTask = new BorderTask(main, increment);   
						      borderTask.runTaskTimer(main, 0, time * 20); //time is multiplied by 20 because the function takes ticks instead of seconds
						      
						      player.sendMessage("§6§lBorderhunt START!");
			    		  }
			    		  else
			    		  {
			    			  player.sendMessage("§4Borderhunt already running. Use §l/borderhunt stop " + "§4to stop the border.");
			    		  }
			    	  }
			    	  else if(args[0].equals("stop"))
			    	  {
			    		  //borderhunt stop
			    		  
			    		  if(borderTask == null)
			    		  {
			    			  player.sendMessage("§4Borderhunt is not running. Use §l/borderhunt start " + "§4to start the border.");
			    		  }
			    		  else
			    		  {
			    			  //Stop the timer and clear the variable
			    			  borderTask.cancel();
			    			  borderTask = null;
			    			  
			    			  player.sendMessage("§6§lBorderhunt STOP!");
			    		  }
			    	  }
			    	  else if(args[0].equals("pause"))
			    	  {
			    		  //borderhunt pause
			    		  
			    		  //Stop the task, but the variable stays
		    			  borderTask.cancel();
		    			  player.sendMessage("§6§lBorderhunt PAUSED");
			    	  }
			    	  else if(args[0].equals("resume"))
			    	  {
			    		  //borderhunt resume
			    		  
			    		  //Start the task
			    		  borderTask = new BorderTask(main, increment);   
			    		  borderTask.runTaskTimer(main, 0, time * 20);
		    			  player.sendMessage("§6§lBorderhunt RESUMED");
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
			    		  //borderhunt time 30
			    		  
			    		  try 
			    		  {
			    			  //Get int value from the argument from the command
				    		  int value = Integer.parseInt(args[1]);
				    		  time = value;
						  } 
			    		  catch (NumberFormatException e) 
			    		  {
			    			  //The argument is not a number!
			    			  player.sendMessage("§4Incorrect input! Only integers are allowed");
			    			  return true;
						  }
			    		  
			    		  //Reset the task
			    		  if(borderTask != null)
			    		  {
			    			  borderTask.cancel();
				    		  borderTask = new BorderTask(main, increment);   
						      borderTask.runTaskTimer(main, 0, time * 20);
			    		  }
			    		  
			    		  player.sendMessage("§6Time changed to: §2§l" + args[1] + " seconds");
			    	  }
			    	  else if (args[0].equals("increment"))
			    	  {
			    		  //borderhunt increment 50
			    		  
			    		  try 
			    		  {
			    			  //Get int value from the argument from the command
				    		  int value = Integer.parseInt(args[1]);
				    		  time = value;
						  } 
			    		  catch (NumberFormatException e) 
			    		  {
			    			  //The argument is not a number!
			    			  player.sendMessage("§4Incorrect input! Only integers are allowed");
			    			  return true;
						  }
			    		  
			    		  //Reset the task
			    		  if(borderTask != null)
			    		  {
			    			  borderTask.cancel();
				    		  borderTask = new BorderTask(main, increment);   
						      borderTask.runTaskTimer(main, 0, time * 20);
			    		  }
			    		  
			    		  player.sendMessage("§6Increment changed to: §2§l" + args[1]);
			    	  }
			    	  else if (args[0].equals("initial"))
			    	  {
			    		  //borderhunt initial 50
			    		  
			    		  try 
			    		  {
			    			  //Get int value from the argument from the command
				    		  int value = Integer.parseInt(args[1]);
				    		  time = value;
						  } 
			    		  catch (NumberFormatException e) 
			    		  {
			    			  //The argument is not a number!
			    			  player.sendMessage("§4Incorrect input! Only integers are allowed");
			    			  return true;
						  }	    		  
			    		  
			    		  player.sendMessage("§6Initial border size changed to: §2§l" + args[1]);
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
