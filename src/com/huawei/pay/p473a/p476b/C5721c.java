package com.huawei.pay.p473a.p476b;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: PermissionsUtil */
public class C5721c {
    public static final HashMap<String, Integer> f19500a = new C5722d();

    public static int[] m26378a(Map<String, Integer> map) {
        int[] iArr = new int[map.size()];
        int i = 0;
        for (Entry value : map.entrySet()) {
            int i2 = i + 1;
            iArr[i] = ((Integer) value.getValue()).intValue();
            i = i2;
        }
        return iArr;
    }

    public static String[] m26379b(Map<String, Integer> map) {
        List arrayList = new ArrayList();
        for (Entry entry : map.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == -1) {
                arrayList.add(entry.getKey());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static Map<String, Integer> m26374a(Context context, String... strArr) {
        Map<String, Integer> linkedHashMap = new LinkedHashMap();
        for (String str : strArr) {
            if (C5721c.m26377a(context, str)) {
                linkedHashMap.put(str, Integer.valueOf(0));
            } else {
                linkedHashMap.put(str, Integer.valueOf(-1));
            }
        }
        return linkedHashMap;
    }

    public static Map<String, Integer> m26373a(Context context, Map<String, Integer> map) {
        for (String str : map.keySet()) {
            if (C5721c.m26377a(context, str)) {
                map.put(str, Integer.valueOf(0));
            } else {
                map.put(str, Integer.valueOf(-1));
            }
        }
        return map;
    }

    public static boolean m26377a(Context context, String str) {
        if (VERSION.SDK_INT >= 23 && context.checkSelfPermission(str) != 0) {
            return false;
        }
        return true;
    }

    public static boolean m26376a(Activity activity, String[] strArr) {
        boolean z = true;
        if (strArr != null) {
            for (String shouldShowRequestPermissionRationale : strArr) {
                if (!activity.shouldShowRequestPermissionRationale(shouldShowRequestPermissionRationale)) {
                    z = false;
                }
            }
        }
        return z;
    }

    public static void m26375a(Activity activity, int i, String[] strArr) {
        activity.requestPermissions(strArr, i);
    }
}
