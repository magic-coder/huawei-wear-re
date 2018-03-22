package com.huawei.appmarket.sdk.foundation.p364c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;

class C4271c extends BroadcastReceiver {
    final /* synthetic */ C4269a f15944a;

    private C4271c(C4269a c4269a) {
        this.f15944a = c4269a;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && context != null) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                C4272d c4272d = (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? C4272d.NOT_CONNECTED : C4272d.CONNECTED;
                C4241a.m20529a("NetworkConnectivity", "onReceive(): " + activeNetworkInfo + " ,mState=" + c4272d);
                for (Handler handler : this.f15944a.f15941b.keySet()) {
                    Message obtain = Message.obtain(handler, ((Integer) this.f15944a.f15941b.get(handler)).intValue());
                    obtain.obj = activeNetworkInfo;
                    obtain.arg1 = c4272d.m20645a();
                    handler.sendMessage(obtain);
                }
            }
        }
    }
}
