package com.huawei.p192w.p521a;

import com.huawei.hwcommonmodel.datatypes.C4744k;
import com.huawei.hwcommonmodel.datatypes.C4747n;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.multisimservice.model.MultiSimDeviceInfo;
import com.huawei.multisimservice.model.SimInfo;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: MultiSimUnPackage */
public class C6137b {
    public static int[] m27939a(C4754u c4754u) {
        List a = c4754u.m22734a();
        int size = a.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            String b = ((C4752s) a.get(i)).m22733b();
            switch (Integer.parseInt(((C4752s) a.get(i)).m22732a(), 16)) {
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

    public static int m27938a(byte[] bArr) throws Exception {
        String a = a.a(bArr);
        int[] a2 = C6137b.m27939a(new C4756w().m22743a(a.substring(4, a.length())));
        C2538c.c("MultiSimUnPackage", new Object[]{"Error Code:" + a2[0]});
        if (a2[0] == 100000) {
            return 0;
        }
        return a2[0];
    }

    private static MultiSimDeviceInfo m27940b(C4754u c4754u) {
        MultiSimDeviceInfo multiSimDeviceInfo = new MultiSimDeviceInfo();
        List list = c4754u.f17338b;
        for (int i = 0; i < list.size(); i++) {
            int i2;
            List a = ((C4754u) list.get(i)).m22734a();
            for (i2 = 0; i2 < a.size(); i2++) {
                String b = ((C4752s) a.get(i2)).m22733b();
                switch (Integer.parseInt(((C4752s) a.get(i2)).m22732a(), 16)) {
                    case 2:
                        multiSimDeviceInfo.setDeviceType(Integer.parseInt(b, 16));
                        break;
                    case 3:
                        multiSimDeviceInfo.setDeviceIMEI(a.c(b));
                        break;
                    case 4:
                        multiSimDeviceInfo.setDeviceSerialNumber(a.c(b));
                        break;
                    case 5:
                        multiSimDeviceInfo.setProductName(a.c(b));
                        break;
                    case 6:
                        multiSimDeviceInfo.setEID(a.c(b));
                        break;
                    default:
                        C2538c.e("MultiSimUnPackage", new Object[]{":" + Integer.parseInt(((C4752s) a.get(i2)).m22732a(), 16)});
                        break;
                }
            }
            List arrayList = new ArrayList();
            List b2 = ((C4754u) list.get(i)).m22735b();
            for (i2 = 0; i2 < b2.size(); i2++) {
                List b3 = ((C4754u) b2.get(i2)).m22735b();
                for (int i3 = 0; i3 < b3.size(); i3++) {
                    List a2 = ((C4754u) b3.get(i3)).m22734a();
                    SimInfo simInfo = new SimInfo();
                    for (int i4 = 0; i4 < a2.size(); i4++) {
                        String b4 = ((C4752s) a2.get(i4)).m22733b();
                        switch (Integer.parseInt(((C4752s) a2.get(i4)).m22732a(), 16)) {
                            case 9:
                                simInfo.setIMSI(a.c(b4));
                                break;
                            case 10:
                                simInfo.setICCID(a.c(b4));
                                break;
                            case 11:
                                simInfo.setActive(Integer.parseInt(b4, 16) != 1);
                                break;
                            default:
                                C2538c.e("MultiSimUnPackage", new Object[]{" unkown type:", Integer.valueOf(Integer.parseInt(((C4752s) a2.get(i4)).m22732a(), 16))});
                                break;
                        }
                    }
                    C2538c.c("MultiSimUnPackage", new Object[]{" profileInfo:", simInfo});
                    arrayList.add(simInfo);
                }
            }
            multiSimDeviceInfo.setSimInfoList(arrayList);
        }
        return multiSimDeviceInfo;
    }

    public static MultiSimDeviceInfo m27941b(byte[] bArr) throws Exception {
        String a = a.a(bArr);
        return C6137b.m27940b(new C4756w().m22743a(a.substring(4, a.length())));
    }

    public static int m27942c(byte[] bArr) throws Exception {
        String a = a.a(bArr);
        List a2 = new C4756w().m22743a(a.substring(4, a.length())).m22734a();
        int size = a2.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            String b = ((C4752s) a2.get(i)).m22733b();
            switch (Integer.parseInt(((C4752s) a2.get(i)).m22732a(), 16)) {
                case 1:
                    if (iArr.length <= 0) {
                        break;
                    }
                    iArr[0] = Integer.parseInt(b, 16);
                    break;
                default:
                    break;
            }
        }
        C2538c.c("MultiSimUnPackage", new Object[]{"Error Code:" + iArr[0]});
        return iArr[0];
    }

    public static int m27943d(byte[] bArr) throws Exception {
        String a = a.a(bArr);
        List a2 = new C4756w().m22743a(a.substring(4, a.length())).m22734a();
        if (a2 == null || a2.size() <= 0) {
            return -1;
        }
        return Integer.parseInt(((C4752s) a2.get(0)).m22733b(), 16);
    }

    public static C4747n m27944e(byte[] bArr) throws Exception {
        C2538c.c("MultiSimUnPackage", new Object[]{"Error Code:111111111111111111111"});
        String a = a.a(bArr);
        C4754u a2 = new C4756w().m22743a(a.substring(4, a.length()));
        List b = a2.m22735b();
        List<C4752s> a3 = a2.m22734a();
        C4747n c4747n = new C4747n();
        if (a3 != null && a3.size() > 0) {
            for (C4752s c4752s : a3) {
                C2538c.c("MultiSimUnPackage", new Object[]{"Error Code:3333333333333333333333333"});
                switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                    case 1:
                        C2538c.b("MultiSimUnPackage", new Object[]{"authenticationResult " + Integer.parseInt(c4752s.m22733b(), 16)});
                        c4747n.m22719b(Integer.parseInt(c4752s.m22733b(), 16));
                        break;
                    case 2:
                        C2538c.b("MultiSimUnPackage", new Object[]{"SPN " + Integer.parseInt(c4752s.m22733b(), 16)});
                        c4747n.m22716a(Integer.parseInt(c4752s.m22733b(), 16));
                        break;
                    default:
                        C2538c.b("MultiSimUnPackage", new Object[]{"default"});
                        break;
                }
            }
        }
        C4744k c4744k = new C4744k();
        if (b != null && b.size() > 0) {
            C2538c.c("MultiSimUnPackage", new Object[]{"Error Code:22222222222222222222222"});
            for (C4752s c4752s2 : ((C4754u) b.get(0)).m22734a()) {
                C2538c.c("MultiSimUnPackage", new Object[]{"Error Code:3333333333333333333333333"});
                switch (Integer.parseInt(c4752s2.m22732a(), 16)) {
                    case 4:
                        C2538c.b("MultiSimUnPackage", new Object[]{"ICCID " + a.c(c4752s2.m22733b())});
                        c4744k.m22694a(a.c(c4752s2.m22733b()));
                        break;
                    case 5:
                        C2538c.b("MultiSimUnPackage", new Object[]{"SPN " + a.c(c4752s2.m22733b())});
                        c4744k.m22697b(a.c(c4752s2.m22733b()));
                        break;
                    case 6:
                        C2538c.b("MultiSimUnPackage", new Object[]{"profile name " + a.c(c4752s2.m22733b())});
                        c4744k.m22699c(a.c(c4752s2.m22733b()));
                        break;
                    case 7:
                        C2538c.b("MultiSimUnPackage", new Object[]{"profile class " + a.c(c4752s2.m22733b())});
                        c4744k.m22700d(a.c(c4752s2.m22733b()));
                        break;
                    case 8:
                        try {
                            C2538c.b("MultiSimUnPackage", new Object[]{"ICON TYPE " + Integer.parseInt(c4752s2.m22733b())});
                            c4744k.m22693a(Integer.parseInt(c4752s2.m22733b()));
                            break;
                        } catch (Exception e) {
                            C2538c.e("MultiSimUnPackage", new Object[]{"Exception:  " + e.getMessage()});
                            break;
                        }
                    case 9:
                        C2538c.b("MultiSimUnPackage", new Object[]{"ICON " + c4752s2.m22733b()});
                        c4744k.m22695a(a.b(c4752s2.m22733b()));
                        break;
                    case 10:
                        C2538c.b("MultiSimUnPackage", new Object[]{"CONFINFO " + a.c(c4752s2.m22733b())});
                        c4744k.m22702e(a.c(c4752s2.m22733b()));
                        break;
                    case 11:
                        C2538c.b("MultiSimUnPackage", new Object[]{"PO " + a.c(c4752s2.m22733b())});
                        c4744k.m22703f(a.c(c4752s2.m22733b()));
                        break;
                    case 12:
                        C2538c.b("MultiSimUnPackage", new Object[]{"PPR " + a.c(c4752s2.m22733b())});
                        c4744k.m22704g(a.c(c4752s2.m22733b()));
                        break;
                    default:
                        C2538c.b("MultiSimUnPackage", new Object[]{"default"});
                        break;
                }
            }
            c4747n.m22717a(c4744k);
        }
        return c4747n;
    }
}
