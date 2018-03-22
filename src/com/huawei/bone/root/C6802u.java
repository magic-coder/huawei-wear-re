package com.huawei.bone.root;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.q.a.a;
import com.huawei.p190v.C2538c;

/* compiled from: ProtocolAndClauseActivity */
class C6802u implements OnClickListener {
    final /* synthetic */ ProtocolAndClauseActivity f23344a;

    C6802u(ProtocolAndClauseActivity protocolAndClauseActivity) {
        this.f23344a = protocolAndClauseActivity;
    }

    public void onClick(View view) {
        C2538c.c("ProtocolAndClauseActivity", new Object[]{"用户点击同意协议与条款."});
        this.f23344a.f23246m.a(true);
        a.a(this.f23344a.f23246m.c());
        this.f23344a.f23248o = new Intent().getBooleanExtra("haveDevice", false);
        C2538c.c("ProtocolAndClauseActivity", new Object[]{"have connected device is : " + this.f23344a.f23248o});
        Intent intent = new Intent();
        intent.setClass(BaseApplication.b(), SplashActivity.class);
        this.f23344a.startActivity(intent);
        this.f23344a.finish();
    }
}
