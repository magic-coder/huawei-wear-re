package com.huawei.sim.esim.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.sim.i;
import com.huawei.p190v.C2538c;

/* compiled from: EsimProfileAcitvity */
class ab implements OnClickListener {
    final /* synthetic */ EsimProfileAcitvity f20423a;

    ab(EsimProfileAcitvity esimProfileAcitvity) {
        this.f20423a = esimProfileAcitvity;
    }

    public void onClick(View view) {
        C2538c.b("EsimProfileAcitvity", new Object[]{" mNextButton.setOnClickListener"});
        if (this.f20423a.f20350d.booleanValue()) {
            this.f20423a.startActivity(new Intent(this.f20423a, ConformActivity.class));
        } else if (this.f20423a.f20367u != null) {
            this.f20423a.f20367u.mo4469a(null, 0, this.f20423a.f20368v, null);
            this.f20423a.m27237b(i.IDS_plugin_sim_esim_handling);
        } else {
            C2538c.e("EsimProfileAcitvity", new Object[]{"null == pluginSimAdapter"});
        }
    }
}
