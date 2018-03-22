package com.huawei.hwversionmgr.utils.p083a;

import android.os.Handler;
import android.os.Message;
import com.huawei.hwversionmgr.p079a.C1067b;
import com.huawei.hwversionmgr.utils.C1078c;
import com.huawei.p190v.C2538c;

/* compiled from: AppCheckNewVersionHandler */
public abstract class C1074a extends Handler {
    public abstract void mo2345a(int i);

    public abstract void mo2346a(C1067b c1067b);

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 0:
                C2538c.m12674b("AppCheckNewVersionHandler", "check new version failed,FAILED_REASON_NETWORK");
                try {
                    mo2345a(1);
                    return;
                } catch (Exception e) {
                    C2538c.m12674b("handleMessage CHECK_VERSION_STATUS_FAILED, " + e.getMessage(), new Object[0]);
                    return;
                }
            case 1:
                C2538c.m12674b("AppCheckNewVersionHandler", "check new version success");
                m4546a(message.obj);
                return;
            case 2:
                C2538c.m12674b("AppCheckNewVersionHandler", "check band new version success");
                m4547b(message.obj);
                return;
            default:
                C2538c.m12674b("AppCheckNewVersionHandler", "default");
                return;
        }
    }

    private void m4546a(Object obj) {
        try {
            C1067b c1067b = (C1067b) obj;
            if (C1078c.m4587i().f2147t == 1) {
                C2538c.m12674b("AppCheckNewVersionHandler", "STATUS_NEW_VERSION_NOT_AVAILABLE");
                mo2345a(0);
            } else if (C1078c.m4587i().f2147t == -1) {
                C2538c.m12674b("AppCheckNewVersionHandler", "STATUS_SYSTEM_ERROR");
                mo2345a(2);
            } else if (C1078c.m4587i().f2147t == 0) {
                C2538c.m12674b("AppCheckNewVersionHandler", "STATUS_NEW_VERSION_AVAILABLE");
                mo2346a(c1067b);
            } else {
                C2538c.m12674b("AppCheckNewVersionHandler", "FAILED_REASON_UNKNOWN");
                mo2345a(3);
            }
        } catch (Exception e) {
            C2538c.m12674b("handleMessage CHECK_VERSION_STATUS_SUCCESS, " + e.getMessage(), new Object[0]);
        }
    }

    private void m4547b(Object obj) {
        try {
            C1067b c1067b = (C1067b) obj;
            if (C1078c.m4588j().f2147t == 1) {
                C2538c.m12674b("AppCheckNewVersionHandler", "check band STATUS_NEW_VERSION_NOT_AVAILABLE");
                mo2345a(0);
            } else if (C1078c.m4588j().f2147t == -1) {
                C2538c.m12674b("AppCheckNewVersionHandler", "check band STATUS_SYSTEM_ERROR");
                mo2345a(2);
            } else if (C1078c.m4588j().f2147t == 0) {
                C2538c.m12674b("AppCheckNewVersionHandler", "check band STATUS_NEW_VERSION_AVAILABLE");
                mo2346a(c1067b);
            } else {
                C2538c.m12674b("AppCheckNewVersionHandler", "check band FAILED_REASON_UNKNOWN");
                mo2345a(3);
            }
        } catch (Exception e) {
            C2538c.m12674b("check band handleMessage CHECK_VERSION_STATUS_SUCCESS, " + e.getMessage(), new Object[0]);
        }
    }
}
