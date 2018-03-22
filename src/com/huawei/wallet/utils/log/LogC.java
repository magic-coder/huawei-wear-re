package com.huawei.wallet.utils.log;

import com.huawei.feedback.bean.MetadataBundle;
import java.util.Map;
import java.util.Map.Entry;

public class LogC {
    public static void m28524a(String str, String str2, boolean z) {
        LogUtil.m28541a(str, str2, z);
    }

    public static void m28528b(String str, String str2, boolean z) {
        LogUtil.m28544b(str, str2, z);
    }

    public static void m28531c(String str, String str2, boolean z) {
        LogUtil.m28540a(str, str2, null, z);
    }

    public static void m28523a(String str, String str2, Throwable th, boolean z) {
        LogUtil.m28540a(str, str2, th, z);
    }

    public static void m28533d(String str, String str2, boolean z) {
        LogUtil.m28540a(str, str2, null, z);
    }

    public static void m28527a(String str, boolean z) {
        LogUtil.m28541a("baselib", str, z);
    }

    public static void m28530b(String str, boolean z) {
        LogUtil.m28544b("baselib", str, z);
    }

    public static void m28532c(String str, boolean z) {
        LogUtil.m28540a("baselib", str, null, z);
    }

    public static void m28526a(String str, Throwable th, boolean z) {
        LogUtil.m28540a("baselib", str, th, z);
    }

    public static void m28534d(String str, boolean z) {
        LogUtil.m28540a("baselib", str, null, z);
    }

    public static void m28529b(String str, Throwable th, boolean z) {
        LogUtil.m28540a("baselib", str, th, z);
    }

    public static void m28522a(String str, int i, Map<String, String> map, boolean z) {
        m28525a(str, null, i, map, false, z);
    }

    public static void m28525a(String str, Throwable th, int i, Map<String, String> map, boolean z, boolean z2) {
        MetadataBundle a = LogUtil.m28536a(i);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                a.putData((String) entry.getKey(), (String) entry.getValue());
            }
        }
        LogUtil.m28539a("baselib", str, th, i, a, z2, z);
    }
}
