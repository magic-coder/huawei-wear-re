package com.huawei.ui.main.stories.guide.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.login.ui.login.util.b;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

/* compiled from: BasicInfoSettingActivity */
class C2403y extends Handler {
    final /* synthetic */ BasicInfoSettingActivity f8672a;

    C2403y(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8672a = basicInfoSettingActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 0:
                C2538c.m12677c("BasicInfoSettingActivity", "enter MSG_GET_USERINFO_SUCCESS");
                if (message.obj instanceof UserInfomation) {
                    this.f8672a.m12054a((UserInfomation) message.obj);
                    return;
                }
                return;
            case 1:
                this.f8672a.m12084n();
                return;
            case 2:
                this.f8672a.m12087o();
                return;
            case 3:
                this.f8672a.m12094s();
                return;
            case 4:
                this.f8672a.m12097t();
                return;
            case 5:
                this.f8672a.m12104x();
                return;
            case 6:
                this.f8672a.m12097t();
                return;
            case 9:
                C2538c.m12677c("BasicInfoSettingActivity", "Enter MSG_HIHEALTH_LOGIN_SUCCESS");
                this.f8672a.m12072h();
                return;
            case 10:
                C2538c.m12677c("BasicInfoSettingActivity", "Enter MSG_HIHEALTH_LOGIN_FAILURE");
                try {
                    this.f8672a.m12050a((b) message.obj);
                    return;
                } catch (ClassCastException e) {
                    C2538c.m12677c("BasicInfoSettingActivity", "Enter ClassCastException ERROR:" + e.getMessage());
                    return;
                }
            default:
                return;
        }
    }
}
