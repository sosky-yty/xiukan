package com.example.sosky.xiukan.fragement.favouite;

import com.example.sosky.xiukan.XiuKan;
import com.example.sosky.xiukan.adapter.ActressAdapter;
import com.example.sosky.xiukan.adapter.ItemAdapter;
import com.example.sosky.xiukan.view.decoration.ActressItemDecoration;

import androidx.recyclerview.widget.RecyclerView;




public class FavouriteActressFragment extends FavouriteFragment {
    @Override
    public ItemAdapter adapter() {
        return new ActressAdapter(XiuKan.CONFIGURATIONS.getStarredActresses(), this.getActivity());
    }

    @Override
    public RecyclerView.ItemDecoration decoration() {
        return new ActressItemDecoration();
    }
}
