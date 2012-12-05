package com.tyzoid.jailr.commands;

import com.tyzoid.jailr.JailrPlugin;
import com.tyzoid.jailr.commands.IssuedCommand;
import com.tyzoid.jailr.util.Messenger;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.tyzoid.jailr.api.JailAPI;

import java.lang.String;

public class JailrCommand {
    public static boolean issue(IssuedCommand cmd) {
    	if(cmd.argExists(0) && !cmd.argExists(1)) {
    		if (cmd.getArgs()[0].equalsIgnoreCase("setjail"))
                setJailPoint(cmd);
            else if (cmd.getArgs()[0].equalsIgnoreCase("setunjail"))
                setUnjailPoint(cmd);
            else if (cmd.getArgs()[0].equalsIgnoreCase("about"))
                about(cmd);
            else if (cmd.getArgs()[0].equalsIgnoreCase("list"))
                unimplemented(cmd);
            else if (cmd.getArgs()[0].equalsIgnoreCase("jail"))
            	wrongArgs(cmd);
            else if (cmd.getArgs()[0].equalsIgnoreCase("unjail"))
            	wrongArgs(cmd);
            else if (cmd.getArgs()[0].equalsIgnoreCase("jailtime"))
                wrongArgs(cmd);
            else
                help(cmd); // Also triggers on /jailr help
    	}
    	if(cmd.argExists(0) && cmd.argExists(1)) {
    		if (cmd.getArgs()[0].equalsIgnoreCase("jail"))
                unimplemented(cmd);
            else if (cmd.getArgs()[0].equalsIgnoreCase("unjail"))
                unimplemented(cmd);
            else if (cmd.getArgs()[0].equalsIgnoreCase("jailtime"))
                unimplemented(cmd);
            else
            	help(cmd); // Also triggers on /jailr help
    	}
        return true;
    }
    
    private static void jailPlayer(IssuedCommand cmd, String prisoner) {
    	
    }
    
    private static void unjailPlayer(IssuedCommand cmd, String prisoner) {
    	
    }
    
    private static void listJailed(IssuedCommand cmd) {
    	
    }
    
    // The string prisoner is the prisoner being checked for the time left.
    private static void getJailTime(IssuedCommand cmd, String prisoner) {
    	
    }

    private static void setUnjailPoint(IssuedCommand cmd) {
        if (cmd.isPlayer()) {
            Player player = (Player) cmd.getSender();

            if (player.hasPermission("jailr.setunjail")) {
                JailAPI.setUnJailPoint(player.getLocation());
                Messenger.sendMessage(player, "The unjail point has been set to your location.");
            }
        } else {
            Messenger.sendError(cmd.getSender(), "You must be a player to use that command.");
        }
    }

    private static void setJailPoint(IssuedCommand cmd) {
        if (cmd.isPlayer()) {
            Player player = (Player) cmd.getSender();

            if (player.hasPermission("jailr.setjail")) {
                JailAPI.setJailPoint(player.getLocation());
                Messenger.sendMessage(cmd.getSender(), "The jail point has been set to your location.");
            }
        } else {
            Messenger.sendError(cmd.getSender(), "You must be a player to use that command.");
        }
    }
    
    private static void wrongArgs(IssuedCommand cmd) {
    	Messenger.sendMessage(cmd.getSender(), "Incorrect arguments!");
    }
    
    private static void unimplemented(IssuedCommand cmd) {
        Messenger.sendMessage(cmd.getSender(), "This command is unimplemented.");
    }

    private static void help(IssuedCommand cmd) {
        String bull = ChatColor.GRAY + "  - ";

        Messenger.sendMessage(cmd.getSender(), "Available commands:");
        Messenger.sendMessage(cmd.getSender(), bull + "/jailr help - See this menu", false);
        Messenger.sendMessage(cmd.getSender(), bull + "/jailr about - See information about jailr", false);
        if (cmd.getSender().hasPermission("jailr.jail"))
            Messenger.sendMessage(cmd.getSender(), bull + "/jailr jail <player> [XhYm] - Jail a player", false);
        if (cmd.getSender().hasPermission("jailr.unjail"))
            Messenger.sendMessage(cmd.getSender(), bull + "/jailr unjail <player> - Unjail a player", false);
        if (cmd.getSender().hasPermission("jailr.setjail"))
            Messenger.sendMessage(cmd.getSender(), bull + "/jailr setjail - Sets the jail point.", false);
        if (cmd.getSender().hasPermission("jailr.setunjail"))
            Messenger.sendMessage(cmd.getSender(), bull + "/jailr setunjail - Sets the jail removal point.", false);
        if (cmd.getSender().hasPermission("jailr.list"))
            Messenger.sendMessage(cmd.getSender(), bull + "/jailr list - List prisoners", false);
        if (cmd.getSender().hasPermission("jailr.list"))
            Messenger.sendMessage(cmd.getSender(), bull + "/jailr jailtime <player> - Check the remaining time of a prisoner", false);
    }

    private static void about(IssuedCommand cmd) {
        Messenger.sendMessage(cmd.getSender(), "jailr v" + JailrPlugin.getPlugin().getDescription().getVersion() + " by goldblattster and Tyzoid");
        Messenger.sendMessage(cmd.getSender(), "jailr is licensed under the BSD 2 clause license. Go to town.");
    }
}
