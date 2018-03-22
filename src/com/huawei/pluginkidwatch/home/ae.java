package com.huawei.pluginkidwatch.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: HomeActivity */
class ae implements OnClickListener {
    final /* synthetic */ ad f4167a;

    ae(ad adVar) {
        this.f4167a = adVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f4167a.f4166a.f4136i != null) {
            this.f4167a.f4166a.f4136i.dismiss();
            this.f4167a.f4166a.f4136i.cancel();
        }
    }
}
