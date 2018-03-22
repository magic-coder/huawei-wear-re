package com.huawei.android.pushagent.p017a.p322b;

public class C4042a {
    private String f15348a;
    private byte[] f15349b;
    private byte[] f15350c;

    public C4042a(String str, byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            this.f15348a = str;
            this.f15349b = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f15349b, 0, bArr.length);
            this.f15350c = new byte[bArr2.length];
            System.arraycopy(bArr2, 0, this.f15350c, 0, bArr2.length);
        }
    }

    public String m19869a() {
        return this.f15348a;
    }

    public byte[] m19870b() {
        return this.f15349b;
    }

    public byte[] m19871c() {
        return this.f15350c;
    }
}
