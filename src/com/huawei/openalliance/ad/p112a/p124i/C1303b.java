package com.huawei.openalliance.ad.p112a.p124i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

public abstract class C1303b extends RelativeLayout {
    protected Context f2810a;

    public C1303b(Context context) {
        super(context);
        this.f2810a = context;
    }

    protected ImageView m5795a(String str) {
        Bitmap decodeFile;
        ImageView imageView = new ImageView(this.f2810a);
        Options options = new Options();
        try {
            options.inJustDecodeBounds = false;
            decodeFile = BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            C1336d.m5888c("AdView", "OutOfMemoryError when read image");
            decodeFile = null;
        }
        if (decodeFile != null) {
            imageView.setImageBitmap(decodeFile);
        }
        return imageView;
    }
}
