package com.huawei.hwfitnessmgr;

import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5026i;
import java.util.Comparator;

/* compiled from: FitnessMgrStorage */
class C5045m implements Comparator<C5026i> {
    final /* synthetic */ C5039g f18256a;

    C5045m(C5039g c5039g) {
        this.f18256a = c5039g;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m24344a((C5026i) obj, (C5026i) obj2);
    }

    public int m24344a(C5026i c5026i, C5026i c5026i2) {
        return (int) (c5026i.m24229a() - c5026i2.m24229a());
    }
}
