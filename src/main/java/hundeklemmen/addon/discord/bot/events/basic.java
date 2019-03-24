package hundeklemmen.addon.discord.bot.events;

import hundeklemmen.addon.main;
import net.dv8tion.jda.core.events.DisconnectEvent;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.ShutdownEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.script.Invocable;

public class basic extends ListenerAdapter {

    private String botName;

    public basic(String name){
        this.botName = name;
    }

    @Override
    public void onReady(ReadyEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }


    @Override
    public void onDisconnect(DisconnectEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onShutdown(ShutdownEvent event){
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
