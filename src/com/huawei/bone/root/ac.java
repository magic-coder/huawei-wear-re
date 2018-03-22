package com.huawei.bone.root;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ServiceAreaActivity */
class ac implements OnClickListener {
    final /* synthetic */ ServiceAreaActivity f23297a;

    ac(ServiceAreaActivity serviceAreaActivity) {
        this.f23297a = serviceAreaActivity;
    }

    public void onClick(View view) {
        this.f23297a.startActivityForResult(new Intent(this.f23297a.f23269c, ServiceCountryActivity.class), 1);
    }
}
