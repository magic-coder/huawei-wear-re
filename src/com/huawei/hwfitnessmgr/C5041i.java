package com.huawei.hwfitnessmgr;

import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5019b;
import java.util.Comparator;

/* compiled from: FitnessMgrStorage */
class C5041i implements Comparator<C5019b> {
    final /* synthetic */ C5039g f18251a;

    C5041i(C5039g c5039g) {
        this.f18251a = c5039g;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m24341a((C5019b) obj, (C5019b) obj2);
    }

    public int m24341a(C5019b c5019b, C5019b c5019b2) {
        return c5019b.m24187f() - c5019b2.m24187f();
    }
}
