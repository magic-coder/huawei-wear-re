package com.huawei.hms.p038b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

/* compiled from: AbstractDialog */
class C0851e implements OnKeyListener {
    final /* synthetic */ C0837a f1349a;

    C0851e(C0837a c0837a) {
        this.f1349a = c0837a;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (4 != i || keyEvent.getAction() != 1) {
            return false;
        }
        this.f1349a.m2956a();
        return true;
    }
}
