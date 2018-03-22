package cn.com.fmsh.nfcos.client.service.huawei;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BroadCastParameter implements Parcelable {
    public static final Creator<BroadCastParameter> CREATOR = new C28791();
    public int broadcastType;
    public int process;

    class C28791 implements Creator<BroadCastParameter> {
        C28791() {
        }

        public BroadCastParameter createFromParcel(Parcel parcel) {
            BroadCastParameter broadCastParameter = new BroadCastParameter();
            broadCastParameter.broadcastType = parcel.readInt();
            broadCastParameter.process = parcel.readInt();
            return broadCastParameter;
        }

        public BroadCastParameter[] newArray(int i) {
            return new BroadCastParameter[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.broadcastType);
        parcel.writeInt(this.process);
    }

    public void readFromParcel(Parcel parcel) {
        this.broadcastType = parcel.readInt();
        this.process = parcel.readInt();
    }
}
