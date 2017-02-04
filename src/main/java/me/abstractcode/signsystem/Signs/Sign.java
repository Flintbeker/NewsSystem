package me.abstractcode.signsystem.Signs;

import me.abstractcode.signsystem.System;
import me.abstractcode.signsystem.Utils.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.Serializable;

/**
 * Created by Moritz on 04.02.2017.
 */
public class Sign implements Serializable{

    public String name;
    public String SignGroupName;

    public Sign(String name, SignGroup group, Location loc) {

        FileUtils.saveLocation(name, loc);
        this.SignGroupName = group.name;
        this.name = name;

    }

    public boolean verify(){

        if(!SignGroupManager.isSignGroupValid( SignGroupName )) {

            Bukkit.broadcastMessage(System.prefix + "Sign could not be loaded!");
            FileUtils.getLocation(name).getBlock().breakNaturally();
            Sign s = SignGroupManager.getSignByName( name );
            SignGroupManager.signs.remove( s );
            SignGroupManager.deleteSign( s );
            return false;

        }

        return true;

    }

}
