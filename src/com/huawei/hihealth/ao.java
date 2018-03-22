package com.huawei.hihealth;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: IHiHealth */
class ao implements am {
    private IBinder f16763a;

    ao(IBinder iBinder) {
        this.f16763a = iBinder;
    }

    public IBinder asBinder() {
        return this.f16763a;
    }

    public void mo4507a(HiAppInfo hiAppInfo) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            if (hiAppInfo != null) {
                obtain.writeInt(1);
                hiAppInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f16763a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4497a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            this.f16763a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4522a(List list, List list2, C4579x c4579x) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeList(list);
            obtain.writeList(list2);
            obtain.writeStrongBinder(c4579x != null ? c4579x.asBinder() : null);
            this.f16763a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4502a(int i, av avVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeInt(i);
            obtain.writeStrongBinder(avVar != null ? avVar.asBinder() : null);
            this.f16763a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4519a(List list, as asVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeList(list);
            obtain.writeStrongBinder(asVar != null ? asVar.asBinder() : null);
            this.f16763a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo4523a(int i, int i2, HiSubscribeTrigger hiSubscribeTrigger) throws RemoteException {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            if (hiSubscribeTrigger != null) {
                obtain.writeInt(1);
                hiSubscribeTrigger.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f16763a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4520a(List list, ay ayVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeList(list);
            obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
            this.f16763a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4506a(HiAggregateOption hiAggregateOption, C4514r c4514r) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            if (hiAggregateOption != null) {
                obtain.writeInt(1);
                hiAggregateOption.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(c4514r != null ? c4514r.asBinder() : null);
            this.f16763a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4521a(List list, C4576u c4576u) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeList(list);
            obtain.writeStrongBinder(c4576u != null ? c4576u.asBinder() : null);
            this.f16763a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4509a(HiDataInsertOption hiDataInsertOption, ag agVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            if (hiDataInsertOption != null) {
                obtain.writeInt(1);
                hiDataInsertOption.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(agVar != null ? agVar.asBinder() : null);
            this.f16763a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4508a(HiDataDeleteOption hiDataDeleteOption, ag agVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            if (hiDataDeleteOption != null) {
                obtain.writeInt(1);
                hiDataDeleteOption.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(agVar != null ? agVar.asBinder() : null);
            this.f16763a.transact(11, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4510a(HiDataReadOption hiDataReadOption, aj ajVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            if (hiDataReadOption != null) {
                obtain.writeInt(1);
                hiDataReadOption.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(ajVar != null ? ajVar.asBinder() : null);
            this.f16763a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4511a(HiDataUpdateOption hiDataUpdateOption, ag agVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            if (hiDataUpdateOption != null) {
                obtain.writeInt(1);
                hiDataUpdateOption.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(agVar != null ? agVar.asBinder() : null);
            this.f16763a.transact(13, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int mo4495a(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeString(str);
            this.f16763a.transact(14, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int mo4525b(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeString(str);
            this.f16763a.transact(15, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4513a(HiDeviceInfo hiDeviceInfo, List list, ap apVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            if (hiDeviceInfo != null) {
                obtain.writeInt(1);
                hiDeviceInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeList(list);
            obtain.writeStrongBinder(apVar != null ? apVar.asBinder() : null);
            this.f16763a.transact(16, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4512a(HiDeviceInfo hiDeviceInfo, HiUserInfo hiUserInfo, List list, ap apVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            if (hiDeviceInfo != null) {
                obtain.writeInt(1);
                hiDeviceInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (hiUserInfo != null) {
                obtain.writeInt(1);
                hiUserInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeList(list);
            obtain.writeStrongBinder(apVar != null ? apVar.asBinder() : null);
            this.f16763a.transact(17, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4517a(ad adVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
            this.f16763a.transact(18, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4528b(ad adVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
            this.f16763a.transact(19, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4532c(ad adVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
            this.f16763a.transact(20, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4501a(int i, ad adVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeInt(i);
            obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
            this.f16763a.transact(21, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4503a(int i, String str, ad adVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeInt(i);
            obtain.writeString(str);
            obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
            this.f16763a.transact(22, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public HiHealthUnit mo4496a(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            HiHealthUnit hiHealthUnit;
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeInt(i);
            this.f16763a.transact(23, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                hiHealthUnit = (HiHealthUnit) HiHealthUnit.CREATOR.createFromParcel(obtain2);
            } else {
                hiHealthUnit = null;
            }
            obtain2.recycle();
            obtain.recycle();
            return hiHealthUnit;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4499a(int i, HiHealthUnit hiHealthUnit) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeInt(i);
            if (hiHealthUnit != null) {
                obtain.writeInt(1);
                hiHealthUnit.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f16763a.transact(24, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4500a(int i, HiTimeInterval hiTimeInterval, ad adVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeInt(i);
            if (hiTimeInterval != null) {
                obtain.writeInt(1);
                hiTimeInterval.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
            this.f16763a.transact(25, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4515a(HiUserInfo hiUserInfo, aa aaVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            if (hiUserInfo != null) {
                obtain.writeInt(1);
                hiUserInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(aaVar != null ? aaVar.asBinder() : null);
            this.f16763a.transact(26, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4516a(aa aaVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeStrongBinder(aaVar != null ? aaVar.asBinder() : null);
            this.f16763a.transact(27, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4514a(HiSyncOption hiSyncOption, aa aaVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            if (hiSyncOption != null) {
                obtain.writeInt(1);
                hiSyncOption.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(aaVar != null ? aaVar.asBinder() : null);
            this.f16763a.transact(28, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4518a(List list, aa aaVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeList(list);
            obtain.writeStrongBinder(aaVar != null ? aaVar.asBinder() : null);
            this.f16763a.transact(29, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4526b() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            this.f16763a.transact(30, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4505a(HiAccountInfo hiAccountInfo, aa aaVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            if (hiAccountInfo != null) {
                obtain.writeInt(1);
                hiAccountInfo.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(aaVar != null ? aaVar.asBinder() : null);
            this.f16763a.transact(31, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4527b(aa aaVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeStrongBinder(aaVar != null ? aaVar.asBinder() : null);
            this.f16763a.transact(32, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4531c(aa aaVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeStrongBinder(aaVar != null ? aaVar.asBinder() : null);
            this.f16763a.transact(33, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4504a(int i, List list, aa aaVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeInt(i);
            obtain.writeList(list);
            obtain.writeStrongBinder(aaVar != null ? aaVar.asBinder() : null);
            this.f16763a.transact(34, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void mo4498a(int i, int i2, aa aaVar) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeStrongBinder(aaVar != null ? aaVar.asBinder() : null);
            this.f16763a.transact(35, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo4524a(HiUserPreference hiUserPreference, boolean z) throws RemoteException {
        boolean z2 = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            if (hiUserPreference != null) {
                obtain.writeInt(1);
                hiUserPreference.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(z ? 1 : 0);
            this.f16763a.transact(36, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z2 = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z2;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public HiUserPreference mo4530c(String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            HiUserPreference hiUserPreference;
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeString(str);
            this.f16763a.transact(37, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                hiUserPreference = (HiUserPreference) HiUserPreference.CREATOR.createFromParcel(obtain2);
            } else {
                hiUserPreference = null;
            }
            obtain2.recycle();
            obtain.recycle();
            return hiUserPreference;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean mo4533d(String str) throws RemoteException {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            obtain.writeString(str);
            this.f16763a.transact(38, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int mo4529c() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.hihealth.IHiHealth");
            this.f16763a.transact(39, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
