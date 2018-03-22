package exocr.bankcard;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import exocr.base.ExBaseCardInfo;

public final class EXBankCardInfo extends ExBaseCardInfo implements Parcelable {
    public static final Creator<EXBankCardInfo> CREATOR = new C6640a();

    public EXBankCardInfo() {
        this.numbers = new char[32];
        this.rects = new Rect[32];
        this.charCount = 0;
        this.bitmap = null;
    }

    private EXBankCardInfo(Parcel parcel) {
        int i = 0;
        this.numbers = new char[32];
        this.rects = new Rect[32];
        this.charCount = 0;
        this.bitmap = null;
        this.charCount = parcel.readInt();
        parcel.readCharArray(this.numbers);
        while (i < this.charCount) {
            this.rects[i] = new Rect(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            i++;
        }
        this.strNumbers = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.charCount);
        parcel.writeCharArray(this.numbers);
        for (int i2 = 0; i2 < this.charCount; i2++) {
            parcel.writeInt(this.rects[i2].left);
            parcel.writeInt(this.rects[i2].top);
            parcel.writeInt(this.rects[i2].right);
            parcel.writeInt(this.rects[i2].bottom);
        }
        parcel.writeString(this.strNumbers);
    }
}
