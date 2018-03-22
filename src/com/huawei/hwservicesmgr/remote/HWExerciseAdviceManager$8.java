package com.huawei.hwservicesmgr.remote;

import com.huawei.p029c.C4334c;
import com.huawei.p190v.C2538c;

import java.util.Map;

class HWExerciseAdviceManager$8 implements C4334c {
    final /* synthetic */ HWExerciseAdviceManager this$0;
    final /* synthetic */ boolean val$isSuccess;

    HWExerciseAdviceManager$8(HWExerciseAdviceManager hWExerciseAdviceManager, boolean z) {
        this.this$0 = hWExerciseAdviceManager;
        this.val$isSuccess = z;
    }

    public void onResponse(int i, Object obj) {
        boolean z;
        boolean z2 = this.val$isSuccess;
        if (10000 == i) {
            for (int i2 = 0; i2 < HWExerciseAdviceManager.access$3300(this.this$0).size(); i2++) {
                Object[] objArr = (Object[]) obj;
                Map map = (Map) objArr[0];
                C2538c.c("HWExerciseAdviceManager", new Object[]{"数据返回了 getRunPlanDetailFromDevice.get(i) = " + HWExerciseAdviceManager.access$3300(this.this$0).get(i2) + " type = " + ((Map) objArr[1]).get(HWExerciseAdviceManager.access$3300(this.this$0).get(i2))});
                HWExerciseAdviceManager.access$3400(this.this$0).put(HWExerciseAdviceManager.access$3300(this.this$0).get(i2), map.get(HWExerciseAdviceManager.access$3300(this.this$0).get(i2)));
                HWExerciseAdviceManager.access$2800(this.this$0).put(HWExerciseAdviceManager.access$3300(this.this$0).get(i2), r0.get(HWExerciseAdviceManager.access$3300(this.this$0).get(i2)));
            }
            z = z2;
        } else {
            C2538c.e("HWExerciseAdviceManager", new Object[]{"getRunPlanDetailFromDevice() callback error = " + obj});
            z = false;
        }
        if (z) {
            HWExerciseAdviceManager.access$100(this.this$0, 0, null);
        } else {
            HWExerciseAdviceManager.access$100(this.this$0, -1, null);
        }
    }
}
