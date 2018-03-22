package com.huawei.hms.api.internal;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.hms.support.log.C0887a;

/* compiled from: BindingFailedResolution */
class C0841b implements Callback {
    final /* synthetic */ C0840a f1338a;

    C0841b(C0840a c0840a) {
        this.f1338a = c0840a;
    }

    public boolean handleMessage(Message message) {
        if (message == null || message.what != 2) {
            return false;
        }
        C0887a.m3098d("BindingFailedResolution", "In connect, bind core try timeout");
        this.f1338a.m2975b(false);
        return true;
    }
}
