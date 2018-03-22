package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: TagManager */
public class be {
    private static be f14299f;
    private final bi f14300a;
    private final Context f14301b;
    private final C3681f f14302c;
    private volatile bj f14303d;
    private final ConcurrentMap<String, C3679d> f14304e;

    be(Context context, bi biVar, C3681f c3681f) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.f14301b = context.getApplicationContext();
        this.f14300a = biVar;
        this.f14303d = bj.STANDARD;
        this.f14304e = new ConcurrentHashMap();
        this.f14302c = c3681f;
        this.f14302c.m18569a(new bf(this));
        this.f14302c.m18569a(new C3676a(this.f14301b));
    }

    public static be m18516a(Context context) {
        be beVar;
        synchronized (be.class) {
            if (f14299f == null) {
                if (context == null) {
                    C3700z.m18624a("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                f14299f = new be(context, new bg(), new C3681f(new C3688n(context)));
            }
            beVar = f14299f;
        }
        return beVar;
    }

    public bj m18519a() {
        return this.f14303d;
    }

    synchronized boolean m18520a(Uri uri) {
        boolean z;
        am a = am.m18470a();
        if (a.m18473a(uri)) {
            String d = a.m18476d();
            switch (bh.f14306a[a.m18474b().ordinal()]) {
                case 1:
                    C3679d c3679d = (C3679d) this.f14304e.get(d);
                    if (c3679d != null) {
                        c3679d.m18552b(null);
                        c3679d.refresh();
                        break;
                    }
                    break;
                case 2:
                case 3:
                    for (Entry entry : this.f14304e.entrySet()) {
                        C3679d c3679d2 = (C3679d) entry.getValue();
                        if (((String) entry.getKey()).equals(d)) {
                            c3679d2.m18552b(a.m18475c());
                            c3679d2.refresh();
                        } else if (c3679d2.m18549a() != null) {
                            c3679d2.m18552b(null);
                            c3679d2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private void m18518a(String str) {
        for (C3679d a : this.f14304e.values()) {
            a.m18551a(str);
        }
    }
}
