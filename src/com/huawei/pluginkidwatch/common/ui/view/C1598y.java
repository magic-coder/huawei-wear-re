package com.huawei.pluginkidwatch.common.ui.view;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.g;

/* compiled from: CustomDialog */
class C1598y implements OnClickListener {
    final /* synthetic */ C1597x f4008a;

    C1598y(C1597x c1597x) {
        this.f4008a = c1597x;
    }

    public void onClick(View view) {
        Message message = null;
        int id = view.getId();
        if (id == g.k1_dialog_btn_positive) {
            message = Message.obtain(this.f4008a.f4004q);
        } else if (id == g.k1_dialog_btn_negative) {
            message = Message.obtain(this.f4008a.f4006s);
        } else if (id == g.k1_dialog_btn_neutral) {
            message = Message.obtain(this.f4008a.f4005r);
        }
        if (message != null) {
            message.sendToTarget();
        }
        if (this.f4008a.f4007t) {
            CustomDialog.f3800a.obtainMessage(1).sendToTarget();
        }
    }
}
