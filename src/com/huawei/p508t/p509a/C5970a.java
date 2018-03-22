package com.huawei.p508t.p509a;

import com.huawei.hms.support.api.entity.pay.PayStatusCodes;

/* compiled from: DataTypeUtil */
public class C5970a {
    public static String m27382a(int i) {
        String str = "step_sum";
        switch (i) {
            case 2:
                return "step";
            case 3:
                return "distance";
            case 4:
                return "calorie";
            case 5:
                return "altitude_offset";
            case PayStatusCodes.PRODUCT_AUTHENTICATION_FAILED /*40002*/:
                return "step_sum";
            case PayStatusCodes.PRODUCT_SERVER_INTERNAL_EXCEPTION /*40003*/:
                return "calorie_sum";
            case PayStatusCodes.PRODUCT_SOME_NOT_EXIST /*40004*/:
                return "distance_sum";
            case 40005:
                return "storey_sum";
            case 42003:
                return "all_distance_sum";
            case 42004:
                return "all_track_pace";
            case 42005:
                return "all_track_count";
            default:
                return str;
        }
    }

    public static int m27383b(int i) {
        switch (i) {
            case 2:
                return 4;
            default:
                return 3;
        }
    }

    public static int m27384c(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 4:
                return 3;
            case 8:
                return 4;
            default:
                return 0;
        }
    }
}
