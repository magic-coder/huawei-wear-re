package com.tencent.connect.p193b;

import android.app.Dialog;
import android.view.View;
import com.tencent.tauth.C6252b;

/* compiled from: ProGuard */
class C6269f extends C6268i {
    final /* synthetic */ C6252b f21803a;
    final /* synthetic */ Object f21804b;
    final /* synthetic */ C6267e f21805c;

    C6269f(C6267e c6267e, Dialog dialog, C6252b c6252b, Object obj) {
        this.f21805c = c6267e;
        this.f21803a = c6252b;
        this.f21804b = obj;
        super(c6267e, dialog);
    }

    public void onClick(View view) {
        this.f21805c.m28798b();
        if (this.d != null && this.d.isShowing()) {
            this.d.dismiss();
        }
        if (this.f21803a != null) {
            this.f21803a.mo5288a(this.f21804b);
        }
    }
}
