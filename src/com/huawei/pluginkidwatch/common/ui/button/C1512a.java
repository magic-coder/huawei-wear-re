package com.huawei.pluginkidwatch.common.ui.button;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.d;

/* compiled from: DeviceTextImageButton */
public class C1512a extends View {
    int f3556a = 0;
    int f3557b = 0;
    int f3558c = 0;
    private int f3559d = 0;
    private Paint f3560e;
    private RectF f3561f;

    public C1512a(Context context, int i) {
        super(context);
        m7011a(context, i);
    }

    private void m7011a(Context context, int i) {
        this.f3556a = C1492l.m6901a(context, (float) i);
        this.f3560e = new Paint();
        this.f3561f = new RectF();
        this.f3558c = i;
    }

    protected void onDraw(Canvas canvas) {
        float a;
        super.onDraw(canvas);
        this.f3557b = 0;
        this.f3560e.setColor(getResources().getColor(d.kw_color_white_85alpha));
        this.f3560e.setStyle(Style.FILL);
        this.f3560e.setAntiAlias(true);
        String str = this.f3559d + "";
        this.f3557b = (this.f3556a * (str.length() - 1)) / 2;
        RectF rectF = this.f3561f;
        this.f3561f.top = 0.0f;
        rectF.left = 0.0f;
        this.f3561f.right = (float) (this.f3556a + this.f3557b);
        this.f3561f.bottom = (float) this.f3556a;
        canvas.drawOval(this.f3561f, this.f3560e);
        this.f3560e.setColor(Color.rgb(223, 38, 37));
        rectF = this.f3561f;
        this.f3561f.top = 0.5f;
        rectF.left = 0.5f;
        this.f3561f.right = (float) (((double) (this.f3556a + this.f3557b)) - 0.5d);
        this.f3561f.bottom = (float) (((double) this.f3556a) - 0.5d);
        canvas.drawOval(this.f3561f, this.f3560e);
        this.f3560e.setColor(-1);
        this.f3560e.setStyle(Style.FILL);
        this.f3560e.setAntiAlias(true);
        this.f3560e.setTypeface(Typeface.DEFAULT_BOLD);
        this.f3560e.setTextSize((float) C1492l.m6901a(getContext(), (float) (this.f3558c - 1)));
        int a2 = C1512a.m7010a(this.f3560e, str);
        int a3 = m7012a(this.f3560e);
        float f = ((float) ((this.f3556a + this.f3557b) - a2)) / 2.0f;
        if (this.f3558c <= 10) {
            a = (float) (((a3 / 2) + (this.f3556a / 2)) - (a3 - C1492l.m6901a(getContext(), (float) (this.f3558c - 1))));
        } else {
            a = (float) (((a3 / 2) + (this.f3556a / 2)) - (a3 - C1492l.m6901a(getContext(), (float) (this.f3558c - 2))));
        }
        canvas.drawText(str, f, a, this.f3560e);
    }

    public static int m7010a(Paint paint, String str) {
        int i = 0;
        if (str != null && str.length() > 0) {
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            int i2 = 0;
            while (i2 < length) {
                int ceil = ((int) Math.ceil((double) fArr[i2])) + i;
                i2++;
                i = ceil;
            }
        }
        return i;
    }

    public int m7012a(Paint paint) {
        FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil((double) (fontMetrics.descent - fontMetrics.ascent));
    }

    public int getmNum() {
        return this.f3559d;
    }

    public void setmNum(int i) {
        this.f3559d = i;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension((this.f3556a + this.f3557b) + 7, (this.f3556a + this.f3557b) + 7);
    }
}
