package com.huawei.ui.main.stories.about.activity.legalinformation;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.d.d;
import com.huawei.ui.commonui.dialog.u;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.j;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import org.apache.http.client.methods.HttpGet;

public class PrivacyPolicyActivity extends BaseActivity {
    private static final String[] f8388j = new String[]{"ae", "ba", "bg", "mm", "az", "ct", HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE, "hr", "cz", "dk", "nl", "en", "ee", "kh", "uz", "fi", "fr", "de", "gr", "in", "hu", "id", "it", "jp", "br", "kr", "lv", "lt", "mk", "my", "no", "pl", "pt", "ro", "ru", "sk", "si", "es", "sla", "se", "th", "tw", "hk", "tr", "ua", "vn"};
    private LinearLayout f8389a = null;
    private LinearLayout f8390b = null;
    private Button f8391c = null;
    private Button f8392d = null;
    private WebView f8393e = null;
    private Context f8394f = null;
    private C2321i f8395g = new C2321i();
    private C2322j f8396h = new C2322j();
    private u f8397i = null;
    private Handler f8398k = new C2320h(this, this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_lefal_info_webview);
        this.f8394f = this;
        m11832a();
    }

    private void m11832a() {
        this.f8390b = (LinearLayout) d.a(this, f.layout_retry);
        this.f8390b.setVisibility(8);
        this.f8389a = (LinearLayout) d.a(this, f.layout_loading);
        this.f8389a.setVisibility(0);
        this.f8393e = (WebView) d.a(this, f.webview);
        this.f8391c = (Button) d.a(this, f.retry);
        this.f8391c.setText(this.f8391c.getText().toString().toUpperCase());
        m11841b();
        if (m11837a(this.f8394f)) {
            C2538c.m12674b("PrivacyPolicyActivity", "===www===Enter 3G dialog ");
            m11842b(this.f8394f);
        } else {
            this.f8393e.setVisibility(0);
            m11848d(this.f8394f);
        }
        this.f8391c.setOnClickListener(new C2315c(this));
        this.f8392d = (Button) d.a(this, f.ok_btn);
        this.f8392d.setOnClickListener(new C2316d(this));
    }

    private void m11841b() {
        this.f8393e.getSettings().setCacheMode(1);
        WebSettings settings = this.f8393e.getSettings();
        settings.setJavaScriptEnabled(false);
        settings.setSupportZoom(true);
        settings.setCacheMode(-1);
        settings.setSavePassword(false);
        settings.setTextSize(TextSize.SMALLER);
        this.f8393e.setWebViewClient(this.f8396h);
        this.f8393e.setWebChromeClient(this.f8395g);
        this.f8393e.getSettings().setAllowFileAccess(false);
        this.f8393e.setBackgroundColor(0);
    }

    private void m11845c() {
        C2538c.m12674b("PrivacyPolicyActivity", "===www===showTryAgain");
        this.f8393e.setVisibility(8);
        this.f8390b.setVisibility(0);
        this.f8389a.setVisibility(8);
    }

    private void m11847d() {
        this.f8390b.setVisibility(8);
    }

    private void m11842b(Context context) {
        C2538c.m12674b("PrivacyPolicyActivity", "===www===showIs3GDialog");
        this.f8397i = new w(this.f8394f).a(j.IDS_service_area_notice_title).b(j.IDS_app_help_3gnet_diag_conent).a(j.IDS_apphelp_pwindows_continue_button, new C2318f(this, context)).b(j.IDS_apphelp_pwindows_back_button, new C2317e(this)).a();
        this.f8397i.show();
    }

    public static boolean m11837a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return true;
    }

    private void m11836a(String str) {
        C2538c.m12674b("PrivacyPolicyActivity", "===www===loadTermsWeb");
        this.f8393e.loadDataWithBaseURL(null, str, "text/html", GameManager.DEFAULT_CHARSET, null);
    }

    private String m11844c(Context context) {
        String language;
        int i;
        C2538c.m12674b("PrivacyPolicyActivity", "===www===getFormatUrl");
        String toLowerCase = context.getResources().getConfiguration().locale.getCountry().toLowerCase(Locale.getDefault());
        C2538c.m12674b("PrivacyPolicyActivity", "===www=== uintStr" + toLowerCase + "-" + toLowerCase);
        for (String equalsIgnoreCase : f8388j) {
            if (equalsIgnoreCase.equalsIgnoreCase(toLowerCase)) {
                if (toLowerCase.startsWith(HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE)) {
                    language = Locale.getDefault().getLanguage();
                    C2538c.m12674b("PrivacyPolicyActivity", "===www=== uintStr" + Locale.getDefault().getLanguage());
                    if (language == null || !language.toLowerCase(Locale.getDefault()).contains("bo")) {
                        language = toLowerCase;
                    } else {
                        language = "bo";
                    }
                    i = 1;
                } else {
                    language = toLowerCase;
                    i = 1;
                }
                if (i == 0) {
                    toLowerCase = Locale.getDefault().getLanguage();
                    if (toLowerCase == null && toLowerCase.toLowerCase(Locale.getDefault()).contains("ar")) {
                        language = "ae";
                    } else if (language.startsWith("es")) {
                        language = "ct";
                    } else if (language.startsWith("ir")) {
                        language = "fs";
                    } else if (language.startsWith("il")) {
                        language = "he";
                    } else if (language.startsWith("eg")) {
                        language = "ae";
                    } else if (language.startsWith("ar")) {
                        language = "es";
                    } else if (language.startsWith("ge")) {
                        language = "ka";
                    } else if (language.startsWith("pk")) {
                        language = "ur";
                    } else if (language.startsWith("rs")) {
                        language = "sr";
                    } else if (language.startsWith("lk")) {
                        language = "en";
                    } else {
                        language = "si-lk";
                    }
                }
                C2538c.m12674b("PrivacyPolicyActivity", "getFormatUrl :  country = " + language + ",url = " + String.format("http://consumer.huawei.com/minisite/worldwide/privacy-policy/%s/index.htm", new Object[]{language}));
                return String.format("http://consumer.huawei.com/minisite/worldwide/privacy-policy/%s/index.htm", new Object[]{language});
            }
        }
        language = toLowerCase;
        i = 0;
        if (i == 0) {
            toLowerCase = Locale.getDefault().getLanguage();
            if (toLowerCase == null) {
            }
            if (language.startsWith("es")) {
                language = "ct";
            } else if (language.startsWith("ir")) {
                language = "fs";
            } else if (language.startsWith("il")) {
                language = "he";
            } else if (language.startsWith("eg")) {
                language = "ae";
            } else if (language.startsWith("ar")) {
                language = "es";
            } else if (language.startsWith("ge")) {
                language = "ka";
            } else if (language.startsWith("pk")) {
                language = "ur";
            } else if (language.startsWith("rs")) {
                language = "sr";
            } else if (language.startsWith("lk")) {
                language = "en";
            } else {
                language = "si-lk";
            }
        }
        C2538c.m12674b("PrivacyPolicyActivity", "getFormatUrl :  country = " + language + ",url = " + String.format("http://consumer.huawei.com/minisite/worldwide/privacy-policy/%s/index.htm", new Object[]{language}));
        return String.format("http://consumer.huawei.com/minisite/worldwide/privacy-policy/%s/index.htm", new Object[]{language});
    }

    private byte[] m11838a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1204];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                C2538c.m12674b("PrivacyPolicyActivity", "IOException e" + e.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        C2538c.m12674b("PrivacyPolicyActivity", "IOException e" + e2.getMessage());
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        C2538c.m12674b("PrivacyPolicyActivity", "IOException e" + e3.getMessage());
                    }
                }
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e22) {
                C2538c.m12674b("PrivacyPolicyActivity", "IOException e" + e22.getMessage());
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void m11848d(Context context) {
        new Thread(new C2319g(this, context)).start();
    }

    private String m11831a(URL url) {
        C2538c.m12674b("PrivacyPolicyActivity", "===www===Enter getURLSource");
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
            httpURLConnection.setConnectTimeout(10000);
            C2538c.m12674b("PrivacyPolicyActivity", "===www===inStream" + httpURLConnection.getInputStream());
            String str = null;
            try {
                str = new String(m11838a(httpURLConnection.getInputStream()), "utf-8");
            } catch (UnsupportedEncodingException e) {
                C2538c.m12674b("PrivacyPolicyActivity", "===www===inStream IOException e" + e.getMessage());
            }
            if (str != null && ((str.contains("<div class=\"terms-of-use\">") || str.contains("<div class=\"terms-of-use\" style=\"font-family:'zawgyi-one';\">")) && str.contains("</div>"))) {
                int indexOf;
                if (str.contains("<div class=\"terms-of-use\">")) {
                    indexOf = str.indexOf("<div class=\"terms-of-use\">");
                } else if (str.contains("<div class=\"terms-of-use\" style=\"font-family:'zawgyi-one';\">")) {
                    indexOf = str.indexOf("<div class=\"terms-of-use\" style=\"font-family:'zawgyi-one';\">");
                } else {
                    indexOf = 0;
                }
                int indexOf2 = str.indexOf("</div>", indexOf);
                if (-1 == indexOf || -1 == indexOf2) {
                    C2538c.m12677c("PrivacyPolicyActivity", "getURLSource(): i = " + indexOf + ",j = " + indexOf2);
                    return "";
                }
                try {
                    String substring = str.substring(indexOf, indexOf2);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("<html><head><style type=\"text/css\">ol,li{margin:0;padding:0;}</style></head><body>");
                    stringBuffer.append(substring);
                    stringBuffer.append("</div></body></html>");
                    return stringBuffer.toString();
                } catch (StringIndexOutOfBoundsException e2) {
                    C2538c.m12677c("PrivacyPolicyActivity", "StringIndexOutOfBoundsException e" + e2.getMessage());
                }
            }
            return "";
        } catch (IOException e3) {
            C2538c.m12674b("PrivacyPolicyActivity", "===www===inStream IOException e" + e3.getMessage());
            return "";
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C0977d.m3575n(this.f8394f);
        if (this.f8398k != null) {
            this.f8398k.removeCallbacksAndMessages(null);
            this.f8398k = null;
        }
    }
}
