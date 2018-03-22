package com.huawei.hwid.update.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.hwid.core.p435d.p437b.C5165e;

public class SilentInstallReceive extends BroadcastReceiver {
    private Handler f18992a;

    public SilentInstallReceive(Handler handler) {
        this.f18992a = handler;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C5165e.m24906b("SilentInstallReceive", "intent is null");
            return;
        }
        try {
            intent.getStringExtra("TestIntent");
            String action = intent.getAction();
            Bundle extras;
            Message message;
            if ("com.huawei.appmarket.service.downloadservice.Receiver".equals(action)) {
                extras = intent.getExtras();
                if (extras == null) {
                    C5165e.m24906b("SilentInstallReceive", "bundle == null");
                    return;
                }
                message = new Message();
                message.what = 101;
                message.obj = extras;
                this.f18992a.sendMessage(message);
            } else if ("com.huawei.appmarket.service.downloadservice.progress.Receiver".equals(action)) {
                extras = intent.getExtras();
                if (extras != null) {
                    message = new Message();
                    message.what = 102;
                    message.obj = extras;
                    this.f18992a.sendMessage(message);
                }
            } else if ("com.huawei.appmarket.service.installerservice.Receiver".equals(action)) {
                extras = intent.getExtras();
                if (extras != null) {
                    message = new Message();
                    message.what = 103;
                    message.obj = extras;
                    this.f18992a.sendMessage(message);
                }
            }
        } catch (Exception e) {
            C5165e.m24910d("SilentInstallReceive", "intent has some error" + e.getMessage());
        }
    }
}
