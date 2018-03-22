package com.huawei.bone.root;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.ab.m;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.g;
import com.huawei.hwdatamigrate.a;
import com.huawei.hwdatamigrate.a.ba;
import com.huawei.hwdatamigrate.a.bg;
import com.huawei.hwdatamigrate.a.h;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

import java.io.File;

/* compiled from: ProtocolAndClauseActivity */
class C6805x implements Runnable {
    final /* synthetic */ ProtocolAndClauseActivity f23347a;

    C6805x(ProtocolAndClauseActivity protocolAndClauseActivity) {
        this.f23347a = protocolAndClauseActivity;
    }

    public void run() {
        a a = a.a(this.f23347a.f23235b);
        if (a.a()) {
            C2538c.c("ProtocolAndClauseActivity", new Object[]{"not need to migrate"});
            this.f23347a.f23250r.sendEmptyMessage(1);
        } else if (a.b(this.f23347a.f23235b)) {
            boolean z;
            C2538c.c("ProtocolAndClauseActivity", new Object[]{"need to migrate"});
            String a2 = h.a(this.f23347a.f23235b);
            ba c = h.c(this.f23347a.f23235b, a2);
            if (c == null || c.g == null || c.g.isEmpty()) {
                c.c("ProtocolAndClauseActivity", new Object[]{"app 1.5 is not login"});
                z = false;
            } else {
                c.c("ProtocolAndClauseActivity", new Object[]{"app 1.5 is already login"});
                z = true;
            }
            if (h.c(BaseApplication.b()) && z && c != null) {
                String str = c.g;
                if (c.c != 0) {
                    com.huawei.hwdatamigrate.common.h.f(this.f23347a.f23235b);
                }
                this.f23347a.f23247n = c.c;
            }
            com.huawei.login.ui.login.util.c.a(this.f23347a.f23235b).a(z);
            bg a3 = h.a(this.f23347a.f23235b, a2);
            UserInfomation userInfomation = new UserInfomation();
            userInfomation.setName(a3.o);
            c.c("ProtocolAndClauseActivity", new Object[]{"protrait is :", a3.n});
            if (!TextUtils.isEmpty(a3.n)) {
                if (new File(a3.n).exists()) {
                    userInfomation.setPicPath(a3.n);
                    userInfomation.setPortraitUrl("");
                } else {
                    String str2 = w.a(this.f23347a.f23235b) + File.separator + g.a(this.f23347a.f23235b, a3.n);
                    c.c("ProtocolAndClauseActivity", new Object[]{"local name is :", str2});
                    if (new File(str2).exists()) {
                        c.c("ProtocolAndClauseActivity", new Object[]{"file is exists"});
                        userInfomation.setPicPath(str2);
                    }
                    userInfomation.setPortraitUrl(a3.n);
                }
            }
            userInfomation.setBirthday(String.valueOf(a3.r));
            int i = -1;
            if (a3.b == 0) {
                i = 1;
            } else if (1 == a3.b) {
                i = 0;
            }
            userInfomation.setGender(Integer.valueOf(i));
            userInfomation.setClientSet(Integer.valueOf(a3.k));
            if (a3.k == 0) {
                if (a3.i > 250) {
                    c.c("ProtocolAndClauseActivity", new Object[]{"table.weight > MAX_WEIGHT_KG,change to MAX_WEIGHT_KG."});
                    userInfomation.setWeight(Integer.valueOf(250));
                } else {
                    userInfomation.setWeight(Integer.valueOf(a3.i));
                }
                if (a3.f > 250) {
                    c.c("ProtocolAndClauseActivity", new Object[]{"table.height > MAX_HEIGHT_CM,change to MAX_HEIGHT_CM."});
                    userInfomation.setHeight(Integer.valueOf(250));
                } else {
                    userInfomation.setHeight(Integer.valueOf(a3.f));
                }
            } else {
                if (a3.j > 552) {
                    c.c("ProtocolAndClauseActivity", new Object[]{"table.weight_lb > MAX_WEIGHT_LB,change to MAX_WEIGHT_LB."});
                    userInfomation.setWeight(Integer.valueOf(552));
                } else {
                    userInfomation.setWeight(Integer.valueOf(a3.j));
                }
                if (a3.g > 107) {
                    c.c("ProtocolAndClauseActivity", new Object[]{"table.height_ft > MAX_HEIGHT_FT2INCH,change to MAX_HEIGHT_FT2INCH."});
                    userInfomation.setHeight(Integer.valueOf(107));
                } else {
                    userInfomation.setHeight(Integer.valueOf(a3.g));
                }
                com.huawei.hwbasemgr.c.a(true);
            }
            com.huawei.hwdataaccessmodel.sharedpreference.a.a(this.f23347a.f23235b, String.valueOf(1004), UserInfomation.KEY_USER_INFO, new Gson().toJson(userInfomation, UserInfomation.class), new com.huawei.hwdataaccessmodel.a.c(2));
            m.a(this.f23347a.f23235b).onDataMigrate();
            new com.huawei.ui.main.stories.guide.a.a(BaseApplication.b()).c(true);
            this.f23347a.f23250r.sendEmptyMessage(1);
        } else {
            C2538c.c("ProtocolAndClauseActivity", new Object[]{"not need migrate data."});
            this.f23347a.f23250r.sendEmptyMessage(1);
        }
    }
}
