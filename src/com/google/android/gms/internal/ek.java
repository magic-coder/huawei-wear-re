package com.google.android.gms.internal;

import java.io.IOException;

public abstract class ek<M extends ek<M>> extends eq {
    protected em f711o;

    private void m1288a(int i, es esVar) {
        en enVar = null;
        if (this.f711o == null) {
            this.f711o = new em();
        } else {
            enVar = this.f711o.m1416a(i);
        }
        if (enVar == null) {
            enVar = new en();
            this.f711o.m1417a(i, enVar);
        }
        enVar.m1424a(esVar);
    }

    public void mo1871a(ei eiVar) throws IOException {
        if (this.f711o != null) {
            for (int i = 0; i < this.f711o.m1415a(); i++) {
                this.f711o.m1418b(i).m1423a(eiVar);
            }
        }
    }

    protected final boolean m1290a(eh ehVar, int i) throws IOException {
        int q = ehVar.m1344q();
        if (!ehVar.m1325b(i)) {
            return false;
        }
        m1288a(et.m1451b(i), new es(i, ehVar.m1323a(q, ehVar.m1344q() - q)));
        return true;
    }

    protected int mo1872b() {
        int i = 0;
        if (this.f711o == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.f711o.m1415a()) {
            i2 += this.f711o.m1418b(i).m1422a();
            i++;
        }
        return i2;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m1292d();
    }

    public M m1292d() throws CloneNotSupportedException {
        ek ekVar = (ek) super.mo1874e();
        eo.m1429a(this, ekVar);
        return ekVar;
    }

    public /* synthetic */ eq mo1874e() throws CloneNotSupportedException {
        return (ek) clone();
    }
}
