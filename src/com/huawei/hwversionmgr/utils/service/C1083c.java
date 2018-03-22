package com.huawei.hwversionmgr.utils.service;

import android.text.TextUtils;
import com.huawei.hwversionmgr.p079a.C1067b;
import com.huawei.hwversionmgr.utils.C1080f;
import com.huawei.hwversionmgr.utils.p083a.C1074a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;

/* compiled from: UpdateService */
class C1083c extends C1074a {
    final /* synthetic */ UpdateService f2201a;

    C1083c(UpdateService updateService) {
        this.f2201a = updateService;
    }

    public void mo2345a(int i) {
        C2538c.m12680e("UpdateService", "handleCheckFailed: arg0 = " + i + " mCheck = " + this.f2201a.f2186k);
        if (this.f2201a.f2186k == 0) {
            if (i == 0) {
                C2538c.m12680e("UpdateService", "handleAutoCheckFailed() reason = FAILED_REASON_NOTFOUND");
                C1080f.m4599a(C1080f.m4595a(), this.f2201a.f2177b);
            }
            this.f2201a.m4623a(6);
        }
        if (this.f2201a.f2186k == 2) {
            if (i == 0 && !WeChat.HEALTH_PACKAGE_NAME.equals(this.f2201a.f2184i)) {
                C2538c.m12680e("UpdateService", "handleAutoCheckFailed() reason = FAILED_REASON_NOTFOUND");
                C1080f.m4599a(C1080f.m4595a(), this.f2201a.f2177b);
                C1080f.m4605c("", this.f2201a.f2177b);
            }
            this.f2201a.m4624a(11, i);
        }
        this.f2201a.stopSelf();
    }

    public void mo2346a(C1067b c1067b) {
        C2538c.m12677c("UpdateService", "enter handleManualCheckSuccess:");
        if (c1067b != null) {
            C2538c.m12677c("UpdateService", "arg0 = " + c1067b);
            this.f2201a.f2178c = c1067b.f2108l;
            this.f2201a.f2179d = c1067b.f2107k;
            this.f2201a.f2180e = (int) c1067b.f2106j;
            C2538c.m12677c("UpdateService", "handleManualCheckSuccess: mCheckNewVersionCode = " + this.f2201a.f2178c);
            this.f2201a.f2181f = c1067b.f2120x;
            this.f2201a.f2182g = c1067b.f2122z;
            this.f2201a.f2183h = c1067b.f2121y;
            this.f2201a.f2184i = c1067b.f2097a;
            C2538c.m12677c("UpdateService", "handleManualCheckSuccess: mAppMinCode = ", Integer.valueOf(this.f2201a.f2181f), "mAppForcedUpdate = ", this.f2201a.f2182g, "mForcedUpdate = ", this.f2201a.f2183h, "mPackageName = ", this.f2201a.f2184i);
            if (this.f2201a.f2186k == 0) {
                if (TextUtils.isEmpty(this.f2201a.f2178c)) {
                    C2538c.m12680e("UpdateService", "APP_AUTO_UPDATE: error, mCheckNewVersionCode is empty... ");
                    this.f2201a.m4623a(6);
                    this.f2201a.stopSelf();
                }
                if (TextUtils.isEmpty(this.f2201a.f2182g)) {
                    C1080f.m4599a(C1080f.m4595a(), this.f2201a.f2177b);
                } else {
                    C1080f.m4599a("", this.f2201a.f2177b);
                }
                C1080f.m4605c(this.f2201a.f2178c, this.f2201a.f2177b);
            }
            if (this.f2201a.f2186k == 2) {
                if (TextUtils.isEmpty(this.f2201a.f2178c)) {
                    C2538c.m12680e("UpdateService", "APP_MANUAL_UPDATE: error, mCheckNewVersionCode is empty... ");
                    this.f2201a.m4624a(11, 2);
                    this.f2201a.stopSelf();
                }
                if (WeChat.HEALTH_PACKAGE_NAME.equals(this.f2201a.f2184i)) {
                    this.f2201a.m4626a(12, (int) c1067b.f2106j, c1067b.f2107k, this.f2201a.f2182g, 0, this.f2201a.f2184i);
                } else {
                    if (TextUtils.isEmpty(this.f2201a.f2182g)) {
                        C1080f.m4599a(C1080f.m4595a(), this.f2201a.f2177b);
                    } else {
                        C1080f.m4599a("", this.f2201a.f2177b);
                    }
                    C1080f.m4605c(this.f2201a.f2178c, this.f2201a.f2177b);
                    this.f2201a.m4625a(12, (int) c1067b.f2106j, c1067b.f2107k, this.f2201a.f2182g, 0);
                }
            }
            C2538c.m12677c("UpdateService", "handleManualCheckSuccess() NAME=" + c1067b.f2097a + ", DESCRIPTION=" + c1067b.f2099c + ", CREATETIME=" + c1067b.f2101e + ", BYTESIZE=" + c1067b.f2106j + ", VERSION_NAME=" + c1067b.f2107k + ", VERSION_CODE=" + c1067b.f2108l);
            this.f2201a.m4641b();
        }
    }
}
