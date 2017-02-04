package me.abstractcode.signsystem.Signs;

import org.bukkit.Location;

import java.io.Serializable;

/**
 * Created by Moritz on 04.02.2017.
 */
public class Sign implements Serializable{

    public String name;
    public SignGroup group;
    public Location loc;

    public Sign(String name, SignGroup group, Location loc ) {

        this.group = group;
        this.name = name;
        this.loc = loc;

    }

}
