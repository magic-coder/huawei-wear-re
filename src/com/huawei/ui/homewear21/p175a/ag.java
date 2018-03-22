package com.huawei.ui.homewear21.p175a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.Process;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class ag extends BroadcastReceiver {
    final /* synthetic */ C2217a f8048a;

    ag(C2217a c2217a) {
        this.f8048a = c2217a;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "mNonLocalBroadcastReceiver(): intent = " + intent.getAction());
        if ("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS".equals(intent.getAction())) {
            this.f8048a.m11557l();
        } else if ("com.huawei.bone.action.CORE_SLEEP_DATA_SYNC_COMPLETED".equals(intent.getAction())) {
            this.f8048a.bu.sendEmptyMessage(18);
        } else if ("com.huawei.bone.action.open_gps".equals(intent.getAction())) {
            this.f8048a.bB();
            abortBroadcast();
        } else {
            try {
                DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
                C2538c.m12661a("MainUI", 0, "HomeFragment", "handleConnectStateChanged() Process.myPid():" + Process.myPid());
                if (this.f8048a.f8019d == null) {
                    C2538c.m12661a("MainUI", 0, "HomeFragment", "initView is not completed");
                    return;
                }
                this.f8048a.aA();
                Message message = new Message();
                message.what = 1011;
                message.obj = deviceInfo;
                this.f8048a.bu.sendMessage(message);
            } catch (ClassCastException e) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "DeviceInfo deviceInfo error" + e.getMessage());
            }
        }
    }
}
