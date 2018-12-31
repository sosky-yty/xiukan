package com.example.sosky.xiukan.fragement;

import com.example.sosky.xiukan.XiuKan;

import okhttp3.ResponseBody;
import retrofit2.Call;


public class PopularFragment extends MovieFragment {
    @Override
    public Call<ResponseBody> newCall(int page) {
        return XiuKan.SERVICE.getPopular(page);
    }
}
