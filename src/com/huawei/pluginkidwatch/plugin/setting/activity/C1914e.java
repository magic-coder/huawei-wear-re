package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: BindbyQrActivity */
class C1914e implements OnClickListener {
    final /* synthetic */ BindbyQrActivity f6678a;

    C1914e(BindbyQrActivity bindbyQrActivity) {
        this.f6678a = bindbyQrActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b(this.f6678a.f6266b, "======gotoIntroduceListener");
        Intent intent = new Intent();
        intent.setClass(this.f6678a.f6284t, IntroduceQrActivity.class);
        this.f6678a.startActivity(intent);
    }
}
