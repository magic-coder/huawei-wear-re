package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.p150a.C1499a;
import com.huawei.pluginkidwatch.common.ui.p150a.C1509k;
import java.util.Date;
import java.util.List;

/* compiled from: CalendarView */
public class C1575k extends View implements OnTouchListener {
    public C1577m f3882a;
    private C1509k f3883b;
    private C1576l f3884c;
    private Context f3885d;

    public C1575k(Context context, C1509k c1509k) {
        super(context);
        this.f3885d = context;
        this.f3883b = c1509k;
    }

    public void m7263a(Date date, List<Date> list) {
        this.f3884c = new C1576l();
        this.f3884c.f3886a = getResources().getDisplayMetrics().density;
        this.f3882a = new C1577m(date, list);
        setOnTouchListener(this);
    }

    public void m7266b(Date date, List<Date> list) {
        this.f3882a = new C1577m(date, list);
        invalidate();
    }

    public boolean m7264a() {
        return (this.f3884c == null || this.f3882a == null) ? false : true;
    }

    protected void onMeasure(int i, int i2) {
        if (m7264a()) {
            this.f3884c.f3887b = C1492l.m6901a(this.f3885d, this.f3884c.f3890e) * this.f3884c.f3894i;
            this.f3884c.f3888c = C1492l.m6901a(this.f3885d, this.f3884c.f3891f) * this.f3884c.f3893h;
            i = MeasureSpec.makeMeasureSpec(this.f3884c.f3887b, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(this.f3884c.f3888c, 1073741824);
            setMeasuredDimension(i, i2);
            C2538c.m12674b("calendarSurface.density = " + this.f3884c.f3886a, new Object[0]);
        }
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && m7264a()) {
            this.f3884c.m7269a();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        if (m7264a()) {
            m7261a(canvas);
        }
        super.onDraw(canvas);
    }

    public void m7261a(Canvas canvas) {
        List list = this.f3882a.f3909d;
        for (int i = 0; i < list.size(); i++) {
            m7262a(canvas, (Date) list.get(i), i);
        }
    }

    public void m7260a(float f, float f2) {
        if (f2 > 0.0f) {
            int b = m7265b(f, f2);
            if (b < this.f3882a.f3909d.size()) {
                Date date = (Date) this.f3882a.f3909d.get(b);
                if (date != null && date.before(new Date())) {
                    this.f3883b.mo2603a(date);
                }
            }
        }
    }

    public int m7265b(float f, float f2) {
        return (((int) (f2 / this.f3884c.f3892g)) * this.f3884c.f3894i) + ((int) (f / this.f3884c.f3889d));
    }

    public void m7262a(Canvas canvas, Date date, int i) {
        if (date != null) {
            float f;
            int i2 = i % this.f3884c.f3894i;
            int i3 = i / this.f3884c.f3894i;
            Object obj = null;
            String a = C1485e.m6849a(date, "yyyyMMdd");
            String a2 = C1485e.m6849a(C1499a.m6961a(), "yyyyMMdd");
            if (a.equals(C1485e.m6849a(new Date(), "yyyyMMdd"))) {
                float f2 = (((float) i2) * this.f3884c.f3889d) + (this.f3884c.f3889d / 2.0f);
                float f3 = (((float) (i3 + 1)) * this.f3884c.f3892g) - (this.f3884c.f3892g / 2.0f);
                this.f3884c.f3899n.setStyle(Style.STROKE);
                canvas.drawCircle(f2, f3, this.f3884c.f3889d / 3.0f, this.f3884c.f3899n);
            }
            if (a.equals(a2)) {
                float f4 = (((float) i2) * this.f3884c.f3889d) + (this.f3884c.f3889d / 2.0f);
                f = (((float) (i3 + 1)) * this.f3884c.f3892g) - (this.f3884c.f3892g / 2.0f);
                this.f3884c.f3899n.setStyle(Style.FILL);
                canvas.drawCircle(f4, f, this.f3884c.f3889d / 3.0f, this.f3884c.f3899n);
                obj = 1;
            }
            if (obj != null) {
                this.f3884c.f3895j.setColor(this.f3884c.f3898m);
            } else if (this.f3882a.m7274b(date)) {
                this.f3884c.f3895j.setColor(this.f3884c.f3897l);
            } else {
                this.f3884c.f3895j.setColor(this.f3884c.f3896k);
            }
            f = this.f3884c.m7267a(i2);
            float b = this.f3884c.m7270b(i3);
            canvas.drawText(String.valueOf(date.getDate()), f, b, this.f3884c.f3895j);
            if (this.f3882a.m7273a(date)) {
                float f5 = (((float) i2) * this.f3884c.f3889d) + (this.f3884c.f3889d / 2.0f);
                b = (b + (((float) this.f3884c.f3905t) / 2.0f)) + ((float) this.f3884c.f3904s);
                if (obj != null) {
                    this.f3884c.f3901p.setColor(this.f3884c.f3903r);
                } else {
                    this.f3884c.f3901p.setColor(this.f3884c.f3902q);
                }
                canvas.drawCircle(f5, b, (float) this.f3884c.f3905t, this.f3884c.f3901p);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                if (m7264a()) {
                    m7260a(motionEvent.getX(), motionEvent.getY());
                    break;
                }
                break;
        }
        return true;
    }
}
