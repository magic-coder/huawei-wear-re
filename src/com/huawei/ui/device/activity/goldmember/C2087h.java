package com.huawei.ui.device.activity.goldmember;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.d.f;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

/* compiled from: VIPUserInfoActivity */
class C2087h implements IBaseResponseCallback {
    final /* synthetic */ VIPUserInfoActivity f7367a;

    C2087h(VIPUserInfoActivity vIPUserInfoActivity) {
        this.f7367a = vIPUserInfoActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c(VIPUserInfoActivity.f7302d, "Enter onResponse() : err_code = " + i + " ; objData = " + obj);
        if (i == 0) {
            this.f7367a.f7344p = (UserInfomation) obj;
            this.f7367a.f7343o = this.f7367a.f7344p.getPicPath();
            C2538c.m12677c(VIPUserInfoActivity.f7302d, "Enter onResponse() mUserInfo=" + this.f7367a.f7344p + " ; headImgPath=" + this.f7367a.f7343o);
            if (this.f7367a.f7343o != null) {
                this.f7367a.f7342n = f.a(this.f7367a.f7311G, this.f7367a.f7343o);
            }
            this.f7367a.f7327W.sendEmptyMessage(3);
        }
    }
}
