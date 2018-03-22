package com.huawei.hwcloudmodel.p061c;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.callback.C4691b;
import com.huawei.hwcloudmodel.model.userprofile.AddPrivacyRecordRsp;
import com.huawei.p190v.C2538c;

/* compiled from: HWCloudUtils */
class C4701n implements C4691b {
    final /* synthetic */ C3957a f17139a;
    final /* synthetic */ C4689d f17140b;

    C4701n(C4689d c4689d, C3957a c3957a) {
        this.f17140b = c4689d;
        this.f17139a = c3957a;
    }

    public void mo4556a(String str) {
        C2538c.c("HWCloudUtils", new Object[]{"addPrivacyRecord  in operationResult"});
        try {
            AddPrivacyRecordRsp addPrivacyRecordRsp = (AddPrivacyRecordRsp) new Gson().fromJson(str, AddPrivacyRecordRsp.class);
            if (addPrivacyRecordRsp == null) {
                return;
            }
            if (addPrivacyRecordRsp.getResultCode() == 0) {
                C2538c.c("HWCloudUtils", new Object[]{"addPrivacyRecord  in operationResult successful"});
                this.f17139a.mo4330a(addPrivacyRecordRsp, null, true);
                return;
            }
            C2538c.c("HWCloudUtils", new Object[]{"addPrivacyRecord  in operationResult fail:" + addPrivacyRecordRsp.getResultCode()});
            this.f17139a.mo4330a(null, "code:" + addPrivacyRecordRsp.getResultCode(), false);
        } catch (JsonSyntaxException e) {
            C2538c.c("HWCloudUtils", new Object[]{"addPrivacyRecord  json exception :" + e.getMessage()});
            this.f17139a.mo4330a(null, e.getMessage(), false);
        }
    }

    public void mo4555a(int i, Exception exception) {
        C2538c.c("HWCloudUtils", new Object[]{"addPrivacyRecord EXCEPTION code:" + i + ", message:" + exception.getMessage()});
        this.f17139a.mo4330a(null, exception.getMessage(), false);
    }
}
