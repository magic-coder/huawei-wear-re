package com.huawei.p508t.p509a;

import com.huawei.hihealth.HiGoalInfo;
import com.huawei.hwcommonmodel.fitnessdatatype.MotionGoal;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HealthDataMgrUtil */
public class C5971b {
    private static final byte[] f20552a = new byte[0];

    public static List<HiGoalInfo> m27386a(MotionGoal motionGoal) {
        List<HiGoalInfo> arrayList = new ArrayList();
        if (motionGoal.getCurrValue() != -1) {
            arrayList.add(C5971b.m27385a(C5970a.m27384c(motionGoal.getDataType()), C5970a.m27383b(motionGoal.getGoalType()), motionGoal.getCurrValue()));
        } else {
            if (motionGoal.getStepGoal() > 0) {
                arrayList.add(C5971b.m27385a(2, C5970a.m27383b(motionGoal.getGoalType()), motionGoal.getStepGoal()));
            }
            if (motionGoal.getCalorieGoal() > 0) {
                arrayList.add(C5971b.m27385a(1, C5970a.m27383b(motionGoal.getGoalType()), motionGoal.getCalorieGoal()));
            }
            if (motionGoal.getDistanceGoal() > 0) {
                arrayList.add(C5971b.m27385a(3, C5970a.m27383b(motionGoal.getGoalType()), motionGoal.getDistanceGoal()));
            }
            if (motionGoal.getDutationGoal() > 0) {
                arrayList.add(C5971b.m27385a(4, C5970a.m27383b(motionGoal.getGoalType()), motionGoal.getDutationGoal()));
            }
        }
        return arrayList;
    }

    public static HiGoalInfo m27385a(int i, int i2, int i3) {
        HiGoalInfo hiGoalInfo = new HiGoalInfo();
        hiGoalInfo.setGoalType(i);
        hiGoalInfo.setGoalUnit(i2);
        hiGoalInfo.setGoalValue((double) i3);
        return hiGoalInfo;
    }
}
