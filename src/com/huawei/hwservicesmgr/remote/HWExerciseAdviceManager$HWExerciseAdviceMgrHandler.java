package com.huawei.hwservicesmgr.remote;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.p190v.C2538c;

class HWExerciseAdviceManager$HWExerciseAdviceMgrHandler extends Handler {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    public HWExerciseAdviceManager$HWExerciseAdviceMgrHandler(HWExerciseAdviceManager hWExerciseAdviceManager, Looper looper) {
        this.this$0 = hWExerciseAdviceManager;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.c("HWExerciseAdviceManager", new Object[]{"handleMessage msg = " + message.what});
        switch (message.what) {
            case 0:
                HWExerciseAdviceManager.access$100(this.this$0, 300001, "TIMEOUT");
                C2538c.c("HWExerciseAdviceManager", new Object[]{"-----------------reset maintenance flag delete this code! have problem!--------------"});
                return;
            case 1:
                HWExerciseAdviceManager.access$200(this.this$0);
                return;
            case 4:
                if (!HWExerciseAdviceManager.access$300(this.this$0)) {
                    return;
                }
                return;
            default:
                return;
        }
    }
}
