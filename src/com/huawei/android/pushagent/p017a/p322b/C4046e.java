package com.huawei.android.pushagent.p017a.p322b;

import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import java.io.IOException;
import java.io.InputStream;

public class C4046e extends C4041b {
    public C4046e() {
        super(C4046e.m19882c());
    }

    public static byte m19882c() {
        return (byte) -48;
    }

    public C4041b mo4356a(InputStream inputStream) throws IOException {
        C4041b.m19864a(inputStream, new byte[1]);
        return this;
    }

    public byte[] mo4355b() {
        return new byte[]{mo4353a()};
    }

    public String toString() {
        return new StringBuffer(getClass().getSimpleName()).append(" cmdId:").append(m19868j()).toString();
    }
}
