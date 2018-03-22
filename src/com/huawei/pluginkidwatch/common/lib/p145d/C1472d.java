package com.huawei.pluginkidwatch.common.lib.p145d;

import com.d.a.a.g;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import org.apache.http.Header;

/* compiled from: ExHttpClient */
class C1472d extends g {
    final /* synthetic */ C1455g f3428a;
    final /* synthetic */ C1469a f3429b;

    C1472d(C1469a c1469a, C1455g c1455g) {
        this.f3429b = c1469a;
        this.f3428a = c1455g;
    }

    public void m6801a(int i, Header[] headerArr, byte[] bArr) {
        if (bArr == null) {
            try {
                bArr = "".getBytes(GameManager.DEFAULT_CHARSET);
            } catch (Exception e) {
                C2538c.m12680e("ExHttpClient", e.getMessage());
                return;
            }
        }
        this.f3428a.mo2514a(i, bArr);
    }

    public void m6802a(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        if (bArr == null) {
            try {
                bArr = "".getBytes(GameManager.DEFAULT_CHARSET);
            } catch (Exception e) {
                C2538c.m12680e("ExHttpClient", e.getMessage());
                return;
            }
        }
        C2538c.m12680e("ExHttpClient", th.toString(), "statusCode: ", String.valueOf(i));
        this.f3428a.mo2515b(i, bArr);
    }
}
