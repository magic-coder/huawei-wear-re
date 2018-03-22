package com.tencent.stat.p545b;

import android.util.Log;

public final class C6452b {
    private String f22384a = "default";
    private boolean f22385b = true;
    private int f22386c = 2;

    public C6452b(String str) {
        this.f22384a = str;
    }

    private String m29401b() {
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

    public void m29402a(Exception exception) {
        if (this.f22386c <= 6) {
            StringBuffer stringBuffer = new StringBuffer();
            String b = m29401b();
            StackTraceElement[] stackTrace = exception.getStackTrace();
            if (b != null) {
                stringBuffer.append(b + " - " + exception + "\r\n");
            } else {
                stringBuffer.append(exception + "\r\n");
            }
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        stringBuffer.append("[ " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + " ]\r\n");
                    }
                }
            }
            Log.e(this.f22384a, stringBuffer.toString());
        }
    }

    public void m29403a(Object obj) {
        if (this.f22386c <= 4) {
            String b = m29401b();
            Log.i(this.f22384a, b == null ? obj.toString() : b + " - " + obj);
        }
    }

    public void m29404a(boolean z) {
        this.f22385b = z;
    }

    public boolean m29405a() {
        return this.f22385b;
    }

    public void m29406b(Exception exception) {
        if (m29405a()) {
            m29402a(exception);
        }
    }

    public void m29407b(Object obj) {
        if (m29405a()) {
            m29403a(obj);
        }
    }

    public void m29408c(Object obj) {
        if (this.f22386c <= 5) {
            String b = m29401b();
            Log.w(this.f22384a, b == null ? obj.toString() : b + " - " + obj);
        }
    }

    public void m29409d(Object obj) {
        if (m29405a()) {
            m29408c(obj);
        }
    }

    public void m29410e(Object obj) {
        if (this.f22386c <= 6) {
            String b = m29401b();
            Log.e(this.f22384a, b == null ? obj.toString() : b + " - " + obj);
        }
    }

    public void m29411f(Object obj) {
        if (m29405a()) {
            m29410e(obj);
        }
    }

    public void m29412g(Object obj) {
        if (this.f22386c <= 3) {
            String b = m29401b();
            Log.d(this.f22384a, b == null ? obj.toString() : b + " - " + obj);
        }
    }

    public void m29413h(Object obj) {
        if (m29405a()) {
            m29412g(obj);
        }
    }
}
