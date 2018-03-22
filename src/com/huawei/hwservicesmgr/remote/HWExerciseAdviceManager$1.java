package com.huawei.hwservicesmgr.remote;

import com.huawei.hwservicesmgr.remote.utils.RemoteUtils;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.huawei.p190v.C2538c;

class HWExerciseAdviceManager$1 implements Runnable {
    final /* synthetic */ HWExerciseAdviceManager this$0;
    final /* synthetic */ int val$errCode;

    HWExerciseAdviceManager$1(HWExerciseAdviceManager hWExerciseAdviceManager, int i) {
        this.this$0 = hWExerciseAdviceManager;
        this.val$errCode = i;
    }

    public void run() {
        if (HWExerciseAdviceManager.access$400(this.this$0).equals(this.this$0.getCurrDeviceId())) {
            HWExerciseAdviceManager.access$500(this.this$0);
            if (this.val$errCode == 0) {
                HWExerciseAdviceManager.access$700(this.this$0, HWExerciseAdviceManager.access$600(this.this$0));
            } else {
                C2538c.e("HWExerciseAdviceManager", new Object[]{"sync start device is not same with end device, or gps error,don't save timestamp"});
            }
        }
        HWExerciseAdviceManager.access$802(this.this$0, false);
        if (HWExerciseAdviceManager.access$900(this.this$0) != null) {
            HWExerciseAdviceManager.access$900(this.this$0).onResponse(100000, RemoteUtils.generateRetMap(LightCloudConstants.RESPONSE_RESULT_SUCCESS, "syncDeviceWorkoutRecordInfo"));
        }
    }
}
