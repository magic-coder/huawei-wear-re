package com.huawei.hwservicesmgr.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import com.huawei.p190v.C2538c;

public class NetworkConnectReceiver extends BroadcastReceiver {
    private static Handler f2075a;

    public static void m4471a(Handler handler) {
        f2075a = handler;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            C2538c.m12677c("NetworkConnectReceiver", "receive action: ", action);
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    C2538c.m12677c("NetworkConnectReceiver", "network info is null");
                    return;
                }
                C2538c.m12677c("NetworkConnectReceiver", "network is connected:", Boolean.valueOf(activeNetworkInfo.isConnected()));
                if (!activeNetworkInfo.isConnected()) {
                    return;
                }
                if (f2075a != null) {
                    f2075a.sendEmptyMessageDelayed(100, 3000);
                    return;
                }
                C2538c.m12677c("NetworkConnectReceiver", "mHandler is null");
            }
        }
    }
}
