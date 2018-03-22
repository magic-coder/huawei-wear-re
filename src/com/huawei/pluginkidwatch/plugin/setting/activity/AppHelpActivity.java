package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.base.KidWatchBaseTitleWebActivity;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;

public class AppHelpActivity extends KidWatchBaseTitleWebActivity {
    private Context f6252b;
    private WebView f6253c = null;
    private RelativeLayout f6254d = null;
    private CustomDialog f6255e = null;
    private ProgressBar f6256f;
    private OnClickListener f6257g = null;
    private C1912c f6258h = new C1912c();
    private C1913d f6259i = new C1913d();
    private TextView f6260j;
    private String f6261k = null;
    private String f6262l = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6252b = getBaseContext();
        Intent intent = getIntent();
        this.f6261k = intent.getStringExtra("com.huawei.bone.ui.setting.AppHelpActivity.APP_HELP_BASE_URL");
        int intExtra = intent.getIntExtra("com.huawei.bone.ui.setting.AppHelpActivity.JUMP_MODE_KEY", -1);
        this.f6260j = (TextView) findViewById(g.app_help_title);
        m9716a(intExtra);
        this.f6256f = (ProgressBar) findViewById(g.load_help_url_progress);
        m9726l();
        m9725k();
        this.f6254d = (RelativeLayout) findViewById(g.help_retry);
        if (m9721c(this.f6252b)) {
            m9722d(this.f6252b);
        } else {
            m9728n();
        }
    }

    private void m9725k() {
        this.f6257g = new C1910a(this);
    }

    private void m9726l() {
        this.f6253c = (WebView) findViewById(g.sns_app_help_web);
        this.f6253c.getSettings().setJavaScriptEnabled(true);
        this.f6253c.getSettings().setSupportZoom(true);
        if (VERSION.SDK_INT >= 19) {
            m9727m();
        }
        this.f6253c.setLayerType(1, null);
        this.f6253c.getSettings().setSavePassword(false);
        this.f6253c.getSettings().setAllowFileAccess(false);
        this.f6253c.setWebViewClient(this.f6259i);
        this.f6253c.setWebChromeClient(this.f6258h);
        this.f6253c.setDownloadListener(new C1911b());
    }

    private void m9727m() {
        if (C1492l.m6916b(this.f6252b)) {
            this.f6253c.getSettings().setCacheMode(-1);
        } else {
            this.f6253c.getSettings().setCacheMode(1);
        }
    }

    protected int mo2628j() {
        return h.activity_app_help;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void m9716a(int i) {
        switch (i) {
            case 0:
                this.f6260j.setText(C1680l.IDS_plugin_kidwatch_settings_about_help);
                return;
            case 1:
                this.f6260j.setText(C1680l.IDS_plugin_kidwatch_settings_hufen_club);
                return;
            case 2:
                this.f6260j.setText(C1680l.IDS_plugin_kidwatch_settings_about_help);
                return;
            case 3:
                this.f6260j.setText(C1680l.IDS_plugin_kidwatch_menu_disney_world);
                return;
            default:
                return;
        }
    }

    private void m9722d(Context context) {
        C1595v c1595v = new C1595v(this);
        c1595v.m7351b(getResources().getString(C1680l.IDS_plugin_kidwatch_settings_help_3gnet_diag_conent));
        c1595v.m7345a(getResources().getString(C1680l.IDS_plugin_kidwatch_common_continue), this.f6257g);
        c1595v.m7350b(getResources().getString(C1680l.IDS_plugin_kidwatch_common_btn_back), this.f6257g);
        this.f6255e = c1595v.m7338a();
        this.f6255e.show();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f6253c.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        int i2;
        C2538c.m12674b("AppHelpActivity", "onKeyDown", " KeyEvent.KEYCODE_BACK" + i);
        WebBackForwardList copyBackForwardList = this.f6253c.copyBackForwardList();
        C2538c.m12674b("AppHelpActivity", "WebBackForwardList", " backList.getSize()" + copyBackForwardList.getSize());
        if (copyBackForwardList.getSize() > 1) {
            int size = copyBackForwardList.getSize() - 2;
            i2 = 1;
            while (size >= 0) {
                if (copyBackForwardList.getItemAtIndex(size) != null) {
                    if (!copyBackForwardList.getItemAtIndex(size).getUrl().equals("about:blank") && !copyBackForwardList.getItemAtIndex(size).getUrl().equals("file:///android_asset/nullblank.html")) {
                        break;
                    }
                    i2++;
                }
                size--;
            }
        } else {
            i2 = 1;
        }
        C2538c.m12674b("AppHelpActivity", "onKeyDown ", "count" + i2);
        if (i2 <= 1 || !this.f6253c.canGoBackOrForward(-i2)) {
            this.f6253c.goBack();
            return false;
        }
        this.f6253c.goBackOrForward(-i2);
        return false;
    }

    public boolean mo2627b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    public static boolean m9721c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return true;
    }

    private void m9728n() {
        if (!mo2627b(this.f6252b)) {
            m9729o();
            m9719b(getString(C1680l.IDS_plugin_kidwatch_settings_userinfo_update_failed));
        } else if (this.f6262l != null) {
            m9717a(this.f6262l);
            this.f6262l = null;
        } else {
            m9717a(this.f6261k);
        }
    }

    private void m9717a(String str) {
        if (str.startsWith("http://cn.club.vmall.com/") || str.equals("http://club.huawei.com/cn/forum-1421-1.html") || str.startsWith("http://health.vmall.com/help/") || str.equals("http://www.dol.cn/minisite/index.aspx") || str.startsWith("https://health.vmall.com/help/userimprovement/index.jsp") || str.startsWith("http://club.huawei.com/forum-2405-1.html")) {
            this.f6253c.loadUrl(str);
            return;
        }
        C2538c.m12674b("AppHelpActivity", "This url is illeagle:" + str);
    }

    private void m9719b(String str) {
        C1483c.m6832c(this.f6252b, str);
    }

    private void m9729o() {
        this.f6253c.loadUrl("file:///android_asset/nullblank.html");
        this.f6254d.setVisibility(0);
    }

    private void m9730p() {
        this.f6254d.setVisibility(8);
    }

    public void onWebRetryClick(View view) {
        m9728n();
    }
}
