package cn.com.fmsh.nfcos.client.service.huawei;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cn.com.fmsh.util.FM_Bytes;

public class ActParameter implements Parcelable {
    public static final Creator<ActParameter> CREATOR = new C28781();
    public byte tagName;
    public String tagValue;

    class C28781 implements Creator<ActParameter> {
        C28781() {
        }

        public ActParameter createFromParcel(Parcel parcel) {
            ActParameter actParameter = new ActParameter();
            actParameter.tagName = parcel.readByte();
            actParameter.tagValue = parcel.readString();
            return actParameter;
        }

        public ActParameter[] newArray(int i) {
            return new ActParameter[i];
        }
    }

    public ActParameter(byte b, int i) {
        this.tagName = b;
        this.tagValue = String.valueOf(i);
    }

    public ActParameter(byte b, byte b2) {
        this.tagName = b;
        this.tagValue = String.valueOf(b2);
    }

    public ActParameter(byte b, byte[] bArr) {
        this.tagName = b;
        this.tagValue = FM_Bytes.bytesToHexString(bArr);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.tagName);
        parcel.writeString(this.tagValue);
    }

    public void readFromParcel(Parcel parcel) {
        this.tagName = parcel.readByte();
        this.tagValue = parcel.readString();
    }
}
