package com.huawei.android.pushagent.p017a.p322b;

import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.p322b.p323a.C4041b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

public class C4043b extends C4041b {
    private JSONObject f15351b = new JSONObject();

    public C4043b(byte b) {
        super(b);
    }

    public C4041b mo4356a(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[2];
        C4041b.m19864a(inputStream, bArr);
        int c = a.c(bArr);
        e.a("PushLogAC2712", "push message len=" + c);
        bArr = new byte[c];
        C4041b.m19864a(inputStream, bArr);
        String str = new String(bArr, GameManager.DEFAULT_CHARSET);
        e.a("PushLogAC2712", "push message data :" + str);
        this.f15351b = new JSONObject(str);
        return this;
    }

    public byte[] mo4355b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(mo4353a());
            if (this.f15351b.length() == 0) {
                byteArrayOutputStream.write(a.b(0));
            } else {
                byte[] bytes = this.f15351b.toString().getBytes(GameManager.DEFAULT_CHARSET);
                byteArrayOutputStream.write(a.b(bytes.length));
                byteArrayOutputStream.write(bytes);
                e.a("PushLogAC2712", " begin to send:" + this.f15351b);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.a("PushLogAC2712", "encode error," + e.toString());
            return new byte[0];
        }
    }

    public JSONObject m19874c() {
        return this.f15351b;
    }

    public String toString() {
        return this.f15351b.toString();
    }
}
