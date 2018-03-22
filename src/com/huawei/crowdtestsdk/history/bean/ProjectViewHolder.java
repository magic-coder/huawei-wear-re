package com.huawei.crowdtestsdk.history.bean;

import android.widget.ImageView;
import android.widget.TextView;

public class ProjectViewHolder {
    private ImageView projectIcon;
    private TextView tvProjectTitle;

    public ImageView getProjectIcon() {
        return this.projectIcon;
    }

    public TextView getTvProjectTitle() {
        return this.tvProjectTitle;
    }

    public void setProjectIcon(ImageView imageView) {
        this.projectIcon = imageView;
    }

    public void setTvProjectTitle(TextView textView) {
        this.tvProjectTitle = textView;
    }
}
