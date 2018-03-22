package com.huawei.hwdevicedfxmanager.utils;

import com.huawei.hwservicesmgr.datetype.C5361c;
import com.huawei.hwservicesmgr.datetype.C5364f;
import com.huawei.p190v.C2538c;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailGPSWorkoutUtil {
    private static String TAG = "DetailGPSWorkoutUtil";
    private static DetailGPSWorkoutUtil instance;

    public static DetailGPSWorkoutUtil getMainInstance() {
        if (instance == null) {
            instance = new DetailGPSWorkoutUtil();
        }
        return instance;
    }

    private DetailGPSWorkoutUtil() {
        C2538c.c(TAG, new Object[]{"DetailGPSWorkoutUtil"});
    }

    public int getGPSMapType(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            C2538c.e(TAG, new Object[]{"getGPSMap e = " + e.getMessage()});
        }
        String substring = stringBuilder.substring(0, 64);
        C2538c.c(TAG, new Object[]{"getFileGPSMap info = " + substring});
        if (Integer.parseInt(substring.substring(24, 28), 16) > 1) {
            return Integer.parseInt(substring.substring(28, 30), 16);
        }
        return -1;
    }

    public Map<Long, double[]> getGPSMap(byte[] bArr, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            C2538c.e(TAG, new Object[]{"getGPSMap e = " + e.getMessage()});
        }
        C2538c.c(TAG, new Object[]{"getGPSMap sb = " + stringBuilder.toString()});
        return getFileGPSMap(stringBuilder.toString(), i);
    }

    private Map<Long, double[]> getFileGPSMap(String str, int i) {
        Map<Long, double[]> hashMap = new HashMap();
        while (str.length() > 0) {
            String substring;
            String substring2 = str.substring(0, 64);
            C2538c.c(TAG, new Object[]{"getFileGPSMap info = " + substring2});
            C5364f gPSFrameHeader = getGPSFrameHeader(substring2);
            String substring3 = str.substring(substring2.length(), str.length());
            C2538c.c(TAG, new Object[]{"getFileGPSMap sb = " + substring3});
            if (-1 != i) {
                substring = substring3.substring(0, gPSFrameHeader.m25836a() * 2);
            } else {
                substring = substring3.substring(0, gPSFrameHeader.m25836a() * 26);
            }
            C2538c.c(TAG, new Object[]{"getFileGPSMap info = " + substring});
            List gPSOffsetData = getGPSOffsetData(substring, gPSFrameHeader.m25838b());
            for (int i2 = 0; i2 < gPSOffsetData.size(); i2++) {
                hashMap.put(Long.valueOf(((C5361c) gPSOffsetData.get(i2)).m25822a()), ((C5361c) gPSOffsetData.get(i2)).m25825b());
            }
            str = substring3.substring(substring.length(), substring3.length());
        }
        return hashMap;
    }

    private C5364f getGPSFrameHeader(String str) {
        C5364f c5364f = new C5364f();
        c5364f.m25837a(Integer.parseInt(str.substring(0, 16), 16));
        c5364f.m25839b(Integer.parseInt(str.substring(16, 20), 16));
        c5364f.m25840c(Integer.parseInt(str.substring(20, 24), 16));
        c5364f.m25841d(Integer.parseInt(str.substring(24, 28), 16));
        return c5364f;
    }

    private List<C5361c> getGPSOffsetData(String str, int i) {
        List<C5361c> arrayList = new ArrayList();
        for (int i2 = 0; i2 < str.length() / 26; i2++) {
            Object obj = 1;
            Object obj2 = 1;
            double[] dArr = new double[4];
            C5361c c5361c = new C5361c();
            String substring = str.substring(i2 * 26, (i2 + 1) * 26);
            C2538c.c(TAG, new Object[]{"getGPSOffsetData() offsetData = " + substring + " version = " + i});
            double parseLong = ((double) Long.parseLong(substring.substring(0, 10), 16)) / 1.6777216E7d;
            double parseLong2 = ((double) Long.parseLong(substring.substring(10, 18), 16)) / 1.6777216E7d;
            if (i != 0) {
                if (0.0d > parseLong || 360.0d < parseLong) {
                    obj = null;
                } else {
                    parseLong -= 180.0d;
                }
                if (0.0d > parseLong2 || 180.0d < parseLong2) {
                    obj2 = null;
                } else {
                    parseLong2 -= 90.0d;
                }
            }
            parseLong2 = new BigDecimal(parseLong2).setScale(7, 4).doubleValue();
            parseLong = new BigDecimal(parseLong).setScale(7, 4).doubleValue();
            dArr[0] = parseLong2;
            dArr[1] = parseLong;
            dArr[2] = 0.0d;
            dArr[3] = (double) (Long.parseLong(substring.substring(18, 26), 16) * 1000);
            c5361c.m25823a((long) i2);
            c5361c.m25824a(dArr);
            C2538c.c(TAG, new Object[]{"getGPSOffsetData() lon = " + parseLong + " lat = " + parseLong2 + " time = " + r12 + " i = " + i2});
            if (!(obj2 == null || r8 == null)) {
                arrayList.add(c5361c);
            }
        }
        return arrayList;
    }
}
