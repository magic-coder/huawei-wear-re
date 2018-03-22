package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.d;

/* compiled from: ProfileSettingActivity */
class be implements OnClickListener {
    final /* synthetic */ ImageView f6618a;
    final /* synthetic */ TextView f6619b;
    final /* synthetic */ ImageView f6620c;
    final /* synthetic */ TextView f6621d;
    final /* synthetic */ ProfileSettingActivity f6622e;

    be(ProfileSettingActivity profileSettingActivity, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2) {
        this.f6622e = profileSettingActivity;
        this.f6618a = imageView;
        this.f6619b = textView;
        this.f6620c = imageView2;
        this.f6621d = textView2;
    }

    public void onClick(View view) {
        this.f6618a.setImageResource(C1617f.kw_btn_male_1_2);
        this.f6619b.setTextColor(this.f6622e.getResources().getColor(d.setting_profile_tv_boy));
        this.f6620c.setImageResource(C1617f.kw_btn_famale_2_1);
        this.f6621d.setTextColor(this.f6622e.getResources().getColor(d.setting_profile_tv_not_selected));
        this.f6622e.f6370B = 2;
    }
}
