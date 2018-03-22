package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;

public class CircularImage extends C1538u {
    public CircularImage(Context context) {
        super(context);
    }

    public CircularImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Bitmap mo2530a() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawOval(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), paint);
        return createBitmap;
    }
}
