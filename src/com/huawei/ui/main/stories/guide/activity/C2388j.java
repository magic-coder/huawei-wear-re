package com.huawei.ui.main.stories.guide.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2388j implements OnItemClickListener {
    final /* synthetic */ BasicInfoSettingActivity f8651a;

    C2388j(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8651a = basicInfoSettingActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f8651a.f8620z = i;
        C2538c.m12677c("BasicInfoSettingActivity", "Gender dialog position" + i);
        this.f8651a.m12026F();
        this.f8651a.m12025E();
    }
}
