package com.huawei.hwcommonmodel.p064d.p406a;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PermissionsResultAction */
public abstract class C4719c {
    private static final String f17265a = C4719c.class.getSimpleName();
    private final Set<String> f17266b = new HashSet(1);
    private Looper f17267c = Looper.getMainLooper();
    private final Object f17268d = new Object();

    public abstract void mo5116a();

    public abstract void mo5117a(String str);

    public boolean m22609b(String str) {
        synchronized (this.f17268d) {
            Log.d(f17265a, "Permission not found: " + str);
        }
        return true;
    }

    @CallSuper
    protected final boolean m22607a(@NonNull String str, int i) {
        boolean a;
        synchronized (this.f17268d) {
            if (i == 0) {
                a = m22608a(str, C4717a.GRANTED);
            } else {
                a = m22608a(str, C4717a.DENIED);
            }
        }
        return a;
    }

    @CallSuper
    protected final boolean m22608a(@NonNull String str, C4717a c4717a) {
        boolean z = true;
        synchronized (this.f17268d) {
            this.f17266b.remove(str);
            if (c4717a == C4717a.GRANTED) {
                if (this.f17266b.isEmpty()) {
                    new Handler(this.f17267c).post(new C4720d(this));
                }
                z = false;
            } else if (c4717a == C4717a.DENIED) {
                new Handler(this.f17267c).post(new C4721e(this, str));
            } else {
                if (c4717a == C4717a.NOT_FOUND) {
                    if (!m22609b(str)) {
                        new Handler(this.f17267c).post(new C4723g(this, str));
                    } else if (this.f17266b.isEmpty()) {
                        new Handler(this.f17267c).post(new C4722f(this));
                    }
                }
                z = false;
            }
        }
        return z;
    }

    @CallSuper
    protected final void m22606a(@NonNull String[] strArr) {
        synchronized (this.f17268d) {
            Collections.addAll(this.f17266b, strArr);
        }
    }
}
