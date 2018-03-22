package com.huawei.hwfitnessmgr.deviceadapter;

import android.support.v4.media.TransportMediator;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.fitnessdatatype.MotionGoal;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: FitnessPackageGoal */
public class C5015b {
    public static byte[] m24140a(List<MotionGoal> list) {
        String str = "";
        if (list != null && list.size() > 0) {
            String str2 = str + C0973a.a(129);
            int i = 0;
            String str3 = "";
            for (MotionGoal motionGoal : list) {
                int fitness_frame_type;
                String str4;
                int stepGoal;
                int dutationGoal;
                String str5 = "" + C0973a.a(3) + C0973a.a(1) + C0973a.a(motionGoal.getGoalType());
                int i2 = i + 3;
                str5 = str5 + C0973a.a(4) + C0973a.a(1);
                DeviceCapability a = C0973a.a.a();
                if (a != null) {
                    fitness_frame_type = a.getFitness_frame_type();
                } else {
                    C2538c.c("FitnessPackageGoal", new Object[]{"setGoal deviceCapability is null"});
                    fitness_frame_type = -1;
                }
                if (fitness_frame_type == 1) {
                    str4 = str5 + a.a(1);
                } else {
                    str4 = str5 + a.a(motionGoal.getMotionType());
                }
                i2 += 3;
                if ((motionGoal.getDataType() & 1) != 0) {
                    stepGoal = motionGoal.getStepGoal();
                } else {
                    stepGoal = -1;
                }
                if (-1 != stepGoal) {
                    str5 = str4 + a.a(5) + a.a(4) + a.a(stepGoal >> 24) + a.a((stepGoal >> 16) & 255) + a.a((stepGoal >> 8) & 255) + a.a(stepGoal & 255);
                    i2 += 6;
                    i = 12;
                } else {
                    str5 = str4;
                    i = 6;
                }
                int i3 = -1;
                if ((motionGoal.getDataType() & 2) != 0) {
                    i3 = motionGoal.getCalorieGoal();
                }
                if (-1 != i3) {
                    str5 = str5 + a.a(6) + a.a(4) + a.a((long) i3);
                    i2 += 6;
                    i += 6;
                } else if (fitness_frame_type == 1) {
                    str5 = str5 + a.a(6) + a.a(4) + a.a((long) (stepGoal / 30));
                    i2 += 6;
                    i += 6;
                }
                i3 = -1;
                if ((motionGoal.getDataType() & 4) != 0) {
                    i3 = motionGoal.getDutationGoal();
                }
                if (-1 != i3) {
                    str5 = str5 + a.a(7) + a.a(4) + a.a((long) i3);
                    i2 += 6;
                    i += 6;
                } else if (fitness_frame_type == 1) {
                    str5 = str5 + a.a(7) + a.a(4) + a.a((long) stepGoal);
                    i2 += 6;
                    i += 6;
                }
                if ((motionGoal.getDataType() & 8) != 0) {
                    dutationGoal = motionGoal.getDutationGoal();
                } else {
                    dutationGoal = -1;
                }
                if (-1 != dutationGoal) {
                    str5 = str5 + a.a(8) + a.a(2) + a.b(dutationGoal);
                    i2 += 4;
                    i += 4;
                }
                str = a.a(TransportMediator.KEYCODE_MEDIA_RECORD) + a.a(i) + str5;
                i = i2 + 2;
                str3 = str3 + str;
            }
            str = C0973a.a(i);
            if (i > 127) {
                str = C0973a.a((i >> 8) + 128) + C0973a.a(i & 255);
            }
            str = str2 + str + str3;
        }
        return C0973a.b(str);
    }
}
