package com.huawei.ui.device.activity.goldmember;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiMemberActivity */
class C2082c extends Handler {
    final /* synthetic */ HuaweiMemberActivity f7362a;

    C2082c(HuaweiMemberActivity huaweiMemberActivity) {
        this.f7362a = huaweiMemberActivity;
    }

    public void handleMessage(Message message) {
        C2538c.m12677c(HuaweiMemberActivity.f7279c, "msg.what ==" + message.what);
        switch (message.what) {
            case 0:
                if (!this.f7362a.f7284f.isChecked()) {
                    this.f7362a.f7283e.getBackground().setAlpha(150);
                    this.f7362a.f7283e.setClickable(false);
                    this.f7362a.f7283e.setTextColor(856530939);
                    break;
                }
                this.f7362a.f7283e.getBackground().setAlpha(255);
                this.f7362a.f7283e.setClickable(true);
                this.f7362a.f7283e.setTextColor(-15884293);
                break;
            case 1:
                C2538c.m12677c(HuaweiMemberActivity.f7279c, "GETDB_USER_MEMLEVEL_SUCCESS");
                this.f7362a.m10769c();
                break;
        }
        super.handleMessage(message);
    }
}
