package com.tencent.p527a.p528a.p529a.p530a;

import android.content.Context;

public abstract class C6237f {
    protected Context f21705a = null;

    protected C6237f(Context context) {
        this.f21705a = context;
    }

    public final void m28668a(C6239c c6239c) {
        if (c6239c != null) {
            String c6239c2 = c6239c.toString();
            if (mo5284a()) {
                mo5283a(C6243h.m28697d(c6239c2));
            }
        }
    }

    protected abstract void mo5283a(String str);

    protected abstract boolean mo5284a();

    protected abstract String mo5285b();

    public final C6239c m28672c() {
        String c = mo5284a() ? C6243h.m28696c(mo5285b()) : null;
        return c != null ? C6239c.m28676a(c) : null;
    }
}
