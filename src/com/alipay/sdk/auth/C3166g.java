package com.alipay.sdk.auth;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.p247d.C3180e;

final class C3166g implements Runnable {
    final /* synthetic */ SslErrorHandler f10567a;
    final /* synthetic */ C3161b f10568b;

    C3166g(C3161b c3161b, SslErrorHandler sslErrorHandler) {
        this.f10568b = c3161b;
        this.f10567a = sslErrorHandler;
    }

    public final void run() {
        C3180e.m14036a(this.f10568b.f10561a, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new C3167h(this), "退出", new C3168i(this));
    }
}
