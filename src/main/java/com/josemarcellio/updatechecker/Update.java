package com.josemarcellio.updatechecker;

import org.bukkit.plugin.java.JavaPlugin;

public interface Update {

    Update setJavaPlugin(JavaPlugin plugin);

    Update setPluginName(String name);

    Update setPluginVersion(double version);

    Update setJsonURL(String url);

    void init();
}
