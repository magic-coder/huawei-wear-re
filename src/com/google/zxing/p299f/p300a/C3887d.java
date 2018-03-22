package com.google.zxing.p299f.p300a;

/* compiled from: Codeword */
final class C3887d {
    private final int f15003a;
    private final int f15004b;
    private final int f15005c;
    private final int f15006d;
    private int f15007e = -1;

    C3887d(int i, int i2, int i3, int i4) {
        this.f15003a = i;
        this.f15004b = i2;
        this.f15005c = i3;
        this.f15006d = i4;
    }

    boolean m19357a() {
        return m19358a(this.f15007e);
    }

    boolean m19358a(int i) {
        return i != -1 && this.f15005c == (i % 3) * 3;
    }

    void m19359b() {
        this.f15007e = ((this.f15006d / 30) * 3) + (this.f15005c / 3);
    }

    int m19361c() {
        return this.f15004b - this.f15003a;
    }

    int m19362d() {
        return this.f15003a;
    }

    int m19363e() {
        return this.f15004b;
    }

    int m19364f() {
        return this.f15005c;
    }

    int m19365g() {
        return this.f15006d;
    }

    int m19366h() {
        return this.f15007e;
    }

    void m19360b(int i) {
        this.f15007e = i;
    }

    public String toString() {
        return this.f15007e + "|" + this.f15006d;
    }
}
