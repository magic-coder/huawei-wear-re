package com.huawei.feedback.component;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.feedback.C0809b;
import com.huawei.logupload.C1094a.C1096a;
import com.huawei.logupload.LogUpload;
import com.huawei.phoneserviceuni.common.p132d.C1373c;

/* compiled from: ProgressService */
class C0815d implements ServiceConnection {
    final /* synthetic */ ProgressService f1283a;

    C0815d(ProgressService progressService) {
        this.f1283a = progressService;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C1373c.m6139b("ProgressService", "onServiceDisconnected");
        ProgressService.f1256j = null;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C1373c.m6139b("ProgressService", "onServiceConnected");
        ProgressService.f1256j = C1096a.m4840a(iBinder);
        if (ProgressService.f1256j != null) {
            try {
                ProgressService.f1257k = ProgressService.f1256j.mo2353a();
            } catch (RemoteException e) {
                C1373c.m6141d("ProgressService", "RemoteException");
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.logupload.progress");
        intentFilter.addAction("com.example.logupload.progressSmall");
        this.f1283a.registerReceiver(this.f1283a.f1264f, intentFilter);
        C0809b.m2733a(1);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.logupload.progress.start");
        this.f1283a.registerReceiver(this.f1283a.f1265g, intentFilter);
        C0809b.m2733a(2);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.logupload.progress.pause");
        this.f1283a.registerReceiver(this.f1283a.f1267i, intentFilter);
        C0809b.m2733a(3);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.logupload.progress.cancel");
        this.f1283a.registerReceiver(this.f1283a.f1266h, intentFilter);
        C0809b.m2733a(4);
        C1373c.m6138a("ProgressService", "mListLogUpload.size() :" + ProgressService.f1257k.size());
        for (LogUpload logUpload : ProgressService.f1257k) {
            if (ProgressService.f1258o.equals(logUpload.m4760C())) {
                this.f1283a.f1261c.cancel((int) logUpload.m4800i());
                C1373c.m6138a("ProgressService", "nm.cancel id:" + logUpload.m4800i());
                C1373c.m6140c("ProgressService", "onServiceConnected CreateNotification");
                this.f1283a.m2848b(logUpload);
                C1373c.m6140c("ProgressService", "onServiceConnected updateNotification");
                this.f1283a.m2856c(logUpload);
            }
        }
    }
}
