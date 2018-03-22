package com.huawei.pluginkidwatch.plugin.feature.newsport.p163a;

import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.ui.p150a.C1499a;
import com.huawei.pluginkidwatch.common.ui.p150a.C1510l;
import java.util.Date;
import java.util.List;

/* compiled from: NewSportViewPagerAdapter */
public abstract class C1804a<T extends View> extends PagerAdapter {
    private List<Date> f4982a;
    public final OnPageChangeListener f4983b = new C1805b(this);
    private C1510l f4984c;
    private Handler f4985d;
    private int f4986e = -1;

    public abstract void mo2599a(T t, Date date);

    public abstract void mo2600a(Date date);

    public abstract T mo2601b(int i);

    public abstract T mo2602b(int i, Date date);

    public C1804a(List<Date> list, C1510l c1510l, Handler handler) {
        this.f4982a = list;
        this.f4984c = c1510l;
        this.f4985d = handler;
    }

    public void m8632a(List<Date> list) {
        this.f4982a = list;
    }

    public int getCount() {
        return this.f4982a.size();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View b;
        C2538c.m12674b("DynamicViewPagerAdapter", "position = " + i);
        Date date = (Date) this.f4982a.get(i);
        View a = this.f4984c.m6983a(i);
        if (a == null) {
            b = mo2602b(i, date);
        } else {
            b = a;
        }
        viewGroup.addView(b);
        return b;
    }

    public void m8635c(int i) {
        C2538c.m12674b("DynamicViewPagerAdapter", "setItemViewByIndex... index = " + i);
        Date date = (Date) this.f4982a.get(i);
        Date a = C1485e.m6852a(date);
        Date b = C1485e.m6860b(date);
        mo2600a(date);
        C2538c.m12674b("DynamicViewPagerAdapter", "setItemViewByIndex...  curDay = " + date);
        C1499a.m6962a(date);
        C2538c.m12674b("DynamicViewPagerAdapter", "setItemViewByIndex...  preDate = " + a);
        C2538c.m12674b("DynamicViewPagerAdapter", "dateList = " + this.f4982a.toString());
        if (i == 0) {
            this.f4982a.add(0, a);
            notifyDataSetChanged();
            this.f4985d.sendEmptyMessageDelayed(2, 100);
            return;
        }
        if (this.f4982a.size() - 1 == i) {
            if (C1485e.m6865c(date)) {
                mo2599a(mo2601b(i - 1), a);
                m8629b(mo2601b(i), date);
                return;
            }
            this.f4982a.add(b);
            notifyDataSetChanged();
        }
        mo2599a(mo2601b(i - 1), a);
        mo2599a(mo2601b(i + 1), b);
        m8629b(mo2601b(i), date);
    }

    private void m8629b(T t, Date date) {
        if (t != null) {
            mo2599a((View) t, date);
            this.f4985d.sendMessageDelayed(this.f4985d.obtainMessage(1, Long.valueOf(date.getTime())), 500);
        }
    }
}
