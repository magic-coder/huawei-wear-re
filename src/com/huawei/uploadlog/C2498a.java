package com.huawei.uploadlog;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: ExternalConnectionDatabase */
public interface C2498a extends IInterface {
    LogUpload mo2663a(String str) throws RemoteException;

    List<LogUpload> mo2664a() throws RemoteException;

    boolean mo2665a(LogUpload logUpload) throws RemoteException;

    LogUpload mo2666b(String str) throws RemoteException;

    String mo2667b(LogUpload logUpload) throws RemoteException;

    void mo2668c(LogUpload logUpload) throws RemoteException;

    void mo2669d(LogUpload logUpload) throws RemoteException;

    void mo2670e(LogUpload logUpload) throws RemoteException;
}
