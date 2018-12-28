package com.example.sosky.xiukan.view.decoration;

import android.graphics.Rect;
import android.view.View;

import com.example.sosky.xiukan.view.ViewUtil;

import androidx.recyclerview.widget.RecyclerView;



public class DownloadItemDecoration extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Rect rect = new Rect();
        if (parent.getChildAdapterPosition(view) == 0) {
            rect.top = ViewUtil.dpToPx(8);
        }
        outRect.set(rect);
    }
}
