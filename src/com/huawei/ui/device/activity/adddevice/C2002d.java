package com.huawei.ui.device.activity.adddevice;

import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.JoinRuleParse;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.huawei.ui.main.stories.lightcloud.service.LightCloudCallBack;

/* compiled from: AddDeviceActivity */
class C2002d implements LightCloudCallBack {
    final /* synthetic */ AddDeviceActivity f7040a;

    C2002d(AddDeviceActivity addDeviceActivity) {
        this.f7040a = addDeviceActivity;
    }

    public void onResponce(String str, int i) {
        C2538c.m12677c("AddDeviceActivity", "LightCloud doRefreshBatch ", str, " resCode = ", Integer.valueOf(i));
        if (!(20000 == i || LightCloudConstants.RESPONSE_CODE_NO_ENOUGH == i || i == 0)) {
            C0996a.m3611a(this.f7040a.f6987L, String.valueOf(10000), LightCloudConstants.LightCloud_RESULT, LightCloudConstants.RESPONSE_RESULT_FAIL, new C0993c());
        }
        if (LightCloudConstants.JOIN_CONFIG.equals(str) && i == 0) {
            int parseResult = JoinRuleParse.parseResult(this.f7040a.f6987L);
            C2538c.m12677c("AddDeviceActivity", "JoinRuleParse resCode = " + parseResult);
        }
    }
}
