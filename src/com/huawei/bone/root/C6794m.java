package com.huawei.bone.root;

import android.os.Looper;
import android.os.Message;
import com.huawei.hwcommonmodel.c.a;

/* compiled from: MainActivity */
class C6794m extends a<MainActivity> {
    public C6794m(Looper looper, MainActivity mainActivity) {
        super(looper, mainActivity);
    }

    protected void m30211a(MainActivity mainActivity, Message message) {
        switch (message.what) {
            case 100:
                mainActivity.m30129j();
                return;
            case 101:
                mainActivity.m30108a(mainActivity.f23220k);
                return;
            default:
                return;
        }
    }
}
