package com.huawei.sim;

import android.content.Context;
import android.content.Intent;
import com.huawei.ah.a;
import com.huawei.sim.esim.view.WirelessManagerAcitivity;

/* compiled from: PluginSim */
public class C5898a extends a {
    private static C5898a f20191a;
    private Context f20192b;
    private boolean f20193c = false;

    private C5898a(Context context) {
        this.f20192b = context;
    }

    public static C5898a m27101a(Context context) {
        C5898a c5898a;
        synchronized (C5898a.class) {
            if (f20191a == null && context != null) {
                f20191a = new C5898a(context);
            }
            c5898a = f20191a;
        }
        return c5898a;
    }

    public void m27102a() {
        this.f20192b.startActivity(new Intent(this.f20192b, WirelessManagerAcitivity.class));
    }

    public void m27103a(boolean z) {
        this.f20193c = z;
    }

    public boolean m27104b() {
        return this.f20193c;
    }
}
