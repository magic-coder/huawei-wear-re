package com.huawei.android.pushagent.p017a.p322b;

import android.text.TextUtils;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class C4055n extends C4041b {
    private String f15377b = null;
    private String f15378c = null;

    public C4055n() {
        super(C4055n.m19921c());
    }

    public C4055n(String str, String str2) {
        super(C4055n.m19921c());
        this.f15377b = str;
        this.f15378c = str2;
    }

    public static byte m19921c() {
        return (byte) -36;
    }

    public C4041b mo4356a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[16];
        C4041b.m19864a(inputStream, bArr);
        this.f15377b = new String(bArr, GameManager.DEFAULT_CHARSET);
        bArr = new byte[2];
        C4041b.m19864a(inputStream, bArr);
        bArr = new byte[a.c(bArr)];
        C4041b.m19864a(inputStream, bArr);
        this.f15378c = new String(bArr, GameManager.DEFAULT_CHARSET);
        return this;
    }

    public byte[] mo4355b() {
        byte[] bArr = new byte[0];
        try {
            if (TextUtils.isEmpty(this.f15377b)) {
                e.d("PushLogAC2712", "encode error mDeviceId = " + this.f15377b);
            } else if (TextUtils.isEmpty(this.f15378c)) {
                e.d("PushLogAC2712", "encode error mPackageName = " + this.f15378c);
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(mo4353a());
                byteArrayOutputStream.write(this.f15377b.getBytes(GameManager.DEFAULT_CHARSET));
                byteArrayOutputStream.write(a.b(this.f15378c.length()));
                byteArrayOutputStream.write(this.f15378c.getBytes(GameManager.DEFAULT_CHARSET));
                bArr = byteArrayOutputStream.toByteArray();
            }
        } catch (IOException e) {
            e.d("PushLogAC2712", "encode error " + e.toString());
        }
        return bArr;
    }

    public String toString() {
        return new StringBuffer().append("RegisterTokenReqMessage[").append("deviceId:").append(this.f15377b).append(",packageName:").append(this.f15378c).append("]").toString();
    }
}
