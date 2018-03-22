package com.huawei.sim.esim.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.sim.C4501b;
import com.huawei.sim.C5898a;
import com.huawei.sim.e;
import com.huawei.sim.esim.p505b.C5902c;
import com.huawei.sim.esim.view.p507a.C5922c;
import com.huawei.sim.g;
import com.huawei.sim.h;
import com.huawei.sim.i;
import com.huawei.sim.multisim.MultiSimConfigActivity;
import com.huawei.ui.commonui.base.BaseActivity;
import com.huawei.ui.commonui.p514d.C5999c;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;

public class WirelessManagerAcitivity extends BaseActivity {
    private ListView f20401a;
    private ArrayList<C5902c> f20402b = new ArrayList();
    private C5922c f20403c;
    private Context f20404d;
    private TextView f20405e;
    private View f20406f;
    private C4501b f20407g;
    private OnClickListener f20408h = new am(this);
    private OnClickListener f20409i = new an(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.wireless_activity);
        this.f20404d = this;
        this.f20407g = (C4501b) C5898a.m27101a((Context) this).getAdapter();
        if (this.f20407g == null) {
            C2538c.e("WirelessManagerAcitivity", new Object[]{"pluginSimAdapter is null"});
        }
        C5898a.m27101a((Context) this).m27103a(true);
        m27259c();
        m27257b();
    }

    private void m27257b() {
        this.f20401a = (ListView) findViewById(g.listView);
        this.f20401a.setAdapter(this.f20403c);
        this.f20405e = (TextView) findViewById(g.wirless_manager_txt);
        this.f20406f = findViewById(g.wirless_manager_lint);
        if (this.f20407g == null || !this.f20407g.mo4482i()) {
            this.f20405e.setVisibility(8);
            this.f20406f.setVisibility(8);
            return;
        }
        this.f20405e.setVisibility(0);
        this.f20406f.setVisibility(0);
        String string = getString(i.IDS_plugin_multi_sim_manager_txt);
        CharSequence string2 = getString(i.IDS_plugin_multi_sim_manager_title);
        String[] split = String.format(string, new Object[]{string2}).split(string2);
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        CharSequence spannableString = new SpannableString(split[0]);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, e.IDS_plugin_sim_white_50alpha)), 0, spannableString.length(), 33);
        spannableStringBuilder.append(spannableString);
        spannableString = new SpannableString(string2);
        spannableString.setSpan(new al(this), 0, spannableString.length(), 33);
        spannableStringBuilder.append(spannableString);
        string2 = new SpannableString(split[1]);
        string2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, e.IDS_plugin_sim_white_50alpha)), 0, string2.length(), 33);
        spannableStringBuilder.append(string2);
        this.f20405e.setText(spannableStringBuilder);
        this.f20405e.setMovementMethod(LinkMovementMethod.getInstance());
        this.f20405e.setHighlightColor(ContextCompat.getColor(this, e.IDS_plugin_sim_transparent));
    }

    private void m27259c() {
        C5902c c5902c = new C5902c();
        if (this.f20407g != null) {
            if (this.f20407g.mo4482i()) {
                C2538c.c("WirelessManagerAcitivity", new Object[]{"create esim menu"});
                c5902c.m27127a(getString(i.IDS_plugin_sim_esim_open));
                c5902c.m27129b(getString(i.IDS_plugin_sim_esim_open_tips));
                c5902c.m27126a(this.f20408h);
                this.f20402b.add(c5902c);
            }
            c5902c = new C5902c();
            if (this.f20407g.mo4483j() && C5999c.m27453b(this.f20404d) && !this.f20407g.mo4482i()) {
                C2538c.c("WirelessManagerAcitivity", new Object[]{"create multisim menu"});
                c5902c.m27127a(getString(i.IDS_plugin_multi_sim_config_title));
                c5902c.m27129b(getString(i.IDS_plugin_multi_sim_menu_tip));
                c5902c.m27126a(this.f20409i);
                this.f20402b.add(c5902c);
            }
            this.f20403c = new C5922c(this.f20402b, this);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        C5898a.m27101a((Context) this).m27103a(false);
    }

    protected void onPause() {
        super.onPause();
    }

    public boolean m27261a() {
        try {
            this.f20404d.getPackageManager().getPackageInfo("com.huawei.hwmultisim", 128);
            return true;
        } catch (NameNotFoundException e) {
            C2538c.c("WirelessManagerAcitivity", new Object[]{"no multisim apk"});
            return false;
        }
    }

    private void m27260d() {
        this.f20404d.startActivity(new Intent(this, MultiSimConfigActivity.class));
    }
}
