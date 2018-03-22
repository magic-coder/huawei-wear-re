package com.huawei.ui.main.stories.p177a.p178a;

import com.huawei.hwcloudmodel.mgr.C4710a;
import com.huawei.hwcloudmodel.model.userprofile.SetUserProfileReq;
import com.huawei.hwcloudmodel.model.userprofile.SetUserProfileRsp;
import com.huawei.ui.main.stories.a.a.b;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UserProfileInteractors */
class C6107c extends Thread {
    final /* synthetic */ b f21077a;

    C6107c(b bVar) {
        this.f21077a = bVar;
    }

    public void run() {
        SetUserProfileReq setUserProfileReq = new SetUserProfileReq();
        Map hashMap = new HashMap();
        hashMap.put("silentUpgradeSwitch", b.a(this.f21077a));
        setUserProfileReq.setCustomDefine(hashMap);
        SetUserProfileRsp a = C4710a.m22540a(b.b(this.f21077a)).m22560a(setUserProfileReq);
        if (a == null) {
            C2538c.e("UserProfileInteractors", new Object[]{"setWLANAutoUpdate rsp is null"});
        } else if (a.getResultCode() == 0) {
            C2538c.b("UserProfileInteractors", new Object[]{"setWLANAutoUpdate success"});
        }
    }
}
