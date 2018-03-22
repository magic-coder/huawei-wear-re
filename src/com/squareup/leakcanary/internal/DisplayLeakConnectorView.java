package com.squareup.leakcanary.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public final class DisplayLeakConnectorView extends View {
    private static final Paint clearPaint = new Paint(1);
    private static final Paint iconPaint = new Paint(1);
    private static final Paint leakPaint = new Paint(1);
    private static final Paint rootPaint = new Paint(1);
    private Bitmap cache;
    private Type type = Type.NODE;

    public enum Type {
        START,
        NODE,
        END
    }

    static {
        iconPaint.setColor(-4539718);
        rootPaint.setColor(-8083771);
        leakPaint.setColor(-5155506);
        clearPaint.setColor(0);
        clearPaint.setXfermode(LeakCanaryUi.CLEAR_XFER_MODE);
    }

    public DisplayLeakConnectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (!(this.cache == null || (this.cache.getWidth() == width && this.cache.getHeight() == height))) {
            this.cache.recycle();
            this.cache = null;
        }
        if (this.cache == null) {
            this.cache = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            Canvas canvas2 = new Canvas(this.cache);
            float f = ((float) width) / 2.0f;
            float f2 = ((float) height) / 2.0f;
            float f3 = ((float) width) / 3.0f;
            float dpToPixel = LeakCanaryUi.dpToPixel(4.0f, getResources());
            iconPaint.setStrokeWidth(dpToPixel);
            rootPaint.setStrokeWidth(dpToPixel);
            switch (this.type) {
                case NODE:
                    canvas2.drawLine(f, 0.0f, f, (float) height, iconPaint);
                    canvas2.drawCircle(f, f2, f, iconPaint);
                    canvas2.drawCircle(f, f2, f3, clearPaint);
                    break;
                case START:
                    float f4 = f - (dpToPixel / 2.0f);
                    canvas2.drawRect(0.0f, 0.0f, (float) width, f4, rootPaint);
                    canvas2.drawCircle(0.0f, f4, f4, clearPaint);
                    canvas2.drawCircle((float) width, f4, f4, clearPaint);
                    canvas2.drawLine(f, 0.0f, f, f2, rootPaint);
                    canvas2.drawLine(f, f2, f, (float) height, iconPaint);
                    canvas2.drawCircle(f, f2, f, iconPaint);
                    canvas2.drawCircle(f, f2, f3, clearPaint);
                    break;
                default:
                    canvas2.drawLine(f, 0.0f, f, f2, iconPaint);
                    canvas2.drawCircle(f, f2, f3, leakPaint);
                    break;
            }
        }
        canvas.drawBitmap(this.cache, 0.0f, 0.0f, null);
    }

    public void setType(Type type) {
        if (type != this.type) {
            this.type = type;
            if (this.cache != null) {
                this.cache.recycle();
                this.cache = null;
            }
            invalidate();
        }
    }
}
