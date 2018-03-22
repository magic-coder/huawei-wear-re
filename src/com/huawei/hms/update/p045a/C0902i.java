package com.huawei.hms.update.p045a;

import android.content.Context;
import com.huawei.hms.p039c.C0852a;
import com.huawei.hms.update.p045a.p046a.C0890a;
import com.huawei.hms.update.p045a.p046a.C0891b;
import com.huawei.hms.update.p045a.p046a.C0892c;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: ThreadWrapper */
public class C0902i implements C0890a {
    private static final Executor f1483b = Executors.newSingleThreadExecutor();
    private final C0890a f1484a;

    public C0902i(C0890a c0890a) {
        C0852a.m3001a(c0890a, "update must not be null.");
        this.f1484a = c0890a;
    }

    public Context mo2264a() {
        return this.f1484a.mo2264a();
    }

    public void mo2267b() {
        this.f1484a.mo2267b();
    }

    public void mo2265a(C0891b c0891b) {
        f1483b.execute(new C0903j(this, c0891b));
    }

    public void mo2266a(C0891b c0891b, C0892c c0892c) {
        f1483b.execute(new C0904k(this, c0891b, c0892c));
    }

    private static C0891b m3166c(C0891b c0891b) {
        return new C0905l(c0891b);
    }
}
