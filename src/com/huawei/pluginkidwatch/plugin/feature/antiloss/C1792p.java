package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import com.huawei.p190v.C2538c;
import java.util.TimerTask;

/* compiled from: AntilossActivity */
public class C1792p extends TimerTask {
    final /* synthetic */ AntilossActivity f4941a;

    public C1792p(AntilossActivity antilossActivity) {
        this.f4941a = antilossActivity;
    }

    public void run() {
        C2538c.m12674b("AntilossActivity", "timerTask ... timerCount = " + this.f4941a.f4875F);
        if (2 != this.f4941a.f4904w.m8302i()) {
            this.f4941a.runOnUiThread(new C1793q(this));
        }
        this.f4941a.f4875F = this.f4941a.f4875F + 1;
    }
}
