package com.huawei.android.pushagent.p017a.p322b;

import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class C4054m extends C4041b {
    private byte[] f15375b;
    private byte f15376c;

    public C4054m() {
        super(C4054m.m19918c());
    }

    public C4054m(byte[] bArr, byte b) {
        this();
        this.f15375b = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.f15375b, 0, bArr.length);
        this.f15376c = b;
    }

    public static byte m19918c() {
        return TagName.ScriptDown;
    }

    public C4041b mo4356a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8];
        C4041b.m19864a(inputStream, bArr);
        this.f15375b = bArr;
        bArr = new byte[1];
        C4041b.m19864a(inputStream, bArr);
        this.f15376c = bArr[0];
        return this;
    }

    public byte[] mo4355b() {
        byte[] bArr = new byte[0];
        if (this.f15375b == null) {
            e.d("PushLogAC2712", "encode error, mMsgId is null ");
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(mo4353a());
                byteArrayOutputStream.write(this.f15375b);
                byteArrayOutputStream.write(this.f15376c);
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.d("PushLogAC2712", "encode error " + e.toString());
            }
        }
        return bArr;
    }

    public String toString() {
        return new StringBuffer(getClass().getSimpleName()).append(",cmdId:").append(m19868j()).append(",msgId:").append(a.a(this.f15375b)).append(",flag:").append(this.f15376c).toString();
    }
}
