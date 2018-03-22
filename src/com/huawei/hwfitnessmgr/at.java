package com.huawei.hwfitnessmgr;

import android.os.Message;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.fitnessdatatype.MotionGoal;
import com.huawei.hwfitnessmgr.deviceadapter.C5017d;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWFitnessMgr */
class at implements Runnable {
    final /* synthetic */ q f18161a;
    private int f18162b;
    private Object f18163c;

    public at(q qVar, int i, Object obj) {
        this.f18161a = qVar;
        this.f18162b = i;
        this.f18163c = obj;
    }

    public void run() {
        C2538c.a("05", 1, "HWFitnessMgr", new Object[]{"setDeviceFitnessGoal  onResponse!"});
        C2538c.c("HWFitnessMgr", new Object[]{"setDeviceFitnessGoal  onResponse!", this.f18163c});
        if (this.f18162b == 0 && (this.f18163c instanceof MotionGoal)) {
            MotionGoal motionGoal = (MotionGoal) this.f18163c;
            boolean a = w.a(a.a(q.d(this.f18161a)).c());
            C2538c.c("HWFitnessMgr", new Object[]{"setDeviceFitnessGoal isDatalogin:" + a});
            if (4 == this.f18161a.i()) {
                if (a) {
                    int stepGoal = motionGoal.getStepGoal();
                    C2538c.c("HWFitnessMgr", new Object[]{"Start to set AF Goal."});
                    C5017d.m24170j(stepGoal);
                }
            } else if (this.f18161a.f() == 0) {
                if (a) {
                    C2538c.c("HWFitnessMgr", new Object[]{"Start to set V0 Goal."});
                    Message obtainMessage = q.e(this.f18161a).obtainMessage();
                    obtainMessage.what = 1;
                    obtainMessage.obj = motionGoal;
                    q.e(this.f18161a).sendMessage(obtainMessage);
                }
            } else if (a) {
                List arrayList = new ArrayList();
                arrayList.add(motionGoal);
                C5017d.m24151a(arrayList);
            }
        }
    }
}
