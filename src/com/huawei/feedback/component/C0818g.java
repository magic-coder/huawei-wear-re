package com.huawei.feedback.component;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ProgressService */
class C0818g implements OnClickListener {
    final /* synthetic */ ProgressService f1289a;

    C0818g(ProgressService progressService) {
        this.f1289a = progressService;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1289a.f1269m.dismiss();
    }
}
