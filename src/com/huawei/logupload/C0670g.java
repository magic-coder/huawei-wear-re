package com.huawei.logupload;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: PackLogService */
public interface C0670g extends IInterface {

    /* compiled from: PackLogService */
    public abstract class C0671a extends Binder implements C0670g {
        public C0671a() {
            attachInterface(this, "com.huawei.logupload.PackLogService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.huawei.logupload.PackLogService");
                    Bundle a = mo2127a();
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.huawei.logupload.PackLogService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Bundle mo2127a();
}
