package com.huawei.ui.main.stories.messagecenter.interactors;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.huawei.hwcommonmodel.d.m;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.pluginmessagecenter.a.g;
import com.huawei.ui.main.e;
import com.huawei.ui.main.stories.messagecenter.activity.DispatchSkipEventActivity;
import com.huawei.ui.main.stories.messagecenter.p182a.C2411a;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ADNotificationInterActor */
public class C2418a {
    private static AtomicInteger f8698a = new AtomicInteger(0);
    private static volatile C2418a f8699b;
    private Context f8700c;
    private Builder f8701d;

    public static C2418a m12156a(Context context) {
        if (f8699b == null) {
            synchronized (C2418a.class) {
                if (f8699b == null) {
                    f8699b = new C2418a(context);
                }
            }
        }
        return f8699b;
    }

    private C2418a(Context context) {
        this.f8700c = context;
    }

    public void m12161a(C2411a c2411a) {
        g.a("ADNotificationInterActor", "showNotification start");
        if (!m12158a(c2411a.m12130a(), c2411a.m12131b())) {
            g.a("ADNotificationInterActor", "showNotification | checkDeadline is true");
            m12159b(c2411a);
        }
    }

    private void m12159b(C2411a c2411a) {
        this.f8701d = new Builder(this.f8700c).setSmallIcon(e.ic_launcher).setContentTitle(c2411a.m12131b()).setContentText(c2411a.m12132c()).setAutoCancel(true);
        String d = c2411a.m12133d();
        g.a("ADNotificationInterActor", "showNotification | webUri = \"" + d + "\"");
        String e = c2411a.m12134e();
        g.a("ADNotificationInterActor", "showNotification | detailID = \"" + e + "\"");
        Intent intent = new Intent(this.f8700c, DispatchSkipEventActivity.class);
        intent.putExtra("msgId", "pushAD");
        String str = "detailUri";
        if (!m12160b(d)) {
            d = m12160b(e) ? m12157a(e) : "";
        }
        intent.putExtra(str, d);
        this.f8701d.setContentIntent(PendingIntent.getActivity(this.f8700c, f8698a.incrementAndGet(), intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR));
        g.a("ADNotificationInterActor", "showNotification | download large icon start");
        new C2419b(this, this.f8700c).execute(new String[]{c2411a.m12135f(), c2411a.m12131b(), r0 + ""});
        g.a("ADNotificationInterActor", "showNotification | set ContentIntent end");
    }

    private String m12157a(String str) {
        return str;
    }

    private boolean m12160b(String str) {
        return !TextUtils.isEmpty(str);
    }

    private boolean m12158a(String str, String str2) {
        g.a("ADNotificationInterActor", "checkDeadline start | deadline = " + str + "; adTitle = " + str2);
        Calendar instance = Calendar.getInstance();
        instance.add(14, -(instance.get(15) + instance.get(16)));
        long timeInMillis = instance.getTimeInMillis();
        Date a = m.a(str, "yyyy-MM-dd HH:mm:ss");
        if (a == null) {
            return true;
        }
        if (timeInMillis < a.getTime()) {
            return false;
        }
        g.a("ADNotificationInterActor", "checkDeadline | AD \"" + str2 + "\" has expired");
        return true;
    }
}
