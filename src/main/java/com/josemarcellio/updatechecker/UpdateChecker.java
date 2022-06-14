package com.josemarcellio.updatechecker;

import com.google.gson.*;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class UpdateChecker implements Update {

    private JavaPlugin plugin;
    private int id;
    private Provider provider;
    private String message;
    private String object;

    @Override
    public Update setJavaPlugin(JavaPlugin plugin) {
        this.plugin = plugin;
        return this;
    }

    @Override
    public Update setResourceId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public Update setProvider(Provider provider) {
        this.provider = provider;
        return this;
    }

    @Override
    public Update setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public void init() {
        readJsonObject();
    }

    public String getJsonUrl() {
        String url = this.provider.url.replace("%resourceId%", String.valueOf(this.id));
        try (InputStream inputStream = new URL ( url ).openStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader (inputStream, StandardCharsets.UTF_8))) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string = bufferedReader.readLine(); string != null; string = bufferedReader.readLine()) {
                stringBuilder.append(string);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void readJsonObject() {
        JsonElement jsonElement = new JsonParser ().parse ( getJsonUrl () );
        Provider provider = this.provider;
        switch (provider) {
            case SPIGOT:
                this.object = "current_version";
                break;
            case SPIGET:
                this.object = "name";
                break;
        }
        JsonElement jsonObject = jsonElement.getAsJsonObject ().get ( this.object );
        if (NumberUtils.toDouble ( jsonObject.getAsString () ) > NumberUtils.toDouble ( plugin.getDescription ().getVersion() )) {
            String message = this.message.replace ( "{current_version}", plugin.getDescription ().getVersion() ).replace ( "{latest_version}", String.valueOf ( jsonObject.getAsDouble () )).replace("{plugin_name}", plugin.getDescription().getName());
            for (String string : message.split ( "\n" )) {
                plugin.getLogger ().info ( string );
            }
        }
    }
}
