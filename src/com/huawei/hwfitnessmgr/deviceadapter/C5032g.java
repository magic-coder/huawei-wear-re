package com.huawei.hwfitnessmgr.deviceadapter;

import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5018a;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5019b;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5022e;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FitnessUnTLVData */
public class C5032g {
    public static C5022e m24266a(C4754u c4754u) {
        C5022e c5022e = new C5022e();
        List arrayList = new ArrayList();
        List list = c4754u.f17338b;
        for (int i = 0; i < list.size(); i++) {
            List list2 = ((C4754u) list.get(i)).f17337a;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                String b = ((C4752s) list2.get(i2)).m22733b();
                switch (Integer.parseInt(((C4752s) list2.get(i2)).m22732a(), 16)) {
                    case 2:
                        c5022e.m24205a(Integer.parseInt(b, 16));
                        break;
                    case 5:
                        arrayList.add(Integer.valueOf(Integer.parseInt(b, 16)));
                        break;
                    default:
                        break;
                }
            }
        }
        c5022e.m24206a(arrayList);
        return c5022e;
    }

    public static C5018a m24267b(C4754u c4754u) {
        return C5036k.m24282a(c4754u);
    }

    public static List<C5019b> m24268c(C4754u c4754u) {
        List<C5019b> arrayList = new ArrayList();
        List list = c4754u.f17338b;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < list.size()) {
            List list2 = c4754u.f17338b;
            int i4 = i;
            i = i2;
            for (int i5 = 0; i5 < list2.size(); i5++) {
                int i6;
                List list3 = ((C4754u) list2.get(i5)).f17337a;
                for (i6 = 0; i6 < list3.size(); i6++) {
                    String b = ((C4752s) list3.get(i6)).m22733b();
                    switch (Integer.parseInt(((C4752s) list3.get(i6)).m22732a(), 16)) {
                        case 4:
                            i4 = Integer.parseInt(b, 16);
                            break;
                        case 5:
                            i = Integer.parseInt(b, 16);
                            break;
                        default:
                            break;
                    }
                }
                List list4 = ((C4754u) list2.get(i5)).f17338b;
                for (i6 = 0; i6 < list4.size(); i6++) {
                    C5019b c5019b = new C5019b();
                    List list5 = ((C4754u) list4.get(i6)).f17337a;
                    for (int i7 = 0; i7 < list5.size(); i7++) {
                        String b2 = ((C4752s) list5.get(i7)).m22733b();
                        switch (Integer.parseInt(((C4752s) list5.get(i7)).m22732a(), 16)) {
                            case 7:
                                c5019b.m24186e((((Integer.parseInt(b2, 16) - 1) * i) * 60) + i4);
                                break;
                            case 8:
                                c5019b.m24178a(C5031f.m24265a(Integer.parseInt(b2, 16)));
                                break;
                            case 9:
                                c5019b.m24180b(Integer.parseInt(b2, 16));
                                break;
                            case 10:
                                c5019b.m24182c(Integer.parseInt(b2, 16));
                                break;
                            case 11:
                                c5019b.m24184d(Integer.parseInt(b2, 16));
                                break;
                            default:
                                break;
                        }
                    }
                    if (c5019b.m24177a() != 0) {
                        C2538c.c("FitnessUnTLVUtil", new Object[]{"type=" + c5019b.m24177a() + " step= " + c5019b.m24179b() + " cal=" + c5019b.m24181c() + " dis=" + c5019b.m24183d()});
                        arrayList.add(c5019b);
                    }
                }
            }
            i3++;
            i2 = i;
            i = i4;
        }
        return arrayList;
    }
}
