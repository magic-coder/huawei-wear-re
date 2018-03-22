package com.huawei.hihealth.p394c;

import android.content.Context;
import android.util.SparseArray;
import com.huawei.hihealth.HiDataInsertOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.p190v.C2538c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HiDivideUtil */
public class C4541c {
    public static boolean m21771a(List<HiHealthData> list, int i, List<HiHealthData> list2) {
        if (!C4539a.m21749a((List) list)) {
            list2.addAll(list);
        }
        return i == 2;
    }

    public static boolean m21770a(List<HiHealthData> list, int i, int i2, List<HiHealthData> list2, SparseArray<List<HiHealthData>> sparseArray) {
        boolean z = true;
        if (!C4539a.m21749a((List) list)) {
            list2.addAll(list);
        }
        if (i2 != 1) {
            if (i2 != 2) {
                z = false;
            }
            return z;
        } else if (C4539a.m21749a((List) list2)) {
            return false;
        } else {
            C4541c.m21766a((SparseArray) sparseArray, (List) list2, i);
            return false;
        }
    }

    public static boolean m21769a(Context context, List<HiHealthData> list, int i, int i2, List<HiHealthData> list2, SparseArray<List<HiHealthData>> sparseArray) {
        switch (i) {
            case PayStatusCodes.PAY_STATE_PARAM_ERROR /*30001*/:
            case 30003:
                C4541c.m21772b(context, list, i, i2, list2, sparseArray);
                return false;
            default:
                return C4541c.m21770a(list, i, i2, list2, sparseArray);
        }
    }

    private static void m21772b(Context context, List<HiHealthData> list, int i, int i2, List<HiHealthData> list2, SparseArray<List<HiHealthData>> sparseArray) {
        HiHealthData hiHealthData;
        String str;
        if (C4539a.m21749a((List) list2)) {
            hiHealthData = null;
            str = null;
        } else {
            HiHealthData hiHealthData2 = (HiHealthData) list2.get(0);
            HiHealthData hiHealthData3 = hiHealthData2;
            str = hiHealthData2.getSequenceData();
            hiHealthData = hiHealthData3;
        }
        if (!C4539a.m21749a((List) list)) {
            if (hiHealthData == null) {
                hiHealthData2 = (HiHealthData) list.get(0);
                list2.add(hiHealthData2);
                hiHealthData = hiHealthData2;
            } else {
                hiHealthData.setSequenceData(str + ((HiHealthData) list.get(0)).getSequenceData());
            }
        }
        if (hiHealthData == null) {
            C2538c.d("HiH_HiDivideUtil", new Object[]{"packageSequenceDivideData data is null"});
        } else if (i2 == 1 && !C4539a.m21749a((List) list2)) {
            try {
                String b = C4545g.m21791b(hiHealthData.getSequenceData());
                if (i == 30003) {
                    str = "HiTrack_" + Long.toString(hiHealthData.getStartTime()) + hiHealthData.getEndTime() + PayStatusCodes.PAY_STATE_PARAM_ERROR;
                    if (!C4542d.m21776a(context, b, str)) {
                        str = null;
                    }
                    hiHealthData.setSequenceData(null);
                    hiHealthData.setSequenceFileUrl(str);
                } else {
                    hiHealthData.setSequenceData(b);
                }
                C4541c.m21766a((SparseArray) sparseArray, (List) list2, i);
            } catch (IOException e) {
                C2538c.e("HiH_HiDivideUtil", new Object[]{"packageSequenceDivideData uncompress e = ", e.getMessage()});
            }
        }
    }

    public static List<HiDataInsertOption> m21765a(HiDataInsertOption hiDataInsertOption) {
        List datas = hiDataInsertOption.getDatas();
        List arrayList = new ArrayList();
        if (C4539a.m21749a(datas)) {
            arrayList.add(hiDataInsertOption);
            return arrayList;
        }
        switch (((HiHealthData) datas.get(0)).getType()) {
            case PayStatusCodes.PAY_STATE_PARAM_ERROR /*30001*/:
                C4541c.m21768a(datas, arrayList, hiDataInsertOption.getWriteStatType());
                break;
            default:
                C4541c.m21773b(datas, arrayList, hiDataInsertOption.getWriteStatType());
                break;
        }
        return arrayList;
    }

