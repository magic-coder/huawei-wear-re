package com.huawei.pluginkidwatch.plugin.feature.newsport.p163a;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.huawei.p190v.C2538c;

/* compiled from: NewSportViewPagerAdapter */
class C1805b implements OnPageChangeListener {
    final /* synthetic */ C1804a f4987a;

    C1805b(C1804a c1804a) {
        this.f4987a = c1804a;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        C2538c.m12674b("DynamicViewPagerAdapter", "onPageSelected... arg0 = " + i);
        this.f4987a.m8635c(i);
        this.f4987a.f4986e = i;
    }
}
