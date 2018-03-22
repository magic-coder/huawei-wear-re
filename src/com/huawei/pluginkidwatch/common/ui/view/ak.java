package com.huawei.pluginkidwatch.common.ui.view;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.common.lib.p148c.C1466a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: SlectPictureDialog */
class ak implements OnClickListener {
    final /* synthetic */ Activity f3856a;
    final /* synthetic */ Uri f3857b;
    final /* synthetic */ ah f3858c;

    ak(ah ahVar, Activity activity, Uri uri) {
        this.f3858c = ahVar;
        this.f3856a = activity;
        this.f3857b = uri;
    }

    public void onClick(View view) {
        if (C1492l.m6913a(this.f3856a, C1466a.m6779c())) {
            this.f3858c.m7248b(this.f3856a, this.f3857b);
        } else {
            C1492l.m6910a(this.f3856a, C1466a.m6779c());
        }
        this.f3858c.m7245a(this.f3858c.f3844a);
    }
}
