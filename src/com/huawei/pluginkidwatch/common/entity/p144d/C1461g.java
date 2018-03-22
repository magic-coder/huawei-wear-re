package com.huawei.pluginkidwatch.common.entity.p144d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;

/* compiled from: RestfulService */
class C1461g extends Handler {
    final /* synthetic */ C1457c f3363a;

    public C1461g(C1457c c1457c, Looper looper) {
        this.f3363a = c1457c;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.m12674b("RestfulService", "enter handle message");
        C1418a c1418a = (C1418a) message.getData().getSerializable("builder");
        if (c1418a == null) {
            C2538c.m12674b("RestfulService", "(null == obj)");
            return;
        }
        C1378e c1378e = (C1378e) message.obj;
        switch (message.what) {
            case 500000:
                BaseEntityModel baseEntityModel = (BaseEntityModel) message.getData().getSerializable("entity");
                if (baseEntityModel != null) {
                    C2538c.m12674b("RestfulService", "get normally");
                    this.f3363a.m6705a(c1378e, baseEntityModel);
                    return;
                }
                return;
            case 500001:
                this.f3363a.m6706a((BaseEntityModel) message.getData().getSerializable("entity"), message.getData().getString("url"), c1378e, c1418a);
                return;
            case 500002:
                this.f3363a.m6707a(message.getData().getString("url"), message.getData().getString("params"), c1378e, c1418a);
                return;
            default:
                return;
        }
    }
}
