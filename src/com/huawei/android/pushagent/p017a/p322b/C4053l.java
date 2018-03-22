package com.huawei.android.pushagent.p017a.p322b;

import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import cn.com.fmsh.tsm.business.constants.Constants;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class C4053l extends C4041b {
    private byte f15368b = (byte) -1;
    private byte[] f15369c;
    private byte[] f15370d;
    private int f15371e;
    private byte[] f15372f;
    private int f15373g;
    private byte[] f15374h;

    public C4053l() {
        super(C4053l.m19909c());
    }

    public static final byte m19909c() {
        return TagName.CommandSingle;
    }

    public C4041b mo4356a(InputStream inputStream) throws Exception {
        this.f15369c = new byte[8];
        C4041b.m19864a(inputStream, this.f15369c);
        this.f15370d = new byte[32];
        C4041b.m19864a(inputStream, this.f15370d);
        byte[] bArr = new byte[2];
        C4041b.m19864a(inputStream, bArr);
        int c = a.c(bArr);
        e.a("PushLogAC2712", "push message len=" + c);
        this.f15371e = c;
        this.f15372f = new byte[c];
        C4041b.m19864a(inputStream, this.f15372f);
        bArr = new byte[2];
        try {
            bArr[0] = (byte) inputStream.read();
            if (bArr[0] < (byte) 0) {
                e.b("PushLogAC2712", "read first Len:" + bArr[0] + ", not valid len, may be next cmdId in Old PushDataReqMessage");
                this.f15368b = bArr[0];
            } else {
                bArr[1] = (byte) inputStream.read();
                c = bArr[1] + bArr[0];
                e.b("PushLogAC2712", "mPackageNameLen=" + c);
                if (c <= 0) {
                    e.b("PushLogAC2712", "the package length:" + c + " is Unavailable ");
                } else {
                    this.f15373g = c;
                    this.f15374h = new byte[c];
                    C4041b.m19864a(inputStream, this.f15374h);
                }
            }
        } catch (Exception e) {
            e.b("PushLogAC2712", "read msg cause:" + e.toString() + " may be old PushDataReqMessage");
        }
        return this;
    }

    public byte[] mo4355b() {
        byte[] bArr = new byte[0];
        try {
            if (this.f15369c == null) {
                e.d("PushLogAC2712", "encode error, mMsgId = null");
                return bArr;
            } else if (this.f15370d == null) {
                e.d("PushLogAC2712", "encode error, reason mToken = null");
                return bArr;
            } else if (this.f15372f == null) {
                e.d("PushLogAC2712", "encode error, reason mMsgData = null");
                return bArr;
            } else if (this.f15374h == null) {
                e.d("PushLogAC2712", "encode error, reason mPackage = null");
                return bArr;
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(mo4353a());
                byteArrayOutputStream.write(this.f15369c);
                byteArrayOutputStream.write(this.f15370d);
                byteArrayOutputStream.write(a.b(this.f15372f.length));
                byteArrayOutputStream.write(this.f15372f);
                byte[] bArr2 = new byte[2];
                if (this.f15373g > 127) {
                    bArr2[0] = Constants.TagName.ELECTRONIC_PUBLISH_START_TIME;
                    bArr2[1] = (byte) (this.f15373g - 127);
                } else {
                    bArr2[0] = (byte) 0;
                    bArr2[1] = (byte) this.f15373g;
                }
                byteArrayOutputStream.write(bArr2);
                byteArrayOutputStream.write(this.f15374h);
                return byteArrayOutputStream.toByteArray();
            }
        } catch (Exception e) {
            e.a("PushLogAC2712", "encode error," + e.toString());
            return bArr;
        }
    }

    public byte[] m19912d() {
        return this.f15369c;
    }

    public byte[] m19913e() {
        return this.f15370d;
    }

    public byte[] m19914f() {
        return this.f15372f;
    }

    public int m19915g() {
        return this.f15373g;
    }

    public byte[] m19916h() {
        return this.f15374h;
    }

    public byte m19917i() {
        return this.f15368b;
    }

    public String toString() {
        String str;
        String str2 = "null";
        if (this.f15374h != null) {
            try {
                str = new String(this.f15374h, GameManager.DEFAULT_CHARSET);
            } catch (Throwable e) {
                e.a("PushLogAC2712", e.toString(), e);
            }
            return new StringBuffer(getClass().getSimpleName()).append(" cmdId:").append(m19868j()).append(",msgId:").append(a.a(this.f15369c)).append(",deviceToken:").append(a.a(this.f15370d)).append(",msgData:").append(a.a(this.f15372f)).append(", mPackageLen:").append(this.f15373g).append(", pkgName:").append(str).toString();
        }
        str = str2;
        return new StringBuffer(getClass().getSimpleName()).append(" cmdId:").append(m19868j()).append(",msgId:").append(a.a(this.f15369c)).append(",deviceToken:").append(a.a(this.f15370d)).append(",msgData:").append(a.a(this.f15372f)).append(", mPackageLen:").append(this.f15373g).append(", pkgName:").append(str).toString();
    }
}
