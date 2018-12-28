package com.example.sosky.xiukan.network.provider;

import com.example.sosky.xiukan.adapter.item.DownloadLink;
import com.example.sosky.xiukan.adapter.item.MagentLink;

import java.util.List;


import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Project: JAViewer
 */
public abstract class DownloadLinkProvider {
    public static DownloadLinkProvider getProvider(String name) {
        switch (name.toLowerCase().trim()) {
            case "btso":
                return new BTSOLinkProvider();
            case "torrentkitty":
                return new TorrentKittyLinkProvider();
            default:
                return null;
        }
    }

    public abstract Call<ResponseBody> search(String keyword, int page);

    public abstract List<DownloadLink> parseDownloadLinks(String htmlContent);

    public abstract Call<ResponseBody> get(String url);

    public abstract MagentLink parseMagnetLink(String htmlContent);
}
