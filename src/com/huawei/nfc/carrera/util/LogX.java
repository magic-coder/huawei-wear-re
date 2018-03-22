package com.huawei.nfc.carrera.util;

import com.huawei.p190v.C2538c;
import java.util.Map;

public final class LogX {
    private static final int CALL_LOG_LEVEL = 3;
    private static final String LOG_HWNFC_TAG = "PluginPay";

    private LogX() {
    }

    public static void m5466d(String str, String str2) {
        C2538c.m12674b(str, str2, Boolean.valueOf(false));
    }

    public static void m5465d(String str) {
        C2538c.m12674b(LOG_HWNFC_TAG, str, Boolean.valueOf(false));
    }

    public static void m5467d(String str, boolean z) {
        C2538c.m12674b(LOG_HWNFC_TAG, str, Boolean.valueOf(z));
    }

    public static void m5476i(String str, String str2) {
        C2538c.m12677c(str, str2, Boolean.valueOf(false));
    }

    public static void m5475i(String str) {
        C2538c.m12677c(LOG_HWNFC_TAG, str, Boolean.valueOf(false));
    }

    public static void m5477i(String str, boolean z) {
        C2538c.m12677c(LOG_HWNFC_TAG, str, Boolean.valueOf(z));
    }

    public static void m5479w(String str, String str2) {
        C2538c.m12680e(str, str2, null, Boolean.valueOf(false));
    }

    public static void m5478w(String str) {
        C2538c.m12680e(LOG_HWNFC_TAG, str, null, Boolean.valueOf(false));
    }

    public static void m5483w(String str, boolean z) {
        C2538c.m12680e(LOG_HWNFC_TAG, str, null, Boolean.valueOf(z));
    }

    public static void m5480w(String str, String str2, Throwable th) {
        C2538c.m12680e(str, str2, th, Boolean.valueOf(false));
    }

    public static void m5481w(String str, Throwable th) {
        C2538c.m12680e(LOG_HWNFC_TAG, str, th, Boolean.valueOf(false));
    }

    public static void m5482w(String str, Throwable th, boolean z) {
        C2538c.m12680e(LOG_HWNFC_TAG, str, th, Boolean.valueOf(z));
    }

    public static void m5470e(String str, String str2) {
        C2538c.m12680e(LOG_HWNFC_TAG, str2, null, Boolean.valueOf(false));
    }

    public static void m5469e(String str) {
        C2538c.m12680e(LOG_HWNFC_TAG, str, null, Boolean.valueOf(false));
    }

    public static void m5474e(String str, boolean z) {
        C2538c.m12680e(LOG_HWNFC_TAG, str, null, Boolean.valueOf(z));
    }

    public static void m5468e(int i, Map<String, String> map, String str, boolean z, boolean z2) {
        m5474e(str, z2);
    }

    public static void m5471e(String str, String str2, Throwable th) {
        C2538c.m12680e(LOG_HWNFC_TAG, str2, th, Boolean.valueOf(false));
    }

    public static void m5472e(String str, Throwable th) {
        C2538c.m12680e(LOG_HWNFC_TAG, str, th, Boolean.valueOf(false));
    }

    public static void m5473e(String str, Throwable th, boolean z) {
        C2538c.m12680e(LOG_HWNFC_TAG, str, th, Boolean.valueOf(z));
    }
}
