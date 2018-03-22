package com.huawei.operation.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.operation.C5708a;
import com.huawei.operation.C5713b;
import com.huawei.operation.d;
import com.huawei.operation.e;
import com.huawei.operation.f;
import com.huawei.operation.js.JsInteraction;
import com.huawei.operation.js.JsInteraction$AchievementShareCallback;
import com.huawei.operation.js.JsInteraction$SetTitleCallback;
import com.huawei.operation.js.JsInteraction$ShareCallback;
import com.huawei.operation.js.JsInteraction$StartGPSTrackPageCallback;
import com.huawei.operation.js.JsInteraction$StartSocialDetailPageCallback;
import com.huawei.operation.js.JsInteraction$ToastCallBack;
import com.huawei.p190v.C2538c;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Iterator;

public class CustomWebView extends LinearLayout implements JsInteraction$AchievementShareCallback, JsInteraction$SetTitleCallback, JsInteraction$ShareCallback, JsInteraction$StartGPSTrackPageCallback, JsInteraction$StartSocialDetailPageCallback, JsInteraction$ToastCallBack {
    private static ArrayList<String> f19476i;
    private WebView f19477a;
    private C5717d f19478b;
    private ProgressBar f19479c;
    private Context f19480d;
    private TextView f19481e;
    private ArrayList<String> f19482f;
    private Handler f19483g;
    private C5713b f19484h;

    public CustomWebView(Context context) {
        this(context, null);
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26348a(context);
    }

    private void m26348a(Context context) {
        this.f19480d = context;
        View inflate = LayoutInflater.from(context).inflate(e.webview, this);
        this.f19477a = (WebView) inflate.findViewById(d.view);
        this.f19479c = (ProgressBar) inflate.findViewById(d.load_url_progress);
        this.f19478b = new C5717d();
        m26347a();
        this.f19483g = new C5714a(this);
        this.f19484h = (C5713b) C5708a.m26333a(this.f19480d).getAdapter();
    }

