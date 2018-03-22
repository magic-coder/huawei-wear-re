package com.huawei.pluginkidwatch.common.ui.button;

import android.os.Handler;
import android.os.Message;

/* compiled from: SwitchButtonAnimation */
public class C1517f {
    private static final Handler f3566a = new C1519h();

    public static void m7014a(Runnable runnable, int i) {
        Message message = new Message();
        message.what = 1000;
        message.obj = runnable;
        f3566a.sendMessageDelayed(message, (long) i);
    }
}
