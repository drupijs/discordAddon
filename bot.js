var bot = discord.bot().create("testBot", "Your token here");
bot.getPresence().setGame(discord.bot().playing("Made with Drupi"));

function discord_testBot_ReadyEvent(event){
    logger.info("Bot is ready!");
}

function discord_testBot_MessageReceivedEvent(event){
    var authorName = event.getAuthor().getName();
    var message = event.getMessage().getContentRaw();

    var command = message.split(" ")[0];
    if(command == "!ping"){
        var args = message.split(" ");
        if(args[1]){
            event.getMessage().getChannel().sendMessage("Pong! "+args[1]).queue();
        } else {
            event.getMessage().getChannel().sendMessage("Pong!").queue();
        }
    } else if(command == "!join"){
        var audioManager = event.getGuild().getAudioManager();
        if(audioManager.isConnected()){
            event.getMessage().getChannel().sendMessage("I'm already connected to a channel").queue();
            return;
        }

        var memberVoiceState = event.getMember().getVoiceState();
        if(!memberVoiceState.inVoiceChannel()){
            event.getMessage().getChannel().sendMessage("Please join a voice channel first").queue();
            return;
        }
        
        var voiceChannel = memberVoiceState.getChannel();

        audioManager.openAudioConnection(voiceChannel);
        event.getMessage().getChannel().sendMessage("Joining your voice channel").queue();

    } else if(command == "!leave"){
        var audioManager = event.getGuild().getAudioManager();
        if(!audioManager.isConnected()){
            event.getMessage().getChannel().sendMessage("I'm not connected to a voice channel").queue();
            return;
        }
    
        var voiceChannel = audioManager.getConnectedChannel();
        if(!voiceChannel.getMembers().contains(event.getMember())){
            event.getMessage().getChannel().sendMessage("You have to be in the same voice channel as me to use this").queue();
            return;
        }

        audioManager.closeAudioConnection();
        event.getMessage().getChannel().sendMessage("Disconnected from your voice channel").queue();

    } else if(command == "!play"){
        const args = message.split(" ");
        if(args.length != 1){
            var url = args[1];
            var audioManager = event.getGuild().getAudioManager();
            if(!audioManager.isConnected()){
                event.getMessage().getChannel().sendMessage("I'm not connected to a voice channel! Use !join first").queue();
                return;
            }
        
            var voiceChannel = audioManager.getConnectedChannel();
            if(!voiceChannel.getMembers().contains(event.getMember())){
                event.getMessage().getChannel().sendMessage("You have to be in the same voice channel as me to use this").queue();
                return;
            }
            var playerManager = discord.bot().getPlayerManager();
            
            var channel = event.getChannel(); //The channel it should output to, like "Playing xx", null = none;
            playerManager.loadAndPlay(channel, url)
        } else {
            event.getMessage().getChannel().sendMessage("Please provide an link. Usage: !play <song or playlist link>").queue();
        }
    } else if(command == "!stop"){
        var audioManager = event.getGuild().getAudioManager();
        if(!audioManager.isConnected()){
            event.getMessage().getChannel().sendMessage("I'm not playing any music!").queue();
            return;
        }
    
        var voiceChannel = audioManager.getConnectedChannel();
        if(!voiceChannel.getMembers().contains(event.getMember())){
            event.getMessage().getChannel().sendMessage("You have to be in the same voice channel as me to use this").queue();
            return;
        }
        var playerManager = discord.bot().getPlayerManager();
        var musicManager = playerManager.getGuildMusicManager(event.getGuild());
        
        musicManager.scheduler.getQueue().clear();
        musicManager.player.stopTrack();
        musicManager.player.setPaused(false);

        event.getChannel().sendMessage("Stopping the player and clearing the queue").queue();

    } else if(command == "!pause"){
        var audioManager = event.getGuild().getAudioManager();
        if(!audioManager.isConnected()){
            event.getMessage().getChannel().sendMessage("I'm not playing any music!").queue();
            return;
        }
    
        var voiceChannel = audioManager.getConnectedChannel();
        if(!voiceChannel.getMembers().contains(event.getMember())){
            event.getMessage().getChannel().sendMessage("You have to be in the same voice channel as me to use this").queue();
            return;
        }

        var playerManager = discord.bot().getPlayerManager();
        var musicManager = playerManager.getGuildMusicManager(event.getGuild());
        
        musicManager.player.setPaused(true);

        event.getChannel().sendMessage("Paused the music, use !resume to resume the music").queue();

    } else if(command == "!resume"){
        var audioManager = event.getGuild().getAudioManager();
        if(!audioManager.isConnected()){
            event.getMessage().getChannel().sendMessage("I'm not playing any music!").queue();
            return;
        }
    
        var voiceChannel = audioManager.getConnectedChannel();
        if(!voiceChannel.getMembers().contains(event.getMember())){
            event.getMessage().getChannel().sendMessage("You have to be in the same voice channel as me to use this").queue();
            return;
        }
        
        var playerManager = discord.bot().getPlayerManager();
        var musicManager = playerManager.getGuildMusicManager(event.getGuild());
        
        musicManager.player.setPaused(false);

        event.getChannel().sendMessage("Resumed the music, use !pause to pause the music").queue();

    } else if(command == "!volume"){
        
        const args = message.split(" ");
        if(args.length != 1){
            var amount = args[1];
   
            var playerManager = discord.bot().getPlayerManager();
            var musicManager = playerManager.getGuildMusicManager(event.getGuild());
            
            musicManager.player.setVolume(amount);
            
            event.getMessage().getChannel().sendMessage("The volume is now set to " + amount).queue();
        } else {
            event.getMessage().getChannel().sendMessage("Please specify the volume. Usage: !volume <amount>").queue();
        }

    } else if(command == "!skip"){
        var audioManager = event.getGuild().getAudioManager();
        if(!audioManager.isConnected()){
            event.getMessage().getChannel().sendMessage("I'm not playing any music!").queue();
            return;
        }
    
        var voiceChannel = audioManager.getConnectedChannel();
        if(!voiceChannel.getMembers().contains(event.getMember())){
            event.getMessage().getChannel().sendMessage("You have to be in the same voice channel as me to use this").queue();
            return;
        }

        var playerManager = discord.bot().getPlayerManager();
        var musicManager = playerManager.getGuildMusicManager(event.getGuild());
        musicManager.scheduler.nextTrack();
        
        event.getMessage().getChannel().sendMessage("Skipping song..").queue();
    } else if(command == "!queue"){
        var playerManager = discord.bot().getPlayerManager();
        var musicManager = playerManager.getGuildMusicManager(event.getGuild());
        
        var queue = musicManager.scheduler.getQueue()
        var queueArr = queue.toArray();
        if(queueArr.length != 0){
            event.getMessage().getChannel().sendMessage("Queue:").queue();
            for(var i in queueArr){
                event.getMessage().getChannel().sendMessage(" - " + queueArr[i].getInfo().title).queue();
            }
        } else {
            event.getMessage().getChannel().sendMessage("The queue is empty!").queue();
        }
    }
}
