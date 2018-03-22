package com.google.android.gms.internal;

import java.io.IOException;

public final class ef extends ek<ef> {
    private static volatile ef[] f716c;
    public int f717a;
    public eg f718b;

    public ef() {
        m1311c();
    }

    public static ef[] m1306a() {
        if (f716c == null) {
            synchronized (eo.f758c) {
                if (f716c == null) {
                    f716c = new ef[0];
                }
            }
        }
        return f716c;
    }

    public ef m1307a(eh ehVar) throws IOException {
        while (true) {
            int a = ehVar.m1320a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    a = ehVar.m1331f();
                    switch (a) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                            this.f717a = a;
                            break;
                        default:
                            continue;
                    }
                case 18:
                    if (this.f718b == null) {
                        this.f718b = new eg();
                    }
                    ehVar.m1322a(this.f718b);
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
        eiVar.m1381a(1, this.f717a);
        if (this.f718b != null) {
            eiVar.m1383a(2, this.f718b);
        }
        super.mo1871a(eiVar);
    }

    protected int mo1872b() {
        int b = super.mo1872b() + ei.m1363c(1, this.f717a);
        return this.f718b != null ? b + ei.m1364c(2, this.f718b) : b;
    }

    public /* synthetic */ eq mo1875b(eh ehVar) throws IOException {
        return m1307a(ehVar);
    }

    public ef m1311c() {
        this.f717a = 1;
        this.f718b = null;
        this.o = null;
        this.p = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ef)) {
            return false;
        }
        ef efVar = (ef) obj;
        if (this.f717a != efVar.f717a) {
            return false;
        }
        if (this.f718b == null) {
            if (efVar.f718b != null) {
                return false;
            }
        } else if (!this.f718b.equals(efVar.f718b)) {
            return false;
        }
        return (this.o == null || this.o.m1419b()) ? efVar.o == null || efVar.o.m1419b() : this.o.equals(efVar.o);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f718b == null ? 0 : this.f718b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.f717a) * 31)) * 31;
        if (!(this.o == null || this.o.m1419b())) {
            i = this.o.hashCode();
        }
        return hashCode + i;
    }
}
