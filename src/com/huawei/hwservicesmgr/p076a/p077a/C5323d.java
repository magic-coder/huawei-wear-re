package com.huawei.hwservicesmgr.p076a.p077a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hwservicesmgr.a.a.a;
import com.huawei.p190v.C2538c;

/* compiled from: HWEphemerisManager */
class C5323d extends Handler {
    final /* synthetic */ a f19054a;

    C5323d(a aVar, Looper looper) {
        this.f19054a = aVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.c("HWEphemerisManager", new Object[]{"handleMessage() msg: ", Integer.valueOf(message.what)});
        switch (message.what) {
            case 1:
                sendEmptyMessageDelayed(1, a.b());
                C2538c.c("HWEphemerisManager", new Object[]{"handleMessage()  发送超时定时器 waitTime = " + a.b()});
                a.a(this.f19054a);
                return;
            case 2:
                C2538c.c("HWEphemerisManager", new Object[]{"handleMessage()  START_DOWNLOAD_MSG "});
                a.g(this.f19054a);
                a.e(this.f19054a);
                a.a(this.f19054a, false);
                return;
            case 3:
                a.b(this.f19054a, -1);
                C2538c.c("HWEphemerisManager", new Object[]{"epn handleMessage()  TIMEOUT_RESET_UPDATE_STATE currentUpdateState = " + a.h(this.f19054a)});
                return;
            case 4:
                C2538c.c("HWEphemerisManager", new Object[]{"eph handleMessage() TIMEOUT_CHECK_STATE_RESET checkingState = " + a.i(this.f19054a) + "  currentUpdateState = " + a.h(this.f19054a)});
                if (a.i(this.f19054a) && -1 != a.h(this.f19054a)) {
                    a.b(this.f19054a, false);
                    a.a(this.f19054a, "com.huawei.bone.ephemeris.currentState.updating");
                }
                a.b(this.f19054a, false);
                return;
            case 100:
                C2538c.c("HWEphemerisManager", new Object[]{"network connected, isDownloading:", Boolean.valueOf(a.b(this.f19054a)), ";isNeedDownload:", Boolean.valueOf(a.c(this.f19054a)), ";currentNetworkConnectedRetryTimes:", Integer.valueOf(a.d(this.f19054a))});
                if (a.b(this.f19054a)) {
                    a.a(this.f19054a, 2);
                    return;
                } else if (a.c(this.f19054a) && a.d(this.f19054a) < 3) {
                    sendEmptyMessageDelayed(1, a.b());
                    a.a(this.f19054a, true);
                    a.e(this.f19054a);
                    a.a(this.f19054a, false);
                    a.f(this.f19054a);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
