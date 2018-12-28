package com.example.sosky.xiukan.fragement;

import android.os.Bundle;

import com.example.sosky.xiukan.XiuKan;

import androidx.annotation.Nullable;

import okhttp3.ResponseBody;
import retrofit2.Call;


public class MovieListFragment extends MovieFragment {

    public String link;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        this.link = bundle.getString("link");
    }

    @Override
    public Call<ResponseBody> newCall(int page) {
        return XiuKan.SERVICE.get(this.link + "/page/" + page);
    }
}
