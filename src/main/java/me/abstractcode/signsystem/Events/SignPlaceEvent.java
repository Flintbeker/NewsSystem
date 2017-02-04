package me.abstractcode.signsystem.Events;

import me.abstractcode.signsystem.Signs.Sign;
import me.abstractcode.signsystem.Signs.SignGroup;
import me.abstractcode.signsystem.Signs.SignGroupManager;
import me.abstractcode.signsystem.System;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import sun.misc.Signal;

import java.util.UUID;

/**
 * Created by Moritz on 04.02.2017.
 */
public class SignPlaceEvent implements Listener{

    @EventHandler
    public void placeSing(SignChangeEvent e){

        if(e.getLine(0).equalsIgnoreCase("[SignSystem]")){

            if(SignGroupManager.isSignGroupValid(e.getLine(1 )) ){
                SignGroup group = SignGroupManager.getSignGroupByName( e.getLine(1) );
                Sign s = new Sign(UUID.randomUUID().toString(), group, e.getBlock().getLocation());
                SignGroupManager.signs.add( s );
                e.getPlayer().sendMessage(System.prefix + "Sucessfully placed a Sign with the ID " + s.name + " and the Group " + group.name + "!");

            } else {

                e.getBlock().breakNaturally();

            }

        }

    }

}
