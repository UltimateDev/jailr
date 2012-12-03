package com.tyzoid.jailr.commands;

import org.bukkit.entity.Player;

import com.tyzoid.jailr.api.JailAPI;

public class JailrCommand {
    public static boolean issue(IssuedCommand cmd) {
        if(cmd.argExists(0) && cmd.getArgs()[0].equalsIgnoreCase("setunjailpoint"))
            setUnjailPoint(cmd);
        else if(cmd.argExists(0) && cmd.getArgs()[0].equalsIgnoreCase("setjailpoint"))
            setJailPoint(cmd);
        else
            return false;
        return true;
    }
    
    private static void setUnjailPoint(IssuedCommand cmd){
        if(cmd.isPlayer()){
            JailAPI.setUnJailPoint(((Player) cmd.getSender()).getLocation());
        } else {
            cmd.getSender().sendMessage("You must be a Player to use that command.");
        }
    }
    
    private static void setJailPoint(IssuedCommand cmd){
        if(cmd.isPlayer()){
            JailAPI.setJailPoint(((Player) cmd.getSender()).getLocation());
        } else {
            cmd.getSender().sendMessage("You must be a Player to use that command.");
        }
    }
}
