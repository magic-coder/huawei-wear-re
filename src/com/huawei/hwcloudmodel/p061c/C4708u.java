package com.huawei.hwcloudmodel.p061c;

import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;

/* compiled from: NSPResponse */
public class C4708u {
    private int f17157a = 200;
    private int f17158b = 0;
    private Map<String, String> f17159c;
    private byte[] f17160d;

    public byte[] m22530a() {
        return this.f17160d;
    }

    public void m22529a(byte[] bArr) {
        if (bArr != null) {
            this.f17160d = Arrays.copyOf(bArr, bArr.length);
        }
    }

    public int m22531b() {
        return this.f17157a;
    }

    public int m22532c() {
        return this.f17158b;
    }

    public String toString() {
        try {
            return "NSPResponse [status=" + this.f17157a + ", code=" + this.f17158b + ", headers=" + this.f17159c + ", content=" + Arrays.toString(this.f17160d) + " == " + new String(this.f17160d, GameManager.DEFAULT_CHARSET) + "]";
        } catch (UnsupportedEncodingException e) {
            C2538c.e("NSPResponse", new Object[]{"Exception e = " + e.getMessage()});
            return "";
        }
    }
}
