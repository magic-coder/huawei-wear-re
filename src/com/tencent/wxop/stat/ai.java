package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p546a.C6495d;
import com.tencent.wxop.stat.p547b.C6517l;
import com.tencent.wxop.stat.p547b.C6522q;

final class ai {
    private static volatile long f22615f = 0;
    private C6495d f22616a;
    private C6545w f22617b = null;
    private boolean f22618c = false;
    private Context f22619d = null;
    private long f22620e = System.currentTimeMillis();

    public ai(C6495d c6495d) {
        this.f22616a = c6495d;
        this.f22617b = C6544v.m29815a();
        this.f22618c = c6495d.m29634f();
        this.f22619d = c6495d.m29633e();
    }

    private void m29655a(C6505k c6505k) {
        C6534l.m29803b(C6546x.f22859t).m29804a(this.f22616a, c6505k);
    }

    private void m29657b() {
        if (am.m29680b().f22627a <= 0 || !C6544v.f22817m) {
            m29655a(new al(this));
            return;
        }
        am.m29680b().m29694a(this.f22616a, null, this.f22618c, true);
        am.m29680b().m29693a(-1);
    }

    public final void m29659a() {
        boolean z;
        long l;
        if (C6544v.f22812h > 0) {
            if (this.f22620e > C6546x.f22847h) {
                C6546x.f22846g.clear();
                C6546x.f22847h = this.f22620e + C6544v.f22813i;
                if (C6544v.m29830b()) {
                    C6546x.f22856q.m29702a("clear methodsCalledLimitMap, nextLimitCallClearTime=" + C6546x.f22847h);
                }
            }
            Integer valueOf = Integer.valueOf(this.f22616a.mo5348b().m29642a());
            Integer num = (Integer) C6546x.f22846g.get(valueOf);
            if (num != null) {
                C6546x.f22846g.put(valueOf, Integer.valueOf(num.intValue() + 1));
                if (num.intValue() > C6544v.f22812h) {
                    if (C6544v.m29830b()) {
                        C6546x.f22856q.m29708e("event " + this.f22616a.m29635g() + " was discard, cause of called limit, current:" + num + ", limit:" + C6544v.f22812h + ", period:" + C6544v.f22813i + " ms");
                    }
                    z = true;
                    if (z) {
                        if (C6544v.f22818n > 0 && this.f22620e >= f22615f) {
                            C6546x.m29879e(this.f22619d);
                            f22615f = this.f22620e + C6544v.f22819o;
                            if (C6544v.m29830b()) {
                                C6546x.f22856q.m29702a("nextFlushTime=" + f22615f);
                            }
                        }
                        if (C6548z.m29898a(this.f22619d).m29908f()) {
                            am.m29668a(this.f22619d).m29694a(this.f22616a, null, this.f22618c, false);
                            return;
                        }
                        if (C6544v.m29830b()) {
                            C6546x.f22856q.m29702a("sendFailedCount=" + C6546x.f22840a);
                        }
                        if (C6546x.m29867a()) {
                            if (this.f22616a.m29632d() != null && this.f22616a.m29632d().m29892a()) {
                                this.f22617b = C6545w.INSTANT;
                            }
                            if (C6544v.f22814j && C6548z.m29898a(C6546x.f22859t).m29907e()) {
                                this.f22617b = C6545w.INSTANT;
                            }
                            if (C6544v.m29830b()) {
                                C6546x.f22856q.m29702a("strategy=" + this.f22617b.name());
                            }
                            switch (ac.f22604a[this.f22617b.ordinal()]) {
                                case 1:
                                    m29657b();
                                    return;
                                case 2:
                                    am.m29668a(this.f22619d).m29694a(this.f22616a, null, this.f22618c, false);
                                    if (C6544v.m29830b()) {
                                        C6546x.f22856q.m29702a("PERIOD currTime=" + this.f22620e + ",nextPeriodSendTs=" + C6546x.f22842c + ",difftime=" + (C6546x.f22842c - this.f22620e));
                                    }
                                    if (C6546x.f22842c == 0) {
                                        C6546x.f22842c = C6522q.m29777a(this.f22619d, "last_period_ts");
                                        if (this.f22620e > C6546x.f22842c) {
                                            C6546x.m29881f(this.f22619d);
                                        }
                                        l = this.f22620e + ((long) ((C6544v.m29845l() * 60) * 1000));
                                        if (C6546x.f22842c > l) {
                                            C6546x.f22842c = l;
                                        }
                                        C6530g.m29799a(this.f22619d).m29800a();
                                    }
                                    if (C6544v.m29830b()) {
                                        C6546x.f22856q.m29702a("PERIOD currTime=" + this.f22620e + ",nextPeriodSendTs=" + C6546x.f22842c + ",difftime=" + (C6546x.f22842c - this.f22620e));
                                    }
                                    if (this.f22620e > C6546x.f22842c) {
                                        C6546x.m29881f(this.f22619d);
                                        return;
                                    }
                                    return;
                                case 3:
                                case 4:
                                    am.m29668a(this.f22619d).m29694a(this.f22616a, null, this.f22618c, false);
                                    return;
                                case 5:
                                    am.m29668a(this.f22619d).m29694a(this.f22616a, new aj(this), this.f22618c, true);
                                    return;
                                case 6:
                                    if (C6548z.m29898a(C6546x.f22859t).m29905c() != 1) {
                                        m29657b();
                                        return;
                                    } else {
                                        am.m29668a(this.f22619d).m29694a(this.f22616a, null, this.f22618c, false);
                                        return;
                                    }
                                case 7:
                                    if (C6517l.m29746e(this.f22619d)) {
                                        m29655a(new ak(this));
                                        return;
                                    }
                                    return;
                                default:
                                    C6546x.f22856q.m29707d("Invalid stat strategy:" + C6544v.m29815a());
                                    return;
                            }
                        }
                        am.m29668a(this.f22619d).m29694a(this.f22616a, null, this.f22618c, false);
                        if (this.f22620e - C6546x.f22841b > 1800000) {
                            C6546x.m29875c(this.f22619d);
                            return;
                        }
                        return;
                    }
                }
            }
            C6546x.f22846g.put(valueOf, Integer.valueOf(1));
        }
        z = false;
        if (z) {
            C6546x.m29879e(this.f22619d);
            f22615f = this.f22620e + C6544v.f22819o;
            if (C6544v.m29830b()) {
                C6546x.f22856q.m29702a("nextFlushTime=" + f22615f);
            }
            if (C6548z.m29898a(this.f22619d).m29908f()) {
                am.m29668a(this.f22619d).m29694a(this.f22616a, null, this.f22618c, false);
                return;
            }
            if (C6544v.m29830b()) {
                C6546x.f22856q.m29702a("sendFailedCount=" + C6546x.f22840a);
            }
            if (C6546x.m29867a()) {
                am.m29668a(this.f22619d).m29694a(this.f22616a, null, this.f22618c, false);
                if (this.f22620e - C6546x.f22841b > 1800000) {
                    C6546x.m29875c(this.f22619d);
                    return;
                }
                return;
            }
            this.f22617b = C6545w.INSTANT;
            this.f22617b = C6545w.INSTANT;
            if (C6544v.m29830b()) {
                C6546x.f22856q.m29702a("strategy=" + this.f22617b.name());
            }
            switch (ac.f22604a[this.f22617b.ordinal()]) {
                case 1:
                    m29657b();
                    return;
                case 2:
                    am.m29668a(this.f22619d).m29694a(this.f22616a, null, this.f22618c, false);
                    if (C6544v.m29830b()) {
                        C6546x.f22856q.m29702a("PERIOD currTime=" + this.f22620e + ",nextPeriodSendTs=" + C6546x.f22842c + ",difftime=" + (C6546x.f22842c - this.f22620e));
                    }
                    if (C6546x.f22842c == 0) {
                        C6546x.f22842c = C6522q.m29777a(this.f22619d, "last_period_ts");
                        if (this.f22620e > C6546x.f22842c) {
                            C6546x.m29881f(this.f22619d);
                        }
                        l = this.f22620e + ((long) ((C6544v.m29845l() * 60) * 1000));
                        if (C6546x.f22842c > l) {
                            C6546x.f22842c = l;
                        }
                        C6530g.m29799a(this.f22619d).m29800a();
                    }
                    if (C6544v.m29830b()) {
                        C6546x.f22856q.m29702a("PERIOD currTime=" + this.f22620e + ",nextPeriodSendTs=" + C6546x.f22842c + ",difftime=" + (C6546x.f22842c - this.f22620e));
                    }
                    if (this.f22620e > C6546x.f22842c) {
                        C6546x.m29881f(this.f22619d);
                        return;
                    }
                    return;
                case 3:
                case 4:
                    am.m29668a(this.f22619d).m29694a(this.f22616a, null, this.f22618c, false);
                    return;
                case 5:
                    am.m29668a(this.f22619d).m29694a(this.f22616a, new aj(this), this.f22618c, true);
                    return;
                case 6:
                    if (C6548z.m29898a(C6546x.f22859t).m29905c() != 1) {
                        am.m29668a(this.f22619d).m29694a(this.f22616a, null, this.f22618c, false);
                        return;
                    } else {
                        m29657b();
                        return;
                    }
                case 7:
                    if (C6517l.m29746e(this.f22619d)) {
                        m29655a(new ak(this));
                        return;
                    }
                    return;
                default:
                    C6546x.f22856q.m29707d("Invalid stat strategy:" + C6544v.m29815a());
                    return;
            }
        }
    }
}
