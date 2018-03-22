package com.huawei.hwservicesmgr.remote;

import android.content.Intent;
import com.huawei.hihealth.HiHealthClient;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.data.p312b.C4552f;
import com.huawei.p190v.C2538c;

import java.util.List;

class RemoteServiceMgr$7 implements C4552f {
    final /* synthetic */ RemoteServiceMgr this$0;

    RemoteServiceMgr$7(RemoteServiceMgr remoteServiceMgr) {
        this.this$0 = remoteServiceMgr;
    }

    public void onResult(List<Integer> list, List<Integer> list2) {
        C2538c.c("RemoteServiceMgr", new Object[]{"regDeviceInfoConfigListener onResult"});
        if (list != null && !list.isEmpty()) {
            C2538c.c("RemoteServiceMgr", new Object[]{"regDeviceInfoConfigListener success"});
            RemoteServiceMgr.access$802(this.this$0, list);
        }
    }

    public void onChange(int i, HiHealthClient hiHealthClient, String str, HiHealthData hiHealthData, long j) {
        C2538c.c("RemoteServiceMgr", new Object[]{"regDeviceInfoConfigListener success type = " + i + ",changeType = " + str});
        if (102 == i && "custom.UserPreference_HeartZone_Config".equals(str)) {
            C2538c.c("RemoteServiceMgr", new Object[]{"regDeviceInfoConfigListener send HeartZoneConfig to device"});
            RemoteServiceMgr.access$1000(this.this$0).sendBroadcast(new Intent("com.huawei.bone.ACTION_RECEIVE_SEND_HEART_CONFIG"), com.huawei.hwcommonmodel.b.c.a);
        } else if (100 == i) {
            C2538c.c("RemoteServiceMgr", new Object[]{"regDeviceInfoConfigListener send UserInfo to device"});
            RemoteServiceMgr.access$1000(this.this$0).sendBroadcast(new Intent("com.huawei.bone.ACTION_RECEIVE_SEND_HEIGHT_WEIGHT"), com.huawei.hwcommonmodel.b.c.a);
        } else if (101 == i) {
            C2538c.c("RemoteServiceMgr", new Object[]{"regDeviceInfoConfigListener send GoalInfo to device"});
            RemoteServiceMgr.access$1000(this.this$0).sendBroadcast(new Intent("com.huawei.bone.ACTION_RECEIVE_SEND_SPORT_GOAL"), com.huawei.hwcommonmodel.b.c.a);
        }
    }
}
