package com.huawei.appmarket.service.deamon.download;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.appmarket.p348a.p349a.C4212a;
import com.huawei.appmarket.sdk.service.download.bean.DownloadTask;

public final class C4327a {
    public static final String m20846a() {
        return C4212a.m20466a() + ".service.downloadservice.Receiver";
    }

    public static void m20847a(Context context, DownloadTask downloadTask, int i) {
        if (context != null) {
            Intent intent = new Intent();
            String a = C4327a.m20846a();
            if (downloadTask != null) {
                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                downloadTask.writeToBundle(bundle2);
                bundle.putBundle("downloadtask.all", bundle2);
                bundle.putInt("downloadtask.status", i);
                intent.putExtras(bundle);
                if (i == 2) {
                    a = C4327a.m20848b();
                }
            }
            intent.setAction(a);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    public static final String m20848b() {
        return C4212a.m20466a() + ".service.downloadservice.progress.Receiver";
    }
}
