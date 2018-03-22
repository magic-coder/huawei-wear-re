package com.huawei.ui.homewear21.p175a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.p190v.C2538c;
import java.util.Locale;

/* compiled from: HomeFragment */
class aw extends BroadcastReceiver {
    final /* synthetic */ C2217a f8066a;

    aw(C2217a c2217a) {
        this.f8066a = c2217a;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C2538c.m12661a("MainUI", 0, "HomeFragment", "onReceive deleteDeviceReceiver action = " + action);
        if (action != null && action.equals("action_delete_debice_in_device_manager_list")) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "onReceive deleteDeviceReceiver isConnected = " + this.f8066a.f8009R);
            Object stringExtra = intent.getStringExtra("key_device_mac");
            if (TextUtils.isEmpty(stringExtra)) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "mac is null,return");
            } else if (TextUtils.isEmpty(this.f8066a.ah)) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "deviceMac is null,return");
            } else if (stringExtra.toLowerCase(Locale.getDefault()).equals(this.f8066a.ah.toLowerCase(Locale.getDefault()))) {
                this.f8066a.ah = "";
                this.f8066a.f8019d.m11686a();
            } else {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "do not need to change device");
            }
        }
    }
}
