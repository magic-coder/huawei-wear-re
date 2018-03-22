package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.SeAppListItem;

public class GetSeAppListResult implements Parcelable {
    public static final Creator<GetSeAppListResult> CREATOR = new C66261();
    private SeAppListItem[] mSeAppList;

    final class C66261 implements Creator<GetSeAppListResult> {
        C66261() {
        }

        public GetSeAppListResult createFromParcel(Parcel parcel) {
            return new GetSeAppListResult(parcel);
        }

        public GetSeAppListResult[] newArray(int i) {
            return new GetSeAppListResult[i];
        }
    }

    public GetSeAppListResult(Parcel parcel) {
        this.mSeAppList = (SeAppListItem[]) parcel.createTypedArray(SeAppListItem.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.mSeAppList, i);
    }

    public SeAppListItem[] getSeAppList() {
        return this.mSeAppList;
    }

    public void setSeAppList(SeAppListItem[] seAppListItemArr) {
        this.mSeAppList = seAppListItemArr;
    }
}
