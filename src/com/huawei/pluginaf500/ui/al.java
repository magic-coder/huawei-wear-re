package com.huawei.pluginaf500.ui;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import com.huawei.pluginaf500.d;

/* compiled from: HelpActivity */
public class al implements OnPageChangeListener {
    final /* synthetic */ HelpActivity f19887a;

    public al(HelpActivity helpActivity) {
        this.f19887a = helpActivity;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        for (int findViewById : this.f19887a.f19755s) {
            ((ImageView) this.f19887a.findViewById(findViewById)).setImageDrawable(this.f19887a.getResources().getDrawable(d.point_unsel));
        }
        ((ImageView) this.f19887a.findViewById(this.f19887a.f19755s[i])).setImageDrawable(this.f19887a.getResources().getDrawable(d.point_sel));
    }
}
