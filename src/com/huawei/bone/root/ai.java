package com.huawei.bone.root;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.a;

/* compiled from: SplashActivity */
class ai implements OnClickListener {
    final /* synthetic */ a f23304a;
    final /* synthetic */ SplashActivity f23305b;

    ai(SplashActivity splashActivity, a aVar) {
        this.f23305b = splashActivity;
        this.f23304a = aVar;
    }

    public void onClick(View view) {
        C2538c.c("SplashActivity", new Object[]{"showHwIdStopedDialog cancel"});
        this.f23304a.dismiss();
        this.f23305b.finish();
    }
}
