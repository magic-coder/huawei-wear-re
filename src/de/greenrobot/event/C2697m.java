package de.greenrobot.event;

import java.lang.reflect.Method;

/* compiled from: SubscriberMethod */
final class C2697m {
    final Method f9147a;
    final C2700p f9148b;
    final Class<?> f9149c;
    String f9150d;

    C2697m(Method method, C2700p c2700p, Class<?> cls) {
        this.f9147a = method;
        this.f9148b = c2700p;
        this.f9149c = cls;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2697m)) {
            return false;
        }
        m12851a();
        C2697m c2697m = (C2697m) obj;
        c2697m.m12851a();
        return this.f9150d.equals(c2697m.f9150d);
    }

    private synchronized void m12851a() {
        if (this.f9150d == null) {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append(this.f9147a.getDeclaringClass().getName());
            stringBuilder.append('#').append(this.f9147a.getName());
            stringBuilder.append('(').append(this.f9149c.getName());
            this.f9150d = stringBuilder.toString();
        }
    }

    public int hashCode() {
        return this.f9147a.hashCode();
    }
}
