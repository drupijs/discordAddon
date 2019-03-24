package hundeklemmen.addon.discord.bot.events.message;

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
        functionName = "discord_"+botName+"_" + functionName;
        if (hundeklemmen.main.engine.get(functionName) == null) {
            return;
        }
        try {
            hundeklemmen.main.instance.getLogger().info(functionName + "    has been fired! COMPLETE");
            ((Invocable) hundeklemmen.main.engine).invokeFunction(functionName, event);
        } catch (final Exception se) {
            hundeklemmen.main.instance.getLogger().warning("Error while calling " + functionName);
            se.printStackTrace();
        }
    }

}
