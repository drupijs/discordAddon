package hundeklemmen.addon.discord.bot.events.channel;

import hundeklemmen.addon.main;
import net.dv8tion.jda.core.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.core.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.core.events.channel.voice.update.*;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.script.Invocable;

public class voice extends ListenerAdapter {

    private String botName;

    public voice(String name){
        this.botName = name;
    }

    @Override
    public void onVoiceChannelCreate(VoiceChannelCreateEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onVoiceChannelDelete(VoiceChannelDeleteEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onVoiceChannelUpdateBitrate(VoiceChannelUpdateBitrateEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onVoiceChannelUpdateName(VoiceChannelUpdateNameEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onVoiceChannelUpdateParent(VoiceChannelUpdateParentEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onVoiceChannelUpdatePermissions(VoiceChannelUpdatePermissionsEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onVoiceChannelUpdatePosition(VoiceChannelUpdatePositionEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onVoiceChannelUpdateUserLimit(VoiceChannelUpdateUserLimitEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }



    public void callMessageEvent(Object event, String functionName){
        main.getDrupi().callEvent(functionName, event);
    }
}
