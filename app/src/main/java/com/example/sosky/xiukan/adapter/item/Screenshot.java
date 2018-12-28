package com.example.sosky.xiukan.adapter.item;


public class Screenshot extends Linkable {

    protected String thumbnailUrl;

    public static Screenshot create(String thumbnailUrl, String imageUrl) {
        Screenshot screenshot = new Screenshot();
        screenshot.thumbnailUrl = thumbnailUrl;
        screenshot.link = imageUrl;
        return screenshot;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getImageUrl() {
        return getLink();
    }
}
