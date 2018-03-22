package com.huawei.hihealth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IHiHealth */
public abstract class an extends Binder implements am {
    public static am m21692a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hihealth.IHiHealth");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof am)) {
            return new ao(iBinder);
        }
        return (am) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        int i3 = 0;
        boolean a;
        int i4;
        HiUserInfo hiUserInfo;
        HiHealthUnit a2;
        HiUserPreference hiUserPreference;
        switch (i) {
            case 1:
                HiAppInfo hiAppInfo;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                if (parcel.readInt() != 0) {
                    hiAppInfo = (HiAppInfo) HiAppInfo.CREATOR.createFromParcel(parcel);
                } else {
                    hiAppInfo = null;
                }
                mo4507a(hiAppInfo);
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4497a();
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                ClassLoader classLoader = getClass().getClassLoader();
                mo4522a(parcel.readArrayList(classLoader), parcel.readArrayList(classLoader), C4580y.m21847a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4502a(parcel.readInt(), aw.m21736a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4519a(parcel.readArrayList(getClass().getClassLoader()), at.m21590a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                HiSubscribeTrigger hiSubscribeTrigger;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    hiSubscribeTrigger = (HiSubscribeTrigger) HiSubscribeTrigger.CREATOR.createFromParcel(parcel);
                } else {
                    hiSubscribeTrigger = null;
                }
                a = mo4523a(readInt, readInt2, hiSubscribeTrigger);
                parcel2.writeNoException();
                if (a) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                parcel2.writeInt(i4);
                return true;
            case 7:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4520a(parcel.readArrayList(getClass().getClassLoader()), az.m21620a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 8:
                HiAggregateOption hiAggregateOption;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                if (parcel.readInt() != 0) {
                    hiAggregateOption = (HiAggregateOption) HiAggregateOption.CREATOR.createFromParcel(parcel);
                } else {
                    hiAggregateOption = null;
                }
                mo4506a(hiAggregateOption, C4515s.m21623a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4521a(parcel.readArrayList(getClass().getClassLoader()), C4577v.m21844a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 10:
                HiDataInsertOption hiDataInsertOption;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                if (parcel.readInt() != 0) {
                    hiDataInsertOption = (HiDataInsertOption) HiDataInsertOption.CREATOR.createFromParcel(parcel);
                } else {
                    hiDataInsertOption = null;
                }
                mo4509a(hiDataInsertOption, ah.m21626a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                HiDataDeleteOption hiDataDeleteOption;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                if (parcel.readInt() != 0) {
                    hiDataDeleteOption = (HiDataDeleteOption) HiDataDeleteOption.CREATOR.createFromParcel(parcel);
                } else {
                    hiDataDeleteOption = null;
                }
                mo4508a(hiDataDeleteOption, ah.m21626a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                HiDataReadOption hiDataReadOption;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                if (parcel.readInt() != 0) {
                    hiDataReadOption = (HiDataReadOption) HiDataReadOption.CREATOR.createFromParcel(parcel);
                } else {
                    hiDataReadOption = null;
                }
                mo4510a(hiDataReadOption, ak.m21629a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                HiDataUpdateOption hiDataUpdateOption;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                if (parcel.readInt() != 0) {
                    hiDataUpdateOption = (HiDataUpdateOption) HiDataUpdateOption.CREATOR.createFromParcel(parcel);
                } else {
                    hiDataUpdateOption = null;
                }
                mo4511a(hiDataUpdateOption, ah.m21626a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                i4 = mo4495a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(i4);
                return true;
            case 15:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                i4 = mo4525b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(i4);
                return true;
            case 16:
                HiDeviceInfo hiDeviceInfo;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                if (parcel.readInt() != 0) {
                    hiDeviceInfo = (HiDeviceInfo) HiDeviceInfo.CREATOR.createFromParcel(parcel);
                } else {
                    hiDeviceInfo = null;
                }
                mo4513a(hiDeviceInfo, parcel.readArrayList(getClass().getClassLoader()), aq.m21632a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 17:
                HiDeviceInfo hiDeviceInfo2;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                if (parcel.readInt() != 0) {
                    hiDeviceInfo2 = (HiDeviceInfo) HiDeviceInfo.CREATOR.createFromParcel(parcel);
                } else {
                    hiDeviceInfo2 = null;
                }
                if (parcel.readInt() != 0) {
                    hiUserInfo = (HiUserInfo) HiUserInfo.CREATOR.createFromParcel(parcel);
                } else {
                    hiUserInfo = null;
                }
                mo4512a(hiDeviceInfo2, hiUserInfo, parcel.readArrayList(getClass().getClassLoader()), aq.m21632a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 18:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4517a(ae.m21649a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4528b(ae.m21649a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4532c(ae.m21649a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 21:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4501a(parcel.readInt(), ae.m21649a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4503a(parcel.readInt(), parcel.readString(), ae.m21649a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 23:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                a2 = mo4496a(parcel.readInt());
                parcel2.writeNoException();
                if (a2 != null) {
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 24:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                i3 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    a2 = (HiHealthUnit) HiHealthUnit.CREATOR.createFromParcel(parcel);
                } else {
                    a2 = null;
                }
                mo4499a(i3, a2);
                parcel2.writeNoException();
                return true;
            case 25:
                HiTimeInterval hiTimeInterval;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                i3 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    hiTimeInterval = (HiTimeInterval) HiTimeInterval.CREATOR.createFromParcel(parcel);
                } else {
                    hiTimeInterval = null;
                }
                mo4500a(i3, hiTimeInterval, ae.m21649a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 26:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                if (parcel.readInt() != 0) {
                    hiUserInfo = (HiUserInfo) HiUserInfo.CREATOR.createFromParcel(parcel);
                } else {
                    hiUserInfo = null;
                }
                mo4515a(hiUserInfo, ab.m21585a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 27:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4516a(ab.m21585a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 28:
                HiSyncOption hiSyncOption;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                if (parcel.readInt() != 0) {
                    hiSyncOption = (HiSyncOption) HiSyncOption.CREATOR.createFromParcel(parcel);
                } else {
                    hiSyncOption = null;
                }
                mo4514a(hiSyncOption, ab.m21585a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 29:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4518a(parcel.readArrayList(getClass().getClassLoader()), ab.m21585a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 30:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4526b();
                parcel2.writeNoException();
                return true;
            case 31:
                HiAccountInfo hiAccountInfo;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                if (parcel.readInt() != 0) {
                    hiAccountInfo = (HiAccountInfo) HiAccountInfo.CREATOR.createFromParcel(parcel);
                } else {
                    hiAccountInfo = null;
                }
                mo4505a(hiAccountInfo, ab.m21585a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 32:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4527b(ab.m21585a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 33:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4531c(ab.m21585a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 34:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4504a(parcel.readInt(), parcel.readArrayList(getClass().getClassLoader()), ab.m21585a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 35:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                mo4498a(parcel.readInt(), parcel.readInt(), ab.m21585a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 36:
                boolean z;
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                if (parcel.readInt() != 0) {
                    hiUserPreference = (HiUserPreference) HiUserPreference.CREATOR.createFromParcel(parcel);
                } else {
                    hiUserPreference = null;
                }
                if (parcel.readInt() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                a = mo4524a(hiUserPreference, z);
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 37:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                hiUserPreference = mo4530c(parcel.readString());
                parcel2.writeNoException();
                if (hiUserPreference != null) {
                    parcel2.writeInt(1);
                    hiUserPreference.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 38:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                a = mo4533d(parcel.readString());
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 39:
                parcel.enforceInterface("com.huawei.hihealth.IHiHealth");
                i4 = mo4529c();
                parcel2.writeNoException();
                parcel2.writeInt(i4);
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.hihealth.IHiHealth");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
