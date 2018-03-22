package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HiHealthUnit implements Parcelable {
    public static final int BLOOD_GLUCOSE = 6;
    public static final int BLOOD_PRESSURE = 7;
    public static final int CALORIES = 3;
    public static final int CLIMB = 4;
    public static final int COUNT = 16;
    public static final Creator<HiHealthUnit> CREATOR = new C4569l();
    public static final int DEFAULT = 0;
    public static final int DISTANCE = 2;
    public static final int DURATION_MIL = 5;
    public static final int DURATION_MINUTE = 15;
    public static final int DURATION_SECONDS = 13;
    public static final int FLOOR_TO_ALTITUDE_RATIO = 30;
    public static final int HEAR_TRATE = 8;
    public static final int HEIGHT_CM = 11;
    public static final int HEIGHT_FT = 12;
    public static final int PACE_MINUTE = 14;
    public static final int PERSENT = 18;
    public static final int SCORE = 17;
    public static final int STEPS = 1;
    public static final int WEIGHT_BL = 10;
    public static final int WEIGHT_KG = 9;

    protected HiHealthUnit(Parcel parcel) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
