package com.huawei.sim.esim.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.sim.C4501b;
import com.huawei.sim.C5898a;
import com.huawei.sim.d;
import com.huawei.sim.e;
import com.huawei.sim.esim.qrcode.QrCodeActivity;
import com.huawei.sim.f;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.p514d.C5999c;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;

public class EsimProfileBTFailActivity extends BaseActivity implements OnClickListener {
    private Button f20371a;
    private Button f20372b;
    private CustomTitleBar f20373c;
    private int f20374d = 3;
    private View f20375e;
    private TextView f20376f;
    private TextView f20377g;
    private ImageView f20378h;
    private ImageView f20379i;
    private View f20380j;
    private View f20381k;
    private ImageView f20382l;
    private C4501b f20383m;
    private ImageView f20384n;
    private IBaseResponseCallback f20385o = new ah(this);
    private Handler f20386p = new ai(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.activity_profile_bt_fail);
        this.f20371a = (Button) findViewById(g.esim_profile_cancel);
        this.f20371a.setOnClickListener(this);
        this.f20372b = (Button) findViewById(g.esim_profile_retry);
        this.f20372b.setOnClickListener(this);
        this.f20373c = (CustomTitleBar) findViewById(g.profile_bt_fail_title_bar);
        this.f20376f = (TextView) findViewById(g.esim_failed_info);
        this.f20379i = (ImageView) findViewById(g.esim_image_failed);
        this.f20377g = (TextView) findViewById(g.esim_success_info);
        this.f20378h = (ImageView) findViewById(g.esim_image_success);
        this.f20380j = findViewById(g.bt_disconnect);
        this.f20375e = findViewById(g.set_bt_reconnect);
        this.f20375e.setOnClickListener(new af(this));
        this.f20382l = (ImageView) findViewById(g.bt_connecting_imgage);
        this.f20381k = findViewById(g.bt_connecting);
        this.f20383m = (C4501b) C5898a.m27101a((Context) this).getAdapter();
        if (this.f20383m == null) {
            C2538c.e("EsimProfileBTFailActivity", new Object[]{"null == pluginSimAdapter"});
            return;
        }
        this.f20384n = (ImageView) findViewById(g.bt_reconnect_set_image);
        if (C5999c.m27456e(this)) {
            this.f20384n.setImageResource(f.sim_direction_left_black_tip_image);
        }
        this.f20383m.mo4468a(this.f20385o);
    }

    protected void onResume() {
        super.onResume();
        if (this.f20383m == null) {
            C2538c.e("EsimProfileBTFailActivity", new Object[]{"pluginSimAdapter is null"});
            this.f20374d = 3;
        } else {
            this.f20374d = this.f20383m.mo4474b();
        }
        if (2 == this.f20374d) {
            m27250b();
        } else if (1 == this.f20374d) {
            C2538c.e("EsimProfileBTFailActivity", new Object[]{"DEVICE_CONNECTING == mBTStatus"});
            m27252c();
        } else {
            m27249a();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f20383m != null) {
            this.f20383m.mo4475b(this.f20385o);
        }
    }

    public void onClick(View view) {
        if (view.getId() == g.esim_profile_cancel) {
            startActivity(new Intent(this, EsimActivationActivity.class));
            finish();
        } else if (view.getId() == g.esim_profile_retry) {
            startActivity(new Intent(this, QrCodeActivity.class));
            finish();
        }
    }

    private void m27249a() {
        this.f20381k.setVisibility(8);
        this.f20380j.setVisibility(0);
        this.f20372b.setEnabled(false);
        this.f20376f.setVisibility(0);
        this.f20379i.setVisibility(0);
        this.f20377g.setVisibility(8);
        this.f20378h.setVisibility(8);
        this.f20372b.setBackgroundResource(f.sim_btn_two_disable);
        this.f20372b.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
    }

    private void m27250b() {
        this.f20381k.setVisibility(8);
        this.f20380j.setVisibility(8);
        this.f20372b.setEnabled(true);
        this.f20376f.setVisibility(8);
        this.f20379i.setVisibility(8);
        this.f20377g.setVisibility(0);
        this.f20378h.setVisibility(0);
        this.f20372b.setBackgroundResource(f.sim_btn_two);
        this.f20372b.setTextColor(getResources().getColor(e.IDS_plugin_sim_next_back_color));
    }

    private void m27252c() {
        this.f20381k.setVisibility(0);
        this.f20380j.setVisibility(8);
        this.f20382l.startAnimation(AnimationUtils.loadAnimation(this, d.bt_connecting));
        this.f20376f.setVisibility(0);
        this.f20379i.setVisibility(0);
        this.f20377g.setVisibility(8);
        this.f20378h.setVisibility(8);
        this.f20372b.setEnabled(false);
        this.f20372b.setBackgroundResource(f.sim_btn_two_disable);
        this.f20372b.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
    }
}
