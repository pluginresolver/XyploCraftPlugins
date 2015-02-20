package xyplocraft.net.bano.permissions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyplocraft.net.bano.Bano;

public class PermissionCommands implements CommandExecutor
{
	
	Bano main = Bano.getPlugin();
	PermissionUtils pUtils = PermissionUtils.getPermissionUtils();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(label.equalsIgnoreCase("perm"))
		{
			if(args.length == 4)
			{
				if(args[0].equalsIgnoreCase("user"))
				{
					Player p = Bukkit.getPlayer(args[1]);
					if(args[1] != null && p != null)
					{
						
						if(args[2].equalsIgnoreCase("add"))
						{
							if((args[3] != null) && !(args[3].contains(" ")))
							{
								if(pUtils.hasPermission(sender, "perm.user.add"))
								{
									pUtils.givePlayerPermission(p.getUniqueId(), args[3]);
									sender.sendMessage(ChatColor.GREEN + "The permission " + ChatColor.YELLOW + args[3] + ChatColor.GREEN + " was set for " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + ".");
								} else sender.sendMessage(ChatColor.RED + "You don't have permission to give a player a permission.");
							}
						}
						
						if(args[2].equalsIgnoreCase("remove"))
						{
							if((args[3] != null) && !(args[3].contains(" ")))
							{
								if(pUtils.hasPermission(sender, "perm.user.remove"))
								{
									pUtils.removePlayerPermission(p.getUniqueId(), args[3]);
									sender.sendMessage(ChatColor.GREEN + "The permission " + ChatColor.YELLOW + args[3] + ChatColor.GREEN + " was set for " + ChatColor.YELLOW + args[1] + ChatColor.GREEN + ".");
								} else sender.sendMessage(ChatColor.RED + "You don't have permission to remove a players permission.");
							}
						} 
						
						if(args[2].equalsIgnoreCase("check"))
						{
							if((args[3] != null) && !(args[3].contains(" ")))
							{
								if(pUtils.hasPermission(sender, "perm.user.check"))
								{
									String status;
									if(pUtils.hasPermission(p, args[3]))
									{
										status = ChatColor.GREEN + " does";
									} else status = ChatColor.RED + " doesn't";
									sender.sendMessage(ChatColor.YELLOW + args[1] + status + ChatColor.GREEN + " have the permission: " + ChatColor.YELLOW + args[3]);
								} else sender.sendMessage(ChatColor.RED + "You don't have permission to check a playes permission.");
							}
						} 
						
					} // erm... not sure yet
				}
			}
			return true;
		}
		return false;
	}
	
}
