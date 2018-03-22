package com.huawei.android.pushagent.p017a.p322b;

import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import java.io.IOException;
import java.io.InputStream;

public class C4051j extends C4041b {
    private byte f15367b = (byte) 10;

    public C4051j() {
        super(C4051j.m19901c());
    }

    public static byte m19901c() {
        return (byte) -38;
    }

    public C4041b mo4356a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1];
        C4041b.m19864a(inputStream, bArr);
        this.f15367b = bArr[0];
        return this;
    }

    public void m19903a(byte b) {
        this.f15367b = b;
    }

    public byte[] mo4355b() {
        return new byte[]{mo4353a(), m19905d()};
    }

    public byte m19905d() {
        return this.f15367b;
    }

    public String toString() {
        return new StringBuffer(getClass().getSimpleName()).append(" cmdId:").append(m19868j()).append(" NextHeartBeatToServer:").append(this.f15367b).toString();
    }
}
