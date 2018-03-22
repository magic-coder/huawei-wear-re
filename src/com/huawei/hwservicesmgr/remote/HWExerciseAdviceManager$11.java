package com.huawei.hwservicesmgr.remote;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class HWExerciseAdviceManager$11 implements IBaseResponseCallback {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    HWExerciseAdviceManager$11(HWExerciseAdviceManager hWExerciseAdviceManager) {
        this.this$0 = hWExerciseAdviceManager;
    }

    public void onResponse(int i, Object obj) {
        if (100000 == i) {
            try {
                JSONObject jSONObject;
                HWExerciseAdviceManager.access$4202(this.this$0, new JSONObject((String) ((Map) obj).get("value")));
                JSONArray jSONArray = HWExerciseAdviceManager.access$4200(this.this$0).getJSONArray("workoutRecordStructList");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    jSONObject = (JSONObject) jSONArray.get(i2);
                    C2538c.c("HWExerciseAdviceManager", new Object[]{"get workout paceIndex count is " + jSONObject.optInt("paceIndexCount", -1)});
                    HWExerciseAdviceManager.access$4300(this.this$0, jSONObject.optInt("workout_record_id"), r4);
                }
                HWExerciseAdviceManager.access$3502(this.this$0, 0);
                HWExerciseAdviceManager.access$3600(this.this$0).clear();
                HWExerciseAdviceManager.access$2700(this.this$0).clear();
                if (HWExerciseAdviceManager.access$4200(this.this$0) == null || HWExerciseAdviceManager.access$4200(this.this$0).getInt("workout_record_count") <= 0) {
                    jSONObject = new JSONObject();
                    jSONObject.put("startTime", HWExerciseAdviceManager.access$2000(this.this$0));
                    jSONObject.put("endTime", HWExerciseAdviceManager.access$600(this.this$0));
                    HWExerciseAdviceManager.access$4400(this.this$0, jSONObject);
                    return;
                }
                HWExerciseAdviceManager.access$3700(this.this$0);
                return;
            } catch (JSONException e) {
                C2538c.e("HWExerciseAdviceManager", new Object[]{e.getMessage()});
                return;
            }
        }
        C2538c.e("HWExerciseAdviceManager", new Object[]{"getWorkoutRecord error, error code=" + i});
        HWExerciseAdviceManager.access$100(this.this$0, i, "getDeviceWorkoutRecordIdList");
    }
}
