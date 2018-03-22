package com.huawei.wallet.logic.tlv;

import java.util.Arrays;

public class TlvTag {
    public final byte[] f21299a;

    public TlvTag(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        this.f21299a = obj;
    }

    public TlvTag(String str) {
        this.f21299a = TlvUtil.m28098a(str);
    }

    public boolean m28094a() {
        return (this.f21299a[0] & 32) != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f21299a, ((TlvTag) obj).f21299a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f21299a);
    }

    public String toString() {
        return (m28094a() ? "+ " : "- ") + TlvUtil.m28097a(this.f21299a, 0, this.f21299a.length);
    }
}
