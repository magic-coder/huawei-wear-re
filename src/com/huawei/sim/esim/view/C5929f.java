package com.huawei.sim.esim.view;

import android.text.Editable;
import android.text.TextWatcher;
import com.huawei.sim.e;
import com.huawei.sim.f;
import com.huawei.sim.i;
import com.huawei.ui.commonui.p514d.C5999c;
import com.huawei.p190v.C2538c;

/* compiled from: ConformActivity */
class C5929f implements TextWatcher {
    final /* synthetic */ ConformActivity f20442a;

    C5929f(ConformActivity conformActivity) {
        this.f20442a = conformActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C2538c.b("ConformActivity", new Object[]{"CharSequence " + charSequence.toString() + "length " + charSequence.length()});
        if (charSequence.length() > 255) {
            this.f20442a.f20294d.setVisibility(0);
            this.f20442a.f20294d.setText(i.IDS_plugin_sim_esim_conform_code_error);
            this.f20442a.f20298h.setEnabled(false);
            this.f20442a.f20298h.setTextColor(this.f20442a.getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
            if (C5999c.m27456e(this.f20442a)) {
                this.f20442a.f20299i.setImageResource(f.sim_back_arrow_disable);
            } else {
                this.f20442a.f20299i.setImageResource(f.sim_next_arrow_disable);
            }
            this.f20442a.f20292b.setBackgroundResource(f.sim_edit_input_error);
            return;
        }
        if (charSequence.length() != 0) {
            this.f20442a.f20298h.setEnabled(true);
            this.f20442a.f20298h.setTextColor(this.f20442a.getResources().getColor(e.IDS_plugin_sim_next_back_color));
            if (C5999c.m27456e(this.f20442a)) {
                this.f20442a.f20299i.setImageResource(f.sim_back_arrow);
            } else {
                this.f20442a.f20299i.setImageResource(f.sim_next_arrow);
            }
        } else {
            this.f20442a.f20298h.setEnabled(false);
            this.f20442a.f20298h.setTextColor(this.f20442a.getResources().getColor(e.IDS_plugin_sim_ext_back_color_20alpha));
            if (C5999c.m27456e(this.f20442a)) {
                this.f20442a.f20299i.setImageResource(f.sim_back_arrow_disable);
            } else {
                this.f20442a.f20299i.setImageResource(f.sim_next_arrow_disable);
            }
        }
        this.f20442a.f20294d.setVisibility(4);
        this.f20442a.f20292b.setBackgroundResource(f.sim_edit_input);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}
