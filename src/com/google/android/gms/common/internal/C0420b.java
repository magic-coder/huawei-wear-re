package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C0391p;

public class C0420b extends ap {
    int f425a;

    public static Account m638a(ao aoVar) {
        Account account = null;
        if (aoVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = aoVar.mo1767a();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public Account mo1767a() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.f425a) {
            if (C0391p.m449a(null, callingUid)) {
                this.f425a = callingUid;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        Account account = null;
        return this == obj ? true : !(obj instanceof C0420b) ? false : account.equals(account);
    }
}
