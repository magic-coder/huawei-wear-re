package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.huawei.p190v.C2538c;

/* compiled from: MaskedImage */
public abstract class C1538u extends ImageView {
    private static final Xfermode f3646a = new PorterDuffXfermode(Mode.DST_IN);
    private Bitmap f3647b;
    private Paint f3648c;

    public abstract Bitmap mo2530a();

    public C1538u(Context context) {
        super(context);
    }

    public C1538u(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C1538u(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            try {
                if (this.f3648c == null) {
                    this.f3648c = new Paint();
                    this.f3648c.setFilterBitmap(false);
                    this.f3648c.setXfermode(f3646a);
                }
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
                drawable.setBounds(0, 0, getWidth(), getHeight());
                drawable.draw(canvas);
                if (this.f3647b == null || this.f3647b.isRecycled()) {
                    this.f3647b = mo2530a();
                }
                canvas.drawBitmap(this.f3647b, 0.0f, 0.0f, this.f3648c);
                canvas.restoreToCount(saveLayer);
            } catch (Exception e) {
                C2538c.m12680e("MaskedImage", "EXCEPTION E = " + e.getMessage());
            }
        }
    }
}
