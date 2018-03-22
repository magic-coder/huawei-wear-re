package com.tencent.wxop.stat.p547b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class C6511f {
    ExecutorService f22692a;

    public C6511f() {
        this.f22692a = null;
        this.f22692a = Executors.newSingleThreadExecutor();
    }

    public final void m29719a(Runnable runnable) {
        this.f22692a.execute(runnable);
    }
}
