package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: AddAlarmActivity */
class C1862e implements OnClickListener {
    final /* synthetic */ int f6063a;
    final /* synthetic */ String f6064b;
    final /* synthetic */ AddAlarmActivity f6065c;

    C1862e(AddAlarmActivity addAlarmActivity, int i, String str) {
        this.f6065c = addAlarmActivity;
        this.f6063a = i;
        this.f6064b = str;
    }

    public void onClick(View view) {
        this.f6065c.f5377w.cancel();
        this.f6065c.f5377w = null;
        for (int i = 0; i < this.f6065c.f5354N.length; i++) {
            this.f6065c.f5354N[i] = false;
        }
        this.f6065c.f5354N[this.f6063a] = true;
        this.f6065c.f5378x = this.f6064b;
        this.f6065c.m8953b(this.f6064b);
        C2538c.m12674b("AddAlarmActivity", "========showSelfDefineDialog changeThemeDialog cancle onClick!!!");
    }
}
