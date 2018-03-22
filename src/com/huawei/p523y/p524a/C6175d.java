package com.huawei.p523y.p524a;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.p248b.p249a.p250a.p251a.C3534h;

/* compiled from: HWOTAV1Mgr */
class C6175d implements Callback {
    final /* synthetic */ C6174c f21650a;

    C6175d(C6174c c6174c) {
        this.f21650a = c6174c;
    }

    public boolean handleMessage(Message message) {
        C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: receive message " + message.what});
        C3534h a = C3534h.m17703a(message.what);
        if (a != null) {
            switch (C6176e.f21651a[a.ordinal()]) {
                case 1:
                    this.f21650a.m28570a(message);
                    break;
                case 2:
                    C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: " + this.f21650a.f21640c.m17702c() + " connected"});
                    if (!this.f21650a.m28580f()) {
                        this.f21650a.m28569a(0, null);
                    }
                    try {
                        this.f21650a.f21640c.m17694a(10, 770, new int[0]);
                        break;
                    } catch (Exception e) {
                        C2538c.e("HWOTAV1Mgr", new Object[]{"gaia: sendCommand error e = " + e.getMessage()});
                        break;
                    }
                case 3:
                    C2538c.b("HWOTAV1Mgr", new Object[]{"gaia: " + this.f21650a.f21640c.m17702c() + "disconnected"});
                    if (this.f21650a.f21641d != null) {
                        try {
                            this.f21650a.f21641d.a(104007, "disconnected");
                        } catch (Exception e2) {
                            C2538c.e("HWOTAV1Mgr", new Object[]{"disconnected error" + e2.getMessage()});
                        }
                    }
                    this.f21650a.m28586e();
                    break;
                case 4:
                    this.f21650a.m28569a(8, "gaia: " + message.obj.toString());
                    break;
                case 5:
                    this.f21650a.m28582h();
                    break;
                default:
                    this.f21650a.m28569a(8, String.format("gaia: unhandled 0x%04X", new Object[]{Integer.valueOf(message.what)}));
                    break;
            }
        }
        C2538c.e("HWOTAV1Mgr", new Object[]{"gaia: handleMessage: value == null"});
        return false;
    }
}
