package com.tencent.open.p542b;

import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6403p;
import com.tencent.open.p541a.C6367n;

/* compiled from: ProGuard */
class C6381j implements Runnable {
    final /* synthetic */ long f22192a;
    final /* synthetic */ String f22193b;
    final /* synthetic */ String f22194c;
    final /* synthetic */ int f22195d;
    final /* synthetic */ long f22196e;
    final /* synthetic */ long f22197f;
    final /* synthetic */ boolean f22198g;
    final /* synthetic */ C6378g f22199h;

    C6381j(C6378g c6378g, long j, String str, String str2, int i, long j2, long j3, boolean z) {
        this.f22199h = c6378g;
        this.f22192a = j;
        this.f22193b = str;
        this.f22194c = str2;
        this.f22195d = i;
        this.f22196e = j2;
        this.f22197f = j3;
        this.f22198g = z;
    }

    public void run() {
        int i = 1;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f22192a;
            Bundle bundle = new Bundle();
            String a = C6372a.m29132a(C6395h.m29184a());
            bundle.putString("apn", a);
            bundle.putString("appid", "1000067");
            bundle.putString("commandid", this.f22193b);
            bundle.putString("detail", this.f22194c);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("network=").append(a).append('&');
            stringBuilder.append("sdcard=").append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0).append('&');
            stringBuilder.append("wifi=").append(C6372a.m29136e(C6395h.m29184a()));
            bundle.putString("deviceInfo", stringBuilder.toString());
            int a2 = 100 / this.f22199h.m29156a(this.f22195d);
            if (a2 > 0) {
                if (a2 > 100) {
                    i = 100;
                } else {
                    i = a2;
                }
            }
            bundle.putString("frequency", i + "");
            bundle.putString("reqSize", this.f22196e + "");
            bundle.putString("resultCode", this.f22195d + "");
            bundle.putString("rspSize", this.f22197f + "");
            bundle.putString("timeCost", elapsedRealtime + "");
            bundle.putString("uin", "1000");
            this.f22199h.f22182c.add(new C6373b(bundle));
            int size = this.f22199h.f22182c.size();
            i = C6403p.m29203a(C6395h.m29184a(), null).m29212a("Agent_ReportTimeInterval");
            if (i == 0) {
                i = 10000;
            }
            if (this.f22199h.m29161a("report_cgi", size) || this.f22198g) {
                this.f22199h.m29163b();
                this.f22199h.f22185f.removeMessages(1000);
            } else if (!this.f22199h.f22185f.hasMessages(1000)) {
                Message obtain = Message.obtain();
                obtain.what = 1000;
                this.f22199h.f22185f.sendMessageDelayed(obtain, (long) i);
            }
        } catch (Throwable e) {
            C6367n.m29108b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
        }
    }
}
