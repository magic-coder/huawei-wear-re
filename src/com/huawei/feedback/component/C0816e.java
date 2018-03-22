package com.huawei.feedback.component;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.feedback.logic.C0822f;
import com.huawei.logupload.LogUpload;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import java.io.File;
import java.util.List;

/* compiled from: ProgressService */
class C0816e implements Runnable {
    final /* synthetic */ LogUpload f1284a;
    final /* synthetic */ ProgressService f1285b;

    C0816e(ProgressService progressService, LogUpload logUpload) {
        this.f1285b = progressService;
        this.f1284a = logUpload;
    }

    public void run() {
        int i = 0;
        int d = this.f1285b.m2861e(this.f1284a);
        C1373c.m6138a("ProgressService", "mLogUploadInfo.getId(): " + this.f1284a.m4800i());
        this.f1285b.f1262d.remove(Long.valueOf(this.f1284a.m4800i()));
        this.f1285b.f1261c.cancel(d);
        List list = null;
        if (ProgressService.f1256j != null) {
            try {
                list = ProgressService.f1256j.mo2353a();
            } catch (RemoteException e) {
                C1373c.m6139b("ProgressService", "external queryAllRecord RemoteException");
            }
        }
        if (!(r1 == null || r1.size() == 0)) {
            d = 0;
            for (LogUpload C : r1) {
                if (ProgressService.f1258o.equals(C.m4760C())) {
                    i = d + 1;
                } else {
                    i = d;
                }
                d = i;
            }
            i = d;
        }
        this.f1285b.f1262d.remove(Long.valueOf(this.f1284a.m4800i()));
        this.f1285b.f1263e.remove(Long.valueOf(this.f1284a.m4800i()));
        C0822f.m2889a(String.valueOf(this.f1284a.m4800i()), 3);
        if (TextUtils.isEmpty(this.f1284a.m4798h())) {
            C1373c.m6139b("ProgressService", "file path is empty or null: mLogUploadInfo.getFilepath()):" + this.f1284a.m4798h());
        } else {
            C1373c.m6138a("ProgressServicefilepath", this.f1284a.m4798h());
            File file = new File(this.f1284a.m4798h());
            if (file.exists() && file.delete()) {
                C1373c.m6139b("ProgressService", "file delete sucess");
            } else {
                C1373c.m6139b("ProgressService", "file not exist or error! delete file fail!");
            }
        }
        if (i == 0) {
            this.f1285b.f1261c.cancel(1002);
            this.f1285b.stopSelf();
        }
    }
}
