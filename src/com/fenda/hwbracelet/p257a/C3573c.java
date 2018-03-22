package com.fenda.hwbracelet.p257a;

import com.fenda.hwbracelet.mode.C3629l;
import java.util.Comparator;

/* compiled from: SyncDataParser */
final class C3573c implements Comparator<C3629l> {
    C3573c() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m17933a((C3629l) obj, (C3629l) obj2);
    }

    public int m17933a(C3629l c3629l, C3629l c3629l2) {
        if (c3629l.m18198a() > c3629l2.m18198a()) {
            return 1;
        }
        if (c3629l.m18198a() < c3629l2.m18198a()) {
            return -1;
        }
        return 0;
    }
}
