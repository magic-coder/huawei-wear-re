package cn.com.fmsh.nfcos.client.service.huawei;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class CardAppInfo implements Parcelable {
    public static final Creator<CardAppInfo> CREATOR = new C28801();
    public int appLock;
    public byte[] appNo;
    public int balance;
    public String cardFaceNo;
    public int cardType;
    public String moc;
    public CardAppRecord[] records = new CardAppRecord[0];
    public String time4Validity;

    class C28801 implements Creator<CardAppInfo> {
        C28801() {
        }

        public CardAppInfo createFromParcel(Parcel parcel) {
            CardAppInfo cardAppInfo = new CardAppInfo();
            cardAppInfo.cardFaceNo = parcel.readString();
            cardAppInfo.appNo = CardAppInfo.readBytesWithNull(parcel);
            cardAppInfo.balance = parcel.readInt();
            cardAppInfo.records = (CardAppRecord[]) parcel.readParcelableArray(CardAppRecord.class.getClassLoader());
            cardAppInfo.appLock = parcel.readInt();
            cardAppInfo.cardType = parcel.readInt();
            cardAppInfo.moc = parcel.readString();
            cardAppInfo.time4Validity = parcel.readString();
            return cardAppInfo;
        }

        public CardAppInfo[] newArray(int i) {
            return new CardAppInfo[i];
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cardFaceNo);
        writeBytesWithNull(parcel, this.appNo);
        parcel.writeInt(this.balance);
        parcel.writeParcelableArray(this.records, 1);
        parcel.writeInt(this.appLock);
        parcel.writeInt(this.cardType);
        parcel.writeString(this.moc);
        parcel.writeString(this.time4Validity);
    }

    static byte[] readBytesWithNull(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        parcel.readByteArray(bArr);
        return bArr;
    }

    static void writeBytesWithNull(Parcel parcel, byte[] bArr) {
        if (bArr == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.cardFaceNo = parcel.readString();
        this.appNo = readBytesWithNull(parcel);
        this.balance = parcel.readInt();
        Parcelable[] readParcelableArray = parcel.readParcelableArray(CardAppRecord.class.getClassLoader());
        if (readParcelableArray != null) {
            this.records = (CardAppRecord[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, CardAppRecord[].class);
        }
        this.appLock = parcel.readInt();
        this.cardType = parcel.readInt();
        this.moc = parcel.readString();
        this.time4Validity = parcel.readString();
    }
}
