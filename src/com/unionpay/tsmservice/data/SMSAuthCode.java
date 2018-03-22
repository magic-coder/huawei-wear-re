package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SMSAuthCode implements Parcelable {
    public static final Creator<SMSAuthCode> CREATOR = new C65671();
    private String mExpireNote;

    final class C65671 implements Creator<SMSAuthCode> {
        C65671() {
        }

        public SMSAuthCode createFromParcel(Parcel parcel) {
            return new SMSAuthCode(parcel);
        }

        public SMSAuthCode[] newArray(int i) {
            return new SMSAuthCode[i];
        }
    }

    public SMSAuthCode(Parcel parcel) {
        this.mExpireNote = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mExpireNote);
    }

    public String getExpireNote() {
        return this.mExpireNote;
    }

    public void setExpireNote(String str) {
        this.mExpireNote = str;
    }
}
