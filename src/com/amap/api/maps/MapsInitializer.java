package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import com.amap.api.mapcore.as;
import com.amap.api.mapcore.util.bn;

public final class MapsInitializer {
    private static boolean f11982a = true;
    public static String sdcardDir = "";

    public static void initialize(Context context) throws RemoteException {
        as.f10925a = context.getApplicationContext();
    }

    public static void setNetWorkEnable(boolean z) {
        f11982a = z;
    }

    public static boolean getNetWorkEnable() {
        return f11982a;
    }

    public static void setApiKey(String str) {
        if (str != null && str.trim().length() > 0) {
            bn.m15694a(str);
        }
    }

    public static String getVersion() {
        return "3.2.0.1";
    }
}
