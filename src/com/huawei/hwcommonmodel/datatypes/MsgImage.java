package com.huawei.hwcommonmodel.datatypes;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MsgImage implements Parcelable {
    public static final Creator<MsgImage> CREATOR = new C4749p();
    private Bitmap imageBitmap;
    private int imageType;

    public int getImageType() {
        return this.imageType;
    }

    public void setImageType(int i) {
        this.imageType = i;
    }

    public Bitmap getImageBitmap() {
        return this.imageBitmap;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.imageBitmap = bitmap;
    }

    public MsgImage(Bitmap bitmap, int i) {
        this.imageBitmap = bitmap;
        this.imageType = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.imageBitmap, 0);
        parcel.writeInt(this.imageType);
    }

    protected MsgImage(Parcel parcel) {
        this.imageBitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.imageType = parcel.readInt();
    }
}
