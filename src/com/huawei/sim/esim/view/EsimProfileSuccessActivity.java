package com.huawei.sim.esim.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.sim.f;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.ui.commonui.base.BaseActivity;

public class EsimProfileSuccessActivity extends BaseActivity implements OnClickListener {
    private Button f20387a;
    private boolean f20388b;
    private TextView f20389c;
    private ImageView f20390d;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.activity_conform_success);
        this.f20387a = (Button) findViewById(g.conform_button);
        this.f20387a.setOnClickListener(this);
        this.f20388b = getIntent().getBooleanExtra("conform_status", false);
        this.f20390d = (ImageView) findViewById(g.conform_success_image);
        this.f20389c = (TextView) findViewById(g.conform_sucess_tips);
    }

    protected void onResume() {
        super.onResume();
        if (this.f20388b) {
            this.f20389c.setVisibility(0);
            this.f20390d.setImageResource(f.sim_verify_success);
            return;
        }
        this.f20389c.setVisibility(4);
        this.f20390d.setImageResource(f.sim_open_esim_success);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        if (view.getId() == g.conform_button) {
            startActivity(new Intent(this, WirelessManagerAcitivity.class));
        }
    }
}
