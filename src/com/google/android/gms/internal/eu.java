package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.C0467l;

public abstract class eu {
    public final int f773a;

    public eu(int i) {
        this.f773a = i;
    }

    private static Status m1453b(RemoteException remoteException) {
        StringBuilder stringBuilder = new StringBuilder();
        if (C0467l.m826b() && (remoteException instanceof TransactionTooLargeException)) {
            stringBuilder.append("TransactionTooLargeException: ");
        }
        stringBuilder.append(remoteException.getLocalizedMessage());
        return new Status(8, stringBuilder.toString());
    }

    public abstract void mo1876a(@NonNull Status status);

    public abstract void mo1877a(@NonNull ab abVar, boolean z);

    public abstract void mo1878a(bb<?> bbVar) throws DeadObjectException;
}
