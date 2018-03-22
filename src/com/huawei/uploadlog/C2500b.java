package com.huawei.uploadlog;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: ExternalConnectionDatabase */
public abstract class C2500b extends Binder implements C2498a {
    public C2500b() {
        attachInterface(this, "com.huawei.uploadlog.ExternalConnectionDatabase");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        LogUpload logUpload = null;
        switch (i) {
            case 1:
                int i3;
                parcel.enforceInterface("com.huawei.uploadlog.ExternalConnectionDatabase");
                if (parcel.readInt() != 0) {
                    logUpload = (LogUpload) LogUpload.CREATOR.createFromParcel(parcel);
                }
                boolean a = mo2665a(logUpload);
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                parcel2.writeInt(i3);
                if (logUpload != null) {
                    parcel2.writeInt(1);
                    logUpload.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.uploadlog.ExternalConnectionDatabase");
                List a2 = mo2664a();
                parcel2.writeNoException();
                parcel2.writeTypedList(a2);
                return true;
            case 3:
                parcel.enforceInterface("com.huawei.uploadlog.ExternalConnectionDatabase");
                logUpload = mo2663a(parcel.readString());
                parcel2.writeNoException();
                if (logUpload != null) {
                    parcel2.writeInt(1);
                    logUpload.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 4:
                parcel.enforceInterface("com.huawei.uploadlog.ExternalConnectionDatabase");
                if (parcel.readInt() != 0) {
                    logUpload = (LogUpload) LogUpload.CREATOR.createFromParcel(parcel);
                }
                String b = mo2667b(logUpload);
                parcel2.writeNoException();
                parcel2.writeString(b);
                if (logUpload != null) {
                    parcel2.writeInt(1);
                    logUpload.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 5:
                parcel.enforceInterface("com.huawei.uploadlog.ExternalConnectionDatabase");
                if (parcel.readInt() != 0) {
                    logUpload = (LogUpload) LogUpload.CREATOR.createFromParcel(parcel);
                }
                mo2668c(logUpload);
                parcel2.writeNoException();
                if (logUpload != null) {
                    parcel2.writeInt(1);
                    logUpload.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 6:
                parcel.enforceInterface("com.huawei.uploadlog.ExternalConnectionDatabase");
                if (parcel.readInt() != 0) {
                    logUpload = (LogUpload) LogUpload.CREATOR.createFromParcel(parcel);
                }
                mo2669d(logUpload);
                parcel2.writeNoException();
                if (logUpload != null) {
                    parcel2.writeInt(1);
                    logUpload.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 7:
                parcel.enforceInterface("com.huawei.uploadlog.ExternalConnectionDatabase");
                if (parcel.readInt() != 0) {
                    logUpload = (LogUpload) LogUpload.CREATOR.createFromParcel(parcel);
                }
                mo2670e(logUpload);
                parcel2.writeNoException();
                if (logUpload != null) {
                    parcel2.writeInt(1);
                    logUpload.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 8:
                parcel.enforceInterface("com.huawei.uploadlog.ExternalConnectionDatabase");
                logUpload = mo2666b(parcel.readString());
                parcel2.writeNoException();
                if (logUpload != null) {
                    parcel2.writeInt(1);
                    logUpload.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.uploadlog.ExternalConnectionDatabase");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
