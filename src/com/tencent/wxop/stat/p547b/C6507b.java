package com.tencent.wxop.stat.p547b;

import android.util.Log;
import com.tencent.wxop.stat.C6544v;

public final class C6507b {
    private String f22658a = "default";
    private boolean f22659b = true;
    private int f22660c = 2;

    public C6507b(String str) {
        this.f22658a = str;
    }

    private String m29700b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public final void m29701a() {
        this.f22659b = false;
    }

    public final void m29702a(Object obj) {
        if (this.f22659b && this.f22660c <= 4) {
            String b = m29700b();
            Log.i(this.f22658a, b == null ? obj.toString() : b + " - " + obj);
            C6544v.m29856w();
        }
    }

    public final void m29703a(Throwable th) {
        if (this.f22660c <= 6) {
            Log.e(this.f22658a, "", th);
            C6544v.m29856w();
        }
    }

    public final void m29704b(Object obj) {
        if (this.f22660c <= 5) {
            String b = m29700b();
            Log.w(this.f22658a, b == null ? obj.toString() : b + " - " + obj);
            C6544v.m29856w();
        }
    }

    public final void m29705b(Throwable th) {
        if (this.f22659b) {
            m29703a(th);
        }
    }

    public final void m29706c(Object obj) {
        if (this.f22659b) {
            m29704b(obj);
        }
    }

    public final void m29707d(Object obj) {
        if (this.f22660c <= 6) {
            String b = m29700b();
            Log.e(this.f22658a, b == null ? obj.toString() : b + " - " + obj);
            C6544v.m29856w();
        }
    }

    public final void m29708e(Object obj) {
        if (this.f22659b) {
            m29707d(obj);
        }
    }

    public final void m29709f(Object obj) {
        if (this.f22660c <= 3) {
            String b = m29700b();
            Log.d(this.f22658a, b == null ? obj.toString() : b + " - " + obj);
            C6544v.m29856w();
        }
    }

    public final void m29710g(Object obj) {
        if (this.f22659b) {
            m29709f(obj);
        }
    }
}
