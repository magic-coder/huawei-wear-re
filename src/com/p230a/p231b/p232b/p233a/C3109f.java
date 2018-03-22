package com.p230a.p231b.p232b.p233a;

import android.os.Handler;
import java.util.concurrent.Executor;

public class C3109f implements C3108s {
    private final Executor f10426a;

    public C3109f(Handler handler) {
        this.f10426a = new C3123z(handler);
    }

    public void mo3659a(C3115m c3115m, C3118p c3118p) {
        mo3660a(c3115m, c3118p, null);
    }

    public void mo3660a(C3115m c3115m, C3118p c3118p, Runnable runnable) {
        c3115m.m13895t();
        c3115m.m13873a("post-response");
        this.f10426a.execute(new aa(c3115m, c3118p, runnable));
    }

    public void mo3661a(C3115m c3115m, C3102w c3102w) {
        c3115m.m13873a("post-error");
        this.f10426a.execute(new aa(c3115m, C3118p.m13902a(c3102w), null));
    }
}
