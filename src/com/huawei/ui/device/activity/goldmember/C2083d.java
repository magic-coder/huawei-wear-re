package com.huawei.ui.device.activity.goldmember;

import com.huawei.membercenter.sdk.membersdklibrary.api.MemberServiceAPI.IActiveMemberCallback;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.RetCode;
import com.huawei.p190v.C2538c;

/* compiled from: VIPMemberActivationActivity */
class C2083d implements IActiveMemberCallback {
    final /* synthetic */ VIPMemberActivationActivity f7363a;

    C2083d(VIPMemberActivationActivity vIPMemberActivationActivity) {
        this.f7363a = vIPMemberActivationActivity;
    }

    public void callback(String str, String str2, int i) {
        C2538c.m12677c(VIPMemberActivationActivity.f7291e, "retCode = " + str + "，retMsg = " + str2 + ",memLevel = " + i);
        if (str.equals("-1")) {
            C2538c.m12680e(VIPMemberActivationActivity.f7291e, "RetCode.FAILED");
            this.f7363a.f7299i.sendEmptyMessage(2);
        } else if ("0".equals(str) || "200".equals(str)) {
            C2538c.m12677c(VIPMemberActivationActivity.f7291e, "RetCode.SUCCESS! ");
            this.f7363a.f7299i.sendEmptyMessage(3);
            this.f7363a.f7299i.sendEmptyMessage(1);
            if (this.f7363a.f7296f == 0) {
                this.f7363a.m10783a(VIPUserInfoActivity.class);
                this.f7363a.finish();
            } else if (this.f7363a.f7296f == 1) {
                this.f7363a.finish();
            }
        } else if (RetCode.FAILED_301001.equals(str)) {
            this.f7363a.f7299i.sendEmptyMessage(4);
            C2538c.m12677c(VIPMemberActivationActivity.f7291e, "response Failure not huawei phone!");
        } else {
            this.f7363a.f7299i.sendEmptyMessage(2);
            C2538c.m12677c(VIPMemberActivationActivity.f7291e, "response Failure not huawei phone!");
        }
    }
}
