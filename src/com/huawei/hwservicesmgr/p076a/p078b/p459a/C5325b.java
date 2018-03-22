package com.huawei.hwservicesmgr.p076a.p078b.p459a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

/* compiled from: FileApplicationUtil */
class C5325b extends Handler {
    C5325b(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                C2538c.c("FileApplicationUtil", new Object[]{" SEND_FILE sendNumIndex = " + C5326c.m25779j() + " offset = " + C5326c.m25775h() + " indexList.size() = " + C5326c.m25783l().size()});
                sendEmptyMessageDelayed(1, (long) C5326c.m25767d());
                byte[] b = C5324a.m25754c();
                if (C5326c.m25779j() >= C5326c.m25783l().size()) {
                    C2538c.c("FileApplicationUtil", new Object[]{" index error"});
                    removeMessages(1);
                    return;
                }
                C2538c.c("FileApplicationUtil", new Object[]{" SEND_FILE byteBuffer = " + C0973a.a(b) + " byteBuffer.length = " + b.length + " indexList.get(sendNumIndex) = " + C5326c.m25783l().get(C5326c.m25779j()) + " sendNumIndex = " + C5326c.m25779j()});
                if (b.length != 0) {
                    C5324a.m25751b(b, ((Integer) C5326c.m25783l().get(C5326c.m25779j())).intValue());
                    C5326c.m25776h(C5326c.m25779j() + 1);
                    if (C5326c.m25779j() == C5326c.m25783l().size()) {
                        removeMessages(1);
                        C5326c.m25776h(0);
                        return;
                    }
                    return;
                }
                removeMessages(1);
                return;
            default:
                return;
        }
    }
}
