package com.tencent.map.p535b;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.List;

public final class C6323o implements Cloneable {
    private List<ScanResult> f22033a = null;

    public C6323o(C6315g c6315g, List<ScanResult> list, long j, int i) {
        if (list != null) {
            this.f22033a = new ArrayList();
            for (ScanResult add : list) {
                this.f22033a.add(add);
            }
        }
    }

    public final List<ScanResult> m28991a() {
        return this.f22033a;
    }

    public final Object clone() {
        C6323o c6323o;
        try {
            c6323o = (C6323o) super.clone();
        } catch (Exception e) {
            c6323o = null;
        }
        if (this.f22033a != null) {
            c6323o.f22033a = new ArrayList();
            c6323o.f22033a.addAll(this.f22033a);
        }
        return c6323o;
    }
}
