package com.huawei.sim.esim.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.sim.C4501b;
import com.huawei.sim.C5898a;
import com.huawei.sim.e;
import com.huawei.sim.f;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.sim.i;
import com.huawei.sim.j;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.dialog.C6002a;
import com.huawei.ui.commonui.p514d.C5999c;

public class ConformActivity extends BaseActivity {
    TextWatcher f20291a = new C5929f(this);
    private EditText f20292b;
    private String f20293c;
    private TextView f20294d;
    private C6002a f20295e = null;
    private int f20296f;
    private View f20297g;
    private TextView f20298h;
    private ImageView f20299i;
    private ImageView f20300j;
    private C4501b f20301k;
    private IBaseResponseCallback f20302l = new C5926c(this);
    private IBaseResponseCallback f20303m = new C5928e(this);
    private IBaseResponseCallback f20304n = new C5930g(this);
    private Handler f20305o = new C5931h(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.activity_conform);
        this.f20293c = getIntent().getStringExtra("conform_code");
        m27188a();
        this.f20301k = (C4501b) C5898a.m27101a((Context) this).getAdapter();
        if (this.f20301k == null) {
            C2538c.e("ConformActivity", new Object[]{"mHWDeviceConfigManager is null"});
            return;
        }
        this.f20301k.mo4468a(this.f20304n);
    }

    private void m27188a() {
        this.f20294d = (TextView) findViewById(g.conform_invilid_tips);
        this.f20292b = (EditText) findViewById(g.conform_code);
        this.f20297g = findViewById(g.back_button_text);
        this.f20297g.setOnClickListener(new C5924a(this));
        this.f20298h = (TextView) findViewById(g.next_button_text);
        this.f20298h.setOnClickListener(new C5925b(this));
        this.f20299i = (ImageView) findViewById(g.next_button);
        this.f20300j = (ImageView) findViewById(g.back_button);
        if (C5999c.m27456e(this)) {
            this.f20299i.setImageResource(f.sim_back_arrow);
            this.f20300j.setImageResource(f.sim_next_arrow);
        }
    }

    protected void onResume() {
        super.onResume();
        this.f20292b.addTextChangedListener(this.f20291a);
        C2538c.b("ConformActivity", new Object[]{"onResume conformcode " + this.f20293c});
        if (this.f20293c != null) {
            this.f20292b.setText(this.f20293c);
            this.f20292b.setSelection(this.f20292b.getText().length());
        }
        C2538c.b("ConformActivity", new Object[]{"CharSequence " + this.f20296f});
        if (this.f20296f != 0) {
            this.f20298h.setEnabled(false);
            this.f20298h.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
            if (C5999c.m27456e(this)) {
                this.f20299i.setImageResource(f.sim_back_arrow_disable);
            } else {
                this.f20299i.setImageResource(f.sim_next_arrow_disable);
            }
            this.f20292b.setBackgroundResource(f.sim_edit_input_error);
            this.f20294d.setVisibility(0);
            this.f20294d.setText(i.IDS_plugin_sim_esim_conform_code_auth_error);
            return;
        }
        if (this.f20292b.getText().length() == 0) {
            this.f20298h.setEnabled(false);
            this.f20298h.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
            if (C5999c.m27456e(this)) {
                this.f20299i.setImageResource(f.sim_back_arrow_disable);
            } else {
                this.f20299i.setImageResource(f.sim_next_arrow_disable);
            }
        } else {
            this.f20298h.setEnabled(true);
            this.f20298h.setTextColor(getResources().getColor(e.IDS_plugin_sim_next_back_color));
            if (C5999c.m27456e(this)) {
                this.f20299i.setImageResource(f.sim_back_arrow);
            } else {
                this.f20299i.setImageResource(f.sim_next_arrow);
            }
        }
        this.f20294d.setVisibility(4);
        this.f20292b.setBackgroundResource(f.sim_edit_input);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        C2538c.c("ConformActivity", new Object[]{"onDestroy()"});
        m27193b();
        super.onDestroy();
        if (this.f20301k != null) {
            this.f20301k.mo4475b(this.f20304n);
        }
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    private void m27189a(int i) {
        C2538c.c("ConformActivity", new Object[]{"the error code is: " + i});
        Intent intent = new Intent(this, EsimConformInvailActivity.class);
        intent.putExtra("conform_error", i);
        startActivity(intent);
    }

    private void m27194b(int i) {
        if (this.f20295e == null) {
            C2538c.c("ConformActivity", new Object[]{"mLoadingUserInformationDialog is null"});
            C6002a c6002a = new C6002a(this, j.common_dialog21);
            this.f20295e = C6002a.m27468a((Context) this);
            this.f20295e.m27476a(getResources().getString(i));
            this.f20295e.setCancelable(false);
        } else {
            this.f20295e.m27476a(getResources().getString(i));
        }
        if (this.f20295e != null) {
            this.f20295e.m27474a();
            C2538c.c("ConformActivity", new Object[]{"mLoadingUserInformationDialog  show"});
        }
    }

    private void m27193b() {
        if (!isFinishing()) {
            C2538c.c("ConformActivity", new Object[]{"enter dismissLoadingDialog()"});
            if (this.f20295e != null && this.f20295e.isShowing()) {
                C2538c.c("ConformActivity", new Object[]{"dismissLoadingDialog()!"});
                this.f20295e.cancel();
                this.f20295e = null;
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        C2538c.b("ConformActivity", new Object[]{"requestCode " + i + " resultCode " + i2});
        super.onActivityResult(i, i2, intent);
        if (1 == i2 && intent != null) {
            this.f20296f = intent.getIntExtra("conform_report", 1);
            if (this.f20296f != 0) {
                this.f20298h.setEnabled(false);
                this.f20298h.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
                if (C5999c.m27456e(this)) {
                    this.f20299i.setImageResource(f.sim_back_arrow_disable);
                } else {
                    this.f20299i.setImageResource(f.sim_next_arrow_disable);
                }
                this.f20292b.setBackgroundResource(f.sim_edit_input_error);
                this.f20294d.setVisibility(0);
                this.f20294d.setText(i.IDS_plugin_sim_esim_conform_code_auth_error);
                return;
            }
            this.f20298h.setEnabled(true);
            this.f20298h.setTextColor(getResources().getColor(e.IDS_plugin_sim_next_back_color));
            if (C5999c.m27456e(this)) {
                this.f20299i.setImageResource(f.sim_back_arrow);
            } else {
                this.f20299i.setImageResource(f.sim_next_arrow);
            }
            this.f20294d.setVisibility(4);
            this.f20292b.setBackgroundResource(f.sim_edit_input);
        }
    }

    private void m27196c() {
        this.f20294d.setVisibility(0);
        this.f20294d.setText(i.IDS_plugin_sim_esim_conform_code_auth_error);
        this.f20292b.setBackgroundResource(f.sim_edit_input_error);
        this.f20298h.setEnabled(false);
        this.f20298h.setTextColor(getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
        if (C5999c.m27456e(this)) {
            this.f20299i.setImageResource(f.sim_back_arrow_disable);
        } else {
            this.f20299i.setImageResource(f.sim_next_arrow_disable);
        }
    }
}
