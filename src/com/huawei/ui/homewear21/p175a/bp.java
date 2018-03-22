package com.huawei.ui.homewear21.p175a;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class bp implements OnClickListener {
    final /* synthetic */ int f8088a;
    final /* synthetic */ C2217a f8089b;

    bp(C2217a c2217a, int i) {
        this.f8089b = c2217a;
        this.f8088a = i;
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        try {
            this.f8089b.startActivityForResult(intent, this.f8088a);
        } catch (ActivityNotFoundException e) {
            intent.setAction("android.settings.SETTINGS");
            try {
                this.f8089b.startActivityForResult(intent, this.f8088a);
            } catch (ActivityNotFoundException e2) {
                C2538c.m12679d("HomeFragment", "startActivity exception" + e2.getMessage());
            }
        }
    }
}
