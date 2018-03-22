package com.huawei.hwdevicedfxmanager.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.ab.C0630m;
import com.huawei.hwappdfxmgr.a;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwdevicedfxmanager.callback.IDeviceDFXBaseResponseCallback;
import com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager;
import com.huawei.p190v.C2538c;

public class DeviceTriggerDFXReceiver extends BroadcastReceiver {
    public static final String DEVICE_TRIGGER_GET_LOG = "com.huawei.bone.dfx.device_trigger_log";
    private static final String TAG = "DeviceTriggerDFXReceiver";
    private Context mContext = null;

    class C10201 implements IDeviceDFXBaseResponseCallback {
        C10201() {
        }

        public void onSuccess(int i, String str) {
            C2538c.m12677c(DeviceTriggerDFXReceiver.TAG, "onSuccess suc_code = " + i + ",err_msg = " + str);
            a.a(DeviceTriggerDFXReceiver.this.mContext).a(true);
        }

        public void onFailure(int i, String str) {
            C2538c.m12677c(DeviceTriggerDFXReceiver.TAG, "onFailure fail_code = " + i + ",err_msg = " + str);
        }
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c(TAG, "DeviceTriggerDFXReceiver enter");
        this.mContext = context;
        if (!isSupport()) {
            C2538c.m12674b(TAG, "not support DXF");
        } else if (intent == null) {
            C2538c.m12680e(TAG, "null == intent");
        } else {
            String action = intent.getAction();
            C2538c.m12674b(TAG, "DeviceTriggerDFXReceiver action: " + action);
            if (DEVICE_TRIGGER_GET_LOG.equalsIgnoreCase(action)) {
                HWDeviceDFXManager.getInstance(context).getMaintanceFileNoRestrict(0, new C10201());
            }
        }
    }

    private boolean isSupport() {
        C2538c.m12674b(TAG, "BuildConfig.SUPPORT_LOG_FEEDBACK falseexperence " + C0630m.m2297a(this.mContext).m2318c());
        return (!C0630m.m2297a(this.mContext).m2318c() || C0969i.m3482a(48)) ? false : false;
    }
}
