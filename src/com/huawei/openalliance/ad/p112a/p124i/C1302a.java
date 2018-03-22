package com.huawei.openalliance.ad.p112a.p124i;

import android.app.ActionBar;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1229o;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p124i.C1304c.C1301a;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;

public class C1302a extends RelativeLayout implements C1301a {
    private WebView f2801a;
    private C1304c f2802b;
    private C1290a f2803c;
    private ProgressBar f2804d;
    private C1307d f2805e;
    private String f2806f;
    private ActionBar f2807g;
    private C1229o f2808h;
    private String f2809i;

    public interface C1290a {
        void onDetailClose();
    }

    public interface C1291b {
        void onOperation();
    }

    public C1302a(Context context, String str, C1229o c1229o, String str2) {
        super(context);
        this.f2806f = str;
        this.f2808h = c1229o;
        this.f2809i = str2;
        m5791a(context);
    }

    public C1302a(Context context, String str, C1229o c1229o, String str2, ActionBar actionBar) {
        super(context);
        this.f2806f = str;
        this.f2808h = c1229o;
        this.f2809i = str2;
        this.f2807g = actionBar;
        m5791a(context);
    }

    @SuppressWarnings(justification = "h00193325/In some HUAWEI developing phones, the WebView led to the problem of crash, in order to prevent uncontrolled anomalies, add protection", value = {"REC_CATCH_EXCEPTION"})
    private void m5791a(Context context) {
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        if (VERSION.SDK_INT >= 21) {
            instance.removeSessionCookies(null);
        } else {
            instance.removeSessionCookie();
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        this.f2804d = new ProgressBar(context);
        if (this.f2807g == null) {
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, C1287e.m5678a(context, 48.0f));
            layoutParams2.addRule(10, -1);
            this.f2802b = new C1304c(context);
            this.f2802b.setId(1001);
            LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.addRule(3, 1001);
            addView(this.f2802b, layoutParams2);
            this.f2802b.m5798a((C1301a) this);
            try {
                this.f2801a = new WebView(context);
                addView(this.f2801a, layoutParams3);
                addView(this.f2804d, layoutParams);
                this.f2805e = new C1307d(context, this.f2806f, this.f2808h, this.f2809i, this.f2801a, this.f2804d, this.f2802b);
                this.f2805e.m5807a();
                this.f2805e.m5809b();
                return;
            } catch (Exception e) {
                C1336d.m5888c("AdDetailView", "fail to create detail");
                return;
            }
        }
        layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(10, -1);
        try {
            this.f2801a = new WebView(context);
            addView(this.f2801a, layoutParams2);
            addView(this.f2804d, layoutParams);
            this.f2805e = new C1307d(context, this.f2806f, this.f2808h, this.f2809i, this.f2801a, this.f2804d, this.f2807g);
            this.f2805e.m5807a();
            this.f2805e.m5809b();
        } catch (Exception e2) {
            C1336d.m5888c("AdDetailView", "fail to create detail");
        }
    }

    public void mo2447a() {
        if (this.f2803c != null) {
            this.f2803c.onDetailClose();
        }
    }

    public void m5793a(C1290a c1290a) {
        this.f2803c = c1290a;
    }

    public void m5794a(C1291b c1291b) {
        this.f2805e.m5808a(c1291b);
    }
}
