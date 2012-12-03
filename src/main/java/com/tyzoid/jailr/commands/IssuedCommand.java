package com.tyzoid.jailr.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IssuedCommand {
    private CommandSender sender;
    private Command cmd;
    private String commandLabel;
    private String[] args;

    public IssuedCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        this.sender = sender;
        this.cmd = cmd;
        this.commandLabel = commandLabel;
        this.args = args;
    }

    public CommandSender getSender() {
        return this.sender;
    }

    public Command getCommand() {
        return this.cmd;
    }

    public String getCommandLabel() {
        return this.commandLabel;
    }

    public String[] getArgs() {
        return this.args;
    }

    public boolean argExists(int arg) {
        return this.args.length > arg;
    }

    public boolean isPlayer() {
        return (this.sender instanceof Player);
    }
}
