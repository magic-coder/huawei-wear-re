package com.tencent.open.p542b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.location.LocationManagerProxy;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6403p;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import java.util.TimeZone;

/* compiled from: ProGuard */
class C6380i implements Runnable {
    final /* synthetic */ Bundle f22189a;
    final /* synthetic */ boolean f22190b;
    final /* synthetic */ C6378g f22191c;

    C6380i(C6378g c6378g, Bundle bundle, boolean z) {
        this.f22191c = c6378g;
        this.f22189a = bundle;
        this.f22190b = z;
    }

    public void run() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("uin", "1000");
            bundle.putString("imei", C6374c.m29140b(C6395h.m29184a()));
            bundle.putString(UploadFile.DEVICE_IMSI_LABEL, C6374c.m29141c(C6395h.m29184a()));
            bundle.putString("android_id", C6374c.m29142d(C6395h.m29184a()));
            bundle.putString("mac", C6374c.m29137a());
            bundle.putString(LogBuilder.KEY_PLATFORM, "1");
            bundle.putString("os_ver", VERSION.RELEASE);
            bundle.putString("position", C6412y.m29258d(C6395h.m29184a()));
            bundle.putString(LocationManagerProxy.NETWORK_PROVIDER, C6372a.m29132a(C6395h.m29184a()));
            bundle.putString("language", C6374c.m29139b());
            bundle.putString("resolution", C6374c.m29138a(C6395h.m29184a()));
            bundle.putString("apn", C6372a.m29133b(C6395h.m29184a()));
            bundle.putString("model_name", Build.MODEL);
            bundle.putString("timezone", TimeZone.getDefault().getID());
            bundle.putString("sdk_ver", "2.9.1");
            bundle.putString("qz_ver", C6412y.m29259d(C6395h.m29184a(), "com.qzone"));
            bundle.putString("qq_ver", C6412y.m29255c(C6395h.m29184a(), "com.tencent.mobileqq"));
            bundle.putString("qua", C6412y.m29261e(C6395h.m29184a(), C6395h.m29186b()));
            bundle.putString("packagename", C6395h.m29186b());
            bundle.putString("app_ver", C6412y.m29259d(C6395h.m29184a(), C6395h.m29186b()));
            if (this.f22189a != null) {
                bundle.putAll(this.f22189a);
            }
            this.f22191c.f22183d.add(new C6373b(bundle));
            int size = this.f22191c.f22183d.size();
            int a = C6403p.m29203a(C6395h.m29184a(), null).m29212a("Agent_ReportTimeInterval");
            if (a == 0) {
                a = 10000;
            }
            if (this.f22191c.m29161a("report_via", size) || this.f22190b) {
                this.f22191c.m29166e();
                this.f22191c.f22185f.removeMessages(1001);
            } else if (!this.f22191c.f22185f.hasMessages(1001)) {
                Message obtain = Message.obtain();
                obtain.what = 1001;
                this.f22191c.f22185f.sendMessageDelayed(obtain, (long) a);
            }
        } catch (Throwable e) {
            C6367n.m29108b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
        }
    }
}
