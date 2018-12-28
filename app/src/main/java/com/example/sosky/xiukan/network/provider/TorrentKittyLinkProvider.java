package com.example.sosky.xiukan.network.provider;

import com.example.sosky.xiukan.adapter.item.DownloadLink;
import com.example.sosky.xiukan.adapter.item.MagentLink;
import com.example.sosky.xiukan.network.TorrentKitty;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Project: JAViewer
 */
public class TorrentKittyLinkProvider extends DownloadLinkProvider {


    @Override
    public Call<ResponseBody> search(String keyword, int page) {
        if (page == 1) {
            return TorrentKitty.INSTANCE.search(keyword);
        } else {
            return null;
        }
    }

    @Override
    public List<DownloadLink> parseDownloadLinks(String htmlContent) {
        ArrayList<DownloadLink> links = new ArrayList<>();
        Element table = Jsoup.parse(htmlContent).getElementById("archiveResult");
        for (Element tr : table.getElementsByTag("tr")) {
            try {
                links.add(DownloadLink.create(
                        tr.getElementsByClass("name").first().text(),
                        "",
                        tr.getElementsByClass("date").first().text(),
                        null,
                        tr.getElementsByAttributeValue("rel", "magnet").first().attr("href")
                ));
            } catch (Exception ignored) {

            }
        }

        return links;
    }

    @Override
    public Call<ResponseBody> get(String url) {
        return null;
        //ABANDONED
    }

    @Override
    public MagentLink parseMagnetLink(String htmlContent) {
        return null;
        //ABANDONED
    }
}
