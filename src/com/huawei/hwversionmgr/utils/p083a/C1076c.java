package com.huawei.hwversionmgr.utils.p083a;

import android.os.Handler;
import android.os.Message;
import com.huawei.hwversionmgr.p079a.C1070g;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AppPullChangeLogHandler */
public abstract class C1076c extends Handler {
    public abstract void mo2347a();

    public abstract void mo2348a(List<C1070g> list);

    public void handleMessage(Message message) {
        List list = null;
        super.handleMessage(message);
        switch (message.what) {
            case 0:
                C2538c.m12674b("AppPullChangeLogHandler", "pull changelog failed!");
                mo2347a();
                return;
            case 1:
                C2538c.m12674b("AppPullChangeLogHandler", "pull changelog success!");
                ArrayList arrayList = new ArrayList();
                if (message.obj == null) {
                    C2538c.m12674b("AppPullChangeLogHandler", "msg.obj is null!");
                } else if (message.obj instanceof List) {
                    C2538c.m12674b("AppPullChangeLogHandler", "msg.obj is instanceof List<?>!");
                    list = (List) message.obj;
                } else {
                    C2538c.m12674b("AppPullChangeLogHandler", "msg.obj is not instanceof List<?>!");
                }
                mo2348a(list);
                return;
            default:
                C2538c.m12674b("AppPullChangeLogHandler", "default!");
                return;
        }
    }
}
