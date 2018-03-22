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
class C2467h implements IBaseResponseCallback {
    final /* synthetic */ String f8873a;
    final /* synthetic */ int f8874b;
    final /* synthetic */ C2465f f8875c;

    C2467h(C2465f c2465f, String str, int i) {
        this.f8875c = c2465f;
        this.f8873a = str;
        this.f8874b = i;
    }

    public void onResponse(int i, Object obj) {
        UserInfomation userInfomation = (UserInfomation) obj;
        C2538c.m12677c("UserProfileSettingsInteractors", "用户选择的单位值是" + this.f8873a);
        if (userInfomation == null) {
            C2538c.m12680e("UserProfileSettingsInteractors", "weightSetUserInfoGet is null!!");
            return;
        }
        int c = C0977d.m3546c(this.f8875c.f8859m, this.f8875c.f8856j.getFisrtPickerValue());
        int clientSet;
        if (this.f8874b == 0) {
            C2538c.m12677c("UserProfileSettingsInteractors", "WEIGHT_UNIT_KG == weight_type");
            this.f8875c.f8867v = c;
            this.f8875c.f8869x = e.g(c);
            c = this.f8875c.f8867v;
            if (c < 10 || c > 250) {
                c = 10;
            }
            C2538c.m12677c("UserProfileSettingsInteractors", "用户修改后的weight_kg =" + this.f8875c.f8867v + "KG..........weight_lb = " + this.f8875c.f8869x + "lb.");
            C2538c.m12677c("UserProfileSettingsInteractors", "weightSetUserInfoGet.setUnitType(weightTypeUpdatedInt) = " + this.f8874b + ", iWeight= " + c);
            clientSet = userInfomation.getClientSet();
            userInfomation.setClientSet(Integer.valueOf(0));
            userInfomation.setWeight(Integer.valueOf(c));
            if (C0969i.m3482a(35)) {
                C0956c.m3348a(false);
            }
            if (clientSet != 0) {
                c = userInfomation.getHeight() / 12;
                userInfomation.setHeight(Integer.valueOf(e.b(c, userInfomation.getHeight() - (c * 12))));
            }
        } else {
            C2538c.m12677c("UserProfileSettingsInteractors", "WEIGHT_UNIT_lb == weight_type");
            this.f8875c.f8869x = c;
            this.f8875c.f8867v = e.f(c);
            c = this.f8875c.f8869x;
            if (c < 22 || c > 552) {
                c = 22;
            }
            C2538c.m12677c("UserProfileSettingsInteractors", "用户修改后的weight_lb =" + this.f8875c.f8869x + "lb..........weight = " + this.f8875c.f8867v + "kg.");
            C2538c.m12677c("UserProfileSettingsInteractors", "weightSetUserInfoGet.setUnitType(weightTypeUpdatedInt) = " + this.f8874b + ", iWeight= " + c);
            clientSet = userInfomation.getClientSet();
            userInfomation.setClientSet(Integer.valueOf(1));
            userInfomation.setWeight(Integer.valueOf(c));
            if (C0969i.m3482a(35)) {
                C0956c.m3348a(true);
            }
            if (clientSet != 1) {
                userInfomation.setHeight(Integer.valueOf(e.e(userInfomation.getHeight())));
            }
        }
        if (C0630m.m2297a(this.f8875c.f8859m).m2320e()) {
            userInfomation.setGender(Integer.valueOf(-1000));
            userInfomation.setName(null);
            userInfomation.setBirthday("");
            userInfomation.setPicPath("");
        }
        C2538c.m12677c("UserProfileSettingsInteractors", "给数据库中存值weightSetUserInfoGet！" + userInfomation.toString());
        this.f8875c.m12318a(this.f8875c.f8859m, userInfomation, new C2468i(this));
    }
}
