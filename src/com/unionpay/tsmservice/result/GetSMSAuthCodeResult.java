package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.SMSAuthCode;

public class GetSMSAuthCodeResult implements Parcelable {
    public static final Creator<GetSMSAuthCodeResult> CREATOR = new C66251();
    private SMSAuthCode smsAuthCode;

    final class C66251 implements Creator<GetSMSAuthCodeResult> {
        C66251() {
        }

        public GetSMSAuthCodeResult createFromParcel(Parcel parcel) {
            return new GetSMSAuthCodeResult(parcel);
        }

        public GetSMSAuthCodeResult[] newArray(int i) {
            return new GetSMSAuthCodeResult[i];
        }
    }

    public GetSMSAuthCodeResult(Parcel parcel) {
        this.smsAuthCode = (SMSAuthCode) parcel.readParcelable(SMSAuthCode.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.smsAuthCode, i);
    }

    public SMSAuthCode getSmsAuthCode() {
        return this.smsAuthCode;
    }

    public void setSmsAuthCode(SMSAuthCode sMSAuthCode) {
        this.smsAuthCode = sMSAuthCode;
    }
}
