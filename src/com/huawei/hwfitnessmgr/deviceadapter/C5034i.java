package com.huawei.hwfitnessmgr.deviceadapter;

import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5028k;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5029l;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: FitnessUnTLVStatus */
public class C5034i {
    public static int m24273a(C4754u c4754u) {
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

    public static C5029l m24274a(C5029l c5029l, String str) {
        if (str.length() != 12) {
            C2538c.c("FitnessUnTLVStatus", new Object[]{"parseStatusDuration invalid duration" + str});
        } else {
            String substring = str.substring(0, 8);
            try {
                long parseInt = (long) Integer.parseInt(substring, 16);
                int parseInt2 = Integer.parseInt(str.substring(8, 12), 16);
                c5029l.m24246a(parseInt);
                c5029l.m24245a(parseInt2 * 60);
            } catch (Exception e) {
                C2538c.e("FitnessUnTLVStatus", new Object[]{"parseStatusDuration parse time error" + e});
            }
        }
        return c5029l;
    }

    public static C5028k m24275b(C4754u c4754u) {
        C5028k c5028k = new C5028k();
        List arrayList = new ArrayList();
        List list = c4754u.f17338b;
        for (int i = 0; i < list.size(); i++) {
            int i2;
            List list2 = ((C4754u) list.get(i)).f17337a;
            for (i2 = 0; i2 < list2.size(); i2++) {
                String b = ((C4752s) list2.get(i2)).m22733b();
                switch (Integer.parseInt(((C4752s) list2.get(i2)).m22732a(), 16)) {
                    case 3:
                        c5028k.m24242a((long) Integer.parseInt(b, 16));
                        break;
                    default:
                        break;
                }
            }
            List list3 = ((C4754u) list.get(i)).f17338b;
            for (i2 = 0; i2 < list3.size(); i2++) {
                List list4 = ((C4754u) list3.get(i2)).f17337a;
                C5029l c5029l = new C5029l();
                for (int i3 = 0; i3 < list4.size(); i3++) {
                    String b2 = ((C4752s) list4.get(i3)).m22733b();
                    switch (Integer.parseInt(((C4752s) list4.get(i3)).m22732a(), 16)) {
                        case 4:
                            c5029l.m24248b(Integer.parseInt(b2, 16));
                            break;
                        case 5:
                            c5029l = C5034i.m24274a(c5029l, b2);
                            break;
                        case 6:
                            c5029l.m24250c(Integer.parseInt(b2, 16));
                            break;
                        default:
                            break;
                    }
                }
                C2538c.c("FitnessUnTLVStatus", new Object[]{"get status:" + c5029l});
                arrayList.add(c5029l);
            }
        }
        c5028k.m24243a(arrayList);
        return c5028k;
    }
}
