package com.huawei.appmarket.p348a.p351c;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.appmarket.C4234a;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.foundation.p367e.C4288e;
import java.io.File;
import java.util.regex.Pattern;

public class C4215a {
    public static final String m20476a(Context context) {
        return context.getPackageName() + ".action.SELF_UPGRADE";
    }

    public static void m20477a() {
        C4241a.m20529a("PackageUtils", "enableBroadcastReceiver");
        C4234a.m20519a().m20523b();
    }

    public static boolean m20478a(String str) {
        if (C4288e.m20695a(str)) {
            return false;
        }
        if (!Pattern.compile("(\\.)+[\\\\/]+").matcher(str).find()) {
            return new File(str).delete();
        }
        C4241a.m20529a("PackageUtils", "remov APK fail. the apk path is not valid");
        return false;
    }

    public static void m20479b() {
        C4241a.m20529a("PackageUtils", "disableBroadcastReceiver");
        C4234a.m20519a().m20523b();
    }

    public static void m20480b(Context context) {
        Intent intent = new Intent();
        intent.setAction(C4215a.m20476a(context));
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context);
        if (instance != null) {
            instance.sendBroadcast(intent);
        }
    }
}
