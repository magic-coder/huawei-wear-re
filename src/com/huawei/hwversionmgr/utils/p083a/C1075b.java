package com.huawei.hwversionmgr.utils.p083a;

import android.os.Handler;
import android.os.Message;
import com.huawei.hwversionmgr.p079a.C1066a;
import com.huawei.p190v.C2538c;

/* compiled from: AppDownloadHandler */
public abstract class C1075b extends Handler {
    public abstract void mo2349a(int i);

    public abstract void mo2350a(C1066a c1066a);

    public abstract void mo2351b(C1066a c1066a);

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                C2538c.m12674b("AppDownloadHandler", "DOWNLOAD_FAILED_VERIFY_MD5_FAILED");
                mo2349a(message.what);
                return;
            case 2:
                C2538c.m12674b("AppDownloadHandler", "DOWNLOAD_FAILED_URL_ERROR");
                mo2349a(message.what);
                return;
            case 3:
                C2538c.m12674b("AppDownloadHandler", "DOWNLOAD_FAILED_CONNECT_ERROR");
                mo2349a(message.what);
                return;
            case 4:
                C2538c.m12674b("AppDownloadHandler", "DOWNLOAD_FAILED_FILESYSTEM_ERROR");
                mo2349a(message.what);
                return;
            case 5:
                C2538c.m12674b("AppDownloadHandler", "DOWNLOAD_FAILED_IO_ERROR");
                mo2349a(message.what);
                return;
            case 6:
                C2538c.m12674b("AppDownloadHandler", "DOWNLOAD_FAILED_UNKNOWN_ERROR");
                mo2349a(message.what);
                return;
            case 7:
                C2538c.m12674b("AppDownloadHandler", "DOWNLOAD_IN_PROGRESS");
                mo2350a((C1066a) message.obj);
                return;
            case 8:
                C2538c.m12674b("AppDownloadHandler", "DOWNLOAD_SUCCESS");
                mo2351b((C1066a) message.obj);
                return;
            case 9:
                C2538c.m12674b("AppDownloadHandler", "DOWNLOAD_CANCEL");
                mo2349a(message.what);
                return;
            default:
                C2538c.m12674b("AppDownloadHandler", "default");
                return;
        }
    }
}
