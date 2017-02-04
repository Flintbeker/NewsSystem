package me.abstractcode.signsystem.Signs;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Moritz on 04.02.2017.
 */
public class SignGroup implements Serializable{

    @Getter @Setter
    public String name;
    @Getter @Setter
    public ArrayList<Sign> signs = new ArrayList<Sign>();

    public SignGroup(String name){

        this.name = name;

    }

    public void addSign(Sign sign){

        signs.add(sign);

    }

    public void removeSign(Sign sign){

        signs.remove(sign);

    }

}
