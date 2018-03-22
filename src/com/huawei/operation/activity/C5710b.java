package com.huawei.operation.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: WebViewActivity */
class C5710b extends Handler {
    final /* synthetic */ WebViewActivity f19472a;

    C5710b(WebViewActivity webViewActivity) {
        this.f19472a = webViewActivity;
    }

    public void handleMessage(Message message) {
        if (message.what == 1 && this.f19472a.f19465f != null) {
            C2538c.c("[Operation Version 1.2]WebViewActivity", new Object[]{"reset webView to " + this.f19472a.f19467h});
            this.f19472a.f19465f.m26358b(this.f19472a.f19467h);
        }
        super.handleMessage(message);
    }
}
