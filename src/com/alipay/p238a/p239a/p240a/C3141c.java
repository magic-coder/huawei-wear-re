package com.alipay.p238a.p239a.p240a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class C3141c extends Binder implements C3140b {
    public static C3140b m13976a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.alipay.android.phone.easybarcode.IAlipayEasyBarcode");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C3140b)) ? new C3142d(iBinder) : (C3140b) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.alipay.android.phone.easybarcode.IAlipayEasyBarcode");
                String a = mo3667a(parcel.readInt(), parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 1598968902:
                parcel2.writeString("com.alipay.android.phone.easybarcode.IAlipayEasyBarcode");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
