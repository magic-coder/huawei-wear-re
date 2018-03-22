package com.huawei.hwservicesmgr.remote;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class HWExerciseAdviceManager$12 implements IBaseResponseCallback {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    HWExerciseAdviceManager$12(HWExerciseAdviceManager hWExerciseAdviceManager) {
        this.this$0 = hWExerciseAdviceManager;
    }

    public void onResponse(int i, Object obj) {
        if (100000 == i) {
            try {
                HWExerciseAdviceManager.access$3902(this.this$0, new JSONObject(((Map) obj).get("value").toString()));
                JSONArray jSONArray = HWExerciseAdviceManager.access$3900(this.this$0).getJSONArray("runPlanRecordStructList");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    C2538c.c("HWExerciseAdviceManager", new Object[]{"get run plan paceIndex count is " + jSONObject.optInt("paceIndexCount", -1)});
                    HWExerciseAdviceManager.access$4300(this.this$0, jSONObject.optInt("run_plan_record_id"), r4);
                }
                HWExerciseAdviceManager.access$3802(this.this$0, 0);
                HWExerciseAdviceManager.access$4000(this.this$0).clear();
                HWExerciseAdviceManager.access$3300(this.this$0).clear();
                if (HWExerciseAdviceManager.access$3900(this.this$0) == null || HWExerciseAdviceManager.access$3900(this.this$0).getInt("run_plan_record_count") <= 0) {
                    HWExerciseAdviceManager.access$4500(this.this$0);
                    return;
                } else {
                    HWExerciseAdviceManager.access$4100(this.this$0);
                    return;
                }
            } catch (JSONException e) {
                C2538c.e("HWExerciseAdviceManager", new Object[]{e.getMessage()});
                return;
            }
        }
        C2538c.e("HWExerciseAdviceManager", new Object[]{"getRunPlanRecord error, error code=" + i});
        HWExerciseAdviceManager.access$100(this.this$0, i, "getDeviceRunPlanRecordIdList");
    }
}
