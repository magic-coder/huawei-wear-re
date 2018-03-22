package com.alipay.sdk.app;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.p247d.C3180e;

final class C3154d implements Runnable {
    final /* synthetic */ SslErrorHandler f10537a;
    final /* synthetic */ C3153c f10538b;

    C3154d(C3153c c3153c, SslErrorHandler sslErrorHandler) {
        this.f10538b = c3153c;
        this.f10537a = sslErrorHandler;
    }

    public final void run() {
        C3180e.m14036a(this.f10538b.f10532b, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，可能存在风险，请选择是否继续？", "继续", new C3155e(this), "退出", new C3156f(this));
    }
}
