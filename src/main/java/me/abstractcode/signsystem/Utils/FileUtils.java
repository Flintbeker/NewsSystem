package me.abstractcode.signsystem.Utils;

import me.abstractcode.signsystem.Signs.SignGroup;
import me.abstractcode.signsystem.System;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by Moritz on 04.02.2017.
 */
public class FileUtils {

    public static File f = new File("plugins/SignSystem/config.yml" );
    public static FileConfiguration cfg;

    public static void setup() {

        cfg = YamlConfiguration.loadConfiguration(f);
        Bukkit.getConsoleSender().sendMessage(System.prefix + "Loaded the Config-File!");

    }

    public static void saveLocation( String name, Location loc ) {

        Bukkit.getConsoleSender().sendMessage(System.prefix + "Trying to save the Location..." );
        cfg.set(name, loc);

        try {
            cfg.save( f );
        } catch ( IOException e ) {
            Bukkit.getConsoleSender().sendMessage(System.prefix + "Could not save the Location: " + name );
        }

        Bukkit.getConsoleSender().sendMessage(System.prefix + "Saved Location: " + name );

    }

    public static Location getLocation( String name ) {

        //Location can be null if it is, it´s an error! And Hey SPIGOT at the Time!
        if( cfg.isSet( name ) ){

            Location loc = (Location) cfg.get( name );
            return loc;

        }

        return null;

    }


}
