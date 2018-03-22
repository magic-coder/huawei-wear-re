package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@KeepName
public final class DataHolder extends zza implements Closeable {
    public static final Creator<DataHolder> CREATOR = new C0403k();
    private static final C0395d zzaDW = new C0396c(new String[0], null);
    boolean mClosed;
    private final String[] zzaDP;
    Bundle zzaDQ;
    private final CursorWindow[] zzaDR;
    private final Bundle zzaDS;
    int[] zzaDT;
    int zzaDU;
    private boolean zzaDV;
    final int zzaiI;
    private final int zzavD;

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.zzaDV = true;
        this.zzaiI = i;
        this.zzaDP = strArr;
        this.zzaDR = cursorWindowArr;
        this.zzavD = i2;
        this.zzaDS = bundle;
    }

    private DataHolder(C0395d c0395d, int i, Bundle bundle) {
        this(c0395d.f319a, zza(c0395d, -1), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.zzaDV = true;
        this.zzaiI = 1;
        this.zzaDP = (String[]) C0424f.m649a((Object) strArr);
        this.zzaDR = (CursorWindow[]) C0424f.m649a((Object) cursorWindowArr);
        this.zzavD = i;
        this.zzaDS = bundle;
        zzxk();
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(zzaDW, i, bundle);
    }

    private static CursorWindow[] zza(C0395d c0395d, int i) {
        int i2 = 0;
        if (c0395d.f319a.length == 0) {
            return new CursorWindow[0];
        }
        List b = (i < 0 || i >= c0395d.f320b.size()) ? c0395d.f320b : c0395d.f320b.subList(0, i);
        int size = b.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(c0395d.f319a.length);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            try {
                int i5;
                int i6;
                CursorWindow cursorWindow2;
                if (!cursorWindow.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i3);
                    cursorWindow.setNumColumns(c0395d.f319a.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) b.get(i3);
                boolean z = true;
                for (int i7 = 0; i7 < c0395d.f319a.length && z; i7++) {
                    String str = c0395d.f319a[i7];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i3, i7);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i3, i7);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i3, i7);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i3, i7);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i7);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i3, i7);
                    } else if (obj instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i7);
                    } else if (obj instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i3, i7);
                    } else {
                        String valueOf = String.valueOf(obj);
                        throw new IllegalArgumentException(new StringBuilder((String.valueOf(str).length() + 32) + String.valueOf(valueOf).length()).append("Unsupported object for column ").append(str).append(": ").append(valueOf).toString());
                    }
                }
                if (z) {
                    i5 = i3;
                    i6 = 0;
                    cursorWindow2 = cursorWindow;
                } else if (i4 != 0) {
                    throw new C0397e("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(c0395d.f319a.length);
                    arrayList.add(cursorWindow3);
                    i5 = i3 - 1;
                    cursorWindow2 = cursorWindow3;
                    i6 = 1;
                }
                i4 = i6;
                cursorWindow = cursorWindow2;
                i3 = i5 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                int size2 = arrayList.size();
                while (i2 < size2) {
                    ((CursorWindow) arrayList.get(i2)).close();
                    i2++;
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static C0395d zzc(String[] strArr) {
        return new C0395d(strArr, null);
    }

    public static DataHolder zzcJ(int i) {
        return zza(i, null);
    }

    private void zzi(String str, int i) {
        if (this.zzaDQ == null || !this.zzaDQ.containsKey(str)) {
            String str2 = "No such column: ";
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.zzaDU) {
            throw new CursorIndexOutOfBoundsException(i, this.zzaDU);
        }
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.zzaDR) {
                    close.close();
                }
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            if (this.zzaDV && this.zzaDR.length > 0 && !isClosed()) {
                close();
                String valueOf = String.valueOf(toString());
                Log.e("DataBuffer", new StringBuilder(String.valueOf(valueOf).length() + 178).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ").append(valueOf).append(")").toString());
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public int getCount() {
        return this.zzaDU;
    }

    public int getStatusCode() {
        return this.zzavD;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0403k.m476a(this, parcel, i);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzi(str, i);
        this.zzaDR[i2].copyStringToBuffer(i, this.zzaDQ.getInt(str), charArrayBuffer);
    }

    public long zzb(String str, int i, int i2) {
        zzi(str, i);
        return this.zzaDR[i2].getLong(i, this.zzaDQ.getInt(str));
    }

    public int zzc(String str, int i, int i2) {
        zzi(str, i);
        return this.zzaDR[i2].getInt(i, this.zzaDQ.getInt(str));
    }

    public int zzcI(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.zzaDU;
        C0424f.m654a(z);
        while (i2 < this.zzaDT.length) {
            if (i < this.zzaDT[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.zzaDT.length ? i2 - 1 : i2;
    }

    public String zzd(String str, int i, int i2) {
        zzi(str, i);
        return this.zzaDR[i2].getString(i, this.zzaDQ.getInt(str));
    }

    public boolean zzdf(String str) {
        return this.zzaDQ.containsKey(str);
    }

    public boolean zze(String str, int i, int i2) {
        zzi(str, i);
        return Long.valueOf(this.zzaDR[i2].getLong(i, this.zzaDQ.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        zzi(str, i);
        return this.zzaDR[i2].getFloat(i, this.zzaDQ.getInt(str));
    }

    public byte[] zzg(String str, int i, int i2) {
        zzi(str, i);
        return this.zzaDR[i2].getBlob(i, this.zzaDQ.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String zzd = zzd(str, i, i2);
        return zzd == null ? null : Uri.parse(zzd);
    }

    public boolean zzi(String str, int i, int i2) {
        zzi(str, i);
        return this.zzaDR[i2].isNull(i, this.zzaDQ.getInt(str));
    }

    public Bundle zzxf() {
        return this.zzaDS;
    }

    public void zzxk() {
        int i;
        int i2 = 0;
        this.zzaDQ = new Bundle();
        for (i = 0; i < this.zzaDP.length; i++) {
            this.zzaDQ.putInt(this.zzaDP[i], i);
        }
        this.zzaDT = new int[this.zzaDR.length];
        i = 0;
        while (i2 < this.zzaDR.length) {
            this.zzaDT[i2] = i;
            i += this.zzaDR[i2].getNumRows() - (i - this.zzaDR[i2].getStartPosition());
            i2++;
        }
        this.zzaDU = i;
    }

    String[] zzxl() {
        return this.zzaDP;
    }

    CursorWindow[] zzxm() {
        return this.zzaDR;
    }
}
