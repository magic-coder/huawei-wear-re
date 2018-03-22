package com.huawei.p508t;

import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.fitnessdatatype.MotionGoal;
import com.huawei.p508t.p509a.C5972c;
import java.util.List;

/* compiled from: HWHealthDataManager */
class C5975c implements C3961b {
    final /* synthetic */ MotionGoal f20560a;
    final /* synthetic */ IBaseResponseCallback f20561b;
    final /* synthetic */ C5973a f20562c;

    C5975c(C5973a c5973a, MotionGoal motionGoal, IBaseResponseCallback iBaseResponseCallback) {
        this.f20562c = c5973a;
        this.f20560a = motionGoal;
        this.f20561b = iBaseResponseCallback;
    }

    public void mo4331a(int i, Object obj) {
        if (obj != null) {
            this.f20561b.onResponse(0, C5972c.m27387a(this.f20560a, (List) obj));
            return;
        }
        this.f20561b.onResponse(100001, null);
    }

    public void mo4332b(int i, Object obj) {
        this.f20561b.onResponse(100001, null);
    }
}
