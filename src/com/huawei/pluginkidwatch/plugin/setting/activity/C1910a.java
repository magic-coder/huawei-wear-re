package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: AppHelpActivity */
class C1910a implements OnClickListener {
    final /* synthetic */ AppHelpActivity f6580a;

    C1910a(AppHelpActivity appHelpActivity) {
        this.f6580a = appHelpActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            C2538c.m12674b("AppHelpActivity", "onKeyDown ", " DialogInterface.BUTTON_POSITIVE" + i);
            this.f6580a.f6255e.cancel();
            this.f6580a.m9728n();
        } else if (i == -2) {
            C2538c.m12674b("AppHelpActivity", "onKeyDown ", "DialogInterface.BUTTON_POSITIVE" + i);
            this.f6580a.f6255e.cancel();
            this.f6580a.finish();
        }
    }
}
