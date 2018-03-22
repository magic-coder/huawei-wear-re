package com.huawei.ui.main.stories.settings.p185a;

import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.i;
import com.huawei.ui.main.j;
import com.huawei.up.model.UserInfomation;

/* compiled from: UserProfileSettingsInteractors */
class C2475p implements IBaseResponseCallback {
    final /* synthetic */ C2465f f8885a;

    C2475p(C2465f c2465f) {
        this.f8885a = c2465f;
    }

    public void onResponse(int i, Object obj) {
        UserInfomation userInfomation = (UserInfomation) obj;
        if (userInfomation != null) {
            int i2;
            C2538c.m12677c("UserProfileSettingsInteractors", "heightSetUserInfoGet1 = " + userInfomation.toString());
            int clientSet = userInfomation.getClientSet();
            int height = userInfomation.getHeight();
            C2538c.m12677c("UserProfileSettingsInteractors", "heightValue1= " + height + ",unitTypeGet1=" + clientSet);
            this.f8885a.m12317a(clientSet);
            if (clientSet == 0) {
                if (userInfomation.getWeight() > 250) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud weight > MAX_WEIGHT_KG,change to MAX_WEIGHT_KG.");
                    this.f8885a.m12329e(250);
                } else {
                    this.f8885a.m12329e(userInfomation.getWeight());
                }
                if (10 > userInfomation.getWeight()) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud weight < MIN_WEIGHT_KG,change to MIN_WEIGHT_KG.");
                    this.f8885a.m12329e(10);
                } else {
                    this.f8885a.m12329e(userInfomation.getWeight());
                }
                if (userInfomation.getHeight() > 250) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud height > MAX_HEIGHT_CM,change to MAX_HEIGHT_CM.");
                    this.f8885a.m12322b(250);
                } else {
                    this.f8885a.m12322b(userInfomation.getHeight());
                }
                if (50 > userInfomation.getHeight()) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud height < MIN_HEIGHT_CM,change to MIN_HEIGHT_CM.");
                    this.f8885a.m12322b(50);
                    clientSet = 0;
                    i2 = 0;
                } else {
                    this.f8885a.m12322b(userInfomation.getHeight());
                    clientSet = 0;
                    i2 = 0;
                }
            } else {
                if (userInfomation.getWeight() > 552) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud weight > MAX_WEIGHT_LB,change to MAX_WEIGHT_LB.");
                    this.f8885a.m12329e(552);
                } else {
                    this.f8885a.m12329e(userInfomation.getWeight());
                }
                if (22 > userInfomation.getWeight()) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud weight < MIN_WEIGHT_LB,change to MIN_WEIGHT_LB.");
                    this.f8885a.m12329e(22);
                } else {
                    this.f8885a.m12329e(userInfomation.getWeight());
                }
                if (userInfomation.getHeight() > 107) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud height > MAX_HEIGHT_FT2INCH,change to MAX_HEIGHT_FT2INCH.");
                    this.f8885a.m12322b(107);
                } else {
                    this.f8885a.m12322b(userInfomation.getHeight());
                }
                if (12 > userInfomation.getHeight()) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud height < MIN_HEIGHT_FT2INCH,change to MIN_HEIGHT_FT2INCH.");
                    this.f8885a.m12322b(12);
                } else {
                    this.f8885a.m12322b(userInfomation.getHeight());
                }
                clientSet = 1;
                i2 = 1;
            }
            C2538c.m12677c("UserProfileSettingsInteractors", "getWeightType() = " + this.f8885a.m12328e() + "，heightSetUserInfoGet1.getWeight() = " + userInfomation.getWeight());
            String a;
            String a2;
            int f;
            if (i2 == 0) {
                a = C0956c.m3344a((double) height, 1, 0);
                this.f8885a.m12320a(this.f8885a.f8859m.getResources().getQuantityString(i.IDS_cm_string, height, new Object[]{a}));
                a2 = C0956c.m3344a((double) this.f8885a.m12330f(), 1, 0);
                f = this.f8885a.m12330f();
                this.f8885a.m12323b(this.f8885a.f8859m.getResources().getQuantityString(i.IDS_kg_string, f, new Object[]{a2}));
            } else {
                f = height / 12;
                height -= f * 12;
                String a3 = C0956c.m3344a((double) f, 1, 0);
                a = this.f8885a.f8859m.getResources().getQuantityString(i.IDS_ft_string, f, new Object[]{a3});
                a3 = C0956c.m3344a((double) height, 1, 0);
                a2 = this.f8885a.f8859m.getResources().getQuantityString(i.IDS_ins_string, height, new Object[]{a3});
                this.f8885a.m12320a(String.format(this.f8885a.f8859m.getResources().getString(j.IDS_ft_ins_string21), new Object[]{a, a2}));
                this.f8885a.m12323b(this.f8885a.f8859m.getResources().getQuantityString(i.IDS_lb_string, this.f8885a.m12330f(), new Object[]{C0956c.m3344a((double) this.f8885a.m12330f(), 1, 0)}));
            }
            C2538c.m12677c("UserProfileSettingsInteractors", "用户修改了身高cm，同时修改体重显示！getHeightStr () = " + this.f8885a.m12324c() + ", getWeightStr ()= " + this.f8885a.m12331g());
            this.f8885a.m12325c(i2);
            this.f8885a.m12327d(clientSet);
            this.f8885a.f8860n.sendEmptyMessage(1);
            this.f8885a.f8860n.sendEmptyMessage(2);
        }
    }
}
