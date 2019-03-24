package hundeklemmen.addon.discord.bot.events.guild;

import hundeklemmen.main;
import net.dv8tion.jda.core.events.guild.voice.*;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.script.Invocable;

public class voice extends ListenerAdapter {

    private String botName;

    public voice(String name){
        this.botName = name;
    }

    @Override
    public void onGuildVoiceGuildDeafen(GuildVoiceGuildDeafenEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildVoiceGuildMute(GuildVoiceGuildMuteEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildVoiceMove(GuildVoiceMoveEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildVoiceMute(GuildVoiceMuteEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildVoiceSelfDeafen(GuildVoiceSelfDeafenEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildVoiceSelfMute(GuildVoiceSelfMuteEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    public void callMessageEvent(Object event, String functionName){
        functionName = "discord_"+botName+"_" + functionName;
        if (main.engine.get(functionName) == null) {
            return;
        }
        try {
            ((Invocable) main.engine).invokeFunction(functionName, event);
        } catch (final Exception se) {
            main.instance.getLogger().warning("Error while calling " + functionName);
            se.printStackTrace();
        }
    }

    }
