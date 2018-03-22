package com.huawei.hwservicesmgr.remote;

import com.huawei.datatype.PaceIndexStruct;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class HWExerciseAdviceManager$7 implements IBaseResponseCallback {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    HWExerciseAdviceManager$7(HWExerciseAdviceManager hWExerciseAdviceManager) {
        this.this$0 = hWExerciseAdviceManager;
    }

    public void onResponse(int i, Object obj) {
        if (100000 == i) {
            JSONObject jSONObject;
            try {
                C2538c.c("HWExerciseAdviceManager", new Object[]{"getWorkoutRecordPaceMapCallback==value.toString()：" + ((Map) obj).get("value").toString()});
                jSONObject = new JSONObject(((Map) obj).get("value").toString());
            } catch (JSONException e) {
                C2538c.e("HWExerciseAdviceManager", new Object[]{e.getMessage()});
                jSONObject = null;
            }
            if (jSONObject != null) {
                HWExerciseAdviceManager.access$2500(this.this$0).add(jSONObject);
                try {
                    C2538c.c("HWExerciseAdviceManager", new Object[]{"===getWorkoutRecordPaceMapCallback workoutID =" + jSONObject.get("workout_record_id")});
                    int i2 = 0;
                    while (i2 < HWExerciseAdviceManager.access$2400(this.this$0).size()) {
                        C2538c.c("HWExerciseAdviceManager", new Object[]{"xxxxxxxxxxxxxxxxx===getWorkoutRecordPaceMapCallback workoutID =" + jSONObject.getInt("workout_record_id") + ";paceIndex:" + jSONObject.optInt("paceIndex", -1)});
                        if (jSONObject.getInt("workout_record_id") == ((PaceIndexStruct) HWExerciseAdviceManager.access$2400(this.this$0).get(i2)).getRecordId() && jSONObject.optInt("paceIndex", -1) == ((PaceIndexStruct) HWExerciseAdviceManager.access$2400(this.this$0).get(i2)).getPaceIndex()) {
                            C2538c.c("HWExerciseAdviceManager", new Object[]{"xxxxxxxxxxxxxxxxx==remove"});
                            HWExerciseAdviceManager.access$2400(this.this$0).remove(i2);
                            break;
                        }
                        i2++;
                    }
                    if (HWExerciseAdviceManager.access$2400(this.this$0).size() > 0) {
                        HWExerciseAdviceManager.access$3100(this.this$0, (PaceIndexStruct) HWExerciseAdviceManager.access$2400(this.this$0).get(0));
                        return;
                    } else {
                        HWExerciseAdviceManager.access$3200(this.this$0);
                        return;
                    }
                } catch (JSONException e2) {
                    C2538c.e("HWExerciseAdviceManager", new Object[]{e2.getMessage()});
                    return;
                }
            }
            return;
        }
        HWExerciseAdviceManager.access$100(this.this$0, i, "getWorkoutRecordPaceMap");
    }
}
