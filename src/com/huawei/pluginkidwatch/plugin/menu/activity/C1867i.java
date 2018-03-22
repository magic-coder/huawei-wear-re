package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: AddAlarmActivity */
class C1867i implements OnClickListener {
    final /* synthetic */ AddAlarmActivity f6172a;

    C1867i(AddAlarmActivity addAlarmActivity) {
        this.f6172a = addAlarmActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6172a.f5375u = "";
        for (int i2 = 0; i2 < this.f6172a.f5352L.length; i2++) {
            this.f6172a.f5351K[i2] = this.f6172a.f5352L[i2];
            if (this.f6172a.f5352L[i2]) {
                if (i2 == 0) {
                    this.f6172a.f5375u = this.f6172a.f5375u + "7";
                } else {
                    this.f6172a.f5375u = this.f6172a.f5375u + i2 + "";
                }
            }
        }
    }
}
