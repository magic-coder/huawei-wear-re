package com.huawei.pluginaf500.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.fenda.hwbracelet.connection.C3596n;
import com.huawei.pluginaf500.h;

/* compiled from: ResetBraceletActivity */
class bd implements OnClickListener {
    final /* synthetic */ ResetBraceletActivity f19924a;

    bd(ResetBraceletActivity resetBraceletActivity) {
        this.f19924a = resetBraceletActivity;
    }

    public void onClick(View view) {
        if (3 == C3596n.m18054a()) {
            this.f19924a.m26787j();
        } else {
            Toast.makeText(this.f19924a, this.f19924a.getString(h.no_connect_note), 0).show();
        }
    }
}
