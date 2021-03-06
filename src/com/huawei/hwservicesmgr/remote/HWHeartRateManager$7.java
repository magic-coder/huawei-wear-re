package com.huawei.hwservicesmgr.remote;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwservicesmgr.remote.utils.RemoteUtils;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

class HWHeartRateManager$7 implements IBaseResponseCallback {
    final /* synthetic */ HWHeartRateManager this$0;
    final /* synthetic */ IBaseResponseCallback val$callback;

    HWHeartRateManager$7(HWHeartRateManager hWHeartRateManager, IBaseResponseCallback iBaseResponseCallback) {
        this.this$0 = hWHeartRateManager;
        this.val$callback = iBaseResponseCallback;
    }

    public void onResponse(int i, Object obj) {
        if (HWHeartRateManager.access$000(this.this$0) != null && HWHeartRateManager.access$000(this.this$0).hasMessages(3)) {
            HWHeartRateManager.access$000(this.this$0).removeMessages(3);
        }
        if (obj != null) {
            int intValue = ((Integer) obj).intValue();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", 12);
                if (intValue == 100000) {
                    jSONObject.put("result_code", 0);
                } else {
                    jSONObject.put("result_code", 1);
                }
            } catch (JSONException e) {
                C2538c.e("HWHeartRateManager", new Object[]{"game open fail," + e.getMessage()});
            }
            C2538c.c("HWHeartRateManager", new Object[]{"game open call back data = " + jSONObject.toString()});
            if (this.val$callback != null) {
                this.val$callback.onResponse(100000, RemoteUtils.generateRetMap(jSONObject.toString(), "setStressReportStatus"));
                return;
            }
            C2538c.c("HWHeartRateManager", new Object[]{"game open call back is null"});
        }
    }
}
