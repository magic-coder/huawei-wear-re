package com.huawei.appmarket.service.deamon.download;

import android.os.Handler;
import android.os.Message;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.foundation.p367e.p368a.C4274a;
import com.huawei.appmarket.sdk.service.download.bean.DownloadTask;
import java.lang.ref.WeakReference;

public final class DownloadHandler extends Handler {
    protected DownloadTask f16115a = null;
    private WeakReference<DownloadService> f16116b;

    public DownloadHandler(DownloadService downloadService) {
        this.f16116b = new WeakReference(downloadService);
    }

    public void m20836a(DownloadService downloadService, DownloadTask downloadTask) {
        downloadService.f16118a.m20799c(downloadTask);
    }

    public void m20837b(DownloadService downloadService, DownloadTask downloadTask) {
        DownloadTask d = downloadService.f16118a.m20801d();
        if (d != null) {
            if (downloadTask == this.f16115a) {
                downloadService.startForeground(d.getId(), d.getNotifyBuilder().build());
                this.f16115a = d;
                C4241a.m20529a("DownloadService", "set foreground task,ID:" + d.getId());
            }
        } else if (this.f16115a != null && this.f16115a == downloadTask) {
            C4241a.m20529a("DownloadService", "download completed, stop foreground task,ID:" + downloadTask.getId());
            this.f16115a = null;
            if (downloadTask.getStatus() == 4) {
                downloadTask.getNotifyBuilder().setOngoing(false);
                downloadTask.setId(C4274a.m20646a());
            }
            if (!downloadService.m20841a()) {
                downloadService.stopSelf();
            }
            downloadService.stopForeground(true);
        }
    }

    public void handleMessage(Message message) {
        DownloadService downloadService = (DownloadService) this.f16116b.get();
        if (downloadService == null) {
            C4241a.m20532b("DownloadService", "handleMessage, but service object is null.");
            return;
        }
        super.handleMessage(message);
        if (message.obj != null && (message.obj instanceof DownloadTask)) {
            DownloadTask downloadTask = (DownloadTask) message.obj;
            String str = "";
            switch (message.what) {
                case 0:
                    C4327a.m20847a(downloadService, downloadTask, message.what);
                    return;
                case 1:
                    downloadService.f16118a.m20804e(downloadTask);
                    C4327a.m20847a(downloadService, downloadTask, message.what);
                    return;
                case 2:
                    C4327a.m20847a(downloadService, downloadTask, message.what);
                    return;
                case 3:
                    m20836a(downloadService, downloadTask);
                    C4327a.m20847a(downloadService, downloadTask, message.what);
                    m20837b(downloadService, downloadTask);
                    C4241a.m20532b("DownloadService", "task download canneled:" + downloadTask);
                    return;
                case 4:
                    m20836a(downloadService, downloadTask);
                    C4327a.m20847a(downloadService, downloadTask, message.what);
                    m20837b(downloadService, downloadTask);
                    downloadService.m20840a(downloadTask);
                    C4241a.m20529a("DownloadService", "task download completed:" + downloadTask);
                    return;
                case 5:
                    m20836a(downloadService, downloadTask);
                    C4327a.m20847a(downloadService, downloadTask, message.what);
                    m20837b(downloadService, downloadTask);
                    C4241a.m20532b("DownloadService", "task download failed:" + downloadTask);
                    return;
                case 6:
                    if (downloadTask.getInterruptReason() == 6) {
                        downloadService.f16118a.m20791a(1);
                    } else if (downloadTask.getInterruptReason() == 5) {
                        downloadService.f16118a.m20804e(downloadTask);
                    }
                    C4241a.m20529a("DownloadService", "Download downloadPaused task.getId():" + downloadTask.getId());
                    C4327a.m20847a(downloadService, downloadTask, message.what);
                    m20837b(downloadService, downloadTask);
                    return;
                default:
                    C4241a.m20532b("DownloadService", "Unkonw message " + message.what + " ,taskid:" + downloadTask.getId());
                    return;
            }
        }
    }
}
