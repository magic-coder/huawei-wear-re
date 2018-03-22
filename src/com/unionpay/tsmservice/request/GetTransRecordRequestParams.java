package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class GetTransRecordRequestParams extends RequestParams {
    public static final Creator<GetTransRecordRequestParams> CREATOR = new C65971();
    private AppID mAppID;

    final class C65971 implements Creator<GetTransRecordRequestParams> {
        C65971() {
        }

        public GetTransRecordRequestParams createFromParcel(Parcel parcel) {
            return new GetTransRecordRequestParams(parcel);
        }

        public GetTransRecordRequestParams[] newArray(int i) {
            return new GetTransRecordRequestParams[i];
        }
    }

    public GetTransRecordRequestParams(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }
}
