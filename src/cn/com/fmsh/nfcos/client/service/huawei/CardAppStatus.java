package cn.com.fmsh.nfcos.client.service.huawei;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CardAppStatus implements Parcelable {
    public static final Creator<CardAppStatus> CREATOR = new C28821();
    private int status;

    class C28821 implements Creator<CardAppStatus> {
        C28821() {
        }

        public CardAppStatus createFromParcel(Parcel parcel) {
            CardAppStatus cardAppStatus = new CardAppStatus();
            cardAppStatus.setStatus(parcel.readInt());
            return cardAppStatus;
        }

        public CardAppStatus[] newArray(int i) {
            return new CardAppStatus[i];
        }
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.status);
    }

    public void readFromParcel(Parcel parcel) {
        setStatus(parcel.readInt());
    }
}
