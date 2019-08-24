package hundeklemmen.addon.discord;

import hundeklemmen.addon.discord.bot.bot;

public class discordbot {

    private hundeklemmen.addon.main plugin;

    public discordbot(hundeklemmen.addon.main plugin){
        this.plugin = plugin;
    }

    public Object bot(){
        return new bot(plugin);
    }
}
