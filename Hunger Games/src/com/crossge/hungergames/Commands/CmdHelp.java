package com.crossge.hungergames.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.crossge.hungergames.Variables;

public class CmdHelp extends Cmd
{
	Variables var = new Variables();
	public CmdHelp()
	{
		
	}
	public boolean commandUse(CommandSender sender, String[] args)
	{
		int maxPages = 2;
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			if(p.hasPermission("HungerGames.help"))
			{
				int page = 1;
				if(args.length > 0)
				{
					try
					{
						page = Integer.parseInt(args[1]);
					}
					catch(Exception e){}
				}
				if(page == 0)
					page = 1;
				if(page > maxPages)
				{
					p.sendMessage(var.errorCol() + "Error: Please enter a page inbetween 1 and " + Integer.toString(maxPages));
					return false;
				}
				p.sendMessage(var.defaultCol() + "Hunger Games Help Page " + Integer.toString(page) + " of " + Integer.toString(maxPages));
				if(page == 1)
					page1(sender);
				else if(page == 2)
					page2(sender);
			}
			else
			{
				p.sendMessage(var.errorCol() + "Error you may not view the help for Hunger Games.");
			}
		}
		else
		{
			
		}
		return true;
	}
	private void page1(CommandSender sender)
	{
		sender.sendMessage(var.defaultCol() + "/hg help [page] ~ Shows the help page [page] for hunger games.");
		sender.sendMessage(var.defaultCol() + "/hg join ~ Gets in line for next game.");
		sender.sendMessage(var.defaultCol() + "/hg spectate ~ Spectates the current game.");
		sender.sendMessage(var.defaultCol() + "/hg leave ~ Leaves the current game or if in line, the line.");
		sender.sendMessage(var.defaultCol() + "/hg stats [player] ~ Shows the stats of [player].");
	}
	private void page2(CommandSender sender)
	{
		sender.sendMessage(var.defaultCol() + "/hg setspawn [number] ~ Sets the [number] spawnpoint(max 24).");
		sender.sendMessage(var.defaultCol() + "/hg info ~ Views info about the current round.");
		sender.sendMessage(var.defaultCol() + "");
		sender.sendMessage(var.defaultCol() + "");
		sender.sendMessage(var.defaultCol() + "");
	}
}
