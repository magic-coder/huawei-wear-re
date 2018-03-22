package com.google.android.gms.internal;

import java.io.IOException;

public final class ee extends ek<ee> {
    private static volatile ee[] f713c;
    public String f714a;
    public ef f715b;

    public ee() {
        m1305c();
    }

    public static ee[] m1300a() {
        if (f713c == null) {
            synchronized (eo.f758c) {
                if (f713c == null) {
                    f713c = new ee[0];
                }
            }
        }
        return f713c;
    }

    public ee m1301a(eh ehVar) throws IOException {
        while (true) {
            int a = ehVar.m1320a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.f714a = ehVar.m1335h();
                    continue;
                case 18:
                    if (this.f715b == null) {
                        this.f715b = new ef();
                    }
                    ehVar.m1322a(this.f715b);
                    continue;
                default:
                    if (!super.m1290a(ehVar, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public void mo1871a(ei eiVar) throws IOException {
        eiVar.m1384a(1, this.f714a);
        if (this.f715b != null) {
            eiVar.m1383a(2, this.f715b);
        }
        super.mo1871a(eiVar);
    }

    protected int mo1872b() {
        int b = super.mo1872b() + ei.m1356b(1, this.f714a);
        return this.f715b != null ? b + ei.m1364c(2, this.f715b) : b;
    }

    public /* synthetic */ eq mo1875b(eh ehVar) throws IOException {
        return m1301a(ehVar);
    }

    public ee m1305c() {
        this.f714a = "";
        this.f715b = null;
        this.o = null;
        this.p = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ee)) {
            return false;
        }
        ee eeVar = (ee) obj;
        if (this.f714a == null) {
            if (eeVar.f714a != null) {
                return false;
            }
        } else if (!this.f714a.equals(eeVar.f714a)) {
            return false;
        }
        if (this.f715b == null) {
            if (eeVar.f715b != null) {
                return false;
            }
        } else if (!this.f715b.equals(eeVar.f715b)) {
            return false;
        }
        return (this.o == null || this.o.m1419b()) ? eeVar.o == null || eeVar.o.m1419b() : this.o.equals(eeVar.o);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f715b == null ? 0 : this.f715b.hashCode()) + (((this.f714a == null ? 0 : this.f714a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (!(this.o == null || this.o.m1419b())) {
            i = this.o.hashCode();
        }
        return hashCode + i;
    }
}
