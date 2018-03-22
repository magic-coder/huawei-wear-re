package com.huawei.hwservicesmgr.remote;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class HWExerciseAdviceManager$9 implements IBaseResponseCallback {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    HWExerciseAdviceManager$9(HWExerciseAdviceManager hWExerciseAdviceManager) {
        this.this$0 = hWExerciseAdviceManager;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWExerciseAdviceManager", new Object[]{"enter getDeviceWorkoutRecordStatistic response, the mWorkoutRecordStatisticIndex is " + HWExerciseAdviceManager.access$3500(this.this$0)});
        if (100000 != i) {
            C2538c.e("HWExerciseAdviceManager", new Object[]{"getRecordStatistic error ,error=" + i});
            HWExerciseAdviceManager.access$100(this.this$0, i, "getDeviceWorkoutRecordStatistic");
        } else if (obj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) ((Map) obj).get("value"));
                HWExerciseAdviceManager.access$3600(this.this$0).put(jSONObject.getInt("workout_record_id"), jSONObject);
                HWExerciseAdviceManager.access$3508(this.this$0);
                HWExerciseAdviceManager.access$2700(this.this$0).add(Integer.valueOf(jSONObject.getInt("workout_record_id")));
                HWExerciseAdviceManager.access$3700(this.this$0);
            } catch (JSONException e) {
                C2538c.e("HWExerciseAdviceManager", new Object[]{e.getMessage()});
            }
        }
    }
}
