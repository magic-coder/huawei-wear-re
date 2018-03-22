package com.tencent.connect.p193b;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import com.tencent.open.p543c.C6387b;
import com.tencent.open.web.security.C6421a;
import com.tencent.open.web.security.C6423c;
import com.tencent.tauth.C6252b;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class C6273k extends Dialog {
    private String f21816a;
    private C6279q f21817b;
    private C6252b f21818c;
    private Handler f21819d;
    private FrameLayout f21820e;
    private LinearLayout f21821f;
    private FrameLayout f21822g;
    private ProgressBar f21823h;
    private String f21824i;
    private C6387b f21825j;
    private Context f21826k;
    private C6423c f21827l;
    private boolean f21828m = false;
    private int f21829n;
    private String f21830o;
    private String f21831p;
    private long f21832q = 0;
    private long f21833r = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private HashMap<String, Runnable> f21834s;

    static /* synthetic */ String m28805a(C6273k c6273k, Object obj) {
        String str = c6273k.f21816a + obj;
        c6273k.f21816a = str;
        return str;
    }

    static {
        try {
            Context a = C6395h.m29184a();
            if (a == null) {
                C6367n.m29107b("openSDK_LOG.authDlg", "-->load wbsafeedit lib fail, because context is null.");
            } else if (new File(a.getFilesDir().toString() + "/" + "libwbsafeedit.so").exists()) {
                System.load(a.getFilesDir().toString() + "/" + "libwbsafeedit.so");
                C6367n.m29107b("openSDK_LOG.authDlg", "-->load wbsafeedit lib success.");
            } else {
                C6367n.m29107b("openSDK_LOG.authDlg", "-->load wbsafeedit lib fail, because so is not exists.");
            }
        } catch (Throwable e) {
            C6367n.m29108b("openSDK_LOG.authDlg", "-->load wbsafeedit lib error.", e);
        }
    }

    public C6273k(Context context, String str, String str2, C6252b c6252b, C6284w c6284w) {
        super(context, 16973840);
        this.f21826k = context;
        this.f21816a = str2;
        this.f21817b = new C6279q(this, str, str2, c6284w.m28849b(), c6252b);
        this.f21819d = new C6280r(this, this.f21817b, context.getMainLooper());
        this.f21818c = c6252b;
        this.f21824i = str;
        this.f21827l = new C6423c();
        getWindow().setSoftInputMode(32);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        m28811b();
        m28818d();
        this.f21834s = new HashMap();
    }

    public void onBackPressed() {
        if (!this.f21828m) {
            this.f21817b.mo5286a();
        }
        super.onBackPressed();
    }

    protected void onStop() {
        super.onStop();
    }

    private String m28807a(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.f21831p) && this.f21831p.length() >= 4) {
            stringBuilder.append("_u_").append(this.f21831p.substring(this.f21831p.length() - 4));
        }
        return stringBuilder.toString();
    }

    private String m28804a() {
        String str = "http://qzs.qq.com/open/mobile/login/qzsjump.html?" + this.f21816a.substring(this.f21816a.indexOf(LocationInfo.NA) + 1);
        C6367n.m29110c("openSDK_LOG.authDlg", "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        return str;
    }

    private void m28811b() {
        m28815c();
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f21825j = new C6387b(this.f21826k);
        this.f21825j.setLayoutParams(layoutParams);
        this.f21820e = new FrameLayout(this.f21826k);
        layoutParams.gravity = 17;
        this.f21820e.setLayoutParams(layoutParams);
        this.f21820e.addView(this.f21825j);
        this.f21820e.addView(this.f21822g);
        setContentView(this.f21820e);
    }

    private void m28815c() {
        LayoutParams layoutParams;
        this.f21823h = new ProgressBar(this.f21826k);
        this.f21823h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f21821f = new LinearLayout(this.f21826k);
        View view = null;
        if (this.f21824i.equals("action_login")) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            view = new TextView(this.f21826k);
            if (Locale.getDefault().getLanguage().equals(PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH)) {
                view.setText("登录中...");
            } else {
                view.setText("Logging in...");
            }
            view.setTextColor(Color.rgb(255, 255, 255));
            view.setTextSize(18.0f);
            view.setLayoutParams(layoutParams);
        }
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f21821f.setLayoutParams(layoutParams);
        this.f21821f.addView(this.f21823h);
        if (view != null) {
            this.f21821f.addView(view);
        }
        this.f21822g = new FrameLayout(this.f21826k);
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = 80;
        layoutParams2.rightMargin = 80;
        layoutParams2.topMargin = 40;
        layoutParams2.bottomMargin = 40;
        layoutParams2.gravity = 17;
        this.f21822g.setLayoutParams(layoutParams2);
        this.f21822g.setBackgroundResource(17301504);
        this.f21822g.addView(this.f21821f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void m28818d() {
        this.f21825j.setVerticalScrollBarEnabled(false);
        this.f21825j.setHorizontalScrollBarEnabled(false);
        this.f21825j.setWebViewClient(new C6277o());
        this.f21825j.setWebChromeClient(new WebChromeClient());
        this.f21825j.clearFormData();
        this.f21825j.clearSslPreferences();
        this.f21825j.setOnLongClickListener(new C6274l(this));
        this.f21825j.setOnTouchListener(new C6275m(this));
        WebSettings settings = this.f21825j.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f21826k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        C6367n.m29107b("openSDK_LOG.authDlg", "-->mUrl : " + this.f21816a);
        this.f21830o = this.f21816a;
        this.f21825j.loadUrl(this.f21816a);
        this.f21825j.setVisibility(4);
        this.f21825j.getSettings().setSavePassword(false);
        this.f21827l.m29277a(new C6421a(), "SecureJsInterface");
        C6421a.f22286a = false;
        super.setOnDismissListener(new C6276n(this));
    }

    private boolean m28820e() {
        C6282t a = C6282t.m28838a();
        String c = a.m28845c();
        C6283u c6283u = new C6283u();
        c6283u.f21854a = this.f21818c;
        c6283u.f21855b = this;
        c6283u.f21856c = c;
        String a2 = a.m28842a(c6283u);
        String substring = this.f21816a.substring(0, this.f21816a.indexOf(LocationInfo.NA));
        Bundle b = C6412y.m29250b(this.f21816a);
        b.putString("token_key", c);
        b.putString("serial", a2);
        b.putString("browser", "1");
        this.f21816a = substring + LocationInfo.NA + C6412y.m29241a(b);
        return C6412y.m29249a(this.f21826k, this.f21816a);
    }

    private static void m28812b(Context context, String str) {
        try {
            JSONObject d = C6412y.m29260d(str);
            int i = d.getInt("type");
            Toast.makeText(context.getApplicationContext(), d.getString("msg"), i).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void m28832a(String str, String str2) {
        this.f21825j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }

    public void dismiss() {
        this.f21834s.clear();
        this.f21819d.removeCallbacksAndMessages(null);
        if (isShowing()) {
            super.dismiss();
        }
        if (this.f21825j != null) {
            this.f21825j.destroy();
            this.f21825j = null;
        }
    }
}
