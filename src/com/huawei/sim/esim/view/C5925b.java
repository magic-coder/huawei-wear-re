package com.huawei.sim.esim.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.sim.i;

/* compiled from: ConformActivity */
class C5925b implements OnClickListener {
    final /* synthetic */ ConformActivity f20436a;

    C5925b(ConformActivity conformActivity) {
        this.f20436a = conformActivity;
    }

    public void onClick(View view) {
        this.f20436a.f20293c = this.f20436a.f20292b.getText().toString();
        C2538c.b("ConformActivity", new Object[]{"conformcode " + this.f20436a.f20293c});
        int i = 3;
        if (this.f20436a.f20301k == null) {
            C2538c.e("ConformActivity", new Object[]{"null == pluginSimAdapter"});
        } else {
            i = this.f20436a.f20301k.mo4474b();
        }
        if (2 == i) {
            this.f20436a.m27194b(i.IDS_plugin_sim_esim_conform_code_auth);
            this.f20436a.f20301k.mo4469a(this.f20436a.f20293c, 0, this.f20436a.f20303m, this.f20436a.f20302l);
            return;
        }
        Intent intent = new Intent(this.f20436a, EsimConformBTFailActivity.class);
        intent.putExtra("conform_code", this.f20436a.f20293c);
        this.f20436a.startActivityForResult(intent, 0);
    }
}
