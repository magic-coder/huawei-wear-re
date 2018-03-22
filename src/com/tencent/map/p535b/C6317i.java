package com.tencent.map.p535b;

import android.telephony.NeighboringCellInfo;
import java.util.LinkedList;
import java.util.List;

public final class C6317i {
    private List<NeighboringCellInfo> f22010a;
    private byte[] f22011b;

    public final List<NeighboringCellInfo> m28987a() {
        List<NeighboringCellInfo> list = null;
        synchronized (this.f22011b) {
            if (this.f22010a != null) {
                list = new LinkedList();
                list.addAll(this.f22010a);
            }
        }
        return list;
    }
}
