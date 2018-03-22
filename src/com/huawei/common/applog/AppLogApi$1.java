package com.huawei.common.applog;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.phoneserviceuni.common.d.c;

final class AppLogApi$1 extends Handler {
    AppLogApi$1(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (1 == message.what) {
            c.d("AppLogApi", "LOGPACAKAGE_SUCCESS!");
            Intent intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_REQUEST");
            c.d("AppLogApi", "no hasPhoneServiceAutoUpload!");
            intent.setClassName(AppLogApi.access$000(), "com.huawei.feedback.component.AutoUploadService");
            intent.putExtra("aesSecret", AppLogApi.access$100());
            intent.putExtra("filepath", AppLogApi.access$200());
            intent.putExtra("uploadFile", AppLogApi.access$300());
            intent.putExtra("metaData", AppLogApi.access$400());
            try {
                AppLogApi.access$000().startService(intent);
            } catch (Exception e) {
                intent.setClassName(AppLogApi.access$000(), "com.huawei.feedback.component.AutoUploadService");
                try {
                    AppLogApi.access$000().startService(intent);
                } catch (Exception e2) {
                    c.d("AppLogApi", "start AutoUploadService intent error");
                }
            }
        }
    }
}
