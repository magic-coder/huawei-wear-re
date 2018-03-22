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
import com.huawei.sim.f;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.sim.i;
import com.huawei.sim.j;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.p514d.C5999c;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;

public class EsimConformBTFailActivity extends BaseActivity implements OnClickListener {
    private Button f20321a;
    private Button f20322b;
    private CustomTitleBar f20323c;
    private View f20324d;
    private TextView f20325e;
    private TextView f20326f;
    private int f20327g = 3;
    private String f20328h;
    private ImageView f20329i;
    private ImageView f20330j;
    private ImageView f20331k;
    private View f20332l;
    private View f20333m;
    private ImageView f20334n;
    private C4501b f20335o;
    private String f20336p;
    private IBaseResponseCallback f20337q = new C5940q(this);
    private IBaseResponseCallback f20338r = new C5942s(this);
    private C6002a f20339s = null;
    private IBaseResponseCallback f20340t = new C5943t(this);
    private Handler f20341u = new C5944u(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.activity_conform_bt_fail);
        Intent intent = getIntent();
        if (intent != null) {
            this.f20336p = intent.getStringExtra("conform_error");
            C2538c.e("ConformReportActivity", new Object[]{"mErrorCode: " + this.f20336p});
            this.f20328h = intent.getStringExtra("conform_code");
            this.f20321a = (Button) findViewById(g.esim_profile_cancel);
            this.f20321a.setOnClickListener(this);
            this.f20322b = (Button) findViewById(g.esim_profile_retry);
            this.f20322b.setText(i.IDS_plugin_sim_esim_button_retry);
            this.f20322b.setOnClickListener(this);
            this.f20323c = (CustomTitleBar) findViewById(g.profile_BT_fail_title_bar);
            this.f20323c.setLeftButtonClickable(true);
            this.f20325e = (TextView) findViewById(g.esim_failed_info);
            this.f20326f = (TextView) findViewById(g.esim_success_info);
            this.f20329i = (ImageView) findViewById(g.esim_status_success_image);
            this.f20330j = (ImageView) findViewById(g.esim_status_image);
            this.f20332l = findViewById(g.bt_disconnect);
            this.f20324d = findViewById(g.set_bt_reconnect);
            this.f20324d.setOnClickListener(new C5938o(this));
            this.f20331k = (ImageView) findViewById(g.bt_reconnect_set_image);
            if (C5999c.m27456e(this)) {
                this.f20331k.setImageResource(f.sim_direction_left_black_tip_image);
            }
            this.f20334n = (ImageView) findViewById(g.bt_connecting_imgage);
            this.f20333m = findViewById(g.bt_connecting);
            this.f20335o = (C4501b) C5898a.m27101a((Context) this).getAdapter();
            if (this.f20335o == null) {
                C2538c.e("ConformReportActivity", new Object[]{"null == pluginSimAdapter"});
                return;
            }
            this.f20335o.mo4468a(this.f20340t);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.f20335o == null) {
            C2538c.e("ConformReportActivity", new Object[]{"null == pluginSimAdapter"});
            this.f20327g = 3;
        } else {
            this.f20327g = this.f20335o.mo4474b();
        }
        if (2 == this.f20327g) {
            m27226c();
        } else if (1 == this.f20327g) {
            m27228d();
        } else {
            m27224b();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        m27219a();
        super.onDestroy();
        if (this.f20335o != null) {
            this.f20335o.mo4475b(this.f20340t);
        }
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    public void onClick(View view) {
        if (view.getId() == g.esim_profile_cancel) {
            startActivity(new Intent(this, ConformActivity.class));
            finish();
        } else if (view.getId() != g.esim_profile_retry) {
        } else {
            if (this.f20335o != null) {
                m27225b(i.IDS_plugin_sim_esim_conform_code_auth);
                this.f20335o.mo4469a(this.f20328h, 0, this.f20338r, this.f20337q);
                return;
            }
            C2538c.e("ConformReportActivity", new Object[]{"null == pluginSimAdapter"});
        }
    }

    private void m27220a(int i) {
        C2538c.c("ConformReportActivity", new Object[]{"the error code is: " + i});
        Intent intent = new Intent(this, EsimConformInvailActivity.class);
        intent.putExtra("conform_error", i);
        startActivity(intent);
        finish();
    }

    private void m27225b(int i) {
        if (this.f20339s == null) {
            C6002a c6002a = new C6002a(this, j.common_dialog21);
            this.f20339s = C6002a.m27468a((Context) this);
            this.f20339s.m27476a(getResources().getString(i));
            this.f20339s.setCancelable(false);
        } else {
            this.f20339s.m27476a(getResources().getString(i));
        }
        if (this.f20339s != null) {
            this.f20339s.m27474a();
            C2538c.c("ConformReportActivity", new Object[]{"mLoadingUserInformationDialog.show()"});
        }
    }

    private void m27219a() {
        C2538c.c("ConformReportActivity", new Object[]{"enter dismissLoadingDialog()"});
        if (!isFinishing() && this.f20339s != null && this.f20339s.isShowing()) {
            C2538c.c("ConformReportActivity", new Object[]{"dismissLoadingDialog()!"});
            this.f20339s.cancel();
            this.f20339s = null;
        }
    }

    private void m27224b() {
        this.f20333m.setVisibility(8);
        this.f20332l.setVisibility(0);
        this.f20322b.setEnabled(false);
        this.f20325e.setVisibility(0);
        this.f20325e.setText(i.IDS_plugin_sim_esim_conform_fail_tips);
        this.f20330j.setVisibility(0);
        this.f20326f.setVisibility(8);
        this.f20329i.setVisibility(8);
        this.f20322b.setBackgroundResource(f.sim_btn_two_disable);
        this.f20322b.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
    }

    private void m27226c() {
        this.f20333m.setVisibility(8);
        this.f20332l.setVisibility(8);
        this.f20322b.setEnabled(true);
        if (this.f20336p == null || !"network_failed".equals(this.f20336p)) {
            this.f20325e.setVisibility(8);
            this.f20330j.setVisibility(8);
            this.f20326f.setVisibility(0);
            this.f20329i.setVisibility(0);
        } else {
            this.f20325e.setVisibility(0);
            this.f20325e.setText(i.IDS_plugin_esim_conform_network_failed);
            this.f20330j.setVisibility(0);
            this.f20326f.setVisibility(8);
            this.f20329i.setVisibility(8);
        }
        this.f20322b.setBackgroundResource(f.sim_btn_two);
        this.f20322b.setTextColor(getResources().getColor(e.IDS_plugin_sim_next_back_color));
    }

    private void m27228d() {
        this.f20333m.setVisibility(0);
        this.f20332l.setVisibility(8);
        this.f20334n.startAnimation(AnimationUtils.loadAnimation(this, d.bt_connecting));
        this.f20325e.setVisibility(0);
        this.f20325e.setText(i.IDS_plugin_sim_esim_conform_fail_tips);
        this.f20330j.setVisibility(0);
        this.f20326f.setVisibility(8);
        this.f20329i.setVisibility(8);
        this.f20322b.setEnabled(false);
        this.f20322b.setBackgroundResource(f.sim_btn_two_disable);
        this.f20322b.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
    }
}
