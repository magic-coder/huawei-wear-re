package com.huawei.ui.main.stories.guide.activity;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2390l implements IBaseResponseCallback {
    final /* synthetic */ BasicInfoSettingActivity f8656a;

    C2390l(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8656a = basicInfoSettingActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("BasicInfoSettingActivity", "getUserInfo,err_code = " + i);
        if (i != 0 || obj == null) {
            this.f8656a.f8592T.sendEmptyMessage(1);
            return;
        }
        Message message = new Message();
        message.obj = obj;
        message.what = 0;
        this.f8656a.f8592T.sendMessage(message);
    }
}
