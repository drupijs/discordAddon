package hundeklemmen.addon.discord.bot.events.channel;

import hundeklemmen.addon.main;
import net.dv8tion.jda.core.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.core.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.core.events.channel.text.update.*;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.script.Invocable;

public class text extends ListenerAdapter {

    private String botName;

    public text(String name){
        this.botName = name;
    }

    @Override
    public void onTextChannelCreate(TextChannelCreateEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onTextChannelDelete(TextChannelDeleteEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onTextChannelUpdateNSFW(TextChannelUpdateNSFWEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onTextChannelUpdateName(TextChannelUpdateNameEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onTextChannelUpdateParent(TextChannelUpdateParentEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onTextChannelUpdatePermissions(TextChannelUpdatePermissionsEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onTextChannelUpdatePosition(TextChannelUpdatePositionEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onTextChannelUpdateSlowmode(TextChannelUpdateSlowmodeEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onTextChannelUpdateTopic(TextChannelUpdateTopicEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }


    public void callMessageEvent(Object event, String functionName){
        main.getDrupi().callEvent(functionName, event);
    }

}
