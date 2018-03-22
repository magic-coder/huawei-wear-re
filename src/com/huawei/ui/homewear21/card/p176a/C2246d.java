package com.huawei.ui.homewear21.card.p176a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceStateInteractors */
class C2246d implements OnClickListener {
    final /* synthetic */ Intent f8167a;
    final /* synthetic */ Context f8168b;
    final /* synthetic */ C2243a f8169c;

    C2246d(C2243a c2243a, Intent intent, Context context) {
        this.f8169c = c2243a;
        this.f8167a = intent;
        this.f8168b = context;
    }

    public void onClick(View view) {
        C2538c.m12677c(C2243a.f8159a, "showAppStoreDialog():点击下载华为应用市场APP.");
        if (this.f8167a.getPackage() == null) {
            C2538c.m12680e(C2243a.f8159a, "Cannot resolve activity for appStore intent: " + this.f8167a);
            return;
        }
        try {
            this.f8168b.startActivity(this.f8167a);
        } catch (ActivityNotFoundException e) {
            C2538c.m12680e(C2243a.f8159a, "Cannot resolve activity for appstore intent: " + this.f8167a);
        }
    }
}
