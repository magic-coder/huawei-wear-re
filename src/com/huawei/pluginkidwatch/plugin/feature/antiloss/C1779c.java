package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: AntilossActivity */
class C1779c implements OnCancelListener {
    final /* synthetic */ AntilossActivity f4928a;

    C1779c(AntilossActivity antilossActivity) {
        this.f4928a = antilossActivity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f4928a.f4903v.m8587a(true);
        this.f4928a.f4904w.m8292c(9);
        this.f4928a.finish();
    }
}
