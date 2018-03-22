package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;

/* compiled from: ProGuard */
public class C6259l extends View {
    private Rect f21768a;
    private Paint f21769b;

    public C6259l(Context context) {
        super(context);
        m28767b();
    }

    private void m28767b() {
        this.f21769b = new Paint();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect a = m28768a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f21769b.setStyle(Style.FILL);
        this.f21769b.setColor(Color.argb(100, 0, 0, 0));
        canvas.drawRect(0.0f, 0.0f, (float) measuredWidth, (float) a.top, this.f21769b);
        canvas.drawRect(0.0f, (float) a.bottom, (float) measuredWidth, (float) measuredHeight, this.f21769b);
        canvas.drawRect(0.0f, (float) a.top, (float) a.left, (float) a.bottom, this.f21769b);
        canvas.drawRect((float) a.right, (float) a.top, (float) measuredWidth, (float) a.bottom, this.f21769b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.f21769b.setStyle(Style.STROKE);
        this.f21769b.setColor(-1);
        canvas.drawRect((float) a.left, (float) a.top, (float) (a.right - 1), (float) a.bottom, this.f21769b);
    }

    public Rect m28768a() {
        if (this.f21768a == null) {
            this.f21768a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), 640);
            measuredWidth = (measuredWidth - min) / 2;
            measuredHeight = (measuredHeight - min) / 2;
            this.f21768a.set(measuredWidth, measuredHeight, measuredWidth + min, min + measuredHeight);
        }
        return this.f21768a;
    }
}
