package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class GetTransElementsRequestParams extends RequestParams {
    public static final Creator<GetTransElementsRequestParams> CREATOR = new C65961();
    public static final String TRANS_TYPE_DELETE = "0112";
    public static final String TRANS_TYPE_DOWNLOAD_APPLY = "0101";
    private AppID mAppID;
    private String mTransType;

    final class C65961 implements Creator<GetTransElementsRequestParams> {
        C65961() {
        }

        public GetTransElementsRequestParams createFromParcel(Parcel parcel) {
            return new GetTransElementsRequestParams(parcel);
        }

        public GetTransElementsRequestParams[] newArray(int i) {
            return new GetTransElementsRequestParams[i];
        }
    }

    public GetTransElementsRequestParams(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mTransType = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeString(this.mTransType);
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public String getTransType() {
        return this.mTransType;
    }

    public void setTransType(String str) {
        this.mTransType = str;
    }
}
