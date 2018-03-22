package com.huawei.hwid.api.common;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.huawei.android.app.ActionBarEx;
import com.huawei.cloudservice.C4335a;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5180k;
import com.huawei.hwid.core.p435d.C5183n;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.vermanager.C5313c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public class CloudAccountCenterActivity extends Activity {
    private String f18283a;
    private WebView f18284b;
    private ProgressBar f18285c;
    private ActionBar f18286d;
    private String f18287e;
    private String f18288f = "";
    private String f18289g = "";
    private String f18290h = "";
    private String f18291i;
    private String f18292j;
    private int f18293k;
    private int f18294l;
    private int f18295m;
    private C4335a f18296n = new C50641(this);

    class C50641 implements C4335a {
        final /* synthetic */ CloudAccountCenterActivity f18280a;

        C50641(CloudAccountCenterActivity cloudAccountCenterActivity) {
            this.f18280a = cloudAccountCenterActivity;
        }

        public void mo4612a(WebView webView, String str, Bitmap bitmap) {
            if (this.f18280a.f18285c != null) {
                this.f18280a.f18285c.setProgress(0);
                this.f18280a.f18285c.setVisibility(0);
            }
            this.f18280a.f18287e = str;
        }

        public void mo4611a(WebView webView, String str) {
            if (this.f18280a.f18285c != null) {
                this.f18280a.f18285c.setProgress(this.f18280a.f18285c.getMax());
                this.f18280a.f18285c.setVisibility(8);
            }
            this.f18280a.f18287e = str;
            this.f18280a.m24386e();
        }
    }

    class C50652 implements OnClickListener {
        final /* synthetic */ CloudAccountCenterActivity f18281a;

        C50652(CloudAccountCenterActivity cloudAccountCenterActivity) {
            this.f18281a = cloudAccountCenterActivity;
        }

        public void onClick(View view) {
            this.f18281a.finish();
        }
    }

    class C5066a extends WebChromeClient {
        final /* synthetic */ CloudAccountCenterActivity f18282a;

        private C5066a(CloudAccountCenterActivity cloudAccountCenterActivity) {
            this.f18282a = cloudAccountCenterActivity;
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            this.f18282a.f18285c.setProgress(i);
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            this.f18282a.m24380a(str);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C5180k.m25031d(this, "cs_webview"));
        m24381b();
        m24379a();
        this.f18287e = this.f18283a;
        m24380a("");
        getWindow().addFlags(8192);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void m24379a() {
        this.f18286d = getActionBar();
        if (this.f18286d != null) {
            if (C5183n.f18660a && C5166b.m24956h("com.huawei.android.app.ActionBarEx")) {
                try {
                    ActionBarEx.setStartIcon(this.f18286d, true, null, new C50652(this));
                    this.f18286d.setDisplayHomeAsUpEnabled(false);
                } catch (Exception e) {
                    this.f18286d.setDisplayHomeAsUpEnabled(true);
                }
            } else {
                this.f18286d.setDisplayHomeAsUpEnabled(true);
            }
        }
        this.f18285c = (ProgressBar) findViewById(C5180k.m25032e(this, "wvProgressbar"));
        this.f18284b = (WebView) findViewById(C5180k.m25032e(this, "webView"));
        if (this.f18284b != null) {
            this.f18284b.setWebViewClient(C5313c.m25693a(this, this.f18296n));
            this.f18284b.setWebChromeClient(new C5066a());
            WebSettings settings = this.f18284b.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            this.f18284b.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f18284b.removeJavascriptInterface("accessibility");
            this.f18284b.removeJavascriptInterface("accessibilityTraversal");
            this.f18284b.loadUrl(this.f18283a);
        }
    }

    private void m24381b() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        try {
            this.f18288f = extras.getString(CloudAccount.KEY_APP_ID_WEB);
            this.f18289g = extras.getString(CloudAccount.KEY_USER_ACCOUNT_WEB);
            this.f18290h = extras.getString(CloudAccount.KEY_SERVICE_TOKEN_WEB);
            this.f18291i = extras.getString("deviceId");
            this.f18292j = extras.getString("deviceType");
            this.f18295m = extras.getInt("siteId");
            this.f18293k = extras.getInt(CloudAccount.KEY_REQCLIENTTYPE);
            this.f18294l = extras.getInt(CloudAccount.KEY_LOGIN_CHANNEL);
        } catch (Exception e) {
            C5165e.m24908c("CloudAccountCenterActivity", e.getMessage());
        }
        this.f18283a = m24377a((Context) this);
        if (TextUtils.isEmpty(this.f18283a)) {
            finish();
            return;
        }
        String toLowerCase = this.f18283a.toLowerCase(Locale.US);
        Object obj = (toLowerCase.startsWith("http://") || toLowerCase.startsWith("https://")) ? 1 : null;
        if (obj == null) {
            this.f18283a = "http://" + this.f18283a;
        }
    }

    private void m24380a(String str) {
        if (this.f18286d != null) {
            this.f18286d.setTitle(str);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (C5166b.m24954h()) {
            getMenuInflater().inflate(C5180k.m25033f(this, "cs_webview_menu_emui5"), menu);
        } else {
            getMenuInflater().inflate(C5180k.m25033f(this, "cs_webview_menu"), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
        } else if (itemId == C5180k.m25032e(this, "menu_wv_goback")) {
            if (!m24384c()) {
                finish();
            }
        } else if (itemId == C5180k.m25032e(this, "menu_wv_open_in_browser")) {
            m24385d();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onPause() {
        super.onPause();
        if (this.f18284b != null) {
            this.f18284b.onPause();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f18284b != null) {
            this.f18284b.setVisibility(8);
            this.f18284b.removeAllViews();
            this.f18284b.destroy();
        }
        this.f18284b = null;
    }

    public void onBackPressed() {
        if (!m24384c()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private boolean m24384c() {
        if (this.f18284b == null || !this.f18284b.canGoBack()) {
            return false;
        }
        String url = this.f18284b.getUrl();
        if (url == null || !(url.endsWith("index.html") || url.endsWith("wapLogin.html"))) {
            this.f18284b.goBack();
            return true;
        }
        C5165e.m24906b("CloudAccountCenterActivity", "can not go back");
        return false;
    }

    private void m24385d() {
        if (this.f18287e == null) {
            C5165e.m24910d("CloudAccountCenterActivity", "url is null, open failed.");
            return;
        }
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f18287e)));
        } catch (ActivityNotFoundException e) {
            C5165e.m24910d("CloudAccountCenterActivity", "no browser app installed, open failed.");
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.f18284b != null) {
            this.f18284b.onResume();
        }
    }

    private void m24386e() {
        C5165e.m24906b("CloudAccountCenterActivity", "autoLogin");
        this.f18284b.loadUrl("javascript:autoLogin(\"" + this.f18288f + "\",\"" + this.f18289g + "\",\"" + this.f18290h + "\")");
    }

    private String m24377a(Context context) {
        String b = C5313c.m25694a().mo4684b(this.f18295m);
        String c = C5313c.m25694a().mo4686c(this.f18295m);
        String encode = URLEncoder.encode(b);
        c = URLEncoder.encode(c);
        StringBuffer stringBuffer = new StringBuffer(C5313c.m25694a().mo4681a(this.f18295m));
        try {
            stringBuffer.append("?loginUrl=").append(encode).append("&deviceID=").append(this.f18291i).append("&deviceType=").append(this.f18292j).append("&reqClientType=").append(this.f18293k).append("&service=").append(c).append("&loginChannel=").append(this.f18294l).append("&lang=").append(URLEncoder.encode(C5166b.m24948f(context).toLowerCase(Locale.getDefault()), GameManager.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            stringBuffer = new StringBuffer();
        } catch (Exception e2) {
            stringBuffer = new StringBuffer();
        }
        return stringBuffer.toString();
    }
}
