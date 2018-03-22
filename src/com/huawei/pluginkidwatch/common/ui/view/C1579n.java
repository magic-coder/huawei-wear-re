package com.huawei.pluginkidwatch.common.ui.view;

import android.view.View;
import com.huawei.pluginkidwatch.common.ui.p150a.C1509k;
import java.util.Date;
import java.util.List;

/* compiled from: CalendarViewPager */
class C1579n extends C1578p<C1575k> {
    final /* synthetic */ C1509k f3913a;
    final /* synthetic */ CalendarViewPager f3914b;

    C1579n(CalendarViewPager calendarViewPager, List list, C1509k c1509k) {
        this.f3914b = calendarViewPager;
        this.f3913a = c1509k;
        super(calendarViewPager, list);
    }

    public /* synthetic */ View mo2548b(int i) {
        return m7280a(i);
    }

    public /* synthetic */ View mo2549b(int i, Date date) {
        return m7281a(i, date);
    }

    public C1575k m7281a(int i, Date date) {
        View c1575k = new C1575k(this.f3914b.getContext(), this.f3913a);
        this.f3914b.f3790c.m6984a(i, c1575k);
        c1575k.m7263a(date, null);
        return c1575k;
    }

    public C1575k m7280a(int i) {
        if (this.f3914b.f3790c == null) {
            return null;
        }
        View a = this.f3914b.f3790c.m6983a(i);
        if (a == null) {
            return null;
        }
        return a instanceof C1575k ? (C1575k) a : null;
    }

    public void mo2547a(Date date) {
        if (this.f3914b.f3788a != null) {
            this.f3914b.f3788a.mo2516a(date);
        }
    }

    public void m7283a(C1575k c1575k, Date date) {
        if (c1575k != null) {
            c1575k.m7266b(date, null);
        }
    }
}
