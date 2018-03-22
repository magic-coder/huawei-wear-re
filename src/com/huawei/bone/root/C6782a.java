package com.huawei.bone.root;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.hwdatamigrate.hihealth.c.be;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;

/* compiled from: MainActivity */
class C6782a implements Runnable {
    final /* synthetic */ MainActivity f23294a;

    C6782a(MainActivity mainActivity) {
        this.f23294a = mainActivity;
    }

    public void run() {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"no need check time:" + Math.abs(d.d(BaseApplication.b(), a.a(BaseApplication.b(), String.valueOf(20007), "migrate_lastcheck_time")) - System.currentTimeMillis())});
        if (Math.abs(d.d(BaseApplication.b(), a.a(BaseApplication.b(), String.valueOf(20007), "migrate_lastcheck_time")) - System.currentTimeMillis()) > 21600000) {
            a.a(BaseApplication.b(), String.valueOf(20007), "migrate_lastcheck_time", System.currentTimeMillis() + "", new com.huawei.hwdataaccessmodel.a.c(0));
            ArrayList c = be.a().c(com.huawei.login.ui.login.a.a(BaseApplication.b()).c());
            if (c != null && c.size() > 0) {
                this.f23294a.m30114b();
                return;
            }
            return;
        }
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"no need check time:" + r0});
    }
}
