package com.example.sosky.xiukan.fragement.favouite;

import android.os.Bundle;

import com.example.sosky.xiukan.adapter.ItemAdapter;
import com.example.sosky.xiukan.adapter.item.Movie;
import com.example.sosky.xiukan.fragement.RecyclerFragment;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public abstract class FavouriteFragment extends RecyclerFragment<Movie, LinearLayoutManager> {

    public void update() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        this.setLayoutManager(new LinearLayoutManager(this.getContext()));
        this.setAdapter(adapter());
        //this.setAdapter(adapter =
        mRefreshLayout.setEnabled(false);

        if (decoration() != null) {
            mRecyclerView.addItemDecoration(decoration());
        }

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public abstract ItemAdapter adapter();

    public RecyclerView.ItemDecoration decoration() {
        return null;
    }
}
