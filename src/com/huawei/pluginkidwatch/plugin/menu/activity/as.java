package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: AddPeroidActivity */
class as implements OnClickListener {
    final /* synthetic */ AddPeroidActivity f5943a;

    as(AddPeroidActivity addPeroidActivity) {
        this.f5943a = addPeroidActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5943a.f5494j = "";
        for (int i2 = 0; i2 < this.f5943a.f5471D.length; i2++) {
            this.f5943a.f5470C[i2] = this.f5943a.f5471D[i2];
            if (this.f5943a.f5471D[i2]) {
                if (i2 == 0) {
                    this.f5943a.f5494j = this.f5943a.f5494j + "7";
                } else {
                    this.f5943a.f5494j = this.f5943a.f5494j + i2 + "";
                }
            }
        }
    }
}
