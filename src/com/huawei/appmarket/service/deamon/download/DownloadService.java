package com.huawei.appmarket.service.deamon.download;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.huawei.appmarket.p348a.p352d.C4229l;
import com.huawei.appmarket.p348a.p352d.C4230m;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.foundation.p364c.C4269a;
import com.huawei.appmarket.sdk.foundation.p367e.p369b.C4281a;
import com.huawei.appmarket.sdk.foundation.p367e.p371c.C4285c;
import com.huawei.appmarket.sdk.service.download.C4317e;
import com.huawei.appmarket.sdk.service.download.bean.DownloadTask;
import com.huawei.appmarket.service.deamon.download.p379a.C4326a;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadService extends Service {
    private static boolean f16117b = false;
    protected C4317e f16118a;
    private final AtomicInteger f16119c = new AtomicInteger();
    private C4326a f16120d;
    private final IBinder f16121e = new C4330d(this);

    public static void m20838a(boolean z) {
        f16117b = z;
    }

    public DownloadTask m20839a(String str) {
        return this.f16118a.m20792a(str);
    }

    void m20840a(DownloadTask downloadTask) {
        C4230m.m20509a(downloadTask.getFilepath(), downloadTask.getPackageName(), downloadTask, C4229l.m20501a(downloadTask.getInstallType()), false);
    }

    public boolean m20841a() {
        return this.f16119c.get() > 0;
    }

    public boolean m20842b() {
        return C4281a.m20659a();
    }

    public boolean m20843b(DownloadTask downloadTask) {
        if (!m20842b() || downloadTask == null) {
            return false;
        }
        downloadTask.setAllowMobileNetowrkDownload(C4285c.m20689e(this));
        this.f16118a.m20794a(downloadTask);
        return true;
    }

    public boolean m20844c(DownloadTask downloadTask) {
        if (!m20842b()) {
            return false;
        }
        downloadTask.setAllowMobileNetowrkDownload(C4285c.m20689e(this));
        this.f16118a.m20802d(downloadTask);
        return true;
    }

    public IBinder onBind(Intent intent) {
        this.f16119c.incrementAndGet();
        return this.f16121e;
    }

    public void onCreate() {
        super.onCreate();
        C4241a.m20529a("DownloadService", "DownloadService onCreate");
        f16117b = true;
        this.f16118a = C4317e.m20789a();
        this.f16118a.m20796a(new C4328b());
        this.f16118a.m20793a(new DownloadHandler(this));
        this.f16120d = new C4326a();
        C4269a.m20641a().m20643a((Context) this);
    }

    public void onDestroy() {
        super.onDestroy();
        m20838a(false);
        try {
            this.f16118a.m20797b();
            C4269a.m20641a().m20644b();
            if (this.f16120d != null) {
                this.f16120d.m20845a();
                this.f16120d = null;
            }
            stopForeground(true);
        } catch (Throwable e) {
            C4241a.m20530a("DownloadService", "unRegister NetworkConnectivityListener:", e);
        }
        C4241a.m20529a("DownloadService", "DownloadService onDestroy");
    }

    public void onRebind(Intent intent) {
        this.f16119c.incrementAndGet();
        super.onRebind(intent);
    }

    public boolean onUnbind(Intent intent) {
        this.f16119c.decrementAndGet();
        if (this.f16119c.intValue() <= 0 && !this.f16118a.m20800c()) {
            new Handler(new C4329c(this)).sendEmptyMessage(1);
        }
        return true;
    }
}
