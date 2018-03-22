package com.huawei.ui.main.stories.about.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.hwappdfxmgr.f.c;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.j;

/* compiled from: AboutActivity */
class C2307g extends Handler {
    final /* synthetic */ AboutActivity f8368a;

    C2307g(AboutActivity aboutActivity) {
        this.f8368a = aboutActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 0:
                C2538c.m12674b("AboutActivity", "上传log 超时");
                if (!(this.f8368a.f8302C == null || !this.f8368a.f8302C.isShowing() || c.b())) {
                    this.f8368a.m11794a(j.IDS_hw_show_log_upload_failed);
                }
                this.f8368a.m11789i();
                return;
            case 2:
                if (c.b()) {
                    C2538c.m12674b("AboutActivity", "mUploadLogResultBroadcastReceiver: log upload success");
                    this.f8368a.f8303D.removeMessages(2);
                    this.f8368a.m11789i();
                    return;
                }
                C2538c.m12674b("AboutActivity", "文件没上传完毕，等待文件上传");
                Message obtain = Message.obtain();
                obtain.what = 0;
                this.f8368a.f8303D.sendMessageDelayed(obtain, 600000);
                return;
            case 10:
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    C2538c.m12677c("AboutActivity", "AboutActivity  curTime = ", Long.valueOf(currentTimeMillis), ", lastTime = ", Long.valueOf(Long.parseLong(C0996a.m3612a(this.f8368a.f8308a, String.valueOf(10), "Crowd_test_last_time"))));
                    if (1800000 > currentTimeMillis - Long.parseLong(C0996a.m3612a(this.f8368a.f8308a, String.valueOf(10), "Crowd_test_last_time"))) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    C2538c.m12680e("AboutActivity", "AboutActivity... e = ", e.getMessage());
                }
                C0996a.m3611a(this.f8368a.f8308a, String.valueOf(10), "Crowd_test_last_time", String.valueOf(currentTimeMillis), new C0993c(0));
                HWDeviceDFXManager.getInstance(this.f8368a.f8308a).getCrowdTestAndMaint(0, new C2308h(this));
                return;
            default:
                return;
        }
    }
}
