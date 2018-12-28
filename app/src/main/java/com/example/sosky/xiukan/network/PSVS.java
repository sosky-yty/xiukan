package com.example.sosky.xiukan.network;

import com.example.sosky.xiukan.XiuKan;
import com.example.sosky.xiukan.network.item.AvgleSearchResult;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Project: JAViewer
 */
public interface PSVS {

    String BASE_URL = "http://api.rekonquer.com";
    PSVS INSTANCE = new Retrofit.Builder()
            .baseUrl(PSVS.BASE_URL)
            .client(XiuKan.HTTP_CLIENT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PSVS.class);

    @GET("/psvs/search.php")
    Call<AvgleSearchResult> search(@Query(value = "kw") String keyword);
}
