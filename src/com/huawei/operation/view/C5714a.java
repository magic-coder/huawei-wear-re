package com.huawei.operation.view;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.huawei.operation.f;

/* compiled from: CustomWebView */
class C5714a extends Handler {
    final /* synthetic */ CustomWebView f19485a;

    C5714a(CustomWebView customWebView) {
        this.f19485a = customWebView;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                this.f19485a.f19481e.setText((String) message.obj);
                return;
            case 2:
                Toast.makeText(this.f19485a.f19480d, (String) message.obj, 0).show();
                return;
            case 3:
                Toast.makeText(this.f19485a.f19480d, f.IDS_plugin_operation_connect_network, 0).show();
                return;
            default:
                return;
        }
    }
}
