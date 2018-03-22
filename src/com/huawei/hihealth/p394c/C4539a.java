package com.huawei.hihealth.p394c;

import android.content.Context;
import android.provider.Settings.Secure;
import java.util.List;

/* compiled from: HiCommonUtil */
public class C4539a {
    public static String m21747a(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public static boolean m21748a(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean m21749a(List list) {
        return list == null || list.isEmpty();
    }
}
