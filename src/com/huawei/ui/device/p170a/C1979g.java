package com.huawei.ui.device.p170a;

import android.content.Context;
import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.c.a;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;

/* compiled from: CompatibilityInteractor */
class C1979g implements Runnable {
    final /* synthetic */ int f6913a;
    final /* synthetic */ Context f6914b;
    final /* synthetic */ IBaseResponseCallback f6915c;
    final /* synthetic */ a f6916d;
    final /* synthetic */ C1975c f6917e;

    C1979g(C1975c c1975c, int i, Context context, IBaseResponseCallback iBaseResponseCallback, a aVar) {
        this.f6917e = c1975c;
        this.f6913a = i;
        this.f6914b = context;
        this.f6915c = iBaseResponseCallback;
        this.f6916d = aVar;
    }

    public void run() {
        boolean z = true;
        if (C0969i.m3482a(60)) {
            if (10 != this.f6913a) {
                boolean z2;
                C2538c.m12677c("CompatibilityInteractor", "isSupportInHealth typeSupport:" + this.f6917e.m10377a(this.f6913a));
                String a = C0996a.m3612a(this.f6914b, String.valueOf(10000), "health_support_note_migrate_");
                String a2 = C0996a.m3612a(this.f6914b, String.valueOf(10000), "health_support_force_migrate_");
                if ("true".equalsIgnoreCase(a) || "true".equalsIgnoreCase(a2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                C2538c.m12677c("CompatibilityInteractor", "isSupportInHealth isCloudNoteSupport:" + a + " isCloudForceSupport:" + a2 + " cloudSupport:" + z2);
                C2538c.m12677c("CompatibilityInteractor", "isSupportInHealth isLocalHealthVersionSupport:" + C1975c.m10369a(BaseApplication.m2632b()));
                if (!(z2 && r3 && r4)) {
                    z = false;
                }
            } else {
                z = false;
            }
            this.f6915c.onResponse(0, Boolean.valueOf(z));
            return;
        }
        C2538c.m12677c("CompatibilityInteractor", "isSupportInHealth oversea");
        if (10 == this.f6913a) {
            this.f6915c.onResponse(0, Boolean.valueOf(false));
        } else if (this.f6917e.m10377a(this.f6913a)) {
            Message message = new Message();
            message.what = 102;
            message.obj = this.f6915c;
            this.f6916d.sendMessageDelayed(message, 500);
            C1988p.m10381a(BaseApplication.m2632b()).m10385a(2, new C1980h(this));
        } else {
            C2538c.m12677c("CompatibilityInteractor", "isSupportInHealth not support type");
            this.f6915c.onResponse(0, Boolean.valueOf(false));
        }
    }
}
