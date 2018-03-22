package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;

/* compiled from: ContactsListActivity */
public class cu extends PagerAdapter {
    public List<View> f6015a;

    public cu(List<View> list) {
        this.f6015a = list;
    }

    public void destroyItem(View view, int i, Object obj) {
        if (view instanceof ViewPager) {
            ((ViewPager) view).removeView((View) this.f6015a.get(i));
        }
    }

    public void finishUpdate(View view) {
    }

    public int getCount() {
        return this.f6015a.size();
    }

    public Object instantiateItem(View view, int i) {
        if (view instanceof ViewPager) {
            ((ViewPager) view).addView((View) this.f6015a.get(i), 0);
        }
        return this.f6015a.get(i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void startUpdate(View view) {
    }
}
