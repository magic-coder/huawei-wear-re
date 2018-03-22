package com.huawei.pluginmessagecenter;

import android.content.Context;
import android.content.IntentFilter;
import com.huawei.ah.C0639a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.mgr.HwWearPushReceiver;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.k;
import com.huawei.pluginmessagecenter.a.a;
import com.huawei.pluginmessagecenter.a.g;
import com.huawei.pluginmessagecenter.provider.data.MessageChangeEvent;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

/* compiled from: PluginMessageCenter */
public class C1971j extends C0639a {
    private static volatile C1971j f6835a;
    private Context f6836b;
    private w f6837c = null;
    private final Object f6838d = new Object();
    private long f6839e = 0;
    private Runnable f6840f = new k(this);

    public static C1971j m10236a(Context context) {
        if (f6835a == null) {
            synchronized (C1971j.class) {
                if (f6835a == null) {
                    f6835a = new C1971j(context);
                }
            }
        }
        return f6835a;
    }

    private C1971j(Context context) {
        if (context != null) {
            this.f6836b = context.getApplicationContext();
        } else {
            this.f6836b = BaseApplication.m2632b();
        }
        g.a();
    }

    private void m10240d() {
        g.c("PluginMessageCenter", "processSwitchUserOrLanguage");
        this.f6837c = new w(null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        this.f6836b.registerReceiver(this.f6837c, intentFilter);
        new Thread(this.f6840f).start();
    }

    public void init(Context context) {
        super.init(context);
        g.c("PluginMessageCenter", "init");
        a.a();
        m10240d();
        HwWearPushReceiver.m3497a(this.f6836b, "PluginMessageCenter", new f());
    }

    public void finish() {
        super.finish();
        g.c("PluginMessageCenter", "finish");
        if (this.f6837c != null) {
            this.f6836b.unregisterReceiver(this.f6837c);
            this.f6837c = null;
        }
        com.huawei.pluginmessagecenter.provider.a.a().b();
        HwWearPushReceiver.m3496a(this.f6836b.getApplicationContext());
    }

    public void m10247a(String str, String str2, IBaseResponseCallback iBaseResponseCallback) {
        k.a(new o(this, str, str2, iBaseResponseCallback));
    }

    public void m10243a(MessageObject messageObject) {
        m10244a(messageObject, null);
    }

    public void m10244a(MessageObject messageObject, IBaseResponseCallback iBaseResponseCallback) {
        k.a(new p(this, messageObject, iBaseResponseCallback));
    }

    private List<MessageObject> m10237a(int i, int i2) {
        g.c("PluginMessageCenter", "getMessageList | pageNo = " + i + "; pageSize = " + i2);
        x xVar = (x) getAdapter();
        if (xVar == null) {
            g.c("PluginMessageCenter", "PluginMessageCenterAdapter is null.");
            return new ArrayList();
        } else if (i < 0 || i2 < 0) {
            g.c("PluginMessageCenter", "pageNo or pageSize is invalid.");
            return new ArrayList();
        } else {
            Map a = xVar.a(new String[]{"getLoginInfo", "getPhoneInfo", "getDeviceInfo"});
            String str = (String) a.get("huid");
            String a2 = a.a((String) a.get("productType"));
            g.c("PluginMessageCenter", "getMessageList | huid = " + str + "; deviceIMEI = " + a2);
            return a.a(this.f6836b).a(str, a2, i, i2);
        }
    }

    public void m10254b(String str, String str2, IBaseResponseCallback iBaseResponseCallback) {
        g.c("PluginMessageCenter", "getMessage | module = " + str + "; type = " + str2);
        k.a(new q(this, str, str2, iBaseResponseCallback));
    }

    public void m10242a(IBaseResponseCallback iBaseResponseCallback) {
        g.c("PluginMessageCenter", "getMessageCenterListMessage");
        k.a(new r(this, iBaseResponseCallback));
    }

    public void m10250b(IBaseResponseCallback iBaseResponseCallback) {
        g.c("PluginMessageCenter", "getNotificationMessageList");
        k.a(new s(this, iBaseResponseCallback));
    }

    public void m10256c(IBaseResponseCallback iBaseResponseCallback) {
        g.c("PluginMessageCenter", "getFAQMessageList");
        k.a(new t(this, iBaseResponseCallback));
    }

    public boolean m10248a(String str) {
        g.c("PluginMessageCenter", "onRead | msgId = " + str);
        return a.a(this.f6836b).b(str);
    }

    public void m10245a(MessageObserver messageObserver) {
        com.huawei.pluginmessagecenter.provider.a.a().a(messageObserver);
    }

    public void m10251b(MessageObserver messageObserver) {
        com.huawei.pluginmessagecenter.provider.a.a().b(messageObserver);
    }

    public void m10252b(String str) {
        synchronized (this.f6838d) {
            g.c("PluginMessageCenter", "deleteMessage | msgId = " + str);
            m10246a(str, null);
        }
    }

    public void m10246a(String str, IBaseResponseCallback iBaseResponseCallback) {
        synchronized (this.f6838d) {
            g.c("PluginMessageCenter", "deleteMessage | msgId = " + str);
            k.a(new u(this, str, iBaseResponseCallback));
        }
    }

    public void m10257d(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (this.f6838d) {
            k.a(new v(this, iBaseResponseCallback));
        }
    }

    public void m10241a() {
        g.c("PluginMessageCenter", "Enter doRefresh");
        Executors.newSingleThreadExecutor().execute(new l(this));
    }

    public void m10249b() {
        synchronized (this.f6838d) {
            if (System.currentTimeMillis() - this.f6839e > 14400000) {
                m10241a();
            }
        }
    }

    public void m10255c() {
        g.c("PluginMessageCenter", "Enter doRefresh !");
        this.f6839e = System.currentTimeMillis();
        long b = a.a(this.f6836b).b();
        if (b < 0) {
            com.huawei.pluginmessagecenter.provider.a.a().a(-1, new MessageChangeEvent(new ArrayList(), new ArrayList()));
            g.c("PluginMessageCenter", "doRefresh because maxTime < 0 return!");
            return;
        }
        d.a().a(this.f6836b, b, new m(this));
        g.c("PluginMessageCenter", "Leave doRefresh !");
    }

    public void m10253b(String str, IBaseResponseCallback iBaseResponseCallback) {
        g.c("PluginMessageCenter", "getMessageCenterListMessageForHealth");
        k.a(new n(this, str, iBaseResponseCallback));
    }
}
