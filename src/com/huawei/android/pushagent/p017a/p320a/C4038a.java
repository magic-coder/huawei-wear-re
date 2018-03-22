package com.huawei.android.pushagent.p017a.p320a;

import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p320a.p321a.C4037b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class C4038a extends C4037b {
    private short f15338b;
    private short f15339c = ((short) (a.a().hashCode() & 255));
    private int f15340d;

    public C4038a(int i) {
        super(C4038a.m19854c());
        this.f15340d = i;
        this.f15338b = (short) 7;
    }

    private static byte m19854c() {
        return (byte) 1;
    }

    public C4037b mo4354a(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[2];
            C4037b.m19848a(inputStream, bArr);
            this.f15339c = (short) a.c(bArr);
            bArr = new byte[4];
            C4037b.m19848a(inputStream, bArr);
            this.f15340d = a.b(bArr);
        } catch (Throwable e) {
            e.c("PushLogAC2712", e.toString(), e);
        }
        return this;
    }

    public byte[] mo4355b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(a.b(this.f15338b));
            byteArrayOutputStream.write(mo4353a());
            byteArrayOutputStream.write(a.b(this.f15339c));
            byteArrayOutputStream.write(a.a(this.f15340d));
            e.a("PushLogAC2712", "PollingDataReqMessage encode : baos " + a.a(byteArrayOutputStream.toByteArray()));
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            e.c("PushLogAC2712", e.toString(), e);
            return new byte[0];
        }
    }

    public String toString() {
        return new StringBuffer(getClass().getSimpleName()).append(" mLength:").append(this.f15338b).append(" cmdId:").append(m19853g()).append(" mRequestId:").append(this.f15339c).append(" mPollingId:").append(this.f15340d).toString();
    }
}
