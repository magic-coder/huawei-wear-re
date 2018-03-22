package com.huawei.hwservicesmgr.remote;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.hwservicesmgr.remote.utils.RemoteUtils;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import org.json.JSONObject;

class RemoteServiceMgr$5 extends BroadcastReceiver {
    final /* synthetic */ RemoteServiceMgr this$0;

    class C53731 implements Runnable {
        C53731() {
        }

        public void run() {
            a.a(BaseApplication.b(), String.valueOf(1015), "key_device_last_device", RemoteServiceMgr.access$1600(), null);
        }
    }

    RemoteServiceMgr$5(RemoteServiceMgr remoteServiceMgr) {
        this.this$0 = remoteServiceMgr;
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            C2538c.c("RemoteServiceMgr", new Object[]{"mConnectStateChangedReceiver() action = " + intent.getAction()});
            if ("com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                JSONObject jSONObject = new JSONObject();
                DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
                if (deviceInfo != null) {
                    C2538c.c("RemoteServiceMgr", new Object[]{"mConnectStateChangedReceiver() status = " + deviceInfo.getDeviceConnectState()});
                    try {
                        switch (deviceInfo.getDeviceConnectState()) {
                            case 2:
                                RemoteServiceMgr.access$1500().removeMessages(1);
                                if (RemoteServiceMgr.access$100() != null) {
                                    RemoteServiceMgr.access$100().mo4452a(RemoteServiceMgr.access$400().toJson(RemoteServiceMgr.access$300().b()));
                                    RemoteServiceMgr.access$100().mo4454a(RemoteServiceMgr.access$500());
                                    jSONObject.put("state", RemoteServiceMgr.DEVICE_INSTANT_CONNECTETED);
                                    RemoteServiceMgr.access$100().mo4455a(RemoteUtils.generateRetMap(jSONObject.toString(), "notificationStateConnectionStateChanged"));
                                    C2538c.c("RemoteServiceMgr", new Object[]{"deviceInstantConnected sent"});
                                    if (RemoteServiceMgr.access$1600() == null) {
                                        RemoteServiceMgr.access$1602(a.a(BaseApplication.b(), String.valueOf(1015), "key_device_last_device"));
                                    }
                                    C2538c.c("RemoteServiceMgr", new Object[]{"lastKnownDeviceIdentify is " + RemoteServiceMgr.access$1600()});
                                    C2538c.c("RemoteServiceMgr", new Object[]{"deviceInfo.getUUID() is " + deviceInfo.getUUID()});
                                    if (RemoteServiceMgr.access$1600() == null || !RemoteServiceMgr.access$1600().equalsIgnoreCase(deviceInfo.getUUID())) {
                                        jSONObject.put("state", RemoteServiceMgr.DEVICE_DISCONNECTED);
                                        C2538c.c("RemoteServiceMgr", new Object[]{"deviceDisconnected sent"});
                                        RemoteServiceMgr.access$100().mo4455a(RemoteUtils.generateRetMap(jSONObject.toString(), "notificationStateConnectionStateChanged"));
                                    } else if (RemoteServiceMgr.access$1600().equals(deviceInfo.getUUID()) && !RemoteServiceMgr.access$1100()) {
                                        C2538c.c("RemoteServiceMgr", new Object[]{"set isDisconnectedReported ======> false"});
                                        RemoteServiceMgr.access$1102(false);
                                        return;
                                    }
                                    RemoteServiceMgr.access$1602(deviceInfo.getUUID());
                                    RemoteServiceMgr.access$1700(this.this$0).execute(new C53731());
                                    jSONObject.put("state", RemoteServiceMgr.DEVICE_CONNECTED);
                                    C2538c.c("RemoteServiceMgr", new Object[]{"deviceConnected sent"});
                                    RemoteServiceMgr.access$100().mo4455a(RemoteUtils.generateRetMap(jSONObject.toString(), "notificationStateConnectionStateChanged"));
                                    return;
                                }
                                RemoteServiceMgr.access$1800(this.this$0);
                                return;
                            case 3:
                                if (RemoteServiceMgr.access$100() != null) {
                                    jSONObject.put("state", RemoteServiceMgr.DEVICE_INSTANT_DISCONNECTETED);
                                    RemoteServiceMgr.access$100().mo4454a(RemoteServiceMgr.access$500());
                                    RemoteServiceMgr.access$100().mo4455a(RemoteUtils.generateRetMap(jSONObject.toString(), "notificationStateConnectionStateChanged"));
                                } else {
                                    RemoteServiceMgr.access$1800(this.this$0);
                                }
                                C2538c.c("RemoteServiceMgr", new Object[]{"deviceInstantDisconnected sent"});
                                RemoteServiceMgr.access$1500().sendEmptyMessageDelayed(1, LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                                return;
                            default:
                                return;
                        }
                    } catch (Exception e) {
                        C2538c.e("RemoteServiceMgr", new Object[]{e.getMessage()});
                        return;
                    }
                    C2538c.e("RemoteServiceMgr", new Object[]{e.getMessage()});
                    return;
                }
                C2538c.c("RemoteServiceMgr", new Object[]{"ACTION_CONNECTION_STATE_CHANGED deviceinfo is null"});
            }
        }
    }
}
