package com.huawei.sim.multisim;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: MultiSimConfigActivity */
class C5966q implements OnItemClickListener {
    final /* synthetic */ MultiSimConfigActivity f20546a;

    private C5966q(MultiSimConfigActivity multiSimConfigActivity) {
        this.f20546a = multiSimConfigActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"onItemClick  positon=", Integer.valueOf(i)});
        for (int i2 = 0; i2 < this.f20546a.f20482L.length; i2++) {
            this.f20546a.f20483M[i2] = false;
        }
        this.f20546a.f20483M[i] = true;
        ((C5962m) this.f20546a.f20496Z.getAdapter()).notifyDataSetChanged();
    }
}
