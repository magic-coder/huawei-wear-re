package com.huawei.hwdevicedfxmanager.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.huawei.ab.C0630m;
import com.huawei.hwappdfxmgr.a;
import com.huawei.hwcloudmodel.p060b.C0969i;
import com.huawei.hwdevicedfxmanager.callback.IDeviceDFXBaseResponseCallback;
import com.huawei.hwdevicedfxmanager.datatype.BoneBroadcastJson;
import com.huawei.hwdevicedfxmanager.manager.HWDeviceDFXManager;
import com.huawei.p190v.C2538c;

public class DeviceDFXReceiver extends BroadcastReceiver {
    private static final String LAST_SYNC_BETA_LOG_TIME = "last_sync_beta_log_time";
    public static final String RECIVE_GET_BETA_INFO = "com.huawei.bone.action.GET_BETA_INFO";
    public static final String RECIVE_GET_BETA_LOG = "com.huawei.bone.action.GET_BETA_LOG";
    public static final String SEND_GET_BETA_INFO = "com.huawei.crowdtest.action.GET_BETA_INFO";
    public static final String SEND_GET_BETA_LOG = "com.huawei.crowdtest.action.GET_BETA_LOG";
    private static final String TAG = "DeviceDFXReceiver";
    private int logLevel = 1;
    private Context mContext = null;

    class C10191 implements IDeviceDFXBaseResponseCallback {
        C10191() {
        }

        public void onSuccess(int i, String str) {
            C2538c.m12677c(DeviceDFXReceiver.TAG, "onSuccess suc_code = " + i + ",err_msg = " + str);
            a.a(DeviceDFXReceiver.this.mContext).a(false);
        }

        public void onFailure(int i, String str) {
            C2538c.m12677c(DeviceDFXReceiver.TAG, "onFailure err_code = " + i + ",err_msg = " + str);
            a.a(DeviceDFXReceiver.this.mContext).a(false);
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            C2538c.m12680e(TAG, "intent is null");
            return;
        }
        this.mContext = context;
        if (isSupport()) {
            C2538c.m12677c(TAG, "DeviceDFXReceiver, intent.getAction() = " + intent.getAction());
            try {
                if ("com.huawei.bone.action.GET_BETA_INFO".equalsIgnoreCase(intent.getAction())) {
                    C2538c.m12677c(TAG, "DeviceDFXReceiver, RECIVE_GET_BETA_INFO getFirmwareVersion");
                    HWDeviceDFXManager.getInstance(this.mContext).getCrowdFirmwareVersion();
                }
                if ("com.huawei.bone.action.GET_BETA_LOG".equalsIgnoreCase(intent.getAction())) {
                    C2538c.m12677c(TAG, "DeviceDFXReceiver startMainteFile: logLevel = " + this.logLevel);
                    broadcastMaintResult();
                    HWDeviceDFXManager.getInstance(this.mContext).getCrowdTestAndMaint(this.logLevel, new C10191());
                    return;
                }
                return;
            } catch (Exception e) {
                C2538c.m12680e(TAG, "Exception e = " + e.getMessage());
                return;
            }
        }
        C2538c.m12674b(TAG, "not support DXF");
    }

    private void broadcastMaintResult() {
        C2538c.m12674b(TAG, "broadcastMaintResult SEND_GET_BETA_LOG = com.huawei.crowdtest.action.GET_BETA_LOG");
        Intent intent = new Intent(SEND_GET_BETA_LOG);
        Object boneBroadcastJson = new BoneBroadcastJson();
        boneBroadcastJson.setResponseCode(200);
        intent.putExtra("Request", new Gson().toJson(boneBroadcastJson));
        this.mContext.sendBroadcast(intent);
        C2538c.m12677c(TAG, "broadcastCrowdDeviceInfoResult: 发送结果！！！");
    }

    private boolean isSupport() {
        C2538c.m12674b(TAG, "BuildConfig.SUPPORT_LOG_FEEDBACK falseexperence " + C0630m.m2297a(this.mContext).m2318c());
        return (!C0630m.m2297a(this.mContext).m2318c() || C0969i.m3482a(48)) ? false : false;
    }
}
