package com.huawei.hwfitnessmgr;

import com.huawei.ab.m;
import com.huawei.datatype.FitnessUserInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

/* compiled from: HWFitnessMgr */
class ab implements IBaseResponseCallback {
    final /* synthetic */ q f18141a;

    ab(q qVar) {
        this.f18141a = qVar;
    }

    public void onResponse(int i, Object obj) {
        FitnessUserInfo fitnessUserInfo = (FitnessUserInfo) obj;
        long time = fitnessUserInfo.getTime() * 1000;
        UserInfomation h = this.f18141a.h();
        C2538c.c("HWFitnessMgr", new Object[]{"本地时间戳 = " + h.getSetTime() + " 手表时间戳 = " + time});
        if (h.getSetTime() > time) {
            q.a(this.f18141a, h);
            return;
        }
        h.setHeight(Integer.valueOf(fitnessUserInfo.getHeight()));
        h.setWeight(Integer.valueOf(fitnessUserInfo.getWeight()));
        h.setSetTime(time);
        m.a(q.d(this.f18141a)).a(true, q.d(this.f18141a), h, new ac(this));
    }
}
