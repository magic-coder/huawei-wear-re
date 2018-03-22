package com.huawei.sim.esim.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.sim.esim.qrcode.QrCodeActivity;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.sim.i;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;

public class EsimProflieAuthenticationFail extends BaseActivity implements OnClickListener {
    private Button f20391a;
    private Button f20392b;
    private Button f20393c;
    private TextView f20394d;
    private int f20395e;
    private CustomTitleBar f20396f;
    private View f20397g;
    private View f20398h;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.activity_esim_profile_fail);
        this.f20395e = getIntent().getIntExtra("mata_report", 1);
        m27255a();
    }

    private void m27255a() {
        this.f20397g = findViewById(g.double_button);
        this.f20398h = findViewById(g.single_button);
        this.f20391a = (Button) findViewById(g.esim_profile_cancel);
        this.f20391a.setOnClickListener(this);
        this.f20392b = (Button) findViewById(g.esim_profile_retry);
        this.f20392b.setOnClickListener(this);
        this.f20393c = (Button) findViewById(g.esim_profile_ok);
        this.f20393c.setOnClickListener(this);
        this.f20396f = (CustomTitleBar) findViewById(g.profile_auth_fail_title_bar);
        this.f20396f.setLeftButtonOnClickListener(new aj(this));
        this.f20394d = (TextView) findViewById(g.profile_auth_tips);
        if (2 == this.f20395e) {
            this.f20397g.setVisibility(8);
            this.f20398h.setVisibility(0);
            this.f20394d.setText(i.IDS_plugin_sim_esim_error_2);
        } else if (1 == this.f20395e) {
            this.f20398h.setVisibility(8);
            this.f20397g.setVisibility(0);
            this.f20394d.setText(i.IDS_plugin_esim_network_failed);
        } else if (3 == this.f20395e) {
            this.f20397g.setVisibility(8);
            this.f20398h.setVisibility(0);
            this.f20394d.setText(i.IDS_plugin_esim_watch_failed);
        } else if (4 == this.f20395e) {
            this.f20397g.setVisibility(8);
            this.f20398h.setVisibility(0);
            this.f20394d.setText(i.IDS_plugin_esim_service_failed);
        } else if (5 == this.f20395e) {
            this.f20397g.setVisibility(8);
            this.f20398h.setVisibility(0);
            this.f20394d.setText(i.IDS_plugin_eid_is_refused_by_server);
        } else if (6 == this.f20395e) {
            this.f20397g.setVisibility(8);
            this.f20398h.setVisibility(0);
            this.f20394d.setText(i.IDS_plugin_matching_id_is_resused_by_server);
        } else if (7 == this.f20395e) {
            this.f20397g.setVisibility(8);
            this.f20398h.setVisibility(0);
            this.f20394d.setText(i.IDS_plugin_insufficent_storage);
        } else if (1000 == this.f20395e) {
            this.f20397g.setVisibility(8);
            this.f20398h.setVisibility(0);
            this.f20394d.setText(i.IDS_plugin_esim_start_failed);
        } else {
            this.f20397g.setVisibility(8);
            this.f20398h.setVisibility(0);
            this.f20394d.setText(i.IDS_plugin_esim_unknonw_failed);
        }
    }

    public void onClick(View view) {
        if (view.getId() == g.esim_profile_cancel) {
            startActivity(new Intent(this, EsimActivationActivity.class));
            finish();
        } else if (view.getId() == g.esim_profile_retry) {
            startActivity(new Intent(this, QrCodeActivity.class));
            finish();
        } else if (view.getId() == g.esim_profile_ok) {
            startActivity(new Intent(this, EsimActivationActivity.class));
            finish();
        }
    }
}
