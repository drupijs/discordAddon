package hundeklemmen.addon;

import hundeklemmen.addon.discord.discordbot;
import hundeklemmen.api.DrupiAPI;
import hundeklemmen.api.DrupiLoadEvent;
import net.dv8tion.jda.core.JDA;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class main extends JavaPlugin implements Listener {

    private static main instance;
    private static DrupiAPI Drupi;

    public static boolean update = false;
    public static HashMap<String, JDA> discordBots = new HashMap<String, JDA>();

    @Override
    public void onEnable() {
        instance = this;


        instance.getLogger().info("Drupi Discord Addon has been enabled");

        instance.getServer().getPluginManager().registerEvents(this, this);
        instance.getServer().getPluginManager().registerEvents(new eventHandler(), this);

        //register our addon
        instance.getLogger().info("Registering Discord addon");
        Drupi = new DrupiAPI("discord");
        instance.getLogger().info("Drupi Discord Addon has been registered");

    }

    @Override
    public void onDisable(){
        instance.getLogger().info("Drupi Discord Addon has been disabled");
    }

    @EventHandler
    public void DrupiLoad(DrupiLoadEvent event){
        //registering a class
        Drupi.register(new discordbot(instance));
    }


    public static main getInstance(){
        return instance;
    }

    public static DrupiAPI getDrupi(){
        return Drupi;
    }



}