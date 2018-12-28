package com.example.sosky.xiukan.fragement;


import android.os.Bundle;

import com.example.sosky.xiukan.XiuKan;
import com.example.sosky.xiukan.adapter.ActressAdapter;
import com.example.sosky.xiukan.adapter.item.Actores;
import com.example.sosky.xiukan.network.provider.AVMOProvider;
import com.example.sosky.xiukan.view.decoration.ActressItemDecoration;
import com.example.sosky.xiukan.view.listener.EndlessOnScrollListener;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class ActressesFragment extends RecyclerFragment<Actores, LinearLayoutManager> {

    public ActressesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        this.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //this.setAdapter(new SlideInBottomAnimationAdapter(new ActressAdapter(getItems(), this.getActivity())));
        this.setAdapter(new ActressAdapter(getItems(), this.getActivity()));

        mRecyclerView.addItemDecoration(new ActressItemDecoration());

        /*RecyclerView.ItemAnimator animator = new SlideInUpAnimator();
        animator.setAddDuration(300);
        mRecyclerView.setItemAnimator(animator);*/

        this.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getOnScrollListener().refresh();
            }
        });

        this.addOnScrollListener(new EndlessOnScrollListener<Actores>() {
            @Override
            public Call<ResponseBody> newCall(int page) {
                return ActressesFragment.this.newCall(page);
            }

            @Override
            public RecyclerView.LayoutManager getLayoutManager() {
                return ActressesFragment.this.getLayoutManager();
            }

            @Override
            public SwipeRefreshLayout getRefreshLayout() {
                return ActressesFragment.this.mRefreshLayout;
            }

            @Override
            public RecyclerView.Adapter getAdapter() {
                return ActressesFragment.this.getAdapter();
            }

            @Override
            public List<Actores> getItems() {
                return ActressesFragment.this.getItems();
            }

            @Override
            public void onResult(ResponseBody response) throws Exception {
                super.onResult(response);
                List<Actores> wrappers = AVMOProvider.parseActresses(response.string());

                int pos = getItems().size();

                getItems().addAll(wrappers);
                getAdapter().notifyItemRangeInserted(pos, wrappers.size());
            }
        });

        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(true);
                getOnRefreshListener().onRefresh();
            }
        });

        super.onActivityCreated(savedInstanceState);
    }

    public Call<ResponseBody> newCall(int page) {
        return XiuKan.SERVICE.getActresses(page);
    }
}
