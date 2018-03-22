package com.huawei.hwservicesmgr.remote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.datatype.OperatorStatus;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

class HWExerciseAdviceManager$3 extends BroadcastReceiver {
    final /* synthetic */ HWExerciseAdviceManager this$0;

    class C53701 implements IBaseResponseCallback {
        C53701() {
        }

        public void onResponse(int i, Object obj) {
            if (100000 == i && 1 == ((OperatorStatus) obj).getTrain_monitor_state()) {
                HWExerciseAdviceManager.access$1602(HWExerciseAdviceManager$3.this.this$0, false);
            }
        }
    }

    HWExerciseAdviceManager$3(HWExerciseAdviceManager hWExerciseAdviceManager) {
        this.this$0 = hWExerciseAdviceManager;
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            C2538c.c("HWExerciseAdviceManager", new Object[]{"mConnectStateChangedReceiver() action = " + intent.getAction()});
            if ("com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
                if (deviceInfo != null) {
                    C2538c.c("HWExerciseAdviceManager", new Object[]{"mConnectStateChangedReceiver() status = " + deviceInfo.getDeviceConnectState()});
                    switch (deviceInfo.getDeviceConnectState()) {
                        case 2:
                            HWExerciseAdviceManager.access$1200(this.this$0);
                            HWExerciseAdviceManager.access$1300(this.this$0).removeMessages(1);
                            if (HWExerciseAdviceManager.access$1400(this.this$0)) {
                                if (HWExerciseAdviceManager.access$1500(this.this$0) == null) {
                                    HWExerciseAdviceManager.access$1300(this.this$0).sendEmptyMessage(1);
                                } else if (deviceInfo.getDeviceIdentify() == null || !HWExerciseAdviceManager.access$1500(this.this$0).equalsIgnoreCase(deviceInfo.getDeviceIdentify())) {
                                    HWExerciseAdviceManager.access$1300(this.this$0).sendEmptyMessage(1);
                                }
                                if (HWExerciseAdviceManager.access$1600(this.this$0) && 3 != HWExerciseAdviceManager.access$1700(this.this$0)) {
                                    HWWorkoutServiceManager.getInstance().getOperator(new C53701());
                                }
                            } else {
                                HWExerciseAdviceManager.access$1300(this.this$0).sendEmptyMessage(1);
                            }
                            HWExerciseAdviceManager.access$1502(this.this$0, deviceInfo.getDeviceIdentify());
                            return;
                        case 3:
                            if (HWExerciseAdviceManager.access$1400(this.this$0)) {
                                HWExerciseAdviceManager.access$1300(this.this$0).sendEmptyMessageDelayed(1, LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }
}
