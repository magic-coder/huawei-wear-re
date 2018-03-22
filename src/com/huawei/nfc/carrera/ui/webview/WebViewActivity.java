package com.huawei.nfc.carrera.ui.webview;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.huawei.aj.p315a.p318c.C4026a;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.R;
import com.huawei.wallet.utils.BaseLibUtil;
import com.p230a.p231b.p237c.C3132e;

public abstract class WebViewActivity extends NFCBaseActivity implements OnClickListener {
    private final int FULL_PROGRESS = 100;
    private final String TAG = WebViewActivity.class.getSimpleName();
    public final int WEBVIEW_LOAD_UNKNOW_ERROR_VALUE = -3;
    public final int WEBVIEW_STATE_DEFAULT_VALUE = 0;
    public final int WEBVIEW_STATE_NETWORK_ERROR_VALUE = -2;
    public final int WEBVIEW_STATE_NO_NETWORK_VALUE = -1;
    protected Button acceptButton;
    private LinearLayout contentlayout;
    private LinearLayout loadingLayout;
    private ProgressBar loadingProgressBar;
    private String mUrl;
    private RelativeLayout networkExceptionLayout;
    private LinearLayout networkFailLayout;
    private WebView webview;
    protected int webviewCodeResult = 0;

    class C56841 extends WebChromeClient {
        C56841() {
        }

        public void onProgressChanged(WebView webView, int i) {
            if (100 == i) {
                if (WebViewActivity.this.loadingProgressBar != null) {
                    WebViewActivity.this.loadingProgressBar.setVisibility(8);
                }
            } else if (WebViewActivity.this.loadingProgressBar != null) {
                WebViewActivity.this.loadingProgressBar.setProgress(i);
            }
            super.onProgressChanged(webView, i);
        }
    }

    class C56852 extends WebViewClient {
        C56852() {
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            LogX.i(WebViewActivity.this.TAG, "onPageStarted.");
            LogX.d("WebViewActivity : " + str);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            LogX.i(WebViewActivity.this.TAG, "onPageFinished.");
            if (WebViewActivity.this.webviewCodeResult == 0) {
                WebViewActivity.this.showContentLayout();
            } else if (-1 == WebViewActivity.this.webviewCodeResult) {
                WebViewActivity.this.showNoNetworkLayout();
                WebViewActivity.this.loadWebviewFailed();
            } else if (-2 == WebViewActivity.this.webviewCodeResult) {
                WebViewActivity.this.showNetworkExceptionLayout();
                WebViewActivity.this.loadWebviewFailed();
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            LogX.i(WebViewActivity.this.TAG, "onReceivedError.errorCode==" + i + "  description==" + str + "  failingUrl==" + str2);
            LogX.d("WebViewActivity : onReceivedError");
            if (C4026a.m19819a(WebViewActivity.this)) {
                WebViewActivity.this.webviewCodeResult = -2;
            } else {
                WebViewActivity.this.webviewCodeResult = -1;
            }
        }
    }

    protected abstract String getTitleStrResc();

    protected abstract void loadWebviewFailed();

    protected abstract void loadWebviewSuccess();

    protected abstract void loadingProgress();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setTitle(getTitleStrResc());
        setContentView(R.layout.nfc_carrera_activity_card_instruction);
        initView();
        showLoadingProgress();
    }

    protected void loadWebView(String str) {
        this.mUrl = str;
        this.webviewCodeResult = 0;
        if (!C4026a.m19819a(this)) {
            this.webviewCodeResult = -1;
            showNoNetworkLayout();
        } else if (C3132e.m13953a(str)) {
            this.webviewCodeResult = -3;
            loadWebviewFailed();
        } else {
            this.webview.loadUrl(str);
        }
    }

    private void initView() {
        this.networkFailLayout = (LinearLayout) findViewById(R.id.network_fail_layout);
        this.networkFailLayout.setOnClickListener(this);
        this.networkExceptionLayout = (RelativeLayout) findViewById(R.id.nfc_web_exception_layout);
        this.networkExceptionLayout.setVisibility(8);
        this.networkExceptionLayout.setOnClickListener(this);
        ((Button) findViewById(R.id.set_network_button)).setOnClickListener(this);
        this.contentlayout = (LinearLayout) findViewById(R.id.content_layout);
        this.loadingLayout = (LinearLayout) findViewById(R.id.progress_bar_layout);
        this.loadingProgressBar = (ProgressBar) this.loadingLayout.findViewById(R.id.progress_bar);
        this.webview = (WebView) findViewById(R.id.card_instruction_webview);
        this.acceptButton = (Button) findViewById(R.id.accept_button);
        initButton();
        initWebViewSettings();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebViewSettings() {
        this.webview.getSettings().setCacheMode(2);
        this.webview.getSettings().setAllowFileAccess(false);
        this.webview.getSettings().setJavaScriptEnabled(false);
        this.webview.setWebChromeClient(new C56841());
        this.webview.setWebViewClient(new C56852());
    }

    public void showLoadingProgress() {
        this.webview.setVisibility(8);
        this.networkFailLayout.setVisibility(8);
        this.networkExceptionLayout.setVisibility(8);
        this.loadingLayout.setVisibility(0);
        this.contentlayout.setVisibility(0);
        loadingProgress();
    }

    public void showNoNetworkLayout() {
        this.acceptButton.setVisibility(8);
        this.contentlayout.setVisibility(8);
        this.networkExceptionLayout.setVisibility(8);
        this.networkFailLayout.setVisibility(0);
    }

    public void showNetworkExceptionLayout() {
        this.acceptButton.setVisibility(8);
        this.contentlayout.setVisibility(8);
        this.networkFailLayout.setVisibility(8);
        this.networkExceptionLayout.setVisibility(0);
    }

    private void showContentLayout() {
        this.loadingLayout.setVisibility(8);
        this.networkFailLayout.setVisibility(8);
        this.networkExceptionLayout.setVisibility(8);
        this.contentlayout.setVisibility(0);
        this.webview.setVisibility(0);
        loadWebviewSuccess();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (R.id.set_network_button == id) {
            LogX.i(this.TAG, "onClick set_network_button.");
            BaseLibUtil.jumpToSettings(getApplicationContext());
        } else if (R.id.network_fail_layout == id || R.id.nfc_web_exception_layout == id) {
            LogX.i(this.TAG, "onClick nfc_no_network_text.");
            showLoadingProgress();
            loadWebView(this.mUrl);
        }
    }

    protected void initButton() {
    }
}
