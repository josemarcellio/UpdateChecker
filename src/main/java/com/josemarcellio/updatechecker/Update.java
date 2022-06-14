package com.josemarcellio.updatechecker;

import org.bukkit.plugin.java.JavaPlugin;

public interface Update {

    Update setJavaPlugin(JavaPlugin plugin);

    Update setResourceId(int id);

    Update setMessage(String message);

    Update setProvider(Provider provider);

    void init();
}
