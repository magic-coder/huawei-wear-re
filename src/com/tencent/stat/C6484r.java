package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.p544a.C6443b;
import com.tencent.stat.p544a.C6445c;
import com.tencent.stat.p545b.C6463m;
import com.tencent.stat.p545b.C6468r;
import org.apache.log4j.helpers.FileWatchdog;

class C6484r implements Runnable {
    private C6443b f22531a;
    private C6473f f22532b = null;
    private C6450j f22533c = new C6485s(this);

    public C6484r(C6443b c6443b) {
        this.f22531a = c6443b;
        this.f22532b = C6470c.m29503a();
    }

    private void m29588a() {
        if (C6487u.m29602b().m29612a() > 0) {
            C6487u.m29602b().m29614a(this.f22531a, null);
            C6487u.m29602b().m29613a(-1);
            return;
        }
        m29589a(true);
    }

    private void m29589a(boolean z) {
        C6477k.m29580b().m29582a(this.f22531a, this.f22533c);
    }

    public void run() {
        try {
            if (!C6470c.m29515b()) {
                return;
            }
            if (this.f22531a.mo5342a() == C6445c.ERROR || this.f22531a.m29367d().length() <= C6470c.m29537t()) {
                if (C6470c.m29531n() > 0) {
                    if (C6470c.m29532o() >= C6470c.m29531n()) {
                        C6474g.f22503i.m29411f("Times for reporting events has reached the limit of StatConfig.getMaxSessionStatReportCount() in current session.");
                        return;
                    }
                    C6470c.m29533p();
                }
                C6474g.f22503i.m29407b("Lauch stat task in thread:" + Thread.currentThread().getName());
                Context c = this.f22531a.m29366c();
                if (C6463m.m29465h(c)) {
                    if (C6470c.m29528k() && this.f22532b != C6473f.ONLY_WIFI_NO_CACHE && C6463m.m29463g(c)) {
                        this.f22532b = C6473f.INSTANT;
                    }
                    switch (C6481o.f22527a[this.f22532b.ordinal()]) {
                        case 1:
                            m29588a();
                            return;
                        case 2:
                            if (C6463m.m29459e(c)) {
                                m29588a();
                                return;
                            } else {
                                C6487u.m29594a(c).m29614a(this.f22531a, null);
                                return;
                            }
                        case 3:
                        case 4:
                            C6487u.m29594a(c).m29614a(this.f22531a, null);
                            return;
                        case 5:
                            if (C6487u.m29594a(this.f22531a.m29366c()) != null) {
                                C6487u.m29594a(c).m29614a(this.f22531a, new C6486t(this));
                                return;
                            }
                            return;
                        case 6:
                            C6487u.m29594a(c).m29614a(this.f22531a, null);
                            String str = "last_period_ts";
                            Long valueOf = Long.valueOf(C6468r.m29491a(c, str, 0));
                            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                            if (Long.valueOf(Long.valueOf(valueOf2.longValue() - valueOf.longValue()).longValue() / FileWatchdog.DEFAULT_DELAY).longValue() > ((long) C6470c.m29526i())) {
                                C6487u.m29594a(c).m29613a(-1);
                                C6468r.m29495b(c, str, valueOf2.longValue());
                                return;
                            }
                            return;
                        case 7:
                            if (C6463m.m29459e(c)) {
                                m29589a(false);
                                return;
                            }
                            return;
                        default:
                            C6474g.f22503i.m29410e("Invalid stat strategy:" + C6470c.m29503a());
                            return;
                    }
                    C6474g.f22503i.m29411f(th);
                }
                C6487u.m29594a(c).m29614a(this.f22531a, null);
                return;
            }
            C6474g.f22503i.m29411f("Event length exceed StatConfig.getMaxReportEventLength(): " + C6470c.m29537t());
        } catch (Exception e) {
            C6474g.f22503i.m29406b(e);
        } catch (Throwable th) {
            C6474g.f22503i.m29411f(th);
        }
    }
}
