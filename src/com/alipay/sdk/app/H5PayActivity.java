package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.p246c.C3172b;

public class H5PayActivity extends Activity {
    private WebView f10525a;
    private WebViewClient f10526b;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            String string = extras.getString("url");
            if (C3172b.m14021a(string)) {
                String string2 = extras.getString("cookie");
                super.requestWindowFeature(1);
                this.f10525a = C3172b.m14014a((Activity) this, string, string2);
                this.f10526b = new C3153c(this);
                this.f10525a.setWebViewClient(this.f10526b);
                return;
            }
            finish();
        } catch (Exception e) {
            finish();
        }
    }

    public void onBackPressed() {
        if (!this.f10525a.canGoBack()) {
            C3158h.f10542a = C3158h.m13994a();
            finish();
        } else if (((C3153c) this.f10526b).f10531a) {
            C3159i a = C3159i.m13996a(C3159i.NETWORK_ERROR.f10551h);
            C3158h.f10542a = C3158h.m13995a(a.f10551h, a.f10552i, "");
            finish();
        }
    }

    public void finish() {
        mo3668a();
        super.finish();
    }

    public void mo3668a() {
        Object obj = C3152b.f10530a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception e) {
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f10525a != null) {
            this.f10525a.removeAllViews();
            try {
                this.f10525a.destroy();
            } catch (Throwable th) {
            }
            this.f10525a = null;
        }
    }
}
