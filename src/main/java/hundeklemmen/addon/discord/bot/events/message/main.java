package hundeklemmen.addon.discord.bot.events.message;

import net.dv8tion.jda.core.events.message.*;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.script.Invocable;

public class main extends ListenerAdapter {

    private String botName;

    public main(String name){
        this.botName = name;
    }

    @Override
    public void onMessageBulkDelete(MessageBulkDeleteEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onMessageDelete(MessageDeleteEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onMessageEmbed(MessageEmbedEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());

    }

    @Override
    public void onMessageUpdate(MessageUpdateEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }




    public void callMessageEvent(Object event, String functionName){
        hundeklemmen.addon.main.getDrupi().callEvent(functionName, event);
    }
}
