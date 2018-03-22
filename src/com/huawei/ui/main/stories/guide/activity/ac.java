package com.huawei.ui.main.stories.guide.activity;

import android.os.Message;
import com.huawei.login.ui.login.util.ILoginCallback;

/* compiled from: BasicInfoSettingActivity */
class ac implements ILoginCallback {
    final /* synthetic */ BasicInfoSettingActivity f8638a;

    ac(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8638a = basicInfoSettingActivity;
    }

    public void onLoginSuccess(Object obj) {
        this.f8638a.f8592T.sendEmptyMessage(9);
    }

    public void onLoginFailed(Object obj) {
        Message message = new Message();
        message.obj = obj;
        message.what = 10;
        this.f8638a.f8592T.sendMessage(message);
    }
}
