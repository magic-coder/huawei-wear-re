package com.huawei.ui.device.p170a;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.login.ui.login.C1093a;
import com.huawei.membercenter.sdk.membersdklibrary.api.MemberServiceAPI.IQueryMemberStatusCallback;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.MemberStatus;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.RetCode;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiGoldMemberInteractors */
class ac implements IQueryMemberStatusCallback {
    final /* synthetic */ ab f6858a;

    ac(ab abVar) {
        this.f6858a = abVar;
    }

    public void callback(String str, String str2, MemberStatus memberStatus) {
        C2538c.m12677c("HuaweiGoldMemberInteractors", "s =" + str + " + s1 =" + str2 + " + memberStatus = " + memberStatus);
        this.f6858a.f6857a.f6974l.sendEmptyMessage(13);
        if (RetCode.FAILED_301003.equals(str)) {
            C2538c.m12677c("HuaweiGoldMemberInteractors", "用户登录华为账号有效期已过 ");
            this.f6858a.f6857a.f6974l.sendEmptyMessage(5);
            C1093a.m4739a(BaseApplication.m2632b()).m4757j();
        } else if (str.equals("-1")) {
            C2538c.m12680e("HuaweiGoldMemberInteractors", "RetCode.FAILED");
            this.f6858a.f6857a.f6974l.sendEmptyMessage(6);
        } else if (memberStatus == null) {
            C2538c.m12677c("HuaweiGoldMemberInteractors", "memberStatus is null! ");
        } else {
            this.f6858a.f6857a.f6973k = C0977d.m3524a(memberStatus.getMemAdLevel(), 0);
            C2538c.m12677c("HuaweiGoldMemberInteractors", "retCode = " + str + ",retMsg = " + str2 + ",memLevel =" + memberStatus.getMemLevel() + ", memAdLevel = " + memberStatus.getMemAdLevel() + ", expireTime =" + memberStatus.getExpireTime());
            if (RetCode.SUC_300002.equals(str)) {
                C2538c.m12677c("HuaweiGoldMemberInteractors", "goto enterGoldCardActivationActivity! ");
                this.f6858a.f6857a.m10475b();
            } else if ("0".equals(str) || RetCode.SUC_300001.equals(str) || RetCode.SUC_CAN_BE_UPGRADED.equals(str)) {
                C2538c.m12677c("HuaweiGoldMemberInteractors", "toIntent VIPUserInfoActivity  ");
                this.f6858a.f6857a.m10476c();
            } else if (RetCode.FAILED_200001.equals(str)) {
                C2538c.m12680e("HuaweiGoldMemberInteractors", "RetCode = 200001, retMsg = " + str2);
                this.f6858a.f6857a.f6974l.sendEmptyMessage(6);
            }
        }
    }
}
