package com.huawei.ui.device.activity.goldmember;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.ui.device.i;
import com.huawei.ui.device.j;

/* compiled from: VIPMemberActivationActivity */
class C2084e extends Handler {
    final /* synthetic */ VIPMemberActivationActivity f7364a;

    public C2084e(VIPMemberActivationActivity vIPMemberActivationActivity, Looper looper) {
        this.f7364a = vIPMemberActivationActivity;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.m12677c(VIPMemberActivationActivity.f7291e, "msg.what ==" + message.what);
        switch (message.what) {
            case 0:
                this.f7364a.f7299i.postDelayed(this.f7364a.f7297g, 20000);
                if (this.f7364a.f7298h == null) {
                    VIPMemberActivationActivity vIPMemberActivationActivity = this.f7364a;
                    a aVar = new a(this.f7364a.f7295d, j.app_update_dialogActivity);
                    vIPMemberActivationActivity.f7298h = a.a(this.f7364a.f7295d);
                }
                this.f7364a.f7298h.a(this.f7364a.f7295d.getResources().getString(i.IDS_main_sns_member_activation_lodaing_dialog));
                this.f7364a.f7298h.setCancelable(false);
                this.f7364a.f7298h.a();
                this.f7364a.f7294c.getBackground().setAlpha(150);
                this.f7364a.f7294c.setClickable(false);
                this.f7364a.f7294c.setTextColor(856530939);
                return;
            case 1:
                this.f7364a.m10779d();
                this.f7364a.f7294c.getBackground().setAlpha(255);
                this.f7364a.f7294c.setClickable(true);
                this.f7364a.f7294c.setTextColor(-15884293);
                return;
            case 2:
                this.f7364a.m10779d();
                this.f7364a.f7294c.getBackground().setAlpha(255);
                this.f7364a.f7294c.setClickable(true);
                this.f7364a.f7294c.setTextColor(-15884293);
                com.huawei.ui.commonui.c.a.a(this.f7364a.f7295d, i.IDS_main_sns_member_activation_failure);
                return;
            case 3:
                com.huawei.ui.commonui.c.a.a(this.f7364a.f7295d, i.IDS_main_sns_member_activation_success);
                return;
            case 4:
                this.f7364a.m10779d();
                this.f7364a.f7294c.getBackground().setAlpha(255);
                this.f7364a.f7294c.setClickable(true);
                this.f7364a.f7294c.setTextColor(-15884293);
                com.huawei.ui.commonui.c.a.a(this.f7364a.f7295d, i.IDS_huawei_member_not_huawei_phone);
                return;
            default:
                return;
        }
    }
}
