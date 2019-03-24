package hundeklemmen.addon.discord.bot.events.message;

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
        functionName = "discord_"+botName+"_" + functionName;
        if (hundeklemmen.main.engine.get(functionName) == null) {
            return;
        }
        try {
            ((Invocable) hundeklemmen.main.engine).invokeFunction(functionName, event);
        } catch (final Exception se) {
            hundeklemmen.main.instance.getLogger().warning("Error while calling " + functionName);
            se.printStackTrace();
        }
    }

}
