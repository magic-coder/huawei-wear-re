package com.huawei.hwcloudmodel.p061c;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.callback.C4691b;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataRsp;
import com.huawei.p190v.C2538c;

/* compiled from: HWCloudUtils */
class C4692f implements C4691b {
    final /* synthetic */ C3957a f17123a;
    final /* synthetic */ C4689d f17124b;

    C4692f(C4689d c4689d, C3957a c3957a) {
        this.f17124b = c4689d;
        this.f17123a = c3957a;
    }

    public void mo4556a(String str) {
        C2538c.c("HWCloudUtils", new Object[]{"mergeUserAllData  in operationResult"});
        try {
            MergeUserAllDataRsp mergeUserAllDataRsp = (MergeUserAllDataRsp) new Gson().fromJson(str, MergeUserAllDataRsp.class);
            if (mergeUserAllDataRsp == null) {
                C2538c.c("HWCloudUtils", new Object[]{"mergeUserAllData  in operationResult fail"});
                this.f17123a.mo4330a(null, "1", false);
            } else if (mergeUserAllDataRsp.getResultCode() == 0) {
                C2538c.c("HWCloudUtils", new Object[]{"mergeUserAllData  in operationResult successful"});
                this.f17123a.mo4330a(mergeUserAllDataRsp, null, true);
            } else {
                C2538c.c("HWCloudUtils", new Object[]{"mergeUserAllData  in operationResult fail:" + mergeUserAllDataRsp.getResultCode()});
                this.f17123a.mo4330a(null, "" + mergeUserAllDataRsp.getResultCode(), false);
            }
        } catch (JsonSyntaxException e) {
            C2538c.c("HWCloudUtils", new Object[]{"mergeUserAllData  json exception :" + e.getMessage()});
            this.f17123a.mo4330a(null, e.getMessage(), false);
        }
    }

    public void mo4555a(int i, Exception exception) {
        C2538c.c("HWCloudUtils", new Object[]{"mergeUserAllData EXCEPTION code:" + i + ", message:" + exception.getMessage()});
        this.f17123a.mo4330a(null, exception.getMessage(), false);
    }
}
