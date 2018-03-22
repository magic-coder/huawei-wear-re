package com.huawei.ab;

import com.huawei.hwcloudmodel.mgr.C4710a;
import com.huawei.hwcloudmodel.model.userprofile.GetUserProfileReq;
import com.huawei.hwcloudmodel.model.userprofile.GetUserProfileRsp;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: UserProfileUtil */
final class C3980x implements Runnable {
    C3980x() {
    }

    public void run() {
        try {
            String str = "0";
            List arrayList = new ArrayList();
            arrayList.add("silentUpgradeSwitch");
            C4710a a = C4710a.m22540a(BaseApplication.b());
            List arrayList2 = new ArrayList();
            GetUserProfileReq getUserProfileReq = new GetUserProfileReq();
            arrayList2.add(Integer.valueOf(99));
            getUserProfileReq.setProfileType(arrayList2);
            getUserProfileReq.setCustomDefine(arrayList);
            GetUserProfileRsp a2 = a.m22559a(getUserProfileReq);
            if (a2 == null) {
                C2538c.e("UserProfileUtil", new Object[]{"getWLANAutoUpdate() rsp is null"});
            } else if (a2.getResultCode() == 0) {
                Map customDefine = a2.getCustomDefine();
                if (customDefine != null) {
                    C2538c.c("UserProfileUtil", new Object[]{"getWLANAutoUpdate get auto ota checkbox status autoUpdateSwitch = " + ((String) customDefine.get("silentUpgradeSwitch"))});
                    com.huawei.hwdataaccessmodel.a.c cVar = new com.huawei.hwdataaccessmodel.a.c();
                    cVar.a = 0;
                    a.a(BaseApplication.b(), String.valueOf(10009), "key_auto_update_switch", str, cVar);
                }
            } else {
                C2538c.c("UserProfileUtil", new Object[]{"getWLANAutoUpdate get auto ota checkbox status fail"});
            }
        } catch (Exception e) {
            C2538c.c("UserProfileUtil", new Object[]{"getWLANAutoUpdate Exception = " + e.getMessage()});
        }
    }
}
