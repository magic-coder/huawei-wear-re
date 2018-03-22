package com.huawei.appmarket;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.appmarket.p348a.p352d.C4221d;
import com.huawei.appmarket.sdk.service.download.bean.DownloadTask;
import com.huawei.appmarket.service.deamon.download.C4327a;
import com.huawei.appmarket.service.deamon.download.C4331e;
import java.util.HashMap;
import java.util.Map;

class C4236c extends BroadcastReceiver {
    final /* synthetic */ C4234a f15883a;

    C4236c(C4234a c4234a) {
        this.f15883a = c4234a;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle extras;
        if (C4327a.m20846a().equals(action)) {
            extras = intent.getExtras();
            if (extras != null) {
                int i = extras.getInt("downloadtask.status", -1);
                if (DownloadTask.fromBundle(intent.getBundleExtra("downloadtask.all")) != null) {
                    switch (i) {
                        case 4:
                            if (this.f15883a.f15878e != null) {
                                this.f15883a.f15878e.sendMessage(this.f15883a.f15878e.obtainMessage(5));
                                return;
                            }
                            return;
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            if (this.f15883a.f15878e != null) {
                                this.f15883a.f15878e.sendMessage(this.f15883a.f15878e.obtainMessage(6));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        } else if (C4327a.m20848b().equals(action)) {
            C4331e a = C4331e.m20857a();
            if (a == null || a.m20859b() != null) {
                DownloadTask a2 = a.m20859b().m20839a("com.huawei.appmarket");
                if (a2 != null) {
                    r1 = a2.calculateProgress();
                    long alreadDownloadSize = a2.getAlreadDownloadSize();
                    long fileSize = a2.getFileSize();
                    r0 = this.f15883a.f15878e.obtainMessage();
                    Map hashMap = new HashMap();
                    hashMap.put("DOWNLOADED_SIZE", alreadDownloadSize + "");
                    hashMap.put("TOTAL_SIZE", fileSize + "");
                    r0.what = 4;
                    r0.obj = hashMap;
                    r0.arg1 = r1;
                    this.f15883a.f15878e.sendMessage(r0);
                }
            }
        } else if (C4221d.m20497a().equals(action)) {
            extras = intent.getExtras();
            r1 = extras.getInt("INSTALL_STATE");
            int i2 = extras.getInt("INSTALL_TYPE");
            intent.putExtras(extras);
            r0 = this.f15883a.f15878e.obtainMessage();
            r0.what = 8;
            r0.arg1 = i2;
            r0.arg2 = r1;
            this.f15883a.f15878e.sendMessage(r0);
        }
    }
}
