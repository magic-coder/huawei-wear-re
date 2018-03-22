package com.huawei.hwservicesmgr.remote;

import com.huawei.datatype.RunPlanParameter;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

class HWExerciseAdviceManager$13 implements IBaseResponseCallback {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    HWExerciseAdviceManager$13(HWExerciseAdviceManager hWExerciseAdviceManager) {
        this.this$0 = hWExerciseAdviceManager;
    }

    public void onResponse(int i, Object obj) {
        if (100000 == i) {
            RunPlanParameter runPlanParameter = (RunPlanParameter) obj;
            HWExerciseAdviceManager.access$4600(this.this$0)[0] = runPlanParameter.getRun_plan_sync_size() / 256;
            HWExerciseAdviceManager.access$4600(this.this$0)[1] = runPlanParameter.getRun_plan_sync_size() % 256;
            HWExerciseAdviceManager.access$4702(runPlanParameter.getRun_plan_sign());
            C2538c.c("HWExerciseAdviceManager", new Object[]{"syncsize[0]=" + HWExerciseAdviceManager.access$4600(this.this$0)[0] + ",syncsize[1]=" + HWExerciseAdviceManager.access$4600(this.this$0)[1] + ",deviceSHAValue=" + HWExerciseAdviceManager.access$4700()});
            return;
        }
        C2538c.e("HWExerciseAdviceManager", new Object[]{"getAdviceParam fail err=" + i});
    }
}
