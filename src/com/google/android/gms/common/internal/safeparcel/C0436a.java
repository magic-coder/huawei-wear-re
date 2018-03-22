package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class C0436a {
    public static int m694a(int i) {
        return SupportMenu.USER_MASK & i;
    }

    public static int m695a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int m696a(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != SupportMenu.CATEGORY_MASK ? (i >> 16) & SupportMenu.USER_MASK : parcel.readInt();
    }

    public static <T extends Parcelable> T m697a(Parcel parcel, int i, Creator<T> creator) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m698a(Parcel parcel, int i, int i2) {
        int a = C0436a.m696a(parcel, i);
        if (a != i2) {
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new C0437b(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i2).append(" got ").append(a).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    private static void m699a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String valueOf = String.valueOf(Integer.toHexString(i2));
            throw new C0437b(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected size ").append(i3).append(" got ").append(i2).append(" (0x").append(valueOf).append(")").toString(), parcel);
        }
    }

    public static int m700b(Parcel parcel) {
        int a = C0436a.m695a(parcel);
        int a2 = C0436a.m696a(parcel, a);
        int dataPosition = parcel.dataPosition();
        if (C0436a.m694a(a) != 20293) {
            String str = "Expected object header. Got 0x";
            String valueOf = String.valueOf(Integer.toHexString(a));
            throw new C0437b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), parcel);
        }
        a = dataPosition + a2;
        if (a >= dataPosition && a <= parcel.dataSize()) {
            return a;
        }
        throw new C0437b("Size read is invalid start=" + dataPosition + " end=" + a, parcel);
    }

    public static void m701b(Parcel parcel, int i) {
        parcel.setDataPosition(C0436a.m696a(parcel, i) + parcel.dataPosition());
    }

    public static <T> T[] m702b(Parcel parcel, int i, Creator<T> creator) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static <T> ArrayList<T> m703c(Parcel parcel, int i, Creator<T> creator) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m704c(Parcel parcel, int i) {
        C0436a.m698a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static byte m705d(Parcel parcel, int i) {
        C0436a.m698a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static int m706e(Parcel parcel, int i) {
        C0436a.m698a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer m707f(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0436a.m699a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long m708g(Parcel parcel, int i) {
        C0436a.m698a(parcel, i, 8);
        return parcel.readLong();
    }

    public static BigInteger m709h(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static float m710i(Parcel parcel, int i) {
        C0436a.m698a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static double m711j(Parcel parcel, int i) {
        C0436a.m698a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static BigDecimal m712k(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(a + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static String m713l(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static IBinder m714m(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m715n(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static byte[] m716o(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    public static boolean[] m717p(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(a + dataPosition);
        return createBooleanArray;
    }

    public static int[] m718q(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    public static long[] m719r(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(a + dataPosition);
        return createLongArray;
    }

    public static BigInteger[] m720s(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigIntegerArr;
    }

    public static float[] m721t(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(a + dataPosition);
        return createFloatArray;
    }

    public static double[] m722u(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(a + dataPosition);
        return createDoubleArray;
    }

    public static BigDecimal[] m723v(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigDecimalArr;
    }

    public static String[] m724w(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }

    public static ArrayList<String> m725x(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }

    public static Parcel m726y(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a);
        parcel.setDataPosition(a + dataPosition);
        return obtain;
    }

    public static Parcel[] m727z(Parcel parcel, int i) {
        int a = C0436a.m696a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a);
        return parcelArr;
    }
}
