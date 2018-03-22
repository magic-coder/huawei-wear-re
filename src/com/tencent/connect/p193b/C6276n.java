package com.tencent.connect.p193b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.open.web.security.JniInterface;

/* compiled from: ProGuard */
class C6276n implements OnDismissListener {
    final /* synthetic */ C6273k f21837a;

    C6276n(C6273k c6273k) {
        this.f21837a = c6273k;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e) {
        }
    }
}
