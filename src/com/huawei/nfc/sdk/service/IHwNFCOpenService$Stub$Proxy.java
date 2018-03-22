package com.huawei.nfc.sdk.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class IHwNFCOpenService$Stub$Proxy implements IHwNFCOpenService {
    private IBinder mRemote;

    IHwNFCOpenService$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "com.huawei.nfc.sdk.service.IHwNFCOpenService";
    }

    public int createSSD(String str, String str2, String str3, String str4) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwNFCOpenService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeString(str4);
            this.mRemote.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int deleteSSD(String str, String str2, String str3, String str4) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwNFCOpenService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            obtain.writeString(str4);
            this.mRemote.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String getCplc() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.nfc.sdk.service.IHwNFCOpenService");
            this.mRemote.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
