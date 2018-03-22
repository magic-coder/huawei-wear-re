package com.huawei.bone.root;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.p190v.C2538c;

/* compiled from: SplashActivity */
class ah implements OnClickListener {
    final /* synthetic */ a f23302a;
    final /* synthetic */ SplashActivity f23303b;

    ah(SplashActivity splashActivity, a aVar) {
        this.f23303b = splashActivity;
        this.f23302a = aVar;
    }

    public void onClick(View view) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.setClassName("com.android.settings", "com.android.settings.ManageApplications");
            this.f23303b.f23277e.startActivity(intent);
            this.f23302a.dismiss();
            this.f23303b.finish();
        } catch (Exception e) {
            C2538c.c("SplashActivity", new Object[]{"Exception e = " + e.getMessage()});
        }
    }
}
