package com.huawei.sim.esim.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.sim.i;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.titlebar.CustomTitleBar;
import com.huawei.p190v.C2538c;

public class EsimConformInvailActivity extends BaseActivity {
    private Button f20342a;
    private CustomTitleBar f20343b;
    private int f20344c = 9999;
    private TextView f20345d;
    private ImageView f20346e;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.activity_conform_invail);
        Intent intent = getIntent();
        if (intent != null) {
            this.f20344c = intent.getIntExtra("conform_error", 9999);
            C2538c.c("EsimConformInvailActivity", new Object[]{"the mErrorCode: " + this.f20344c});
            this.f20343b = (CustomTitleBar) findViewById(g.conform_invalid_title_bar);
            this.f20343b.setLeftButtonOnClickListener(new C5945v(this));
            this.f20342a = (Button) findViewById(g.conform_button);
            this.f20342a.setOnClickListener(new C5946w(this));
            this.f20346e = (ImageView) findViewById(g.conform_invalid_image);
            this.f20345d = (TextView) findViewById(g.conform_invide_info);
            if (1000 == this.f20344c) {
                this.f20343b.setTitleText(getResources().getString(i.IDS_plugin_sim_esim_conform_code_title));
                this.f20345d.setText(i.IDS_plugin_esim_conform_start_failed);
            } else if (3 == this.f20344c) {
                this.f20343b.setTitleText(getResources().getString(i.IDS_plugin_sim_conform_invaid_title));
                this.f20345d.setText(i.IDS_plugin_sim_conform_invaid_tip);
            } else {
                this.f20343b.setTitleText(getResources().getString(i.IDS_plugin_sim_esim_conform_code_title));
                this.f20345d.setText(i.IDS_plugin_esim_conform_unkown_error);
            }
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
