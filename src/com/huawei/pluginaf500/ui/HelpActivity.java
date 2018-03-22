package com.huawei.pluginaf500.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.pluginaf500.c;
import com.huawei.pluginaf500.d;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import java.util.ArrayList;
import java.util.List;

public class HelpActivity extends AF500BaseActivity {
    LayoutInflater f19739a;
    private final int f19740b = 1;
    private final int f19741c = 2;
    private final int f19742d = 3;
    private int f19743g = 1;
    private Button f19744h;
    private Button f19745i;
    private Button f19746j;
    private ViewPager f19747k;
    private ViewPager f19748l;
    private an f19749m;
    private an f19750n;
    private List<View> f19751o = new ArrayList();
    private List<View> f19752p = new ArrayList();
    private int[] f19753q = new int[]{f.viewpager_guide_item1, f.viewpager_guide_item2, f.viewpager_guide_item3, f.viewpager_guide_item4};
    private int[] f19754r = new int[]{f.viewpager_bt_item1, f.viewpager_bt_item2, f.viewpager_bt_item3, f.viewpager_bt_item4};
    private int[] f19755s = new int[]{e.dot1, e.dot2, e.dot3, e.dot4, e.dot5};
    private RelativeLayout f19756t;
    private FrameLayout f19757u = null;
    private WebView f19758v = null;
    private final String f19759w = "file:///android_asset/note.html";

    private FrameLayout m26717j() {
        if (this.f19757u == null) {
            this.f19757u = (FrameLayout) findViewById(e.webview_container);
        }
        return this.f19757u;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
        m26718k();
        if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
            findViewById(e.kitket).setVisibility(0);
        }
        ((ImageView) findViewById(e.dot5)).setVisibility(8);
    }

    private void m26718k() {
        this.f19756t = (RelativeLayout) findViewById(e.explain);
        this.f19744h = (Button) findViewById(e.btn_guide);
        this.f19745i = (Button) findViewById(e.btn_bt);
        this.f19746j = (Button) findViewById(e.btn_explain);
        this.f19747k = (ViewPager) findViewById(e.guidepager);
        this.f19748l = (ViewPager) findViewById(e.btpager);
        this.f19739a = getLayoutInflater();
        this.f19744h.setSelected(true);
        for (int inflate : this.f19753q) {
            this.f19751o.add(this.f19739a.inflate(inflate, null));
        }
        for (int inflate2 : this.f19754r) {
            this.f19752p.add(this.f19739a.inflate(inflate2, null));
        }
        this.f19749m = new an(this.f19751o);
        this.f19750n = new an(this.f19752p);
        this.f19747k.setAdapter(this.f19749m);
        this.f19748l.setAdapter(this.f19750n);
        this.f19747k.setOnPageChangeListener(new al(this));
        this.f19748l.setOnPageChangeListener(new al(this));
        this.f19758v = new WebView(this);
        WebSettings settings = this.f19758v.getSettings();
        settings.setJavaScriptEnabled(false);
        this.f19758v.setWebViewClient(new am(this));
        this.f19758v.loadUrl("file:///android_asset/note.html");
        this.f19758v.setLayerType(1, null);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setAllowFileAccess(false);
        this.f19758v.setInitialScale(TransportMediator.KEYCODE_MEDIA_RECORD);
        m26717j().addView(this.f19758v);
    }

    public void Button_Click(View view) {
        int id = view.getId();
        if (id == this.f19744h.getId()) {
            this.f19744h.setSelected(true);
            this.f19746j.setSelected(false);
            this.f19745i.setSelected(false);
            this.f19743g = 1;
        } else if (id == this.f19745i.getId()) {
            this.f19744h.setSelected(false);
            this.f19746j.setSelected(false);
            this.f19745i.setSelected(true);
            this.f19743g = 2;
        } else if (id == this.f19746j.getId()) {
            this.f19744h.setSelected(false);
            this.f19746j.setSelected(true);
            this.f19745i.setSelected(false);
            this.f19743g = 3;
        }
        m26719l();
        m26716b(id);
    }

    private void m26716b(int i) {
        this.f19747k.setVisibility(8);
        this.f19748l.setVisibility(8);
        this.f19756t.setVisibility(8);
        if (i == this.f19744h.getId()) {
            this.f19747k.setVisibility(0);
            ((ImageView) findViewById(this.f19755s[this.f19747k.getCurrentItem()])).setImageDrawable(getResources().getDrawable(d.point_sel));
        } else if (i == this.f19745i.getId()) {
            this.f19748l.setVisibility(0);
            ((ImageView) findViewById(this.f19755s[this.f19748l.getCurrentItem()])).setImageDrawable(getResources().getDrawable(d.point_sel));
        } else if (i == this.f19746j.getId()) {
            this.f19756t.setVisibility(0);
        }
    }

    private void m26719l() {
        int i;
        for (i = 0; i < this.f19755s.length; i++) {
            ((ImageView) findViewById(this.f19755s[i])).setImageDrawable(getResources().getDrawable(d.point_unsel));
            ((ImageView) findViewById(this.f19755s[i])).setVisibility(8);
        }
        if (this.f19743g == 1) {
            for (int findViewById : this.f19755s) {
                ((ImageView) findViewById(findViewById)).setVisibility(0);
            }
        } else if (this.f19743g == 2) {
            for (i = 0; i < 5; i++) {
                ((ImageView) findViewById(this.f19755s[i])).setVisibility(0);
            }
        }
        ((ImageView) findViewById(e.dot5)).setVisibility(8);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (m26717j() != null) {
            m26717j().removeAllViews();
        }
        this.f19757u = null;
        if (this.f19758v != null) {
            this.f19758v.setVisibility(8);
            this.f19758v.destroy();
        }
        this.f19758v = null;
        getWindow().clearFlags(ViewCompat.MEASURED_STATE_TOO_SMALL);
    }

    protected void onResume() {
        super.onResume();
    }

    protected int mo5104a() {
        return f.act_help;
    }

    protected int mo5114f() {
        return getResources().getDimensionPixelSize(c.help_title_height);
    }
}
