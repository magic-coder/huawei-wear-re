package com.huawei.hwfitnessmgr.deviceadapter;

import com.huawei.datatype.FitnessUserInfo;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwcommonmodel.fitnessdatatype.DataTotalMotion;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetectRet;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5023f;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: FitnessUnTLVUtil */
public class C5035j {
    public static int[] m24276a(C4754u c4754u) {
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

    public static C5023f m24277b(C4754u c4754u) {
        C5023f c5023f = new C5023f();
        List list = c4754u.f17338b;
        for (int i = 0; i < list.size(); i++) {
            int i2;
            C4754u c4754u2 = (C4754u) list.get(i);
            List list2 = c4754u2.f17337a;
            for (i2 = 0; i2 < list2.size(); i2++) {
                switch (Integer.parseInt(((C4752s) list2.get(i2)).m22732a(), 16)) {
                    case 2:
                        c5023f.m24209a(Integer.parseInt(((C4752s) list2.get(i2)).m22733b(), 16));
                        break;
                    case 9:
                        HeartRateDetectRet heartRateDetectRet = new HeartRateDetectRet();
                        String b = ((C4752s) list2.get(i2)).m22733b();
                        C2538c.c("FitnessUnTLVUtil", new Object[]{"unTlv HeartRateDetectRet value:" + b});
                        if (b.length() == 10) {
                            heartRateDetectRet.setTimeStamp((long) Integer.parseInt(b.substring(0, 8), 16));
                            heartRateDetectRet.setHeartRate(Integer.parseInt(b.substring(8, 10), 16));
                        }
                        c5023f.m24210a(heartRateDetectRet);
                        break;
                    default:
                        break;
                }
            }
            list2 = c4754u2.f17338b;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                List list3 = ((C4754u) list2.get(i3)).f17337a;
                DataTotalMotion dataTotalMotion = new DataTotalMotion();
                for (i2 = 0; i2 < list3.size(); i2++) {
                    switch (Integer.parseInt(((C4752s) list3.get(i2)).m22732a(), 16)) {
                        case 4:
                            dataTotalMotion.setMotion_type(Integer.parseInt(((C4752s) list3.get(i2)).m22733b(), 16));
                            break;
                        case 5:
                            dataTotalMotion.setStep(Integer.parseInt(((C4752s) list3.get(i2)).m22733b(), 16));
                            break;
                        case 6:
                            dataTotalMotion.setCalorie(Integer.parseInt(((C4752s) list3.get(i2)).m22733b(), 16));
                            break;
                        case 7:
                            dataTotalMotion.setDistance(Integer.parseInt(((C4752s) list3.get(i2)).m22733b(), 16));
                            break;
                        case 8:
                            dataTotalMotion.setSleep_time(Integer.parseInt(((C4752s) list3.get(i2)).m22733b(), 16));
                            break;
                        case 10:
                            dataTotalMotion.setHeight(Integer.parseInt(((C4752s) list3.get(i2)).m22733b(), 16));
                            break;
                        default:
                            break;
                    }
                }
                c5023f.m24212b().add(dataTotalMotion);
            }
        }
        return c5023f;
    }

    public static int m24278c(C4754u c4754u) {
        List list = c4754u.f17337a;
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int parseInt;
            String b = ((C4752s) list.get(i)).m22733b();
            switch (Integer.parseInt(((C4752s) list.get(i)).m22732a(), 16)) {
                case 1:
                    parseInt = Integer.parseInt(b, 16);
                    break;
                default:
                    parseInt = i2;
                    break;
            }
            i++;
            i2 = parseInt;
        }
        return i2;
    }

    public static FitnessUserInfo m24279d(C4754u c4754u) {
        FitnessUserInfo fitnessUserInfo = new FitnessUserInfo();
        for (C4754u c4754u2 : c4754u.f17338b) {
            List list = c4754u2.f17337a;
            for (int i = 0; i < list.size(); i++) {
                String b = ((C4752s) list.get(i)).m22733b();
                switch (Integer.parseInt(((C4752s) list.get(i)).m22732a(), 16)) {
                    case 2:
                        fitnessUserInfo.setTime(Long.parseLong(b, 16));
                        break;
                    case 3:
                        fitnessUserInfo.setHeight(Integer.parseInt(b, 16));
                        break;
                    case 4:
                        fitnessUserInfo.setWeight(Integer.parseInt(b, 16));
                        break;
                    default:
                        break;
                }
            }
        }
        return fitnessUserInfo;
    }
}
