package com.tencent.connect.p193b;

import android.app.Dialog;
import android.view.View;
import com.tencent.tauth.C6252b;

/* compiled from: ProGuard */
class C6270g extends C6268i {
    final /* synthetic */ C6252b f21806a;
    final /* synthetic */ Object f21807b;
    final /* synthetic */ C6267e f21808c;

    C6270g(C6267e c6267e, Dialog dialog, C6252b c6252b, Object obj) {
        this.f21808c = c6267e;
        this.f21806a = c6252b;
        this.f21807b = obj;
        super(c6267e, dialog);
    }

    public void onClick(View view) {
        if (this.d != null && this.d.isShowing()) {
            this.d.dismiss();
        }
        if (this.f21806a != null) {
            this.f21806a.mo5288a(this.f21807b);
        }
    }
}
