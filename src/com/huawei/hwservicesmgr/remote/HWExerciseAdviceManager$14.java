package com.huawei.hwservicesmgr.remote;

import com.huawei.datatype.PaceIndexStruct;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class HWExerciseAdviceManager$14 implements IBaseResponseCallback {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    HWExerciseAdviceManager$14(HWExerciseAdviceManager hWExerciseAdviceManager) {
        this.this$0 = hWExerciseAdviceManager;
    }

    public void onResponse(int i, Object obj) {
        if (100000 == i) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(((Map) obj).get("value").toString());
            } catch (JSONException e) {
                C2538c.e("HWExerciseAdviceManager", new Object[]{e.getMessage()});
                jSONObject = null;
            }
            if (jSONObject != null) {
                HWExerciseAdviceManager.access$2300(this.this$0).add(jSONObject);
                int i2 = 0;
                while (i2 < HWExerciseAdviceManager.access$4800(this.this$0).size()) {
                    try {
                        if (jSONObject.getInt("workout_data_index") == ((JSONObject) HWExerciseAdviceManager.access$4800(this.this$0).get(i2)).getInt("workout_data_index") && jSONObject.getInt("workout_record_id") == ((JSONObject) HWExerciseAdviceManager.access$4800(this.this$0).get(i2)).getInt("workout_record_id")) {
                            HWExerciseAdviceManager.access$4800(this.this$0).remove(i2);
                            break;
                        }
                        i2++;
                    } catch (JSONException e2) {
                        C2538c.e("HWExerciseAdviceManager", new Object[]{e2.getMessage()});
                        return;
                    }
                }
                if (HWExerciseAdviceManager.access$4800(this.this$0).size() > 0) {
                    HWExerciseAdviceManager.access$4900(this.this$0, (JSONObject) HWExerciseAdviceManager.access$4800(this.this$0).get(0));
                    return;
                } else if (!HWExerciseAdviceManager.access$5000(this.this$0) || HWExerciseAdviceManager.access$2400(this.this$0).size() <= 0) {
                    HWExerciseAdviceManager.access$3200(this.this$0);
                    return;
                } else {
                    HWExerciseAdviceManager.access$3100(this.this$0, (PaceIndexStruct) HWExerciseAdviceManager.access$2400(this.this$0).get(0));
                    return;
                }
            }
            return;
        }
        HWExerciseAdviceManager.access$100(this.this$0, i, "getWorkoutDetailData");
    }
}
