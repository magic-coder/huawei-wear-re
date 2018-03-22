package com.huawei.nfc.sdk.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IHwNFCOpenService extends IInterface {

    public abstract class Stub extends Binder implements IHwNFCOpenService {
        private static final String DESCRIPTOR = "com.huawei.nfc.sdk.service.IHwNFCOpenService";
        static final int TRANSACTION_createSSD = 1;
        static final int TRANSACTION_deleteSSD = 2;
        static final int TRANSACTION_getCplc = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IHwNFCOpenService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IHwNFCOpenService)) {
                return new Proxy(iBinder);
            }
            return (IHwNFCOpenService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int createSSD;
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    createSSD = createSSD(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(createSSD);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    createSSD = deleteSSD(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(createSSD);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    String cplc = getCplc();
                    parcel2.writeNoException();
                    parcel2.writeString(cplc);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int createSSD(String str, String str2, String str3, String str4) throws RemoteException;

    int deleteSSD(String str, String str2, String str3, String str4) throws RemoteException;

    String getCplc() throws RemoteException;
}
