package com.example.sosky.xiukan.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.sosky.xiukan.R;
import com.example.sosky.xiukan.adapter.item.Actores;
import com.example.sosky.xiukan.view.SquareTopCrop;
import com.example.sosky.xiukan.view.ViewUtil;
import com.example.sosky.xiukan.view.listener.ActressClickListener;
import com.example.sosky.xiukan.view.listener.ActressLongClickListener;

import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


import static com.bumptech.glide.load.engine.DiskCacheStrategy.SOURCE;


public class ActressPaletteAdapter extends RecyclerView.Adapter<ActressPaletteAdapter.ViewHolder> {

    private List<Actores> actresses;

    private Activity mParentActivity;

    private ImageView mIcon;

    public ActressPaletteAdapter(List<Actores> actresses, Activity mParentActivity, ImageView mIcon) {
        this.actresses = actresses;
        this.mParentActivity = mParentActivity;
        this.mIcon = mIcon;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_actress_palette, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Actores actress = actresses.get(position);

        holder.mCard.setOnClickListener(new ActressClickListener(actress, mParentActivity));
        holder.mCard.setOnLongClickListener(new ActressLongClickListener(actress, mParentActivity));

        holder.mName.setText(actress.getName());

        if (position == 0) {
            ViewUtil.alignIconToView(mIcon, holder.mImage);
        }

        holder.mImage.setImageResource(R.drawable.ic_movie_actresses);

        if (actress.getImageUrl().trim().isEmpty()) {
            return;
        }

        Glide.with(holder.mImage.getContext().getApplicationContext())
                .load(actress.getImageUrl())
                .asBitmap()
                .placeholder(R.drawable.ic_movie_actresses)
                .diskCacheStrategy(SOURCE) // override default RESULT cache and apply transform always
                .skipMemoryCache(true) // do not reuse the transformed result while running
                .transform(new SquareTopCrop(holder.mImage.getContext()))
                //.transform(new PositionedCropTransformation(holder.mImage.getContext(), 0, 0))
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        //resource = Bitmap.createBitmap(resource, 0, 0, resource.getWidth(), resource.getWidth());
                        holder.mImage.setImageBitmap(resource);

                        try {
                            Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                                @Override
                                public void onGenerated(Palette palette) {
                                    Palette.Swatch swatch = palette.getLightVibrantSwatch();
                                    if (swatch == null) {
                                        return;
                                    }
                                    holder.mCard.setCardBackgroundColor(swatch.getRgb());
                                    holder.mName.setTextColor(swatch.getBodyTextColor());
                                }
                            });
                        } catch (Exception ignored) {
                        }
                    }
                });

    }

    @Override
    public int getItemCount() {
        return actresses == null ? 0 : actresses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.actress_palette_img)
        public ImageView mImage;

        @BindView(R.id.actress_palette_name)
        public TextView mName;

        @BindView(R.id.card_actress_palette)
        public CardView mCard;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
