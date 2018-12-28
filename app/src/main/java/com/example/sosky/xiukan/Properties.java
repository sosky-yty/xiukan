package com.example.sosky.xiukan;

import com.example.sosky.xiukan.adapter.item.DataSource;

import java.util.List;



public class Properties {

    private String latest_version;
    private int latest_version_code;

    private String changelog;
    private List<DataSource> data_sources;

    public Properties() {
    }

    public String getLatestVersion() {
        return latest_version;
    }

    public int getLatestVersionCode() {
        return latest_version_code;
    }

    public List<DataSource> getDataSources() {
        return data_sources;
    }

    public String getChangelog() {
        return changelog;
    }
}
