package com.huawei.bone.root;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Handler;
import android.os.Parcelable;
import com.huawei.p190v.C2538c;

/* compiled from: MainActivity */
class C6791j extends BroadcastReceiver {
    boolean f23331a = false;
    final /* synthetic */ MainActivity f23332b;

    C6791j(MainActivity mainActivity) {
        this.f23332b = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null) {
            C2538c.a("MainUI", 0, "MainActivity", new Object[]{"mWifiBroadcastReceiver----onReceive intent =" + intent.getAction()});
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null && (parcelableExtra instanceof NetworkInfo)) {
                    boolean z = ((NetworkInfo) parcelableExtra).getState() == State.CONNECTED;
                    C2538c.a("MainUI", 0, "MainActivity", new Object[]{"----isConnected= " + z + "BuildConfig.RELEASE_EVENT_LOG_UPLOAD " + true + "oldConnected " + this.f23331a});
                    if (z != this.f23331a) {
                        this.f23331a = z;
                        if (z) {
                            new Handler().postDelayed(new C6792k(this, context), 2000);
                        }
                    }
                }
            }
        }
    }
}
