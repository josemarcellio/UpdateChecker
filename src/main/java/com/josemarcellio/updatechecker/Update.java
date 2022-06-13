package com.josemarcellio.updatechecker;

import org.bukkit.plugin.java.JavaPlugin;

public interface Update {

    Update setJavaPlugin(JavaPlugin plugin);

    String getPluginVersion();

    Update setResourceId(int id);

    Update setMessage(String message);

    void init();
}
