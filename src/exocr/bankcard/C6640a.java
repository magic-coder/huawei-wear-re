package exocr.bankcard;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: EXBankCardInfo */
final class C6640a implements Creator<EXBankCardInfo> {
    C6640a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m29922a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m29923a(i);
    }

    public EXBankCardInfo m29922a(Parcel parcel) {
        return new EXBankCardInfo(parcel);
    }

    public EXBankCardInfo[] m29923a(int i) {
        return new EXBankCardInfo[i];
    }
}
