package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: ImportContactActivity */
class fb implements OnClickListener {
    final /* synthetic */ ImportContactActivity f6112a;

    fb(ImportContactActivity importContactActivity) {
        this.f6112a = importContactActivity;
    }

    public void onClick(View view) {
        if (this.f6112a.f5777t) {
            C1497q.m6942a(this.f6112a, "importcontactbooleanyes", Boolean.valueOf(true));
            this.f6112a.finish();
            return;
        }
        C1483c.m6832c(this.f6112a, "请选择一位联系人");
    }
}
