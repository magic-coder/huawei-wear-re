package com.huawei.ui.device.activity.update;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.p170a.ah;

/* compiled from: UpdateVersionActivity */
class C2176j implements OnClickListener {
    final /* synthetic */ UpdateVersionActivity f7756a;

    C2176j(UpdateVersionActivity updateVersionActivity) {
        this.f7756a = updateVersionActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("UpdateVersionActivity", "start showExitUpdateDialog, user click Negative button! ");
        int i = this.f7756a.f7742v.f6876k;
        this.f7756a.f7742v;
        if (i == 3) {
            this.f7756a.f7742v.m10340g();
            ah c = this.f7756a.f7742v;
            this.f7756a.f7742v;
            c.f6876k = 0;
            C2538c.m12677c("UpdateVersionActivity", "start showExitUpdateDialog,cancle downloading  file!");
        }
        this.f7756a.f7716D.dismiss();
        this.f7756a.f7716D = null;
        this.f7756a.finish();
    }
}
