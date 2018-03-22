package com.huawei.wallet.logic.down;

import android.os.Environment;
import com.huawei.wallet.utils.log.LogC;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DownloadManager {
    private static DownloadManager f21231a;
    private static final byte[] f21232c = new byte[0];
    private Map<String, DownloadTask> f21233b = Collections.synchronizedMap(new HashMap(10));

    private DownloadManager() {
    }

    public static DownloadManager m28022a() {
        DownloadManager downloadManager;
        synchronized (f21232c) {
            if (f21231a == null) {
                f21231a = new DownloadManager();
            }
            downloadManager = f21231a;
        }
        return downloadManager;
    }

    public String m28023a(String str, IDownloadTaskListener iDownloadTaskListener, long j, long j2) {
        Object downloadTask = new DownloadTask(new DownloadEntity(str, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "OTO", j, j2), iDownloadTaskListener);
        this.f21233b.put(downloadTask.m28044e(), downloadTask);
        ThreadPoolManager.m28049a().m28050a(downloadTask);
        return downloadTask.m28044e();
    }

    public void m28024a(DownloadEntity downloadEntity, IDownloadTaskListener iDownloadTaskListener, int i) {
        if (downloadEntity == null || iDownloadTaskListener == null) {
            LogC.m28527a("DownloadManager DownloadEntity is null or listener is null , do not send message.", false);
            return;
        }
        switch (i) {
            case 20017:
                iDownloadTaskListener.mo5141a(downloadEntity, 100);
                iDownloadTaskListener.mo5140a(downloadEntity);
                return;
            case 20018:
                iDownloadTaskListener.mo5145c(downloadEntity);
                iDownloadTaskListener.mo5141a(downloadEntity, 0);
                return;
            case 30017:
                iDownloadTaskListener.mo5143b(downloadEntity, i);
                return;
            default:
                return;
        }
    }

    public void m28025a(String str) {
        DownloadTask downloadTask = (DownloadTask) this.f21233b.get(str);
        if (downloadTask != null) {
            downloadTask.m28043d().sendEmptyMessage(50001);
            downloadTask.m28043d().removeCallbacksAndMessages(null);
            downloadTask.m28040a();
            return;
        }
        LogC.m28527a("DownloadManager cancelDownloadTask task is null.", false);
    }
}
