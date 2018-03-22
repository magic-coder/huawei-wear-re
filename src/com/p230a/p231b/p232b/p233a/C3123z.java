package com.p230a.p231b.p232b.p233a;

import android.os.Handler;
import java.util.concurrent.Executor;

final class C3123z implements Executor {
    private final /* synthetic */ Handler f10473a;

    C3123z(Handler handler) {
        this.f10473a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f10473a.post(runnable);
    }
}
