package com.huawei.android.pushagent.p017a.p322b;

import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class C4056o extends C4041b {
    private byte f15379b = (byte) 1;
    private String f15380c = null;
    private String f15381d = null;

    public C4056o() {
        super(C4056o.m19924c());
    }

    public static byte m19924c() {
        return (byte) -35;
    }

    public C4041b mo4356a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[1];
        C4041b.m19864a(inputStream, bArr);
        this.f15379b = bArr[0];
        if (bArr[0] != (byte) 0) {
            this.f15381d = null;
            this.f15380c = null;
        }
        bArr = new byte[32];
        C4041b.m19864a(inputStream, bArr);
        this.f15380c = new String(bArr, GameManager.DEFAULT_CHARSET);
        bArr = new byte[2];
        C4041b.m19864a(inputStream, bArr);
        bArr = new byte[a.c(bArr)];
        C4041b.m19864a(inputStream, bArr);
        this.f15381d = new String(bArr, GameManager.DEFAULT_CHARSET);
        return this;
    }

    public byte[] mo4355b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(mo4353a());
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(this.f15380c.getBytes(GameManager.DEFAULT_CHARSET));
            byteArrayOutputStream.write(a.b(this.f15381d.length()));
            byteArrayOutputStream.write(this.f15381d.getBytes(GameManager.DEFAULT_CHARSET));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.d("PushLogAC2712", "encode error,e " + e.toString());
            return new byte[0];
        }
    }

    public String m19927d() {
        return this.f15380c;
    }

    public String m19928e() {
        return this.f15381d;
    }

    public byte m19929f() {
        return this.f15379b;
    }

    public String toString() {
        return new StringBuffer().append("RegisterTokenRspMessage[").append("result:").append(a.a(this.f15379b)).append(",token:").append(this.f15380c).append(",packageName:").append(this.f15381d).append("]").toString();
    }
}
