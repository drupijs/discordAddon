package hundeklemmen.addon;

import hundeklemmen.addon.discord.discordbot;
import hundeklemmen.legacy.addon.DrupiAddon;
import net.dv8tion.jda.core.JDA;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class main extends JavaPlugin implements Listener {

    private static main instance;
    private static DrupiAddon Drupi;

    public static boolean update = false;
    public static HashMap<String, JDA> discordBots = new HashMap<String, JDA>();

    @Override
    public void onEnable() {
        instance = this;


        instance.getLogger().info("Drupi Discord Addon has been enabled");

        //register our addon
        instance.getLogger().info("Registering Discord addon");
        Drupi = new DrupiAddon("discord", new discordbot(instance));
        instance.getLogger().info("Drupi Discord Addon has been registered");

    }

    @Override
    public void onDisable(){
        instance.getLogger().info("Drupi Discord Addon has been disabled");
    }


    public static main getInstance(){
        return instance;
    }

    public static DrupiAddon getDrupi(){
        return Drupi;
    }



}