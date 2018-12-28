package com.example.sosky.xiukan.adapter.item;

public class Actores extends Linkable{

    protected String name;
    protected String imageUrl;

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static Actores create(String name ,String imageUrl ,String detailUrl){
        Actores actress = new Actores();
        actress.name = name;
        actress.imageUrl = imageUrl;
        actress.link = detailUrl;
        return actress;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }

        if (obj instanceof Actores) {
            return this.name.equals(((Actores) obj).getName());
        }

        return false;
    }
}
