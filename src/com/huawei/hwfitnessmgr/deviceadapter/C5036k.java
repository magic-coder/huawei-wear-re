package com.huawei.hwfitnessmgr.deviceadapter;

import android.annotation.SuppressLint;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwcommonmodel.p064d.C4726c;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5018a;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5020c;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5021d;
import com.huawei.p190v.C2538c;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: FitnessUnpackFrame */
public class C5036k {
    private static int m24280a(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 0;
            case 3:
                return 0;
            case 4:
            case 5:
                return 1;
            case 6:
                return 2;
            case 7:
                return 2;
            case 8:
                return 3;
            case 9:
                return 4;
            case 10:
                return 6;
            case 11:
                return 7;
            default:
                return 255;
        }
    }

    private static int m24281a(byte[] bArr) {
        return C4726c.m22617a(C4726c.m22619a(bArr[2]));
    }

    private static void m24284a(int i, int i2, int i3, C5021d c5021d) {
        c5021d.m24202d(i3);
        c5021d.m24200c(i);
        c5021d.m24198b(i2);
    }

    private static void m24283a(int i, int i2, int i3, C5020c c5020c) {
        c5020c.m24189a(i);
    }

    private static void m24287a(List<C5021d> list, List<C5020c> list2, int i, int i2, int i3, int i4, int i5, int i6) {
        if (11 == i3 || 10 == i3) {
            C5020c c5020c = new C5020c();
            c5020c.m24192b(C5036k.m24280a(i3));
            c5020c.m24190a((long) (((i2 - 1) * 60) + i));
            C5036k.m24283a(i4, i5, i6, c5020c);
            list2.add(c5020c);
            return;
        }
        C5021d c5021d = new C5021d();
        c5021d.m24196a((long) (((i2 - 1) * 60) + i));
        c5021d.m24195a(C5036k.m24280a(i3));
        C5036k.m24284a(i4, i5, i6, c5021d);
        list.add(c5021d);
    }

    @SuppressLint({"SimpleDateFormat"})
    private static boolean m24288a(List<C5021d> list, long j) {
        C5021d c5021d = (C5021d) list.get(list.size() - 1);
        if (c5021d == null) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        return !simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date(c5021d.m24194a() * 1000)));
    }

    private static void m24286a(List<C5021d> list, int i, int i2, int i3, C5021d c5021d) {
        C5021d c5021d2 = (C5021d) list.get(list.size() - 1);
        C5036k.m24284a(c5021d2.m24201d() + i, c5021d2.m24199c() + i2, c5021d2.m24203e() + i3, c5021d);
    }

    private static void m24285a(List<C5020c> list, int i, int i2, int i3, C5020c c5020c) {
        c5020c.m24189a(((C5020c) list.get(list.size() - 1)).m24191b() + i);
    }

    @SuppressLint({"SimpleDateFormat"})
    private static void m24289b(List<C5021d> list, List<C5020c> list2, int i, int i2, int i3, int i4, int i5, int i6) {
        if (11 == i3 || 10 == i3) {
            C5020c c5020c = new C5020c();
            c5020c.m24192b(C5036k.m24280a(i3));
            c5020c.m24190a((long) (((i2 - 1) * 60) + i));
            if (list2.size() >= 1) {
                C5036k.m24285a((List) list2, i4, i5, i6, c5020c);
            }
            list2.add(c5020c);
            return;
        }
        C5021d c5021d = new C5021d();
        int i7 = ((i2 - 1) * 60) + i;
        c5021d.m24196a((long) i7);
        c5021d.m24195a(C5036k.m24280a(i3));
        if (list.size() >= 1) {
            if (C5036k.m24288a(list, ((long) i7) * 1000)) {
                C5036k.m24284a(i4, i5, i6, c5021d);
            } else {
                C5036k.m24286a((List) list, i4, i5, i6, c5021d);
            }
        }
        list.add(c5021d);
    }

    public static C5018a m24282a(C4754u c4754u) {
        int i;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        C5018a c5018a = new C5018a();
        String str = "";
        List list = c4754u.f17338b;
        for (i = 0; i < list.size(); i++) {
            List list2 = ((C4754u) list.get(i)).f17337a;
            int i2 = 0;
            while (i2 < list2.size()) {
                String b;
                switch (Integer.parseInt(((C4752s) list2.get(i2)).m22732a(), 16)) {
                    case 3:
                        b = ((C4752s) list2.get(i2)).m22733b();
                        break;
                    default:
                        b = str;
                        break;
                }
                i2++;
                str = b;
            }
        }
        byte[] b2 = C0973a.b(str);
        if (b2.length < 16) {
            return c5018a;
        }
        int a = C4726c.m22618a(b2);
        c5018a.m24172a(a);
        C2538c.c("FitnessUnpackFrame", new Object[]{"unGetFrameData(),time=" + a + " date=" + new Date(((long) a) * 1000)});
        if (C5036k.m24281a(b2) == 0) {
            return c5018a;
        }
        int i3;
        int length = (b2.length - 16) / 16;
        StringBuilder stringBuilder = new StringBuilder("");
        for (i3 = 16; i3 < b2.length; i3++) {
            stringBuilder.append(C4726c.m22619a(b2[i3]));
        }
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = (i4 * 16) * 8;
            i3 = C4726c.m22617a(stringBuilder.substring(i5 + 0, i5 + 7));
            i2 = C4726c.m22617a(stringBuilder.substring(i5 + 8, i5 + 15));
            int a2 = C4726c.m22617a(stringBuilder.substring(i5 + 15, i5 + 32));
            i = C4726c.m22617a(stringBuilder.substring(i5 + 32, i5 + 56));
            int a3 = C4726c.m22617a(stringBuilder.substring(i5 + 56, i5 + 75));
            int a4 = C4726c.m22617a(stringBuilder.substring(i5 + 75, i5 + 82));
            int a5 = C4726c.m22617a(stringBuilder.substring(i5 + 83, i5 + 90));
            int a6 = C4726c.m22617a(stringBuilder.substring(i5 + 90, i5 + 101));
            int a7 = C4726c.m22617a(stringBuilder.substring(i5 + 101, i5 + SpecialIssueType.BUG_TYPE_ID_CHARGE));
            i5 = C4726c.m22617a(stringBuilder.substring(i5 + SpecialIssueType.BUG_TYPE_ID_CHARGE, i5 + 128));
            C5036k.m24287a(arrayList, arrayList2, a, i3, i2, i, a2, a3);
            if (a4 != 0) {
                C5036k.m24289b(arrayList, arrayList2, a, a4, a5, a7, a6, i5);
            }
        }
        c5018a.m24175b(arrayList);
        c5018a.m24173a(arrayList2);
        return c5018a;
    }
}
