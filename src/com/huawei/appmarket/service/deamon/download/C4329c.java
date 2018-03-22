package com.huawei.appmarket.service.deamon.download;

import android.os.Handler.Callback;
import android.os.Message;

class C4329c implements Callback {
    final /* synthetic */ DownloadService f16124a;

    C4329c(DownloadService downloadService) {
        this.f16124a = downloadService;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            this.f16124a.stopSelf();
        }
        return true;
    }
}
