package com.example.sosky.xiukan.adapter.item;

import java.io.Serializable;

public class MagentLink implements Serializable {

    protected String magentlink;

    public static MagentLink create(String link){
        MagentLink magentLink = new MagentLink();
        if (link != null){
            magentLink.magentlink = link.substring(0,link.indexOf("&"));
        }
        return  magentLink;
    }

    public String getMagentlink(){return magentlink;}
}
