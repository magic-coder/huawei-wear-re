package com.unionpay.tsmservice.result;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.TransElement;
import java.util.Arrays;

public class GetTransElementsResult implements Parcelable {
    public static final Creator<GetTransElementsResult> CREATOR = new C66291();
    private TransElement[] mCreditElements;
    private TransElement[] mDebitElements;

    final class C66291 implements Creator<GetTransElementsResult> {
        C66291() {
        }

        public GetTransElementsResult createFromParcel(Parcel parcel) {
            return new GetTransElementsResult(parcel);
        }

        public GetTransElementsResult[] newArray(int i) {
            return new GetTransElementsResult[i];
        }
    }

    @SuppressLint({"NewApi"})
    public GetTransElementsResult(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(TransElement.class.getClassLoader());
        if (readParcelableArray != null) {
            this.mDebitElements = (TransElement[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, TransElement[].class);
        }
        readParcelableArray = parcel.readParcelableArray(TransElement.class.getClassLoader());
        if (readParcelableArray != null) {
            this.mCreditElements = (TransElement[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, TransElement[].class);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.mDebitElements, i);
        parcel.writeParcelableArray(this.mCreditElements, i);
    }

    public TransElement[] getDebitElements() {
        return this.mDebitElements;
    }

    public void setDebitElements(TransElement[] transElementArr) {
        this.mDebitElements = transElementArr;
    }

    public TransElement[] getCreditElements() {
        return this.mCreditElements;
    }

    public void setCreditElements(TransElement[] transElementArr) {
        this.mCreditElements = transElementArr;
    }
}
