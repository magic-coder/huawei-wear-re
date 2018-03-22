package com.huawei.ui.commonui.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.C6034k;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.C6022u;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.ui.commonui.p514d.C6000d;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;

public class LegalInfoWebViewActivity extends BaseActivity {
    private LinearLayout f20814a = null;
    private LinearLayout f20815b = null;
    private Button f20816c = null;
    private Button f20817d = null;
    private WebView f20818e = null;
    private WebSettings f20819f = null;
    private CustomTitleBar f20820g;
    private Context f20821h = null;
    private C6046e f20822i = new C6046e();
    private C6047f f20823j = new C6047f();
    private String[] f20824k = new String[]{"https://health.vmall.com/help/legal/eula/index.jsp", "https://health.vmall.com/help/userimprovement/index.jsp"};
    private C6022u f20825l = null;
    private String f20826m = null;
    private int f20827n = -1;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C6031h.activity_lefal_info_webview);
        this.f20821h = BaseApplication.b();
        m27624a();
    }

    private void m27624a() {
        Intent intent = getIntent();
        this.f20820g = (CustomTitleBar) C6000d.m27460a((Activity) this, C6030g.use_agreenment_title);
        String stringExtra = intent.getStringExtra("LegalInfoWebViewActivity.TITLE_KEY");
        this.f20820g.setTitleText(stringExtra);
        if (stringExtra != null && stringExtra.equals(getString(C6034k.IDS_setting_user_agreement))) {
            this.f20820g.setTitleTextSize(13.0f);
        }
        this.f20826m = intent.getStringExtra("LegalInfoWebViewActivity.URL_KEY");
        this.f20815b = (LinearLayout) C6000d.m27460a((Activity) this, C6030g.layout_retry);
        this.f20815b.setVisibility(8);
        this.f20814a = (LinearLayout) C6000d.m27460a((Activity) this, C6030g.layout_loading);
        this.f20814a.setVisibility(0);
        this.f20816c = (Button) C6000d.m27460a((Activity) this, C6030g.retry);
        this.f20816c.setText(this.f20816c.getText().toString().toUpperCase());
        m27629b();
        this.f20816c.setOnClickListener(new C6042a(this));
        this.f20817d = (Button) C6000d.m27460a((Activity) this, C6030g.ok_btn);
        this.f20817d.setOnClickListener(new C6043b(this));
        this.f20827n = intent.getIntExtra("LegalInfoWebViewActivity.URL_TYPE_KEY", -1);
        switch (this.f20827n) {
            case 1001:
                this.f20819f.setTextSize(TextSize.SMALLER);
                if (m27627a(this.f20821h)) {
                    m27636e();
                    return;
                }
                this.f20818e.setVisibility(0);
                m27638f();
                return;
            case 1002:
                this.f20818e.loadUrl(this.f20826m);
                return;
            default:
                return;
        }
    }

    private void m27629b() {
        this.f20818e = (WebView) C6000d.m27460a((Activity) this, C6030g.webview);
        this.f20818e.getSettings().setCacheMode(1);
        this.f20819f = this.f20818e.getSettings();
        this.f20819f.setJavaScriptEnabled(true);
        this.f20819f.setSupportZoom(true);
        this.f20819f.setCacheMode(-1);
        this.f20819f.setSavePassword(false);
        this.f20819f.setAllowFileAccess(false);
        this.f20818e.setWebViewClient(this.f20823j);
        this.f20818e.setWebChromeClient(this.f20822i);
        this.f20818e.setBackgroundColor(0);
    }

    private void m27631c() {
        this.f20818e.setVisibility(8);
        this.f20815b.setVisibility(0);
        this.f20814a.setVisibility(8);
    }

    private void m27634d() {
        this.f20815b.setVisibility(8);
    }

    private void m27636e() {
        this.f20825l = new C6024w(this).m27591a(C6034k.IDS_service_area_notice_title).m27596b(C6034k.IDS_app_help_3gnet_diag_conent).m27597b(C6034k.IDS_apphelp_pwindows_back_button, new C6045d(this)).m27593a(C6034k.IDS_apphelp_pwindows_continue_button, new C6044c(this)).m27590a();
        this.f20825l.show();
    }

    public static boolean m27627a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return true;
    }

    private void m27638f() {
        if (m27640b(this.f20821h)) {
            m27626a(this.f20826m);
        } else {
            m27631c();
        }
    }

    public boolean m27640b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    private void m27626a(String str) {
        if (m27630b(str)) {
            this.f20818e.loadUrl(str);
        }
    }

    private boolean m27630b(String str) {
        for (String startsWith : this.f20824k) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public void onDestroy() {
        d.n(this.f20821h);
        super.onDestroy();
    }
}
