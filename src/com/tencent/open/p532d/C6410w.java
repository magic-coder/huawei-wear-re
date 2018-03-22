package com.tencent.open.p532d;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

/* compiled from: ProGuard */
class C6410w implements Executor {
    final Queue<Runnable> f22258a;
    Runnable f22259b;

    private C6410w() {
        this.f22258a = new LinkedList();
    }

    public synchronized void execute(Runnable runnable) {
        this.f22258a.offer(new C6411x(this, runnable));
        if (this.f22259b == null) {
            m29233a();
        }
    }

    protected synchronized void m29233a() {
        Runnable runnable = (Runnable) this.f22258a.poll();
        this.f22259b = runnable;
        if (runnable != null) {
            C6408u.f22254a.execute(this.f22259b);
        }
    }
}
