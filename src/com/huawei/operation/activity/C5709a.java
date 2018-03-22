package com.huawei.operation.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: WebViewActivity */
class C5709a implements OnClickListener {
    final /* synthetic */ WebViewActivity f19471a;

    C5709a(WebViewActivity webViewActivity) {
        this.f19471a = webViewActivity;
    }

    public void onClick(View view) {
        this.f19471a.setResult(-1);
        this.f19471a.finish();
    }
}
