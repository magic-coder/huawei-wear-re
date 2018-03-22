package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.bk;

public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();
    int f12003a = 0;
    int f12004b = 0;
    Bitmap f12005c;

    BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.f12003a = bitmap.getWidth();
            this.f12004b = bitmap.getHeight();
            this.f12005c = m16436a(bitmap, bk.m15642a(this.f12003a), bk.m15642a(this.f12004b));
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2) {
        this.f12003a = i;
        this.f12004b = i2;
        this.f12005c = bitmap;
    }

    public BitmapDescriptor clone() {
        try {
            return new BitmapDescriptor(Bitmap.createBitmap(this.f12005c), this.f12003a, this.f12004b);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Bitmap getBitmap() {
        return this.f12005c;
    }

    public int getWidth() {
        return this.f12003a;
    }

    public int getHeight() {
        return this.f12004b;
    }

    private Bitmap m16436a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap.hasAlpha() ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12005c, i);
        parcel.writeInt(this.f12003a);
        parcel.writeInt(this.f12004b);
    }

    public void recycle() {
        if (this.f12005c != null && !this.f12005c.isRecycled()) {
            this.f12005c.recycle();
            this.f12005c = null;
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this.f12005c == null || this.f12005c.isRecycled() || obj == null) {
            return z;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return z;
        }
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) obj;
        if (bitmapDescriptor.f12005c == null || bitmapDescriptor.f12005c.isRecycled() || this.f12003a != bitmapDescriptor.getWidth() || this.f12004b != bitmapDescriptor.getHeight()) {
            return z;
        }
        try {
            return this.f12005c.sameAs(bitmapDescriptor.f12005c);
        } catch (Throwable th) {
            return z;
        }
    }
}
