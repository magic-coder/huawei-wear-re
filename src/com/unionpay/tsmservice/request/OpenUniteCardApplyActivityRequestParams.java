package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.ApplyActivityStyle;

public class OpenUniteCardApplyActivityRequestParams extends RequestParams {
    public static final Creator<OpenUniteCardApplyActivityRequestParams> CREATOR = new C66021();
    private ApplyActivityStyle mApplyActivityStyle;
    private String mBankName;
    private String mCardType;
    private String mSpan;
    private String mTCUrl;

    final class C66021 implements Creator<OpenUniteCardApplyActivityRequestParams> {
        C66021() {
        }

        public OpenUniteCardApplyActivityRequestParams createFromParcel(Parcel parcel) {
            return new OpenUniteCardApplyActivityRequestParams(parcel);
        }

        public OpenUniteCardApplyActivityRequestParams[] newArray(int i) {
            return new OpenUniteCardApplyActivityRequestParams[i];
        }
    }

    public OpenUniteCardApplyActivityRequestParams(Parcel parcel) {
        this.mSpan = parcel.readString();
        this.mTCUrl = parcel.readString();
        this.mBankName = parcel.readString();
        this.mCardType = parcel.readString();
        this.mApplyActivityStyle = (ApplyActivityStyle) parcel.readParcelable(ApplyActivityStyle.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mSpan);
        parcel.writeString(this.mTCUrl);
        parcel.writeString(this.mBankName);
        parcel.writeString(this.mCardType);
        parcel.writeParcelable(this.mApplyActivityStyle, i);
    }

    public ApplyActivityStyle getmApplyActivityStyle() {
        return this.mApplyActivityStyle;
    }

    public void setmApplyActivityStyle(ApplyActivityStyle applyActivityStyle) {
        this.mApplyActivityStyle = applyActivityStyle;
    }

    public String getSpan() {
        return this.mSpan;
    }

    public void setSpan(String str) {
        this.mSpan = str;
    }

    public String getTCUrl() {
        return this.mTCUrl;
    }

    public void setTCUrl(String str) {
        this.mTCUrl = str;
    }

    public String getBankName() {
        return this.mBankName;
    }

    public void setBankName(String str) {
        this.mBankName = str;
    }

    public String getCardType() {
        return this.mCardType;
    }

    public void setCardType(String str) {
        this.mCardType = str;
    }
}
