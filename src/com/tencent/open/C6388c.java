package com.tencent.open;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.tencent.open.p532d.C6405r;
import com.tencent.open.p532d.C6412y;
import com.tencent.tauth.C6494d;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: ProGuard */
class C6388c extends WebViewClient {
    final /* synthetic */ C6371a f22210a;

    private C6388c(C6371a c6371a) {
        this.f22210a = c6371a;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C6412y.m29247a("TDialog", "Redirect URL: " + str);
        if (str.startsWith(C6405r.m29214a().m29215a((Context) this.f22210a.f22160e.get(), "auth://tauth.qq.com/"))) {
            this.f22210a.f22162h.mo5288a(C6412y.m29256c(str));
            if (this.f22210a.isShowing()) {
                this.f22210a.dismiss();
            }
            return true;
        } else if (str.startsWith("auth://cancel")) {
            this.f22210a.f22162h.mo5286a();
            if (this.f22210a.isShowing()) {
                this.f22210a.dismiss();
            }
            return true;
        } else if (str.startsWith("auth://close")) {
            if (this.f22210a.isShowing()) {
                this.f22210a.dismiss();
            }
            return true;
        } else if (str.startsWith("download://")) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str.substring("download://".length()))));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (!(this.f22210a.f22160e == null || this.f22210a.f22160e.get() == null)) {
                ((Context) this.f22210a.f22160e.get()).startActivity(intent);
            }
            return true;
        } else if (str.startsWith("auth://progress")) {
            return true;
        } else {
            return false;
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f22210a.f22162h.mo5287a(new C6494d(i, str, str2));
        if (!(this.f22210a.f22160e == null || this.f22210a.f22160e.get() == null)) {
            Toast.makeText((Context) this.f22210a.f22160e.get(), "网络连接异常或系统错误", 0).show();
        }
        this.f22210a.dismiss();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C6412y.m29247a("TDialog", "Webview loading URL: " + str);
        super.onPageStarted(webView, str, bitmap);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f22210a.f22165k.setVisibility(0);
    }
}
