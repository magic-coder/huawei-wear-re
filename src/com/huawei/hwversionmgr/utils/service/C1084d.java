package com.huawei.hwversionmgr.utils.service;

import android.text.TextUtils;
import com.huawei.hwversionmgr.p079a.C1067b;
import com.huawei.hwversionmgr.utils.C1080f;
import com.huawei.hwversionmgr.utils.p083a.C1074a;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateService */
class C1084d extends C1074a {
    final /* synthetic */ UpdateService f2202a;

    C1084d(UpdateService updateService) {
        this.f2202a = updateService;
    }

    public void mo2345a(int i) {
        C2538c.m12680e("UpdateService", "mBandCheckNewVersion HandlerhandleCheckFailed: arg0 = " + i + " mCheck = " + this.f2202a.f2187l);
        if (this.f2202a.f2187l == 1) {
            if (i == 0) {
                C2538c.m12680e("UpdateService", "mBandCheckNewVersionHandler handleAutoCheckFailed() reason = FAILED_REASON_NOTFOUND");
                C1080f.m4601b(C1080f.m4595a(), this.f2202a.f2177b);
            }
            C1080f.m4611f("", this.f2202a.f2177b);
            this.f2202a.m4623a(8);
        }
        if (this.f2202a.f2187l == 3) {
            if (i == 0) {
                C2538c.m12680e("UpdateService", "mBandCheckNewVersionHandler handleAutoCheckFailed() reason = FAILED_REASON_NOTFOUND");
                C1080f.m4611f("", this.f2202a.f2177b);
                C1080f.m4601b(C1080f.m4595a(), this.f2202a.f2177b);
            }
            this.f2202a.m4624a(11, i);
        }
        this.f2202a.stopSelf();
    }

    public void mo2346a(C1067b c1067b) {
        C2538c.m12677c("UpdateService", "mBandCheckNewVersionHandler handleManualCheckSuccess: arg0 = " + c1067b + " mCheck = " + this.f2202a.f2187l);
        if (c1067b != null) {
            this.f2202a.f2178c = c1067b.f2108l;
            this.f2202a.f2179d = c1067b.f2107k;
            this.f2202a.f2180e = (int) c1067b.f2106j;
            C2538c.m12677c("UpdateService", "mBandCheckNewVersionHandler handleManualCheckSuccess: mCheckNewVersionCode = " + this.f2202a.f2178c);
            this.f2202a.f2181f = c1067b.f2120x;
            this.f2202a.f2182g = c1067b.f2122z;
            this.f2202a.f2183h = c1067b.f2121y;
            this.f2202a.f2184i = c1067b.f2097a;
            C2538c.m12677c("UpdateService", "mBandCheckNewVersionHandler handleManualCheckSuccess: mAppMinCode = ", Integer.valueOf(this.f2202a.f2181f), "mAppForcedUpdate = ", this.f2202a.f2182g, "mForcedUpdate = ", this.f2202a.f2183h, "mPackageName = ", this.f2202a.f2184i);
            if (this.f2202a.f2187l == 1) {
                C1080f.m4611f(this.f2202a.f2179d, this.f2202a.f2177b);
                if (!TextUtils.isEmpty(this.f2202a.f2183h)) {
                    C1080f.m4601b("", this.f2202a.f2177b);
                }
            }
            if (this.f2202a.f2187l == 3) {
                C1080f.m4611f(this.f2202a.f2179d, this.f2202a.f2177b);
                if (TextUtils.isEmpty(this.f2202a.f2183h)) {
                    C1080f.m4601b(C1080f.m4595a(), this.f2202a.f2177b);
                } else {
                    C1080f.m4601b("", this.f2202a.f2177b);
                }
                this.f2202a.m4625a(12, (int) c1067b.f2106j, c1067b.f2107k, this.f2202a.f2183h, this.f2202a.f2181f);
            }
            C2538c.m12677c("UpdateService", "mBandCheckNewVersionHandler handleManualCheckSuccess() NAME=" + c1067b.f2097a + ", DESCRIPTION=" + c1067b.f2099c + ", CREATETIME=" + c1067b.f2101e + ", BYTESIZE=" + c1067b.f2106j + ", VERSION_NAME=" + c1067b.f2107k + ", VERSION_CODE=" + c1067b.f2108l);
            this.f2202a.m4648c();
        }
    }
}
