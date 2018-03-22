package com.huawei.hwservicesmgr.remote;

import com.huawei.p029c.C4334c;
import com.huawei.p190v.C2538c;

import java.util.Map;

class HWExerciseAdviceManager$6 implements C4334c {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    HWExerciseAdviceManager$6(HWExerciseAdviceManager hWExerciseAdviceManager) {
        this.this$0 = hWExerciseAdviceManager;
    }

    public void onResponse(int i, Object obj) {
        boolean z = false;
        C2538c.c("HWExerciseAdviceManager", new Object[]{"数据返回了 err_code = " + i + " objData = " + obj});
        if (10000 == i) {
            for (int i2 = 0; i2 < HWExerciseAdviceManager.access$2700(this.this$0).size(); i2++) {
                Object[] objArr = (Object[]) obj;
                Map map = (Map) objArr[0];
                C2538c.c("HWExerciseAdviceManager", new Object[]{"数据返回了 lstGPSWorkoutRecordID.get(i) = " + HWExerciseAdviceManager.access$2700(this.this$0).get(i2) + " type = " + ((Map) objArr[1]).get(HWExerciseAdviceManager.access$2700(this.this$0).get(i2))});
                HWExerciseAdviceManager.access$2800(this.this$0).put(HWExerciseAdviceManager.access$2700(this.this$0).get(i2), r0.get(HWExerciseAdviceManager.access$2700(this.this$0).get(i2)));
                HWExerciseAdviceManager.access$2900(this.this$0).put(HWExerciseAdviceManager.access$2700(this.this$0).get(i2), map.get(HWExerciseAdviceManager.access$2700(this.this$0).get(i2)));
            }
            z = true;
        } else {
            C2538c.e("HWExerciseAdviceManager", new Object[]{"getWorkOutDetailFromDevice() callback error = " + obj});
        }
        HWExerciseAdviceManager.access$3000(this.this$0, z);
    }
}
