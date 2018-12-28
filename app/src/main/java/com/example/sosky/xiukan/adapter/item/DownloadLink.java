package com.example.sosky.xiukan.adapter.item;

public class DownloadLink extends Linkable {
    protected String title;
    protected String size;
    protected String date;
    protected MagentLink magnetLink;

    public static DownloadLink create(String title, String size, String date, String link, String magnetLink) {
        DownloadLink download = new DownloadLink();
        download.title = title;
        download.size = size;
        download.date = date;
        download.link = link;
        download.magnetLink = MagentLink.create(magnetLink);
        return download;
    }

    public String getTitle() {
        return title;
    }

    public String getSize() {
        return size;
    }

    public String getDate() {
        return date;
    }

    public boolean hasMagnetLink() {
        return magnetLink.getMagentlink() != null;
    }

    public String getMagnetLink() {
        return magnetLink.getMagentlink();
    }
}
