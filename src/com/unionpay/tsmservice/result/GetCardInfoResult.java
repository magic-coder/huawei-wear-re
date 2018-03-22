package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.VirtualCardInfo;

public class GetCardInfoResult implements Parcelable {
    public static final Creator<GetCardInfoResult> CREATOR = new C66211();
    private VirtualCardInfo[] mVirtualCardInfo;

    final class C66211 implements Creator<GetCardInfoResult> {
        C66211() {
        }

        public GetCardInfoResult createFromParcel(Parcel parcel) {
            return new GetCardInfoResult(parcel);
        }

        public GetCardInfoResult[] newArray(int i) {
            return new GetCardInfoResult[i];
        }
    }

    public GetCardInfoResult(Parcel parcel) {
        this.mVirtualCardInfo = (VirtualCardInfo[]) parcel.createTypedArray(VirtualCardInfo.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.mVirtualCardInfo, i);
    }

    public VirtualCardInfo[] getVirtualCardInfo() {
        return this.mVirtualCardInfo;
    }

    public void setVirtualCardInfo(VirtualCardInfo[] virtualCardInfoArr) {
        this.mVirtualCardInfo = virtualCardInfoArr;
    }
}
