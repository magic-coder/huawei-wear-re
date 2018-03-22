package com.alipay.p238a.p239a.p240a;

import android.os.IBinder;
import android.os.Parcel;
import java.util.Map;

final class C3142d implements C3140b {
    private IBinder f10506a;

    C3142d(IBinder iBinder) {
        this.f10506a = iBinder;
    }

    public final String mo3667a(int i, Map map) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.alipay.android.phone.easybarcode.IAlipayEasyBarcode");
            obtain.writeInt(i);
            obtain.writeMap(map);
            this.f10506a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f10506a;
    }
}
