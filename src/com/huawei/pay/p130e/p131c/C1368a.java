package com.huawei.pay.p130e.p131c;

import com.huawei.feedback.bean.MetadataBundle;
import com.huawei.wallet.utils.log.LogUtil;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: LogC */
public class C1368a {
    public static void m6084a(String str, String str2, boolean z) {
        LogUtil.b(str, str2, z);
    }

    public static void m6088b(String str, String str2, boolean z) {
        LogUtil.a(str, str2, null, z);
    }

    public static void m6087a(String str, boolean z) {
        LogUtil.a("PluginPay", str, z);
    }

    public static void m6089b(String str, boolean z) {
        LogUtil.b("PluginPay", str, z);
    }

    public static void m6090c(String str, boolean z) {
        LogUtil.a("PluginPay", str, null, z);
    }

    public static void m6091d(String str, boolean z) {
        LogUtil.a("PluginPay", str, null, z);
    }

    public static void m6086a(String str, Throwable th, boolean z) {
        LogUtil.a("PluginPay", str, null, z);
    }

    public static void m6083a(String str, int i, Map<String, String> map, boolean z) {
        C1368a.m6085a(str, null, i, map, false, z);
    }

    public static void m6085a(String str, Throwable th, int i, Map<String, String> map, boolean z, boolean z2) {
        MetadataBundle a = LogUtil.a(i);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                a.putData((String) entry.getKey(), (String) entry.getValue());
            }
        }
        LogUtil.a("PluginPay", str, th, i, a, z2, z);
    }
}
