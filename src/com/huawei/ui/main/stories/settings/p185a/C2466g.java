package com.huawei.ui.main.stories.settings.p185a;

import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwcommonmodel.d.e;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.i;
import com.huawei.ui.main.j;
import com.huawei.up.model.UserInfomation;

/* compiled from: UserProfileSettingsInteractors */
class C2466g implements IBaseResponseCallback {
    final /* synthetic */ C2465f f8872a;

    C2466g(C2465f c2465f) {
        this.f8872a = c2465f;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            UserInfomation userInfomation = (UserInfomation) obj;
            if (userInfomation == null) {
                C2538c.m12680e("UserProfileSettingsInteractors", "mUserInfo is null !");
                return;
            }
            int height;
            C2538c.m12677c("UserProfileSettingsInteractors", "mUserInfoCallback ,mUserInfo : " + userInfomation.toString());
            if (C0969i.m3482a(35)) {
                if (C0956c.m3349a()) {
                    if (userInfomation.getClientSet() == 0) {
                        userInfomation.setWeight(Integer.valueOf(e.g(userInfomation.getWeight())));
                        userInfomation.setHeight(Integer.valueOf(e.e(userInfomation.getHeight())));
                        userInfomation.setClientSet(Integer.valueOf(1));
                    }
                } else if (1 == userInfomation.getClientSet()) {
                    userInfomation.setWeight(Integer.valueOf(e.f(userInfomation.getWeight())));
                    height = userInfomation.getHeight() / 12;
                    userInfomation.setHeight(Integer.valueOf(e.b(height, userInfomation.getHeight() - (height * 12))));
                    userInfomation.setClientSet(Integer.valueOf(0));
                }
            }
            this.f8872a.m12317a(userInfomation.getClientSet());
            C2538c.m12677c("UserProfileSettingsInteractors", "unitType = " + this.f8872a.m12316a() + ", heightValue = " + this.f8872a.m12321b() + ",weightValue = " + this.f8872a.m12330f());
            if (this.f8872a.m12316a() == 0) {
                if (userInfomation.getWeight() > 250) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud weight > MAX_WEIGHT_KG,change to MAX_WEIGHT_KG.");
                    this.f8872a.m12329e(250);
                } else if (userInfomation.getWeight() < 10) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud weight < MIN_WEIGHT_KG,change to MIN_WEIGHT_KG.");
                    this.f8872a.m12329e(10);
                } else {
                    this.f8872a.m12329e(userInfomation.getWeight());
                }
                if (userInfomation.getHeight() > 250) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud height > MAX_HEIGHT_CM,change to MAX_HEIGHT_CM.");
                    this.f8872a.m12322b(250);
                } else if (userInfomation.getHeight() < 50) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud height < MIN_HEIGHT_CM,change to MIN_HEIGHT_CM.");
                    this.f8872a.m12322b(50);
                } else {
                    this.f8872a.m12322b(userInfomation.getHeight());
                }
                this.f8872a.m12325c(0);
                this.f8872a.m12320a(this.f8872a.f8859m.getResources().getQuantityString(i.IDS_cm_string, this.f8872a.m12321b(), new Object[]{C0956c.m3344a((double) this.f8872a.m12321b(), 1, 0)}));
                this.f8872a.m12327d(0);
                this.f8872a.m12323b(this.f8872a.f8859m.getResources().getQuantityString(i.IDS_kg_string, this.f8872a.m12330f(), new Object[]{C0956c.m3344a((double) this.f8872a.m12330f(), 1, 0)}));
            } else {
                if (userInfomation.getWeight() > 552) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud weight > MAX_WEIGHT_LB,change to MAX_WEIGHT_LB.");
                    this.f8872a.m12329e(552);
                } else if (userInfomation.getWeight() < 22) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud weight < MIN_WEIGHT_LB,change to MIN_WEIGHT_LB.");
                    this.f8872a.m12329e(22);
                } else {
                    this.f8872a.m12329e(userInfomation.getWeight());
                }
                if (userInfomation.getHeight() > 107) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud height > MAX_HEIGHT_FT2INCH,change to MAX_HEIGHT_FT2INCH.");
                    this.f8872a.m12322b(107);
                } else if (userInfomation.getHeight() < 12) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud height < MIN_HEIGHT_FT2INCH,change to MIN_HEIGHT_FT2INCH.");
                    this.f8872a.m12322b(107);
                } else {
                    this.f8872a.m12322b(userInfomation.getHeight());
                }
                this.f8872a.m12325c(1);
                height = this.f8872a.m12321b() / 12;
                int b = this.f8872a.m12321b() - (height * 12);
                String a = C0956c.m3344a((double) height, 1, 0);
                String quantityString = this.f8872a.f8859m.getResources().getQuantityString(i.IDS_ft_string, height, new Object[]{a});
                a = C0956c.m3344a((double) b, 1, 0);
                String quantityString2 = this.f8872a.f8859m.getResources().getQuantityString(i.IDS_ins_string, b, new Object[]{a});
                this.f8872a.m12320a(String.format(this.f8872a.f8859m.getResources().getString(j.IDS_ft_ins_string21), new Object[]{quantityString, quantityString2}));
                this.f8872a.m12327d(1);
                this.f8872a.m12323b(this.f8872a.f8859m.getResources().getQuantityString(i.IDS_lb_string, this.f8872a.m12330f(), new Object[]{C0956c.m3344a((double) this.f8872a.m12330f(), 1, 0)}));
            }
            this.f8872a.f8860n.sendEmptyMessage(5);
            return;
        }
        C2538c.m12680e("UserProfileSettingsInteractors", "获取用户信息失败！");
        this.f8872a.f8860n.sendEmptyMessage(6);
    }
}
