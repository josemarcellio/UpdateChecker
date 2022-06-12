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

public class UpdateChecker implements Update {

    private JavaPlugin plugin;
    private String plugin_Name;
    private Double plugin_Version;
    private String url;

    @Override
    public Update setJavaPlugin(JavaPlugin plugin) {
        this.plugin = plugin;
        return this;
    }

    @Override
    public Update setPluginName(String name) {
        this.plugin_Name = name;
        return this;
    }

    @Override
    public Update setPluginVersion(double version) {
        this.plugin_Version = version;
        return this;
    }

    @Override
    public Update setJsonURL(String url) {
        this.url = url;
        return this;
    }

    @Override
    public void init() {
        readJsonObject();
    }

    public String getJsonUrl() {
        try (InputStream inputStream = new URL ( this.url ).openStream();
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

    private void readJsonObject() {
        JsonElement jsonElement = new JsonParser ().parse ( getJsonUrl () );
        JsonObject jsonObject = jsonElement.getAsJsonObject ().getAsJsonObject ( "Plugin" );
        if (jsonObject.has ( this.plugin_Name )) {
            JsonObject jsonObjectAsJsonObject = jsonObject.getAsJsonObject ( this.plugin_Name );
            if (jsonObjectAsJsonObject.has ( "Message" ) && NumberUtils.toDouble ( jsonObjectAsJsonObject.getAsJsonPrimitive ( "Latest_Version" ).getAsString () ) > plugin_Version) {
                sendUpdateMessage(jsonObjectAsJsonObject );
            }
        }
    }

    private void sendUpdateMessage(JsonObject json) {
        JsonObject jsonObject = json.getAsJsonObject ( "Message" );
        String message = jsonObject.get("Update_Message").getAsString();
        for (String string : message.split("\n")) {
            plugin.getLogger ().info ( string.replace("{version}", String.valueOf(this.plugin_Version)).replace("{plugin}", this.plugin_Name).replace("{latest_version}", json.getAsJsonPrimitive ("Latest_Version").toString()));
        }
    }
}
