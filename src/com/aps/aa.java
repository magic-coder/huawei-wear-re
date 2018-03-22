package com.aps;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.json.JSONObject;

public final class aa {
    private Context f12835a = null;
    private boolean f12836b = true;
    private int f12837c = 1270;
    private int f12838d = 310;
    private int f12839e = 4;
    private int f12840f = 200;
    private int f12841g = 1;
    private int f12842h = 0;
    private int f12843i = 0;
    private long f12844j = 0;
    private C3516z f12845k = null;

    private aa(Context context) {
        this.f12835a = context;
    }

    private static int m17164a(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 4) {
            i3 += (bArr[i2 + i] & 255) << (i2 << 3);
            i2++;
        }
        return i3;
    }

    protected static aa m17165a(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        aa aaVar = new aa(context);
        aaVar.f12842h = 0;
        aaVar.f12843i = 0;
        aaVar.f12844j = ((System.currentTimeMillis() + 28800000) / 86400000) * 86400000;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(m17168b(context) + File.separator + "data_carrier_status"));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[32];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                if (toByteArray != null && toByteArray.length >= 22) {
                    aaVar.f12836b = toByteArray[0] != (byte) 0;
                    aaVar.f12837c = (toByteArray[1] * 10) << 10;
                    aaVar.f12838d = (toByteArray[2] * 10) << 10;
                    aaVar.f12839e = toByteArray[3];
                    aaVar.f12840f = toByteArray[4] * 10;
                    aaVar.f12841g = toByteArray[5];
                    long b = m17167b(toByteArray, 14);
                    if (aaVar.f12844j - b < 86400000) {
                        aaVar.f12844j = b;
                        aaVar.f12842h = m17164a(toByteArray, 6);
                        aaVar.f12843i = m17164a(toByteArray, 10);
                    }
                }
                byteArrayOutputStream.close();
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return aaVar;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileInputStream2 = fileInputStream;
                th = th3;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return aaVar;
        } catch (Throwable th4) {
            th = th4;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
        return aaVar;
    }

    private static byte[] m17166a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) ((j >> (i << 3)) & 255));
        }
        return bArr;
    }

    private static long m17167b(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 8) {
            i3 += (bArr[i2 + 14] & 255) << (i2 << 3);
            i2++;
        }
        return (long) i3;
    }

    private static String m17168b(Context context) {
        boolean z = false;
        File file = null;
        if (Process.myUid() != 1000) {
            file = C3502l.m17537a(context);
        }
        try {
            z = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
        }
        return ((z || !C3502l.m17546c()) && file != null) ? file.getPath() : context.getFilesDir().getPath();
    }

    private static byte[] m17169c(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >> (i2 << 3));
        }
        return bArr;
    }

    private void m17170g() {
        long currentTimeMillis = System.currentTimeMillis() + 28800000;
        if (currentTimeMillis - this.f12844j > 86400000) {
            this.f12844j = (currentTimeMillis / 86400000) * 86400000;
            this.f12842h = 0;
            this.f12843i = 0;
        }
    }

    protected final void m17171a(int i) {
        m17170g();
        if (i < 0) {
            i = 0;
        }
        this.f12842h = i;
    }

    protected final void m17172a(C3516z c3516z) {
        this.f12845k = c3516z;
    }

    protected final boolean m17173a() {
        m17170g();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12835a.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? this.f12836b : activeNetworkInfo.getType() == 1 ? this.f12836b && this.f12842h < this.f12837c : this.f12836b && this.f12843i < this.f12838d;
    }

    protected final boolean m17174a(String str) {
        boolean z;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Throwable th;
        int i = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("e")) {
                this.f12836b = jSONObject.getInt("e") != 0;
            }
            if (jSONObject.has("d")) {
                int i2 = jSONObject.getInt("d");
                this.f12837c = ((i2 & 127) * 10) << 10;
                this.f12838d = (((i2 & 3968) >> 7) * 10) << 10;
                this.f12839e = (520192 & i2) >> 12;
                this.f12840f = ((66584576 & i2) >> 19) * 10;
                this.f12841g = (i2 & 2080374784) >> 26;
                if (this.f12841g == 31) {
                    this.f12841g = 1500;
                }
                if (this.f12845k != null) {
                    this.f12845k.m17632a();
                }
            }
            z = jSONObject.has("u") ? jSONObject.getInt("u") != 0 : false;
        } catch (Exception e) {
            z = false;
        }
        try {
            m17170g();
            fileOutputStream = new FileOutputStream(new File(m17168b(this.f12835a) + File.separator + "data_carrier_status"));
            try {
                byte[] c = m17169c(this.f12842h);
                byte[] c2 = m17169c(this.f12843i);
                byte[] a = m17166a(this.f12844j);
                byte[] bArr = new byte[22];
                if (!this.f12836b) {
                    i = 0;
                }
                bArr[0] = (byte) i;
                bArr[1] = (byte) (this.f12837c / 10240);
                bArr[2] = (byte) (this.f12838d / 10240);
                bArr[3] = (byte) this.f12839e;
                bArr[4] = (byte) (this.f12840f / 10);
                bArr[5] = (byte) this.f12841g;
                bArr[6] = c[0];
                bArr[7] = c[1];
                bArr[8] = c[2];
                bArr[9] = c[3];
                bArr[10] = c2[0];
                bArr[11] = c2[1];
                bArr[12] = c2[2];
                bArr[13] = c2[3];
                bArr[14] = a[0];
                bArr[15] = a[1];
                bArr[16] = a[2];
                bArr[17] = a[3];
                bArr[18] = a[4];
                bArr[19] = a[5];
                bArr[20] = a[6];
                bArr[21] = a[7];
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            fileOutputStream2 = null;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        return z;
    }

    protected final int m17175b() {
        return this.f12839e;
    }

    protected final void m17176b(int i) {
        m17170g();
        if (i < 0) {
            i = 0;
        }
        this.f12843i = i;
    }

    protected final int m17177c() {
        return this.f12840f;
    }

    protected final int m17178d() {
        return this.f12841g;
    }

    protected final int m17179e() {
        m17170g();
        return this.f12842h;
    }

    protected final int m17180f() {
        m17170g();
        return this.f12843i;
    }
}
