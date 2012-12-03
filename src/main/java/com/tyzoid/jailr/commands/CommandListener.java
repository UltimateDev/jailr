package com.tyzoid.jailr.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.tyzoid.jailr.JailrPlugin;

public class CommandListener implements CommandExecutor {
    JailrPlugin plugin;

    public CommandListener(JailrPlugin instance) {
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        boolean success = false;
        if (cmd.getName().equalsIgnoreCase("jailr")) {
            JailrCommand.issue(new IssuedCommand(sender, cmd, commandLabel, args));
            success = true;
        }
        return success;
    }

}
