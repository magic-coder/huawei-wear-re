package com.huawei.hwid.openapi.auth;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.openapi.out.OutReturn;
import com.huawei.hwid.openapi.out.OutReturn.ParamStr;
import com.huawei.hwid.openapi.p441b.C5227a;
import com.huawei.hwid.openapi.p445e.C5248c;
import com.huawei.hwid.openapi.p445e.p446a.C5243e;
import com.huawei.hwid.openapi.p445e.p447b.C5245a;

class C5221h extends WebViewClient {
    final /* synthetic */ C5218e f18836a;

    private C5221h(C5218e c5218e) {
        this.f18836a = c5218e;
    }

    public void onPageFinished(WebView webView, String str) {
        try {
            super.onPageFinished(webView, str);
            this.f18836a.f18828d.m25368a(webView);
        } catch (Throwable e) {
            C5248c.m25448b(C5218e.f18825e, e.toString(), e);
            this.f18836a.f18826b.f18806b.finish(OutReturn.creatRunTimeErrRet(e.toString()));
            this.f18836a.dismiss();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        try {
            C5248c.m25447b(C5218e.f18825e, "Webview loading URL: " + C5243e.m25426b(str));
            super.onPageStarted(webView, str, bitmap);
            this.f18836a.f18828d.m25369a(webView, this.f18836a);
        } catch (Throwable e) {
            C5248c.m25448b(C5218e.f18825e, e.toString(), e);
            this.f18836a.f18826b.f18806b.finish(OutReturn.creatRunTimeErrRet(e.toString()));
            this.f18836a.dismiss();
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        try {
            super.onReceivedError(webView, i, str, str2);
            Bundle bundle = new Bundle();
            bundle.putString("error_description", "WebReceivedError" + str);
            bundle.putString("failingUrl", str2);
            bundle.putString(ParamStr.Err_Info, str);
            bundle.putInt(ParamStr.RET_CODE, i);
            C5248c.m25450d(C5218e.f18825e, "onReceivedError: errCode:" + i + " description:" + str + " failingUrl:" + C5243e.m25426b(str2));
            this.f18836a.f18826b.f18806b.finish(OutReturn.addFailCode(bundle, 100));
            this.f18836a.dismiss();
        } catch (Throwable e) {
            C5248c.m25448b(C5218e.f18825e, e.toString(), e);
            this.f18836a.f18826b.f18806b.finish(OutReturn.creatRunTimeErrRet(e.toString()));
            this.f18836a.dismiss();
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C5248c.m25447b(C5218e.f18825e, "vist URL, baseUrl: " + C5243e.m25426b(str));
        if (C5218e.m25363b(str, this.f18836a.f18829f)) {
            Bundle c = C5245a.m25434c(str);
            if (c.containsKey("access_token") && !c.containsKey(HwAccountConstants.EXTRA_OPLOG_ERROR)) {
                this.f18836a.f18826b.f18806b.finish(OutReturn.addSuccessCode(c));
            } else if (C5227a.m25371a(c)) {
                this.f18836a.dismiss();
                C5227a.m25370a(this.f18836a.f18826b);
            } else {
                this.f18836a.f18826b.f18806b.finish(OutReturn.addFailCode(c, 1000));
            }
            this.f18836a.dismiss();
        } else {
            webView.loadUrl(str);
        }
        return true;
    }
}
