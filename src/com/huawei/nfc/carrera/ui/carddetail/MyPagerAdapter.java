package com.huawei.nfc.carrera.ui.carddetail;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    public List<View> listviews;

    public MyPagerAdapter(List<View> list) {
        this.listviews = list;
    }

    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) this.listviews.get(i));
    }

    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView((View) this.listviews.get(i), 0);
        return this.listviews.get(i);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return super.instantiateItem(viewGroup, i);
    }

    public int getCount() {
        return this.listviews.size();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
