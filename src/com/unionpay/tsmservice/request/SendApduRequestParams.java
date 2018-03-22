package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class SendApduRequestParams extends RequestParams {
    public static final Creator<SendApduRequestParams> CREATOR = new C66041();
    private String channel;
    private String hexApdu;

    final class C66041 implements Creator<SendApduRequestParams> {
        C66041() {
        }

        public SendApduRequestParams createFromParcel(Parcel parcel) {
            return new SendApduRequestParams(parcel);
        }

        public SendApduRequestParams[] newArray(int i) {
            return new SendApduRequestParams[i];
        }
    }

    public SendApduRequestParams(Parcel parcel) {
        this.channel = parcel.readString();
        this.hexApdu = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.channel);
        parcel.writeString(this.hexApdu);
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public String getHexApdu() {
        return this.hexApdu;
    }

    public void setHexApdu(String str) {
        this.hexApdu = str;
    }
}
