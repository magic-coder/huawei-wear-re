package com.huawei.pluginaf500.ui;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;

/* compiled from: HelpActivity */
class an extends PagerAdapter {
    private int f19889a = 0;
    private List<View> f19890b;
    private int f19891c;

    public an(List<View> list) {
        int i = 0;
        this.f19890b = list;
        if (list != null) {
            i = list.size();
        }
        this.f19891c = i;
    }

    public int getCount() {
        return this.f19891c;
    }

    public void destroyItem(View view, int i, Object obj) {
        if (view instanceof ViewPager) {
            ((ViewPager) view).removeView((View) this.f19890b.get(i));
        }
    }

    public int getItemPosition(Object obj) {
        if (this.f19889a <= 0) {
            return super.getItemPosition(obj);
        }
        this.f19889a--;
        return -2;
    }

    public void notifyDataSetChanged() {
        this.f19889a = getCount();
        super.notifyDataSetChanged();
    }

    public void finishUpdate(View view) {
    }

    public Object instantiateItem(View view, int i) {
        try {
            if (view instanceof ViewPager) {
                ((ViewPager) view).addView((View) this.f19890b.get(i), 0);
            }
        } catch (IllegalArgumentException e) {
        }
        return this.f19890b.get(i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
