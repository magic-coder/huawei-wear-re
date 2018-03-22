package com.huawei.sim.esim.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.datatypes.C4744k;
import com.huawei.p190v.C2538c;
import com.huawei.sim.C4501b;
import com.huawei.sim.C5898a;
import com.huawei.sim.d;
import com.huawei.sim.e;
import com.huawei.sim.esim.p505b.C5900a;
import com.huawei.sim.esim.view.p507a.C5920a;
import com.huawei.sim.f;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.sim.i;
import com.huawei.sim.j;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.p514d.C5999c;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;

import java.util.ArrayList;

public class EsimProfileAcitvity extends BaseActivity {
    private ListView f20347a;
    private C4744k f20348b;
    private ArrayList<C5900a> f20349c = new ArrayList();
    private Boolean f20350d;
    private C6002a f20351e = null;
    private C5920a f20352f;
    private View f20353g;
    private View f20354h;
    private View f20355i;
    private ImageView f20356j;
    private int f20357k = 3;
    private View f20358l;
    private View f20359m;
    private TextView f20360n;
    private ImageView f20361o;
    private ImageView f20362p;
    private CustomTitleBar f20363q;
    private View f20364r;
    private ImageView f20365s;
    private boolean f20366t = true;
    private C4501b f20367u;
    private IBaseResponseCallback f20368v = new ac(this);
    private Handler f20369w = new ad(this);
    private IBaseResponseCallback f20370x = new ae(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.activity_esim_profile);
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("eSim_profile");
            if (stringExtra != null) {
                this.f20348b = (C4744k) new Gson().fromJson(stringExtra, C4744k.class);
            }
            this.f20350d = Boolean.valueOf(intent.getBooleanExtra("conform_status", false));
        }
        m27243e();
        m27242d();
        this.f20367u = (C4501b) C5898a.m27101a((Context) this).getAdapter();
        if (this.f20367u == null) {
            C2538c.e("EsimProfileAcitvity", new Object[]{"null == pluginSimAdapter"});
            return;
        }
        this.f20367u.mo4468a(this.f20370x);
    }

    protected void onResume() {
        super.onResume();
        if (this.f20367u == null) {
            C2538c.e("EsimProfileAcitvity", new Object[]{"pluginSimAdapter = null"});
            this.f20357k = 3;
        } else {
            this.f20357k = this.f20367u.mo4474b();
        }
        if (2 == this.f20357k) {
            C2538c.c("EsimProfileAcitvity", new Object[]{"mBTStatus is DEVICE_CONNECTED"});
            m27236b();
        } else if (1 == this.f20357k) {
            m27240c();
        } else {
            m27232a();
        }
    }

    private void m27232a() {
        this.f20354h.setVisibility(8);
        this.f20353g.setVisibility(0);
        this.f20364r.setVisibility(8);
        this.f20359m.setEnabled(false);
        this.f20360n.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
        if (C5999c.m27456e(this)) {
            this.f20361o.setImageResource(f.sim_back_arrow_disable);
        } else {
            this.f20361o.setImageResource(f.sim_next_arrow_disable);
        }
    }

    private void m27236b() {
        this.f20354h.setVisibility(8);
        this.f20353g.setVisibility(8);
        if (this.f20350d.booleanValue() || this.f20366t) {
            this.f20364r.setVisibility(8);
            this.f20360n.setText(i.IDS_plugin_sim_next);
        } else {
            this.f20364r.setVisibility(0);
            this.f20360n.setText(i.IDS_plugin_sim_esim_button_retry);
        }
        this.f20359m.setEnabled(true);
        this.f20360n.setTextColor(getResources().getColor(e.IDS_plugin_sim_next_back_color));
        if (C5999c.m27456e(this)) {
            this.f20361o.setImageResource(f.sim_back_arrow);
        } else {
            this.f20361o.setImageResource(f.sim_next_arrow);
        }
    }

    private void m27240c() {
        this.f20354h.setVisibility(0);
        this.f20353g.setVisibility(8);
        this.f20364r.setVisibility(8);
        this.f20356j.startAnimation(AnimationUtils.loadAnimation(this, d.bt_connecting));
        this.f20359m.setEnabled(false);
        this.f20360n.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
        if (C5999c.m27456e(this)) {
            this.f20361o.setImageResource(f.sim_back_arrow_disable);
        } else {
            this.f20361o.setImageResource(f.sim_next_arrow_disable);
        }
    }

    protected void onDestroy() {
        m27245f();
        super.onDestroy();
        if (this.f20367u != null) {
            this.f20367u.mo4475b(this.f20370x);
        }
    }

    private void m27242d() {
        this.f20347a = (ListView) findViewById(g.esim_profile);
        this.f20352f = new C5920a(this.f20349c, this);
        this.f20347a.setAdapter(this.f20352f);
        this.f20363q = (CustomTitleBar) findViewById(g.esim_profile_title_bar);
        this.f20363q.setLeftButtonOnClickListener(new C5947x(this));
        this.f20353g = findViewById(g.bt_disconnect);
        this.f20355i = findViewById(g.set_bt_reconnect);
        this.f20355i.setOnClickListener(new C5948y(this));
        this.f20354h = findViewById(g.bt_connecting);
        this.f20356j = (ImageView) findViewById(g.bt_connecting_imgage);
        this.f20358l = findViewById(g.back_button_layout);
        this.f20362p = (ImageView) findViewById(g.back_button);
        this.f20358l.setOnClickListener(new aa(this));
        this.f20359m = findViewById(g.next_button_layout);
        this.f20359m.setOnClickListener(new ab(this));
        this.f20360n = (TextView) findViewById(g.next_button_text);
        this.f20361o = (ImageView) findViewById(g.next_button);
        this.f20364r = findViewById(g.bt_comunictaion_fail);
        this.f20364r.setVisibility(8);
        this.f20365s = (ImageView) findViewById(g.bt_reconnect_set_image);
        if (C5999c.m27456e(this)) {
            this.f20361o.setImageResource(f.sim_back_arrow);
            this.f20362p.setImageResource(f.sim_next_arrow);
            this.f20365s.setImageResource(f.sim_direction_left_black_tip_image);
        }
    }

    private void m27243e() {
        C5900a c5900a = new C5900a();
        c5900a.m27110a(getString(i.IDS_plugin_sim_esim_profile_SPN));
        if (this.f20348b != null) {
            c5900a.m27113b(this.f20348b.m22696b());
            c5900a.m27111a(this.f20348b.m22701d());
        }
        c5900a.m27109a(1);
        this.f20349c.add(c5900a);
        c5900a = new C5900a();
        c5900a.m27110a(getString(i.IDS_plugin_sim_esim_profile_name));
        if (this.f20348b != null) {
            c5900a.m27113b(this.f20348b.m22698c());
        }
        c5900a.m27109a(0);
        this.f20349c.add(c5900a);
        c5900a = new C5900a();
        c5900a.m27110a(getString(i.IDS_plugin_sim_esim_profile_ICCID));
        if (this.f20348b != null) {
            c5900a.m27113b(this.f20348b.m22692a());
        }
        c5900a.m27109a(0);
        this.f20349c.add(c5900a);
    }

    private void m27233a(int i) {
        if (this.f20350d.booleanValue()) {
            C2538c.b("EsimProfileAcitvity", new Object[]{"commandResult errorcode " + i});
            m27245f();
            return;
        }
        if (i == 0) {
            this.f20366t = true;
            Intent intent = new Intent(this, EsimProfileSuccessActivity.class);
            intent.putExtra("conform_status", false);
            startActivity(intent);
        } else {
            this.f20366t = false;
            int i2 = 3;
            if (this.f20367u == null) {
                C2538c.e("EsimProfileAcitvity", new Object[]{"null == pluginSimAdapter"});
            } else {
                i2 = this.f20367u.mo4474b();
            }
            if (2 == i2) {
                m27236b();
            }
        }
        m27245f();
    }

    private void m27237b(int i) {
        if (this.f20351e == null) {
            C6002a c6002a = new C6002a(this, j.common_dialog21);
            this.f20351e = C6002a.m27468a((Context) this);
            this.f20351e.m27476a(getResources().getString(i));
            this.f20351e.setCancelable(false);
        } else {
            this.f20351e.m27476a(getResources().getString(i));
        }
        if (this.f20351e != null) {
            this.f20351e.m27474a();
            C2538c.c("EsimProfileAcitvity", new Object[]{"mLoadingUserInformationDialog.show()"});
        }
    }

    private void m27245f() {
        C2538c.c("EsimProfileAcitvity", new Object[]{"enter dismissLoadingDialog()"});
        if (!isFinishing() && this.f20351e != null && this.f20351e.isShowing()) {
            C2538c.c("EsimProfileAcitvity", new Object[]{"dismissLoadingDialog()!"});
            this.f20351e.cancel();
            this.f20351e = null;
        }
    }

    protected void onStop() {
        super.onStop();
    }
}
