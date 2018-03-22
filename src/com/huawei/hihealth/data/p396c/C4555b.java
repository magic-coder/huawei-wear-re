package com.huawei.hihealth.data.p396c;

import com.huawei.p190v.C2538c;

/* compiled from: HiGoalType */
public class C4555b {
    public static int m21805a(int i, int i2) {
        C2538c.b("HiGoalType", new Object[]{"getLocalGoalType cloudGoalType is ", Integer.valueOf(i), " goalPeriod is ", Integer.valueOf(i2)});
        switch (i2) {
            case 1:
                return i;
            case 2:
                return i + 10;
            case 3:
                return i + 20;
            case 4:
                return i + 30;
            case 5:
                return i + 40;
            default:
                return 0;
        }
    }

    public static int m21804a(int i) {
        C2538c.b("HiGoalType", new Object[]{"getPeriod localGoalType is ", Integer.valueOf(i)});
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return 1;
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                return 2;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
                return 3;
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
                return 4;
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                return 5;
            default:
                return -1;
        }
    }

    public static int m21806b(int i, int i2) {
        switch (i2) {
            case 1:
                return i;
            case 2:
                return i - 10;
            case 3:
                return i - 20;
            case 4:
                return i - 30;
            case 5:
                return i - 40;
            default:
                return 0;
        }
    }
}
