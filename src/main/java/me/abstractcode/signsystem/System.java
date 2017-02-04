package me.abstractcode.signsystem;

import me.abstractcode.signsystem.Events.SignPlaceEvent;
import me.abstractcode.signsystem.Signs.Sign;
import me.abstractcode.signsystem.Signs.SignGroup;
import me.abstractcode.signsystem.Signs.SignGroupManager;
import me.abstractcode.signsystem.Utils.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

/**
 * Created by Moritz on 04.02.2017.
 */
public class System extends JavaPlugin {

    private CommandSender cs;
    public static String prefix = "§3SignSystem §8| §7";

    @Override
    public void onEnable() {

        cs = Bukkit.getConsoleSender();
        register();
        FileUtils.setup();
        signs();
        font();

    }

    @Override
    public void onDisable() {

    }

    private void register(){

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents( new SignPlaceEvent(), this );

    }

    private void signs() {

        SignGroupManager.loadSigns();
        SignGroupManager.loadSignGroup();

    }

    private void font(){

        //Setup Nachrichen
        try {
            cs.sendMessage(prefix + "The SignSystem will enable shortly..." );
            cs.sendMessage(" _____ _         _____         _             " );
            Thread.sleep(600);
            cs.sendMessage("|   __|_|___ ___|   __|_ _ ___| |_ ___ _____ " );
            Thread.sleep(600);
            cs.sendMessage("|__   | | . |   |__   | | |_ -|  _| -_|     |" );
            Thread.sleep(600);
            cs.sendMessage("|_____|_|_  |_|_|_____|_  |___|_| |___|_|_|_|" );
            Thread.sleep(600);
            cs.sendMessage( "        |___|         |___|                  " );
        } catch ( Exception e ) {

        }

    }
}
