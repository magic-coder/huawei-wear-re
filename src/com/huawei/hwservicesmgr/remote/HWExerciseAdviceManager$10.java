package com.huawei.hwservicesmgr.remote;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class HWExerciseAdviceManager$10 implements IBaseResponseCallback {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    HWExerciseAdviceManager$10(HWExerciseAdviceManager hWExerciseAdviceManager) {
        this.this$0 = hWExerciseAdviceManager;
    }

    public void onResponse(int i, Object obj) {
        if (obj != null) {
            try {
                Object obj2 = ((Map) obj).get("value");
                if (100000 == i) {
                    C2538c.c("HWExerciseAdviceManager", new Object[]{"the value is " + obj2.toString()});
                    C2538c.c("HWExerciseAdviceManager", new Object[]{"the value is instanceof a list " + (obj2 instanceof List)});
                    JSONObject jSONObject = new JSONArray(obj2.toString()).getJSONObject(0);
                    jSONObject.put("run_plan_record_info_wourkout_id", HWExerciseAdviceManager.access$3900(this.this$0).getJSONArray("runPlanRecordStructList").getJSONObject(HWExerciseAdviceManager.access$3800(this.this$0)).getInt("run_plan_workout_id"));
                    HWExerciseAdviceManager.access$4000(this.this$0).put(jSONObject.getInt("run_plan_record_info_id"), jSONObject);
                    HWExerciseAdviceManager.access$3808(this.this$0);
                    HWExerciseAdviceManager.access$3300(this.this$0).add(Integer.valueOf(jSONObject.getInt("run_plan_record_info_id")));
                    HWExerciseAdviceManager.access$4100(this.this$0);
                    return;
                }
                C2538c.e("HWExerciseAdviceManager", new Object[]{"getDeviceRunPlanRecordStatistic error ,error=" + i});
                HWExerciseAdviceManager.access$100(this.this$0, i, "getDeviceRunPlanRecordStatistic");
            } catch (JSONException e) {
                C2538c.e("HWExerciseAdviceManager", new Object[]{e.getMessage()});
            }
        }
    }
}
