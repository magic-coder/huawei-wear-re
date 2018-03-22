package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: AntilossActivity */
class C1778b implements OnClickListener {
    final /* synthetic */ AntilossActivity f4927a;

    C1778b(AntilossActivity antilossActivity) {
        this.f4927a = antilossActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4927a.f4903v.m8587a(true);
        this.f4927a.f4904w.m8292c(9);
        this.f4927a.f4907z.dismiss();
        this.f4927a.finish();
    }
}
