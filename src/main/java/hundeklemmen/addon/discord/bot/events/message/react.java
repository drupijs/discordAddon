package hundeklemmen.addon.discord.bot.events.message;

import hundeklemmen.addon.main;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionRemoveAllEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.hooks.SubscribeEvent;

import javax.script.Invocable;

public class react extends ListenerAdapter {

    private String botName;

    public react(String name){
        this.botName = name;
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onMessageReactionRemoveAll(MessageReactionRemoveAllEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @SubscribeEvent
    public void onMessageReactionRemove(MessageReactionRemoveEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    public void callMessageEvent(Object event, String functionName){
        main.getDrupi().callEvent(functionName, event);
    }

}
