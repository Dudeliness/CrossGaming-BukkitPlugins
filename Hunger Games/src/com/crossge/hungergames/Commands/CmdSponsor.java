package com.crossge.hungergames.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdSponsor extends Cmd
{
	public boolean commandUse(CommandSender sender, String[] args)
	{
		if (sender instanceof Player)
		{
			Player p = (Player) sender;
			if(p.hasPermission("HungerGames.sponsor"))
			{
				if(args.length != 0)
					return false;
				if(pl.gameGoing())
				{
					if(pl.alreadySponsored(p.getName()))
					{
						p.sendMessage(var.errorCol() + lang.translate("Error: You already sponsored yourself this round."));
						return true;
					}
					sp.giveItems(p);
					pl.addSponsored(p.getName());
					p.sendMessage(var.defaultCol() + ChatColor.GREEN + lang.translate("You sponsored yourself."));
				}
				else
					p.sendMessage(var.errorCol() + lang.translate("Error: Game not going."));
			}
			else
				p.sendMessage(var.errorCol() + lang.translate("Error: You may not view the help for Hunger Games."));
		}
		else
			sender.sendMessage(var.errorCol() + lang.translate("Error: You may not sponsor yourself."));
		return true;
	}
}