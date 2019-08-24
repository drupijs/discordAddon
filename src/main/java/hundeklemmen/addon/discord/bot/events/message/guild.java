package hundeklemmen.addon.discord.bot.events.message;

import hundeklemmen.addon.main;
import net.dv8tion.jda.core.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageEmbedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageUpdateEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionRemoveAllEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.script.Invocable;

public class guild extends ListenerAdapter {

    private String botName;

    public guild(String name){
        this.botName = name;
    }

    @Override
    public void onGuildMessageDelete(GuildMessageDeleteEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildMessageEmbed(GuildMessageEmbedEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildMessageUpdate(GuildMessageUpdateEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildMessageReactionRemoveAll(GuildMessageReactionRemoveAllEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildMessageReactionRemove(GuildMessageReactionRemoveEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }


    public void callMessageEvent(Object event, String functionName){
        main.getDrupi().callEvent(functionName, event);
    }

}
