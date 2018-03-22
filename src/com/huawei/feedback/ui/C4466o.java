package com.huawei.feedback.ui;

import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: FeedbackEditActivity */
class C4466o extends WebChromeClient {
    final /* synthetic */ FeedbackEditActivity f16598a;

    C4466o(FeedbackEditActivity feedbackEditActivity) {
        this.f16598a = feedbackEditActivity;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (this.f16598a.f16516s != null) {
            this.f16598a.f16516s.setProgress(i);
            if (100 == i) {
                this.f16598a.f16516s.setVisibility(8);
            } else {
                this.f16598a.f16516s.setVisibility(0);
            }
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        if (!TextUtils.isEmpty(str) && this.f16598a.ag != null) {
            this.f16598a.ag.setTitle(str);
        }
    }
}
