package me.abstractcode.signsystem.Signs;

import me.abstractcode.signsystem.System;
import org.bukkit.Bukkit;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Moritz on 04.02.2017.
 */
public class SignGroupManager {

    public static ArrayList<Sign> signs = new ArrayList<Sign>();
    public static ArrayList<SignGroup> groups = new ArrayList<SignGroup>();
    public static String fileName = "plugins/SignSystem/Signs/";
    public static String groupFileName = "plugins/SignSystem/Groups/";

    public static void addSign( Sign sign) {

        signs.add( sign );

    }

    public static void saveSign( Sign sign ) {

        try {

            File SignFile = new File(fileName + sign.name + ".sign");
            SignFile.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream( SignFile );
            ObjectOutputStream oos = new ObjectOutputStream( fos );
            oos.writeObject(sign);

        } catch ( Exception e ) {

            Bukkit.getConsoleSender().sendMessage(System.prefix + "Could not save the Sign with the name " + sign.name);
            e.printStackTrace();

        }

    }

    public static void saveSignGroup( SignGroup group ) {

        try {

            File SignGroupFile = new File( groupFileName + group.name + ".group");
            SignGroupFile.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream( SignGroupFile );
            ObjectOutputStream oos = new ObjectOutputStream( fos );
            oos.writeObject(group);

        } catch ( Exception e ) {

            Bukkit.getConsoleSender().sendMessage(System.prefix + "Could not save the SignGroup with the name " + group.name);
            e.printStackTrace();

        }

    }

    public static void loadSigns(){

        try {

            File f = new File(fileName);
            File[] files = f.listFiles();

            for(File signFile : files){

                if(signFile.getName().contains(".sign")){

                    Sign s;
                    FileInputStream fis = new FileInputStream( signFile );
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    s = (Sign) ois.readObject();
                    signs.add(s);
                    Bukkit.getConsoleSender().sendMessage("Loaded Sign...");

                } else {

                    Bukkit.getConsoleSender().sendMessage(System.prefix + "There is a file that is not a Sign: " + signFile.getAbsolutePath());

                }

            }

        } catch ( Exception e ) {

            Bukkit.getConsoleSender().sendMessage(System.prefix + "There are no Signs!");

        }

    }

    public static void loadSignGroup() {

        try {

            File f = new File( groupFileName );
            File[] files = f.listFiles();

            for(File signFile : files) {

                if(signFile.getName().contains( ".group" )) {

                    SignGroup s;
                    FileInputStream fis = new FileInputStream( signFile );
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    s = (SignGroup) ois.readObject();
                    groups.add( s );
                    Bukkit.getConsoleSender().sendMessage("Loaded Group...");

                } else {

                    Bukkit.getConsoleSender().sendMessage(System.prefix + "There is a file that is not a SignGroup: " + signFile.getAbsolutePath());

                }

            }

        } catch ( Exception e ) {

            Bukkit.getConsoleSender().sendMessage(System.prefix + "There are no SignGroups!");

        }

    }

    public static void saveAll() {

        for( Sign s : signs ){

            saveSign( s );

        }

    }

    public static boolean isSignGroupValid( String groupName ){

        for( SignGroup group : groups ) {

            if( group.name.equals( groupName ) ) {

                return true;

            }

        }
        return true;
    }

    public static SignGroup getSignGroupByName( String groupName ){

        for( SignGroup group : groups ) {

            if( group.name.equals( groupName ) ) {

                return group;

            }

        }
        return null;

    }

}
