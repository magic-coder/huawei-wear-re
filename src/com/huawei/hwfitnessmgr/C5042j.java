package com.huawei.hwfitnessmgr;

import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5018a;
import java.util.Comparator;

/* compiled from: FitnessMgrStorage */
class C5042j implements Comparator<C5018a> {
    final /* synthetic */ C5039g f18252a;

    C5042j(C5039g c5039g) {
        this.f18252a = c5039g;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m24342a((C5018a) obj, (C5018a) obj2);
    }

    public int m24342a(C5018a c5018a, C5018a c5018a2) {
        return c5018a.m24171a() - c5018a2.m24171a();
    }
}
