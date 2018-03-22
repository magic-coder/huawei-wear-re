package com.tencent.p527a.p528a.p529a.p530a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class C6242g {
    private static C6242g f21710d = null;
    private Map<Integer, C6237f> f21711a = null;
    private int f21712b = 0;
    private Context f21713c = null;

    private C6242g(Context context) {
        this.f21713c = context.getApplicationContext();
        this.f21711a = new HashMap(3);
        this.f21711a.put(Integer.valueOf(1), new C6241e(context));
        this.f21711a.put(Integer.valueOf(2), new C6238b(context));
        this.f21711a.put(Integer.valueOf(4), new C6240d(context));
    }

    private C6239c m28685a(List<Integer> list) {
        if (list != null && list.size() >= 0) {
            for (Integer num : list) {
                C6237f c6237f = (C6237f) this.f21711a.get(num);
                if (c6237f != null) {
                    C6239c c = c6237f.m28672c();
                    if (c != null && C6243h.m28695b(c.f21708c)) {
                        return c;
                    }
                }
            }
        }
        return new C6239c();
    }

    public static synchronized C6242g m28686a(Context context) {
        C6242g c6242g;
        synchronized (C6242g.class) {
            if (f21710d == null) {
                f21710d = new C6242g(context);
            }
            c6242g = f21710d;
        }
        return c6242g;
    }

    public final C6239c m28687a() {
        return m28685a(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
    }

    public final void m28688a(String str) {
        C6239c a = m28687a();
        a.f21708c = str;
        if (!C6243h.m28693a(a.f21706a)) {
            a.f21706a = C6243h.m28689a(this.f21713c);
        }
        if (!C6243h.m28693a(a.f21707b)) {
            a.f21707b = C6243h.m28694b(this.f21713c);
        }
        a.f21709d = System.currentTimeMillis();
        for (Entry value : this.f21711a.entrySet()) {
            ((C6237f) value.getValue()).m28668a(a);
        }
    }
}
