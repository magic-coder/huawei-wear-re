package com.huawei.hwservicesmgr.remote;

import com.huawei.hihealth.HiSyncOption;
import com.huawei.hihealth.a.b;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;

class HWExerciseAdviceManager$15 implements Runnable {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    HWExerciseAdviceManager$15(HWExerciseAdviceManager hWExerciseAdviceManager) {
        this.this$0 = hWExerciseAdviceManager;
    }

    public void run() {
        C2538c.c("HWExerciseAdviceManager", new Object[]{"triggerHiHealthCloutSync enter thread"});
        HiSyncOption hiSyncOption = new HiSyncOption();
        hiSyncOption.setSyncModel(2);
        hiSyncOption.setSyncAction(2);
        hiSyncOption.setSyncDataType(20000);
        hiSyncOption.setSyncMethod(2);
        b.a(BaseApplication.b()).a(hiSyncOption, null);
    }
}
