package com.huawei.sim.multisim;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.sim.C4501b;
import com.huawei.sim.C5898a;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.sim.i;
import com.huawei.ui.commonui.base.BaseActivity;

public class MultiSimAuth extends BaseActivity implements OnClickListener {
    private TextView f20465a;
    private TextView f20466b;
    private Button f20467c;
    private Button f20468d;
    private C4501b f20469e;
    private Context f20470f = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2538c.c("MultiSimAuth", new Object[]{"onCreate"});
        this.f20470f = this;
        setContentView(h.activity_multi_sim_auth);
        m27264a();
        this.f20469e = (C4501b) C5898a.m27101a((Context) this).getAdapter();
        if (this.f20469e == null) {
            C2538c.e("MultiSimAuth", new Object[]{"pluginSimAdapter is null"});
        }
        m27265b();
    }

    private void m27264a() {
        this.f20465a = (TextView) findViewById(g.multi_sim_auth_notice);
        this.f20466b = (TextView) findViewById(g.multi_sim_auth_tip);
        this.f20467c = (Button) findViewById(g.multi_sim_auth_agree);
        this.f20467c.setOnClickListener(this);
        this.f20468d = (Button) findViewById(g.multi_sim_auth_cancel);
        this.f20468d.setOnClickListener(this);
    }

    public static String m27263a(Context context, String str) {
        String str2 = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            str2 = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (Exception e) {
            C2538c.c("MultiSimAuth", new Object[]{"Exception=" + e.toString()});
        }
        return str2;
    }

    private void m27265b() {
        CharSequence format;
        CharSequence format2;
        C2538c.c("MultiSimAuth", new Object[]{"initAuthRequestView()"});
        String str = "";
        str = "";
        if (this.f20469e != null) {
            format = String.format(getResources().getString(i.IDS_plugin_multi_sim_get_device_info), new Object[]{m27263a(this.f20470f, this.f20469e.mo4484k()), this.f20469e.mo4476c()});
            format2 = String.format(getResources().getString(i.IDS_plugin_multi_sim_get_device_tip), new Object[]{getResources().getString(i.IDS_plugin_multi_sim_auth_agree), m27263a(this.f20470f, this.f20469e.mo4484k())});
        } else {
            format = String.format(getResources().getString(i.IDS_plugin_multi_sim_get_device_info), new Object[]{"", "Huawei Watch"});
            format2 = String.format(getResources().getString(i.IDS_plugin_multi_sim_get_device_tip), new Object[]{getResources().getString(i.IDS_plugin_multi_sim_auth_agree), ""});
        }
        this.f20465a.setText(format);
        this.f20466b.setText(format2);
    }

    private void m27266c() {
        if (this.f20469e != null) {
            this.f20469e.mo4472a(false);
        } else {
            C2538c.e("MultiSimAuth", new Object[]{"pluginSimAdapter is null"});
        }
        finish();
    }

    public void onClick(View view) {
        C2538c.c("MultiSimAuth", new Object[]{"onClick enter"});
        if (view.getId() == g.multi_sim_auth_agree) {
            C2538c.c("MultiSimAuth", new Object[]{"onClick agree"});
            if (this.f20469e != null) {
                this.f20469e.mo4472a(true);
            } else {
                C2538c.e("MultiSimAuth", new Object[]{"pluginSimAdapter is null"});
            }
            finish();
        } else if (view.getId() == g.multi_sim_auth_cancel) {
            C2538c.c("MultiSimAuth", new Object[]{"onClick cancel"});
            m27266c();
        }
    }

    public void onBackPressed() {
        C2538c.c("MultiSimAuth", new Object[]{"onClick back button"});
        m27266c();
    }
}
