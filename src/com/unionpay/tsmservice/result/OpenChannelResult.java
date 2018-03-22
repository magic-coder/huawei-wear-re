package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class OpenChannelResult implements Parcelable {
    public static final Creator<OpenChannelResult> CREATOR = new C66341();
    private String channel;
    private String outHexApdu;

    final class C66341 implements Creator<OpenChannelResult> {
        C66341() {
        }

        public OpenChannelResult createFromParcel(Parcel parcel) {
            return new OpenChannelResult(parcel);
        }

        public OpenChannelResult[] newArray(int i) {
            return new OpenChannelResult[i];
        }
    }

    public OpenChannelResult(Parcel parcel) {
        this.outHexApdu = parcel.readString();
        this.channel = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.outHexApdu);
        parcel.writeString(this.channel);
    }

    public String getOutHexApdu() {
        return this.outHexApdu;
    }

    public void setOutHexApdu(String str) {
        this.outHexApdu = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }
}
