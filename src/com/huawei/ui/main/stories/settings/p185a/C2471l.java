package com.huawei.ui.main.stories.settings.p185a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: UserProfileSettingsInteractors */
class C2471l implements OnClickListener {
    final /* synthetic */ C2465f f8879a;

    C2471l(C2465f c2465f) {
        this.f8879a = c2465f;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12677c("UserProfileSettingsInteractors", "同意更改height");
        C2538c.m12677c("UserProfileSettingsInteractors", "high type:" + this.f8879a.f8854h.getThirdPickerValue());
        this.f8879a.f8860n.sendEmptyMessage(7);
        this.f8879a.m12309c(r0);
    }
}
