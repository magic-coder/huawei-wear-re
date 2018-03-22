package com.huawei.hwid.api.common;

import android.content.Context;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AIDLTask */
public abstract class C5081b implements Runnable {
    protected Context f18333a;
    protected final CountDownLatch f18334b = new CountDownLatch(1);
    protected final AtomicBoolean f18335c = new AtomicBoolean(false);

    abstract void mo4613a(ErrorStatus errorStatus);

    abstract void mo4614b();

    protected C5081b(Context context) {
        this.f18333a = context;
    }

    public void run() {
        mo4614b();
        try {
            boolean await = this.f18334b.await(12000, TimeUnit.MILLISECONDS);
            C5165e.m24906b("AIDLTask", "run#await" + await);
            if (!await) {
                m24456c();
            }
        } catch (InterruptedException e) {
            C5165e.m24906b("AIDLTask", "execute await InterruptedException");
            m24456c();
        }
    }

    private void m24456c() {
        if (!this.f18335c.get()) {
            this.f18335c.set(true);
            mo4613a(null);
            m24457a();
        }
    }

    protected void m24457a() {
        C5165e.m24906b("AIDLTask", "finishTask");
        C5073a a = C5073a.m24398a(this.f18333a);
        if (a != null) {
            a.m24416b();
            this.f18334b.countDown();
            this.f18335c.set(true);
        }
    }
}
