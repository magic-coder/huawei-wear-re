package com.huawei.hwappdfxmgr;

import com.huawei.hwappdfxmgr.p056f.C4592c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

/* compiled from: HWAppDFXMgr */
class C4588c implements Runnable {
    final /* synthetic */ IBaseResponseCallback f16801a;
    final /* synthetic */ C4583a f16802b;

    C4588c(C4583a c4583a, IBaseResponseCallback iBaseResponseCallback) {
        this.f16802b = c4583a;
        this.f16801a = iBaseResponseCallback;
    }

    public void run() {
        int a = C4592c.m21865a(C4592c.f16809a, C4592c.f16811c);
        int a2 = C4592c.m21865a(C4592c.f16810b, C4592c.f16811c);
        if (this.f16801a == null) {
            return;
        }
        if (a != 0) {
            this.f16801a.onResponse(a, "log copy failed");
        } else if (a2 != 0) {
            this.f16801a.onResponse(a, "zip copy failed");
        } else {
            this.f16801a.onResponse(a, LightCloudConstants.RESPONSE_RESULT_SUCCESS);
        }
    }
}
