package com.example.sosky.xiukan.fragement;

import com.google.android.material.appbar.AppBarLayout;

import androidx.fragment.app.Fragment;

public class ExtendedAppBarFragment extends Fragment {
    private AppBarLayout mAppBarLayout;

    public AppBarLayout getAppBarLayout() {
        return mAppBarLayout;
    }

    public void setAppBarLayout(AppBarLayout mAppBarLayout) {
        this.mAppBarLayout = mAppBarLayout;
    }
}
