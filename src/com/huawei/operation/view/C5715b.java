package com.huawei.operation.view;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.huawei.p190v.C2538c;

/* compiled from: CustomWebView */
class C5715b implements OnKeyListener {
    final /* synthetic */ CustomWebView f19486a;

    C5715b(CustomWebView customWebView) {
        this.f19486a = customWebView;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && i == 4) {
            if (this.f19486a.f19477a.canGoBack()) {
                C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"WebView go back"});
                String url = this.f19486a.f19477a.getUrl();
                C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"currentUrl:", url});
                this.f19486a.f19477a.goBack();
                C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"mWebViewTitles.size():" + this.f19486a.f19482f.size() + " mWebViewTitles:" + this.f19486a.f19482f.toString()});
                if (this.f19486a.f19482f.size() > 1) {
                    this.f19486a.f19482f.remove(this.f19486a.f19482f.size() - 1);
                    url = (String) this.f19486a.f19482f.get(this.f19486a.f19482f.size() - 1);
                    if (this.f19486a.f19481e != null) {
                        this.f19486a.f19481e.setText(url);
                    }
                    return true;
                }
                C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"WebViewActivity go back"});
                return false;
            }
            Activity activity = (Activity) this.f19486a.f19480d;
            ((Activity) this.f19486a.f19480d).setResult(-1);
        }
        return false;
    }
}
