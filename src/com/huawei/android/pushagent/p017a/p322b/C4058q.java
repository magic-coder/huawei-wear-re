package com.huawei.android.pushagent.p017a.p322b;

import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class C4058q extends C4041b {
    private String f15383b = null;
    private byte f15384c = (byte) 1;

    public C4058q() {
        super(C4058q.m19935c());
    }

    public static byte m19935c() {
        return (byte) -41;
    }

    public C4041b mo4356a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[32];
        C4041b.m19864a(inputStream, bArr);
        this.f15383b = new String(bArr, GameManager.DEFAULT_CHARSET);
        bArr = new byte[1];
        C4041b.m19864a(inputStream, bArr);
        this.f15384c = bArr[0];
        return this;
    }

    public byte[] mo4355b() {
        byte[] bArr = new byte[0];
        try {
            if (TextUtils.isEmpty(this.f15383b)) {
                e.d("PushLogAC2712", "encode error, mToken = " + this.f15383b);
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(mo4353a());
                byteArrayOutputStream.write(this.f15383b.getBytes(GameManager.DEFAULT_CHARSET));
                bArr = byteArrayOutputStream.toByteArray();
            }
        } catch (IOException e) {
            e.d("PushLogAC2712", "encode error " + e.toString());
        }
        return bArr;
    }

    public String m19938d() {
        return this.f15383b;
    }

    public String toString() {
        return "UnRegisterRspMessage[token:" + this.f15383b + " result:" + this.f15384c + "]";
    }
}
