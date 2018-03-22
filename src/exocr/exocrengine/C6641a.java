package exocr.exocrengine;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: EXOCardInfo */
final class C6641a implements Creator<EXOCardInfo> {
    C6641a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m29934a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m29935a(i);
    }

    public EXOCardInfo m29934a(Parcel parcel) {
        return new EXOCardInfo(parcel);
    }

    public EXOCardInfo[] m29935a(int i) {
        return new EXOCardInfo[i];
    }
}
