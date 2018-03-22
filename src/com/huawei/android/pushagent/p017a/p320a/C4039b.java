package com.huawei.android.pushagent.p017a.p320a;

import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p320a.p321a.C4037b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class C4039b extends C4037b {
    private short f15341b;
    private short f15342c;
    private byte f15343d;
    private byte f15344e;
    private short f15345f;

    public C4039b() {
        super(C4039b.m19857c());
    }

    public static byte m19857c() {
        return (byte) 2;
    }

    public C4037b mo4354a(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[2];
            C4037b.m19848a(inputStream, bArr);
            this.f15342c = (short) a.c(bArr);
            bArr = new byte[1];
            C4037b.m19848a(inputStream, bArr);
            this.f15343d = bArr[0];
            bArr = new byte[1];
            C4037b.m19848a(inputStream, bArr);
            this.f15344e = bArr[0];
            bArr = new byte[2];
            C4037b.m19848a(inputStream, bArr);
            this.f15345f = (short) a.c(bArr);
        } catch (Throwable e) {
            e.c("PushLogAC2712", e.toString(), e);
        }
        return this;
    }

    public byte[] mo4355b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(a.b(this.f15341b));
            byteArrayOutputStream.write(mo4353a());
            byteArrayOutputStream.write(a.b(this.f15342c));
            byteArrayOutputStream.write(this.f15343d);
            byteArrayOutputStream.write(this.f15344e);
            byteArrayOutputStream.write(a.b(this.f15345f));
            e.a("PushLogAC2712", "PollingDataRspMessage encode : baos " + a.a(byteArrayOutputStream.toByteArray()));
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            e.c("PushLogAC2712", e.toString(), e);
            return new byte[0];
        }
    }

    public byte m19860d() {
        return this.f15343d;
    }

    public boolean m19861e() {
        return this.f15344e == (byte) 1;
    }

    public short m19862f() {
        return this.f15345f;
    }

    public String toString() {
        return new StringBuffer(getClass().getSimpleName()).append(",mLength:").append(this.f15341b).append(",cmdId:").append(m19853g()).append(",mRequestId:").append(this.f15342c).append(",mMode:").append(this.f15343d).append(",mHasMsg:").append(this.f15344e).append(",mPollingInterval:").append(this.f15345f).toString();
    }
}
