package com.tyzoid.jailr.models;

import com.tyzoid.jailr.JailrPlugin;
import com.tyzoid.jailr.util.ExceptionPrinter;
import com.tyzoid.jailr.util.Log;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseCommon {
    public static DatabaseEngine getEngine() {
        if (JailrPlugin.getPlugin().getConfig().getString("database.driver").equalsIgnoreCase("h2")) {
            return DatabaseEngine.H2;
        } else if (JailrPlugin.getPlugin().getConfig().getString("database.driver").equalsIgnoreCase("mysql")) {
            return DatabaseEngine.MYSQL;
        } else {
            Log.severe("Invalid database driver type! Must be `h2` or `mysql`! Assuming h2...");
            return DatabaseEngine.H2;
        }
    }

    public static Connection getConnection() throws SQLException {
        switch (getEngine()) {
            case H2:
                try {
                    Class.forName("org.h2.Driver");

                    return DriverManager.getConnection("jdbc:h2:" +
                            JailrPlugin.getPlugin().getDataFolder().getAbsolutePath() +
                            "/jailr_data", "jailr", "");
                } catch (ClassNotFoundException ex) {
                    ExceptionPrinter.printFriendlyStackTrace(ex);
                    Bukkit.getPluginManager().disablePlugin(JailrPlugin.getPlugin());
                }
                break;
            case MYSQL:
                try {
                    Class.forName("com.mysql.jdbc.Driver");

                    return DriverManager.getConnection("jdbc:mysql://" +
                            JailrPlugin.getPlugin().getConfig().getString("database.host") +
                            ":" + JailrPlugin.getPlugin().getConfig().getInt("database.port") +
                            "/" + JailrPlugin.getPlugin().getConfig().getString("database.database"),
                            JailrPlugin.getPlugin().getConfig().getString("database.username"),
                            JailrPlugin.getPlugin().getConfig().getString("database.password"));
                } catch (ClassNotFoundException ex) {
                    ExceptionPrinter.printFriendlyStackTrace(ex);
                    Bukkit.getPluginManager().disablePlugin(JailrPlugin.getPlugin());
                }
        }

        return null;
    }

    public static Map<String, Object> getDatabaseConfig() {
        Map<String, Object> config = new HashMap<String, Object>();

        switch(getEngine()) {
            case H2:
                config.put("driver", JailrPlugin.getPlugin().getConfig().getString("database.driver"));
                config.put("prefix", "");
                break;
            case MYSQL:
                config.put("host", JailrPlugin.getPlugin().getConfig().getString("database.host"));
                config.put("port", JailrPlugin.getPlugin().getConfig().getInt("database.port"));
                config.put("database", JailrPlugin.getPlugin().getConfig().getString("database.database"));
                config.put("prefix", JailrPlugin.getPlugin().getConfig().getString("database.prefix"));
                config.put("username", JailrPlugin.getPlugin().getConfig().getString("database.username"));
                config.put("password", JailrPlugin.getPlugin().getConfig().getString("database.password"));
                break;
        }

        return config;
    }
}
