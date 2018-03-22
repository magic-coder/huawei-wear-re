package com.huawei.hwid.openapi.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class C5219f implements OnCancelListener {
    final /* synthetic */ C5218e f18834a;

    C5219f(C5218e c5218e) {
        this.f18834a = c5218e;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f18834a.onBackPressed();
    }
}
