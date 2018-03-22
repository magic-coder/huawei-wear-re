package com.huawei.hwservicesmgr.remote;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.p190v.C2538c;

import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class HWHeartRateManager$MyStressHandler extends Handler {
    private WeakReference<HWHeartRateManager> hwHeartRateManagerWeakReference;

    HWHeartRateManager$MyStressHandler(Looper looper, HWHeartRateManager hWHeartRateManager) {
        super(looper);
        this.hwHeartRateManagerWeakReference = new WeakReference(hWHeartRateManager);
    }

    public void handleMessage(Message message) {
        HWHeartRateManager hWHeartRateManager = (HWHeartRateManager) this.hwHeartRateManagerWeakReference.get();
        super.handleMessage(message);
        JSONObject jSONObject;
        switch (message.what) {
            case 0:
                C2538c.c("HWHeartRateManager", new Object[]{"stress open timeout"});
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 1);
                    jSONObject.put("result_code", 1);
                } catch (JSONException e) {
                    C2538c.e("HWHeartRateManager", new Object[]{"stress open time out," + e.getMessage()});
                }
                if (HWHeartRateManager.access$200(hWHeartRateManager) != null) {
                    HWHeartRateManager.access$200(hWHeartRateManager).onResponse(0, jSONObject.toString());
                    return;
                }
                return;
            case 1:
                C2538c.c("HWHeartRateManager", new Object[]{"calib open timeout"});
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 4);
                    jSONObject.put("result_code", 1);
                } catch (JSONException e2) {
                    C2538c.e("HWHeartRateManager", new Object[]{"calib open time out," + e2.getMessage()});
                }
                if (HWHeartRateManager.access$200(hWHeartRateManager) != null) {
                    HWHeartRateManager.access$200(hWHeartRateManager).onResponse(0, jSONObject.toString());
                    return;
                }
                return;
            case 2:
                C2538c.c("HWHeartRateManager", new Object[]{"relax open timeout"});
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 9);
                    jSONObject.put("result_code", 1);
                } catch (JSONException e22) {
                    C2538c.e("HWHeartRateManager", new Object[]{"relax open time out," + e22.getMessage()});
                }
                if (HWHeartRateManager.access$200(hWHeartRateManager) != null) {
                    HWHeartRateManager.access$200(hWHeartRateManager).onResponse(0, jSONObject.toString());
                    return;
                }
                return;
            case 3:
                C2538c.c("HWHeartRateManager", new Object[]{"game open timeout"});
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 12);
                    jSONObject.put("result_code", 1);
                } catch (JSONException e222) {
                    C2538c.e("HWHeartRateManager", new Object[]{"game open time out ," + e222.getMessage()});
                }
                if (HWHeartRateManager.access$200(hWHeartRateManager) != null) {
                    HWHeartRateManager.access$200(hWHeartRateManager).onResponse(0, jSONObject.toString());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
