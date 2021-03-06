package com.endercrest.colorcube.commands;

import com.endercrest.colorcube.GameManager;
import com.endercrest.colorcube.MessageManager;
import com.endercrest.colorcube.SettingsManager;
import org.bukkit.entity.Player;

public class Spectate implements SubCommand {

    @Override
    public boolean onCommand(Player p, String[] args) {
        if(args.length == 1){
            try {
                int id = Integer.parseInt(args[0]);
                GameManager.getInstance().addSpectator(p, id);
            }catch(NumberFormatException e){
                MessageManager.getInstance().sendFMessage("error.notanumber", p, "input-" + args[0]);
            }
        }else{
            MessageManager.getInstance().sendFMessage("error.nospecified", p, "input-Arena");
        }
        return true;
    }

    @Override
    public String helpInfo() {
        return "/cc spectate <id> - " + SettingsManager.getInstance().getMessagesConfig().getString("messages.help.spectate");
    }

    @Override
    public String permission() {
        return "cc.arena.spectate";
    }
}
