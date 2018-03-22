package com.huawei.hms.update.p045a;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.update.p045a.p046a.C0891b;
import com.huawei.hms.update.p045a.p046a.C0892c;
import java.io.File;

/* compiled from: ThreadWrapper */
final class C0905l implements C0891b {
    final /* synthetic */ C0891b f1490a;

    C0905l(C0891b c0891b) {
        this.f1490a = c0891b;
    }

    public void mo2270a(int i, C0892c c0892c) {
        new Handler(Looper.getMainLooper()).post(new C0906m(this, i, c0892c));
    }

    public void mo2269a(int i, int i2, int i3, File file) {
        new Handler(Looper.getMainLooper()).post(new C0907n(this, i, i2, i3, file));
    }
}
