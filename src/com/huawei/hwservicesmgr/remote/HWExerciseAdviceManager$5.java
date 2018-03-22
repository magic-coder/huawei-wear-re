package com.huawei.hwservicesmgr.remote;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwservicesmgr.remote.utils.RemoteUtils;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import org.json.JSONException;
import org.json.JSONObject;

class HWExerciseAdviceManager$5 implements Runnable {
    final /* synthetic */ HWExerciseAdviceManager this$0;
    final /* synthetic */ IBaseResponseCallback val$callback;

    HWExerciseAdviceManager$5(HWExerciseAdviceManager hWExerciseAdviceManager, IBaseResponseCallback iBaseResponseCallback) {
        this.this$0 = hWExerciseAdviceManager;
        this.val$callback = iBaseResponseCallback;
    }

    public void run() {
        C2538c.c("HWExerciseAdviceManager", new Object[]{"calling syncDeviceWorkoutRecordInfo"});
        DeviceInfo access$1800 = HWExerciseAdviceManager.access$1800();
        if (HWExerciseAdviceManager.access$1400(this.this$0)) {
            C2538c.c("HWExerciseAdviceManager", new Object[]{"syncDeviceWorkoutRecordInfo isDetailSyncing:", Boolean.valueOf(HWExerciseAdviceManager.access$800(this.this$0))});
            if (HWExerciseAdviceManager.access$800(this.this$0)) {
                C2538c.c("HWExerciseAdviceManager", new Object[]{"is syning detail, please wait"});
                if (this.val$callback != null) {
                    this.val$callback.onResponse(100005, null);
                    return;
                }
                return;
            }
            HWExerciseAdviceManager.access$802(this.this$0, true);
            if (access$1800 == null || access$1800.getDeviceConnectState() != 2) {
                C2538c.c("HWExerciseAdviceManager", new Object[]{"no device is connected."});
                HWExerciseAdviceManager.access$802(this.this$0, false);
                if (this.val$callback != null) {
                    this.val$callback.onResponse(0, RemoteUtils.generateRetMap(Integer.valueOf(100001), "no device is connected."));
                }
                HWExerciseAdviceManager.access$1900(this.this$0);
                return;
            }
            C2538c.c("HWExerciseAdviceManager", new Object[]{"syncDeviceWorkoutRecordInfo isDatalogin:" + w.a(a.a(BaseApplication.b()).c())});
            if (w.a(a.a(BaseApplication.b()).c())) {
                HWExerciseAdviceManager.access$602(this.this$0, System.currentTimeMillis());
                HWExerciseAdviceManager.access$402(this.this$0, this.this$0.getCurrDeviceId());
                HWExerciseAdviceManager.access$2002(this.this$0, HWExerciseAdviceManager.access$2100(this.this$0));
                C2538c.c("HWExerciseAdviceManager", new Object[]{"===zz====syncDeviceWorkoutRecordInfo======= currentTime - lastSyncTime:" + (HWExerciseAdviceManager.access$600(this.this$0) - HWExerciseAdviceManager.access$2000(this.this$0))});
                if (HWExerciseAdviceManager.access$2000(this.this$0) == 0 || HWExerciseAdviceManager.access$600(this.this$0) - HWExerciseAdviceManager.access$2000(this.this$0) > HWExerciseAdviceManager.access$2200() || HWExerciseAdviceManager.access$600(this.this$0) - HWExerciseAdviceManager.access$2000(this.this$0) < 0) {
                    HWExerciseAdviceManager.access$2002(this.this$0, HWExerciseAdviceManager.access$600(this.this$0) - HWExerciseAdviceManager.access$2200());
                }
                C2538c.c("HWExerciseAdviceManager", new Object[]{"===zz====syncDeviceWorkoutRecordInfo=======starttime :" + HWExerciseAdviceManager.access$2000(this.this$0) + "======endtime : " + HWExerciseAdviceManager.access$600(this.this$0)});
                HWExerciseAdviceManager.access$1300(this.this$0).sendEmptyMessageDelayed(0, LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                HWExerciseAdviceManager.access$2300(this.this$0).clear();
                HWExerciseAdviceManager.access$2400(this.this$0).clear();
                HWExerciseAdviceManager.access$2500(this.this$0).clear();
                HWExerciseAdviceManager.access$902(this.this$0, this.val$callback);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("startTime", HWExerciseAdviceManager.access$2000(this.this$0));
                    jSONObject.put("endTime", HWExerciseAdviceManager.access$600(this.this$0));
                } catch (JSONException e) {
                    C2538c.e("HWExerciseAdviceManager", new Object[]{e.getMessage()});
                }
                HWExerciseAdviceManager.access$2600(this.this$0, jSONObject);
                return;
            }
            C2538c.c("HWExerciseAdviceManager", new Object[]{"HiHelath do not login"});
            HWExerciseAdviceManager.access$802(this.this$0, false);
            if (this.val$callback != null) {
                this.val$callback.onResponse(0, RemoteUtils.generateRetMap(Integer.valueOf(100001), "HiHelath do not login."));
            }
            HWExerciseAdviceManager.access$1900(this.this$0);
            return;
        }
        if (this.val$callback != null) {
            this.val$callback.onResponse(0, RemoteUtils.generateRetMap(Integer.valueOf(0), "syncDeviceWorkoutRecordInfo"));
        }
        HWExerciseAdviceManager.access$1900(this.this$0);
    }
}
