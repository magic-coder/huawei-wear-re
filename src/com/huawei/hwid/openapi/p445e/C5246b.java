package com.huawei.hwid.openapi.p445e;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hwid.openapi.p445e.p446a.C5241c;

public class C5246b {
    public static SharedPreferences m25435a(Context context) {
        return context.getSharedPreferences("hwid_opensdk_config", 0);
    }

    public static void m25436a(Context context, String str) {
        C5246b.m25435a(context).edit().remove(C5241c.m25414a(context, str)).commit();
    }

    public static void m25437a(Context context, String str, String str2) {
        C5246b.m25435a(context).edit().putString(C5241c.m25414a(context, str), C5241c.m25414a(context, str2)).commit();
    }

    public static String m25438b(Context context, String str, String str2) {
        return C5241c.m25416b(context, C5246b.m25435a(context).getString(C5241c.m25414a(context, str), str2));
    }
}
