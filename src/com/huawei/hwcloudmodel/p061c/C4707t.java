package com.huawei.hwcloudmodel.p061c;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;

/* compiled from: NSPClient */
class C4707t implements IBaseResponseCallback {
    final /* synthetic */ C4706s f17156a;

    C4707t(C4706s c4706s) {
        this.f17156a = c4706s;
    }

    public void onResponse(int i, Object obj) {
        if (this.f17156a.m22523a(this.f17156a.f17154d)) {
            C2538c.c("NSPClient", new Object[]{"jump to 1.5 login"});
            this.f17156a.m22526b();
            return;
        }
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(BaseApplication.b());
        if (instance != null) {
            C2538c.c("NSPClient", new Object[]{"Enter logout  --> close "});
            Intent intent = new Intent();
            intent.setAction(BaseActivity.CLEAN_ACTIVITY);
            instance.sendBroadcast(intent);
        }
    }
}
