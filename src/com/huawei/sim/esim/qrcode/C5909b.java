package com.huawei.sim.esim.qrcode;

import android.content.Intent;
import com.google.gson.Gson;
import com.huawei.hwcommonmodel.datatypes.C4744k;
import com.huawei.hwcommonmodel.datatypes.C4747n;
import com.huawei.p190v.C2538c;
import com.huawei.sim.esim.p505b.C5901b;
import com.huawei.sim.esim.view.EsimProfileAcitvity;
import com.huawei.sim.esim.view.EsimProfileBTFailActivity;

/* compiled from: QrCodeActivity */
class C5909b implements Runnable {
    final /* synthetic */ int f20255a;
    final /* synthetic */ Object f20256b;
    final /* synthetic */ C5908a f20257c;

    C5909b(C5908a c5908a, int i, Object obj) {
        this.f20257c = c5908a;
        this.f20255a = i;
        this.f20256b = obj;
    }

    public void run() {
        if (this.f20255a == 0) {
            String str;
            C5901b c5901b = new C5901b();
            Intent intent = new Intent(this.f20257c.f20254a, EsimProfileAcitvity.class);
            boolean z;
            if (this.f20256b instanceof C4747n) {
                String toJson = new Gson().toJson(((C4747n) this.f20256b).m22715a(), C4744k.class);
                z = ((C4747n) this.f20256b).m22718b() != 1;
                str = toJson;
            } else {
                str = new Gson().toJson(this.f20256b, C4744k.class);
                z = false;
            }
            intent.putExtra("eSim_profile", str);
            C2538c.b(QrCodeActivity.f20205a, new Object[]{"the data " + str});
            if (c5901b.m27123b(this.f20257c.f20254a.f20215k) || r3) {
                intent.putExtra("conform_status", true);
            } else {
                intent.putExtra("conform_status", false);
            }
            this.f20257c.f20254a.startActivity(intent);
            this.f20257c.f20254a.finish();
            this.f20257c.f20254a.m27140f();
        } else if (this.f20257c.f20254a.f20212h != null && this.f20257c.f20254a.f20212h.isShowing()) {
            if (this.f20256b == null || -2 != ((Integer) this.f20256b).intValue()) {
                this.f20257c.f20254a.m27135b(this.f20255a);
                return;
            }
            Intent intent2 = new Intent(this.f20257c.f20254a, EsimProfileBTFailActivity.class);
            if (new C5901b().m27123b(this.f20257c.f20254a.f20215k)) {
                intent2.putExtra("conform_status", true);
            } else {
                intent2.putExtra("conform_status", false);
            }
            this.f20257c.f20254a.startActivity(intent2);
            this.f20257c.f20254a.finish();
            this.f20257c.f20254a.m27140f();
        }
    }
}
