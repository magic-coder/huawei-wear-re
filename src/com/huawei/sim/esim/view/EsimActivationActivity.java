package com.huawei.sim.esim.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
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
import com.huawei.sim.i;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.p514d.C5999c;

public class EsimActivationActivity extends BaseActivity {
    private Button f20306a;
    private View f20307b;
    private View f20308c;
    private View f20309d;
    private int f20310e = 3;
    private View f20311f;
    private View f20312g;
    private ImageView f20313h;
    private boolean f20314i = false;
    private C4501b f20315j;
    private ImageView f20316k;
    private ImageView f20317l;
    private TextView f20318m;
    private IBaseResponseCallback f20319n = new C5936m(this);
    private Handler f20320o = new C5937n(this);

    protected void onCreate(Bundle bundle) {
        C2538c.c("EsimActivationActivity", new Object[]{"EsimActivationActivity enter"});
        super.onCreate(bundle);
        setContentView(h.layout_activate_esim);
        m27207a();
        this.f20315j = (C4501b) C5898a.m27101a((Context) this).getAdapter();
        if (this.f20315j == null) {
            C2538c.e("EsimActivationActivity", new Object[]{"null == pluginSimAdapter"});
            return;
        }
        this.f20315j.mo4468a(this.f20319n);
        this.f20310e = this.f20315j.mo4474b();
    }

    private void m27207a() {
        this.f20307b = findViewById(g.permission_tips);
        this.f20308c = findViewById(g.set_permission_tips);
        this.f20308c.setOnClickListener(new C5932i(this));
        this.f20306a = (Button) findViewById(g.open_esim_button);
        this.f20306a.setOnClickListener(new C5933j(this));
        this.f20311f = findViewById(g.bt_disconnect);
        this.f20309d = findViewById(g.set_bt_reconnect);
        C2538c.b("EsimActivationActivity", new Object[]{"mSetBtReconnect.setOnClickListener"});
        this.f20309d.setOnClickListener(new C5934k(this));
        this.f20312g = findViewById(g.bt_connecting);
        this.f20313h = (ImageView) findViewById(g.bt_connecting_imgage);
        this.f20318m = (TextView) findViewById(g.launch_tips);
        this.f20318m.setText(String.format(getString(i.IDS_plugin_sim_open_tip_list), new Object[]{com.huawei.hwbasemgr.c.a(30.0d, 2, 0), Integer.valueOf(1), Integer.valueOf(2)}));
        this.f20316k = (ImageView) findViewById(g.bt_reconnect_set_image);
        this.f20317l = (ImageView) findViewById(g.permission_set_imgage);
        if (C5999c.m27456e(this)) {
            this.f20316k.setImageResource(f.sim_direction_left_black_tip_image);
            this.f20317l.setImageResource(f.sim_direction_left_black_tip_image);
        }
    }

    protected void onResume() {
        super.onResume();
        C2538c.b("EsimActivationActivity", new Object[]{"onResume"});
        if (this.f20315j == null) {
            C2538c.e("EsimActivationActivity", new Object[]{"pluginSimAdapter == null"});
            this.f20310e = 3;
        } else {
            this.f20310e = this.f20315j.mo4474b();
        }
        if (2 == this.f20310e) {
            C2538c.b("EsimActivationActivity", new Object[]{"btConnectView()"});
            m27213d();
        } else if (1 == this.f20310e) {
            C2538c.b("EsimActivationActivity", new Object[]{"btConnectingView()"});
            m27215e();
        } else {
            C2538c.b("EsimActivationActivity", new Object[]{"btDisconnectView()"});
            m27211c();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f20315j != null) {
            this.f20315j.mo4475b(this.f20319n);
        }
        this.f20314i = false;
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            try {
                if ((iArr[0] == 0 ? 1 : 0) != 0) {
                    startActivity(new Intent(this, QrCodeActivity.class));
                } else if (!shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                    C2538c.b("EsimActivationActivity", new Object[]{"#############"});
                    this.f20314i = true;
                    m27217f();
                }
            } catch (Exception e) {
                C2538c.e("EsimActivationActivity", new Object[]{"exception " + e.getMessage()});
            }
        }
    }

    private void m27210b() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
            this.f20314i = false;
        } catch (Exception e) {
            C2538c.e("EsimActivationActivity", new Object[]{"startAppSettings failed"});
            this.f20314i = true;
        }
    }

    private void m27211c() {
        this.f20312g.setVisibility(8);
        this.f20307b.setVisibility(8);
        this.f20311f.setVisibility(0);
        this.f20306a.setEnabled(false);
        this.f20306a.setBackgroundResource(f.sim_btn_one_disable);
        this.f20306a.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
    }

    private void m27213d() {
        this.f20312g.setVisibility(8);
        this.f20311f.setVisibility(8);
        m27217f();
    }

    private void m27215e() {
        this.f20312g.setVisibility(0);
        this.f20311f.setVisibility(8);
        this.f20307b.setVisibility(8);
        this.f20306a.setEnabled(false);
        this.f20313h.startAnimation(AnimationUtils.loadAnimation(this, d.bt_connecting));
        this.f20306a.setBackgroundResource(f.sim_btn_one_disable);
        this.f20306a.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
    }

    private void m27217f() {
        if (this.f20315j == null) {
            C2538c.e("EsimActivationActivity", new Object[]{"null == pluginSimAdapter"});
            this.f20310e = 3;
        } else {
            this.f20310e = this.f20315j.mo4474b();
        }
        if (2 != this.f20310e) {
            return;
        }
        if (this.f20314i) {
            this.f20307b.setVisibility(0);
            this.f20306a.setEnabled(false);
            this.f20306a.setBackgroundResource(f.sim_btn_one_disable);
            this.f20306a.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
            return;
        }
        this.f20307b.setVisibility(8);
        this.f20306a.setEnabled(true);
        this.f20306a.setBackgroundResource(f.sim_btn_one);
        this.f20306a.setTextColor(getResources().getColor(e.IDS_plugin_sim_next_back_color));
    }
}
