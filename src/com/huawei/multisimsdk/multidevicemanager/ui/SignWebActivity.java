package com.huawei.multisimsdk.multidevicemanager.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.huawei.multisimsdk.multidevicemanager.b;
import com.huawei.multisimsdk.multidevicemanager.d;
import com.huawei.multisimsdk.multidevicemanager.e;
import com.huawei.multisimsdk.multidevicemanager.p102a.C1131b;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.multidevicemanager.p106d.C1172a;

public class SignWebActivity extends BaseActivity implements C1131b {
    private static final String TAG = "SignWebActivity";
    private static int WEB_VIEW_PROGRESS = 80;
    private boolean isCancel = false;
    private boolean isSignatureCompleted = false;
    private C1172a mPresenter;
    private ProgressBar mProgressBar;
    private WebView mSignWebView;

    protected void onCreate(Bundle bundle) {
        C1183h.m5282b(TAG, "onCreate start");
        super.onCreate(bundle);
        setContentView(e.sign_web);
        this.mPresenter = new C1172a(this, this);
        this.mSignWebView = (WebView) findViewById(d.sign_webView);
        this.mProgressBar = (ProgressBar) findViewById(d.progress_bar);
        initWebView();
        this.mPresenter.m5240a();
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void initWebView() {
        this.mSignWebView.getSettings().setSupportZoom(true);
        this.mSignWebView.getSettings().setUseWideViewPort(true);
        this.mSignWebView.getSettings().setJavaScriptEnabled(true);
        this.mSignWebView.addJavascriptInterface(this, "MultiSIMWebViewController");
        this.mSignWebView.setWebViewClient(new C1186a(this));
        this.mSignWebView.setWebChromeClient(new C1187b(this));
    }

    public void loadWebUrl(String str) {
        this.mSignWebView.loadUrl(str);
    }

    @JavascriptInterface
    public void cancelButtonPressed() {
        C1183h.m5278a(TAG, "user click cancel in webview");
        if (!this.isCancel) {
            this.mPresenter.m5241a(8888);
            this.isCancel = true;
            finish();
            overridePendingTransition(b.push_left_in, b.push_right_out);
        }
    }

    @JavascriptInterface
    public void multiSIMServiceSignatureCompleted() {
        C1183h.m5278a(TAG, "user click ok in webview");
        if (!this.isSignatureCompleted) {
            this.mPresenter.m5241a(8889);
            this.mPresenter.m5241a(114);
            this.isSignatureCompleted = true;
            finish();
            overridePendingTransition(b.push_right_in, b.push_left_out);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C1183h.m5278a(TAG, "destroyWebView");
        destroyWebView();
    }

    private void destroyWebView() {
        if (this.mSignWebView != null) {
            this.mSignWebView.clearHistory();
            this.mSignWebView.clearCache(true);
            this.mSignWebView.removeAllViews();
            this.mSignWebView.destroy();
            this.mSignWebView = null;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.mPresenter.m5241a(8888);
        finish();
        overridePendingTransition(b.push_left_in, b.push_right_out);
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.mSignWebView.canGoBack()) {
            this.mSignWebView.goBack();
        } else {
            C1183h.m5278a(TAG, "user click back");
            this.mPresenter.m5241a(8888);
            finish();
            overridePendingTransition(b.push_left_in, b.push_right_out);
        }
        return true;
    }

    private void showProgressBar(boolean z) {
        if (z) {
            this.mSignWebView.setVisibility(8);
            this.mProgressBar.setVisibility(0);
            return;
        }
        this.mSignWebView.setVisibility(0);
        this.mProgressBar.setVisibility(8);
    }
}
