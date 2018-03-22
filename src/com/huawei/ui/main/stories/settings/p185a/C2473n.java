package com.huawei.ui.main.stories.settings.p185a;

import com.huawei.ab.C0630m;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.d.e;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

/* compiled from: UserProfileSettingsInteractors */
class C2473n implements IBaseResponseCallback {
    final /* synthetic */ String f8881a;
    final /* synthetic */ int f8882b;
    final /* synthetic */ C2465f f8883c;

    C2473n(C2465f c2465f, String str, int i) {
        this.f8883c = c2465f;
        this.f8881a = str;
        this.f8882b = i;
    }

    public void onResponse(int i, Object obj) {
        UserInfomation userInfomation = (UserInfomation) obj;
        C2538c.m12677c("UserProfileSettingsInteractors", "用户选择的单位值是" + this.f8881a);
        if (userInfomation == null) {
            C2538c.m12680e("UserProfileSettingsInteractors", "heightSetUserInfoGet is null!!");
            return;
        }
        int c = C0977d.m3546c(this.f8883c.f8859m, this.f8883c.f8854h.getFisrtPickerValue());
        int clientSet;
        if (1 == this.f8882b) {
            int c2 = C0977d.m3546c(this.f8883c.f8859m, this.f8883c.f8854h.getSecondPickerValue());
            this.f8883c.f8863q = e.a(c, c2);
            this.f8883c.f8862p = e.b(c, c2);
            C2538c.m12677c("UserProfileSettingsInteractors", "HEIGHT_UNIT_FT == heightSetUserInfoGetInt, 用户修改后的height_ft =" + this.f8883c.f8863q + "FT.，height = " + this.f8883c.f8862p + "cm.");
            c = this.f8883c.f8863q;
            if (c < 12 || c > 107) {
                c = 12;
            }
            C2538c.m12677c("UserProfileSettingsInteractors", "给数据库中存值 unitTypeUpdatedFt=====" + 1);
            clientSet = userInfomation.getClientSet();
            userInfomation.setClientSet(Integer.valueOf(1));
            userInfomation.setHeight(Integer.valueOf(c));
            if (C0969i.m3482a(35)) {
                C0956c.m3348a(true);
            }
            if (clientSet != 1) {
                userInfomation.setWeight(Integer.valueOf(e.g(userInfomation.getWeight())));
            }
        } else {
            this.f8883c.f8862p = c;
            this.f8883c.f8863q = e.e(c);
            C2538c.m12677c("UserProfileSettingsInteractors", "用户修改后的height_ft =" + this.f8883c.f8863q + "FT..........height = " + this.f8883c.f8862p + "cm.");
            c = this.f8883c.f8862p;
            if (c < 50 || c > 250) {
                c = 50;
            }
            clientSet = userInfomation.getClientSet();
            userInfomation.setClientSet(Integer.valueOf(0));
            userInfomation.setHeight(Integer.valueOf(c));
            if (C0969i.m3482a(35)) {
                C0956c.m3348a(false);
            }
            if (clientSet != 0) {
                userInfomation.setWeight(Integer.valueOf(e.f(userInfomation.getWeight())));
            }
        }
        if (C0630m.m2297a(this.f8883c.f8859m).m2320e()) {
            userInfomation.setGender(Integer.valueOf(-1000));
            userInfomation.setName(null);
            userInfomation.setBirthday("");
            userInfomation.setPicPath("");
        }
        C2538c.m12677c("UserProfileSettingsInteractors", "给数据库中存值 heightSetUserInfoGet ：" + userInfomation.toString());
        this.f8883c.m12318a(this.f8883c.f8859m, userInfomation, new C2474o(this));
    }
}
