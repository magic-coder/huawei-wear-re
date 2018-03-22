package com.huawei.android.pushagent.p017a.p322b;

import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import java.io.IOException;
import java.io.InputStream;

public class C4052k extends C4041b {
    public C4052k() {
        super(C4052k.m19906c());
    }

    public static byte m19906c() {
        return (byte) -37;
    }

    public C4041b mo4356a(InputStream inputStream) throws IOException {
        return this;
    }

    public byte[] mo4355b() {
        return new byte[]{this.a};
    }

    public String toString() {
        return new StringBuffer("HeartBeatRspMessage[").append("cmdId:").append(a.a(this.a)).append("]").toString();
    }
}
