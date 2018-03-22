package com.huawei.pluginkidwatch.common.ui.view;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.pluginkidwatch.common.ui.p150a.C1505f;
import java.util.Date;
import java.util.List;

/* compiled from: CalendarViewPager */
abstract class C1578p<T extends View> extends PagerAdapter {
    public List<Date> f3910c;
    public final OnPageChangeListener f3911d = new C1581q(this);
    final /* synthetic */ CalendarViewPager f3912e;

    public abstract void mo2546a(T t, Date date);

    public abstract void mo2547a(Date date);

    public abstract T mo2548b(int i);

    public abstract T mo2549b(int i, Date date);

    public C1578p(CalendarViewPager calendarViewPager, List<Date> list) {
        this.f3912e = calendarViewPager;
        this.f3910c = list;
    }

    public int getCount() {
        return this.f3910c.size();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View b;
        Date date = (Date) this.f3910c.get(i);
        View a = this.f3912e.f3790c.m6983a(i);
        if (a == null) {
            b = mo2549b(i, date);
        } else {
            b = a;
        }
        viewGroup.addView(b);
        return b;
    }

    public void m7279c(int i) {
        Date date = (Date) this.f3910c.get(i);
        Date b = C1505f.m6969a().m6973b(date, -1);
        Date b2 = C1505f.m6969a().m6973b(date, 1);
        mo2547a(date);
        if (i == 0) {
            this.f3910c.add(0, b);
            notifyDataSetChanged();
            this.f3912e.f3791d.sendEmptyMessageDelayed(1, 100);
            return;
        }
        View b3;
        if (this.f3910c.size() - 1 == i) {
            if (C1505f.m6969a().m6972b(date).after(new Date())) {
                View b4 = mo2548b(i - 1);
                if (b4 != null) {
                    mo2546a(b4, b);
                }
                b3 = mo2548b(i);
                if (b3 != null) {
                    mo2546a(b3, date);
                    return;
                }
                return;
            }
            this.f3910c.add(b2);
            notifyDataSetChanged();
        }
        View b5 = mo2548b(i - 1);
        if (b5 != null) {
            mo2546a(b5, b);
        }
        b3 = mo2548b(i + 1);
        if (b3 != null) {
            mo2546a(b3, b2);
        }
        b3 = mo2548b(i);
        if (b3 != null) {
            mo2546a(b3, date);
        }
    }
}
