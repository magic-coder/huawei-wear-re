package com.huawei.multisimsdk.multidevicemanager.p104c;

import android.content.Context;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import com.huawei.multisimsdk.multidevicemanager.common.C1160l;
import com.huawei.multisimsdk.multidevicemanager.common.C1161m;
import com.huawei.multisimsdk.multidevicemanager.common.C1165q;
import com.huawei.multisimsdk.multidevicemanager.common.C1167s;
import com.huawei.multisimsdk.multidevicemanager.common.InProgressData;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1141i;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1176a;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1185k;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.QueryRecordsListCallback;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: QueryManager */
public class C1143i {
    private static final String f2412a = C1143i.class.getSimpleName();
    private static int f2413g = 3000;
    private static int f2414h = 3;
    private Context f2415b;
    private InProgressData f2416c;
    private Timer f2417d = null;
    private TimerTask f2418e = null;
    private int f2419f = 1;
    private C1141i f2420i = new C1144j(this);

    public void m5102a(InProgressData inProgressData) {
        this.f2416c = inProgressData;
    }

    public C1143i(Context context) {
        this.f2415b = context;
    }

    public void m5101a() {
        if (this.f2416c != null) {
            int type = this.f2416c.getType();
            if (100 == type || 101 == type) {
                m5091a((long) (this.f2416c.getTime() / 6));
            } else {
                m5095b();
            }
        }
    }

    private void m5095b() {
        C1176a.m5272a().m5273a(C1185k.m5293a(this.f2416c), m5097c(), this.f2420i);
    }

    private String m5097c() {
        C1160l c1160l = new C1160l();
        String str = null;
        c1160l.m5185a(C1185k.m5290a());
        c1160l.m5186a("GetDevServInfo");
        if (this.f2416c != null) {
            str = this.f2416c.getPrimary();
            c1160l.m5189d(this.f2416c.getServiceType());
            c1160l.m5188c(str);
            c1160l.m5187b(this.f2416c.getPrimaryIDtype());
            c1160l.m5190e(this.f2416c.getSecondarytype());
            c1160l.m5191f(this.f2416c.getSecondaryID());
        }
        Object a = C1185k.m5292a(this.f2415b, str, "OldTimeStamp");
        if (!TextUtils.isEmpty(a)) {
            c1160l.m5192g(a);
        }
        C1161m c1161m = new C1161m();
        c1161m.m5195a(c1160l);
        c1161m.m5194a(C1185k.m5291a(this.f2415b, str));
        return c1161m.m5193a();
    }

    private void m5094a(C1167s c1167s) {
        if (c1167s != null) {
            int a = c1167s.m5223a();
            this.f2416c.setResultcode(a);
            C1183h.m5282b(f2412a, "get query resultcode=" + a);
            if (1500 == a) {
                C1183h.m5282b(f2412a, "get add-query result");
                C1185k.m5298a(this.f2415b, this.f2416c.getPrimary(), "OldTimeStamp", c1167s.m5226c());
                this.f2416c.setMultiSIMServiceInfo(c1167s.m5225b());
                C1185k.m5294a(125, this.f2416c);
                return;
            } else if (1502 == a) {
                a = this.f2416c.getTime() / 6;
                if (this.f2419f < f2414h) {
                    this.f2419f++;
                    C1183h.m5282b(f2412a, "get add-query timer = " + this.f2419f);
                    m5099d();
                    if (a > 0) {
                        m5091a((long) (a * this.f2419f));
                        return;
                    } else {
                        m5091a((long) f2413g);
                        return;
                    }
                }
                C1183h.m5282b(f2412a, "get add-query result");
                C1185k.m5294a((int) TransportMediator.KEYCODE_MEDIA_PLAY, this.f2416c);
                return;
            } else {
                C1183h.m5282b(f2412a, "get query response send to fail ");
                C1185k.m5294a((int) TransportMediator.KEYCODE_MEDIA_PLAY, this.f2416c);
                return;
            }
        }
        C1183h.m5282b(f2412a, "responseGetDevServInfo is null");
        this.f2416c.setResultcode(99);
        C1185k.m5294a((int) TransportMediator.KEYCODE_MEDIA_PLAY, this.f2416c);
    }

