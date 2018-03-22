package com.huawei.common.applog;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.common.applog.bean.C4350c;
import com.huawei.common.applog.bean.C4351e;
import com.huawei.common.applog.p380a.C4346b;
import com.huawei.phoneserviceuni.common.d.c;
import java.util.Timer;
import java.util.TimerTask;

final class AppLogApi$3 extends Handler {

    class C43421 implements Runnable {
        C43421() {
        }

        public void run() {
            new C4346b().m20896a(AppLogApi.access$000(), AppLogApi.access$800(), false);
        }
    }

    class C43432 extends TimerTask {
        C43432() {
        }

        public void run() {
            c.c("ReportApi", "time has come ==" + AppLogApi.access$700());
            new C4346b().m20896a(AppLogApi.access$000(), AppLogApi.access$800(), false);
        }
    }

    AppLogApi$3(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        c.b("ReportApi", "reportHandler handleMessage");
        if (10000 == message.what) {
            c.c("ReportApi", "instert list sucess");
            if (AppLogApi.access$700() == 0) {
                c.d("ReportApi", "reportCycle is 0, report immediately");
                C4350c.m20919a().m20920a(new C43421());
                return;
            }
            c.d("ReportApi", "reportCycle is not 0");
            if (C4351e.m20921a().m20923b() == null) {
                c.d("ReportApi", "new timer");
                C4351e.m20921a().m20922a(new Timer());
                C4351e.m20921a().m20923b().schedule(new C43432(), (long) AppLogApi.access$700(), (long) AppLogApi.access$700());
                return;
            }
            c.c("ReportApi", "already have timer");
        }
    }
}
