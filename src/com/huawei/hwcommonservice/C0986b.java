package com.huawei.hwcommonservice;

import android.os.RemoteException;
import com.google.gson.Gson;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonservice.model.C0988a;
import com.huawei.hwcommonservice.model.C0990d;
import com.huawei.hwcommonservice.model.WearableDeviceInfo;
import com.huawei.hwfitnessmgr.C1026q;
import com.huawei.p091m.C1111d;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;

/* compiled from: HWWearCommonService */
class C0986b extends C0985e {
    final /* synthetic */ HWWearCommonService f1659a;

    C0986b(HWWearCommonService hWWearCommonService) {
        this.f1659a = hWWearCommonService;
    }

    public void mo2309a(C0990d c0990d) {
        C2538c.m12677c("HWWearCommonService", "getWearableDeviceStatus");
        Object wearableDeviceInfo = new WearableDeviceInfo();
        DeviceInfo c = C1204c.m5370a(BaseApplication.m2632b()).m5447c();
        if (c == null || c.getDeviceConnectState() != 2) {
            wearableDeviceInfo.setConnectionStatus(3);
            try {
                c0990d.m3602a(0, new Gson().toJson(wearableDeviceInfo));
                return;
            } catch (RemoteException e) {
                C2538c.m12677c("HWWearCommonService", "RemoteException  ", e);
                return;
            }
        }
        C1204c.m5370a(BaseApplication.m2632b()).m5441b(new C0987c(this, wearableDeviceInfo, c, c0990d));
    }

    public void mo2307a(long j, long j2, C0988a c0988a) {
        C2538c.m12677c("HWWearCommonService", "getCoreSleepRRData,startTime:", Long.valueOf(j), ";endTime:", Long.valueOf(j2));
        DeviceInfo c = C1204c.m5370a(BaseApplication.m2632b()).m5447c();
        if (c == null || c.getDeviceConnectState() != 2) {
            try {
                c0988a.m3600a(PayStatusCodes.PAY_STATE_PARAM_ERROR, 0, 0, "");
                return;
            } catch (RemoteException e) {
                C2538c.m12677c("HWWearCommonService", "RemoteException  ", e);
                return;
            }
        }
        C1111d.m4931a(BaseApplication.m2632b()).m4964a((int) (j / 1000), (int) (j2 / 1000), false, c0988a);
    }

    public void mo2308a(long j, long j2, C0990d c0990d) {
        C2538c.m12677c("HWWearCommonService", "getHeartRateData,startTime:", Long.valueOf(j), ";endTime:", Long.valueOf(j2));
        DeviceInfo c = C1204c.m5370a(BaseApplication.m2632b()).m5447c();
        if (c == null || c.getDeviceConnectState() != 2) {
            try {
                c0990d.m3602a(PayStatusCodes.PAY_STATE_PARAM_ERROR, "");
                return;
            } catch (RemoteException e) {
                C2538c.m12677c("HWWearCommonService", "RemoteException  ", e);
                return;
            }
        }
        C1026q.m4018a(BaseApplication.m2632b()).m4120a(j / 1000, j2 / 1000, c0990d);
    }

    public void mo2310b(long j, long j2, C0988a c0988a) {
        C2538c.m12677c("HWWearCommonService", "getCoreSleepState,startTime:", Long.valueOf(j), ";endTime:", Long.valueOf(j2));
        DeviceInfo c = C1204c.m5370a(BaseApplication.m2632b()).m5447c();
        if (c == null || c.getDeviceConnectState() != 2) {
            try {
                c0988a.m3600a(PayStatusCodes.PAY_STATE_PARAM_ERROR, 0, 0, "");
                return;
            } catch (RemoteException e) {
                C2538c.m12677c("HWWearCommonService", "RemoteException  ", e);
                return;
            }
        }
        C1111d.m4931a(BaseApplication.m2632b()).m4964a((int) (j / 1000), (int) (j2 / 1000), true, c0988a);
    }
}
