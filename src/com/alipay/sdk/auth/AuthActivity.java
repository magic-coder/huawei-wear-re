package com.alipay.sdk.auth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alipay.sdk.p243a.C3143a;
import com.alipay.sdk.p243a.C3144b;
import com.alipay.sdk.p243a.C3146d;
import com.alipay.sdk.p246c.C3172b;
import com.alipay.sdk.p247d.C3176a;
import com.android.volley.DefaultRetryPolicy;
import com.sina.weibo.sdk.constant.WBConstants;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled", "DefaultLocale"})
public class AuthActivity extends Activity {
    private WebView f10553a;
    private String f10554b;
    private C3176a f10555c;
    private Handler f10556d;
    private boolean f10557e;
    private boolean f10558f;
    private Runnable f10559g = new C3165f(this);

    static /* synthetic */ void m13997a(AuthActivity authActivity, C3143a c3143a) {
        if (authActivity.f10553a != null && c3143a != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clientId", c3143a.f10507a);
                jSONObject.put("func", c3143a.f10509c);
                jSONObject.put("param", c3143a.f10511e);
                jSONObject.put("msgType", c3143a.f10510d);
                authActivity.runOnUiThread(new C3164e(authActivity, String.format("AlipayJSBridge._invokeJS(%s)", new Object[]{jSONObject.toString()})));
            } catch (JSONException e) {
            }
        }
    }

    static /* synthetic */ boolean m13999a(AuthActivity authActivity, String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://")) {
            return false;
        }
        if (!"SDKLite://h5quit".equalsIgnoreCase(str)) {
            if (TextUtils.equals(str, authActivity.f10554b)) {
                str = str + "?resultCode=150";
            }
            C3169j.m14010a(authActivity, str);
        }
        authActivity.finish();
        return true;
    }

    static /* synthetic */ void m14001b(AuthActivity authActivity, String str) {
        Object obj;
        C3146d c3146d = new C3146d(authActivity.getApplicationContext(), new C3163d(authActivity));
        try {
            JSONObject jSONObject = new JSONObject(str);
            Object string = jSONObject.getString("clientId");
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("param");
                    jSONObject2 = jSONObject2 instanceof JSONObject ? jSONObject2 : null;
                    String string2 = jSONObject.getString("func");
                    String string3 = jSONObject.getString("bundleName");
                    C3143a c3143a = new C3143a("call");
                    c3143a.f10508b = string3;
                    c3143a.f10509c = string2;
                    c3143a.f10511e = jSONObject2;
                    c3143a.f10507a = string;
                    c3146d.m13979a(c3143a);
                }
            } catch (Exception e) {
                obj = string;
                if (!TextUtils.isEmpty(obj)) {
                    try {
                        c3146d.m13980a(obj, C3144b.f10516d);
                    } catch (JSONException e2) {
                    }
                }
            }
        } catch (Exception e3) {
            obj = null;
            if (!TextUtils.isEmpty(obj)) {
                c3146d.m13980a(obj, C3144b.f10516d);
            }
        }
    }

    static /* synthetic */ void m14004d(AuthActivity authActivity) {
        try {
            if (authActivity.f10555c == null) {
                authActivity.f10555c = new C3176a(authActivity, "正在加载");
            }
            authActivity.f10555c.m14032a();
        } catch (Exception e) {
            authActivity.f10555c = null;
        }
    }

    static /* synthetic */ void m14007g(AuthActivity authActivity) {
        if (authActivity.f10555c != null) {
            authActivity.f10555c.m14033b();
        }
        authActivity.f10555c = null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            try {
                this.f10554b = extras.getString(WBConstants.SSO_REDIRECT_URL);
                String string = extras.getString("params");
                if (C3172b.m14021a(string)) {
                    Method method;
                    super.requestWindowFeature(1);
                    this.f10556d = new Handler(getMainLooper());
                    View linearLayout = new LinearLayout(this);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    linearLayout.setOrientation(1);
                    setContentView(linearLayout, layoutParams);
                    this.f10553a = new WebView(this);
                    layoutParams.weight = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                    this.f10553a.setVisibility(0);
                    linearLayout.addView(this.f10553a, layoutParams);
                    WebSettings settings = this.f10553a.getSettings();
                    settings.setUserAgentString(settings.getUserAgentString() + C3172b.m14017a(getApplicationContext()));
                    settings.setRenderPriority(RenderPriority.HIGH);
                    settings.setSupportMultipleWindows(true);
                    settings.setJavaScriptEnabled(true);
                    settings.setSavePassword(false);
                    settings.setJavaScriptCanOpenWindowsAutomatically(true);
                    settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
                    settings.setAllowFileAccess(false);
                    settings.setTextSize(TextSize.NORMAL);
                    this.f10553a.setVerticalScrollbarOverlay(true);
                    this.f10553a.setWebViewClient(new C3161b());
                    this.f10553a.setWebChromeClient(new C3160a());
                    this.f10553a.setDownloadListener(new C3162c(this));
                    this.f10553a.loadUrl(string);
                    if (VERSION.SDK_INT >= 7) {
                        try {
                            method = this.f10553a.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[]{Boolean.TYPE});
                            if (method != null) {
                                method.invoke(this.f10553a.getSettings(), new Object[]{Boolean.valueOf(true)});
                            }
                        } catch (Exception e) {
                        }
                    }
                    try {
                        this.f10553a.removeJavascriptInterface("searchBoxJavaBridge_");
                        this.f10553a.removeJavascriptInterface("accessibility");
                        this.f10553a.removeJavascriptInterface("accessibilityTraversal");
                    } catch (Throwable th) {
                    }
                    if (VERSION.SDK_INT >= 19) {
                        this.f10553a.getSettings().setCacheMode(1);
                        return;
                    }
                    return;
                }
                finish();
            } catch (Exception e2) {
                finish();
            }
        } catch (Exception e3) {
            finish();
        }
    }

    public void onBackPressed() {
        if (!this.f10553a.canGoBack()) {
            C3169j.m14010a(this, this.f10554b + "?resultCode=150");
            finish();
        } else if (this.f10558f) {
            C3169j.m14010a(this, this.f10554b + "?resultCode=150");
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f10553a != null) {
            this.f10553a.removeAllViews();
            try {
                this.f10553a.destroy();
            } catch (Throwable th) {
            }
            this.f10553a = null;
        }
    }
}
