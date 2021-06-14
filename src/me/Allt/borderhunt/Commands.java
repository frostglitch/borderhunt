package me.Allt.borderhunt;

import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor
{
	  @Override
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	  {
		    if(!(sender instanceof Player))
		    {
			      sender.sendMessage("Only players can use the command!");
			      return true;
		    }
		    
		    Player player = (Player)sender;
		    
		    if(cmd.getName().equalsIgnoreCase("testborder"))
		    {
			      if(args.length != 0)
			      {
					player.sendMessage("�4Incorrect command usage.");
					return true;
			      }
			      
			      
			      player.sendMessage("�6Border increased by 10.");
			      
			      WorldBorder border = player.getWorld().getWorldBorder();
			      border.setSize(border.getSize() + 10);
		    }
		    
		    return true;
	  }
}
