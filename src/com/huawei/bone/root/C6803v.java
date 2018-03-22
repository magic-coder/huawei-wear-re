package com.huawei.bone.root;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: ProtocolAndClauseActivity */
class C6803v implements OnClickListener {
    final /* synthetic */ ProtocolAndClauseActivity f23345a;

    C6803v(ProtocolAndClauseActivity protocolAndClauseActivity) {
        this.f23345a = protocolAndClauseActivity;
    }

    public void onClick(View view) {
        C2538c.c("ProtocolAndClauseActivity", new Object[]{"用户不同意协议与条款，退出App!"});
        this.f23345a.f23246m.a(false);
        this.f23345a.finish();
    }
}
