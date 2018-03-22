package com.huawei.hwfitnessmgr.deviceadapter;

import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5026i;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5027j;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: FitnessUnTLVSample */
public class C5033h {
    public static int m24269a(C4754u c4754u) {
        List list = c4754u.f17338b;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            List list2 = ((C4754u) list.get(i2)).f17337a;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                String b = ((C4752s) list2.get(i3)).m22733b();
                switch (Integer.parseInt(((C4752s) list2.get(i3)).m22732a(), 16)) {
                    case 2:
                        i = Integer.parseInt(b, 16);
                        break;
                    default:
                        break;
                }
            }
        }
        return i;
    }

    private static List<C5027j> m24270a(String str) {
        List arrayList = new ArrayList();
        List<C5027j> arrayList2 = new ArrayList();
        C2538c.c("FitnessUnTLVSample", new Object[]{"parseBaseParameter " + str});
        int parseInt = Integer.parseInt(str.substring(0, 2), 16);
        arrayList.add(Integer.valueOf(parseInt));
        int i = 2;
        while ((parseInt & 128) != 0 && str.length() >= i + 2) {
            String substring = str.substring(i, i + 2);
            i += 2;
            parseInt = Integer.parseInt(substring, 16);
            arrayList.add(Integer.valueOf(parseInt));
        }
        if (arrayList.size() >= 1) {
            if ((((Integer) arrayList.get(0)).intValue() & 1) != 0 && str.length() >= i + 4) {
                parseInt = i + 4;
                arrayList2.add(new C5027j(4, Integer.parseInt(str.substring(i, i + 4), 16)));
                i = parseInt;
            }
            if ((((Integer) arrayList.get(0)).intValue() & 2) != 0 && str.length() >= i + 4) {
                substring = str.substring(i, i + 4);
                i += 4;
                arrayList2.add(new C5027j(1, Integer.parseInt(substring, 16)));
            }
            if ((((Integer) arrayList.get(0)).intValue() & 4) != 0 && str.length() >= i + 4) {
                substring = str.substring(i, i + 4);
                i += 4;
                arrayList2.add(new C5027j(2, Integer.parseInt(substring, 16)));
            }
            if ((((Integer) arrayList.get(0)).intValue() & 8) != 0 && str.length() >= i + 4) {
                substring = str.substring(i, i + 4);
                i += 4;
                arrayList2.add(new C5027j(3, Integer.parseInt(substring, 16)));
            }
            if ((((Integer) arrayList.get(0)).intValue() & 16) != 0 && str.length() >= i + 4) {
                substring = str.substring(i, i + 4);
                i += 4;
                arrayList2.add(new C5027j(5, Integer.parseInt(substring, 16)));
            }
            if ((((Integer) arrayList.get(0)).intValue() & 32) != 0 && str.length() >= i + 2) {
                substring = str.substring(i, i + 2);
                i += 2;
                arrayList2.add(new C5027j(6, Integer.parseInt(substring, 16)));
            }
            if ((((Integer) arrayList.get(0)).intValue() & 64) != 0 && str.length() >= i + 2) {
                arrayList2.add(new C5027j(7, Integer.parseInt(str.substring(i, i + 2), 16)));
            }
        }
        return arrayList2;
    }

    private static List<C5027j> m24271a(List<C5027j> list, long j, int i, int i2, int i3) {
        long j2 = j + ((long) (i * 60));
        for (C5027j c5027j : list) {
            c5027j.m24235a(j2);
            c5027j.m24234a(i2);
            c5027j.m24237b(i3);
        }
        return list;
    }

    public static C5026i m24272b(C4754u c4754u) {
        C5026i c5026i = new C5026i();
        List arrayList = new ArrayList();
        List list = c4754u.f17338b;
        int i = 0;
        int i2 = 0;
        while (i2 < list.size()) {
            List list2 = ((C4754u) list.get(i2)).f17337a;
            int i3 = i;
            for (i = 0; i < list2.size(); i++) {
                String b = ((C4752s) list2.get(i)).m22733b();
                switch (Integer.parseInt(((C4752s) list2.get(i)).m22732a(), 16)) {
                    case 3:
                        i3 = Integer.parseInt(b, 16);
                        c5026i.m24230a((long) i3);
                        break;
                    default:
                        break;
                }
            }
            List list3 = ((C4754u) list.get(i2)).f17338b;
            for (int i4 = 0; i4 < list3.size(); i4++) {
                List list4 = ((C4754u) list3.get(i4)).f17337a;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                Collection arrayList2 = new ArrayList();
                for (int i8 = 0; i8 < list4.size(); i8++) {
                    String b2 = ((C4752s) list4.get(i8)).m22733b();
                    int parseInt = Integer.parseInt(((C4752s) list4.get(i8)).m22732a(), 16);
                    switch (parseInt) {
                        case 5:
                            i5 = Integer.parseInt(b2, 16);
                            break;
                        case 6:
                            arrayList2.addAll(C5033h.m24270a(b2));
                            break;
                        case 8:
                            i7 = Integer.parseInt(b2, 16);
                            break;
                        case 9:
                            i6 = Integer.parseInt(b2, 16);
                            break;
                        default:
                            arrayList2.add(new C5027j(parseInt, Integer.parseInt(b2, 16)));
                            break;
                    }
                }
                C5033h.m24271a(arrayList2, (long) i3, i5, i7, i6);
                arrayList.addAll(arrayList2);
            }
            i2++;
            i = i3;
        }
        c5026i.m24231a(arrayList);
        return c5026i;
    }
}
