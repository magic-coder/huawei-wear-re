package com.huawei.ui.homewear21.card.p176a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceStateInteractors */
class C2245c implements OnClickListener {
    final /* synthetic */ C2243a f8166a;

    C2245c(C2243a c2243a) {
        this.f8166a = c2243a;
    }

    public void onClick(View view) {
        C2538c.m12677c(C2243a.f8159a, "showAppStoreDialog():点击不同意下载华为应用市场APP!");
        this.f8166a.f8163e.dismiss();
    }
}
