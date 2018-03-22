package com.fenda.hwbracelet.mode;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Alarm */
final class C3618a implements Creator<Alarm> {
    C3618a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m18149a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m18150a(i);
    }

    public Alarm m18149a(Parcel parcel) {
        Alarm alarm = new Alarm();
        alarm.id = parcel.readInt();
        alarm.name = parcel.readString();
        alarm.time = parcel.readString();
        alarm.sun = parcel.readInt();
        alarm.mon = parcel.readInt();
        alarm.tue = parcel.readInt();
        alarm.wed = parcel.readInt();
        alarm.thu = parcel.readInt();
        alarm.fri = parcel.readInt();
        alarm.sat = parcel.readInt();
        return alarm;
    }

    public Alarm[] m18150a(int i) {
        return new Alarm[i];
    }
}
