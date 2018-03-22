package com.huawei.android.hwpay.service;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

final class C4034a implements IRemoteServiceCallback {
    private IBinder f15332b;

    C4034a(IBinder iBinder) {
        this.f15332b = iBinder;
    }

    public final void startActivity(String str, String str2, int i, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.android.hwpay.service.IRemoteServiceCallback");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeInt(i);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f15332b.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
