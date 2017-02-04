package me.abstractcode.signsystem.Commands;

import me.abstractcode.signsystem.Signs.SignGroup;
import me.abstractcode.signsystem.Signs.SignGroupManager;
import me.abstractcode.signsystem.System;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Moritz on 04.02.2017.
 */
public class SignSystem implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("createGroup")) {

                if (!SignGroupManager.isSignGroupValid(args[1])) {

                    SignGroup group = new SignGroup(args[1]);
                    SignGroupManager.groups.add(group);
                    sender.sendMessage(System.prefix + "Sucessfully added the SignGroup: " + args[1]);

                } else {

                    sender.sendMessage(System.prefix + "The Group already exists!");

                }

            } else if (args[0].equalsIgnoreCase("deleteGroup")) {

                if (SignGroupManager.isSignGroupValid(args[1])) {

                    SignGroupManager.deleteGroup(SignGroupManager.getSignGroupByName(args[1]));
                    sender.sendMessage(System.prefix + "Sucessfully deleted group " + args[1]);

                } else {

                    sender.sendMessage(System.prefix + "This SignGroup does not exist!");

                }

            } else {

                sender.sendMessage(System.prefix + "Just type /SignSystem for help!");

            }
        } else {
            sender.sendMessage(System.prefix + "You can type in: \n/SignSystem createGroup <NAME>\n/SignSystem deleteGroup <NAME>");
        }
        return false;
    }
}
