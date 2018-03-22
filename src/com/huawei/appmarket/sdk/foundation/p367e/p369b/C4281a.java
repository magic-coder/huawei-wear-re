package com.huawei.appmarket.sdk.foundation.p367e.p369b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.support.v4.util.ArrayMap;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.service.p372b.C4292a;
import java.util.Map;

public class C4281a {
    private static Map<String, Object> f15959a = new ArrayMap();

    public static boolean m20659a() {
        try {
            ConnectivityManager c = C4292a.m20708a().m20710c();
            if (c == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = c.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED;
        } catch (Exception e) {
            C4241a.m20532b("DeviceUtil", "isConnectNet() exception!" + e.getMessage());
            return false;
        }
    }
}
