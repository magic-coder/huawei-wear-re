package com.unionpay.tsmservice.result;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.TransRecord;
import java.util.Arrays;

public class GetTransRecordResult implements Parcelable {
    public static final Creator<GetTransRecordResult> CREATOR = new C66301();
    private TransRecord[] mTransRecord;

    final class C66301 implements Creator<GetTransRecordResult> {
        C66301() {
        }

        public GetTransRecordResult createFromParcel(Parcel parcel) {
            return new GetTransRecordResult(parcel);
        }

        public GetTransRecordResult[] newArray(int i) {
            return new GetTransRecordResult[i];
        }
    }

    @SuppressLint({"NewApi"})
    public GetTransRecordResult(Parcel parcel) {
        Parcelable[] readParcelableArray = parcel.readParcelableArray(TransRecord.class.getClassLoader());
        if (readParcelableArray != null) {
            this.mTransRecord = (TransRecord[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, TransRecord[].class);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.mTransRecord, i);
    }

    public TransRecord[] getTransRecord() {
        return this.mTransRecord;
    }

    public void setTransRecord(TransRecord[] transRecordArr) {
        this.mTransRecord = transRecordArr;
    }
}
