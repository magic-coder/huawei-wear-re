package com.huawei.hwfitnessmgr;

import android.content.Context;
import com.huawei.hwcloudmodel.mgr.C4710a;
import com.huawei.hwcloudmodel.model.userprofile.SetUserProfileReq;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.Map;

/* compiled from: FitnessMgrSharePreference */
final class C5038f extends Thread {
    final /* synthetic */ String f18239a;
    final /* synthetic */ Context f18240b;

    C5038f(String str, Context context) {
        this.f18239a = str;
        this.f18240b = context;
    }

    public void run() {
        SetUserProfileReq setUserProfileReq = new SetUserProfileReq();
        Map hashMap = new HashMap();
        hashMap.put("truSleepSwitch", this.f18239a);
        setUserProfileReq.setCustomDefine(hashMap);
        if (C4710a.m22540a(this.f18240b).m22560a(setUserProfileReq) != null) {
            C2538c.c("FitnessMgrSharePreference", new Object[]{"uploadUserData rsp : " + C4710a.m22540a(this.f18240b).m22560a(setUserProfileReq).toString()});
        }
    }
}
