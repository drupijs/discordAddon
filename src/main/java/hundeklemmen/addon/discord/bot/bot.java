package hundeklemmen.addon.discord.bot;

import hundeklemmen.addon.discord.bot.events.basic;
import hundeklemmen.addon.discord.bot.events.channel.text;
import hundeklemmen.addon.discord.bot.events.channel.voice;
import hundeklemmen.addon.discord.bot.events.guild.guild;
import hundeklemmen.addon.discord.bot.events.message.priv;
import hundeklemmen.addon.discord.bot.events.message.react;
import hundeklemmen.addon.discord.bot.events.user.user;
import hundeklemmen.addon.discord.bot.music.PlayerManager;
import hundeklemmen.addon.main;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class bot {

    private main plugin;

    public bot(main plugin){
        this.plugin = plugin;
    }

    public JDA create(String name, String token){
        if(main.discordBots.containsKey(name)){
            return main.discordBots.get(name);
        } else {
            try {
                JDA client = new JDABuilder(AccountType.BOT).setToken(token)
                        .addEventListener(new text(name))
                        .addEventListener(new voice(name))
                        .addEventListener(new guild(name))
                        .addEventListener(new hundeklemmen.addon.discord.bot.events.guild.voice(name))
                        .addEventListener(new hundeklemmen.addon.discord.bot.events.message.guild(name))
                        .addEventListener(new hundeklemmen.addon.discord.bot.events.message.main(name))
                        .addEventListener(new priv(name))
                        .addEventListener(new react(name))
                        .addEventListener(new user(name))
                        .addEventListener(new basic(name))
                        .build().awaitReady();
                main.discordBots.put(name, client);
                return client;
            } catch (LoginException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public PlayerManager getPlayerManager(){
        return PlayerManager.getInstance();
    }

    public Game listening(String text){
        return Game.listening(text);
    }
    public Game playing(String text){
        return Game.playing(text);
    }
    public Game streaming(String text, String url){
        return Game.streaming(text, url);
    }
    public Game watching(String text){
        return Game.watching(text);
    }
}