    private static void m21768a(List<HiHealthData> list, List<HiDataInsertOption> list2, int i) {
        String str = "";
        for (HiHealthData hiHealthData : list) {
            try {
                str = C4545g.m21790a(hiHealthData.getSequenceData());
            } catch (IOException e) {
                C2538c.d("HiH_HiDivideUtil", new Object[]{"divideInsertSequence e = ", e.getMessage()});
            }
            int length = str.length();
            C2538c.c("HiH_HiDivideUtil", new Object[]{"divideInsertSequence compressed = ", Integer.valueOf(length), ", original size = ", Integer.valueOf(hiHealthData.getSequenceData().length())});
            hiHealthData.putBoolean("is_sequence_zip", true);
            if (length <= 0) {
                C4541c.m21767a((List) list2, hiHealthData, i);
            } else {
                for (int i2 = 0; i2 < length; i2 += 262144) {
                    if (262144 + i2 >= length) {
                        hiHealthData.setSequenceData(str.substring(i2, length));
                        hiHealthData.putBoolean("is_dividing", false);
                        C4541c.m21767a((List) list2, hiHealthData, i);
                        C2538c.c("HiH_HiDivideUtil", new Object[]{"divideInsertSequence finally index is ", Integer.valueOf(i2), ",track size is ", Integer.valueOf(hiHealthData.getSequenceData().length())});
                    } else {
                        hiHealthData.setSequenceData(str.substring(i2, 262144 + i2));
                        hiHealthData.putBoolean("is_dividing", true);
                        C4541c.m21767a((List) list2, hiHealthData, i);
                        C2538c.c("HiH_HiDivideUtil", new Object[]{"divideInsertSequence process index is ", Integer.valueOf(i2), ",track size is ", Integer.valueOf(hiHealthData.getSequenceData().length())});
                    }
                }
            }
        }
        C2538c.c("HiH_HiDivideUtil", new Object[]{"divideInsertSequence datas size = ", Integer.valueOf(list.size()), ", options size = ", Integer.valueOf(list2.size())});
    }

    private static void m21773b(List<HiHealthData> list, List<HiDataInsertOption> list2, int i) {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            if (i2 + 500 >= size) {
                C4541c.m21774c(list2, list.subList(i2, size), i);
                i2 += 500;
            } else {
                int i3 = i2 + 500;
                C4541c.m21774c(list2, list.subList(i2, i3), i);
                i2 = i3;
            }
        }
        C2538c.c("HiH_HiDivideUtil", new Object[]{"divideInsertOther datas size = ", Integer.valueOf(size), ", options size = ", Integer.valueOf(list2.size())});
    }

    private static void m21766a(SparseArray<List<HiHealthData>> sparseArray, List<HiHealthData> list, int i) {
        List arrayList = new ArrayList();
        arrayList.addAll(list);
        sparseArray.append(i, arrayList);
        list.clear();
    }

    private static void m21767a(List<HiDataInsertOption> list, HiHealthData hiHealthData, int i) {
        HiDataInsertOption hiDataInsertOption = new HiDataInsertOption();
        hiDataInsertOption.setWriteStatType(i);
        hiDataInsertOption.addData(hiHealthData.copyData());
        list.add(hiDataInsertOption);
    }

    private static void m21774c(List<HiDataInsertOption> list, List<HiHealthData> list2, int i) {
        HiDataInsertOption hiDataInsertOption = new HiDataInsertOption();
        hiDataInsertOption.setWriteStatType(i);
        hiDataInsertOption.setDatas(list2);
        list.add(hiDataInsertOption);
    }
}
