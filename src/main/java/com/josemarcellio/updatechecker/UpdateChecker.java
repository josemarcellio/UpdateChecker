package com.josemarcellio.updatechecker;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class UpdateChecker {

    private final JavaPlugin plugin;

    public UpdateChecker(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void init(String plugin_Name, double plugin_Version, String url) {
        readJsonObject(plugin_Name, plugin_Version, getJsonUrl(url));
    }

    private String getJsonUrl(String url) {
        try (InputStream inputStream = new URL ( url).openStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader (inputStream, StandardCharsets.UTF_8))) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string = bufferedReader.readLine(); string != null; string = bufferedReader.readLine()) {
                stringBuilder.append(string).append("\n");
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void readJsonObject(String plugin_Name, double plugin_Version, String json) {
        JsonElement jsonElement = new JsonParser ().parse ( json );
        JsonObject jsonObject = jsonElement.getAsJsonObject ().getAsJsonObject ( "Plugin" );
        if (jsonObject.has ( plugin_Name )) {
            JsonObject jsonObjectAsJsonObject = jsonObject.getAsJsonObject ( plugin_Name );
            if (jsonObjectAsJsonObject.has ( "Message" ) && NumberUtils.toDouble ( jsonObjectAsJsonObject.getAsJsonPrimitive ( "Latest_Version" ).getAsString () ) > plugin_Version) {
                sendUpdateMessage( plugin_Name, plugin_Version, jsonObjectAsJsonObject );
            }
        }
    }

    private void sendUpdateMessage(String plugin_Name, double plugin_Version, JsonObject json) {
        JsonObject jsonObject = json.getAsJsonObject ( "Message" );
        String message = jsonObject.get("Update_Message").getAsString();
        for (String string : message.split("\n")) {
            plugin.getLogger ().info ( string.replace("{version}", String.valueOf(plugin_Version)).replace("{plugin}", plugin_Name).replace("{latest_version}", json.getAsJsonPrimitive ("Latest_Version").toString()));
        }
    }
}
