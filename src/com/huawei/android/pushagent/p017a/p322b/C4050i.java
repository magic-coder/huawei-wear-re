package com.huawei.android.pushagent.p017a.p322b;

import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import java.io.IOException;
import java.io.InputStream;

public class C4050i extends C4041b {
    private byte f15366b = (byte) 1;

    public C4050i() {
        super(C4050i.m19897c());
    }

    public static byte m19897c() {
        return (byte) -33;
    }

    public C4041b mo4356a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1];
        C4041b.m19864a(inputStream, bArr);
        this.f15366b = bArr[0];
        return this;
    }

    public byte[] mo4355b() {
        return new byte[]{mo4353a(), this.f15366b};
    }

    public byte m19900d() {
        return this.f15366b;
    }

    public String toString() {
        return new StringBuffer(getClass().getSimpleName()).append(" cmdId:").append(m19868j()).append(" result:").append(this.f15366b).toString();
    }
}
