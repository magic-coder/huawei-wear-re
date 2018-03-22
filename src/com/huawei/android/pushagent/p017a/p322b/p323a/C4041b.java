package com.huawei.android.pushagent.p017a.p322b.p323a;

import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.p017a.C4036b;
import java.io.IOException;
import java.io.InputStream;

public abstract class C4041b implements C4036b {
    protected byte f15347a = (byte) -1;

    public C4041b(byte b) {
        m19867b(b);
    }

    public static void m19864a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = 0;
        while (i < bArr.length) {
            int read = inputStream.read(bArr, i, bArr.length - i);
            if (-1 == read) {
                throw new IOException("read -1 reached");
            }
            i += read;
        }
    }

    public byte mo4353a() {
        return this.f15347a;
    }

    public abstract C4041b mo4356a(InputStream inputStream) throws Exception;

    public void m19867b(byte b) {
        this.f15347a = b;
    }

    public String m19868j() {
        return a.a(new byte[]{this.f15347a});
    }
}
