package com.huawei.pluginkidwatch.plugin.p152a.p153a.p158b;

import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p159b.C1693a;
import java.util.ArrayList;

/* compiled from: WOneBluetoothDataWrapper */
public class C1683b extends C1682a {
    public C1683b(int i) {
        C1682a.m7852a(i);
    }

    public ArrayList<byte[]> mo2564a(int i, byte[] bArr, int i2) {
        if (bArr == null || i == 0) {
            return null;
        }
        ArrayList<byte[]> arrayList = new ArrayList();
        arrayList.add(bArr);
        return arrayList;
    }

    public C1693a mo2565b(int i, byte[] bArr, int i2) {
        C1693a c1693a = new C1693a();
        c1693a.m7879a(bArr);
        c1693a.m7878a(1);
        return c1693a;
    }
}
