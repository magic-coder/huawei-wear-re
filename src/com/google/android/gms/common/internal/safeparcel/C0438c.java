package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenu;
import java.util.List;

public class C0438c {
    public static int m728a(Parcel parcel) {
        return C0438c.m747b(parcel, 20293);
    }

    public static void m729a(Parcel parcel, int i) {
        C0438c.m750c(parcel, i);
    }

    public static void m730a(Parcel parcel, int i, byte b) {
        C0438c.m748b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void m731a(Parcel parcel, int i, double d) {
        C0438c.m748b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void m732a(Parcel parcel, int i, float f) {
        C0438c.m748b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m733a(Parcel parcel, int i, int i2) {
        C0438c.m748b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m734a(Parcel parcel, int i, long j) {
        C0438c.m748b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m735a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int b = C0438c.m747b(parcel, i);
            parcel.writeBundle(bundle);
            C0438c.m750c(parcel, b);
        } else if (z) {
            C0438c.m748b(parcel, i, 0);
        }
    }

    public static void m736a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int b = C0438c.m747b(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C0438c.m750c(parcel, b);
        } else if (z) {
            C0438c.m748b(parcel, i, 0);
        }
    }

    public static void m737a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int b = C0438c.m747b(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            C0438c.m750c(parcel, b);
        } else if (z) {
            C0438c.m748b(parcel, i, 0);
        }
    }

    public static void m738a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int b = C0438c.m747b(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C0438c.m750c(parcel, b);
        } else if (z) {
            C0438c.m748b(parcel, i, 0);
        }
    }

    public static void m739a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C0438c.m748b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C0438c.m748b(parcel, i, 0);
        }
    }

    public static void m740a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int b = C0438c.m747b(parcel, i);
            parcel.writeString(str);
            C0438c.m750c(parcel, b);
        } else if (z) {
            C0438c.m748b(parcel, i, 0);
        }
    }

    public static void m741a(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int b = C0438c.m747b(parcel, i);
            parcel.writeStringList(list);
            C0438c.m750c(parcel, b);
        } else if (z) {
            C0438c.m748b(parcel, i, 0);
        }
    }

    public static void m742a(Parcel parcel, int i, boolean z) {
        C0438c.m748b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m743a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int b = C0438c.m747b(parcel, i);
            parcel.writeByteArray(bArr);
            C0438c.m750c(parcel, b);
        } else if (z) {
            C0438c.m748b(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void m744a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int b = C0438c.m747b(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0438c.m746a(parcel, parcelable, i2);
                }
            }
            C0438c.m750c(parcel, b);
        } else if (z) {
            C0438c.m748b(parcel, i, 0);
        }
    }

    public static void m745a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int b = C0438c.m747b(parcel, i);
            parcel.writeStringArray(strArr);
            C0438c.m750c(parcel, b);
        } else if (z) {
            C0438c.m748b(parcel, i, 0);
        }
    }

    private static <T extends Parcelable> void m746a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int m747b(Parcel parcel, int i) {
        parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m748b(Parcel parcel, int i, int i2) {
        if (i2 >= SupportMenu.USER_MASK) {
            parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static <T extends Parcelable> void m749b(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int b = C0438c.m747b(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0438c.m746a(parcel, parcelable, 0);
                }
            }
            C0438c.m750c(parcel, b);
        } else if (z) {
            C0438c.m748b(parcel, i, 0);
        }
    }

    private static void m750c(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }
}
