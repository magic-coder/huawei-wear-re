package com.tencent.open.yyb;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ZoomButtonsController;
import com.tencent.connect.p193b.C6284w;
import com.tencent.connect.share.C6294a;
import com.tencent.connect.share.C6298d;
import com.tencent.open.p532d.C6406s;
import com.tencent.open.p541a.C6367n;
import com.tencent.open.p543c.C6386a;
import com.tencent.tauth.C6493c;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class AppbarActivity extends Activity implements OnClickListener {
    private static ArrayList<String> f22291l = new ArrayList();
    protected ProgressDialog f22292a;
    private C6386a f22293b;
    private LinearLayout f22294c;
    private C6437m f22295d;
    private C6435k f22296e;
    private C6434j f22297f;
    private ShareModel f22298g;
    private C6493c f22299h;
    private C6284w f22300i;
    private String f22301j;
    private String f22302k;
    private final DownloadListener f22303m = new C6430e(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f22301j = getIntent().getStringExtra("appid");
        this.f22302k = getIntent().getStringExtra("url");
        C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)onCreate : appid = " + this.f22301j + " url = " + this.f22302k);
        this.f22293b = new C6386a(this);
        this.f22297f = new C6434j(this, this.f22293b);
        m29299e();
        m29300f();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        C6435k k = m29305k();
        if (k != null && k.isShowing()) {
            k.dismiss();
        }
    }

    public void onBackPressed() {
        C6435k k = m29305k();
        if (k == null || !k.isShowing()) {
            super.onBackPressed();
        } else {
            k.dismiss();
        }
    }

    private void m29299e() {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f22293b.setLayoutParams(layoutParams);
        this.f22294c = new LinearLayout(this);
        layoutParams.gravity = 17;
        this.f22294c.setLayoutParams(layoutParams);
        this.f22294c.setOrientation(1);
        this.f22295d = new C6437m(this);
        this.f22295d.getBackBtn().setOnClickListener(this);
        this.f22295d.getSharBtn().setOnClickListener(this);
        this.f22294c.addView(this.f22295d);
        this.f22294c.addView(this.f22293b);
        setContentView(this.f22294c);
    }

    private void m29300f() {
        Method method;
        WebSettings settings = this.f22293b.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setUserAgentString(settings.getUserAgentString() + "/" + "qqdownloader/" + this.f22297f.m29335b() + "/sdk");
        settings.setJavaScriptEnabled(true);
        Class cls = settings.getClass();
        try {
            method = cls.getMethod("setPluginsEnabled", new Class[]{Boolean.TYPE});
            if (method != null) {
                method.invoke(settings, new Object[]{Boolean.valueOf(true)});
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            method = cls.getMethod("setDomStorageEnabled", new Class[]{Boolean.TYPE});
            if (method != null) {
                method.invoke(settings, new Object[]{Boolean.valueOf(true)});
            }
        } catch (SecurityException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
        } catch (IllegalArgumentException e4) {
        } catch (IllegalAccessException e5) {
        } catch (InvocationTargetException e6) {
        }
        settings.setAppCachePath(m29304j());
        settings.setDatabasePath(m29304j());
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        if (m29301g()) {
            settings.setUseWideViewPort(true);
            if (VERSION.SDK_INT >= 7) {
                try {
                    cls.getMethod("setLoadWithOverviewMode", new Class[]{Boolean.TYPE}).invoke(settings, new Object[]{Boolean.valueOf(true)});
                } catch (Exception e7) {
                }
            }
            if (C6406s.m29224b()) {
                if (C6406s.m29216a() < 11) {
                    try {
                        Field declaredField = WebView.class.getDeclaredField("mZoomButtonsController");
                        declaredField.setAccessible(true);
                        ZoomButtonsController zoomButtonsController = new ZoomButtonsController(this.f22293b);
                        zoomButtonsController.getZoomControls().setVisibility(8);
                        declaredField.set(this.f22293b, zoomButtonsController);
                    } catch (Exception e8) {
                    }
                } else {
                    try {
                        this.f22293b.getSettings().getClass().getMethod("setDisplayZoomControls", new Class[]{Boolean.TYPE}).invoke(this.f22293b.getSettings(), new Object[]{Boolean.valueOf(false)});
                    } catch (Exception e9) {
                    }
                }
            }
        }
        this.f22293b.setWebViewClient(new C6433i());
        this.f22293b.setWebChromeClient(new C6432h());
        this.f22293b.setDownloadListener(this.f22303m);
        this.f22293b.loadUrl(this.f22302k);
    }

    static {
        f22291l.add("MT870");
        f22291l.add("XT910");
        f22291l.add("XT928");
        f22291l.add("MT917");
        f22291l.add("Lenovo A60");
    }

    private boolean m29301g() {
        String str = Build.MODEL;
        return (str.contains("vivo") || f22291l.contains(str)) ? false : true;
    }

    private C6493c m29302h() {
        if (this.f22299h == null) {
            this.f22299h = C6493c.m29622a(this.f22301j, (Context) this);
        }
        return this.f22299h;
    }

    private C6284w m29303i() {
        if (this.f22300i == null) {
            this.f22300i = m29302h().m29627b();
        }
        return this.f22300i;
    }

    private String m29304j() {
        return m29291a("/webview_cache");
    }

    private String m29291a(String str) {
        String l = m29306l();
        if (!TextUtils.isEmpty(str)) {
            l = l + str;
        }
        return m29292a(l, false);
    }

    private C6435k m29305k() {
        if (this.f22296e == null) {
            this.f22296e = new C6435k(this);
            this.f22296e.setCanceledOnTouchOutside(true);
            this.f22296e.m29341a().setOnClickListener(this);
            this.f22296e.m29342b().setOnClickListener(this);
        }
        return this.f22296e;
    }

    private String m29306l() {
        String str;
        if (m29307m()) {
            str = Environment.getExternalStorageDirectory().getPath() + "/tencent/tassistant";
        } else {
            File filesDir = getFilesDir();
            if (filesDir == null) {
                return "";
            }
            str = filesDir.getAbsolutePath() + "/tencent/tassistant";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private boolean m29307m() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageDirectory().canWrite()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String m29292a(String str, boolean z) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
            if (z) {
                try {
                    new File(str + File.separator + ".nomedia").createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file.getAbsolutePath();
    }

    private void m29294a(boolean z) {
        if (this.f22293b != null) {
            this.f22293b.getSettings().setSupportZoom(z);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f22293b != null) {
            this.f22293b.removeAllViews();
            this.f22293b.setVisibility(8);
            this.f22293b.stopLoading();
            this.f22293b.clearHistory();
            this.f22293b.destroy();
        }
    }

    public void onClick(View view) {
        C6435k k = m29305k();
        if (view == this.f22295d.getSharBtn()) {
            this.f22297f.m29328a();
        } else if (view == k.m29341a()) {
            m29308a();
        } else if (view == k.m29342b()) {
            m29310b();
        } else if (view == k.m29343c()) {
            m29311c();
        } else if (view == k.m29344d()) {
            m29312d();
        } else if (view == this.f22295d.getBackBtn()) {
            finish();
        }
    }

    public void m29308a() {
        C6284w i = m29303i();
        if (i != null) {
            C6294a c6294a = new C6294a(this, i);
            Bundle bundle = new Bundle();
            bundle.putString("title", this.f22298g.f22304a);
            bundle.putString("targetUrl", this.f22298g.f22307d);
            bundle.putString("summary", this.f22298g.f22305b);
            bundle.putString("imageUrl", this.f22298g.f22306c);
            C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)shareToQQ : model.mTitle = " + this.f22298g.f22304a);
            C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)shareToQQ : model.mTargetUrl = " + this.f22298g.f22307d);
            C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)shareToQQ : model.mDescription = " + this.f22298g.f22305b);
            C6367n.m29107b("openSDK_LOG", "-->(AppbarActivity)shareToQQ : model.mIconUrl = " + this.f22298g.f22306c);
            c6294a.m28886a(this, bundle, new C6426b(this, i));
            C6438n.m29355a(i.m28849b(), "200", "SDK.APPBAR.HOME.SHARE.QQ");
        }
    }

    public void m29310b() {
        C6284w i = m29303i();
        if (i != null) {
            C6298d c6298d = new C6298d(this, i);
            Bundle bundle = new Bundle();
            bundle.putInt("req_type", 1);
            bundle.putString("title", this.f22298g.f22304a);
            bundle.putString("summary", this.f22298g.f22305b);
            bundle.putString("targetUrl", this.f22298g.f22307d);
            ArrayList arrayList = new ArrayList();
            C6367n.m29107b("openSDK_LOG", "-->shareToQzone : mIconUrl = " + this.f22298g.f22306c);
            arrayList.add(this.f22298g.f22306c);
            bundle.putStringArrayList("imageUrl", arrayList);
            c6298d.m28897a(this, bundle, new C6427c(this, i));
            C6438n.m29355a(i.m28849b(), "200", "SDK.APPBAR.HOME.SHARE.QZ");
        }
    }

    public void m29311c() {
        m29296b(false);
    }

    public void m29312d() {
        m29296b(true);
    }

    private void m29296b(boolean z) {
        C6367n.m29107b("openSDK_LOG", "-->shareToWX : wx_appid = wx8e8dc60535c9cd93");
        if (!TextUtils.isEmpty(this.f22298g.f22306c)) {
            m29309a(this, "", "");
            new C6431g(new C6429d(this)).execute(new String[]{this.f22298g.f22306c});
        }
    }

    protected void m29309a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "请稍候";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "正在加载...";
        }
        this.f22292a = ProgressDialog.show(context, str, str2);
        this.f22292a.setCancelable(true);
    }
}
