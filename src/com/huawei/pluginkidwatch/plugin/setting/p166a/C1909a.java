package com.huawei.pluginkidwatch.plugin.setting.p166a;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;

/* compiled from: ViewPagerAdapter */
public class C1909a extends PagerAdapter {
    public List<View> f6251a;

    public C1909a(List<View> list) {
        this.f6251a = list;
    }

    public void destroyItem(View view, int i, Object obj) {
        if (view instanceof ViewPager) {
            ((ViewPager) view).removeView((View) this.f6251a.get(i));
        }
    }

    public void finishUpdate(View view) {
    }

    public int getCount() {
        return this.f6251a.size();
    }

    public Object instantiateItem(View view, int i) {
        if (!(view instanceof ViewPager)) {
            return null;
        }
        ((ViewPager) view).addView((View) this.f6251a.get(i));
        return this.f6251a.get(i);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void startUpdate(View view) {
    }
}
