package com.huawei.aa.p311c;

import com.huawei.aa.p309a.C3940a;
import com.huawei.aa.p309a.C3941b;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4753t;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: StressMgrUtil */
public class C3948a {
    public static C3941b m19628a(byte[] bArr) {
        String a = a.a(bArr);
        C3941b c3941b = new C3941b();
        List arrayList = new ArrayList();
        if (4 < a.length()) {
            try {
                List<C4754u> list = new C4756w().m22743a(a.substring(4, a.length())).f17338b;
                if (list != null && list.size() > 0) {
                    for (C4754u c4754u : list) {
                        for (C4752s c4752s : c4754u.f17337a) {
                            switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                                case 2:
                                    c3941b.m19602a(Integer.parseInt(c4752s.m22733b(), 16));
                                    break;
                                default:
                                    break;
                            }
                        }
                        for (C4754u c4754u2 : c4754u.f17338b) {
                            List<C4752s> list2 = c4754u2.f17337a;
                            C3940a c3940a = new C3940a();
                            for (C4752s c4752s2 : list2) {
                                switch (Integer.parseInt(c4752s2.m22732a(), 16)) {
                                    case 4:
                                        c3940a.m19597b(Integer.parseInt(c4752s2.m22733b(), 16));
                                        break;
                                    case 5:
                                        c3940a.m19594a(Integer.parseInt(c4752s2.m22733b(), 16));
                                        break;
                                    case 6:
                                        c3940a.m19595a((long) Integer.parseInt(c4752s2.m22733b(), 16));
                                        break;
                                    case 7:
                                        c3940a.m19599c(Integer.parseInt(c4752s2.m22733b(), 16));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            arrayList.add(c3940a);
                        }
                    }
                }
                c3941b.m19603a(arrayList);
            } catch (C4753t e) {
                C2538c.e("StressMgrUtil", new Object[]{"接收命令错误 e = " + e.getMessage()});
            }
        }
        return c3941b;
    }
}
