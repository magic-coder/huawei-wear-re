package com.huawei.hwservicesmgr.remote;

import android.content.Intent;
import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.p190v.C2538c;

class HWExerciseAdviceManager$2 implements C3951c {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    HWExerciseAdviceManager$2(HWExerciseAdviceManager hWExerciseAdviceManager) {
        this.this$0 = hWExerciseAdviceManager;
    }

    public void onResult(int i, Object obj) {
        C2538c.c("HWExerciseAdviceManager", new Object[]{"saveTrackData MotionPath onSuccess obj = " + obj + ",type = " + i + ", DataItemNum=" + HWExerciseAdviceManager.access$1000(this.this$0)});
        HWExerciseAdviceManager.access$1010(this.this$0);
        if (HWExerciseAdviceManager.access$1000(this.this$0) == 0) {
            C2538c.c("HWExerciseAdviceManager", new Object[]{"saveTrackData finished broardCast to health"});
            HWExerciseAdviceManager.access$1100(this.this$0).sendBroadcast(new Intent(HWExerciseAdviceManager.WORKOUT_RECORD_SAVE_FINISH));
            this.this$0.triggerHiHealthCloutSync();
        }
    }
}
