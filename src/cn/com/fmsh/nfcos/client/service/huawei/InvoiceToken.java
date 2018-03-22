package cn.com.fmsh.nfcos.client.service.huawei;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class InvoiceToken implements Parcelable {
    public static final Creator<InvoiceToken> CREATOR = new C28831();
    public String token;

    class C28831 implements Creator<InvoiceToken> {
        C28831() {
        }

        public InvoiceToken createFromParcel(Parcel parcel) {
            InvoiceToken invoiceToken = new InvoiceToken();
            invoiceToken.token = parcel.readString();
            return invoiceToken;
        }

        public InvoiceToken[] newArray(int i) {
            return new InvoiceToken[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.token);
    }

    public void readFromParcel(Parcel parcel) {
        this.token = parcel.readString();
    }
}
