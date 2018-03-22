package com.huawei.android.pushagent.p017a.p322b;

import android.text.TextUtils;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class C4049h extends C4041b {
    private String f15358b = null;
    private byte f15359c = (byte) -1;
    private int f15360d;
    private long f15361e;
    private long f15362f;
    private long f15363g;
    private int f15364h;
    private C4048g[] f15365i;

    public C4049h() {
        super(C4049h.m19894c());
    }

    public C4049h(String str, byte b, int i, long j, long j2, long j3, int i2, C4048g[] c4048gArr) {
        super(C4049h.m19894c());
        this.f15358b = str;
        this.f15359c = b;
        this.f15360d = i;
        this.f15361e = j;
        this.f15362f = j2;
        this.f15363g = j3;
        this.f15364h = i2;
        if (c4048gArr != null && c4048gArr.length > 0) {
            this.f15365i = new C4048g[c4048gArr.length];
            System.arraycopy(c4048gArr, 0, this.f15365i, 0, c4048gArr.length);
        }
    }

    public static byte m19894c() {
        return (byte) -34;
    }

    public C4041b mo4356a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[16];
        C4041b.m19864a(inputStream, bArr);
        this.f15358b = new String(bArr, GameManager.DEFAULT_CHARSET);
        bArr = new byte[1];
        C4041b.m19864a(inputStream, bArr);
        this.f15359c = bArr[0];
        bArr = new byte[2];
        C4041b.m19864a(inputStream, bArr);
        this.f15360d = a.c(bArr);
        bArr = new byte[8];
        C4041b.m19864a(inputStream, bArr);
        this.f15361e = a.d(bArr);
        bArr = new byte[8];
        C4041b.m19864a(inputStream, bArr);
        this.f15362f = a.d(bArr);
        bArr = new byte[8];
        C4041b.m19864a(inputStream, bArr);
        this.f15363g = a.d(bArr);
        bArr = new byte[1];
        C4041b.m19864a(inputStream, bArr);
        this.f15364h = a.c(bArr);
        int i = this.f15364h & 127;
        if (i > 0) {
            this.f15365i = new C4048g[i];
            for (C4048g c4048g : this.f15365i) {
                byte[] bArr2 = new byte[8];
                C4041b.m19864a(inputStream, bArr2);
                c4048g.m19890a(a.d(bArr2));
                bArr2 = new byte[1];
                C4041b.m19864a(inputStream, bArr2);
                c4048g.m19889a(bArr2[0]);
                bArr2 = new byte[1];
                C4041b.m19864a(inputStream, bArr2);
                c4048g.m19892b(bArr2[0]);
            }
        }
        return this;
    }

    public byte[] mo4355b() {
        if (TextUtils.isEmpty(this.f15358b)) {
            e.d("PushLogAC2712", "encode error, reason mDeviceId = " + this.f15358b);
            return new byte[0];
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(mo4353a());
            byteArrayOutputStream.write(this.f15358b.getBytes(GameManager.DEFAULT_CHARSET));
            byteArrayOutputStream.write(this.f15359c);
            byteArrayOutputStream.write(a.b(this.f15360d));
            byteArrayOutputStream.write(a.a(this.f15361e));
            byteArrayOutputStream.write(a.a(this.f15362f));
            byteArrayOutputStream.write(a.a(this.f15363g));
            byteArrayOutputStream.write((byte) this.f15364h);
            if (this.f15365i != null && this.f15365i.length > 0) {
                for (C4048g c4048g : this.f15365i) {
                    byteArrayOutputStream.write(a.a(c4048g.m19888a()));
                    byteArrayOutputStream.write(c4048g.m19891b());
                    byteArrayOutputStream.write(c4048g.m19893c());
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.d("PushLogAC2712", "encode error " + e.toString());
            return new byte[0];
        }
    }

    public String toString() {
        StringBuffer append = new StringBuffer(getClass().getSimpleName()).append(" cmdId:").append(m19868j()).append(" mDeviceId:").append(this.f15358b).append(" mNetworkType:").append(this.f15359c).append(" mAgentVersion:").append(this.f15360d).append(" mLastDisconnectTime:").append(a.a(this.f15361e, "yyyy-MM-dd HH:mm:ss SSS")).append(" mCurrentConnectTime:").append(a.a(this.f15362f, "yyyy-MM-dd HH:mm:ss SSS")).append(" mCurrentTime:").append(a.a(this.f15363g, "yyyy-MM-dd HH:mm:ss SSS")).append(" mNetEventAccount:").append(this.f15364h);
        if (this.f15365i != null && this.f15365i.length > 0) {
            for (Object append2 : this.f15365i) {
                append.append(append2);
            }
        }
        return append.toString();
    }
}
