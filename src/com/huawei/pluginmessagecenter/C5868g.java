package com.huawei.pluginmessagecenter;

import android.content.Context;
import com.huawei.pluginmessagecenter.p499a.C5857c;
import com.huawei.pluginmessagecenter.p499a.C5861g;

/* compiled from: MessagePushReceiver */
class C5868g implements C5857c {
    final /* synthetic */ Context f20140a;
    final /* synthetic */ String f20141b;
    final /* synthetic */ C5867f f20142c;

    C5868g(C5867f c5867f, Context context, String str) {
        this.f20142c = c5867f;
        this.f20140a = context;
        this.f20141b = str;
    }

    public void mo5124a(String str) {
        C5861g.m27024c("MessagePushReceiver", "doSaveToken HttpUtils.doPostReq onSucceed ==> result =" + str);
        C4478x c4478x = (C4478x) j.a(this.f20140a).getAdapter();
        if (c4478x != null) {
            String str2 = (String) c4478x.mo4465a(new String[]{"getLoginInfo"}).get("huid");
            C5861g.m27024c("MessagePushReceiver", "doSaveToken HttpUtils.doPostReq onSucceed currentHuid " + str2);
            C5870i.m27071d(this.f20140a, str2);
            C5870i.m27070c(this.f20140a, this.f20141b);
        }
    }

    public void mo5123a(int i) {
        C5861g.m27024c("MessagePushReceiver", "doSaveToken HttpUtils.doPostReq onFailed ==> resCode =" + i);
    }
}
