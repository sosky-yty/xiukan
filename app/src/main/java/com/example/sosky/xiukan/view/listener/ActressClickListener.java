package com.example.sosky.xiukan.view.listener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sosky.xiukan.activity.MovieListActivity;
import com.example.sosky.xiukan.adapter.item.Actores;



public class ActressClickListener implements View.OnClickListener {

    private Activity mActivity;
    private Actores actress;

    public ActressClickListener(Actores actress, Activity mActivity) {
        this.actress = actress;
        this.mActivity = mActivity;
    }

    @Override
    public void onClick(View v) {
        if (actress.getLink() != null) {
            Intent intent = new Intent(mActivity, MovieListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("title", actress.getName() + " 的作品");
            bundle.putString("link", actress.getLink());

            intent.putExtras(bundle);

            mActivity.startActivity(intent);
        }
    }
}
