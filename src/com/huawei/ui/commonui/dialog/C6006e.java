package com.huawei.ui.commonui.dialog;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.ui.commonui.C6030g;

/* compiled from: CustomAlertDialog */
class C6006e implements OnClickListener {
    final /* synthetic */ C6005d f20700a;

    C6006e(C6005d c6005d) {
        this.f20700a = c6005d;
    }

    public void onClick(View view) {
        Message message = null;
        int id = view.getId();
        if (id == C6030g.dialog_btn_positive) {
            message = Message.obtain(this.f20700a.f20693p);
        } else if (id == C6030g.dialog_btn_negative) {
            message = Message.obtain(this.f20700a.f20695r);
        } else if (id == C6030g.dialog_btn_neutral) {
            message = Message.obtain(this.f20700a.f20694q);
        }
        if (message != null) {
            message.sendToTarget();
        }
        CustomAlertDialog.f20612a.obtainMessage(1).sendToTarget();
    }
}
