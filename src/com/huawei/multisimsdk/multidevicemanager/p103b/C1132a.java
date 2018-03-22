package com.huawei.multisimsdk.multidevicemanager.p103b;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.multisimsdk.multidevicemanager.common.C1154f;
import com.huawei.multisimsdk.multidevicemanager.common.C1157i;
import com.huawei.multisimsdk.multidevicemanager.common.InProgressData;
import com.huawei.multisimsdk.multidevicemanager.p104c.C1140g;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1185k;
import java.util.HashMap;

/* compiled from: HandleControl */
public class C1132a {
    private static final String f2390a = C1132a.class.getSimpleName();
    private static C1132a f2391c;
    private static C1133b f2392d;
    private static final HashMap<String, Integer> f2393f = new HashMap();
    private static final HashMap<Integer, C1157i> f2394g = new HashMap();
    private Context f2395b;
    private HandlerThread f2396e = null;

    private C1132a() {
        if (this.f2396e == null) {
            this.f2396e = new HandlerThread(f2390a);
            this.f2396e.start();
        }
        f2392d = new C1133b(this, this.f2396e.getLooper());
    }

    public static synchronized C1132a m5034a() {
        C1132a c1132a;
        synchronized (C1132a.class) {
            if (f2391c == null) {
                f2391c = new C1132a();
            }
            c1132a = f2391c;
        }
        return c1132a;
    }

    public C1133b m5050b() {
        return f2392d;
    }

    public void m5049a(Context context) {
        this.f2395b = context;
    }

    public Context m5051c() {
        return this.f2395b;
    }

    public void m5052d() {
        if (f2392d != null) {
            f2392d = null;
        }
        if (this.f2396e != null) {
            this.f2396e.quit();
            this.f2396e = null;
        }
        if (f2391c != null) {
            f2391c = null;
        }
        this.f2395b = null;
    }

    private void m5038a(Message message) {
        C1183h.m5282b(f2390a, "startInvalidTokenHandler ");
        if (message != null) {
            InProgressData inProgressData = null;
            if (message.obj instanceof InProgressData) {
                inProgressData = (InProgressData) message.obj;
            }
            m5041a(inProgressData);
        }
        m5046d(message);
    }

    private void m5041a(InProgressData inProgressData) {
        if (inProgressData != null) {
            String primary = inProgressData.getPrimary();
            String a = C1185k.m5292a(this.f2395b, primary, "Tag");
            if (!"".equals(a)) {
                C1185k.m5303c(this.f2395b, a, "authen_Token");
                C1185k.m5303c(this.f2395b, a, "Tag");
                C1185k.m5303c(this.f2395b, primary, "Tag");
            }
            C1185k.m5303c(this.f2395b, inProgressData.getPrimary(), "authen_Token");
            C1183h.m5282b(f2390a, "start to deleteTokenInfo ");
            return;
        }
        C1183h.m5282b(f2390a, "startInvalidTokenHandler -- inProgressData is null ");
    }

    private InProgressData m5035a(C1157i c1157i, int i) {
        InProgressData inProgressData = new InProgressData();
        if (c1157i != null) {
            inProgressData.setPrimary(c1157i.m5150a());
            inProgressData.setPrimaryIDtype(c1157i.m5169j());
            inProgressData.setSecondaryID(c1157i.m5154b());
            inProgressData.setSecondarytype(c1157i.m5165g());
            inProgressData.setRsn(i);
            inProgressData.setType(c1157i.m5157c());
            inProgressData.setNikename(c1157i.m5163f());
            inProgressData.setServiceType(c1157i.m5167h());
            inProgressData.setDeviceid(c1157i.m5168i());
        }
        return inProgressData;
    }

    private void m5042b(Message message) {
        C1157i c1157i = null;
        if (message.obj instanceof C1157i) {
            c1157i = (C1157i) message.obj;
        }
        if (c1157i == null) {
            return;
        }
        if (TextUtils.isEmpty(C1185k.m5292a(this.f2395b, c1157i.m5150a(), "authen_Token"))) {
            Message e = c1157i.m5161e();
            if (e != null) {
                int c = c1157i.m5157c();
                C1154f c1154f = new C1154f();
                c1154f.m5141b(1);
                c1154f.m5143c(1);
                c1154f.m5138a(m5032a(c));
                e.obj = c1154f;
                C1185k.m5295a(e);
                return;
            }
            C1183h.m5282b(f2390a, "message =null ");
            return;
        }
        int a = C1185k.m5290a();
        if (!m5036a(c1157i, message).booleanValue()) {
            f2394g.put(Integer.valueOf(a), c1157i);
            message.obj = m5035a(c1157i, a);
            m5044c(message);
        }
    }

