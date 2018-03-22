package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.tencent.connect.p193b.C6284w;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import com.tencent.open.p543c.C6386a;
import com.tencent.tauth.C6252b;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class C6371a extends C6370j {
    static final LayoutParams f22157a = new LayoutParams(-1, -1);
    static Toast f22158b = null;
    private static WeakReference<ProgressDialog> f22159f;
    private WeakReference<Context> f22160e;
    private String f22161g;
    private C6416e f22162h;
    private C6252b f22163i;
    private FrameLayout f22164j;
    private C6386a f22165k;
    private Handler f22166l;
    private boolean f22167m = false;
    private C6284w f22168n = null;

    public C6371a(Context context, String str, String str2, C6252b c6252b, C6284w c6284w) {
        super(context, 16973840);
        this.f22160e = new WeakReference(context);
        this.f22161g = str2;
        this.f22162h = new C6416e(context, str, str2, c6284w.m28849b(), c6252b);
        this.f22166l = new C6417f(this, this.f22162h, context.getMainLooper());
        this.f22163i = c6252b;
        this.f22168n = c6284w;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        m29123a();
        m29126b();
    }

    public void onBackPressed() {
        if (this.f22162h != null) {
            this.f22162h.mo5286a();
        }
        super.onBackPressed();
    }

    private void m29123a() {
        new TextView((Context) this.f22160e.get()).setText("test");
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.f22165k = new C6386a((Context) this.f22160e.get());
        this.f22165k.setLayoutParams(layoutParams);
        this.f22164j = new FrameLayout((Context) this.f22160e.get());
        layoutParams.gravity = 17;
        this.f22164j.setLayoutParams(layoutParams);
        this.f22164j.addView(this.f22165k);
        setContentView(this.f22164j);
    }

    protected void mo5333a(String str) {
        C6367n.m29107b("TDialog", "--onConsoleMessage--");
        try {
            this.c.mo5337a(this.f22165k, str);
        } catch (Exception e) {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void m29126b() {
        this.f22165k.setVerticalScrollBarEnabled(false);
        this.f22165k.setHorizontalScrollBarEnabled(false);
        this.f22165k.setWebViewClient(new C6388c());
        this.f22165k.setWebChromeClient(this.d);
        this.f22165k.clearFormData();
        WebSettings settings = this.f22165k.getSettings();
        if (settings != null) {
            settings.setSavePassword(false);
            settings.setSaveFormData(false);
            settings.setCacheMode(-1);
            settings.setNeedInitialFocus(false);
            settings.setBuiltInZoomControls(true);
            settings.setSupportZoom(true);
            settings.setRenderPriority(RenderPriority.HIGH);
            settings.setJavaScriptEnabled(true);
            if (!(this.f22160e == null || this.f22160e.get() == null)) {
                settings.setDatabaseEnabled(true);
                settings.setDatabasePath(((Context) this.f22160e.get()).getApplicationContext().getDir("databases", 0).getPath());
            }
            settings.setDomStorageEnabled(true);
            this.c.m29277a(new C6415d(), "sdk_js_if");
            this.f22165k.loadUrl(this.f22161g);
            this.f22165k.setLayoutParams(f22157a);
            this.f22165k.setVisibility(4);
            this.f22165k.getSettings().setSavePassword(false);
        }
    }

    private static void m29129c(Context context, String str) {
        try {
            JSONObject d = C6412y.m29260d(str);
            int i = d.getInt("type");
            CharSequence string = d.getString("msg");
            if (i == 0) {
                if (f22158b == null) {
                    f22158b = Toast.makeText(context, string, 0);
                } else {
                    f22158b.setView(f22158b.getView());
                    f22158b.setText(string);
                    f22158b.setDuration(0);
                }
                f22158b.show();
            } else if (i == 1) {
                if (f22158b == null) {
                    f22158b = Toast.makeText(context, string, 1);
                } else {
                    f22158b.setView(f22158b.getView());
                    f22158b.setText(string);
                    f22158b.setDuration(1);
                }
                f22158b.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void m29130d(Context context, String str) {
        if (context != null && str != null) {
            try {
                JSONObject d = C6412y.m29260d(str);
                int i = d.getInt(JoinConstants.ACTION);
                CharSequence string = d.getString("msg");
                if (i == 1) {
                    if (f22159f == null || f22159f.get() == null) {
                        ProgressDialog progressDialog = new ProgressDialog(context);
                        progressDialog.setMessage(string);
                        f22159f = new WeakReference(progressDialog);
                        progressDialog.show();
                        return;
                    }
                    ((ProgressDialog) f22159f.get()).setMessage(string);
                    if (!((ProgressDialog) f22159f.get()).isShowing()) {
                        ((ProgressDialog) f22159f.get()).show();
                    }
                } else if (i == 0 && f22159f != null && f22159f.get() != null && ((ProgressDialog) f22159f.get()).isShowing()) {
                    ((ProgressDialog) f22159f.get()).dismiss();
                    f22159f = null;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
