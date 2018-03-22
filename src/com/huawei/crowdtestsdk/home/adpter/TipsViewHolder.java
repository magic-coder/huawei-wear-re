package com.huawei.crowdtestsdk.home.adpter;

import android.widget.ImageView;
import android.widget.TextView;

public class TipsViewHolder {
    private ImageView imageView;
    private TextView textViewContent;
    private TextView textViewTitle;

    public ImageView getImageView() {
        return this.imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getTextViewTitle() {
        return this.textViewTitle;
    }

    public void setTextViewTitle(TextView textView) {
        this.textViewTitle = textView;
    }

    public TextView getTextViewContent() {
        return this.textViewContent;
    }

    public void setTextViewContent(TextView textView) {
        this.textViewContent = textView;
    }
}
