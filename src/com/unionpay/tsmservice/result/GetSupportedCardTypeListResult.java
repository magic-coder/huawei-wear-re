package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.CardTypeListItem;

public class GetSupportedCardTypeListResult implements Parcelable {
    public static final Creator<GetSupportedCardTypeListResult> CREATOR = new C66281();
    private CardTypeListItem[] mCardTypeListItem;

    final class C66281 implements Creator<GetSupportedCardTypeListResult> {
        C66281() {
        }

        public GetSupportedCardTypeListResult createFromParcel(Parcel parcel) {
            return new GetSupportedCardTypeListResult(parcel);
        }

        public GetSupportedCardTypeListResult[] newArray(int i) {
            return new GetSupportedCardTypeListResult[i];
        }
    }

    public GetSupportedCardTypeListResult(Parcel parcel) {
        this.mCardTypeListItem = (CardTypeListItem[]) parcel.createTypedArray(CardTypeListItem.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.mCardTypeListItem, i);
    }

    public CardTypeListItem[] getAppList() {
        return this.mCardTypeListItem;
    }

    public void setAppList(CardTypeListItem[] cardTypeListItemArr) {
        this.mCardTypeListItem = cardTypeListItemArr;
    }
}
