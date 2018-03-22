package com.huawei.pluginaf500.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: RemoteTakePictureActivity */
class at extends BroadcastReceiver {
    final /* synthetic */ RemoteTakePictureActivity f19897a;

    at(RemoteTakePictureActivity remoteTakePictureActivity) {
        this.f19897a = remoteTakePictureActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null && action.equals("com.fenda.hwbracelet.CAMERA_SHUTTER")) {
                this.f19897a.f19804v.onClick(this.f19897a.f19793k);
            }
        }
    }
}
