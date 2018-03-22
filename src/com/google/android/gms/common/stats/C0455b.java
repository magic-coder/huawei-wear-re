package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0436a;
import com.google.android.gms.common.internal.safeparcel.C0437b;
import com.google.android.gms.common.internal.safeparcel.C0438c;
import java.util.List;

public class C0455b implements Creator<WakeLockEvent> {
    static void m799a(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int a = C0438c.m728a(parcel);
        C0438c.m733a(parcel, 1, wakeLockEvent.zzaiI);
        C0438c.m734a(parcel, 2, wakeLockEvent.getTimeMillis());
        C0438c.m740a(parcel, 4, wakeLockEvent.zzyM(), false);
        C0438c.m733a(parcel, 5, wakeLockEvent.zzyP());
        C0438c.m741a(parcel, 6, wakeLockEvent.zzyQ(), false);
        C0438c.m734a(parcel, 8, wakeLockEvent.zzyS());
        C0438c.m740a(parcel, 10, wakeLockEvent.zzyN(), false);
        C0438c.m733a(parcel, 11, wakeLockEvent.getEventType());
        C0438c.m740a(parcel, 12, wakeLockEvent.zzyR(), false);
        C0438c.m740a(parcel, 13, wakeLockEvent.zzyU(), false);
        C0438c.m733a(parcel, 14, wakeLockEvent.zzyT());
        C0438c.m732a(parcel, 15, wakeLockEvent.zzyV());
        C0438c.m734a(parcel, 16, wakeLockEvent.zzyW());
        C0438c.m740a(parcel, 17, wakeLockEvent.zzyO(), false);
        C0438c.m729a(parcel, a);
    }

    public WakeLockEvent m800a(Parcel parcel) {
        int b = C0436a.m700b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a = C0436a.m695a(parcel);
            switch (C0436a.m694a(a)) {
                case 1:
                    i = C0436a.m706e(parcel, a);
                    break;
                case 2:
                    j = C0436a.m708g(parcel, a);
                    break;
                case 4:
                    str = C0436a.m713l(parcel, a);
                    break;
                case 5:
                    i3 = C0436a.m706e(parcel, a);
                    break;
                case 6:
                    list = C0436a.m725x(parcel, a);
                    break;
                case 8:
                    j2 = C0436a.m708g(parcel, a);
                    break;
                case 10:
                    str3 = C0436a.m713l(parcel, a);
                    break;
                case 11:
                    i2 = C0436a.m706e(parcel, a);
                    break;
                case 12:
                    str2 = C0436a.m713l(parcel, a);
                    break;
                case 13:
                    str4 = C0436a.m713l(parcel, a);
                    break;
                case 14:
                    i4 = C0436a.m706e(parcel, a);
                    break;
                case 15:
                    f = C0436a.m710i(parcel, a);
                    break;
                case 16:
                    j3 = C0436a.m708g(parcel, a);
                    break;
                case 17:
                    str5 = C0436a.m713l(parcel, a);
                    break;
                default:
                    C0436a.m701b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5);
        }
        throw new C0437b("Overread allowed size end=" + b, parcel);
    }

    public WakeLockEvent[] m801a(int i) {
        return new WakeLockEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m800a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m801a(i);
    }
}
