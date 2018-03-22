package com.huawei.hwcloudmodel.p061c;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.callback.C4691b;
import com.huawei.hwcloudmodel.model.userprofile.GetPrivacyRecordRsp;
import com.huawei.p190v.C2538c;

/* compiled from: HWCloudUtils */
class C4702o implements C4691b {
    final /* synthetic */ C3957a f17141a;
    final /* synthetic */ C4689d f17142b;

    C4702o(C4689d c4689d, C3957a c3957a) {
        this.f17142b = c4689d;
        this.f17141a = c3957a;
    }

    public void mo4556a(String str) {
        C2538c.c("HWCloudUtils", new Object[]{"getPrivacyRecord  in operationResult"});
        try {
            GetPrivacyRecordRsp getPrivacyRecordRsp = (GetPrivacyRecordRsp) new Gson().fromJson(str, GetPrivacyRecordRsp.class);
            if (getPrivacyRecordRsp == null) {
                return;
            }
            if (getPrivacyRecordRsp.getResultCode() == 0) {
                C2538c.c("HWCloudUtils", new Object[]{"getPrivacyRecord  in operationResult successful"});
                this.f17141a.mo4330a(getPrivacyRecordRsp, null, true);
                return;
            }
            C2538c.c("HWCloudUtils", new Object[]{"getPrivacyRecord  in operationResult fail:" + getPrivacyRecordRsp.getResultCode()});
            this.f17141a.mo4330a(null, "code:" + getPrivacyRecordRsp.getResultCode(), false);
        } catch (JsonSyntaxException e) {
            C2538c.c("HWCloudUtils", new Object[]{"getPrivacyRecord  json exception :" + e.getMessage()});
            this.f17141a.mo4330a(null, e.getMessage(), false);
        }
    }

    public void mo4555a(int i, Exception exception) {
        C2538c.c("HWCloudUtils", new Object[]{"getPrivacyRecord EXCEPTION code:" + i + ", message:" + exception.getMessage()});
        this.f17141a.mo4330a(null, exception.getMessage(), false);
    }
}
