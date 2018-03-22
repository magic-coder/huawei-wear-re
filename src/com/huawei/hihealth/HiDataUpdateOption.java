package com.huawei.hihealth;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HiDataUpdateOption implements Parcelable {
    public static final Creator<HiDataUpdateOption> CREATOR = new C4564g();
    private int type;
    private ContentValues valueHolder;

    public HiDataUpdateOption(int i) {
        this.type = 100;
        this.type = i;
        this.valueHolder = new ContentValues();
    }

    public HiDataUpdateOption() {
        this.type = 100;
        this.valueHolder = new ContentValues();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeParcelable(this.valueHolder, i);
    }

    protected HiDataUpdateOption(Parcel parcel) {
        this.type = 100;
        this.type = parcel.readInt();
        this.valueHolder = (ContentValues) parcel.readParcelable(ContentValues.class.getClassLoader());
    }

    public final void putString(String str, String str2) {
        this.valueHolder.put(str, str2);
    }

    public String getString(String str) {
        return this.valueHolder.getAsString(str);
    }

    public void putBoolean(String str, boolean z) {
        this.valueHolder.put(str, Boolean.valueOf(z));
    }

    public boolean getBoolean(String str) {
        Boolean asBoolean = this.valueHolder.getAsBoolean(str);
        if (asBoolean == null) {
            return false;
        }
        return asBoolean.booleanValue();
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
