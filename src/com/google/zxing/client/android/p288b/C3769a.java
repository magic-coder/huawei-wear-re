package com.google.zxing.client.android.p288b;

import android.os.Build.VERSION;
import android.util.Log;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: PlatformSupportManager */
public abstract class C3769a<T> {
    private static final String f14679a = C3769a.class.getSimpleName();
    private final Class<T> f14680b;
    private final T f14681c;
    private final SortedMap<Integer, String> f14682d;

    protected C3769a(Class<T> cls, T t) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException();
        } else if (cls.isInstance(t)) {
            this.f14680b = cls;
            this.f14681c = t;
            this.f14682d = new TreeMap(Collections.reverseOrder());
        } else {
            throw new IllegalArgumentException();
        }
    }

    protected final void m18973a(int i, String str) {
        this.f14682d.put(Integer.valueOf(i), str);
    }

    public final T m18972a() {
        for (Integer num : this.f14682d.keySet()) {
            if (VERSION.SDK_INT >= num.intValue()) {
                try {
                    Class asSubclass = Class.forName((String) this.f14682d.get(num)).asSubclass(this.f14680b);
                    Log.i(f14679a, "Using implementation " + asSubclass + " of " + this.f14680b + " for SDK " + num);
                    return asSubclass.getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable e) {
                    Log.w(f14679a, e);
                } catch (Throwable e2) {
                    Log.w(f14679a, e2);
                } catch (Throwable e22) {
                    Log.w(f14679a, e22);
                } catch (Throwable e222) {
                    Log.w(f14679a, e222);
                } catch (Throwable e2222) {
                    Log.w(f14679a, e2222);
                }
            }
        }
        Log.i(f14679a, "Using default implementation " + this.f14681c.getClass() + " of " + this.f14680b);
        return this.f14681c;
    }
}
