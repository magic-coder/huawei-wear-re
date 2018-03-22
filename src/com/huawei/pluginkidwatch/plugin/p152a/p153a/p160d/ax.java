package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import com.huawei.hwcommonmodel.datatypes.s;
import com.huawei.hwcommonmodel.datatypes.u;
import java.util.List;

/* compiled from: UnTLVUtils */
public class ax {
    public static byte[] m8019a(u uVar) {
        byte[] bArr = null;
        List list = uVar.a;
        int i = 0;
        while (i < list.size()) {
            byte[] a;
            String b = ((s) list.get(i)).b();
            switch (Integer.parseInt(((s) list.get(i)).a(), 16)) {
                case 1:
                    a = al.m7918a(b);
                    break;
                default:
                    a = bArr;
                    break;
            }
            i++;
            bArr = a;
        }
        return bArr;
    }

    public static byte[] m8020b(u uVar) {
        byte[] bArr = null;
        List list = uVar.a;
        int i = 0;
        while (i < list.size()) {
            byte[] a;
            String b = ((s) list.get(i)).b();
            switch (Integer.parseInt(((s) list.get(i)).a(), 16)) {
                case 2:
                    a = al.m7918a(b);
                    break;
                default:
                    a = bArr;
                    break;
            }
            i++;
            bArr = a;
        }
        return bArr;
    }
}
