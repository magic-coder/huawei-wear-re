package com.google.android.gms.internal;

import java.io.IOException;

public final class ed extends ek<ed> {
    public ee[] f712a;

    public ed() {
        m1295a();
    }

    public static ed m1294a(byte[] bArr) throws ep {
        return (ed) eq.m1278a(new ed(), bArr);
    }

    public ed m1295a() {
        this.f712a = ee.m1300a();
        this.o = null;
        this.p = -1;
        return this;
    }

    public ed m1296a(eh ehVar) throws IOException {
        while (true) {
            int a = ehVar.m1320a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    int a2 = et.m1450a(ehVar, 10);
                    a = this.f712a == null ? 0 : this.f712a.length;
                    Object obj = new ee[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.f712a, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new ee();
                        ehVar.m1322a(obj[a]);
                        ehVar.m1320a();
                        a++;
                    }
                    obj[a] = new ee();
                    ehVar.m1322a(obj[a]);
                    this.f712a = obj;
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
        if (this.f712a != null && this.f712a.length > 0) {
            for (eq eqVar : this.f712a) {
                if (eqVar != null) {
                    eiVar.m1383a(1, eqVar);
                }
            }
        }
        super.mo1871a(eiVar);
    }

    protected int mo1872b() {
        int b = super.mo1872b();
        if (this.f712a != null && this.f712a.length > 0) {
            for (eq eqVar : this.f712a) {
                if (eqVar != null) {
                    b += ei.m1364c(1, eqVar);
                }
            }
        }
        return b;
    }

    public /* synthetic */ eq mo1875b(eh ehVar) throws IOException {
        return m1296a(ehVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ed)) {
            return false;
        }
        ed edVar = (ed) obj;
        return eo.m1432a(this.f712a, edVar.f712a) ? (this.o == null || this.o.m1419b()) ? edVar.o == null || edVar.o.m1419b() : this.o.equals(edVar.o) : false;
    }

    public int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + eo.m1428a(this.f712a)) * 31;
        int hashCode2 = (this.o == null || this.o.m1419b()) ? 0 : this.o.hashCode();
        return hashCode2 + hashCode;
    }
}
