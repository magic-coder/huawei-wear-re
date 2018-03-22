package com.huawei.pluginmessagecenter;

import android.content.Context;
import com.google.gson.JsonSyntaxException;
import com.huawei.pluginmessagecenter.p499a.C5857c;
import com.huawei.pluginmessagecenter.p499a.C5861g;
import com.huawei.pluginmessagecenter.service.MessageParser;
import com.huawei.pluginmessagecenter.service.PullMessageCallBack;

/* compiled from: MessagePuller */
class C5866e implements C5857c {
    final /* synthetic */ Context f20133a;
    final /* synthetic */ PullMessageCallBack f20134b;
    final /* synthetic */ C5865d f20135c;

    C5866e(C5865d c5865d, Context context, PullMessageCallBack pullMessageCallBack) {
        this.f20135c = c5865d;
        this.f20133a = context;
        this.f20134b = pullMessageCallBack;
    }

    public void mo5124a(String str) {
        C5861g.m27024c("MessagePuller", "pullMessage() doPostReq onSucceed ==> result == " + str);
        try {
            this.f20134b.pullMessageResult(200, MessageParser.parseMessageArray(this.f20133a, str));
        } catch (JsonSyntaxException e) {
            C5861g.m27023b("MessagePuller", "pullMessage() doPostReq JsonSyntaxException:" + e);
            this.f20134b.pullMessageResult(-1, null);
        }
    }

    public void mo5123a(int i) {
        C5861g.m27024c("MessagePuller", "pullMessage() doPostReq onFailed ==> resCode == " + i);
        this.f20134b.pullMessageResult(i, null);
    }
}
