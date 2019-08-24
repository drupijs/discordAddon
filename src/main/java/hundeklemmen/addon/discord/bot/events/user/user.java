package hundeklemmen.addon.discord.bot.events.user;

import hundeklemmen.addon.main;
import net.dv8tion.jda.core.events.user.update.UserUpdateDiscriminatorEvent;
import net.dv8tion.jda.core.events.user.update.UserUpdateGameEvent;
import net.dv8tion.jda.core.events.user.update.UserUpdateNameEvent;
import net.dv8tion.jda.core.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.script.Invocable;

public class user extends ListenerAdapter {

    private String botName;

    public user(String name){
        this.botName = name;
    }

    @Override
    public void onUserUpdateDiscriminator(UserUpdateDiscriminatorEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onUserUpdateGame(UserUpdateGameEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onUserUpdateName(UserUpdateNameEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onUserUpdateOnlineStatus(UserUpdateOnlineStatusEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    public void callMessageEvent(Object event, String functionName){
        main.getDrupi().callEvent(functionName, event);
    }

}