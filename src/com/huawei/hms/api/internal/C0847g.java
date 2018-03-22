package com.huawei.hms.api.internal;

import java.util.List;

/* compiled from: ProtocolNegotiate */
public class C0847g {
    private static C0847g f1344b = new C0847g();
    private int f1345a = 1;

    public static C0847g m2998a() {
        return f1344b;
    }

    public int m2999a(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            this.f1345a = 1;
            return this.f1345a;
        }
        if (list.contains(Integer.valueOf(2))) {
            this.f1345a = 2;
        } else {
            this.f1345a = ((Integer) list.get(list.size() - 1)).intValue();
        }
        return this.f1345a;
    }

    public int m3000b() {
        return this.f1345a;
    }
}
