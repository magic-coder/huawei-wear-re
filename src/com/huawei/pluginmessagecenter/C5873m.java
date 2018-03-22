package com.huawei.pluginmessagecenter;

import com.huawei.pluginmessagecenter.p499a.C5861g;
import com.huawei.pluginmessagecenter.provider.C5877a;
import com.huawei.pluginmessagecenter.provider.data.MessageChangeEvent;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.pluginmessagecenter.service.PullMessageCallBack;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PluginMessageCenter */
class C5873m implements PullMessageCallBack {
    final /* synthetic */ j f20146a;

    C5873m(j jVar) {
        this.f20146a = jVar;
    }

    public void pullMessageResult(int i, List<MessageObject> list) {
        C5861g.m27024c("PluginMessageCenter", "pullMessageResult: =====>" + list + "result=====>" + i);
        if (i == 200) {
            C5861g.m27024c("PluginMessageCenter", "pullMessageResult: =====> insertBatch(list) = " + C5862a.m27025a(j.a(this.f20146a)).m27040a((List) list));
            return;
        }
        C5877a.m27072a().m27073a(i, new MessageChangeEvent(new ArrayList(), new ArrayList()));
    }
}
