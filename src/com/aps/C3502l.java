package com.aps;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class C3502l {
    private Context f13189a;
    private int f13190b = 0;
    private int f13191c = 0;
    private int f13192d = 0;

    protected C3502l(Context context) {
        this.f13189a = context;
        m17552a(768);
    }

    private static int m17535a(int i, int i2) {
        return i < i2 ? i : i2;
    }

    protected static C3495e m17536a(Location location, C3505o c3505o, int i, byte b, long j, boolean z) {
        C3495e c3495e = new C3495e();
        if (i <= 0 || i > 3 || c3505o == null) {
            return null;
        }
        int i2;
        int i3;
        Object obj = (i == 1 || i == 3) ? 1 : null;
        Object obj2 = (i == 2 || i == 3) ? 1 : null;
        Object bytes = c3505o.m17620p().getBytes();
        System.arraycopy(bytes, 0, c3495e.f13156c, 0, C3502l.m17535a(bytes.length, c3495e.f13156c.length));
        bytes = c3505o.m17608f().getBytes();
        System.arraycopy(bytes, 0, c3495e.f13160g, 0, C3502l.m17535a(bytes.length, c3495e.f13160g.length));
        bytes = c3505o.m17609g().getBytes();
        System.arraycopy(bytes, 0, c3495e.f13154a, 0, C3502l.m17535a(bytes.length, c3495e.f13154a.length));
        bytes = c3505o.m17612h().getBytes();
        System.arraycopy(bytes, 0, c3495e.f13155b, 0, C3502l.m17535a(bytes.length, c3495e.f13155b.length));
        c3495e.f13157d = (short) c3505o.m17621q();
        c3495e.f13158e = (short) c3505o.m17622r();
        c3495e.f13159f = (byte) c3505o.m17623s();
        bytes = c3505o.m17624t().getBytes();
        System.arraycopy(bytes, 0, c3495e.f13161h, 0, C3502l.m17535a(bytes.length, c3495e.f13161h.length));
        long j2 = j / 1000;
        bytes = (location == null || !c3505o.m17606e()) ? null : 1;
        by byVar;
        if (bytes != null) {
            byVar = new by();
            byVar.f13084b = (int) j2;
            C3494d c3494d = new C3494d();
            c3494d.f13143a = (int) (location.getLongitude() * 1000000.0d);
            c3494d.f13144b = (int) (location.getLatitude() * 1000000.0d);
            c3494d.f13145c = (int) location.getAltitude();
            c3494d.f13146d = (int) location.getAccuracy();
            c3494d.f13147e = (int) location.getSpeed();
            c3494d.f13148f = (short) ((int) location.getBearing());
            if (Build.MODEL.equals("sdk") || (C3505o.m17583b(c3505o.m17629y()) && bz.f13102b)) {
                c3494d.f13149g = (byte) 1;
            } else {
                c3494d.f13149g = (byte) 0;
            }
            c3494d.f13150h = b;
            c3494d.f13151i = System.currentTimeMillis();
            c3494d.f13152j = c3505o.m17619o();
            byVar.f13085c = c3494d;
            i2 = 1;
            c3495e.f13163j.add(byVar);
        } else if (!z) {
            return null;
        } else {
            byVar = new by();
            byVar.f13084b = (int) j2;
            C3497g c3497g = new C3497g();
            c3497g.f13166a = c3505o.m17628x();
            for (i2 = 0; i2 < c3497g.f13166a; i2++) {
                C3498h c3498h = new C3498h();
                c3498h.f13169a = (byte) c3505o.m17595a(i2).length();
                System.arraycopy(c3505o.m17595a(i2).getBytes(), 0, c3498h.f13170b, 0, c3498h.f13169a);
                c3498h.f13171c = c3505o.m17598b(i2);
                c3498h.f13172d = c3505o.m17601c(i2);
                c3498h.f13173e = c3505o.m17603d(i2);
                c3498h.f13174f = c3505o.m17605e(i2);
                c3498h.f13175g = c3505o.m17607f(i2);
                c3498h.f13176h = (byte) c3505o.m17610g(i2).length();
                System.arraycopy(c3505o.m17610g(i2).getBytes(), 0, c3498h.f13177i, 0, c3498h.f13176h);
                c3498h.f13178j = c3505o.m17611h(i2);
                c3497g.f13167b.add(c3498h);
            }
            byVar.f13089g = c3497g;
            i2 = 1;
            c3495e.f13163j.add(byVar);
        }
        if (!(!c3505o.m17602c() || c3505o.m17613i() || obj == null || z)) {
            by byVar2 = new by();
            byVar2.f13084b = (int) j2;
            bw bwVar = new bw();
            List a = c3505o.m17596a(location.getSpeed());
            if (a != null && a.size() >= 3) {
                bwVar.f13072a = (short) ((Integer) a.get(0)).intValue();
                bwVar.f13073b = ((Integer) a.get(1)).intValue();
            }
            bwVar.f13074c = c3505o.m17616l();
            List m = c3505o.m17617m();
            bwVar.f13075d = (byte) m.size();
            for (i3 = 0; i3 < m.size(); i3++) {
                C3504n c3504n = new C3504n();
                c3504n.f13200a = (short) ((NeighboringCellInfo) m.get(i3)).getLac();
                c3504n.f13201b = ((NeighboringCellInfo) m.get(i3)).getCid();
                c3504n.f13202c = (byte) ((NeighboringCellInfo) m.get(i3)).getRssi();
                bwVar.f13076e.add(c3504n);
            }
            byVar2.f13086d = bwVar;
            i2 = 2;
            c3495e.f13163j.add(byVar2);
        }
        i3 = i2;
        if (c3505o.m17602c() && c3505o.m17613i() && obj != null && !z) {
            by byVar3 = new by();
            byVar3.f13084b = (int) j2;
            C3503m c3503m = new C3503m();
            List b2 = c3505o.m17599b(location.getSpeed());
            if (b2 != null && b2.size() >= 6) {
                c3503m.f13193a = ((Integer) b2.get(3)).intValue();
                c3503m.f13194b = ((Integer) b2.get(4)).intValue();
                c3503m.f13195c = (short) ((Integer) b2.get(0)).intValue();
                c3503m.f13196d = (short) ((Integer) b2.get(1)).intValue();
                c3503m.f13197e = ((Integer) b2.get(2)).intValue();
                c3503m.f13198f = c3505o.m17616l();
            }
            byVar3.f13087e = c3503m;
            i3++;
            c3495e.f13163j.add(byVar3);
        }
        if (!(!c3505o.m17604d() || obj2 == null || z)) {
            byVar2 = new by();
            C3499i c3499i = new C3499i();
            List u = c3505o.m17625u();
            byVar2.f13084b = (int) (((Long) u.get(0)).longValue() / 1000);
            c3499i.f13179a = (byte) (u.size() - 1);
            for (int i4 = 1; i4 < u.size(); i4++) {
                List list = (List) u.get(i4);
                if (list != null && list.size() >= 3) {
                    C3500j c3500j = new C3500j();
                    bytes = ((String) list.get(0)).getBytes();
                    System.arraycopy(bytes, 0, c3500j.f13182a, 0, C3502l.m17535a(bytes.length, c3500j.f13182a.length));
                    c3500j.f13183b = (short) ((Integer) list.get(1)).intValue();
                    bytes = ((String) list.get(2)).getBytes();
                    System.arraycopy(bytes, 0, c3500j.f13184c, 0, C3502l.m17535a(bytes.length, c3500j.f13184c.length));
                    c3499i.f13180b.add(c3500j);
                }
            }
            byVar2.f13088f = c3499i;
            i3++;
            c3495e.f13163j.add(byVar2);
        }
        c3495e.f13162i = (short) i3;
        return (i3 >= 2 || z) ? c3495e : null;
    }

    protected static File m17537a(Context context) {
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/files/"));
    }

    public static Object m17538a(Object obj, String str, Object... objArr) {
        Class cls = obj.getClass();
        Class[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(obj, objArr);
    }

    private static ArrayList m17539a(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < fileArr.length) {
            if (fileArr[i].isFile() && fileArr[i].getName().length() == 10 && TextUtils.isDigitsOnly(fileArr[i].getName())) {
                arrayList.add(fileArr[i]);
            }
            i++;
        }
        return arrayList;
    }

    protected static byte[] m17540a(BitSet bitSet) {
        byte[] bArr = new byte[(bitSet.size() / 8)];
        for (int i = 0; i < bitSet.size(); i++) {
            int i2 = i / 8;
            bArr[i2] = (byte) (((bitSet.get(i) ? 1 : 0) << (7 - (i % 8))) | bArr[i2]);
        }
        return bArr;
    }

    protected static byte[] m17541a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e) {
            return bArr2;
        }
    }

    protected static byte[] m17542a(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int indexOf = new String(bArr).indexOf(0);
        if (indexOf <= 0) {
            i = 1;
        } else if (indexOf + 1 <= i) {
            i = indexOf + 1;
        }
        Object obj = new byte[i];
        System.arraycopy(bArr, 0, obj, 0, i);
        obj[i - 1] = null;
        return obj;
    }

    public static int m17543b(Object obj, String str, Object... objArr) {
        Class cls = obj.getClass();
        Class[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, objArr)).intValue();
    }

    protected static BitSet m17544b(byte[] bArr) {
        BitSet bitSet = new BitSet(bArr.length << 3);
        int i = 0;
        for (byte b : bArr) {
            int i2 = 7;
            while (i2 >= 0) {
                int i3 = i + 1;
                bitSet.set(i, ((b & (1 << i2)) >> i2) == 1);
                i2--;
                i = i3;
            }
        }
        return bitSet;
    }

    private File m17545c(long j) {
        boolean equals;
        boolean z = false;
        if (Process.myUid() == 1000) {
            return null;
        }
        File file;
        try {
            equals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            equals = z;
        }
        if (!C3502l.m17546c() || r0) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) <= ((long) (this.f13191c / 2))) {
                return null;
            }
            File file2 = new File(C3502l.m17537a(this.f13189a).getPath() + File.separator + "carrierdata");
            if (!(file2.exists() && file2.isDirectory())) {
                file2.mkdirs();
            }
            file = new File(file2.getPath() + File.separator + j);
            try {
                z = file.createNewFile();
            } catch (IOException e2) {
            }
        } else {
            file = null;
        }
        return !z ? null : file;
    }

    protected static boolean m17546c() {
        if (VERSION.SDK_INT >= 9) {
            try {
                return ((Boolean) Environment.class.getMethod("isExternalStorageRemovable", null).invoke(null, null)).booleanValue();
            } catch (Exception e) {
            }
        }
        return true;
    }

    private File m17547d() {
        if (Process.myUid() == 1000) {
            return null;
        }
        File file;
        boolean equals;
        try {
            equals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            equals = false;
        }
        if (!C3502l.m17546c() || r0) {
            File file2 = new File(C3502l.m17537a(this.f13189a).getPath() + File.separator + "carrierdata");
            if (file2.exists() && file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    ArrayList a = C3502l.m17539a(listFiles);
                    if (a.size() == 1) {
                        if (((File) a.get(0)).length() < ((long) this.f13192d)) {
                            file = (File) a.get(0);
                            return file;
                        }
                    } else if (a.size() >= 2) {
                        file = (File) a.get(0);
                        File file3 = (File) a.get(1);
                        if (file.getName().compareTo(file3.getName()) <= 0) {
                            file = file3;
                        }
                        return file;
                    }
                }
            }
        }
        file = null;
        return file;
    }

    private int m17548e() {
        boolean equals;
        if (Process.myUid() == 1000) {
            return 0;
        }
        try {
            equals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            equals = false;
        }
        if (C3502l.m17546c() && !r0) {
            return 0;
        }
        File file = new File(C3502l.m17537a(this.f13189a).getPath() + File.separator + "carrierdata");
        if (!file.exists() || !file.isDirectory()) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return 0;
        }
        ArrayList a = C3502l.m17539a(listFiles);
        return a.size() == 1 ? ((File) a.get(0)).length() <= 0 ? 10 : 1 : a.size() >= 2 ? 2 : 0;
    }

    private File m17549f() {
        boolean equals;
        if (Process.myUid() == 1000) {
            return null;
        }
        File file;
        try {
            equals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            equals = false;
        }
        if (!C3502l.m17546c() || r0) {
            File a = C3502l.m17537a(this.f13189a);
            if (a != null) {
                File file2 = new File(a.getPath() + File.separator + "carrierdata");
                if (file2.exists() && file2.isDirectory()) {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        ArrayList a2 = C3502l.m17539a(listFiles);
                        if (a2.size() >= 2) {
                            a = (File) a2.get(0);
                            file = (File) a2.get(1);
                            if (a.getName().compareTo(file.getName()) <= 0) {
                                file = a;
                            }
                            return file;
                        }
                    }
                }
            }
        }
        file = null;
        return file;
    }

    protected int m17550a() {
        return this.f13190b;
    }

    protected synchronized File m17551a(long j) {
        File d;
        d = m17547d();
        if (d == null) {
            d = m17545c(j);
        }
        return d;
    }

    protected void m17552a(int i) {
        this.f13190b = i;
        this.f13191c = (((this.f13190b << 3) * 1500) + this.f13190b) + 4;
        if (this.f13190b == 256 || this.f13190b == 768) {
            this.f13192d = this.f13191c / 100;
        } else if (this.f13190b == 8736) {
            this.f13192d = this.f13191c - 5000;
        }
    }

    protected File m17553b() {
        return m17549f();
    }

    protected synchronized boolean m17554b(long j) {
        boolean z = false;
        synchronized (this) {
            int e = m17548e();
            if (e != 0) {
                if (e == 1) {
                    if (m17545c(j) != null) {
                        z = true;
                    }
                } else if (e == 2) {
                    z = true;
                }
            }
        }
        return z;
    }
}
