package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.d;

/* compiled from: ProfileSettingActivity */
class bf implements OnClickListener {
    final /* synthetic */ ImageView f6623a;
    final /* synthetic */ TextView f6624b;
    final /* synthetic */ ImageView f6625c;
    final /* synthetic */ TextView f6626d;
    final /* synthetic */ ProfileSettingActivity f6627e;

    bf(ProfileSettingActivity profileSettingActivity, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2) {
        this.f6627e = profileSettingActivity;
        this.f6623a = imageView;
        this.f6624b = textView;
        this.f6625c = imageView2;
        this.f6626d = textView2;
    }

    public void onClick(View view) {
        this.f6623a.setImageResource(C1617f.kw_btn_male_1);
        this.f6624b.setTextColor(this.f6627e.getResources().getColor(d.setting_profile_tv_not_selected));
        this.f6625c.setImageResource(C1617f.kw_btn_famale_2_2);
        this.f6626d.setTextColor(this.f6627e.getResources().getColor(d.setting_profile_tv_girl));
        this.f6627e.f6370B = 1;
    }
}
