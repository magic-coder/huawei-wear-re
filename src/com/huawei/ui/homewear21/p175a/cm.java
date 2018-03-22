package com.huawei.ui.homewear21.p175a;

import android.os.Looper;
import android.os.Message;
import com.huawei.hwcommonmodel.c.a;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

/* compiled from: LeftMenuFragment */
class cm extends a<cf> {
    public cm(Looper looper, cf cfVar) {
        super(looper, cfVar);
    }

    protected void m11597a(cf cfVar, Message message) {
        C2538c.m12677c("LeftMenuFragment", "Enter handleMessageWhenReferenceNotNull what:" + message.what);
        switch (message.what) {
            case 0:
                C2538c.m12677c("LeftMenuFragment", "MSG_WEAK_HANDLER_GET_USERINFO_SUCCESS");
                if (message.obj instanceof UserInfomation) {
                    cfVar.m11576a((UserInfomation) message.obj);
                    return;
                }
                return;
            case 1:
                C2538c.m12677c("LeftMenuFragment", "MSG_WEAK_HANDLER_GET_USERINFO_FAIL");
                return;
            case 2:
                C2538c.m12677c("LeftMenuFragment", "MSG_WEAK_HANDLER_BIND_SERVICE_SYSTEM_ERROR");
                cfVar.m11588j();
                return;
            case 3:
                C2538c.m12677c("LeftMenuFragment", "MSG_WEAK_HANDLER_REFRESH_USER_INFO");
                cfVar.m11592c();
                return;
            default:
                return;
        }
    }
}
