package com.google.android.gms.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class MessengerCompat implements ReflectedParcelable {
    public static final Creator<MessengerCompat> CREATOR = new C0488a();
    Messenger zzbhO;
    C0489b zzbhP;

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.zzbhO = new Messenger(iBinder);
        } else {
            this.zzbhP = C0490c.m848a(iBinder);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = getBinder().equals(((MessengerCompat) obj).getBinder());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public IBinder getBinder() {
        return this.zzbhO != null ? this.zzbhO.getBinder() : this.zzbhP.asBinder();
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public void send(Message message) throws RemoteException {
        if (this.zzbhO != null) {
            this.zzbhO.send(message);
        } else {
            this.zzbhP.mo1794a(message);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.zzbhO != null) {
            parcel.writeStrongBinder(this.zzbhO.getBinder());
        } else {
            parcel.writeStrongBinder(this.zzbhP.asBinder());
        }
    }
}
