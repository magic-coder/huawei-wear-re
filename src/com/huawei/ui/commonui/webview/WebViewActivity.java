package com.huawei.ui.commonui.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.C6030g;
import com.huawei.ui.commonui.C6031h;
import com.huawei.ui.commonui.C6034k;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.C6022u;
import com.huawei.ui.commonui.dialog.C6024w;
import com.huawei.ui.commonui.p514d.C6000d;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;

public class WebViewActivity extends BaseActivity {
    private Context f20828a;
    private CustomTitleBar f20829b;
    private WebView f20830c = null;
    private LinearLayout f20831d = null;
    private C6022u f20832e = null;
    private Button f20833f = null;
    private ProgressBar f20834g;
    private String f20835h = null;
    private String f20836i = null;
    private String f20837j = "";
    private C6051j f20838k = new C6051j();
    private C6052k f20839l = new C6052k();
    private String[] f20840m = new String[]{"http://cn.club.vmall.com/", "http://health.vmall.com/help/", "https://health.vmall.com/help/userimprovement/index.jsp", "http://club.huawei.com/cn/forum-1421-1.html", "http://club.huawei.com/", "http://www.dol.cn/minisite/index.aspx", "https://m.vmall.com", "http://v.youku.com", "http://m.youku.com", "http://player.youku.com", "http://www.iqiyi.com", "http://www.miaopai.com", "http://3ms.huawei.com", "http://v.qq.com", "https://v.qq.com", "https://m.v.qq.com", "http://static.video.qq.com", "http://www.letv.com", "http://i7.imgs.letv.com", "https://hwid1.vmall.com", "http://hwid1.vmall.com", "https://msale.vmall.com", "https://health.vmall.com/help/"};

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C6031h.activity_web_view);
        this.f20828a = BaseApplication.b();
        m27641a();
        Intent intent = getIntent();
        this.f20835h = intent.getStringExtra("WebViewActivity.REQUEST_URL_KEY");
        this.f20837j = intent.getStringExtra("WebViewActivity.TITLE");
        m27642a(intent.getIntExtra("WebViewActivity.JUMP_MODE_KEY", -1));
        if (m27644a(this.f20828a)) {
            m27648b();
        } else {
            m27653d();
        }
    }

    private void m27641a() {
        this.f20829b = (CustomTitleBar) C6000d.m27460a((Activity) this, C6030g.app_help_title);
        this.f20833f = (Button) C6000d.m27460a((Activity) this, C6030g.refresh_btn);
        this.f20833f.setText(this.f20833f.getText().toString().toUpperCase());
        this.f20834g = (ProgressBar) C6000d.m27460a((Activity) this, C6030g.load_help_url_progress);
        this.f20830c = (WebView) C6000d.m27460a((Activity) this, C6030g.sns_app_help_web);
        this.f20830c.getSettings().setJavaScriptEnabled(true);
        this.f20830c.getSettings().setDomStorageEnabled(true);
        this.f20830c.getSettings().setSupportZoom(true);
        if (VERSION.SDK_INT >= 19) {
            this.f20830c.getSettings().setCacheMode(2);
        }
        if (VERSION.SDK_INT >= 21) {
            this.f20830c.getSettings().setMixedContentMode(2);
        }
        this.f20830c.getSettings().setSavePassword(false);
        this.f20830c.setWebViewClient(this.f20839l);
        this.f20830c.setWebChromeClient(this.f20838k);
        this.f20830c.setDownloadListener(new C6050i());
        this.f20830c.getSettings().setAllowFileAccess(false);
        this.f20831d = (LinearLayout) C6000d.m27460a((Activity) this, C6030g.help_retry);
    }

    private void m27642a(int i) {
        switch (i) {
            case 0:
                this.f20829b.setTitleText(this.f20828a.getString(C6034k.IDS_main_discovery_tab_service_help));
                return;
            case 1:
                this.f20829b.setTitleText(this.f20828a.getString(C6034k.IDS_main_discovery_tab_service_huawei_club));
                return;
            case 2:
                this.f20829b.setTitleText(this.f20828a.getString(C6034k.IDS_main_left_menu_vmall));
                return;
            default:
                this.f20829b.setTitleText(this.f20837j);
                return;
        }
    }

    private void m27648b() {
        if (this.f20832e == null) {
            this.f20832e = new C6024w(this).m27591a(C6034k.IDS_service_area_notice_title).m27596b(C6034k.IDS_app_help_3gnet_diag_conent).m27597b(C6034k.IDS_apphelp_pwindows_back_button, new C6049h(this)).m27593a(C6034k.IDS_apphelp_pwindows_continue_button, new C6048g(this)).m27590a();
            this.f20832e.setCancelable(false);
        }
        if (!isFinishing()) {
            this.f20832e.show();
        }
    }

    private void m27652c() {
        if (!isFinishing() && this.f20832e != null) {
            this.f20832e.cancel();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f20830c.canGoBack()) {
                this.f20830c.goBack();
                return true;
            }
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public static boolean m27644a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return true;
    }

    public boolean m27658b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    private void m27653d() {
        if (!m27658b(this.f20828a)) {
            m27655e();
        } else if (this.f20836i != null) {
            m27650b(this.f20836i);
            this.f20836i = null;
        } else {
            m27650b(this.f20835h);
        }
    }

    private boolean m27646a(String str) {
        for (String startsWith : this.f20840m) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private void m27650b(String str) {
        if (m27646a(str)) {
            C2538c.c("WebViewActivity", new Object[]{"-- WebViewActivity load url =" + str});
            this.f20830c.loadUrl(str);
            return;
        }
        C2538c.b("WebViewActivity", new Object[]{"This url is inValid:" + str});
    }

    private void m27655e() {
        this.f20831d.setVisibility(0);
    }

    private void m27657f() {
        this.f20831d.setVisibility(8);
    }

    public void onWebRetryClick(View view) {
        m27653d();
    }

    protected void onDestroy() {
        super.onDestroy();
        d.n(this.f20828a);
        if (this.f20830c != null) {
            this.f20830c.destroy();
        }
    }
}
