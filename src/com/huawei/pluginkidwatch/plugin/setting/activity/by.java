package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.huawei.pluginkidwatch.C1617f;

/* compiled from: RewardActivity */
public class by implements OnPageChangeListener {
    final /* synthetic */ RewardActivity f6650a;

    public by(RewardActivity rewardActivity) {
        this.f6650a = rewardActivity;
    }

    public void onPageSelected(int i) {
        switch (i) {
            case 0:
                this.f6650a.f6453E.setVisibility(0);
                this.f6650a.f6454F.setVisibility(4);
                this.f6650a.f6453E.setBackgroundResource(C1617f.kw_img_circle);
                return;
            case 1:
                this.f6650a.f6453E.setVisibility(4);
                this.f6650a.f6454F.setVisibility(0);
                this.f6650a.f6454F.setBackgroundResource(C1617f.kw_img_circle);
                return;
            default:
                return;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageScrollStateChanged(int i) {
    }
}
