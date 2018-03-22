package com.huawei.hwversionmgr.utils.service;

import com.huawei.hwversionmgr.p079a.C1066a;
import com.huawei.hwversionmgr.utils.p083a.C1075b;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;

/* compiled from: UpdateService */
class C1088h extends C1075b {
    final /* synthetic */ UpdateService f2206a;

    C1088h(UpdateService updateService) {
        this.f2206a = updateService;
    }

    public void mo2349a(int i) {
        C2538c.m12680e("UpdateService", "doDownloadFailed: arg0 = " + i);
        this.f2206a.m4624a(22, i);
    }

    public void mo2351b(C1066a c1066a) {
        C2538c.m12677c("UpdateService", "doDownloadSuccess: arg0 = " + c1066a);
        String str = c1066a.f2096e;
        C2538c.m12677c("UpdateService", "doDownloadSuccess: mCheckNewVersionCode = " + this.f2206a.f2178c + ", strAppStorePath = " + str);
        if (this.f2206a.f2188m == 0 || this.f2206a.f2188m == 2) {
            if (!WeChat.HEALTH_PACKAGE_NAME.equals(this.f2206a.f2184i)) {
                String str2 = "UpdateService";
                Object[] objArr = new Object[1];
                objArr[0] = "doDownloadSuccess APP_AUTO_UPDATE: !isSameApkSignatures(mContext, strAppStorePath) = " + (!this.f2206a.m4637a(this.f2206a.f2177b, str));
                C2538c.m12677c(str2, objArr);
                if (!this.f2206a.m4637a(this.f2206a.f2177b, str)) {
                    this.f2206a.m4624a(22, 47);
                    return;
                }
            }
            this.f2206a.f2189n.m4519d(str);
            this.f2206a.f2189n.m4522f(this.f2206a.f2178c);
        }
        if (this.f2206a.f2188m == 1 || this.f2206a.f2188m == 3) {
            this.f2206a.f2189n.m4515b(str);
            this.f2206a.f2189n.m4520e(this.f2206a.f2178c);
        }
        this.f2206a.m4624a(23, 0);
    }

    public void mo2350a(C1066a c1066a) {
        C2538c.m12677c("UpdateService", "doInDownloadProgress: arg0 = " + c1066a);
        C2538c.m12677c("UpdateService", "doInDownloadProgress() total=" + c1066a.f2093b + ",cur=" + c1066a.f2092a);
        this.f2206a.m4624a(21, (int) ((c1066a.f2092a * 100) / c1066a.f2093b));
    }
}
