package com.huawei.appmarket.service.deamon.download;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;

public final class C4332f implements ServiceConnection {
    final /* synthetic */ C4331e f16131a;

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f16131a.f16128c = ((C4330d) iBinder).m20856a();
        synchronized (this.f16131a.f16130e) {
            for (Message sendToTarget : this.f16131a.f16130e) {
                sendToTarget.sendToTarget();
            }
            this.f16131a.f16130e.clear();
        }
        C4241a.m20529a("ServiceProxy", "Bind to DownloadService sucessfuly");
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f16131a.f16128c = null;
        C4241a.m20529a("ServiceProxy", "unBind DownloadService sucessfuly");
    }
}
