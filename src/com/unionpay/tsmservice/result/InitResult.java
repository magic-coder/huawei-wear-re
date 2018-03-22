package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.UpdateInfo;

public class InitResult implements Parcelable {
    public static final Creator<InitResult> CREATOR = new C66331();
    private UpdateInfo mUpdateInfo;

    final class C66331 implements Creator<InitResult> {
        C66331() {
        }

        public InitResult createFromParcel(Parcel parcel) {
            return new InitResult(parcel);
        }

        public InitResult[] newArray(int i) {
            return new InitResult[i];
        }
    }

    public InitResult(Parcel parcel) {
        this.mUpdateInfo = (UpdateInfo) parcel.readParcelable(UpdateInfo.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mUpdateInfo, i);
    }

    public UpdateInfo getUpdateInfo() {
        return this.mUpdateInfo;
    }

    public void setUpdateInfo(UpdateInfo updateInfo) {
        this.mUpdateInfo = updateInfo;
    }
}
