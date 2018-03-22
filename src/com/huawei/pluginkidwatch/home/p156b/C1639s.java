package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.home.HomeActivity;

/* compiled from: CheckUpdateVersionFactory */
final class C1639s extends C1624d {
    final /* synthetic */ HomeActivity f4252b;

    C1639s(Context context, C1413d c1413d, HomeActivity homeActivity) {
        this.f4252b = homeActivity;
        super(context, c1413d);
    }

    public boolean mo2558a() {
        return this.f4252b.isFinishing();
    }

    public void mo2556a(boolean z) {
        if (this.f4252b.f4130b != null && this.f4252b.f4132d.isAdded()) {
            this.f4252b.f4130b.setVisibility(z ? 0 : 4);
        }
    }

    public void mo2557a(boolean z, int i, String str, String str2) {
        if (this.f4252b.f4132d.isAdded()) {
            int i2;
            this.f4252b.f4132d.f4296b.setVisibility(z ? 0 : 8);
            TextView textView = this.f4252b.f4132d.f4297c;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            textView = this.f4252b.f4132d.f4298d;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            this.f4252b.f4132d.f4298d.setText(str2);
            if (i == -1) {
                C2538c.m12674b(C1638r.f4249a, " ==ww== str=null =true ");
                this.f4252b.f4132d.f4296b.setVisibility(4);
                if (str == null) {
                    this.f4252b.f4132d.f4297c.setVisibility(8);
                } else {
                    this.f4252b.f4132d.f4297c.setVisibility(0);
                }
                if (str2 == null) {
                    this.f4252b.f4132d.f4298d.setVisibility(8);
                } else {
                    this.f4252b.f4132d.f4298d.setVisibility(0);
                }
                this.f4252b.f4132d.f4297c.setText(str);
                return;
            }
            this.f4252b.f4132d.f4297c.setText(i);
        }
    }
}
