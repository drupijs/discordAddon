package hundeklemmen.addon.discord.bot.events.guild;

import hundeklemmen.addon.main;
import net.dv8tion.jda.core.events.guild.GuildBanEvent;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.script.Invocable;

public class guild extends ListenerAdapter {

    private String botName;

    public guild(String name){
        this.botName = name;
    }

    @Override
    public void onGuildBan(GuildBanEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }

    @Override
    public void onGuildLeave(GuildLeaveEvent event){
        callMessageEvent(event, event.getClass().getSimpleName());
    }



    public void callMessageEvent(Object event, String functionName){
        main.getDrupi().callEvent(functionName, event);
    }

}
