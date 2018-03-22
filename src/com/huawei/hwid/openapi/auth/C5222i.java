package com.huawei.hwid.openapi.auth;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Handler;
import android.webkit.WebView;
import com.huawei.hwid.openapi.out.OutReturn;
import com.huawei.hwid.openapi.out.ResReqHandler;
import com.huawei.hwid.openapi.p440a.C5212a;
import com.huawei.hwid.openapi.p445e.C5248c;
import java.util.Timer;

class C5222i {
    Timer f18837a = null;
    Timer f18838b = null;
    WebView f18839c = null;
    ResReqHandler f18840d = null;
    ProgressDialog f18841e = null;
    Handler f18842f = null;
    C5212a f18843g = null;

    public C5222i(C5212a c5212a, ProgressDialog progressDialog, Handler handler) {
        this.f18840d = c5212a.f18806b;
        this.f18841e = progressDialog;
        this.f18842f = handler;
        this.f18843g = c5212a;
    }

    private void m25365a(Dialog dialog) {
        try {
            m25367a();
            this.f18840d.finish(OutReturn.creatReturn(102, "vist web time out!!"));
            dialog.dismiss();
        } catch (Throwable th) {
            C5248c.m25448b("WebViewMonitor", th.toString(), th);
        }
    }

    public void m25367a() {
        if (this.f18837a != null) {
            this.f18837a.cancel();
            this.f18837a.purge();
            this.f18837a = null;
        }
        if (this.f18838b != null) {
            this.f18838b.cancel();
            this.f18838b.purge();
            this.f18838b = null;
        }
    }

    public void m25368a(WebView webView) {
        m25367a();
        this.f18838b = new Timer();
        this.f18838b.schedule(new C5225l(this, webView), 100, 1);
    }

    public void m25369a(WebView webView, Dialog dialog) {
        try {
            m25367a();
            if (!(this.f18841e == null || this.f18841e.isShowing() || this.f18843g.f18814j != null)) {
                this.f18841e.show();
            }
            this.f18837a = new Timer();
            this.f18839c = webView;
            this.f18837a.schedule(new C5223j(this, dialog), StatisticConfig.MIN_UPLOAD_INTERVAL, 1);
        } catch (Throwable e) {
            C5248c.m25448b("WebViewMonitor", e.toString(), e);
            m25367a();
        }
    }
}