    @TargetApi(7)
    private void m26347a() {
        this.f19482f = new ArrayList();
        this.f19477a.getSettings().setCacheMode(1);
        this.f19477a.getSettings().setAppCacheMaxSize(8388608);
        this.f19477a.getSettings().setAppCachePath(this.f19480d.getCacheDir().getAbsolutePath() + "/webCache");
        this.f19477a.getSettings().setAllowFileAccess(false);
        this.f19477a.getSettings().setAppCacheEnabled(true);
        WebSettings settings = this.f19477a.getSettings();
        settings.setSupportZoom(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setTextZoom(100);
        settings.setLoadWithOverviewMode(true);
        settings.setSavePassword(false);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        this.f19477a.setWebChromeClient(this.f19478b);
        JsInteraction jsInteraction = new JsInteraction(this.f19480d);
        jsInteraction.setShareCallback(this);
        jsInteraction.setSetTitleCallback(this);
        jsInteraction.setAchievementShareCallback(this);
        jsInteraction.setStartGPSTrackPageCallback(this);
        jsInteraction.setStartSocialDetailPageCallback(this);
        jsInteraction.setToastCallBack(this);
        this.f19477a.addJavascriptInterface(jsInteraction, "JsInteraction");
        this.f19477a.setOnKeyListener(new C5715b(this));
    }

    public void setTitle(String str) {
        setBrowserTitle(str);
    }

    public void onShare(String str, String str2) {
        C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"onShare activityId = " + str + "  shareType:" + str2});
    }

    public void onAchievementShare(String str, String str2) {
        C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"getImgurlAndAwardName imgUrl = " + str});
        C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"getImgurlAndAwardName awardName = " + str2});
        if (this.f19484h != null) {
            this.f19484h.m26345a(this.f19480d, str, str2);
        }
    }

    public void onStartGPSTrackPage(Context context, int i, String str, float f) {
        C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"onStartGPSTrackPage sportType:" + i + " targetType:" + str + " targetValue:" + f});
        if (this.f19484h != null) {
            this.f19484h.m26343a(context, i, str, f);
        }
    }

    public void onStartSocialDetialPage(Context context, long j) {
        C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"onStartSocialDetialPage huid" + j});
        if (this.f19484h != null) {
            this.f19484h.m26344a(context, j);
        }
    }

    public void onToast(String str, String str2) {
        this.f19483g.obtainMessage(2, str).sendToTarget();
    }

    private void setBrowserTitle(String str) {
        if (this.f19481e != null) {
            if (m26355d(str)) {
                str = this.f19480d.getResources().getString(f.IDS_plugin_operation_activity_title);
            }
            this.f19483g.obtainMessage(1, str).sendToTarget();
            this.f19482f.add(str);
        }
    }

    public boolean m26357a(String str) {
        boolean z;
        C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"checkUrlInvalid url:" + str});
        if (str.startsWith("https://healthactivity.hicloud.com") || str.startsWith("https://achievement.hicloud.com") || str.startsWith("http://mp.weixin.qq.com/") || str.startsWith("https://mp.weixin.qq.com/") || str.startsWith("https://www.sojump.com/") || str.startsWith("https://www.wenjuan.com/") || str.startsWith("http://www.mikecrm.com/") || str.startsWith("https://www.diaochapai.com")) {
            z = false;
        } else {
            z = true;
        }
        C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"checkUrlInvalid return " + z});
        return z;
    }

    public void m26358b(String str) {
        C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"load url ===>" + str});
        if (TextUtils.isEmpty(str)) {
            str = "about:blank";
        }
        if (com.huawei.hwcommonmodel.d.d.e(this.f19480d)) {
            m26349a(this.f19480d, str);
            if (m26357a(str)) {
                C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"OverrideUrlLoading false:"});
                this.f19477a.getSettings().setJavaScriptEnabled(false);
            } else {
                C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"OverrideUrlLoading true:"});
                this.f19477a.getSettings().setJavaScriptEnabled(true);
            }
            this.f19477a.loadUrl(str);
            this.f19477a.postDelayed(new C5716c(this), 1000);
            return;
        }
        this.f19483g.obtainMessage(3).sendToTarget();
    }

    private String m26353c(String str) {
        return str.split("/web/")[0] + "/web";
    }

    private void m26349a(Context context, String str) {
        C5713b c5713b = (C5713b) C5708a.m26333a(this.f19480d).getAdapter();
        if (c5713b == null) {
            C2538c.b("[Operation Version 1.2]CustomWebView", new Object[]{"pluginOperationAdapter=null"});
            return;
        }
        String c = m26353c(str);
        String str2 = (String) c5713b.m26342a(new String[]{"getAppInfo"}).get("version");
        c.b("[Operation Version 1.2]CustomWebView", new Object[]{"syncCookie appVersion:" + str2});
        try {
            c.b("[Operation Version 1.2]CustomWebView", new Object[]{"Nat: webView.syncCookie.url:" + c});
            CookieSyncManager.createInstance(context);
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            instance.removeSessionCookie();
            instance.removeAllCookie();
            if (instance.getCookie(c) != null) {
                c.b("[Operation Version 1.2]CustomWebView", new Object[]{"Nat: webView.syncCookieOutter.oldCookie:" + instance.getCookie(c)});
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("version=%s", new Object[]{str2}));
            instance.setCookie(c, stringBuilder.toString());
            CookieSyncManager.getInstance().sync();
            if (instance.getCookie(c) != null) {
                c.b("[Operation Version 1.2]CustomWebView", new Object[]{"Nat: webView.syncCookie.newCookie:" + instance.getCookie(c)});
            }
        } catch (Exception e) {
            c.e("[Operation Version 1.2]CustomWebView", new Object[]{"Nat: webView.syncCookie failed:" + e.toString()});
        }
    }

    public void setTextView(TextView textView) {
        this.f19481e = textView;
    }

    public ProgressBar getProgressBar() {
        return this.f19479c;
    }

    public void setWebViewClientBase(WebViewClient webViewClient) {
        this.f19477a.setWebViewClient(webViewClient);
    }

    public void setWebViewChromeBase(WebChromeClient webChromeClient) {
        this.f19477a.setWebChromeClient(webChromeClient);
    }

    static {
        f19476i = null;
        f19476i = new ArrayList();
        f19476i.add("http");
        f19476i.add("https");
        f19476i.add("404 Not Found");
    }

    private boolean m26355d(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String normalize = Normalizer.normalize(str, Form.NFKC);
        Iterator it = f19476i.iterator();
        while (it.hasNext()) {
            if (normalize.startsWith(Normalizer.normalize((String) it.next(), Form.NFKC))) {
                return true;
            }
        }
        return false;
    }

    public void setJsEnable(boolean z) {
        C2538c.c("[Operation Version 1.2]CustomWebView", new Object[]{"Enter setJsEnable :" + z});
        if (this.f19477a != null) {
            this.f19477a.getSettings().setJavaScriptEnabled(z);
        }
    }
}
