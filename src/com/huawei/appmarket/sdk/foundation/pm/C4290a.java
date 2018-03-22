package com.huawei.appmarket.sdk.foundation.pm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;

public class C4290a {
    private static byte[] f15971a = new byte[0];

    public static PackageInfo m20698a(String str, Context context) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (NameNotFoundException e) {
            C4241a.m20532b("PackageKit", "not found: " + str);
            return null;
        }
    }
}
