package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: KidWatchProtocolAndClauseActivity */
class al implements OnClickListener {
    final /* synthetic */ KidWatchProtocolAndClauseActivity f6595a;

    al(KidWatchProtocolAndClauseActivity kidWatchProtocolAndClauseActivity) {
        this.f6595a = kidWatchProtocolAndClauseActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("KidWatchProtocolAndClauseActivity", "用户不同意协议与条款");
        this.f6595a.finish();
    }
}
