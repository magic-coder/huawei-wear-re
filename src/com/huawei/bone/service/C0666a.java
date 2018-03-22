package com.huawei.bone.service;

import com.google.gson.JsonSyntaxException;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.HuaweiHealthData;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.main.stories.nps.interactors.C2442a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: MessageCenterIntentService */
class C0666a implements IBaseResponseCallback {
    final /* synthetic */ int f1210a;
    final /* synthetic */ CountDownLatch f1211b;
    final /* synthetic */ MessageCenterIntentService f1212c;

    C0666a(MessageCenterIntentService messageCenterIntentService, int i, CountDownLatch countDownLatch) {
        this.f1212c = messageCenterIntentService;
        this.f1210a = i;
        this.f1211b = countDownLatch;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            this.f1212c.f1205a = (List) obj;
            if (this.f1212c.f1205a == null || this.f1212c.f1205a.size() <= 0) {
                C2538c.m12677c("MessageCenterIntentService", "getMessageCenterListMessageForHealth no data!");
            } else {
                C2538c.m12677c("MessageCenterIntentService", "getMessageCenterListMessageForHealth count = " + this.f1212c.f1205a.size());
                for (MessageObject messageObject : this.f1212c.f1205a) {
                    C2538c.m12677c("MessageCenterIntentService", "Enter onHandleIntent :" + messageObject.toString());
                }
                Object huaweiHealthData = new HuaweiHealthData();
                try {
                    huaweiHealthData.setCommandType(this.f1210a);
                    huaweiHealthData.setData(this.f1212c.f1206b.toJson(this.f1212c.f1205a));
                    huaweiHealthData.setData1(this.f1212c.m2641a());
                    C2442a a = C2442a.m12225a(BaseApplication.m2632b());
                    Object arrayList = new ArrayList();
                    a.m12268a((List) arrayList);
                    huaweiHealthData.setData2(this.f1212c.f1206b.toJson(arrayList));
                    String toJson = this.f1212c.f1206b.toJson(huaweiHealthData);
                    C2538c.m12677c("MessageCenterIntentService", "gson:" + toJson);
                    if (toJson == null) {
                        toJson = "";
                    }
                    C1988p.m10381a(BaseApplication.m2632b()).m10388a(toJson, new b(this));
                } catch (JsonSyntaxException e) {
                    C2538c.m12677c("MessageCenterIntentService", "Enter JsonSyntaxException");
                    return;
                }
            }
        }
        this.f1211b.countDown();
    }
}
