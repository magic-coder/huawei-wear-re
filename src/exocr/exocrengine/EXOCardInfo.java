package exocr.exocrengine;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import exocr.base.ExBaseCardInfo;

public class EXOCardInfo extends ExBaseCardInfo implements Parcelable {
    public static final Creator<EXOCardInfo> CREATOR = new C6641a();

    public EXOCardInfo() {
        this.numbers = new char[64];
        this.rects = new Rect[64];
        this.charCount = 0;
        this.bitmap = null;
    }

    private EXOCardInfo(Parcel parcel) {
        int i = 0;
        this.numbers = new char[64];
        this.rects = new Rect[64];
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

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.charCount);
        parcel.writeCharArray(this.numbers);
        Rect[] rectArr = this.rects;
        for (int i2 = 0; i2 < this.charCount; i2++) {
            parcel.writeInt(rectArr[i2].left);
            parcel.writeInt(rectArr[i2].top);
            parcel.writeInt(rectArr[i2].right);
            parcel.writeInt(rectArr[i2].bottom);
        }
        parcel.writeString(this.strNumbers);
    }
}
