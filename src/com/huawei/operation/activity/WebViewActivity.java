package com.huawei.operation.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.webkit.ValueCallback;
import android.widget.ProgressBar;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.operation.d;
import com.huawei.operation.e;
import com.huawei.operation.view.CustomWebView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;

public class WebViewActivity extends BaseActivity {
    static int f19460d = 0;
    C5711c f19461a;
    public ValueCallback<Uri> f19462b;
    public ValueCallback<Uri[]> f19463c;
    private ProgressBar f19464e;
    private CustomWebView f19465f;
    private C5712d f19466g;
    private String f19467h;
    private Context f19468i;
    private CustomTitleBar f19469j;
    private Handler f19470k = new C5710b(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.webview_page);
        this.f19468i = BaseApplication.b();
        m26336a();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10086) {
            if (this.f19462b != null) {
                Object data = (intent == null || i2 != -1) ? null : intent.getData();
                this.f19462b.onReceiveValue(data);
                this.f19462b = null;
            }
        } else if (i == 10087 && this.f19463c != null) {
            Uri data2 = (intent == null || i2 != -1) ? null : intent.getData();
            if (data2 != null) {
                this.f19463c.onReceiveValue(new Uri[]{data2});
            } else {
                this.f19463c.onReceiveValue(new Uri[0]);
            }
            this.f19463c = null;
        }
    }

    private void m26336a() {
        this.f19465f = (CustomWebView) findViewById(d.mCustomWebView);
        this.f19469j = (CustomTitleBar) findViewById(d.operation_webview_titlebar);
        this.f19464e = this.f19465f.getProgressBar();
        if (this.f19469j != null) {
            this.f19465f.setTextView(this.f19469j.getmViewTitle());
        }
        this.f19466g = new C5712d();
        this.f19465f.setWebViewClientBase(this.f19466g);
        this.f19461a = new C5711c();
        this.f19465f.setWebViewChromeBase(this.f19461a);
        Intent intent = getIntent();
        if (intent == null) {
            C2538c.c("[Operation Version 1.2]WebViewActivity", new Object[]{"intent is null "});
            return;
        }
        if (intent.getExtras() != null) {
            String stringExtra = intent.getStringExtra("url");
            if (stringExtra == null) {
                stringExtra = "about:blank";
            }
            this.f19467h = stringExtra;
            this.f19465f.m26358b(stringExtra);
        }
        if (this.f19469j != null) {
            this.f19469j.setLeftButtonOnClickListener(new C5709a(this));
        }
    }

    private void m26337a(ValueCallback<Uri[]> valueCallback) {
        this.f19463c = valueCallback;
        Parcelable intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", intent);
        intent2.putExtra("android.intent.extra.TITLE", "Image Chooser");
        startActivityForResult(intent2, 10087);
    }

    protected void onDestroy() {
        com.huawei.hwcommonmodel.d.d.n(this.f19468i);
        super.onDestroy();
    }
}
