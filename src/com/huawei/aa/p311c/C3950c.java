package com.huawei.aa.p311c;

import com.huawei.aa.p309a.C3941b;
import com.huawei.aa.p309a.C3942c;
import com.huawei.aa.p309a.C3943d;
import com.huawei.aa.p309a.C3944e;
import com.huawei.aa.p309a.C3945f;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4753t;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: StressUnPackage */
public class C3950c {
    private static int[] m19634a(C4754u c4754u) {
        List list = c4754u.f17337a;
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            String b = ((C4752s) list.get(i)).m22733b();
            switch (Integer.parseInt(((C4752s) list.get(i)).m22732a(), 16)) {
                case 127:
                    if (iArr.length <= 0) {
                        break;
                    }
                    iArr[0] = Integer.parseInt(b, 16);
                    break;
                default:
                    break;
            }
        }
        return iArr;
    }

    public static int m19633a(byte[] bArr) {
        int i = 0;
        try {
            String a = a.a(bArr);
            int[] a2 = C3950c.m19634a(new C4756w().m22743a(a.substring(4, a.length())));
            C2538c.c("MultiSimUnPackage", new Object[]{"Error Code:" + a2[0]});
            if (a2[0] != 100000) {
                i = a2[0];
            }
        } catch (C4753t e) {
            C2538c.e("MultiSimUnPackage", new Object[]{"getErrorCode TLVException e = " + e.getMessage()});
        }
        return i;
    }

    public static C3945f m19635b(byte[] bArr) {
        String a = a.a(bArr);
        C3945f c3945f = new C3945f();
        if (4 < a.length()) {
            a = a.substring(4, a.length());
            List arrayList = new ArrayList();
            try {
                List<C4754u> list = new C4756w().m22743a(a).f17338b;
                if (list != null && list.size() > 0) {
                    for (C4754u c4754u : list) {
                        for (C4752s c4752s : c4754u.f17337a) {
                            switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                                case 2:
                                    c3945f.m19618a(Integer.parseInt(c4752s.m22733b(), 16));
                                    break;
                                case 5:
                                    arrayList.add(Integer.valueOf(Integer.parseInt(c4752s.m22733b(), 16)));
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
                c3945f.m19619a(arrayList);
            } catch (C4753t e) {
                C2538c.e("MultiSimUnPackage", new Object[]{"接收命令错误 e = " + e.getMessage()});
            }
        }
        return c3945f;
    }

    public static C3944e m19636c(byte[] bArr) {
        String a = a.a(bArr);
        C3944e c3944e = new C3944e();
        List arrayList = new ArrayList();
        if (4 < a.length()) {
            try {
                List<C4754u> list = new C4756w().m22743a(a.substring(4, a.length())).f17338b;
                if (list != null && list.size() > 0) {
                    for (C4754u c4754u : list) {
                        for (C4752s c4752s : c4754u.f17337a) {
                            switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                                case 2:
                                    c3944e.m19615a(Integer.parseInt(c4752s.m22733b(), 16));
                                    break;
                                default:
                                    break;
                            }
                        }
                        for (C4754u c4754u2 : c4754u.f17338b) {
                            List<C4752s> list2 = c4754u2.f17337a;
                            C3943d c3943d = new C3943d();
                            for (C4752s c4752s2 : list2) {
                                switch (Integer.parseInt(c4752s2.m22732a(), 16)) {
                                    case 4:
                                        c3943d.m19609a(Integer.parseInt(c4752s2.m22733b(), 16));
                                        break;
                                    case 5:
                                        c3943d.m19610a((long) Integer.parseInt(c4752s2.m22733b(), 16));
                                        break;
                                    case 6:
                                        c3943d.m19612b(Integer.parseInt(c4752s2.m22733b(), 16));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            arrayList.add(c3943d);
                        }
                    }
                }
                c3944e.m19616a(arrayList);
            } catch (C4753t e) {
                C2538c.e("MultiSimUnPackage", new Object[]{"接收命令错误 e = " + e.getMessage()});
            }
        }
        return c3944e;
    }

    public static C3942c m19637d(byte[] bArr) {
        String a = a.a(bArr);
        C3942c c3942c = new C3942c();
        if (4 < a.length()) {
            a = a.substring(4, a.length());
            List arrayList = new ArrayList();
            try {
                List<C4754u> list = new C4756w().m22743a(a).f17338b;
                if (list != null && list.size() > 0) {
                    for (C4754u c4754u : list) {
                        for (C4752s c4752s : c4754u.f17337a) {
                            switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                                case 2:
                                    c3942c.m19605a(Integer.parseInt(c4752s.m22733b(), 16));
                                    break;
                                case 5:
                                    arrayList.add(Integer.valueOf(Integer.parseInt(c4752s.m22733b(), 16)));
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
                c3942c.m19606a(arrayList);
            } catch (C4753t e) {
                C2538c.e("MultiSimUnPackage", new Object[]{"接收命令错误 e = " + e.getMessage()});
            }
        }
        return c3942c;
    }

    public static C3941b m19638e(byte[] bArr) {
        return C3948a.m19628a(bArr);
    }
}
