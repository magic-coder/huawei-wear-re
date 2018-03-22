package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.Handler;
import android.os.Message;

/* compiled from: ImportContactActivity */
class ev extends Handler {
    final /* synthetic */ ImportContactActivity f6103a;

    ev(ImportContactActivity importContactActivity) {
        this.f6103a = importContactActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 4:
                this.f6103a.m9439b();
                return;
            case 5:
                this.f6103a.f5769l.m8885a(null);
                return;
            case 6:
                if (this.f6103a.f5767j == null || this.f6103a.f5767j.size() <= 0) {
                    this.f6103a.f5769l.m8885a(null);
                    return;
                } else {
                    this.f6103a.f5769l.m8885a(this.f6103a.f5767j);
                    return;
                }
            case 7:
                if (this.f6103a.f5768k == null || this.f6103a.f5768k.size() <= 0) {
                    this.f6103a.f5769l.m8885a(null);
                    return;
                } else {
                    this.f6103a.f5769l.m8885a(this.f6103a.f5768k);
                    return;
                }
            default:
                return;
        }
    }
}
