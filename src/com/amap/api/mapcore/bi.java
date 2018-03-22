package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.view.View;

/* compiled from: ScaleView */
class bi extends View {
    private String f11086a = "";
    private int f11087b = 0;
    private AMapDelegateImp f11088c;
    private Paint f11089d;
    private Paint f11090e;
    private Rect f11091f;

    public void m15079a() {
        this.f11089d = null;
        this.f11090e = null;
        this.f11091f = null;
        this.f11086a = null;
    }

    public bi(Context context) {
        super(context);
    }

    public bi(Context context, AMapDelegateImp aMapDelegateImp) {
        super(context);
        this.f11088c = aMapDelegateImp;
        this.f11089d = new Paint();
        this.f11091f = new Rect();
        this.f11089d.setAntiAlias(true);
        this.f11089d.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f11089d.setStrokeWidth(2.0f * C3264r.f11365a);
        this.f11089d.setStyle(Style.STROKE);
        this.f11090e = new Paint();
        this.f11090e.setAntiAlias(true);
        this.f11090e.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f11090e.setTextSize(20.0f * C3264r.f11365a);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f11086a != null && !this.f11086a.equals("") && this.f11087b != 0) {
            Point I = this.f11088c.mo3742I();
            if (I != null) {
                this.f11090e.getTextBounds(this.f11086a, 0, this.f11086a.length(), this.f11091f);
                int i = I.x;
                int height = (I.y - this.f11091f.height()) + 5;
                canvas.drawText(this.f11086a, (float) i, (float) height, this.f11090e);
                int height2 = height + (this.f11091f.height() - 5);
                canvas.drawLine((float) i, (float) (height2 - 2), (float) i, (float) (height2 + 2), this.f11089d);
                canvas.drawLine((float) i, (float) height2, (float) (this.f11087b + i), (float) height2, this.f11089d);
                canvas.drawLine((float) (this.f11087b + i), (float) (height2 - 2), (float) (this.f11087b + i), (float) (height2 + 2), this.f11089d);
            }
        }
    }

    public void m15081a(String str) {
        this.f11086a = str;
    }

    public void m15080a(int i) {
        this.f11087b = i;
    }
}
