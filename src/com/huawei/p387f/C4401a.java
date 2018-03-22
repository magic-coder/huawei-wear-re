package com.huawei.p387f;

import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.huawei.datatype.SportType;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: AbnormalTrackUtil */
public class C4401a {
    public static int m21099a(int i, Map<Integer, Float> map, float f) {
        int i2;
        if (C4401a.m21101a(i)) {
            if (f < BitmapDescriptorFactory.HUE_GREEN) {
                C2538c.c("Track_AbnormalTrackUtil", new Object[]{"avgPace ,checkAbnormalTrack result is ", Integer.valueOf(1)});
                return 1;
            }
            Map b = C4401a.m21103b(map);
            if (b != null && b.size() > 0) {
                C2538c.c("Track_AbnormalTrackUtil", new Object[]{"checkAbnormalTrack abnormal is ", Integer.valueOf(C4401a.m21100a(b)), " ,distance is ", Integer.valueOf(b.size())});
                if (C4401a.m21102a(C4401a.m21100a(b), b.size())) {
                    i2 = 1;
                    C2538c.c("Track_AbnormalTrackUtil", new Object[]{"checkAbnormalTrack result is ", Integer.valueOf(i2)});
                    return i2;
                }
            }
        }
        i2 = 0;
        C2538c.c("Track_AbnormalTrackUtil", new Object[]{"checkAbnormalTrack result is ", Integer.valueOf(i2)});
        return i2;
    }

    private static boolean m21102a(int i, int i2) {
        if (i == 1) {
            if (i2 < 5) {
                return true;
            }
        } else if (i > 1) {
            return true;
        }
        return false;
    }

    private static boolean m21101a(int i) {
        return i == SportType.SPORT_TYPE_TREADMILL || i == SportType.SPORT_TYPE_RUN || i == 257;
    }

    private static int m21100a(Map<Integer, Float> map) {
        int i = 0;
        for (Entry value : map.entrySet()) {
            int i2;
            if (((Float) value.getValue()).floatValue() < BitmapDescriptorFactory.HUE_GREEN) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    private static Map<Integer, Float> m21103b(Map<Integer, Float> map) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Map<Integer, Float> treeMap = new TreeMap();
        if (map == null) {
            C2538c.b("Track_AbnormalTrackUtil", new Object[]{"paceMap is null"});
            return null;
        }
        for (Entry entry : map.entrySet()) {
            treeMap.put(entry.getKey(), entry.getValue());
            int intValue = ((Integer) entry.getKey()).intValue();
            if (intValue >= 100000) {
                int i = intValue / 100000;
                if (i % 100 != 0) {
                    if (!arrayList2.contains(Integer.valueOf(intValue))) {
                        arrayList2.add(Integer.valueOf(intValue));
                    }
                } else if (arrayList.contains(Integer.valueOf(i / 100))) {
                    arrayList2.add(Integer.valueOf(intValue));
                } else {
                    arrayList.add(Integer.valueOf(i / 100));
                }
            } else if (!arrayList2.contains(Integer.valueOf(intValue))) {
                arrayList2.add(Integer.valueOf(intValue));
            }
        }
        for (intValue = 0; intValue < arrayList2.size(); intValue++) {
            if (treeMap.containsKey(arrayList2.get(intValue))) {
                treeMap.remove(arrayList2.get(intValue));
            }
        }
        return treeMap;
    }
}
