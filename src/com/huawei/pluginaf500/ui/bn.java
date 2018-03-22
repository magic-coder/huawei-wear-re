package com.huawei.pluginaf500.ui;

import android.content.Intent;
import com.huawei.hwcommonmodel.p064d.p406a.C4719c;

/* compiled from: SettingActivity */
class bn extends C4719c {
    final /* synthetic */ SettingActivity f19934a;

    bn(SettingActivity settingActivity) {
        this.f19934a = settingActivity;
    }

    public void mo5116a() {
        this.f19934a.startActivity(new Intent(this.f19934a, RemoteTakePictureActivity.class));
    }

    public void mo5117a(String str) {
    }
}
