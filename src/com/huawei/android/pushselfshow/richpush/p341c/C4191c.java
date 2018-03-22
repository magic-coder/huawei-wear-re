package com.huawei.android.pushselfshow.richpush.p341c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.huawei.android.pushagent.c.a.e;

class C4191c implements OnDismissListener {
    final /* synthetic */ Activity f15791a;
    final /* synthetic */ C4179a f15792b;

    C4191c(C4179a c4179a, Activity activity) {
        this.f15792b = c4179a;
        this.f15791a = activity;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        e.a("PushSelfShowLog", "DialogInterface onDismiss,mClickDialogOkBtn:" + this.f15792b.f15732m);
        if (this.f15792b.f15732m) {
            this.f15792b.m20358b(this.f15791a);
            return;
        }
        this.f15792b.f15730k.m20380a(this.f15792b.f15729j);
        this.f15792b.f15735p = false;
    }
}
