package cn.com.xy.sms.sdk.p220j.p224d;

import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2928f;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;

public final class C3025a implements Runnable {
    public String f10212a = null;
    public String f10213b = null;
    public boolean f10214c = false;
    private int f10215d = 0;

    private C3025a() {
    }

    public C3025a(int i) {
        this.f10215d = i;
    }

    private void m13560a() {
        this.f10212a = null;
        this.f10213b = null;
    }

    public final void run() {
        try {
            this.f10214c = true;
            switch (this.f10215d) {
                case 1:
                    C3030f.m13574a(this.f10213b, this.f10212a, false);
                    C3030f.m13577b(this.f10213b, this.f10212a, false);
                    C2928f.m13187b();
                    synchronized (this) {
                        C3030f.f10239b = false;
                    }
                    break;
                case 2:
                    try {
                        if (C2996a.m13492a(1)) {
                            C3030f.m13572a(this.f10213b, this.f10212a);
                        }
                        C3030f.m13571a();
                        break;
                    } catch (Throwable th) {
                        C2982a.m13415a("XIAOYUAN", th.getMessage(), th);
                        break;
                    }
            }
            this.f10214c = false;
            m13560a();
        } catch (Throwable th2) {
            try {
                C2982a.m13415a("XIAOYUAN", th2.getMessage(), th2);
            } finally {
                this.f10214c = false;
                m13560a();
            }
        }
    }
}
