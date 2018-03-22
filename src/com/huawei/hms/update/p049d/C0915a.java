package com.huawei.hms.update.p049d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.support.log.C0887a;

/* compiled from: SilentInstallReceive */
public class C0915a extends BroadcastReceiver {
    private Handler f1509a;

    public C0915a(Handler handler) {
        this.f1509a = handler;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                intent.getStringExtra("TestIntent");
                String action = intent.getAction();
                Bundle extras;
                Message message;
                if ("com.huawei.appmarket.service.downloadservice.Receiver".equals(action)) {
                    extras = intent.getExtras();
                    if (extras != null) {
                        message = new Message();
                        message.what = 101;
                        message.obj = extras;
                        this.f1509a.sendMessage(message);
                    }
                } else if ("com.huawei.appmarket.service.downloadservice.progress.Receiver".equals(action)) {
                    extras = intent.getExtras();
                    if (extras != null) {
                        message = new Message();
                        message.what = 102;
                        message.obj = extras;
                        this.f1509a.sendMessage(message);
                    }
                } else if ("com.huawei.appmarket.service.installerservice.Receiver".equals(action)) {
                    extras = intent.getExtras();
                    if (extras != null) {
                        message = new Message();
                        message.what = 103;
                        message.obj = extras;
                        this.f1509a.sendMessage(message);
                    }
                }
            } catch (Exception e) {
                C0887a.m3098d("SilentInstallReceive", "intent has some error" + e.getMessage());
            }
        }
    }
}
