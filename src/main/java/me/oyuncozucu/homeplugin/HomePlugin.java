package me.oyuncozucu.homeplugin;

import me.oyuncozucu.homeplugin.command.HomeCommand;
import me.oyuncozucu.homeplugin.manager.MessagesManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class HomePlugin extends JavaPlugin {

    public static HomePlugin instance;

    public static HomePlugin getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {

        MessagesManager.setupMessagesFile(this);

        instance = this;

        getCommand("sethome").setExecutor(new HomeCommand());
        getCommand("home").setExecutor(new HomeCommand());
        getCommand("delhome").setExecutor(new HomeCommand());


    }



}
