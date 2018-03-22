package com.alipay.sdk.p246c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.widget.LinearLayout;
import cn.com.fmsh.tsm.business.constants.Constants.XMLNode;
import com.alipay.sdk.app.C3158h;
import com.alipay.sdk.app.C3159i;
import com.alipay.sdk.app.p244a.C3149a;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"SetJavaScriptEnabled", "DefaultLocale"})
public final class C3172b {
    public static String m14018a(byte[] bArr) {
        try {
            String obj = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey().toString();
            if (obj.indexOf(XMLNode.KEY_MODULUS) != -1) {
                return obj.substring(obj.indexOf(XMLNode.KEY_MODULUS) + 8, obj.lastIndexOf(",")).trim();
            }
        } catch (Throwable e) {
            C3149a.m13984a("auth", "GetPublicKeyFromSignEx", e);
        }
        return null;
    }

    public static C3173c m14015a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 192);
            if (!C3172b.m14019a(packageInfo)) {
                try {
                    packageInfo = C3172b.m14022b(context, str);
                } catch (Throwable th) {
                    C3149a.m13984a("auth", "GetInstalledPackagesEx", th);
                }
            }
        } catch (Throwable th2) {
            C3149a.m13984a("auth", "GetInstalledPackagesEx", th2);
            packageInfo = null;
        }
        if (!C3172b.m14019a(packageInfo) || packageInfo == null) {
            return null;
        }
        C3173c c3173c = new C3173c();
        c3173c.f10575a = packageInfo.signatures;
        c3173c.f10576b = packageInfo.versionCode;
        return c3173c;
    }

    private static boolean m14019a(PackageInfo packageInfo) {
        String str = "";
        boolean z = false;
        if (packageInfo == null) {
            str = str + "info == null";
        } else if (packageInfo.signatures == null) {
            str = str + "info.signatures == null";
        } else if (packageInfo.signatures.length <= 0) {
            str = str + "info.signatures.length <= 0";
        } else {
            z = true;
        }
        if (!z) {
            C3149a.m13983a("auth", "NotIncludeSignatures", str);
        }
        return z;
    }

    private static PackageInfo m14022b(Context context, String str) {
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(192)) {
            if (packageInfo.packageName.equals(str)) {
                return packageInfo;
            }
        }
        return null;
    }

    public static String m14017a(Context context) {
        String a = C3172b.m14016a();
        String b = C3172b.m14023b();
        String b2 = C3172b.m14024b(context);
        return " (" + a + ";" + b + ";" + b2 + ";;" + C3172b.m14026c(context) + ")(sdk android)";
    }

    public static String m14016a() {
        return "Android " + VERSION.RELEASE;
    }

    public static WebView m14014a(Activity activity, String str, String str2) {
        Method method;
        if (!TextUtils.isEmpty(str2)) {
            CookieSyncManager.createInstance(activity.getApplicationContext()).sync();
            CookieManager.getInstance().setCookie(str, str2);
            CookieSyncManager.getInstance().sync();
        }
        View linearLayout = new LinearLayout(activity);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        activity.setContentView(linearLayout, layoutParams);
        View webView = new WebView(activity);
        layoutParams.weight = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        webView.setVisibility(0);
        linearLayout.addView(webView, layoutParams);
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + C3172b.m14017a((Context) activity));
        settings.setRenderPriority(RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
        settings.setAllowFileAccess(false);
        settings.setTextSize(TextSize.NORMAL);
        webView.setVerticalScrollbarOverlay(true);
        webView.setDownloadListener(new C3174d(activity));
        if (VERSION.SDK_INT >= 7) {
            try {
                method = webView.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[]{Boolean.TYPE});
                if (method != null) {
                    method.invoke(webView.getSettings(), new Object[]{Boolean.valueOf(true)});
                }
            } catch (Exception e) {
            }
        }
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
        }
        if (VERSION.SDK_INT >= 19) {
            webView.getSettings().setCacheMode(1);
        }
        webView.loadUrl(str);
        return webView;
    }

    public static String m14023b() {
        String c = C3172b.m14025c();
        int indexOf = c.indexOf("-");
        if (indexOf != -1) {
            c = c.substring(0, indexOf);
        }
        indexOf = c.indexOf("\n");
        if (indexOf != -1) {
            c = c.substring(0, indexOf);
        }
        return "Linux " + c;
    }

    private static String m14025c() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            CharSequence readLine = bufferedReader.readLine();
            bufferedReader.close();
            Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
            if (!matcher.matches()) {
                return "Unavailable";
            }
            if (matcher.groupCount() < 4) {
                return "Unavailable";
            }
            return new StringBuilder(matcher.group(1)).append("\n").append(matcher.group(2)).append(HwAccountConstants.BLANK).append(matcher.group(3)).append("\n").append(matcher.group(4)).toString();
        } catch (IOException e) {
            return "Unavailable";
        } catch (Throwable th) {
            bufferedReader.close();
        }
    }

    public static String m14024b(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String m14026c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(displayMetrics.widthPixels);
        stringBuilder.append("*");
        stringBuilder.append(displayMetrics.heightPixels);
        return stringBuilder.toString();
    }

    public static boolean m14021a(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static boolean m14020a(WebView webView, String str, Activity activity) {
        C3159i a;
        if (!TextUtils.isEmpty(str)) {
            if (str.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase()) || str.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())) {
                try {
                    C3173c a2 = C3172b.m14015a(activity, "com.eg.android.AlipayGphone");
                    if (!(a2 == null || a2.m14027a())) {
                        if (str.startsWith("intent://platformapi/startapp")) {
                            str = str.replaceFirst("intent://platformapi/startapp\\?", "alipays://platformapi/startApp?");
                        }
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    }
                } catch (Throwable th) {
                }
            } else if (TextUtils.equals(str, "sdklite://h5quit") || TextUtils.equals(str, "http://m.alipay.com/?action=h5quit")) {
                C3158h.f10542a = C3158h.m13994a();
                activity.finish();
            } else if (str.startsWith("sdklite://h5quit?result=")) {
                try {
                    String substring = str.substring(str.indexOf("sdklite://h5quit?result=") + 24);
                    int parseInt = Integer.parseInt(substring.substring(substring.lastIndexOf("&end_code=") + 10));
                    if (parseInt == C3159i.SUCCEEDED.f10551h || parseInt == C3159i.PAY_WAITTING.f10551h) {
                        String decode = URLDecoder.decode(str);
                        decode = decode.substring(decode.indexOf("sdklite://h5quit?result=") + 24, decode.lastIndexOf("&end_code="));
                        a = C3159i.m13996a(parseInt);
                        C3158h.f10542a = C3158h.m13995a(a.f10551h, a.f10552i, decode);
                        activity.runOnUiThread(new C3175e(activity));
                    } else {
                        a = C3159i.m13996a(C3159i.FAILED.f10551h);
                        C3158h.f10542a = C3158h.m13995a(a.f10551h, a.f10552i, "");
                        activity.runOnUiThread(new C3175e(activity));
                    }
                } catch (Exception e) {
                    a = C3159i.m13996a(C3159i.PARAMS_ERROR.f10551h);
                    C3158h.f10542a = C3158h.m13995a(a.f10551h, a.f10552i, "");
                }
            } else {
                webView.loadUrl(str);
            }
        }
        return true;
    }
}
