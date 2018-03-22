package com.huawei.android.hwpay.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.Map;

public interface IHuaweiPayService extends IInterface {

    public abstract class Stub extends Binder implements IHuaweiPayService {

        class Proxy implements IHuaweiPayService {
            private IBinder f15331b;

            Proxy(IBinder iBinder) {
                this.f15331b = iBinder;
            }

            public void initPayEnv() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.android.hwpay.service.IHuaweiPayService");
                    this.f15331b.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String pay(Map map, IRemoteServiceCallback iRemoteServiceCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.android.hwpay.service.IHuaweiPayService");
                    obtain.writeMap(map);
                    obtain.writeStrongBinder(iRemoteServiceCallback != null ? iRemoteServiceCallback.asBinder() : null);
                    this.f15331b.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String queryToBind(int i, Map map, IRemoteServiceCallback iRemoteServiceCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.android.hwpay.service.IHuaweiPayService");
                    obtain.writeInt(i);
                    obtain.writeMap(map);
                    obtain.writeStrongBinder(iRemoteServiceCallback != null ? iRemoteServiceCallback.asBinder() : null);
                    this.f15331b.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IHuaweiPayService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hwpay.service.IHuaweiPayService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IHuaweiPayService)) ? new Proxy(iBinder) : (IHuaweiPayService) queryLocalInterface;
        }
    }

    void initPayEnv();

    String pay(Map map, IRemoteServiceCallback iRemoteServiceCallback);

    String queryToBind(int i, Map map, IRemoteServiceCallback iRemoteServiceCallback);
}
