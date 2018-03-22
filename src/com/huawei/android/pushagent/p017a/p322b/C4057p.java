package com.huawei.android.pushagent.p017a.p322b;

import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class C4057p extends C4041b {
    private String f15382b = null;

    public C4057p() {
        super(C4057p.m19930c());
    }

    public C4057p(String str) {
        super(C4057p.m19930c());
        m19932a(str);
    }

    public static byte m19930c() {
        return (byte) -42;
    }

    public C4041b mo4356a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[32];
        C4041b.m19864a(inputStream, bArr);
        this.f15382b = new String(bArr, GameManager.DEFAULT_CHARSET);
        return this;
    }

    public void m19932a(String str) {
        this.f15382b = str;
    }

    public byte[] mo4355b() {
        byte[] bArr = new byte[0];
        try {
            if (TextUtils.isEmpty(this.f15382b)) {
                e.d("PushLogAC2712", "encode error reason mToken is empty");
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(mo4353a());
                byteArrayOutputStream.write(m19934d().getBytes(GameManager.DEFAULT_CHARSET));
                bArr = byteArrayOutputStream.toByteArray();
            }
        } catch (IOException e) {
            e.d("PushLogAC2712", "encode error " + e.toString());
        }
        return bArr;
    }

    public String m19934d() {
        return this.f15382b;
    }

    public String toString() {
        return "UnRegisterReqMessage[token:" + this.f15382b + "]";
    }
}
