package me.oyuncozucu.homeplugin.manager;

import me.oyuncozucu.homeplugin.HomePlugin;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class MessagesManager {

    private static YamlConfiguration messages;

    public static void setupMessagesFile(HomePlugin plugin) {

        File file = new File(plugin.getDataFolder(), "messages.yml");

        if(!file.exists()) {
            plugin.saveResource("messages.yml", false);
        }

        messages = YamlConfiguration.loadConfiguration(file);

    }

    public static String getNotFound() {
        return  messages.getString("not-found");
    }

    public static String getSaveMessage() {
        return messages.getString("save-message");
    }

    public static String getDeleteMessage() {
        return messages.getString("delete-message");
    }

    public static String getTeleportMessage() {
        return messages.getString("teleport-message");
    }

}
