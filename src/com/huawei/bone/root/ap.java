package com.huawei.bone.root;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.p190v.C2538c;

/* compiled from: SplashActivity */
class ap implements OnClickListener {
    final /* synthetic */ IBaseResponseCallback f23316a;
    final /* synthetic */ a f23317b;
    final /* synthetic */ SplashActivity f23318c;

    ap(SplashActivity splashActivity, IBaseResponseCallback iBaseResponseCallback, a aVar) {
        this.f23318c = splashActivity;
        this.f23316a = iBaseResponseCallback;
        this.f23317b = aVar;
    }

    public void onClick(View view) {
        C2538c.c("SplashActivity", new Object[]{"cancel click"});
        this.f23316a.onResponse(2, "");
        this.f23317b.dismiss();
    }
}
