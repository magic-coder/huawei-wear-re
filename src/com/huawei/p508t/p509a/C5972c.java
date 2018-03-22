package com.huawei.p508t.p509a;

import com.huawei.hihealth.HiGoalInfo;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSportType;
import com.huawei.hwcommonmodel.fitnessdatatype.MotionGoal;
import java.util.List;

/* compiled from: HealthDataUtil */
public class C5972c {
    public static int[] m27388a(int i) {
        switch (i) {
            case 1:
                return new int[]{40011, 40021, 40031, 40041};
            case 2:
                return new int[]{40012, 40022, 40032, 40042};
            case 3:
                return new int[]{40013, 40024, 40034, 40005, 40044};
            case 4:
                return new int[]{40023, 40033, 40043};
            case FitnessSportType.HW_FITNESS_SPORT_ALL /*221*/:
                return new int[]{PayStatusCodes.PRODUCT_AUTHENTICATION_FAILED, PayStatusCodes.PRODUCT_SERVER_INTERNAL_EXCEPTION, PayStatusCodes.PRODUCT_SOME_NOT_EXIST, 40005, 40006};
            default:
                return null;
        }
    }

    public static String[] m27389b(int i) {
        switch (i) {
            case 1:
                return new String[]{"WALK_STEP_SUM", "WALK_CALORIE_SUM", "WALK_DISTANCE_SUM", "WALK_DURATION_SUM"};
            case 2:
                return new String[]{"RUN_STEP_SUM", "RUN_CALORIE_SUM", "RUN_DISTANCE_SUM", "RUN_DURATION_SUM"};
            case 3:
                return new String[]{"STAIRS_STEP_SUM", "STAIRS_CALORIE_SUM", "STAIRS_DISTANCE_SUM", "STAIRS_STORY_SUM", "STAIRS_DURATION_SUM"};
            case 4:
                return new String[]{"CYCLE_CALORIE_SUM", "CYCLE_DISTANCE_SUM", "CYCLE_DURATION_SUM"};
            case FitnessSportType.HW_FITNESS_SPORT_ALL /*221*/:
                return new String[]{"STEP_SUM", "CALORIES_SUM", "DISTANCES_SUM", "STOREYS_SUM", "DURATION_SUM"};
            default:
                return null;
        }
    }

    public static MotionGoal m27387a(MotionGoal motionGoal, List<HiGoalInfo> list) {
        MotionGoal motionGoal2 = new MotionGoal();
        motionGoal2.setGoalType(motionGoal.getGoalType());
        for (HiGoalInfo hiGoalInfo : list) {
            if (hiGoalInfo.getGoalType() == 2) {
                motionGoal2.setStepGoal((int) hiGoalInfo.getGoalValue());
            } else if (hiGoalInfo.getGoalType() == 1) {
                motionGoal2.setCalorieGoal((int) hiGoalInfo.getGoalValue());
            } else if (hiGoalInfo.getGoalType() == 3) {
                motionGoal2.setDistanceGoal((int) hiGoalInfo.getGoalValue());
            } else if (hiGoalInfo.getGoalType() == 4) {
                motionGoal2.setDutationGoal((int) hiGoalInfo.getGoalValue());
            }
        }
        return motionGoal2;
    }
}
