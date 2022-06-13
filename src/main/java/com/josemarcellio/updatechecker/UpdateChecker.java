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
    private String message;

    @Override
    public Update setJavaPlugin(JavaPlugin plugin) {
        this.plugin = plugin;
        return this;
    }

    @Override
    public String getPluginVersion() {
        return plugin.getDescription ().getVersion ();
    }

    @Override
    public Update setResourceId(int id) {
        this.id = id;
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
        try (InputStream inputStream = new URL ( "https://api.spiget.org/v2/resources/" + this.id + "/versions/latest" ).openStream();
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
        JsonElement jsonObject = jsonElement.getAsJsonObject ().get ( "name" );
        if (NumberUtils.toDouble ( jsonObject.getAsString () ) > NumberUtils.toDouble ( getPluginVersion () )) {
            String message = this.message;
            for (String string : message.split ( "\n" )) {
                plugin.getLogger ().info ( string.replace ( "{current_version}", getPluginVersion () ).replace ( "{latest_version}", String.valueOf ( jsonObject.getAsDouble () ) ) );
            }
        }
    }
}
