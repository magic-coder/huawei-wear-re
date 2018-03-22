package com.huawei.hwfitnessmgr;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hwcommonmodel.fitnessdatatype.MotionGoal;
import com.huawei.hwfitnessmgr.deviceadapter.C5017d;
import com.huawei.p190v.C2538c;

/* compiled from: HWFitnessMgr */
class ar extends Handler {
    final /* synthetic */ q f18159a;

    public ar(q qVar, Looper looper) {
        this.f18159a = qVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                C2538c.c("HWFitnessMgr", new Object[]{" handleMessage() FitnessCommandID.COMMAND_FITNESS_SET_MOTION_GOAL"});
                C5017d.m24146a(1, this.f18159a.h(), ((MotionGoal) message.obj).getStepGoal());
                return;
            default:
                return;
        }
    }
}
