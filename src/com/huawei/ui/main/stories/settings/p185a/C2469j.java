package com.huawei.ui.main.stories.settings.p185a;

import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.i;
import com.huawei.ui.main.j;
import com.huawei.up.model.UserInfomation;

/* compiled from: UserProfileSettingsInteractors */
class C2469j implements IBaseResponseCallback {
    final /* synthetic */ C2465f f8877a;

    C2469j(C2465f c2465f) {
        this.f8877a = c2465f;
    }

    public void onResponse(int i, Object obj) {
        UserInfomation userInfomation = (UserInfomation) obj;
        if (userInfomation != null) {
            C2538c.m12677c("UserProfileSettingsInteractors", "weightSetUserInfoGet1 = " + userInfomation.toString());
            int clientSet = userInfomation.getClientSet();
            int weight = userInfomation.getWeight();
            C2538c.m12677c("UserProfileSettingsInteractors", "weightValue1= " + weight + ",unitTypeGet1=" + clientSet);
            this.f8877a.m12317a(clientSet);
            if (clientSet == 0) {
                if (userInfomation.getWeight() > 250) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud weight > MAX_WEIGHT_KG,change to MAX_WEIGHT_KG.");
                    this.f8877a.m12329e(250);
                } else {
                    this.f8877a.m12329e(userInfomation.getWeight());
                }
                if (10 > userInfomation.getWeight()) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud weight < MIN_WEIGHT_KG,change to MIN_WEIGHT_KG.");
                    this.f8877a.m12329e(10);
                } else {
                    this.f8877a.m12329e(userInfomation.getWeight());
                }
                if (userInfomation.getHeight() > 250) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud height > MAX_HEIGHT_CM,change to MAX_HEIGHT_CM.");
                    this.f8877a.m12322b(250);
                } else {
                    this.f8877a.m12322b(userInfomation.getHeight());
                }
                if (50 > userInfomation.getHeight()) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud height < MIN_HEIGHT_CM,change to MIN_HEIGHT_CM.");
                    this.f8877a.m12322b(50);
                } else {
                    this.f8877a.m12322b(userInfomation.getHeight());
                }
                clientSet = 0;
                weight = 0;
            } else {
                if (userInfomation.getWeight() > 552) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud weight > MAX_WEIGHT_LB,change to MAX_WEIGHT_LB.");
                    this.f8877a.m12329e(552);
                } else {
                    this.f8877a.m12329e(userInfomation.getWeight());
                }
                if (22 > userInfomation.getWeight()) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud weight < MIN_WEIGHT_LB,change to MIN_WEIGHT_LB.");
                    this.f8877a.m12329e(22);
                } else {
                    this.f8877a.m12329e(userInfomation.getWeight());
                }
                if (userInfomation.getHeight() > 107) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud height > MAX_HEIGHT_FT2INCH,change to MAX_HEIGHT_FT2INCH.");
                    this.f8877a.m12322b(107);
                } else {
                    this.f8877a.m12322b(userInfomation.getHeight());
                }
                if (12 > userInfomation.getHeight()) {
                    C2538c.m12677c("UserProfileSettingsInteractors", "cloud height < MIN_HEIGHT_FT2INCH,change to MIN_HEIGHT_FT2INCH.");
                    this.f8877a.m12322b(12);
                } else {
                    this.f8877a.m12322b(userInfomation.getHeight());
                }
                clientSet = 1;
                weight = 1;
            }
            if (weight == 0) {
                this.f8877a.m12323b(this.f8877a.f8859m.getResources().getQuantityString(i.IDS_kg_string, this.f8877a.m12330f(), new Object[]{C0956c.m3344a((double) this.f8877a.m12330f(), 1, 0)}));
                this.f8877a.m12320a(this.f8877a.f8859m.getResources().getQuantityString(i.IDS_cm_string, this.f8877a.m12321b(), new Object[]{C0956c.m3344a((double) this.f8877a.m12321b(), 1, 0)}));
            } else {
                this.f8877a.m12323b(this.f8877a.f8859m.getResources().getQuantityString(i.IDS_lb_string, this.f8877a.m12330f(), new Object[]{C0956c.m3344a((double) this.f8877a.m12330f(), 1, 0)}));
                int b = this.f8877a.m12321b() / 12;
                int b2 = this.f8877a.m12321b() - (b * 12);
                String a = C0956c.m3344a((double) b, 1, 0);
                String quantityString = this.f8877a.f8859m.getResources().getQuantityString(i.IDS_ft_string, b, new Object[]{a});
                a = C0956c.m3344a((double) b2, 1, 0);
                String quantityString2 = this.f8877a.f8859m.getResources().getQuantityString(i.IDS_ins_string, b2, new Object[]{a});
                this.f8877a.m12320a(String.format(this.f8877a.f8859m.getResources().getString(j.IDS_ft_ins_string21), new Object[]{quantityString, quantityString2}));
            }
            C2538c.m12677c("UserProfileSettingsInteractors", "用户修改了体重为kg，同时修改身高显示！getWeightStr() = " + this.f8877a.m12331g() + ",getHeightStr() = " + this.f8877a.m12324c());
            this.f8877a.m12327d(weight);
            this.f8877a.m12325c(clientSet);
            this.f8877a.f8860n.sendEmptyMessage(2);
            this.f8877a.f8860n.sendEmptyMessage(1);
        }
    }
}
