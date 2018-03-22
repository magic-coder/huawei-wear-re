package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p360b;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p361d.C4244c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class C4245c extends C4244c {
    private BlockingQueue<C4243b> f15919a = new LinkedBlockingQueue();

    public C4245c() {
        super("logger");
    }

    public void m20562a(C4243b c4243b) {
        this.f15919a.offer(c4243b);
    }

    protected boolean mo4388a() {
        return true;
    }

    protected boolean mo4389b() {
        try {
            if (C4243b.m20540b() != null) {
                C4243b c4243b = (C4243b) this.f15919a.poll(3, TimeUnit.SECONDS);
                if (!C4243b.m20537a(c4243b)) {
                    c4243b.m20553f();
                } else if (c4243b != null) {
                    return false;
                }
            }
            synchronized (this) {
                wait(1000);
            }
        } catch (InterruptedException e) {
        }
        return true;
    }

    protected void mo4390c() {
    }
}
