package com.tencent.open.p532d;

/* compiled from: ProGuard */
public final class ab implements Cloneable {
    private long f22216a;

    public ab(long j) {
        this.f22216a = j;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ab) && this.f22216a == ((ab) obj).m29172b()) {
            return true;
        }
        return false;
    }

    public byte[] m29171a() {
        return new byte[]{(byte) ((int) (this.f22216a & 255)), (byte) ((int) ((this.f22216a & 65280) >> 8)), (byte) ((int) ((this.f22216a & 16711680) >> 16)), (byte) ((int) ((this.f22216a & 4278190080L) >> 24))};
    }

    public long m29172b() {
        return this.f22216a;
    }

    public int hashCode() {
        return (int) this.f22216a;
    }
}
