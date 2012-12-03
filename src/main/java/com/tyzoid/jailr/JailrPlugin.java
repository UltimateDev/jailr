package com.tyzoid.jailr;

import com.tyzoid.jailr.commands.CommandListener;
import com.tyzoid.jailr.events.InteractionListener;
import com.tyzoid.jailr.models.DatabaseRunner;
import com.tyzoid.jailr.util.Log;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class JailrPlugin extends JavaPlugin {
    DatabaseRunner runner;
    private static JailrPlugin plugin;

    @Override
    public void onEnable() {
        JailrPlugin.plugin = this;

        this.runner = new DatabaseRunner();
        this.runner.initDb();
        loadEvents();
        loadCommands();
        loadConfig();

        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            Log.warning("I was unable to submit information about jailr to MCStats.");
        }

        Log.info(String.format("Successfully enabled version %s!", this.getDescription().getVersion()));
    }

    @Override
    public void onDisable() {
        Log.info(String.format("Successfully disabled version %s!", this.getDescription().getVersion()));
    }

    public void loadEvents() {
        Bukkit.getPluginManager().registerEvents(new InteractionListener(), this);
    }

    public void loadCommands() {
        getCommand("jailr").setExecutor(new CommandListener(this));
    }

    public void loadConfig() {
        if (!new File(getDataFolder(), "config.yml").exists()) {
            this.saveDefaultConfig();
        }
    }

    public void setConfigValue(String node, String value) {
        this.getConfig().set(node, value);
        this.saveConfig();
    }

    public void setConfigValue(String node, int value) {
        this.getConfig().set(node, value);
        this.saveConfig();
    }

    public void setConfigValue(String node, boolean value) {
        this.getConfig().set(node, value);
        this.saveConfig();
    }

    public static JailrPlugin getPlugin() {
        return JailrPlugin.plugin;
    }
}
