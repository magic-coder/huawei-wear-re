package cn.com.fmsh.nfcos.client.service.huawei;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PreDepositInfo implements Parcelable {
    public static final Creator<PreDepositInfo> CREATOR = new C28921();
    public int blance;
    public int total;

    class C28921 implements Creator<PreDepositInfo> {
        C28921() {
        }

        public PreDepositInfo createFromParcel(Parcel parcel) {
            PreDepositInfo preDepositInfo = new PreDepositInfo();
            preDepositInfo.total = parcel.readInt();
            preDepositInfo.blance = parcel.readInt();
            return preDepositInfo;
        }

        public PreDepositInfo[] newArray(int i) {
            return new PreDepositInfo[i];
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.total);
        parcel.writeInt(this.blance);
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.total = parcel.readInt();
        this.blance = parcel.readInt();
    }
}
