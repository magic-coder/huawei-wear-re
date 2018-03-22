package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.fenda.hwbracelet.connection.C3596n;

/* compiled from: ResetBraceletActivity */
class be implements OnClickListener {
    final /* synthetic */ ResetBraceletActivity f19925a;

    be(ResetBraceletActivity resetBraceletActivity) {
        this.f19925a = resetBraceletActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (3 != C3596n.m18054a()) {
            this.f19925a.m26788k();
        } else if (this.f19925a.m26514e() != null) {
            CharSequence b = this.f19925a.m26514e().m26560b();
            this.f19925a.m26511b();
            if (TextUtils.isEmpty(b)) {
                this.f19925a.f.sendEmptyMessage(102);
            } else {
                this.f19925a.f.sendEmptyMessage(101);
            }
        }
    }
}
