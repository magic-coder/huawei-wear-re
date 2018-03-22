package com.huawei.ui.device.activity.goldmember;

import com.huawei.ab.C0630m;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.membercenter.sdk.membersdklibrary.api.MemberServiceAPI.IQueryMemberStatusCallback;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.MemberStatus;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.RetCode;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.i;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: VIPUserInfoActivity */
class C2088i implements IQueryMemberStatusCallback {
    final /* synthetic */ VIPUserInfoActivity f7368a;

    C2088i(VIPUserInfoActivity vIPUserInfoActivity) {
        this.f7368a = vIPUserInfoActivity;
    }

    public void callback(String str, String str2, MemberStatus memberStatus) {
        C2538c.m12677c(VIPUserInfoActivity.f7302d, "retCode = " + str + ", retMsg = " + str2);
        this.f7368a.f7327W.sendEmptyMessage(7);
        if (memberStatus == null) {
            C2538c.m12680e(VIPUserInfoActivity.f7302d, "memberStatus is null!");
            return;
        }
        this.f7368a.f7352z = C0977d.m3524a(memberStatus.getMemAdLevel(), 0);
        this.f7368a.f7351y = memberStatus.getMemLevel();
        this.f7368a.f7330a = memberStatus.getExpireTime();
        this.f7368a.f7305A = memberStatus.getLevelName();
        this.f7368a.f7306B = memberStatus.getLevelIconUrl();
        this.f7368a.f7307C = memberStatus.getIntentLevelName();
        if (this.f7368a.f7305A != null) {
            this.f7368a.f7309E = this.f7368a.f7305A;
        } else {
            this.f7368a.f7309E = this.f7368a.f7311G.getResources().getString(i.IDS_main_sns_member_gold);
        }
        if (str.equals(RetCode.SUC_300001)) {
            this.f7368a.f7327W.sendEmptyMessage(2);
        } else if (str.equals(RetCode.SUC_CAN_BE_UPGRADED)) {
            this.f7368a.f7327W.sendEmptyMessage(1);
        } else if (str.equals("0")) {
            this.f7368a.f7327W.sendEmptyMessage(4);
        } else {
            this.f7368a.f7327W.sendEmptyMessage(5);
            return;
        }
        C2538c.m12677c(VIPUserInfoActivity.f7302d, "retCode1 = " + str + ", retMsg = " + str2 + ",memLevel =" + this.f7368a.f7351y + ", memAdLevel = " + this.f7368a.f7352z + ", expireTime =" + this.f7368a.f7330a + ", curTime = " + memberStatus.getCurTime() + ",levelName = " + this.f7368a.f7305A + "levelIconUrl=" + this.f7368a.f7306B);
        String curTime = memberStatus.getCurTime();
        if (curTime != null) {
            try {
                Date parse = new SimpleDateFormat("yyyy/MM/dd").parse(curTime);
                this.f7368a.f7331b = parse.getTime();
                C2538c.m12677c(VIPUserInfoActivity.f7302d, "curTime = " + this.f7368a.f7331b);
            } catch (ParseException e) {
                C2538c.m12680e(VIPUserInfoActivity.f7302d, "ParseException = " + e.getMessage());
            }
        }
        C0630m.m2297a(this.f7368a.f7311G).m2306a(this.f7368a.f7328X);
        this.f7368a.f7327W.sendEmptyMessage(0);
    }
}
