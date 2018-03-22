package com.tencent.connect.p193b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.tauth.C6252b;

/* compiled from: ProGuard */
class C6271h implements OnCancelListener {
    final /* synthetic */ C6252b f21809a;
    final /* synthetic */ Object f21810b;
    final /* synthetic */ C6267e f21811c;

    C6271h(C6267e c6267e, C6252b c6252b, Object obj) {
        this.f21811c = c6267e;
        this.f21809a = c6252b;
        this.f21810b = obj;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f21809a != null) {
            this.f21809a.mo5288a(this.f21810b);
        }
    }
}
