package com.huawei.bone.root;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: MainActivity */
class C6789h extends BroadcastReceiver {
    final /* synthetic */ MainActivity f23328a;

    C6789h(MainActivity mainActivity) {
        this.f23328a = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"mNonLocalBroadcastReceiver(): intent = " + intent.getAction()});
        String action = intent.getAction();
        if (action != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("deviceinfo");
            if (action.equals("com.huawei.bone.action.CONNECTION_STATE_CHANGED") && (parcelableExtra instanceof DeviceInfo)) {
                DeviceInfo deviceInfo = (DeviceInfo) parcelableExtra;
                if (this.f23328a.f23213d == null) {
                    C2538c.a("MainUI", 0, "MainActivity", new Object[]{"mNonLocalBroadcastReceiver if (mHomeFragment == null)"});
                    return;
                }
                this.f23328a.f23219j.post(new C6790i(this, deviceInfo));
            } else if (!action.equals("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS")) {
            }
        }
    }
}
