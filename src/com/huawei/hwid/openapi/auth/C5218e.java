package com.huawei.hwid.openapi.auth;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.hwid.openapi.out.OutReturn;
import com.huawei.hwid.openapi.p440a.C5212a;
import com.huawei.hwid.openapi.p440a.C5213b;
import com.huawei.hwid.openapi.p445e.C5248c;
import com.huawei.hwid.openapi.p445e.C5250e;
import com.huawei.hwid.openapi.p445e.p446a.C5243e;
import com.huawei.hwid.openapi.p445e.p447b.C5245a;
import com.huawei.hwid.openapi.p445e.p448c.C5247a;
import com.sina.weibo.sdk.constant.WBConstants;
import java.net.URL;

public class C5218e extends Dialog {
    static final LayoutParams f18824a = new LayoutParams(-1, -1);
    private static final String f18825e = C5213b.f18818a;
    C5212a f18826b;
    RelativeLayout f18827c = null;
    C5222i f18828d = null;
    private String f18829f;
    private ProgressDialog f18830g;
    private WebView f18831h;
    private FrameLayout f18832i;
    private Handler f18833j = null;

    public C5218e(C5212a c5212a, String str) {
        super(c5212a.f18805a, 16973840);
        C5248c.m25447b(f18825e, "enter DialogWebAuth baseurl:" + C5243e.m25426b(str));
        this.f18829f = str;
        this.f18826b = c5212a;
    }

    private void m25362b() {
        this.f18827c = new RelativeLayout(getContext());
        this.f18831h = new WebView(getContext());
        this.f18831h.setVerticalScrollBarEnabled(false);
        this.f18831h.setHorizontalScrollBarEnabled(false);
        this.f18831h.getSettings().setJavaScriptEnabled(true);
        this.f18831h.addJavascriptInterface(this, "webLoader");
        this.f18831h.setWebViewClient(new C5221h());
        this.f18831h.loadUrl(this.f18829f);
        this.f18831h.setLayoutParams(f18824a);
        this.f18831h.setVisibility(4);
        this.f18831h.getSettings().setSavePassword(false);
        this.f18831h.setDownloadListener(new C5220g(this));
        this.f18827c.addView(this.f18831h);
        this.f18832i.addView(this.f18827c, f18824a);
        this.f18833j = new Handler();
        this.f18828d = new C5222i(this.f18826b, this.f18830g, this.f18833j);
    }

    private static boolean m25363b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            String string = C5245a.m25434c(str2).getString(WBConstants.AUTH_PARAMS_REDIRECT_URL);
            C5248c.m25446a(f18825e, "reUrl:" + C5243e.m25426b(string) + " tokenRspUrl:" + C5243e.m25426b(str), null);
            if ("oob".equals(string)) {
                return str.startsWith("https://login.vmall.com/oauth2/oob#");
            }
            URL url = new URL(string);
            string = url.getHost();
            C5248c.m25448b(f18825e, "tokenRspUrl:" + C5243e.m25426b(str) + " compareUrl:" + url.getProtocol() + "://" + string, null);
            return str.startsWith(url.getProtocol() + "://" + string);
        } catch (Throwable e) {
            C5248c.m25448b(f18825e, e.toString(), e);
            return false;
        }
    }

    private void m25364c() {
        this.f18826b.f18806b.finish(OutReturn.creatReturn(2, "user cancel the operation"));
        dismiss();
    }

    public void dismiss() {
        try {
            this.f18830g.dismiss();
            C5250e.m25456c(getContext());
            if (this.f18831h != null) {
                this.f18831h.stopLoading();
                this.f18831h.clearHistory();
                if (this.f18827c != null) {
                    this.f18827c.removeView(this.f18831h);
                }
                this.f18831h.removeAllViews();
                this.f18831h.freeMemory();
                this.f18831h.destroy();
                this.f18831h = null;
            }
            if (this.f18827c != null) {
                this.f18827c.removeAllViews();
                this.f18827c = null;
            }
            this.f18828d.m25367a();
            super.dismiss();
        } catch (Throwable e) {
            C5248c.m25448b(f18825e, e.toString(), e);
        }
    }

    public void onBackPressed() {
        try {
            if (this.f18831h != null) {
                this.f18831h.stopLoading();
            }
            if (this.f18830g != null) {
                this.f18830g.dismiss();
            }
            if (this.f18831h == null || !this.f18831h.canGoBack()) {
                m25364c();
                super.onBackPressed();
                return;
            }
            this.f18831h.goBack();
        } catch (Throwable e) {
            C5248c.m25448b(f18825e, e.toString(), e);
            this.f18826b.f18806b.finish(OutReturn.creatRunTimeErrRet(e.toString()));
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f18830g = new ProgressDialog(this.f18826b.f18805a);
        this.f18830g.requestWindowFeature(1);
        this.f18830g.setMessage(C5247a.m25440a(HWDeviceDFXConstants.ERROR_CODE_GET_FILE_NAME_ERROR));
        this.f18830g.setCanceledOnTouchOutside(false);
        this.f18830g.setOnCancelListener(new C5219f(this));
        requestWindowFeature(1);
        this.f18832i = new FrameLayout(getContext());
        m25362b();
        addContentView(this.f18832i, f18824a);
    }
}
