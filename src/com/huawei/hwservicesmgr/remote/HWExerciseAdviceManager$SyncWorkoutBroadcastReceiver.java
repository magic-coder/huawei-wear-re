package com.huawei.hwservicesmgr.remote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

class HWExerciseAdviceManager$SyncWorkoutBroadcastReceiver extends BroadcastReceiver {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    private HWExerciseAdviceManager$SyncWorkoutBroadcastReceiver(HWExerciseAdviceManager hWExerciseAdviceManager) {
        this.this$0 = hWExerciseAdviceManager;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c("HWExerciseAdviceManager", new Object[]{"SyncWorkoutBroadcastReceiver has received a broadcast"});
        this.this$0.syncDeviceWorkoutRecordInfo(null);
    }
}
