package com.huawei.common.applog;

import android.content.Context;
import android.os.Handler;
import com.huawei.common.applog.bean.C4349b;
import com.huawei.common.applog.bean.C4350c;
import com.huawei.common.applog.bean.C4351e;
import com.huawei.common.applog.bean.Event;
import com.huawei.phoneserviceuni.common.d.c;

/* compiled from: ReportEventManager */
public class C4355d {
    static void m20935a(Context context, Event event, Handler handler) {
        if (context == null || event == null) {
            c.d("ReportApi", "context or event is empty!");
            return;
        }
        C4349b.m20911a().m20912a(event);
        C4350c.m20919a().m20920a(new C4356e(context, handler));
    }

    static void m20936a(Context context, boolean z) {
        if (C4349b.m20911a().m20918f().size() > 0) {
            c.d("ReportApi", "flushReport have data report");
            new Thread(new C4357f(context, z)).start();
            C4351e.m20921a().m20924c();
            return;
        }
        c.d("ReportApi", "flushReport not have data report!!");
        C4349b.m20911a().m20916d();
        C4351e.m20921a().m20924c();
    }

    static int m20934a(int i) {
        int i2;
        int i3 = 240;
        if (i < 0) {
            i2 = 0;
        } else {
            i2 = i;
        }
        if (i2 <= 240) {
            i3 = i2;
        }
        return i3 * 1000;
    }
}
