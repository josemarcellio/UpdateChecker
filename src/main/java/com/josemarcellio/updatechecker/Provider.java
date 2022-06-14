package com.josemarcellio.updatechecker;

public enum Provider {

    SPIGOT("https://api.spigotmc.org/simple/0.2/index.php?action=getResource&id=%resourceId%"),
    SPIGET("https://api.spiget.org/v2/resources/%resourceId%/versions/latest");

    final String url;

    Provider(String url) {
        this.url = url;
    }
}
