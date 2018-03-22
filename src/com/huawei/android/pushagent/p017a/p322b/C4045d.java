package com.huawei.android.pushagent.p017a.p322b;

import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import java.io.IOException;
import java.io.InputStream;

public class C4045d extends C4041b {
    private byte f15354b = (byte) 1;

    public C4045d() {
        super(C4045d.m19878c());
    }

    public static byte m19878c() {
        return (byte) -45;
    }

    public C4041b mo4356a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1];
        C4041b.m19864a(inputStream, bArr);
        this.f15354b = bArr[0];
        return this;
    }

    public byte[] mo4355b() {
        return new byte[]{mo4353a(), this.f15354b};
    }

    public byte m19881d() {
        return this.f15354b;
    }

    public String toString() {
        return new StringBuffer(getClass().getSimpleName()).append(" cmdId:").append(m19868j()).append(" result:").append(this.f15354b).toString();
    }
}
