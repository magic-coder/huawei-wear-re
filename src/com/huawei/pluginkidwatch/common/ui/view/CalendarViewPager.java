package com.huawei.pluginkidwatch.common.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import com.huawei.pluginkidwatch.common.ui.p150a.C1501j;
import com.huawei.pluginkidwatch.common.ui.p150a.C1505f;
import com.huawei.pluginkidwatch.common.ui.p150a.C1509k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1510l;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalendarViewPager extends ViewPager {
    public C1501j f3788a;
    public List<Date> f3789b = new ArrayList();
    private C1510l f3790c;
    @SuppressLint({"HandlerLeak"})
    private Handler f3791d = new C1580o(this);

    public void setmMonthChangedListener(C1501j c1501j) {
        this.f3788a = c1501j;
    }

    public CalendarViewPager(Context context) {
        super(context);
    }

    public CalendarViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void m7193a(Date date, C1509k c1509k) {
        this.f3790c = new C1510l();
        Date b = C1505f.m6969a().m6973b(date, -1);
        this.f3789b.add(date);
        this.f3789b.add(0, b);
        PagerAdapter a = m7191a(c1509k);
        setAdapter(a);
        setOnPageChangeListener(a.f3911d);
        setCurrentItem(1);
    }

    @NonNull
    private C1578p<C1575k> m7191a(C1509k c1509k) {
        return new C1579n(this, this.f3789b, c1509k);
    }
}
