package com.huawei.logupload;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* compiled from: ExternalConnectionDatabase */
public interface C1094a extends IInterface {

    /* compiled from: ExternalConnectionDatabase */
    public abstract class C1096a extends Binder implements C1094a {

        /* compiled from: ExternalConnectionDatabase */
        class C1095a implements C1094a {
            private IBinder f2259a;

            C1095a(IBinder iBinder) {
                this.f2259a = iBinder;
            }

            public IBinder asBinder() {
                return this.f2259a;
            }

            public boolean mo2354a(LogUpload logUpload) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.logupload.ExternalConnectionDatabase");
                    if (logUpload != null) {
                        obtain.writeInt(1);
                        logUpload.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2259a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    if (obtain2.readInt() != 0) {
                        logUpload.m4769a(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<LogUpload> mo2353a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.logupload.ExternalConnectionDatabase");
                    this.f2259a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    List<LogUpload> createTypedArrayList = obtain2.createTypedArrayList(LogUpload.CREATOR);
                    return createTypedArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String mo2355b(LogUpload logUpload) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.logupload.ExternalConnectionDatabase");
                    if (logUpload != null) {
                        obtain.writeInt(1);
                        logUpload.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2259a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    if (obtain2.readInt() != 0) {
                        logUpload.m4769a(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo2356c(LogUpload logUpload) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.logupload.ExternalConnectionDatabase");
                    if (logUpload != null) {
                        obtain.writeInt(1);
                        logUpload.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2259a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        logUpload.m4769a(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public LogUpload mo2352a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    LogUpload logUpload;
                    obtain.writeInterfaceToken("com.huawei.logupload.ExternalConnectionDatabase");
                    obtain.writeString(str);
                    this.f2259a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        logUpload = (LogUpload) LogUpload.CREATOR.createFromParcel(obtain2);
                    } else {
                        logUpload = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return logUpload;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1096a() {
            attachInterface(this, "com.huawei.logupload.ExternalConnectionDatabase");
        }

        public static C1094a m4840a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.logupload.ExternalConnectionDatabase");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C1094a)) {
                return new C1095a(iBinder);
            }
            return (C1094a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            LogUpload logUpload = null;
            switch (i) {
                case 1:
                    int i3;
                    parcel.enforceInterface("com.huawei.logupload.ExternalConnectionDatabase");
                    if (parcel.readInt() != 0) {
                        logUpload = (LogUpload) LogUpload.CREATOR.createFromParcel(parcel);
                    }
                    boolean a = mo2354a(logUpload);
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
                    parcel.enforceInterface("com.huawei.logupload.ExternalConnectionDatabase");
                    List a2 = mo2353a();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(a2);
                    return true;
                case 3:
                    parcel.enforceInterface("com.huawei.logupload.ExternalConnectionDatabase");
                    if (parcel.readInt() != 0) {
                        logUpload = (LogUpload) LogUpload.CREATOR.createFromParcel(parcel);
                    }
                    String b = mo2355b(logUpload);
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    if (logUpload != null) {
                        parcel2.writeInt(1);
                        logUpload.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.huawei.logupload.ExternalConnectionDatabase");
                    if (parcel.readInt() != 0) {
                        logUpload = (LogUpload) LogUpload.CREATOR.createFromParcel(parcel);
                    }
                    mo2356c(logUpload);
                    parcel2.writeNoException();
                    if (logUpload != null) {
                        parcel2.writeInt(1);
                        logUpload.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.huawei.logupload.ExternalConnectionDatabase");
                    logUpload = mo2352a(parcel.readString());
                    parcel2.writeNoException();
                    if (logUpload != null) {
                        parcel2.writeInt(1);
                        logUpload.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.huawei.logupload.ExternalConnectionDatabase");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    LogUpload mo2352a(String str);

    List<LogUpload> mo2353a();

    boolean mo2354a(LogUpload logUpload);

    String mo2355b(LogUpload logUpload);

    void mo2356c(LogUpload logUpload);
}
