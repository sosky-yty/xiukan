package com.example.sosky.xiukan.fragement.favouite;

import com.example.sosky.xiukan.XiuKan;
import com.example.sosky.xiukan.adapter.ItemAdapter;
import com.example.sosky.xiukan.adapter.MovieAdapter;
import com.example.sosky.xiukan.view.decoration.MovieItemDecoration;

import androidx.recyclerview.widget.RecyclerView;





public class FavouriteMovieFragment extends FavouriteFragment {
    @Override
    public ItemAdapter adapter() {
        return new MovieAdapter(XiuKan.CONFIGURATIONS.getStarredMovies(), this.getActivity()) {{
            showIfHot = false;
        }};
    }

    @Override
    public RecyclerView.ItemDecoration decoration() {
        return new MovieItemDecoration();
    }
}
