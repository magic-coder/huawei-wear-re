package com.huawei.appmarket.sdk.service.download;

import android.os.Handler;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.service.download.bean.C4311b;
import com.huawei.appmarket.sdk.service.download.bean.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C4317e {
    protected static C4317e f16054b = null;
    protected List<DownloadTask> f16055a = new ArrayList();
    protected C4311b f16056c;
    protected C4308c f16057d;
    private ExecutorService f16058e;
    private Handler f16059f;

    protected C4317e() {
        C4241a.m20529a("DownloadManager", "create executor with thread pool number:2");
        this.f16058e = Executors.newFixedThreadPool(2);
    }

    public static synchronized C4317e m20789a() {
        C4317e c4317e;
        synchronized (C4317e.class) {
            if (f16054b == null) {
                f16054b = new C4317e();
            }
            c4317e = f16054b;
        }
        return c4317e;
    }

    private void m20790f(DownloadTask downloadTask) {
        downloadTask.setStatus(0);
        this.f16059f.sendMessage(this.f16059f.obtainMessage(downloadTask.getStatus(), downloadTask));
        Runnable c4318f = new C4318f(downloadTask, this.f16059f);
        if (this.f16057d != null) {
            c4318f.m20821a(this.f16057d);
        }
        downloadTask.setTaskFuture(this.f16058e.submit(c4318f));
    }

    public int m20791a(int i) {
        C4241a.m20529a("DownloadManager", "pauseAll all download task, reason:" + i + ",tasklist size:" + m20803e());
        int i2 = 0;
        for (DownloadTask downloadTask : m20805f()) {
            if (downloadTask.getStatus() != 6) {
                m20795a(downloadTask, i);
                i2++;
            }
        }
        return i2;
    }

    public DownloadTask m20792a(String str) {
        synchronized (this.f16055a) {
            for (DownloadTask downloadTask : this.f16055a) {
                if (downloadTask.getPackageName().equalsIgnoreCase(str)) {
                    return downloadTask;
                }
            }
            return null;
        }
    }

    public void m20793a(Handler handler) {
        this.f16059f = handler;
    }

    public void m20794a(DownloadTask downloadTask) {
        if (downloadTask != null) {
            downloadTask.setDeleteDirtyFile(true);
            if (!m20798b(downloadTask)) {
                if (downloadTask.getId() == -1) {
                    downloadTask.setId(DownloadTask.genTaskIndex());
                }
                downloadTask.getDownloadQuality().f16043a = System.currentTimeMillis();
                synchronized (this.f16055a) {
                    this.f16055a.add(downloadTask);
                }
                if (this.f16056c != null) {
                    this.f16056c.m20783a(downloadTask);
                }
                C4241a.m20529a("DownloadManager", "Push new task to pool:" + downloadTask);
            }
            m20790f(downloadTask);
        }
    }

    public void m20795a(DownloadTask downloadTask, int i) {
        if (downloadTask != null) {
            C4241a.m20529a("DownloadManager", "pauseTask, id:" + downloadTask.getId() + ",status:" + downloadTask.getStatus() + ", reason:" + i);
            if (downloadTask.getStatus() == 0) {
                if (downloadTask.getTaskFuture() != null) {
                    downloadTask.getTaskFuture().cancel(true);
                }
                downloadTask.setStatus(6);
                this.f16059f.sendMessage(this.f16059f.obtainMessage(downloadTask.getStatus(), downloadTask));
            }
            downloadTask.setInterrupt(true, i);
            m20804e(downloadTask);
            synchronized (downloadTask) {
                try {
                    downloadTask.notifyAll();
                } catch (Exception e) {
                    C4241a.m20532b("DownloadManager", "task notifyAll exception:" + e.getMessage());
                }
            }
        }
    }

    public void m20796a(C4308c c4308c) {
        this.f16057d = c4308c;
    }

    public void m20797b() {
        m20791a(0);
        synchronized (this.f16055a) {
            this.f16055a.clear();
        }
        if (this.f16056c != null) {
            this.f16056c.m20782a();
            this.f16056c = null;
        }
    }

    public boolean m20798b(DownloadTask downloadTask) {
        synchronized (this.f16055a) {
            for (DownloadTask id : this.f16055a) {
                if (id.getId() == downloadTask.getId()) {
                    return true;
                }
            }
            return false;
        }
    }

    public void m20799c(DownloadTask downloadTask) {
        synchronized (this.f16055a) {
            this.f16055a.remove(downloadTask);
        }
        if (this.f16056c != null) {
            this.f16056c.m20784b(downloadTask);
        }
    }

    public boolean m20800c() {
        boolean z;
        synchronized (this.f16055a) {
            for (DownloadTask status : this.f16055a) {
                if (status.getStatus() != 6) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.appmarket.sdk.service.download.bean.DownloadTask m20801d() {
        /*
        r5 = this;
        r1 = r5.f16055a;
        monitor-enter(r1);
        r0 = r5.f16055a;	 Catch:{ all -> 0x002f }
        r2 = r0.iterator();	 Catch:{ all -> 0x002f }
    L_0x0009:
        r0 = r2.hasNext();	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x002c;
    L_0x000f:
        r0 = r2.next();	 Catch:{ all -> 0x002f }
        r0 = (com.huawei.appmarket.sdk.service.download.bean.DownloadTask) r0;	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x0009;
    L_0x0017:
        r3 = r0.getNotifyBuilder();	 Catch:{ all -> 0x002f }
        if (r3 == 0) goto L_0x0009;
    L_0x001d:
        r3 = r0.getStatus();	 Catch:{ all -> 0x002f }
        r4 = 1;
        if (r3 == r4) goto L_0x002a;
    L_0x0024:
        r4 = 2;
        if (r3 == r4) goto L_0x002a;
    L_0x0027:
        r4 = 7;
        if (r3 != r4) goto L_0x0009;
    L_0x002a:
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
    L_0x002b:
        return r0;
    L_0x002c:
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
        r0 = 0;
        goto L_0x002b;
    L_0x002f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appmarket.sdk.service.download.e.d():com.huawei.appmarket.sdk.service.download.bean.DownloadTask");
    }

    public void m20802d(DownloadTask downloadTask) {
        if (downloadTask != null) {
            if (downloadTask.getStatus() != 6) {
                C4241a.m20532b("DownloadManager", "task status isn't DOWNLOAD_PAUSED(6), ignore task:" + downloadTask);
                return;
            }
            C4241a.m20529a("DownloadManager", "resumeTask, id:" + downloadTask.getId());
            downloadTask.setInterrupt(false, 0);
            m20804e(downloadTask);
            m20794a(downloadTask);
        }
    }

    public int m20803e() {
        int size;
        synchronized (this.f16055a) {
            size = this.f16055a.size();
        }
        return size;
    }

    public void m20804e(DownloadTask downloadTask) {
        if (this.f16056c != null) {
            this.f16056c.m20785c(downloadTask);
        }
    }

    public List<DownloadTask> m20805f() {
        List arrayList;
        synchronized (this.f16055a) {
            arrayList = new ArrayList(this.f16055a);
        }
        return arrayList;
    }
}
