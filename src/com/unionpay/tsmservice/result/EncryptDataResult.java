package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class EncryptDataResult implements Parcelable {
    public static final Creator<EncryptDataResult> CREATOR = new C66121();
    private List<String> mEncryptData;

    final class C66121 implements Creator<EncryptDataResult> {
        C66121() {
        }

        public EncryptDataResult createFromParcel(Parcel parcel) {
            return new EncryptDataResult(parcel);
        }

        public EncryptDataResult[] newArray(int i) {
            return new EncryptDataResult[i];
        }
    }

    public EncryptDataResult(Parcel parcel) {
        this.mEncryptData = new ArrayList();
        parcel.readList(this.mEncryptData, ClassLoader.getSystemClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.mEncryptData);
    }

    public List<String> getEncryptData() {
        return this.mEncryptData;
    }

    public void setEncryptData(List<String> list) {
        this.mEncryptData = list;
    }
}
