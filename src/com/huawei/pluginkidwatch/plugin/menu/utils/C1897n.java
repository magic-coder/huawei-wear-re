package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.app.Activity;
import android.content.Context;
import com.huawei.pluginkidwatch.common.ui.view.C1595v;
import com.huawei.pluginkidwatch.common.ui.view.C1596w;
import com.huawei.pluginkidwatch.common.ui.view.CustomDialog;

/* compiled from: LoadingDialog */
public class C1897n {
    private Context f6217a;
    private CustomDialog f6218b;

    public C1897n(Context context, CustomDialog customDialog) {
        this.f6217a = context;
        this.f6218b = customDialog;
    }

    public void m9667a(int i) {
        if (this.f6218b == null && !((Activity) this.f6217a).isFinishing()) {
            this.f6218b = new C1595v(this.f6217a).m7348b(i).m7344a(C1596w.PROGRESS).m7347a(false).m7338a();
            this.f6218b.show();
        }
    }

    public void m9666a() {
        if (this.f6218b != null) {
            this.f6218b.dismiss();
            this.f6218b = null;
        }
    }
}
