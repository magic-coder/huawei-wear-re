package com.huawei.ui.device.activity.goldmember;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.device.i;

/* compiled from: VIPUserInfoActivity */
class C2086g extends Handler {
    final /* synthetic */ VIPUserInfoActivity f7366a;

    C2086g(VIPUserInfoActivity vIPUserInfoActivity) {
        this.f7366a = vIPUserInfoActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                C2538c.m12677c(VIPUserInfoActivity.f7302d, "UPDATE_MEMBER_VALIDITY");
                this.f7366a.m10807f();
                break;
            case 1:
                this.f7366a.m10809g();
                break;
            case 2:
                this.f7366a.m10811h();
                break;
            case 3:
                this.f7366a.m10804e();
                break;
            case 4:
                this.f7366a.m10813i();
                break;
            case 5:
                a.b(this.f7366a.f7311G, i.IDS_main_sns_member_activation_no_get_my_user_infor_failure);
                break;
            case 6:
                this.f7366a.m10794b(i.IDS_getting_file);
                break;
            case 7:
                this.f7366a.m10829a();
                break;
        }
        super.handleMessage(message);
    }
}
