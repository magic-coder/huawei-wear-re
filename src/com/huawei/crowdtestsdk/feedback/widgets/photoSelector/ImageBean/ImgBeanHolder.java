package com.huawei.crowdtestsdk.feedback.widgets.photoSelector.ImageBean;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class ImgBeanHolder {
    private Bitmap bitmap;
    private ImageView imageView;
    private String path;

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public String getPath() {
        return this.path;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
