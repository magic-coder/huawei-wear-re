package com.huawei.common.applog;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.feedback.c;
import com.huawei.phoneserviceuni.common.d.a;

final class AppLogApi$2 implements Runnable {
    final /* synthetic */ Context val$context;

    AppLogApi$2(Context context) {
        this.val$context = context;
    }

    public void run() {
        if (AppLogApi.checkTimeOver(this.val$context) && AppLogApi.checkPolicyOver(this.val$context)) {
            Intent intent = new Intent("com.huawei.phoneservice.AUTOCHECK");
            intent.setClassName(this.val$context, "com.huawei.feedback.component.AutoUploadService");
            Bundle bundle = new Bundle();
            bundle.putString("LogVersion", AppLogApi.access$500());
            bundle.putString("LogSubversion", AppLogApi.access$600());
            bundle.putString("ProductName", Build.MODEL);
            bundle.putString("ProductVersion", Build.DISPLAY);
            String l = a.l();
            String q = c.q(this.val$context);
            if (TextUtils.isEmpty(q)) {
                q = l;
            }
            bundle.putString("SN", l);
            bundle.putString("IMEI", q);
            intent.putExtra("metaData", bundle);
            this.val$context.startService(intent);
        }
    }
}
