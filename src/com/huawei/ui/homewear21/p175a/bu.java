package com.huawei.ui.homewear21.p175a;

import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.JoinRuleParse;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.huawei.ui.main.stories.lightcloud.service.LightCloudCallBack;

/* compiled from: HomeFragment */
class bu implements LightCloudCallBack {
    final /* synthetic */ C2217a f8094a;

    bu(C2217a c2217a) {
        this.f8094a = c2217a;
    }

    public void onResponce(String str, int i) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "LightCloud doRefreshBatch ", str, " resCode = ", Integer.valueOf(i));
        if (!(20000 == i || LightCloudConstants.RESPONSE_CODE_NO_ENOUGH == i || i == 0)) {
            C0996a.m3611a(this.f8094a.f8041z, String.valueOf(10000), LightCloudConstants.LightCloud_RESULT, LightCloudConstants.RESPONSE_RESULT_FAIL, new C0993c());
        }
        if (LightCloudConstants.JOIN_CONFIG.equals(str) && i == 0) {
            int parseResult = JoinRuleParse.parseResult(this.f8094a.f8041z);
            C2538c.m12661a("MainUI", 0, "HomeFragment", "JoinRuleParse resCode = " + parseResult);
        }
    }
}
