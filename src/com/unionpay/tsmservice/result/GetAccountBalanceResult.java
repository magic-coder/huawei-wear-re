package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.AssociatedCardBalance;

public class GetAccountBalanceResult implements Parcelable {
    public static final Creator<GetAccountBalanceResult> CREATOR = new C66141();
    private AssociatedCardBalance mAssociatedCardBalance;

    final class C66141 implements Creator<GetAccountBalanceResult> {
        C66141() {
        }

        public GetAccountBalanceResult createFromParcel(Parcel parcel) {
            return new GetAccountBalanceResult(parcel);
        }

        public GetAccountBalanceResult[] newArray(int i) {
            return new GetAccountBalanceResult[i];
        }
    }

    public GetAccountBalanceResult(Parcel parcel) {
        this.mAssociatedCardBalance = (AssociatedCardBalance) parcel.readParcelable(AssociatedCardBalance.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAssociatedCardBalance, i);
    }

    public AssociatedCardBalance getAssociatedCardBalance() {
        return this.mAssociatedCardBalance;
    }

    public void setAssociatedCardBalance(AssociatedCardBalance associatedCardBalance) {
        this.mAssociatedCardBalance = associatedCardBalance;
    }
}
