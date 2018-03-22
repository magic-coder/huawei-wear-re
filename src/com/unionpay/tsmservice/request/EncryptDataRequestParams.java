package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class EncryptDataRequestParams extends RequestParams {
    public static final Creator<EncryptDataRequestParams> CREATOR = new C65841();
    private List<String> mData;

    final class C65841 implements Creator<EncryptDataRequestParams> {
        C65841() {
        }

        public EncryptDataRequestParams createFromParcel(Parcel parcel) {
            return new EncryptDataRequestParams(parcel);
        }

        public EncryptDataRequestParams[] newArray(int i) {
            return new EncryptDataRequestParams[i];
        }
    }

    public EncryptDataRequestParams(Parcel parcel) {
        this.mData = new ArrayList();
        parcel.readList(this.mData, ClassLoader.getSystemClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.mData);
    }

    public List<String> getData() {
        return this.mData;
    }

    public void setData(List<String> list) {
        this.mData = list;
    }
}
