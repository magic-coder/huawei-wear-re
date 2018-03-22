package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ApplyActivityStyle implements Parcelable {
    public static final Creator<ApplyActivityStyle> CREATOR = new C65591();
    private int activityBackgroundColor = 0;
    private int buttonColor = 0;
    private int titleColor = 0;

    final class C65591 implements Creator<ApplyActivityStyle> {
        C65591() {
        }

        public ApplyActivityStyle createFromParcel(Parcel parcel) {
            return new ApplyActivityStyle(parcel);
        }

        public ApplyActivityStyle[] newArray(int i) {
            return new ApplyActivityStyle[i];
        }
    }

    public ApplyActivityStyle(Parcel parcel) {
        this.titleColor = parcel.readInt();
        this.buttonColor = parcel.readInt();
        this.activityBackgroundColor = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.titleColor);
        parcel.writeInt(this.buttonColor);
        parcel.writeInt(this.activityBackgroundColor);
    }

    public int getTitleColor() {
        return this.titleColor;
    }

    public void setTitleColor(int i) {
        this.titleColor = i;
    }

    public int getButtonColor() {
        return this.buttonColor;
    }

    public void setButtonColor(int i) {
        this.buttonColor = i;
    }

    public int getActivityBackgroundColor() {
        return this.activityBackgroundColor;
    }

    public void setActivityBackgroundColor(int i) {
        this.activityBackgroundColor = i;
    }
}
