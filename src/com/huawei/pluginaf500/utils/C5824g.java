package com.huawei.pluginaf500.utils;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginaf500.e;

/* compiled from: CustomDialog */
class C5824g implements OnClickListener {
    final /* synthetic */ C5823f f20022a;

    C5824g(C5823f c5823f) {
        this.f20022a = c5823f;
    }

    public void onClick(View view) {
        Message message = null;
        int id = view.getId();
        if (id == e.positive_btn) {
            message = Message.obtain(this.f20022a.f20020n);
        } else if (id == e.negative_btn) {
            message = Message.obtain(this.f20022a.f20021o);
        }
        if (message != null) {
            message.sendToTarget();
        }
        this.f20022a.f20019m.obtainMessage(1).sendToTarget();
    }
}
