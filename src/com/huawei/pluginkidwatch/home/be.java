package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceProfile;
import com.huawei.pluginkidwatch.common.entity.model.GetDeviceProfileRetModel;

/* compiled from: HomeActivity */
class be implements C1378e {
    final /* synthetic */ HomeActivity f4269a;

    be(HomeActivity homeActivity) {
        this.f4269a = homeActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            GetDeviceProfileRetModel getDeviceProfileRetModel = (GetDeviceProfileRetModel) baseEntityModel;
            if (getDeviceProfileRetModel.deviceProfiles != null) {
                DeviceProfile deviceProfile = null;
                if (getDeviceProfileRetModel.deviceProfiles.size() > 0) {
                    deviceProfile = (DeviceProfile) getDeviceProfileRetModel.deviceProfiles.get(0);
                    this.f4269a.m7528a(deviceProfile);
                    if (this.f4269a.f4133e.isAdded()) {
                        this.f4269a.f4133e.m7823a();
                        this.f4269a.f4133e.m7824b();
                    } else {
                        C2538c.m12674b("KIDWATCH_HomeActivity", "=========settingFragement.isAdded():false");
                    }
                }
                if (deviceProfile != null) {
                    C2538c.m12674b("KIDWATCH_HomeActivity", "=== null != deviceInfo");
                }
            }
        }
    }
}
