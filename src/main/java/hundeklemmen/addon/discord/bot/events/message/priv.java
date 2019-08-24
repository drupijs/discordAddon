package hundeklemmen.addon.discord.bot.events.message;

import hundeklemmen.addon.main;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageDeleteEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageEmbedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageUpdateEvent;
import net.dv8tion.jda.core.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.priv.react.PrivateMessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.script.Invocable;

public class priv extends ListenerAdapter {

    private String botName;

    public priv(String name){
        this.botName = name;
    }

    @Override
    public void onPrivateMessageDelete(PrivateMessageDeleteEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onPrivateMessageEmbed(PrivateMessageEmbedEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onPrivateMessageUpdate(PrivateMessageUpdateEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onPrivateMessageReactionAdd(PrivateMessageReactionAddEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onPrivateMessageReactionRemove(PrivateMessageReactionRemoveEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    public void callMessageEvent(Object event, String functionName){
        main.getDrupi().callEvent(functionName, event);
    }

}