    private void m5044c(Message message) {
        InProgressData inProgressData = null;
        if (message.obj instanceof InProgressData) {
            inProgressData = (InProgressData) message.obj;
        }
        if (inProgressData != null) {
            int type = inProgressData.getType();
            C1183h.m5282b(f2390a, "handleAuthCallbackMethod = " + message.what + "type = " + type);
            if (100 == type) {
                f2392d.sendMessage(f2392d.obtainMessage(113, message.obj));
            } else if (101 == type) {
                f2392d.sendMessage(f2392d.obtainMessage(117, message.obj));
            } else {
                f2392d.sendMessage(f2392d.obtainMessage(ReportInfoUtils.FEEDBACK_FAILED, message.obj));
            }
        }
    }

    private void m5046d(Message message) {
        InProgressData inProgressData;
        if (message.obj instanceof InProgressData) {
            inProgressData = (InProgressData) message.obj;
        } else {
            inProgressData = null;
        }
        if (inProgressData != null) {
            Message message2;
            if (f2393f.containsKey(inProgressData.getSecondaryID())) {
                f2393f.remove(inProgressData.getSecondaryID());
            }
            int rsn = inProgressData.getRsn();
            C1157i c1157i = (C1157i) f2394g.get(Integer.valueOf(rsn));
            if (c1157i == null) {
                message2 = null;
            } else if (8889 != message.what) {
                message2 = c1157i.m5161e();
            } else {
                message2 = c1157i.m5159d();
            }
            if (message2 != null) {
                C1183h.m5282b(f2390a, "message.sendToTarget() +message.what= " + message2.what);
                message2.obj = m5047e(message);
                C1185k.m5295a(message2);
                if (8889 != message.what) {
                    f2394g.remove(Integer.valueOf(rsn));
                }
                f2393f.clear();
            } else {
                C1183h.m5282b(f2390a, "message =null ");
            }
            C1183h.m5282b(f2390a, "MSG_MULTISERVICE =finished ");
            return;
        }
        C1183h.m5282b(f2390a, "mutiProgressData =null ");
    }

    private C1154f m5047e(Message message) {
        C1154f c1154f = new C1154f();
        InProgressData inProgressData = null;
        if (message.obj instanceof InProgressData) {
            inProgressData = (InProgressData) message.obj;
        }
        if (inProgressData != null) {
            switch (message.what) {
                case 100:
                case 101:
                case 102:
                    c1154f.m5141b(1);
                    c1154f.m5143c(1);
                    break;
                case 106:
                    c1154f.m5141b(1);
                    m5041a(inProgressData);
                    c1154f.m5143c(inProgressData.getResultcode());
                    break;
                case 107:
                case 115:
                case TagName.ELECTRONIC_USE_COUNT /*119*/:
                case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
                    c1154f.m5141b(1);
                    c1154f.m5143c(inProgressData.getResultcode());
                    break;
                case 125:
                    c1154f.m5141b(0);
                    break;
                case 8888:
                    c1154f.m5141b(1);
                    c1154f.m5143c(3);
                    break;
                case 8889:
                    c1154f.m5141b(3);
                    break;
            }
            c1154f.m5138a(m5032a(inProgressData.getType()));
            C1183h.m5282b(f2390a, "message - resultcode = " + c1154f.m5142c());
            c1154f.m5139a(inProgressData.getMultiSIMServiceInfo());
        } else {
            C1183h.m5282b(f2390a, "message - inProgressData=null ");
        }
        return c1154f;
    }

    private void m5037a(Context context, Message message) {
        InProgressData inProgressData = null;
        if (message.obj instanceof InProgressData) {
            inProgressData = (InProgressData) message.obj;
        }
        C1140g c1140g = new C1140g(context);
        c1140g.m5084a(inProgressData);
        c1140g.m5083a();
    }

    private Boolean m5036a(C1157i c1157i, Message message) {
        if (!(c1157i == null || 102 == message.what)) {
            if (f2393f.containsKey(c1157i.m5154b())) {
                Message e = c1157i.m5161e();
                if (e != null) {
                    C1183h.m5282b(f2390a, "message.sendToTarget() +msg.what= " + e.what + "msg.ag1=" + e.arg1);
                    int c = c1157i.m5157c();
                    C1154f c1154f = new C1154f();
                    c1154f.m5141b(2);
                    c1154f.m5143c(99);
                    c1154f.m5138a(m5032a(c));
                    e.obj = c1154f;
                    C1185k.m5295a(e);
                } else {
                    C1183h.m5282b(f2390a, "message =null ");
                }
                C1183h.m5282b(f2390a, "getSecondaryID is same id ");
                return Boolean.valueOf(true);
            }
            f2393f.put(c1157i.m5154b(), Integer.valueOf(1));
        }
        return Boolean.valueOf(false);
    }

    private int m5032a(int i) {
        switch (i) {
            case 101:
                return 2;
            case 102:
                return 1;
            default:
                return 0;
        }
    }
}
