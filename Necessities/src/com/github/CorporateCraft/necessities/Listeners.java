package com.github.CorporateCraft.necessities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners implements Listener
{
	ArrayLists arl = new ArrayLists();
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
    	Player player = event.getPlayer();
    	if(player.hasPermission("Necessities.motd"))
    	{
    		try
    		{
    			FileReader reader = new FileReader(arl.GetMotd());
    			BufferedReader buff = new BufferedReader(reader);
    			while(true)
    			{
    				String inputText = buff.readLine();
    				if(inputText == null)
		        	{
    					break;
		        	}
    				player.sendMessage(arl.GetCol() + inputText);
    			}
    		}
    		catch (IOException ex){}
    	}
	}
}