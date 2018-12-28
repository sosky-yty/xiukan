package com.example.sosky.xiukan.activity;

import android.content.DialogInterface;
import android.os.Bundle;

import android.view.MenuItem;

import com.example.sosky.xiukan.R;
import com.example.sosky.xiukan.XiuKan;
import com.example.sosky.xiukan.adapter.ViewPagerAdapter;
import com.example.sosky.xiukan.fragement.DownloadFragment;
import com.google.android.material.tabs.TabLayout;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;


public class DownloadActivity extends SecureActivity {

    @BindView(R.id.download_toolbar)
    public Toolbar mToolbar;

    @BindView(R.id.download_tabs)
    public TabLayout mTabLayout;

    @BindView(R.id.download_view_pager)
    public ViewPager mViewPager;

    public String keyword;

    @Override
    @SuppressWarnings("ConstantConditions")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        ButterKnife.bind(this);

        Bundle bundle = this.getIntent().getExtras();
        this.keyword = this.getIntent().getExtras().getString("keyword");

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(this.keyword);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Fragment fragment;

        fragment = new DownloadFragment();
        bundle = (Bundle) bundle.clone();
        bundle.putString("provider", "btso");
        fragment.setArguments(bundle);
        adapter.addFragment(fragment, "BTSO");

        fragment = new DownloadFragment();
        bundle = (Bundle) bundle.clone();
        bundle.putString("provider", "torrentkitty");
        fragment.setArguments(bundle);
        adapter.addFragment(fragment, "Torrent Kitty");

        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);

        long downloadCounter = XiuKan.CONFIGURATIONS.getDownloadCounter();
        if (downloadCounter == -1) {
            return;
        }
        downloadCounter++;
        XiuKan.CONFIGURATIONS.setDownloadCounter(downloadCounter);
        if (downloadCounter % 20 == 0) {
            new AlertDialog.Builder(this)
                    .setTitle("用得不错？")
                    .setMessage("您的支持是我动力来源！\n请考虑为我买杯咖啡醒醒脑，甚至其他…… ;)")
                    .setPositiveButton("为我买杯咖啡", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            XiuKan.a(DownloadActivity.this);
                            new AlertDialog.Builder(DownloadActivity.this)
                                    .setMessage("感谢您的支持！;)\n新功能持续开发中！")
                                    .setPositiveButton("确认", null)
                                    .show();
                        }
                    })
                    .setNeutralButton("不再显示", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            XiuKan.CONFIGURATIONS.setDownloadCounter(-1);
                        }
                    })
                    .setNegativeButton("取消", null)
                    .show();
        }
        XiuKan.CONFIGURATIONS.save();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}