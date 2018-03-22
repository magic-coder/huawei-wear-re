package com.huawei.android.pushagent.p017a.p320a.p321a;

import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.C4036b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class C4037b implements C4036b {
    protected byte f15337a = (byte) -1;

    public C4037b(byte b) {
        m19852a(b);
    }

    public static void m19848a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = 0;
        while (i < bArr.length) {
            int read = inputStream.read(bArr, i, bArr.length - i);
            if (-1 == read) {
                throw new IOException("read -1 reached");
            }
            i += read;
        }
    }

    public static C4037b m19849b(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[2];
        C4037b.m19848a(inputStream, bArr);
        short c = (short) a.c(bArr);
        byte[] bArr2 = new byte[c];
        C4037b.m19848a(inputStream, bArr2);
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr2);
        byte read = (byte) byteArrayInputStream.read();
        e.a("PushLogAC2712", "cmdId: 0X" + Integer.toHexString(read) + " len:" + c);
        return C4035a.m19845a(Byte.valueOf(read), byteArrayInputStream);
    }

    public byte mo4353a() {
        return this.f15337a;
    }

    public abstract C4037b mo4354a(InputStream inputStream) throws IOException;

    public void m19852a(byte b) {
        this.f15337a = b;
    }

    public String m19853g() {
        return a.a(new byte[]{this.f15337a});
    }
}
