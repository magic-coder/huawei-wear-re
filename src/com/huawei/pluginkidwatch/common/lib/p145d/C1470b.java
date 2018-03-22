package com.huawei.pluginkidwatch.common.lib.p145d;

import com.d.a.a.g;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;

/* compiled from: ExHttpClient */
class C1470b extends g {
    final /* synthetic */ C1455g f3424a;
    final /* synthetic */ C1469a f3425b;

    C1470b(C1469a c1469a, C1455g c1455g) {
        this.f3425b = c1469a;
        this.f3424a = c1455g;
    }

    public void m6797a(int i, Header[] headerArr, byte[] bArr) {
        if (bArr == null) {
            try {
                bArr = "".getBytes(GameManager.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e) {
                C2538c.m12680e("ExHttpClient", e.getMessage());
                return;
            }
        }
        C2538c.m12680e("ExHttpClient", "===HttpClient onSuccess ===  ");
        this.f3424a.mo2514a(i, bArr);
    }

    public void m6798a(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        if (bArr == null) {
            try {
                bArr = "".getBytes(GameManager.DEFAULT_CHARSET);
            } catch (Exception e) {
                C2538c.m12680e("ExHttpClient", e.getMessage());
                return;
            }
        }
        C2538c.m12680e("ExHttpClient", th.toString(), "statusCode: ", String.valueOf(i));
        this.f3424a.mo2515b(i, bArr);
    }
}
