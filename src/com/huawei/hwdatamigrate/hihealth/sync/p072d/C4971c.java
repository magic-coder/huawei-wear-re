package com.huawei.hwdatamigrate.hihealth.sync.p072d;

import android.content.Context;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4543e;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4850g;
import com.huawei.hwdatamigrate.hihealth.p067c.ae;
import com.huawei.hwdatamigrate.hihealth.p067c.aw;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;
import com.huawei.hwdatamigrate.hihealth.sync.d.m;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: HiDelCloudData */
public class C4971c {
    private static final int[] f18062a = new int[]{2004, 2001, 2015, IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_EXCEPTION, 2009, 2010, TradeCode.ALIPAY_ONE_KEY_SIGN, 2012, 2013, 2014, IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION, IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NULLPOINTEREXCEPTION};

    public static void m23893a(Context context, int i) throws h {
        C2538c.c("Debug_HiDelCloudData", new Object[]{"delHealthData who is ", Integer.valueOf(i)});
        for (int a : f18062a) {
            List a2 = C4971c.m23891a(context, i, a);
            if (a2 == null || a2.isEmpty()) {
                C2538c.c("Debug_HiDelCloudData", new Object[]{"nothing need to del,type is ", Integer.valueOf(a)});
            } else {
                Map a3 = C4971c.m23892a(context, a2);
                if (a3.isEmpty()) {
                    C2538c.d("Debug_HiDelCloudData", new Object[]{"no recordMap get ! type is ", Integer.valueOf(a)});
                } else if (C4971c.m23894a(context, a3)) {
                    C2538c.c("Debug_HiDelCloudData", new Object[]{"delHealthData OK ! type is ", Integer.valueOf(a), " ,recordMap is ", C4543e.m21779a(a3)});
                } else {
                    C2538c.d("Debug_HiDelCloudData", new Object[]{"delHealthData failed ! type is ", Integer.valueOf(a), " ,recordMap is ", C4543e.m21779a(a3)});
                }
            }
        }
    }

    private static List<HiHealthData> m23891a(Context context, int i, int i2) {
        List d = C4850g.m23559a(context).m23566d(i);
        if (d != null && !d.isEmpty()) {
            return aw.m23483a(context).m23486a(i2, 2, d);
        }
        C2538c.d("Debug_HiDelCloudData", new Object[]{"no clientIDs get , who is ", Integer.valueOf(i)});
        return null;
    }

    private static Map<Long, String> m23892a(Context context, List<HiHealthData> list) {
        Map<Long, String> hashMap = new HashMap();
        for (HiHealthData hiHealthData : list) {
            g e = C4850g.m23559a(context).m23567e(hiHealthData.getClientID());
            int a;
            if (e == null) {
                C2538c.d("Debug_HiDelCloudData", new Object[]{"createDelMap,nothing need to del ,no healthContext,clientId is ", Integer.valueOf(a)});
            } else {
                long g = e.g();
                if (g <= 0) {
                    C2538c.d("Debug_HiDelCloudData", new Object[]{"createDelMap,nothing need to del ,no deviceCode,clientId is ", Integer.valueOf(a)});
                } else {
                    a = C4976k.m23905a(hiHealthData.getType());
                    if (a <= 0) {
                        C2538c.d("Debug_HiDelCloudData", new Object[]{"createDelMap , error type no such type can delete ,type is ", Integer.valueOf(hiHealthData.getType())});
                    } else {
                        hashMap.put(Long.valueOf(hiHealthData.getDataID()), C4972d.m23895a(g, a, hiHealthData.getStartTime()));
                    }
                }
            }
        }
        return hashMap;
    }

    private static boolean m23894a(Context context, Map<Long, String> map) throws h {
        int size = map.size();
        long[] jArr = new long[size];
        String[] strArr = new String[size];
        int i = 0;
        for (Entry entry : map.entrySet()) {
            long longValue = ((Long) entry.getKey()).longValue();
            String str = (String) entry.getValue();
            jArr[i] = longValue;
            strArr[i] = str;
            i++;
        }
        if (!m.a(context, strArr)) {
            return false;
        }
        ae.m23430a(context).m23441a(jArr);
        return true;
    }
}
