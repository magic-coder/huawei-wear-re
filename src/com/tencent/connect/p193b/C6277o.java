package com.tencent.connect.p193b;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import com.tencent.tauth.C6494d;
import net.sqlcipher.database.SQLiteDatabase;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONObject;

/* compiled from: ProGuard */
class C6277o extends WebViewClient {
    final /* synthetic */ C6273k f21838a;

    private C6277o(C6273k c6273k) {
        this.f21838a = c6273k;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C6367n.m29107b("openSDK_LOG.authDlg", "-->Redirect URL: " + str);
        if (str.startsWith("auth://browser")) {
            JSONObject c = C6412y.m29256c(str);
            this.f21838a.f21828m = this.f21838a.m28820e();
            if (!this.f21838a.f21828m) {
                if (c.optString("fail_cb", null) != null) {
                    this.f21838a.m28832a(c.optString("fail_cb"), "");
                } else if (c.optInt("fall_to_wv") == 1) {
                    C6273k.m28805a(this.f21838a, this.f21838a.f21816a.indexOf(LocationInfo.NA) > -1 ? SNBConstant.FILTER : LocationInfo.NA);
                    C6273k.m28805a(this.f21838a, (Object) "browser_error=1");
                    this.f21838a.f21825j.loadUrl(this.f21838a.f21816a);
                } else {
                    String optString = c.optString("redir", null);
                    if (optString != null) {
                        this.f21838a.f21825j.loadUrl(optString);
                    }
                }
            }
            return true;
        } else if (str.startsWith("auth://tauth.qq.com/")) {
            this.f21838a.f21817b.mo5288a(C6412y.m29256c(str));
            this.f21838a.dismiss();
            return true;
        } else if (str.startsWith("auth://cancel")) {
            this.f21838a.f21817b.mo5286a();
            this.f21838a.dismiss();
            return true;
        } else if (str.startsWith("auth://close")) {
            this.f21838a.dismiss();
            return true;
        } else if (str.startsWith("download://")) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str.substring("download://".length()))));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.f21838a.f21826k.startActivity(intent);
            } catch (Exception e) {
                C6367n.m29107b("openSDK_LOG.authDlg", "-->start download activity exception, e: " + e.getMessage());
            }
            return true;
        } else if (str.startsWith("auth://progress")) {
            try {
                r0 = Uri.parse(str).getPathSegments();
                if (r0.isEmpty()) {
                    return true;
                }
                int intValue = Integer.valueOf((String) r0.get(0)).intValue();
                if (intValue == 0) {
                    this.f21838a.f21822g.setVisibility(8);
                    this.f21838a.f21825j.setVisibility(0);
                } else if (intValue == 1) {
                    this.f21838a.f21822g.setVisibility(0);
                }
                return true;
            } catch (Exception e2) {
                return true;
            }
        } else if (str.startsWith("auth://onLoginSubmit")) {
            try {
                r0 = Uri.parse(str).getPathSegments();
                if (!r0.isEmpty()) {
                    this.f21838a.f21831p = (String) r0.get(0);
                }
            } catch (Exception e3) {
            }
            return true;
        } else if (this.f21838a.f21827l.mo5337a(this.f21838a.f21825j, str)) {
            return true;
        } else {
            C6367n.m29110c("openSDK_LOG.authDlg", "-->Redirect URL: return false");
            return false;
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        C6367n.m29110c("openSDK_LOG.authDlg", "-->onReceivedError, errorCode: " + i + " | description: " + str);
        if (!C6412y.m29257c(this.f21838a.f21826k)) {
            this.f21838a.f21817b.mo5287a(new C6494d(9001, "当前网络不可用，请稍后重试！", str2));
            this.f21838a.dismiss();
        } else if (this.f21838a.f21830o.startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?")) {
            this.f21838a.f21817b.mo5287a(new C6494d(i, str, str2));
            this.f21838a.dismiss();
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f21838a.f21832q;
            if (this.f21838a.f21829n >= 1 || elapsedRealtime >= this.f21838a.f21833r) {
                this.f21838a.f21825j.loadUrl(this.f21838a.m28804a());
                return;
            }
            this.f21838a.f21829n = this.f21838a.f21829n + 1;
            this.f21838a.f21819d.postDelayed(new C6278p(this), 500);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C6367n.m29107b("openSDK_LOG.authDlg", "-->onPageStarted, url: " + str);
        super.onPageStarted(webView, str, bitmap);
        this.f21838a.f21822g.setVisibility(0);
        this.f21838a.f21832q = SystemClock.elapsedRealtime();
        if (!TextUtils.isEmpty(this.f21838a.f21830o)) {
            this.f21838a.f21819d.removeCallbacks((Runnable) this.f21838a.f21834s.remove(this.f21838a.f21830o));
        }
        this.f21838a.f21830o = str;
        Runnable c6281s = new C6281s(this.f21838a, this.f21838a.f21830o);
        this.f21838a.f21834s.put(str, c6281s);
        this.f21838a.f21819d.postDelayed(c6281s, 120000);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        C6367n.m29107b("openSDK_LOG.authDlg", "-->onPageFinished, url: " + str);
        this.f21838a.f21822g.setVisibility(8);
        if (this.f21838a.f21825j != null) {
            this.f21838a.f21825j.setVisibility(0);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f21838a.f21819d.removeCallbacks((Runnable) this.f21838a.f21834s.remove(str));
        }
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.cancel();
        this.f21838a.f21817b.mo5287a(new C6494d(sslError.getPrimaryError(), "请求不合法，请检查手机安全设置，如系统时间、代理等。", "ssl error"));
        this.f21838a.dismiss();
    }
}