    private void m5096b(C1167s c1167s) {
        if (c1167s != null) {
            int a = c1167s.m5223a();
            this.f2416c.setResultcode(a);
            C1183h.m5282b(f2412a, "get query resultcode=" + a);
            if (1502 == a) {
                C1183h.m5282b(f2412a, "get Remove-query result");
                C1185k.m5298a(this.f2415b, this.f2416c.getPrimary(), "OldTimeStamp", c1167s.m5226c());
                this.f2416c.setMultiSIMServiceInfo(c1167s.m5225b());
                C1185k.m5294a(125, this.f2416c);
                return;
            } else if (1500 == a) {
                a = this.f2416c.getTime() / 6;
                if (this.f2419f < f2414h) {
                    this.f2419f++;
                    C1183h.m5282b(f2412a, "get Remove-query timer = " + this.f2419f);
                    m5099d();
                    if (a > 0) {
                        m5091a((long) (a * this.f2419f));
                        return;
                    } else {
                        m5091a((long) f2413g);
                        return;
                    }
                }
                C1183h.m5282b(f2412a, "get Remove-query result ");
                C1185k.m5294a((int) TransportMediator.KEYCODE_MEDIA_PLAY, this.f2416c);
                return;
            } else {
                C1183h.m5282b(f2412a, "get query response send to fail ");
                C1185k.m5294a((int) TransportMediator.KEYCODE_MEDIA_PLAY, this.f2416c);
                return;
            }
        }
        C1183h.m5282b(f2412a, "responseGetDevServInfo is null");
        this.f2416c.setResultcode(99);
        C1185k.m5294a((int) TransportMediator.KEYCODE_MEDIA_PLAY, this.f2416c);
    }

    private void m5098c(C1167s c1167s) {
        if (c1167s != null) {
            int a = c1167s.m5223a();
            this.f2416c.setResultcode(a);
            C1183h.m5282b(f2412a, "get query resultcode=" + a);
            if (1500 == a) {
                C1183h.m5282b(f2412a, "start query service");
                C1185k.m5298a(this.f2415b, this.f2416c.getPrimary(), "OldTimeStamp", c1167s.m5226c());
                this.f2416c.setMultiSIMServiceInfo(c1167s.m5225b());
                C1185k.m5294a(125, this.f2416c);
                return;
            } else if (QueryRecordsListCallback.RESULT_FAILED_TRAFFIC_CARD_RECORDS_READ_FAILED == a) {
                C1183h.m5282b(f2412a, "get query response data no change ");
                C1185k.m5294a(125, this.f2416c);
                return;
            } else {
                C1183h.m5282b(f2412a, "get query response send to fail resultcode =" + a);
                C1185k.m5294a((int) TransportMediator.KEYCODE_MEDIA_PLAY, this.f2416c);
                return;
            }
        }
        C1183h.m5282b(f2412a, "responseGetDevServInfo is null");
        this.f2416c.setResultcode(99);
        C1185k.m5294a((int) TransportMediator.KEYCODE_MEDIA_PLAY, this.f2416c);
    }

    private void m5091a(long j) {
        if (this.f2417d == null) {
            this.f2417d = new Timer();
        }
        if (this.f2418e == null) {
            this.f2418e = new C1145k(this);
        }
        this.f2417d.schedule(this.f2418e, j);
    }

    private void m5099d() {
        if (this.f2417d != null) {
            this.f2417d.cancel();
            this.f2417d = null;
        }
        if (this.f2418e != null) {
            this.f2418e.cancel();
            this.f2418e = null;
        }
    }

    private Boolean m5090a(C1165q c1165q) {
        if (c1165q != null) {
            int b = c1165q.m5214b();
            this.f2416c.setResultcode(b);
            C1183h.m5282b(f2412a, "handlerQuickAuthenResult.getResultcode()=" + b);
            if (1000 == b) {
                C1183h.m5282b(f2412a, "TokenAuthen is valid");
                return Boolean.valueOf(true);
            } else if (1004 == b) {
                C1183h.m5282b(f2412a, "TokenAuthen is invalid");
                C1185k.m5294a(107, this.f2416c);
                return Boolean.valueOf(false);
            } else {
                C1183h.m5282b(f2412a, "TokenAuthen is fail");
                C1185k.m5294a(106, this.f2416c);
                return Boolean.valueOf(false);
            }
        }
        C1183h.m5282b(f2412a, "responseAuthFirstInfo is null");
        C1185k.m5294a(106, this.f2416c);
        return Boolean.valueOf(false);
    }

    private void m5100d(C1167s c1167s) {
        if (this.f2416c != null) {
            int type = this.f2416c.getType();
            C1183h.m5282b(f2412a, "type = " + type);
            if (100 == type) {
                m5094a(c1167s);
            } else if (101 == type) {
                m5096b(c1167s);
            } else {
                m5098c(c1167s);
            }
        }
    }
}
