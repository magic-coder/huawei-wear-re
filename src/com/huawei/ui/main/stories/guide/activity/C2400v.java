package com.huawei.ui.main.stories.guide.activity;

import com.huawei.hwcommonmodel.d.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.b.d;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.main.j;

/* compiled from: BasicInfoSettingActivity */
class C2400v extends c {
    final /* synthetic */ BasicInfoSettingActivity f8668a;

    C2400v(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8668a = basicInfoSettingActivity;
    }

    public void m12126a() {
        C2538c.m12677c("BasicInfoSettingActivity", "同意sd卡读写权限！");
        this.f8668a.f8583J.a(d.a);
    }

    public void m12127a(String str) {
        C2538c.m12677c("BasicInfoSettingActivity", "不同意sd卡读写权限！");
        a.a(this.f8668a.f8596a, this.f8668a.f8596a.getString(j.IDS_huawei_user_info_toast));
    }
}
