package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: KidWatchProtocolAndClauseActivity */
class ak implements OnClickListener {
    final /* synthetic */ KidWatchProtocolAndClauseActivity f6594a;

    ak(KidWatchProtocolAndClauseActivity kidWatchProtocolAndClauseActivity) {
        this.f6594a = kidWatchProtocolAndClauseActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("KidWatchProtocolAndClauseActivity", "用户点击同意协议与条款.");
        this.f6594a.m9861d();
        this.f6594a.finish();
    }
}
