package com.huawei.ai;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* compiled from: AuthenticationManager */
class C4016e extends Handler {
    final /* synthetic */ C4010a f15303a;

    public C4016e(C4010a c4010a, Looper looper) {
        this.f15303a = c4010a;
        super(looper);
    }

    public void handleMessage(Message message) {
        boolean z = true;
        switch (message.what) {
            case 1:
                if (this.f15303a.f15298e != null) {
                    this.f15303a.f15298e.onWaitingForInput();
                    return;
                }
                return;
            case 2:
                Log.d("AuthenticationManager", "xFinger--onInput :MSG_FINGER_PRESENT in AuthenticationManager");
                if (this.f15303a.f15298e != null) {
                    this.f15303a.f15298e.onInput();
                    return;
                }
                return;
            case 3:
                Log.d("AuthenticationManager", "xFinger--onCaptureCompleted :MSG_FINGER_UP in AuthenticationManager");
                if (this.f15303a.f15298e != null) {
                    this.f15303a.f15298e.onCaptureCompleted();
                    return;
                }
                return;
            case 6:
                if (this.f15303a.f15299f != null) {
                    C4017f b = this.f15303a.f15299f;
                    int i = message.arg1;
                    byte[] bArr = (byte[]) message.obj;
                    if (message.arg2 != 1) {
                        z = false;
                    }
                    b.onIdentified(i, bArr, z);
                    return;
                }
                return;
            case 7:
                if (this.f15303a.f15299f != null) {
                    this.f15303a.f15299f.onNoMatch(message.arg1);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
