package com.huawei.pluginkidwatch.common.ui.view;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import com.huawei.nfc.carrera.server.card.response.CardStatusQueryResponse;

/* compiled from: CalendarView */
class C1576l {
    public float f3886a;
    public int f3887b;
    public int f3888c;
    public float f3889d;
    public float f3890e = 40.0f;
    public float f3891f = 38.0f;
    public float f3892g;
    public int f3893h = 6;
    public int f3894i = 7;
    public Paint f3895j;
    public int f3896k = Color.parseColor("#D8000000");
    public int f3897l = Color.parseColor("#66000000");
    public int f3898m = Color.parseColor("#ffffff");
    public Paint f3899n;
    public int f3900o = Color.parseColor("#3fc0c5");
    public Paint f3901p;
    public int f3902q = Color.parseColor("#3fc0c5");
    public int f3903r = Color.parseColor("#ffffff");
    public int f3904s = 4;
    public int f3905t = 4;

    public C1576l() {
        m7269a();
    }

    public void m7269a() {
        this.f3892g = ((float) this.f3888c) / ((float) this.f3893h);
        this.f3889d = ((float) this.f3887b) / ((float) this.f3894i);
        this.f3895j = new Paint();
        this.f3895j.setColor(this.f3896k);
        this.f3895j.setAntiAlias(true);
        this.f3895j.setTextSize(this.f3892g * 0.4f);
        this.f3895j.setTextAlign(Align.CENTER);
        this.f3899n = new Paint();
        this.f3899n.setColor(this.f3900o);
        this.f3899n.setAntiAlias(true);
        this.f3901p = new Paint();
        this.f3901p.setColor(this.f3902q);
        this.f3901p.setAntiAlias(true);
    }

    public float m7268a(int i, Paint paint) {
        return (((float) i) * this.f3889d) + (this.f3889d / 2.0f);
    }

    public float m7267a(int i) {
        return m7268a(i, this.f3895j);
    }

    public float m7271b(int i, Paint paint) {
        return ((((float) i) * this.f3892g) + (this.f3892g / 2.0f)) + (paint.measureText(CardStatusQueryResponse.DEV_STATUS_LOCK) / 2.0f);
    }

    public float m7270b(int i) {
        return m7271b(i, this.f3895j);
    }
}
