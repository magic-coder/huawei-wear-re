package com.huawei.ui.device.p170a;

import com.huawei.datatype.HealthSupportModel;
import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: CompatibilityInteractor */
class C1986n implements IBaseResponseCallback {
    final /* synthetic */ int f6933a;
    final /* synthetic */ IBaseResponseCallback f6934b;
    final /* synthetic */ C1975c f6935c;

    C1986n(C1975c c1975c, int i, IBaseResponseCallback iBaseResponseCallback) {
        this.f6935c = c1975c;
        this.f6933a = i;
        this.f6934b = iBaseResponseCallback;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && (obj instanceof HealthSupportModel)) {
            HealthSupportModel healthSupportModel = (HealthSupportModel) obj;
            switch (this.f6933a) {
                case -2:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportAF500()));
                    return;
                case 0:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportB1()));
                    return;
                case 1:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportB2()));
                    return;
                case 3:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportW1()));
                    return;
                case 5:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportB0()));
                    return;
                case 7:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportB3()));
                    return;
                case 8:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportMetis()));
                    return;
                case 10:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportLeo()));
                    return;
                case 11:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportR1()));
                    return;
                case 12:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportA2()));
                    return;
                case 13:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportNyx()));
                    return;
                case 14:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportB3Lite()));
                    return;
                case 15:
                    this.f6934b.onResponse(0, Boolean.valueOf(healthSupportModel.isSupportEris()));
                    return;
                default:
                    this.f6934b.onResponse(0, Boolean.valueOf(false));
                    return;
            }
        }
    }
}
