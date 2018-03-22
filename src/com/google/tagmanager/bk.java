package com.google.tagmanager;

/* compiled from: TypedNumber */
class bk extends Number implements Comparable<bk> {
    private double f14310a;
    private long f14311b;
    private boolean f14312c = true;

    public /* synthetic */ int compareTo(Object obj) {
        return m18523a((bk) obj);
    }

    private bk(long j) {
        this.f14311b = j;
    }

    public static bk m18522a(long j) {
        return new bk(j);
    }

    public String toString() {
        return m18525b() ? Long.toString(this.f14311b) : Double.toString(this.f14310a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof bk) && m18523a((bk) obj) == 0;
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int m18523a(bk bkVar) {
        return (m18525b() && bkVar.m18525b()) ? new Long(this.f14311b).compareTo(Long.valueOf(bkVar.f14311b)) : Double.compare(doubleValue(), bkVar.doubleValue());
    }

    public boolean m18524a() {
        return !m18525b();
    }

    public boolean m18525b() {
        return this.f14312c;
    }

    public double doubleValue() {
        return m18525b() ? (double) this.f14311b : this.f14310a;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public long longValue() {
        return m18526c();
    }

    public long m18526c() {
        return m18525b() ? this.f14311b : (long) this.f14310a;
    }

    public int intValue() {
        return m18527d();
    }

    public int m18527d() {
        return (int) longValue();
    }

    public short shortValue() {
        return m18528e();
    }

    public short m18528e() {
        return (short) ((int) longValue());
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }
}
