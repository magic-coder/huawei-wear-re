package com.google.zxing.p295e.p296a.p297a.p298a;

/* compiled from: CurrentParsingState */
final class C3845m {
    private int f14857a = 0;
    private C3846n f14858b = C3846n.NUMERIC;

    C3845m() {
    }

    int m19134a() {
        return this.f14857a;
    }

    void m19135a(int i) {
        this.f14857a = i;
    }

    void m19136b(int i) {
        this.f14857a += i;
    }

    boolean m19137b() {
        return this.f14858b == C3846n.ALPHA;
    }

    boolean m19138c() {
        return this.f14858b == C3846n.ISO_IEC_646;
    }

    void m19139d() {
        this.f14858b = C3846n.NUMERIC;
    }

    void m19140e() {
        this.f14858b = C3846n.ALPHA;
    }

    void m19141f() {
        this.f14858b = C3846n.ISO_IEC_646;
    }
}
