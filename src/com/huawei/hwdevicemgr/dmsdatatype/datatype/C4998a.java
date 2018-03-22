package com.huawei.hwdevicemgr.dmsdatatype.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;
import java.util.ArrayList;

/* compiled from: Command */
public class C4998a {
    private int f18116a = 0;
    private ArrayList<byte[]> f18117b;

    public int m24004a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18116a))).intValue();
    }

    public ArrayList<byte[]> m24005b() {
        return (ArrayList) C0978h.a(this.f18117b);
    }

    public C4998a(ArrayList<byte[]> arrayList) {
        this.f18117b = arrayList;
    }
}
