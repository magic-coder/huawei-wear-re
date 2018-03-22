package com.huawei.ui.main.stories.guide.activity;

import android.os.Bundle;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.up.b.a;
import com.huawei.up.model.UserInfomation;

/* compiled from: BasicInfoSettingActivity */
class ab implements a {
    final /* synthetic */ aa f8637a;

    ab(aa aaVar) {
        this.f8637a = aaVar;
    }

    public void m12123a(Bundle bundle) {
        C2538c.m12677c("BasicInfoSettingActivity", "getUserInfofromHiHealth success.");
    }

    public void m12122a(int i) {
        C2538c.m12677c("BasicInfoSettingActivity", "getUserInfofromHiHealth failure.");
        this.f8637a.f8636a.f8581H = new UserInfomation();
        Message obtainMessage = this.f8637a.f8636a.f8592T.obtainMessage();
        obtainMessage.what = 0;
        obtainMessage.obj = this.f8637a.f8636a.f8581H;
        this.f8637a.f8636a.f8592T.sendMessage(obtainMessage);
    }
}
