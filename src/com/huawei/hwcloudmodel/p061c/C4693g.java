package com.huawei.hwcloudmodel.p061c;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.callback.C4691b;
import com.huawei.hwcloudmodel.model.userprofile.GetUserMergeInfoRsp;
import com.huawei.p190v.C2538c;

/* compiled from: HWCloudUtils */
class C4693g implements C4691b {
    final /* synthetic */ C3957a f17125a;
    final /* synthetic */ C4689d f17126b;

    C4693g(C4689d c4689d, C3957a c3957a) {
        this.f17126b = c4689d;
        this.f17125a = c3957a;
    }

    public void mo4556a(String str) {
        C2538c.c("HWCloudUtils", new Object[]{"getUserMergeInfo in operationResult"});
        try {
            GetUserMergeInfoRsp getUserMergeInfoRsp = (GetUserMergeInfoRsp) new Gson().fromJson(str, GetUserMergeInfoRsp.class);
            if (getUserMergeInfoRsp == null) {
                return;
            }
            if (getUserMergeInfoRsp.getResultCode() == 0) {
                C2538c.c("HWCloudUtils", new Object[]{"getUserMergeInfo in operationResult successful"});
                this.f17125a.mo4330a(getUserMergeInfoRsp, null, true);
                return;
            }
            C2538c.c("HWCloudUtils", new Object[]{"getUserMergeInfo in operationResult fail:" + getUserMergeInfoRsp.getResultCode()});
            this.f17125a.mo4330a(null, "" + getUserMergeInfoRsp.getResultCode(), false);
        } catch (JsonSyntaxException e) {
            C2538c.c("HWCloudUtils", new Object[]{"getUserMergeInfo json exception :" + e.getMessage()});
            this.f17125a.mo4330a(null, e.getMessage(), false);
        }
    }

    public void mo4555a(int i, Exception exception) {
        C2538c.c("HWCloudUtils", new Object[]{"getUserMergeInfoEXCEPTION code:" + i + ", message:" + exception.getMessage()});
        this.f17125a.mo4330a(null, exception.getMessage(), false);
    }
}
