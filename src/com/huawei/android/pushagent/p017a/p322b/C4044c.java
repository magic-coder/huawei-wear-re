package com.huawei.android.pushagent.p017a.p322b;

import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.InputStream;

public class C4044c extends C4041b {
    private String f15352b = null;
    private byte f15353c = (byte) -1;

    public C4044c() {
        super(C4044c.m19875c());
    }

    public static byte m19875c() {
        return (byte) -46;
    }

    public C4041b mo4356a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[16];
        C4041b.m19864a(inputStream, bArr);
        this.f15352b = new String(bArr, GameManager.DEFAULT_CHARSET);
        bArr = new byte[1];
        C4041b.m19864a(inputStream, bArr);
        this.f15353c = bArr[0];
        return this;
    }

    public byte[] mo4355b() {
        byte[] bArr = new byte[0];
        if (TextUtils.isEmpty(this.f15352b)) {
            e.d("PushLogAC2712", "encode error, reason mDeviceId = " + this.f15352b);
        } else {
            try {
                Object bytes = this.f15352b.getBytes(GameManager.DEFAULT_CHARSET);
                bArr = new byte[((bytes.length + 1) + 1)];
                bArr[0] = mo4353a();
                System.arraycopy(bytes, 0, bArr, 1, bytes.length);
                bArr[bArr.length - 1] = this.f15353c;
            } catch (Throwable e) {
                e.a("PushLogAC2712", e.toString(), e);
            }
        }
        return bArr;
    }

    public String toString() {
        return new StringBuffer(getClass().getSimpleName()).append(" cmdId:").append(m19868j()).append(" mDeviceId:").append(this.f15352b).append(" mNetworkType:").append(this.f15353c).toString();
    }
}
