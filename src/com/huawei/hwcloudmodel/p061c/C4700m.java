package com.huawei.hwcloudmodel.p061c;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.callback.C4691b;
import com.huawei.hwcloudmodel.model.userprofile.DeleteUserProfileRsp;
import com.huawei.p190v.C2538c;

/* compiled from: HWCloudUtils */
class C4700m implements C4691b {
    final /* synthetic */ C3957a f17137a;
    final /* synthetic */ C4689d f17138b;

    C4700m(C4689d c4689d, C3957a c3957a) {
        this.f17138b = c4689d;
        this.f17137a = c3957a;
    }

    public void mo4556a(String str) {
        C2538c.c("HWCloudUtils", new Object[]{"deleteUserProfile in operationResult"});
        try {
            DeleteUserProfileRsp deleteUserProfileRsp = (DeleteUserProfileRsp) new Gson().fromJson(str, DeleteUserProfileRsp.class);
            if (deleteUserProfileRsp == null) {
                return;
            }
            if (deleteUserProfileRsp.getResultCode() == 0) {
                C2538c.c("HWCloudUtils", new Object[]{"deleteUserProfile in operationResult successful"});
                this.f17137a.mo4330a(deleteUserProfileRsp, null, true);
                return;
            }
            C2538c.c("HWCloudUtils", new Object[]{"deleteUserProfile in operationResult fail:" + deleteUserProfileRsp.getResultCode()});
            this.f17137a.mo4330a(null, "code:" + deleteUserProfileRsp.getResultCode(), false);
        } catch (JsonSyntaxException e) {
            C2538c.c("HWCloudUtils", new Object[]{"deleteUserProfile json exception :" + e.getMessage()});
            this.f17137a.mo4330a(null, e.getMessage(), false);
        }
    }

    public void mo4555a(int i, Exception exception) {
        C2538c.c("HWCloudUtils", new Object[]{"deleteUserProfileEXCEPTION code:" + i + ", message:" + exception.getMessage()});
        this.f17137a.mo4330a(null, exception.getMessage(), false);
    }
}
