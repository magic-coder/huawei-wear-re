package com.huawei.hwdatamigrate.hihealth.p419i;

import com.huawei.datatype.SportType;
import com.huawei.p190v.C2538c;

/* compiled from: HiTypeUtil */
public class C4941d {
    public static int m23805a(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 20004;
            case 3:
                return 20005;
            case 4:
                return 20003;
            case 5:
                return 20002;
            case 6:
                return 22001;
            case 7:
                return 22002;
            case 8:
                return 22003;
            default:
                return 0;
        }
    }

    public static int m23806b(int i) {
        switch (i) {
            case 20002:
                return 5;
            case 20003:
                return 4;
            case 20004:
                return 2;
            case 20005:
                return 3;
            case 22001:
                return 6;
            case 22002:
                return 7;
            case 22003:
                return 8;
            default:
                return 0;
        }
    }

    public static int m23807c(int i) {
        switch (i) {
            case 257:
                return 5;
            case SportType.SPORT_TYPE_RUN /*258*/:
                return 4;
            case SportType.SPORT_TYPE_BIKE /*259*/:
                return 3;
            case SportType.SPORT_TYPE_CLIMB_HILL /*260*/:
                return 2;
            case SportType.SPORT_TYPE_CLIMB_STAIRS /*261*/:
                return 1;
            case SportType.SPORT_TYPE_SWIM /*262*/:
                return 102;
            case SportType.SPORT_TYPE_TREADMILL /*264*/:
                return 101;
            case 265:
                return 103;
            case 279:
                return 117;
            default:
                C2538c.d("Debug_HiTypeUtil", new Object[]{"getCloudTrackSportType do not has this type yet , localType is ", Integer.valueOf(i)});
                return 5;
        }
    }

    public static int m23808d(int i) {
        switch (i) {
            case 1:
                return SportType.SPORT_TYPE_CLIMB_STAIRS;
            case 2:
                return SportType.SPORT_TYPE_CLIMB_HILL;
            case 3:
                return SportType.SPORT_TYPE_BIKE;
            case 4:
                return SportType.SPORT_TYPE_RUN;
            case 5:
                return 257;
            case 101:
                return SportType.SPORT_TYPE_TREADMILL;
            case 102:
                return SportType.SPORT_TYPE_SWIM;
            case 103:
                return 265;
            case 117:
                return 279;
            default:
                C2538c.d("Debug_HiTypeUtil", new Object[]{"getLocalTrackSportType do not has this type yet , cloudType is ", Integer.valueOf(i)});
                return 257;
        }
    }
}
