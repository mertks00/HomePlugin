package me.oyuncozucu.homeplugin.command;

import me.oyuncozucu.homeplugin.HomePlugin;
import me.oyuncozucu.homeplugin.manager.MessagesManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("sethome")) {
            if(sender instanceof Player) {

                Player p = (Player) sender;

                    HomePlugin.getInstance().getConfig().set("home."+p.getUniqueId().toString()+".world", p.getLocation().getWorld().getName());
                    HomePlugin.getInstance().getConfig().set("home."+p.getUniqueId().toString()+".x", p.getLocation().getX());
                    HomePlugin.getInstance().getConfig().set("home."+p.getUniqueId().toString()+".y", p.getLocation().getY());
                    HomePlugin.getInstance().getConfig().set("home."+p.getUniqueId().toString()+".z", p.getLocation().getZ());
                    HomePlugin.getInstance().getConfig().set("home."+p.getUniqueId().toString()+".pitch", p.getEyeLocation().getPitch());
                    HomePlugin.getInstance().getConfig().set("home."+p.getUniqueId().toString()+".yaw", p.getEyeLocation().getYaw());
                    HomePlugin.getInstance().saveConfig();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesManager.getSaveMessage()));
                    return false;


            }
        }

        if(label.equalsIgnoreCase("home")) {
            if(sender instanceof Player) {

                Player p = (Player) sender;

                if(HomePlugin.getInstance().getConfig().contains("home."+p.getUniqueId().toString())) {

                    World w = Bukkit.getServer().getWorld(HomePlugin.getInstance().getConfig().getString("home."+p.getUniqueId().toString()+".world"));
                    double x = HomePlugin.getInstance().getConfig().getDouble("home."+p.getUniqueId().toString()+".x");
                    double y = HomePlugin.getInstance().getConfig().getDouble("home."+p.getUniqueId().toString()+".y");
                    double z = HomePlugin.getInstance().getConfig().getDouble("home."+p.getUniqueId().toString()+".z");
                    double pitch = HomePlugin.getInstance().getConfig().getDouble("home."+p.getUniqueId().toString()+".pitch");
                    double yaw = HomePlugin.getInstance().getConfig().getDouble("home."+p.getUniqueId().toString()+".yaw");
                    p.teleport(new Location(w,x,y,z, (float) yaw, (float) pitch));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesManager.getTeleportMessage()));

                    return false;
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesManager.getNotFound()));
                }

            }
        }

        if(label.equalsIgnoreCase("delhome")) {
            if(sender instanceof Player) {

                Player p = (Player) sender;

                if(HomePlugin.getInstance().getConfig().contains("home."+p.getUniqueId().toString())) {
                    HomePlugin.getInstance().getConfig().set("home."+p.getUniqueId().toString(), null);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesManager.getDeleteMessage()));;
                    return false;
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesManager.getNotFound()));
                }


            }
        }

        return false;
    }
}
