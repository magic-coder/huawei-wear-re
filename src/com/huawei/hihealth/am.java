package com.huawei.hihealth;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: IHiHealth */
public interface am extends IInterface {
    int mo4495a(String str) throws RemoteException;

    HiHealthUnit mo4496a(int i) throws RemoteException;

    void mo4497a() throws RemoteException;

    void mo4498a(int i, int i2, aa aaVar) throws RemoteException;

    void mo4499a(int i, HiHealthUnit hiHealthUnit) throws RemoteException;

    void mo4500a(int i, HiTimeInterval hiTimeInterval, ad adVar) throws RemoteException;

    void mo4501a(int i, ad adVar) throws RemoteException;

    void mo4502a(int i, av avVar) throws RemoteException;

    void mo4503a(int i, String str, ad adVar) throws RemoteException;

    void mo4504a(int i, List list, aa aaVar) throws RemoteException;

    void mo4505a(HiAccountInfo hiAccountInfo, aa aaVar) throws RemoteException;

    void mo4506a(HiAggregateOption hiAggregateOption, C4514r c4514r) throws RemoteException;

    void mo4507a(HiAppInfo hiAppInfo) throws RemoteException;

    void mo4508a(HiDataDeleteOption hiDataDeleteOption, ag agVar) throws RemoteException;

    void mo4509a(HiDataInsertOption hiDataInsertOption, ag agVar) throws RemoteException;

    void mo4510a(HiDataReadOption hiDataReadOption, aj ajVar) throws RemoteException;

    void mo4511a(HiDataUpdateOption hiDataUpdateOption, ag agVar) throws RemoteException;

    void mo4512a(HiDeviceInfo hiDeviceInfo, HiUserInfo hiUserInfo, List list, ap apVar) throws RemoteException;

    void mo4513a(HiDeviceInfo hiDeviceInfo, List list, ap apVar) throws RemoteException;

    void mo4514a(HiSyncOption hiSyncOption, aa aaVar) throws RemoteException;

    void mo4515a(HiUserInfo hiUserInfo, aa aaVar) throws RemoteException;

    void mo4516a(aa aaVar) throws RemoteException;

    void mo4517a(ad adVar) throws RemoteException;

    void mo4518a(List list, aa aaVar) throws RemoteException;

    void mo4519a(List list, as asVar) throws RemoteException;

    void mo4520a(List list, ay ayVar) throws RemoteException;

    void mo4521a(List list, C4576u c4576u) throws RemoteException;

    void mo4522a(List list, List list2, C4579x c4579x) throws RemoteException;

    boolean mo4523a(int i, int i2, HiSubscribeTrigger hiSubscribeTrigger) throws RemoteException;

    boolean mo4524a(HiUserPreference hiUserPreference, boolean z) throws RemoteException;

    int mo4525b(String str) throws RemoteException;

    void mo4526b() throws RemoteException;

    void mo4527b(aa aaVar) throws RemoteException;

    void mo4528b(ad adVar) throws RemoteException;

    int mo4529c() throws RemoteException;

    HiUserPreference mo4530c(String str) throws RemoteException;

    void mo4531c(aa aaVar) throws RemoteException;

    void mo4532c(ad adVar) throws RemoteException;

    boolean mo4533d(String str) throws RemoteException;
}
