package com.huawei.ui.device.views.device;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.d.c;

public class BatteryView extends ImageView {
    private Paint f7824a;
    private float f7825b = 2.0f;
    private int f7826c;
    private int f7827d;
    private float f7828e;
    private float f7829f;
    private float f7830g;
    private float f7831h = 0.0f;
    private float f7832i = 100.0f;
    private Context f7833j;

    public BatteryView(Context context) {
        super(context);
        this.f7833j = context;
        C2538c.m12677c("BatteryView", "mContext = " + this.f7833j);
        m11276a();
    }

    public BatteryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11276a();
    }

    public BatteryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11276a();
    }

    private void m11276a() {
        this.f7824a = new Paint();
        this.f7824a.setColor(SupportMenu.CATEGORY_MASK);
        this.f7824a.setAntiAlias(true);
        this.f7824a.setStyle(Style.FILL);
        this.f7824a.setStrokeWidth(this.f7825b);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f7828e = (float) c.a(this.f7833j, 2.0f);
        float a = (float) c.a(this.f7833j, 17.0f - ((13.0f * this.f7831h) / this.f7832i));
        this.f7829f = (float) c.a(this.f7833j, 10.0f);
        this.f7830g = (float) c.a(this.f7833j, 17.0f);
        C2538c.m12677c("BatteryView", "setPower mPower = " + this.f7831h + ", top = " + a + ",left = " + this.f7828e + ",right = " + this.f7829f + ",bottom = " + this.f7830g);
        canvas.drawRect(this.f7828e, a, this.f7829f, this.f7830g, this.f7824a);
    }

    protected void onMeasure(int i, int i2) {
        this.f7826c = MeasureSpec.getSize(i);
        this.f7827d = MeasureSpec.getSize(i2);
        setMeasuredDimension(this.f7826c, this.f7827d);
    }
}
