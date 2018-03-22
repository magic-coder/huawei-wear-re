package com.huawei.nfc.carrera.ui.webview;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;

public class NormalWebViewActivity extends WebViewActivity {
    public static final String BUNDLE_KEY_WEBVEIW_TITLE = "webview_title";
    public static final String BUNDLE_KEY_WEBVEIW_URL = "webview_url";
    private final String TAG = NormalWebViewActivity.class.getSimpleName();
    private String mUrl;
    private String title;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        if (initParams()) {
            loadWebView(this.mUrl);
        } else {
            finish();
        }
    }

    protected String getTitleStrResc() {
        return this.title;
    }

    protected void loadWebviewSuccess() {
        this.acceptButton.setVisibility(8);
    }

    protected void loadWebviewFailed() {
        this.acceptButton.setVisibility(8);
    }

    protected void loadingProgress() {
        this.acceptButton.setVisibility(8);
    }

    private boolean initParams() {
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            LogX.e(this.TAG, "bundle is null.");
            return false;
        }
        this.mUrl = extras.getString(BUNDLE_KEY_WEBVEIW_URL);
        this.title = extras.getString(BUNDLE_KEY_WEBVEIW_TITLE);
        if (!StringUtil.isEmpty(this.mUrl, true) && !StringUtil.isEmpty(this.title, true)) {
            return true;
        }
        LogX.e(this.TAG, "params is illegal.");
        return false;
    }
}
