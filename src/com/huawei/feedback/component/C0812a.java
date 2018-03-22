package com.huawei.feedback.component;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.huawei.common.applog.AppLogApi;
import com.huawei.feedback.C0811c;
import com.huawei.feedback.bean.C0810a;
import com.huawei.feedback.p033a.p035b.C0808a;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import java.io.File;

/* compiled from: AutoUploadService */
class C0812a implements Runnable {
    final /* synthetic */ String f1272a;
    final /* synthetic */ String f1273b;
    final /* synthetic */ C0810a f1274c;
    final /* synthetic */ Bundle f1275d;
    final /* synthetic */ String f1276e;
    final /* synthetic */ AutoUploadService f1277f;

    C0812a(AutoUploadService autoUploadService, String str, String str2, C0810a c0810a, Bundle bundle, String str3) {
        this.f1277f = autoUploadService;
        this.f1272a = str;
        this.f1273b = str2;
        this.f1274c = c0810a;
        this.f1275d = bundle;
        this.f1276e = str3;
    }

    public void run() {
        File a = C0811c.m2754a(this.f1277f.getApplicationContext(), this.f1272a, this.f1273b);
        if (a == null || !a.exists()) {
            this.f1274c.m2741a(false);
        } else {
            long length = a.length();
            String path = a.getPath();
            C1373c.m6141d("AppLogApi/AutoUploadService", "small path ok!" + path);
            this.f1274c.m2740a(path);
            this.f1274c.m2743b(length);
        }
        this.f1277f.m2820a(this.f1274c);
        boolean checkTimeOver = AppLogApi.checkTimeOver(this.f1277f.getApplicationContext());
        boolean checkPolicyOver = AppLogApi.checkPolicyOver(this.f1277f.getApplicationContext());
        if (C0808a.m2700a().m2730k(this.f1277f.getApplicationContext())) {
            C1373c.m6141d("AppLogApi/AutoUploadService", "Immediate Upload");
            this.f1277f.m2819a(this.f1275d, this.f1276e);
        } else if (checkTimeOver && checkPolicyOver) {
            C1373c.m6141d("AppLogApi/AutoUploadService", "TimeOver and PolicyOver Upload");
            this.f1277f.m2819a(this.f1275d, this.f1276e);
        } else {
            Log.i("AppLogApi/AutoUploadService", "checkTimeOver " + checkTimeOver + "ischeckPolicyOver " + checkPolicyOver);
            this.f1277f.getApplicationContext().stopService(new Intent(this.f1277f.getApplicationContext(), AutoUploadService.class));
        }
    }
}
